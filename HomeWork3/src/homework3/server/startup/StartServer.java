
package homework3.server.startup;
import homework3.server.model.RmiRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StartServer {


    public static void main(String[] args)  {
        try {
            RmiRegistry.interinitial();
        } catch (Exception ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        }     
    }
    
