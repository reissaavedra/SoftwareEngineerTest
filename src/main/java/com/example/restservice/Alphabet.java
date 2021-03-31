package com.example.restservice;


import java.util.*;

public class Alphabet {
    public LinkedHashMap<String, String> alphabetMap = new LinkedHashMap<>();

    public void insert(String c){
        List<String> listKeys = new ArrayList<>(alphabetMap.keySet());
        if(listKeys.size()>0){
            String firstEntry = listKeys.get(0);
            String lastEntry = listKeys.get(listKeys.size()-1);
            alphabetMap.replace(lastEntry, c);
            alphabetMap.put(c, firstEntry);
        }else{
            alphabetMap.put(c, c);
        }
    }

    public void printList(){
        System.out.print("Alfabeto: ");
        System.out.println(alphabetMap);
    }

    public LinkedHashMap<String, String> getAlphabet(){
        return alphabetMap;
    }
}
