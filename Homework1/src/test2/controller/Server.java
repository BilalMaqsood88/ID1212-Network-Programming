/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.net.*;
import java.io.*;

/**
 *
 * @author Tania Ijaz
 */
public class Server {
    
        /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception
    {
        int cno = 1;
    try{
                
        ServerSocket ss = new ServerSocket(9999);
        
        //System.out.println("Server waiting for client");
        while (true) {
            System.out.println("Server waiting for client");
	        Socket s = ss.accept();
	        Thread task = new ClientHandler(s, cno++);
		task.start();
	    }
	} catch(IOException e) {
	    System.err.println(e);
	}      
               
    }

}
