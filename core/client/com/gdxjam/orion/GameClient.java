package com.gdxjam.orion;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;
import com.gdxjam.orion.net.Network;

public class GameClient {

	Client client;

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

	}

	protected synchronized void handleRecieved(Connection connection,
			Object message) {

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

}
