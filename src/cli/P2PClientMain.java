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

        if (args.length != 3) {
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
         if ( portServ < 1024 || portServ > 65535 ){
            System.out.println("Numéro de port non autorisé ou non valide !");
            System.exit(1);
        }

        try {
            System.out.println("création socket");
            //Creates a stream socket and connects it to the specified port number
            //at the specified IP address.
            sockComm = new Socket();
            sockComm.connect(new InetSocketAddress(ipServ, portServ));
            System.out.println("connection");


            outs = sockComm.getOutputStream();
            ins = sockComm.getInputStream();

            oos = new ObjectOutputStream(new BufferedOutputStream(outs));
            oos.flush();
            ois = new ObjectInputStream(new BufferedInputStream(ins));
            String rep = new String(args[2]);
            ListFilesClient lfc = new ListFilesClient(rep);
            System.out.println("Liste des fichiers du repertoire");
            
    }
         catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
    }
}
/*
    
    
    
    
    
    
    
    
*/