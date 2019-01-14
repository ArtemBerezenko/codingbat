package com.company.ProgramSchool.AB;
/*
    Требуется сложить два целых числа А и В.
    Входные данные
    В единственной строке входного файла INPUT.TXT записано два натуральных числа через пробел, не превышающих 109.
    Выходные данные
    В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — сумму чисел А и В.
 */

import java.io.*;
import java.util.Scanner;

public class Reader {
    static final String INPUT_TXT = "C:/Users/Home/IdeaProjects/codingbat/src/com/company/ProgramSchool/INPUT.TXT";
    static final String OUTPUT_TXT = "C:/Users/Home/IdeaProjects/codingbat/src/com/company/ProgramSchool/OUTPUT.TXT";
    int sum;

    public void readFile() throws IOException {
        Scanner in = null;

        try {
            in = new Scanner(new File(INPUT_TXT));
            int a = in.nextInt(), b = in.nextInt();
            sum = a + b;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void writeToFile() throws IOException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new File(OUTPUT_TXT));
            out.print(sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
