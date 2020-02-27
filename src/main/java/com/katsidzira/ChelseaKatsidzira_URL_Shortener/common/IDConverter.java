package com.katsidzira.ChelseaKatsidzira_URL_Shortener.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Main {

    public static void main(String[] args) {
        IDConverter.fillCharToIndexTable();
        IDConverter.fillIndexToCharTable();
        System.out.println(IDConverter.getDictionaryKeyFromUniqueID("ABC"));
    }
}

public class IDConverter {

    private static IDConverter instance;
    private static HashMap<Integer, Character> indexToCharTable = new HashMap<>();
    private static HashMap<Character, Integer> charToIndexTable = new HashMap<>();
    private static List<Integer> conversionList = new ArrayList<>();

    private IDConverter() {
        fillIndexToCharTable();
        fillCharToIndexTable();
    }

    public static IDConverter getInstance() {
        if (instance == null) {
            instance = new IDConverter();
        }
        return instance;
    }

    public static String createUniqueId(int base10Id) {
        String uniqueId = "";
        int remainder;
        int quotient;

        while (base10Id > 0) {
            remainder = base10Id % 62;
            quotient = base10Id / 62;
            conversionList.add(remainder);
            base10Id = quotient;
        }

        for (int i = conversionList.size() - 1; i >= 0; i--) {
            int index = conversionList.get(i);
            uniqueId += indexToCharTable.get(index);
        }

        return uniqueId;
    }

    public static int getDictionaryKeyFromUniqueID(String uniqueUrlId) {
        int len = uniqueUrlId.length() - 1;
        int base10Key = 0;
        while (len >= 0) {
            for (char ch : uniqueUrlId.toCharArray()) {
                int letter = charToIndexTable.get(ch);
                base10Key += letter * (Math.pow(62, len));
                len--;
            }
        }
        return base10Key;
    }

    public static void fillIndexToCharTable() {
        int key = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            indexToCharTable.put(key, ch);
            key++;
        }
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            indexToCharTable.put(key, ch);
            key++;
        }
        for (char ch = '0'; ch <= '9'; ++ch) {
            indexToCharTable.put(key, ch);
            key++;
        }
    }

    public static void fillCharToIndexTable() {
        int key = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            charToIndexTable.put(ch, key);
            key++;
        }
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            charToIndexTable.put(ch, key);
            key++;
        }
        for (char ch = '0'; ch <= '9'; ++ch) {
            charToIndexTable.put(ch, key);
            key++;
        }
    }
}
