package com.app.model;

import java.util.ArrayList;

public class ListWord extends ArrayList<Word>{ //list of object Word

    public boolean add(String str) {
        return super.add(new Word(1,str));
    }


    public int indexOf(String s){
        if (!this.isEmpty()){
            for (int i = 0;i<this.size();i++){
                if (super.get(i).getWord().equals(s)){
                    return i;
                }
            }
        }
        return -1;
    }
}
