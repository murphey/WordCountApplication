package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
String txt = "The sun shines over the lake";
SpecificWordFrequency test = new SpecificWordFrequency();
test.calculateHighestFrequency(txt);
test.calculateFrequencyForWord(txt,"mama");
        System.out.println(test);
        System.out.println(test.calculateMostFrequentNWords(txt,5));


	// write your code here
        int max = 0;
        int count = 0;
        String str = "The sun shines over the  blake blake blake lake lake Lake";

        WordCount wordC = new WordCount();
        wordC.setWord(str);
        String[]allWords = wordC.getWord().toLowerCase().split(" ");
        HashMap<String, Integer> myWordsCount = new HashMap<String, Integer>();
        Integer largestVal = null;

        for (String s : allWords){

            if (myWordsCount.containsKey(s)) myWordsCount.replace(s, myWordsCount.get(s) + 1);
            else myWordsCount.put(s, 1);
        }
        System.out.println(myWordsCount);

        Map.Entry<String,Integer> maxEntry = null;

        for(Map.Entry<String,Integer> entry : myWordsCount.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        List<Map.Entry<String, Integer>> largestList = new ArrayList<Map.Entry<String, Integer>>();
        for (Map.Entry<String, Integer> i : myWordsCount.entrySet()){
            if (largestVal == null || largestVal  < i.getValue()){
                largestVal = i.getValue();
                largestList .clear();
                largestList .add(i);
            }else if (largestVal == i.getValue()){
                largestList .add(i);
            }
        }
        System.out.println(largestList);


        Arrays.sort(allWords);
        String mWord = allWords[0];
        String currWord = allWords[1];
        for(int i =0; i < allWords.length; i++) {
            if(allWords[i].equals(currWord)) {
                count++;
            }
            else {
                count = 1;
                currWord = allWords[i];
            }


            if(max < count) {
                max = count;
                wordC.setFrequency(count);

                mWord = allWords[i];
            }


        }
        System.out.println(wordC.getFrequency() + mWord + " Hello");


//Meerdere woorden mogen dezelfde frequency hebben
        System.out.println(wordC.getWord());


    }
}
