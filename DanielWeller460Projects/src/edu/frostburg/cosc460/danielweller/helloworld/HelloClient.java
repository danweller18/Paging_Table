/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.helloworld;
/**
 * This is a program that will use sockets to say hello world from a 
 * client to a sever.
 * @author Daniel Weller
 */
//import java.net + io
import java.net.*;
import java.io.*;

public class HelloClient {

	public static void main (String[] args) throws IOException {

		try {
			Socket client = new Socket("127.0.0.1", 6000);
			InputStream in = client.getInputStream();
			BufferedReader b = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = b.readLine()) != null) {
				System.out.println(line);
				client.close();
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
