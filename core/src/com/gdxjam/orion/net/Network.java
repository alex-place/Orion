package com.gdxjam.orion.net;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {

	private static String ip = "127.0.0.1";
	private static boolean isServer = false;

	// This registers objects that are going to be sent over the network.
	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();

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

}