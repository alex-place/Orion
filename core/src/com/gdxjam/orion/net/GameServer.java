package com.gdxjam.orion.net;

import java.io.IOException;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage.KeepAlive;
import com.esotericsoftware.kryonet.FrameworkMessage.Ping;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;
import com.gdxjam.orion.ClientPlayer;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.Player;
import com.gdxjam.orion.net.Network.ReplyAddPlayer;
import com.gdxjam.orion.net.Network.ReplyUpdate;
import com.gdxjam.orion.net.Network.RequestAddPlayer;
import com.gdxjam.orion.net.Network.RequestUpdate;

public class GameServer {
	private Server server;
	private ReplyUpdate update;
	private Array<ClientPlayer> clientPlayers = new Array<ClientPlayer>();

	public GameServer() throws IOException {
		// Log.set(Log.LEVEL_DEBUG);
		Log.set(Log.LEVEL_NONE);

		server = new Server() {

			@Override
			protected Connection newConnection() {
				return new ClientConnection();
			}

		};

		// For consistency, the classes to be sent over the network are
		// registered by the same method for both the client and server.
		Network.register(server);

		server.addListener(new Listener() {

			@Override
			public void connected(Connection connection) {
				super.connected(connection);
			}

			public void received(Connection c, Object message) {

				if (message instanceof RequestAddPlayer) {
					Player player = new Player(
							((RequestAddPlayer) message).position, c.getID());
					GameManager.getPlayers().put(c.getID(), player);

					ReplyAddPlayer reply = new ReplyAddPlayer();
					reply.id = c.getID();
					server.sendToTCP(c.getID(), reply);
				}

				else if (message instanceof RequestUpdate) {
					RequestUpdate request = (RequestUpdate) message;
					handleInput(c, request);
				}

				else if ((message instanceof Ping)
						|| (message instanceof KeepAlive)) {

				}

				else {
					System.out.println("Server recieved unhandled message "
							+ message);

				}

			}

			public void disconnected(Connection c) {

			}
		});

		server.bind(1881, 1882);
		server.start();
	}

	protected void handleInput(Connection c, RequestUpdate request) {
		switch (request.key) {
		case Keys.W:
			Player player = GameManager.getPlayers().get(c.getID());
			player.up();
			break;
		case Keys.ESCAPE:
			c.close();
			break;
		}
	}

	protected void logInfo(String string) {
		Log.info(string);
	}

	public void shutdown() {
		server.close();
		server.stop();
		System.out.println("Shutting down");

	}

	public void sendMessage(Object message) {
		server.sendToAllTCP(message);

	}

	public void update() {
		update = new ReplyUpdate();
		clientPlayers = new Array<ClientPlayer>();
		for (Player p : GameManager.getPlayers().values()) {
			clientPlayers.add(convertToClient(p));
		}

		update.players = clientPlayers;
		server.sendToAllTCP(update);
	}

	public class ClientConnection extends Connection {

		public ClientConnection() {
		}

	}

	public static void main(String[] args) throws IOException {
		Log.set(Log.LEVEL_DEBUG);
		new GameServer();
	}

	public ClientPlayer convertToClient(Player player) {
		return new ClientPlayer().init(player.getBody().getPosition(),
				player.getId());
	}
}
