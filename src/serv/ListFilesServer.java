package serv;

import comServCli.P2PFile;
import java.io.File;
import java.util.ArrayList;

public class ListFilesServer {
    
    private ArrayList<comServCli.P2PFile> listeServeur;
    
    public ListFilesServer (){
        this.listeServeur = new ArrayList<comServCli.P2PFile>();
    }
    
    public void listerFichiersServeur() {
        listeServeur.toString();
    }
    
    public void AjoutListe (ArrayList<comServCli.P2PFile> listeClient, String ipClient){
        for ( int i = 0; i < listeClient.size(); i++ ) {
            
            // on créer un fichier et on extrait sa taille
            int size = (int) ( new File(listeClient[i]) ).getTotalSpace();
            
            // on créer un fichier P2P
            P2PFile file = new P2PFile( listeClient[i], size );
            
            //verifie que le fichier n'est pas déjà dans la liste du serveur
            boolean f_ex = false,ip_ex = false;
            for ( P2PFile f : listeServeur ){
                if ( f.equals(file) ){
                    // le fichier existe dans la liste du serveur
                    f_ex = true;
                    //verifie que ipClient est dans la liste du fichier
                    for ( String s : f.getListeIpClient() ){
                        if ( s.equals(ipClient) ){
                            // ip déjà présent dans la liste
                            ip_ex = true;
                        }
                    }
                    if ( !ip_ex ){
                        // ip pas présent dans la liste (donc ajout)
                        f.getListeIpClient().add( ipClient );
                    }
                }
            }
            if ( !f_ex ){
                // ajout de l'ip du client dans la liste du fichier
                file.getListeIpClient().add( ipClient );
                //ajout du fichier à la liste des fichiers du serveur
                listeServeur.add( file );
            }
            
            

        }
    }
    
    
    /*
    
    tout les clients doivent avoir une adresse de serveur tcp propre
    (serveur socket) et doit l'envoyer au serveur
    
    
    si le client se déconnecte alors il faut que tout les fichiers 
    qui listent son adr doivent l'enlever de leur liste
    
    a chaque fois qu'un client se connecte on doit mettre à jour 
    la liste de fichiers et leurs adresses dynamiquement
    
    
    */
}
