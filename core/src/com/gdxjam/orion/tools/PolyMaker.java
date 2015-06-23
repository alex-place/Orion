package com.gdxjam.orion.tools;

import java.util.Scanner;

public class PolyMaker {
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter scale: ");
		int scale = input.nextInt();
		float[] poly = new float[scale*scale*2];
		
		System.out.println("points: ");
		for(int i = 0; i < poly.length; i++){
			poly[i] = input.nextFloat();
			if(poly[i] == -1){break;}
		}
		
		for(int i = 0; i < poly.length; i++){
			System.out.print((float)poly[i]/scale+"f, ");
			if(i % 2 == 0){System.out.print(" ");}
			if(poly[i] == -1){break;}
		}
		
		
	}

}
