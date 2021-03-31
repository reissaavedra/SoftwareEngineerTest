package com.example.restservice;

import java.util.LinkedHashMap;

public class ES001 {
    String parameter;
    Alphabet alphabet;

    public ES001(String parameter, Alphabet alphabet) {
        this.parameter = parameter;
        this.alphabet = alphabet;
    }

    public String solve(){
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, String> list_alphabet = alphabet.getAlphabet();

        for(int i=0, len=parameter.length(); i<len; i++) {
            char c = parameter.charAt(i);
            String a = list_alphabet.get(String.valueOf(Character.toLowerCase(c)));
            if(a == null){
                sb.append(c);
            }else{
                if(!Character.isUpperCase(c)){
                    sb.append(a);
                }else{
                    sb.append(a.toUpperCase());
                }
            }
        }
        return sb.toString();
    }
}
