/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.threadsockets;

/**
 * This is the worker client that will handle all of the networking aspect from 
 * the list being read in. It will create a socket and send the data to the 
 * server. It will then retrieve the output from the server and print out the 
 * output.
 * @author Daniel
 */
import java.io.*;
import java.net.*;

public class WorkerClient implements Runnable {
    //declare string ip
    String ip;
    //Create method workerclient with arguemnt address type String
    public WorkerClient (String address){
        //declare ip equal to address
        ip = address;
    }
    
    public void run() {
        try {
            //create a new socket
            Socket client = new Socket("127.0.0.1", 6052);
            //send data to server
            OutputStream out = client.getOutputStream();
            //write the data
            PrintWriter p = new PrintWriter(out, true);
            p.println(ip);
            //get response from server
            InputStream in = client.getInputStream();
            //add response to buffered reader from server
            BufferedReader b = new BufferedReader(new InputStreamReader(in));
            //print out response
            String line;
            while ((line = b.readLine()) != null) {
                System.out.println(line);
            }
            //close socket
            client.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }   
    }
}
