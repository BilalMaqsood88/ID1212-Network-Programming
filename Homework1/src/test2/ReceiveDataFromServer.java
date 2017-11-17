/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class ReceiveDataFromServer extends Thread {
    Socket cs;
    
    public ReceiveDataFromServer(Socket cs) {
        this.cs = cs;
    }
    
    @Override
    public void run (){
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        String read;
        while ((read=br.readLine())!=null){
            System.out.println(read);
        }
}       catch (Exception e) {
            
        }
}
}
