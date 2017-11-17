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
 * @author acer
 */
public class MultithreadedClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Socket cs = new Socket("localhost",9999);
      BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
       OutputStreamWriter os = new OutputStreamWriter(cs.getOutputStream());
        
        new ReceiveDataFromServer(cs).start();
        new SendDataToServer(cs).start();
        
        // TODO code application logic here
    }
    
}
