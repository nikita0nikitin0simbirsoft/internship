package com.app.writer;

import com.app.model.ListWord;
import com.app.model.Word;

public class ConsoleWriter { //small class for easy console output

    public void write(ListWord listWord){
        if (listWord.isEmpty()){
        System.out.println("List empty");
        }else {
        for (Word word:listWord){
            System.out.println(word.toString());
        }
        }
    }

    public void write(Object o){
        System.out.print(o);
    }

    public void writeln(Object o){
        System.out.println(o);
    }

}
