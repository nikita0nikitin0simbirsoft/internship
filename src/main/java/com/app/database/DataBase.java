package com.app.database;

import com.app.model.ListWord;
import com.app.model.Word;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase { //database with methods for connecting, creating and sending requests

    private static final Logger log = Logger.getLogger(DataBase.class);
    private boolean isConnected = false;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connect() throws ClassNotFoundException, SQLException, NamingException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:","sa","");
        statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement( "CREATE TABLE Words (" +
                "  `id` int(11) AUTO_INCREMENT," +
                "  `count` varchar(50) NOT NULL," +
                "  `word` varchar(50) NOT NULL," +
                "  PRIMARY KEY (`id`)" +
                ")");
        statement.execute();
        isConnected = true;
        log.info("DataBase connection "+isConnected);

    }
    public void inset(Word m) throws ClassNotFoundException, SQLException {
        try {
            if(!this.isConnected){
                this.connect();
            }
            statement = connection.createStatement();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Words (count,word) VALUES ('" + m.getX() + "','" + m.getWord()+ "');");
            statement.execute();
        } catch (Exception e) {
            log.error(e);
        }
    }
    public List<Word> getAll() throws ClassNotFoundException, SQLException, NamingException
    {
        List<Word> listRecord = new ArrayList<Word>();
        if (isConnected){
            statement = connection.createStatement();
            ResultSet executeQuery = statement.executeQuery("select * from Words");

            while (executeQuery.next()) {
                Word word = new Word(Integer.valueOf(executeQuery.getString("count")),executeQuery.getString("word"));
                listRecord.add(word);
            }
            executeQuery.close();
        }
        return listRecord;
    }

    public DataBase() {
        try {
            connect();
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
                    inset(word);
                }
                System.out.println("Append");
            }catch (Exception e){
                log.error(e);
                System.out.println("Error selected db");
            }

        }
    }
}
