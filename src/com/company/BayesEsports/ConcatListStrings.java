package com.company.BayesEsports;

public class ConcatListStrings {

    public static String concatStrings(String[] array) {
        String first = "A";
        String last = "Z";
        StringBuilder result = new StringBuilder();
        String lastSentence = "";

        for (int i = 0; i < array.length; i++) {
            if (array[i].substring(0, 1).equals(first)) {
                if (array[i].substring(array[i].length() - 1).equals(last)) {
                    lastSentence = array[i].substring(array[i].length() - 1);
                    continue;
                }
                result.append(first);
                result.append(array[i], 1, array[i].length() - 1);
                first = array[i].substring(array[i].length() - 1);
            }
        }
        result.append(lastSentence);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(concatStrings(new String[] {"A-----b", "b-----*", "*-----Z", "*-----*"}));
    }
}
