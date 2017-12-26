
package homework3.client.startup;

import homework3.client.view.FileOperationManager;
import homework3.client.view.UserOperationManager;
import homework3.common.FileCatalogInterface;

import java.rmi.*;

public class StartClient {
 public static String URL;

    public static void main(String[] args) throws Exception {
        URL="rmi://"+"localhost"+":9999/rmi";
        FileCatalogInterface userOperation= (FileCatalogInterface)Naming.lookup(URL);
        String wow = userOperation.print();
        System.out.println(wow);
        
        
        while(true){
        UserOperationManager.registerlogin();
        if(UserOperationManager.flag==1){
            break;
        }       
        }
        while(true){
        FileOperationManager.Operation();
        }
    }
    
}
