package cli;

import java.net.*; 
import java.io.*;
public class P2PClientMain {
    
 

  public static void main(String[] args) throws Exception {

        String ipServ;
        int portServ = 0;


        Socket sockComm = null;

        InputStream ins = null;
        OutputStream outs = null;

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        BufferedReader brCLAV = new BufferedReader(new InputStreamReader(System.in));
        int nbForme = 0;

        if (args.length != 2) {
            System.out.println("Nombre d'arguments incorrect !");
            System.exit(1);
        }
        ipServ = args[0];
        try {
            //susceptible de lever NumberFormatException
            portServ = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Numéro de port non valide !");
            System.exit(1);
        }
    }
}
/*
    
    
    
    
    
    
    
    
*/