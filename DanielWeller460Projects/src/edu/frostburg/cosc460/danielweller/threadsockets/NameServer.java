/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.threadsockets;

/**
 * This class will open a server side socket and start a thread pool. New 
 * threads will be created to handle any incoming traffic the server receives.
 * @author Daniel
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class NameServer implements Runnable {
    
    public void run() {
        
        try {
            //starts new server socket at the port
            ServerSocket server = new ServerSocket(6052);
            //initialize a thread pool
            ExecutorService pool = Executors.newFixedThreadPool(2);
            // loop
            for (int i=0; i<999999999; i++) {
                //accept socket client
                Socket client = server.accept();
                //create new instance of worker
                Runnable worker = new WorkerServer(client);
                //give worker to thread pool
                pool.execute(worker);
		//client.close();
                System.out.println("Active thread count = " + ((ThreadPoolExecutor)pool).getActiveCount());
            }
            //close server socket
            server.close();
            //shutdown the cachedthread pool
            pool.shutdown();
            System.exit(1);
        } catch (UnknownHostException uhe) {
            System.out.println(uhe);
        } catch (SocketException se) {
            System.out.println(se);
	} catch (IOException ioe) {
            System.out.println(ioe);
	}
    }
}
