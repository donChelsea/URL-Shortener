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
    private static HashMap<Long, Character> indexToCharTable = new HashMap<>();
    private static HashMap<Character, Long> charToIndexTable = new HashMap<>();
    private static List<Long> conversionList = new ArrayList<>();

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

    public static String createUniqueId(long base10Id) {
        StringBuilder uniqueId = new StringBuilder();
        long remainder;
        long quotient;

        while (base10Id > 0) {
            remainder = base10Id % 62;
            quotient = base10Id / 62;
            conversionList.add(remainder);
            base10Id = quotient;
        }

        for (int i = conversionList.size() - 1; i >= 0; i--) {
            long index = conversionList.get(i);
            uniqueId.append(indexToCharTable.get(index));
        }

        return uniqueId.toString();
    }

    public static long getDictionaryKeyFromUniqueID(String uniqueUrlId) {
        int len = uniqueUrlId.length() - 1;
        int base10Key = 0;
        while (len >= 0) {
            for (char ch : uniqueUrlId.toCharArray()) {
                long letter = charToIndexTable.get(ch);
                base10Key += letter * (Math.pow(62, len));
                len--;
            }
        }

        return base10Key;
    }

    // load maps with character and index data for conversion

    public static void fillIndexToCharTable() {
        long key = 0;
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
        long key = 0;
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
