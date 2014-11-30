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
//import edu.frostburg.cosc460.danielweller.helloworld.*;

public class HelloServer {

	public static void main (String[] args) throws IOException {

		try {
			ServerSocket server = new ServerSocket(6000);
			//while loop
			while (true) {
				Socket client = server.accept();
				PrintWriter p = new PrintWriter(client.getOutputStream(), true);
				p.println("Hello World");
				client.close();
				server.close();
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
