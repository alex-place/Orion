package com.gdxjam.orion.net;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.gdxjam.orion.GameManager.ShipType;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.entities.player.Player;

public class Network {

	private static String ip = "127.0.0.1";
	private static boolean isServer = false;

	// This registers objects that are going to be sent over the network.
	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(Array.class);
		kryo.register(Player.class);
		kryo.register(Vector3.class);
		kryo.register(Vector2.class);
		kryo.register(RequestAddPlayer.class);
		kryo.register(ReplyAddPlayer.class);
		kryo.register(RequestUpdateKey.class);
		kryo.register(RequestUpdateMouse.class);
		kryo.register(ReplyUpdate.class);
		kryo.register(Object[].class);
		kryo.register(ClientPlayer.class);
		kryo.register(ShipType.class);
		kryo.register(ReplyAddSattelite.class);
		kryo.register(UpdateSattelite.class);
		kryo.register(HashMap.class);
		kryo.register(RequestClick.class);
		kryo.register(ShipType.class);

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
		public Vector3 position;
		public ShipType type;
	}

	public static class ReplyAddPlayer {
		public int id;
	}

	public static class ReplyAddSattelite {
		public Vector2 position;
		public float size;
	}

	public static class UpdateSattelite {
		public Vector2 position;
	}

	public static class RequestUpdateKey {
		public int keyDown;
		public int keyUp;
	}

	public static class RequestUpdateMouse {
		public Vector2 mousePos;
	}

	public static class RequestClick {
		public Vector2 mousePos;
		public boolean left;
		public boolean right;
	}

	public static class ReplyUpdate {
		public HashMap<Integer, ClientPlayer> players;
	}

}