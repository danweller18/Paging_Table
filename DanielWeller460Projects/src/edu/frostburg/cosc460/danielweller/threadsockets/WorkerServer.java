/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.threadsockets;

/**
 * This is the server class that will handle all of the incoming traffic. The 
 * input is read line by line, and the domain name is used to find the 
 * IP address of the domain name. The IP address is then sent back to the client. 
 * @author Daniel
 */
import java.io.*;
import java.net.*;

public class WorkerServer implements Runnable {
    //Declare socket s
    Socket s;
    //new method WorkerServer with argument sock type Socket 
    public WorkerServer (Socket sock){
        //declaring socket s = sock
        s = sock;
    }
    
    public void run() {
        try {
            //read input stream from client
            InputStream in = s.getInputStream();
            //put inputstream into buffered reader
            BufferedReader b = new BufferedReader(new InputStreamReader(in));
            //declare a string called line
            String line;
            
            //while loop to read line by line from buffered reader while not null
            while ((line = b.readLine()) != null) {
                //declare string name equal to line
                String name = line;
                //determines ip address based on inputed host name
                InetAddress hAddr = InetAddress.getByName(name);
                //returns the ip into a string called ip
                String ip = hAddr.getHostAddress();
                //write the output into socket
                PrintWriter p = new PrintWriter(s.getOutputStream(), true);
                //content to write to client
                p.println("The IP address for " + name + " is: " + ip);
                //close s or client = server.accept
                s.close();
            }
        } catch (UnknownHostException uhe) {
            System.out.println(uhe);
        } catch (SocketException se) {
            System.out.println(se);
        } catch (IOException ioe) {
                System.out.println(ioe);
        }
    }
}
