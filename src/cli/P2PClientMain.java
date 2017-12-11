package cli;

import java.net.*; 
import java.io.*;
import java.util.Objects;
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
            System.out.println("Liste des fichiers du repertoire");
            ListFilesClient lfc = new ListFilesClient(rep);
            
            String[] tblDbl;

            while ((tblDbl = lectPourEcrir(brCLAV)) != null) {

                if (tblDbl.length == 1) {

                    Rond rond = new Rond(tblDbl[0]);

                    System.out.println("écriture d'un rond dans le tableau");
                    oos.writeObject(rond);
                    oos.flush();

                    System.out.println("calcul du perimetre et de l'aire du rond");

                } else if (tblDbl.length == 2) {

                    Rectangle rectangle = new Rectangle(tblDbl[0], tblDbl[1]);

                    System.out.println("insertion de l'objet rectengle dans le tableau");
                    oos.writeObject(rectangle);
                    oos.flush();

                    System.out.println("récuperation du perimetre et de l'aire du rectangle");
                }

                double peri = ois.readDouble();
                double aire = ois.readDouble();

                System.out.println("périmetre : " + peri);
                System.out.println("aire : " + aire);

            }
            
            
    }
         catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
    }
   private static String[] lectPourEcrir(BufferedReader brCLAV) throws IOException {
        System.out.println("saisir une requete (Search, get, list ou quit): ");
        String[] req =  brCLAV.readLine().split(",");

        if (req.length == 1 && Objects.equals(req[0], "")){
            return null;
        }


        if (req.length == 2){

            String[] tblDbl = new String[req.length];
            for (int i = 0; i < req.length; i++) {
                
            }
            return tblDbl;

        }else if(req.length == 1){
            String[] rondRayon = new String[req.length];
           
            }
            return req;
        }

    }

/*
    
    
    
    
    
    
    
    
*/