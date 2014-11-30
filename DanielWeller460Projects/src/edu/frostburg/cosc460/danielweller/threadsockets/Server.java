/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.threadsockets;
/**
 * This program is server side of my thread and socket program. The server will
 * run the class nameserver, and exit upon nameserver completing its task.
 * @author Daniel
 */
import java.util.concurrent.*;

public class Server {
    
    public static void main (String[] args) {
        //create an instance of NameServer
        NameServer nameserver = new NameServer();
        //run nameserver
        nameserver.run();
        System.exit(1);
    }
}
