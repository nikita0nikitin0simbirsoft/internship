package com.app;

import com.app.database.DataBase;
import com.app.writer.ConsoleWriter;
import com.app.controllers.HtmlController;
import com.app.logic.Parser;
import org.apache.log4j.Logger;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ConsoleUserInterface { //program entry and user interface

    private static final Logger log = Logger.getLogger(ConsoleWriter.class);

    public static void main (String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ConsoleWriter writer = new ConsoleWriter();
        HtmlController htmlController = new HtmlController();
        Parser parser = new Parser();
        DataBase db = new DataBase();

        while (true){
            try {
                long freeMemory = Runtime.getRuntime().freeMemory();
                writer.writeln("1. Download website\n2. Save file\n3. Parse doc to identical word and write in console\n4. Save Database\n5. Exit");
                switch (scanner.nextInt()) {
                case 1:
                    try {
                        writer.write("Input URL:");
                        URL url = new URL(scanner.next());
                        htmlController.downloadHtml(url);
                        writer.writeln("Website download");
                    } catch (Exception e) {
                        log.error(e);
                        writer.writeln("Error");
                    }
                    break;
                case 2:
                    try {
                        htmlController.saveInFile();
                    } catch (Exception e) {
                        log.error(e);
                        writer.writeln("Error save");
                    }
                    break;
                case 3:
                    try {
                        parser.parse(htmlController.getHtmlDoc());
                        writer.write(parser.getListWord());
                    } catch (Exception e) {
                        log.error(e);
                    }
                    break;
                case 4:
                    db.saveListWordInDb(parser.getListWord());
                    break;
                case 5:
                    return;
                default:
                    break;
            }
            }catch (Exception e){
                writer.writeln("incorrect input");
                scanner.next();
            }
        }
    }
}
