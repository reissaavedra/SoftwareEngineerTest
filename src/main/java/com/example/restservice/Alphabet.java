package com.example.restservice;


import java.util.*;

public class Alphabet {
    public LinkedHashMap<String, String> LHM = new LinkedHashMap<>();

    public void insert(String c){
        List<String> listKeys = new ArrayList<>(LHM.keySet());
        if(listKeys.size()>0){
            String firstEntry = listKeys.get(0);
            String lastEntry = listKeys.get(listKeys.size()-1);
            LHM.replace(lastEntry, c);
            LHM.put(c, firstEntry);
        }else{
            LHM.put(c, c);
        }
    }

    public void printList(){
        System.out.print("Alfabeto: ");
        System.out.println(LHM);
    }

    public LinkedHashMap<String, String> getAlphabet(){
        return LHM;
    }
}
