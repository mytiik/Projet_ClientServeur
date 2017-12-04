//Argument 1 : le port du serveur

package Exercice9;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AirePerimetreServeur {

	public static void main(String[] args) {

		int portServ = 0;
		ServerSocket sockConn = null;
		Socket sockComm = null;
		ObjectInputStream sockIn = null;
		DataOutputStream sockOs = null;
		
		//On vérifie le nombre d'arguments
		if (args.length != 1) {
			System.out.println("Nombre d'arguments incorrect !");
			System.exit(1);
		}
		
		//On transforme le numéro de port en entier si c'est possible sinon on lève une erreur
		try { 
			portServ = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException e) {
				System.out.println("Numéro de port non valide !");
				System.exit(1);
		}
		
		//On vérifie le numéro de port
		if ( portServ < 1024 || portServ > 65535 ){
			System.out.println("Numéro de port non autorisé ou non valide !");
			System.exit(1);
		}
		
		try {
			//On crée la socket d'écoute du serveur
			sockConn = new ServerSocket(portServ);
			
			//Boucle permettant la connection de plusieurs clients successifs
			while (true) {
				
				//On crée la socket de communication avec la socket du client. On crée ensuite les flux qui serviront à lire et écrire.
				sockComm = sockConn.accept();
				
				sockIn = new ObjectInputStream(sockComm.getInputStream());
				sockOs = new DataOutputStream(sockComm.getOutputStream());
				FormeGeometrique forme = null;
				
				//Ici, tant qu'il y a un objet à lire dans le flux d'entrée, on le lit, on calcule et on envoie son aire et son périmètre au client
				while ((forme = (FormeGeometrique)sockIn.readObject()) != null) {
					if (forme != null) {
						Double aire = forme.aire();
						Double perimetre = forme.perimetre();
					
						sockOs.writeDouble(aire);
						sockOs.writeDouble(perimetre);
					}
				}
				
				sockComm.close();
				sockComm = null;
			}
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (sockComm != null){
					sockComm.close();
				}
				
				if (sockOs != null){
					sockOs.close();
				}
				
				if (sockIn != null){
					sockIn.close();
				}
			}
			catch(IOException e) {
				System.out.println("Erreur IO");
			}
		}
	}
}
