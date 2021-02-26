package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class SpecificWordFrequency implements WordFrequencyAnalyzer {
    List<WordFrequency>frequencyList;
    String wordInput;
    Map<WordFrequency, Integer> occurrences = new HashMap<>();
    Integer counts;
    String specificWord;
    Object obj;
    private int frequentN = 0;
    private int count = 0;
    private int wordMax = 0;

    int max = 0;
    public SpecificWordFrequency() {
    }

    public String getWord() {
        return wordInput;
    }

    public String getSpecificWord() {
        return specificWord;
    }

    public int getFrequentN() {
        return frequentN;
    }

    public void setFrequentN(int frequentN) {
        this.frequentN = frequentN;
    }

    public void setSpecificWord(String specificWord) {
        this.specificWord = specificWord;
    }

    public void setWord(String word) {
        this.wordInput = word;
    }


    @Override
    public int calculateHighestFrequency(String text) {
        String[]allWords = text.toLowerCase().split(" ");
        Arrays.sort(allWords);
        wordInput = allWords[0];
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
//                word = allWords[i];
                setWord(allWords[i]);
            }


        }

        return max;
    }


    @Override
    public int calculateFrequencyForWord(String text, String word) {
        int counter = 0;
        setSpecificWord(word);
        String[]allWords = text.toLowerCase().split(" ");
        Arrays.sort(allWords);
        for (int i = 0; i < allWords.length; i++) {
            if (word.equals(allWords[i]))
                counter++;
        }
        wordMax = counter;
        return wordMax;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        String[]allWords = text.toLowerCase().split("\\s+");
        WordCount nn = new WordCount();
        frequencyList = new ArrayList(Arrays.asList(allWords));
//        frequencyList.sort((a,b)->b.getWord().compareTo(a.getWord()));
//        Collections.sort(frequencyList, (WordFrequency a, WordFrequency b) -> b.getWord().compareTo(a.getWord()));
//        Collections.sort(frequencyList, Collections.reverseOrder());
//        frequencyList.sort(null);
//        frequencyList.add();
        frequencyList = frequencyList.stream()
                .sorted()
                .collect(Collectors.toList());

       System.out.println("n=" + n);
        Map<String, Integer> occurrences = new HashMap<String, Integer>();

        for ( String word : allWords ) {
            Integer oldCount = occurrences.get(word);
            if ( oldCount == null ) {
                oldCount = 0;
            }

            occurrences.put(word, oldCount + 1);
        }
        occurrences.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(3)
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
        System.out.println(occurrences +"");


        TreeMap<String, Integer> myNewMap = occurrences.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(3)
                .collect(TreeMap::new, (ma, ea) -> ma.put(ea.getKey(), ea.getValue()), Map::putAll);
        System.out.println(myNewMap + "");
        List<WordFrequency> result2 = new ArrayList(myNewMap.entrySet());
        return result2;
    }
    @Override
    public String toString() {
        return "SpecificWordFrequency{" +
                "word='" + wordInput + '\'' +
                ", frequency=" + max +
                ", Specificword=" + getSpecificWord() +
                ", Specific word frequency=" + wordMax +
                '}';
    }
}
