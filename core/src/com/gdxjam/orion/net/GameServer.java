package com.gdxjam.orion.net;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage.KeepAlive;
import com.esotericsoftware.kryonet.FrameworkMessage.Ping;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.AsteroidsControlBehavior;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.controls.ShooterControlBehavior;
import com.gdxjam.orion.controls.TestControlBehavior;
import com.gdxjam.orion.controls.UFOControlBehavior;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.entities.PlayerAttributes;
import com.gdxjam.orion.net.Network.ReplyAddPlayer;
import com.gdxjam.orion.net.Network.ReplyUpdate;
import com.gdxjam.orion.net.Network.RequestAddPlayer;
import com.gdxjam.orion.net.Network.RequestClick;
import com.gdxjam.orion.net.Network.RequestUpdateKey;
import com.gdxjam.orion.net.Network.RequestUpdateMouse;
import com.gdxjam.orion.utils.Constants;
import com.gdxjam.orion.utils.EntityFactory;

public class GameServer {
	private Server server;
	private HashMap<Integer, ClientPlayer> clientPlayers = new HashMap<Integer, ClientPlayer>();

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
					RequestAddPlayer request = (RequestAddPlayer) message;
					ControlBehavior behavior; // = new CruiserControlBehavior();
					/*
					 * if (request.type == ShipType.FIGHTER) { behavior = new
					 * FighterControlBehavior(); } if (request.type ==
					 * ShipType.CRUISER) { behavior = new
					 * CruiserControlBehavior(); } if (request.type ==
					 * ShipType.CORVETTE) { behavior = new
					 * CorvetteControlBehavior(); } else { behavior = new
					 * DefaultControlBehavior(); }
					 */
					behavior = new AsteroidsControlBehavior();

					PlayerAttributes a = new PlayerAttributes(c.getID());

					Player player = new Player(a, EntityFactory.createShip(request.position.x, request.position.y, request.position.z, behavior));

					// Player player = new Player(((RequestAddPlayer)
					// message).position, c.getID(), behavior);
					behavior.init(player.getShip());
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

				else if (message instanceof RequestClick) {
					RequestClick request = (RequestClick) message;
					handleClick(c, request);
				}

				else if ((message instanceof Ping) || (message instanceof KeepAlive)) {

				}

				else {
					System.out.println("Server recieved unhandled message " + message);

				}

			}

			public void disconnected(Connection c) {
				Player player = GameManager.getPlayers().get(c.getID());
				GameManager.getPlayers().remove(player);
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

	protected void handleClick(Connection c, RequestClick request) {
		Player player = GameManager.getPlayers().get(c.getID());
		player.getBehavior().handleClick(request.mousePos);
	}

	protected void handleInputKey(Connection c, RequestUpdateKey request) {
		switch (request.keyDown) {
		case Keys.ESCAPE:
			c.close();
			break;
		default:
			Player player = GameManager.getPlayers().get(c.getID());
			player.getBehavior().handleKeyDown(request.keyDown);
			player.getBehavior().handleKeyUp(request.keyUp);
			break;

		}
	}

	protected void logInfo(String string) {
		Log.info(string);
	}

	public void dispose() {
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
			clientPlayers.put(p.getID(), convertToClient(p));
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
		return new ClientPlayer().init(new Vector3(player.getPosition().x, player.getPosition().y, player.getAngle()), player.getID());

	}
}
