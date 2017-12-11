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


private ArrayList<comServCli.P2PFile> listFile;

    public ListFilesClient(String rep) {
        File repertoire = new File(rep);
        File[] list = repertoire.listFiles();
        Arrays.sort(list);
        int count =0;
        for ( File f : list )
        {          
            count++;
            String name = f.getName();
            long lastmod = f.lastModified();
            SimpleDateFormat simple = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            String formatted = simple.format(new Date(lastmod));
            long length = f.length();
            System.out.println(count+" - "+name+ " "+length+"Mo "+formatted);
         }
    }

    
        
    
}
    





/*String [] listefichiers; 

int i; 
listefichiers=repertoire.list(); 
for(i=0;i<listefichiers.length;i++){ 

System.out.println(listefichiers[i].substring(0,listefichiers[i].length()-0));


    }*/