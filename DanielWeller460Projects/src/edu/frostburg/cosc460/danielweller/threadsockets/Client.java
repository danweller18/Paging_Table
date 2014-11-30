/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.threadsockets;

/**
 * This program is client side of my thread and socket program. It reads in a 
 * file containing a list of domain names and starts a new thread pool. A new 
 * thread is started for each line of the list of domain names.
 * @author Daniel
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Client implements Runnable {
    
    public static void main (String[] args) {
        //create an instance of client
        Client client = new Client();
        //run client
        client.run();
    }
    
    public void run() {
        try {
            //buffered reader reads in text file of domains
            BufferedReader b = new BufferedReader(new FileReader("../test.txt"));
            //initialize a thread pool
            ExecutorService pool = Executors.newFixedThreadPool(2);
            // loop
            //for (int i=1; i<20; i++) {
            //set string to users input
            String address;
            //loop that reads file input line by line
            while ((address = b.readLine()) != null) {
                //create new instance of worker
                Runnable worker = new WorkerClient(address);
                //give worker to thread pool
                pool.execute(worker);
            }
            //}
            b.close();
            //shutdown the cachedthread pool
            pool.shutdown();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }   
    }
}
