/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author geofc
 *
 */
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

            ins = sockComm.getInputStream();
            outs = sockComm.getOutputStream();

            oos = new ObjectOutputStream(new BufferedOutputStream(outs));
            oos.flush();
            ois = new ObjectInputStream(new BufferedInputStream(ins));

              System.out.println();
                
                System.out.println("Reception de la liste de fichiers");
                
                ArrayList<comServCli.P2PFile> listFile = (ArrayList<comServCli.P2PFile>)ois.readObject();
               for ( int i = 0; i < listFile.size(); i++ ) {
                System.out.println("Fichier " + i +": "+ listFile.get(i).getName()+" "+ listFile.get(i).getSize()+" MO");
               
                }
                

            while (true){
                
                System.out.println("Reception de la reqûete");
                String req = (String)ois.readObject();
                 System.out.println(req);
                
              
                

               

                
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
