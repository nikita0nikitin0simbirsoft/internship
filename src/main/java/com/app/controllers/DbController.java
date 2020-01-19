package com.app.controllers;

import com.app.database.DataBase;
import com.app.model.ListWord;
import com.app.model.Word;
import org.apache.log4j.Logger;

public class DbController { //controllers for interacting with the database

    private static final Logger log = Logger.getLogger(DataBase.class);
    DataBase dataBase;

    public DbController() {
        dataBase = new DataBase();
        try {
            dataBase.connect();
        } catch (Exception e) {
            System.out.println("Error connection");
            log.error(e);
        }
    }

    public void saveListWordInDb (ListWord listWord){
        if (listWord == null || listWord.isEmpty()){
            System.out.println("List empty");
        }else {
            try {
                for (Word word : listWord){
                    dataBase.inset(word);
                }
                System.out.println("Append");
            }catch (Exception e){
            log.error(e);
            System.out.println("Error selected db");
            }

        }
    }
}
