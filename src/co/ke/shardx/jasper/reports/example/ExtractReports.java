/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ke.shardx.jasper.reports.example;

import com.sun.media.jfxmedia.logging.Logger;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.zip.*;

public class ExtractReports {
 
    private static final String THE_DIRECTORY = "reports";
    private static final String WRITE_DIRECTORY = "/";
     
     
    ExtractReports( String sourceDirectory, String writeDirectory ) {
        // make sure write directory exists
        new File(writeDirectory).mkdirs();
        try {
            extract( sourceDirectory, writeDirectory );
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ExtractReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
   
    private void extract( String sourceDirectory, String writeDirectory ) throws IOException {
        List<File> files=getFiles(sourceDirectory);
        for(File f:files){
            System.out.println(f.getName().toString());
        }
      URL inputUrl = getClass().getResource("/co/ke/shardx/jasper/reports/example/reports");
File dest = new File("/");
// FileUtils.copyURLToFile(inputUrl, dest);
    }
 private List<File> getFiles(String classPath){
     System.out.println(classPath);
		// TODO Auto-generated method stub
		List<File> fetchFiles = new ArrayList<File>();
    	File dataFolder = new File(classPath);
    	for (File dir : dataFolder.listFiles()) {
    		if (dir.isDirectory()) {
        		for (File file : dir.listFiles())
        			if (file.isFile() ){
        				fetchFiles.add(file);
            			}
    		}
    		else {
                    fetchFiles.add(dir);    			
    		}
    	}
    	return fetchFiles;
	
 }
}