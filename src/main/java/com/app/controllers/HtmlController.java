package com.app.controllers;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlController { //controllers for downloading a web page, saving its file and the method returning this page

    private String htmlDoc;

    private static final Logger log = Logger.getLogger(HtmlController.class);

    public void downloadHtml(URL url) throws IOException {
            htmlDoc="";
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
            while (true) {
                if(Runtime.getRuntime().maxMemory()>Runtime.getRuntime().totalMemory()+500000){ //memory overflow control
                    String line = reader.readLine();
                    if (line == null)
                        break;
                    htmlDoc+=line+"\n";
                }
            }
            log.info("Website" + url.toString() +" downloaded");

    }

    public String getHtmlDoc(){
        return htmlDoc;
    }

    public void saveInFile(){
        if (htmlDoc==null || htmlDoc.equals("")){
            System.out.println("Doc empty");
        }else {
            try(FileWriter writer = new FileWriter("index.html", false))
            {
                writer.write(htmlDoc);
                writer.flush();
                System.out.println("Website save");
                log.info("Website save");
            }
            catch(IOException e){
                log.error(e);
            }
        }

    }
}
