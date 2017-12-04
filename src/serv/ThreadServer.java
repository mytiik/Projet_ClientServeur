/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.*;
import java.net.*;

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

            double peri;
            double aire;

            while (true){
                System.out.println();
                System.out.println("Attente de la forme");
                Object o = ois.readObject();
                System.out.println("Récepion de la forme");
                peri = 0.0;
                aire = 0.0;
                Forme forme = (Forme) o;

                System.out.println(o);
                System.out.println("Perimetre : " + forme.perimetre());
                System.out.println("Aire : " + forme.aire());

                peri = forme.perimetre();
                aire = forme.aire();

                System.out.println("Envoi du perimetre");
                oos.writeDouble(peri);

                oos.flush();

                System.out.println("Envoi de l'aire");
                oos.writeDouble(aire);

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
