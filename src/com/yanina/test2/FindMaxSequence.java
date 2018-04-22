package com.yanina.test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindMaxSequence {

    private static final String FILENAME = "/home/yanusia/IdeaProjects/Softheme/INPUT.txt";
    private static final String FILENAMEOUTPUT = "/home/yanusia/IdeaProjects/Softheme/OUTPUT.txt";

    public void getMaxSequence() {
        List<Character> chars = readFromFile();
        outPutStream(findMaxSequence(chars));
    }

    private List<Character> readFromFile() {
        List<Character> chars = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILENAME));
            int symbols;
            while ((symbols = bufferedReader.read()) != -1) {
                chars.add((char) symbols);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(bufferedReader!=null)
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.print(ex.getMessage());
            }
        }
        return chars;
    }

    private int findMaxSequence(List<Character> symbols) {

        int maxSequence = 0;
        int currentSequence = 0;

        for (Character symb : symbols) {
            if (Character.isDigit(symb)) {
                if (symb == '1') {
                    if (maxSequence < ++currentSequence) {
                        maxSequence = currentSequence;
                    }
                } else currentSequence = 0;
            }
        }
        return maxSequence;
    }

    private void outPutStream(int maxSequence) {

        try (FileWriter output = new FileWriter(FILENAMEOUTPUT)) {
            output.write(Integer.toString(maxSequence));
            output.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}






