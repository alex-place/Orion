package com.gdxjam.orion.net;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.gdxjam.orion.ClientPlayer;
import com.gdxjam.orion.Player;

public class Network {

	private static String ip = "127.0.0.1";
	private static boolean isServer = false;

	// This registers objects that are going to be sent over the network.
	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(Array.class);
		kryo.register(Player.class);
		kryo.register(Vector2.class);
		kryo.register(RequestAddPlayer.class);
		kryo.register(ReplyAddPlayer.class);
		kryo.register(RequestUpdate.class);
		kryo.register(ReplyUpdate.class);
		kryo.register(Object[].class);
		kryo.register(ClientPlayer.class);

	}

	public static String getIP() {
		return ip;
	}

	public static void setIP(String ip) {
		Network.ip = ip;
	}

	public static boolean isServer() {
		return isServer;
	}

	public static void setServer(boolean isServer) {
		Network.isServer = isServer;
	}

	public static class RequestAddPlayer {
		public Vector2 position;
	}

	public static class ReplyAddPlayer {
		public int id;
	}

	public static class RequestUpdate {
		public int key;
	}

	public static class ReplyUpdate {
		public Array<ClientPlayer> players;
	}

}