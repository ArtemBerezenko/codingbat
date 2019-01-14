package com.company.ProgramSchool.SUM;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReaderWriter readerWriter = new ReaderWriter();
        Summator summator = new Summator();
        readerWriter.readFile();
        readerWriter.writeToFile(summator.sumN(readerWriter.getN()));
    }
}
