package com.gdxjam.orion.net;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;
import com.gdxjam.orion.ClientGameManager;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.net.Network;
import com.gdxjam.orion.net.Network.ReplyAddPlayer;
import com.gdxjam.orion.net.Network.ReplyUpdate;
import com.gdxjam.orion.net.Network.RequestAddPlayer;

public class GameClient {

	private Client client;
	private ClientPlayer player;
	private Vector3 defaultPos;

	public GameClient() throws IOException { // final GameMap game,
		client = new Client();
		new Thread(client).start();

		// For consistency, the classes to be sent over the network are
		// registered by the same method for both the client and server.
		Network.register(client);

		client.addListener(new Listener() {
			public void connected(Connection connection) {

			}

			public void received(Connection connection, Object object) {
				handleRecieved(connection, object);
			}

			public void disconnected(Connection connection) {
				disconnect();
			}
		});

		client.connect(5000, Network.getIP(), 1881, 1882);
		RequestAddPlayer request = new RequestAddPlayer();
		defaultPos = new Vector3(MathUtils.random(-10, 10), MathUtils.random(
				-10, 10), MathUtils.random(-10, 10));
		defaultPos = new Vector3();
		request.position = defaultPos;
		client.sendTCP(request);

	}

	public synchronized void handleRecieved(Connection connection, Object message) {

		if (message instanceof ReplyAddPlayer) {
			ReplyAddPlayer reply = (ReplyAddPlayer) message;
			player = new ClientPlayer().init(defaultPos, reply.id);
			ClientGameManager.setPlayer(player);
			ClientGameManager.getPlayers().add(player);
		}

		if (message instanceof ReplyUpdate) {
			ReplyUpdate update = (ReplyUpdate) message;
			ClientGameManager.setPlayers(update.players);
		}

	}

	public static void main(String[] args) throws IOException {
		Log.set(Log.LEVEL_DEBUG);
		new GameClient();
	}

	public void disconnect() {
		try {
			client.close();
			client.dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendTCP(Object object) {
		client.sendTCP(object);
	}

	public void update() {
		if (!client.isConnected()) {
			Gdx.app.exit();
		}
	}

}
