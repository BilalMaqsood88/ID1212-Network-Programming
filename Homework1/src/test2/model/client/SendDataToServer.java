/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2.model.client;

import java.net.*;
import java.io.*;

/**
 *
 * @author acer
 */
public class SendDataToServer extends Thread {
      Socket cs;
    public SendDataToServer(Socket cs) throws IOException {
        this.cs = cs;
    }
      @Override
    public void run () {
        try{
        //OutputStreamWriter os = new OutputStreamWriter(cs.getOutputStream());
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(cs.getOutputStream())); 
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in)); //
        PrintWriter out = new PrintWriter(os);
            String line;
        while((line=bufr.readLine())!=null)
            {
                line = line.toLowerCase();
                if("quit".equals(line)){
                    System.out.println("Connection Closed");
                    System.exit(0);
                    //break;
                }
                os.write(line);
                os.newLine(); // server send data
                os.flush();
                //String str = bufin.readLine(); // server recieve data
                
                //System.out.println(str);
                //System.out.print("Guess a word: ");
            }
        
     //   out.println(str);
        os.flush();
        }
        catch(IOException e)
        {
        }
}
}

   
