/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author geofc
 */
public class ListFilesClient {


public ArrayList<comServCli.P2PFile> listFile;

    public ListFilesClient(String rep) {
        listFile= new ArrayList<>();
        File repertoire = new File(rep);
        File[] list = repertoire.listFiles();
        Arrays.sort(list);
        int count =0;
        for ( File f : list )
        {          
           
            String name = f.getName();
            
            long length = f.length();
            listFile.add(new comServCli.P2PFile(name,length));
            
            
           
         }
        
        for(comServCli.P2PFile p : listFile){
            count ++;
        System.out.println(count+" - "+p.getName()+" " +p.getSize()+"Mo");
        }
        
    }

    
        
    
}
    





/*String [] listefichiers; 

int i; 
listefichiers=repertoire.list(); 
for(i=0;i<listefichiers.length;i++){ 

System.out.println(listefichiers[i].substring(0,listefichiers[i].length()-0));


    }*/