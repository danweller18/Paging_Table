/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc460.danielweller.pagetable;

/**
 * This program simulates a paging table. Give a virtual address as input and
 * the output will be its page number and offset.
 * @author Dan
 */

import java.util.*;
import java.io.*;

public class PagingTable {
    
    public static void main (String[] args) {
    
        //asking the user to enter the virtual address
        System.out.println("Please enter the virtual address you would like to lookup:");
        
        //reading the input from the user
        Scanner in = new Scanner(System.in);
        
        //error checking to make sure integer or int between -2147483647 & 2147483647
        while (!in.hasNextInt()) {
            System.out.println("Please enter a valid virtual address between -2147483647 & 2147483647!");
            in.nextLine();
        }
        
        //read the buffer line by line
        int vaddress = in.nextInt();
        
        //error checking to make sure input is valid virtual address
        if ((vaddress < -2147483647) || (vaddress > 2147483647)) {
            System.out.println("Please enter a valid virtual address between -2147483647 & 2147483647!");
            PagingTable.main(args);
            
        } else {
            //calculate page number from virtual address
            int pgn = vaddress / 4096;
            //calculate offset from virtual address
            int offset = vaddress % 4096;

            //print out result
            System.out.println("The address " + vaddress + " contains: ");
            System.out.println("page number = " + pgn + " and offset = " + offset);
        }
    } 
}