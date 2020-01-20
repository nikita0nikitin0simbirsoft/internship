package com.app.logic;

import com.app.model.ListWord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser { //a class that includes the logic of the program, a
                      // method for breaking up words and counting their number with entering it in a list of word objects
    ListWord listWord;

    public void parse(String htmlDoc) {
        if (htmlDoc == null){
            listWord=new ListWord();
        }else{
            listWord = new ListWord();
            String content="";
            Document html = Jsoup.parse(htmlDoc);
            content = html.body().getElementsByTag("body").text();
            content = content.replaceAll("[0-9@\\]\\[%#«-»–-—/,+=*'�{}|$~^&.!?\"<>;:()\n\r\t]"," ");
            content = content.toLowerCase();
            String[] arr =  content.split(" ");

            for (String s : arr) {
                if (listWord.isEmpty()) {
                    listWord.add(s);
                } else if (listWord.indexOf(s) != -1) {
                    listWord.get(listWord.indexOf(s)).setX(listWord.get(listWord.indexOf(s)).getX() + 1);
                } else listWord.add(s);
            }
            listWord.remove(listWord.indexOf(""));
        }
    }

    public ListWord getListWord() {
        return listWord;
    }
}
