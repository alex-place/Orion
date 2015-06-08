package com.gdxjam.orion.net;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage.KeepAlive;
import com.esotericsoftware.kryonet.FrameworkMessage.Ping;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.GameManager.ShipType;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.controls.DefaultControlBehavior;
import com.gdxjam.orion.controls.FighterControlBehavior;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.net.Network.ReplyAddPlayer;
import com.gdxjam.orion.net.Network.ReplyUpdate;
import com.gdxjam.orion.net.Network.RequestAddPlayer;
import com.gdxjam.orion.net.Network.RequestUpdateKey;
import com.gdxjam.orion.net.Network.RequestUpdateMouse;
import com.gdxjam.orion.utils.Constants;

public class GameServer {
	private Server server;
	private HashMap<Integer, ClientPlayer> clientPlayers = new HashMap<Integer, ClientPlayer>();

	private Pool<ClientPlayer> clientPool;

	public GameServer() throws IOException {
		clientPool = Pools.get(ClientPlayer.class);

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
					RequestAddPlayer request = (RequestAddPlayer) message;
					ControlBehavior behavior;

					if (request.type == ShipType.FIGHTER) {
						// TODO create fighter behavior
						behavior = new FighterControlBehavior();
					}
					if (request.type == ShipType.CRUISER) {
						// TODO create fighter behavior
						behavior = new FighterControlBehavior();
					}
					if (request.type == ShipType.CORVETTE) {
						// TODO create fighter behavior
						behavior = new FighterControlBehavior();
					}
					else {
						behavior = new DefaultControlBehavior();
					}

					Player player = new Player(((RequestAddPlayer) message).position, c.getID(), behavior);
					behavior.init(player);
					GameManager.getPlayers().put(c.getID(), player);

					ReplyAddPlayer reply = new ReplyAddPlayer();
					reply.id = c.getID();
					server.sendToTCP(c.getID(), reply);
				}

				else if (message instanceof RequestUpdateKey) {
					RequestUpdateKey request = (RequestUpdateKey) message;
					handleInputKey(c, request);
				}

				else if (message instanceof RequestUpdateMouse) {
					RequestUpdateMouse request = (RequestUpdateMouse) message;
					handleInputMouse(c, request);
				}

				else if ((message instanceof Ping) || (message instanceof KeepAlive)) {

				}

				else {
					System.out.println("Server recieved unhandled message " + message);

				}

			}

			public void disconnected(Connection c) {
				Player player = GameManager.getPlayers().get(c.getID());
				GameManager.getWorld().destroyBody(player.getBody());
				player = null;
				c.close();

			}
		});

		server.bind(1881, 1882);
		server.start();
	}

	protected void handleInputMouse(Connection c, RequestUpdateMouse request) {
		Player player = GameManager.getPlayers().get(c.getID());
		player.getBehavior().handleMouse(request.mousePos);
	}

	protected void handleInputKey(Connection c, RequestUpdateKey request) {
		switch (request.key) {
		case Keys.ESCAPE:
			c.close();
			break;
		default:
			Player player = GameManager.getPlayers().get(c.getID());
			player.getBehavior().handleKey(request.key);
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

	private ReplyUpdate update;

	public void update() {
		update = new ReplyUpdate();
		for (Player p : GameManager.getPlayers().values()) {
			clientPlayers.put(p.getId(), convertToClient(p));
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
		return new ClientPlayer().init(new Vector3(player.getBody().getPosition().x - Constants.PLAYER_HALFWIDTH, player.getBody().getPosition().y
				- Constants.PLAYER_HALFHEIGHT, 0), player.getId());

	}
}
