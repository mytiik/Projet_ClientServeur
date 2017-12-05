/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author geofc
 */
public class ListFilesClient {
public void listerRepertoire(File repertoire){ 

String [] listefichiers; 

int i; 
listefichiers=repertoire.list(); 
for(i=0;i<listefichiers.length;i++){ 

System.out.println(listefichiers[i].substring(0,listefichiers[i].length()-0));

    } 
}
    
}
