
package serv;

import java.io.*;
import java.net.*;

public class ThreadServer extends Thread {
    private Socket sockComm = null;
//    private ObjetPartage objShared;

    private InputStream ins = null;
    private OutputStream outs = null;

    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    public ThreadServer(Socket sockComm) {
        this.sockComm = sockComm;
//        this.objShared = o;
    }

    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try{
            System.out.println("Debut de connection. \nIP : " + sockComm.getInetAddress() +  " | Numero de port :" + sockComm.getPort());
            
            oos = new ObjectOutputStream(new BufferedOutputStream(outs));
            oos.flush();
            ois = new ObjectInputStream(new BufferedInputStream(ins));

            while (true){
                
                // récupère ipClient
                String ipClient = (String) ois.readObject();
                
                // récupère la liste de fichiers
                String[] listeClient = (String[]) ois.readObject();
                
                ListeServer.AjoutListe( listeClient, ipClient);
                System.out.println("Liste de fichiers : ");
                l.listerRepertoire();

                System.out.println("Envoi");
                oos.write();
                oos.flush();
            }
        }catch (EOFException | SocketException e){
            System.out.println();
            System.out.println("Fin de connection");
            System.out.println();
        }
        catch (IOException e) {
            System.out.println("Error : " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if (ois != null)
                    ois.close();
                if (oos != null)
                    oos.close();
                if (ins != null)
                    ins.close();
                if (outs != null)
                    outs.close();
                if (sockComm != null)
                    sockComm.close();
            }
            catch(IOException e) {
                e.printStackTrace();
                System.out.println("Erreur IO2");
            }
        }
    }

    // ... autres méthodes
}
}
