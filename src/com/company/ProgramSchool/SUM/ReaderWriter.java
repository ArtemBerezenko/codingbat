package com.company.ProgramSchool.SUM;
/*
    Требуется посчитать сумму целых чисел, расположенных между числами 1 и N включительно.
    Входные данные:
    В единственной строке входного файла INPUT.TXT записано единственное целое число N, не превышающее по абсолютной величине 104.
    Выходные данные:
    В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — сумму чисел, расположенных между 1 и N включительно.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReaderWriter {
    static final String INPUT_TXT = "C:/Users/Home/IdeaProjects/codingbat/src/com/company/ProgramSchool/SUM/input.txt";
    static final String OUTPUT_TXT = "C:/Users/Home/IdeaProjects/codingbat/src/com/company/ProgramSchool/SUM/output.txt";
    private int N;

    public void readFile() throws IOException {
        Scanner in = null;

        try {
            in = new Scanner(new File(INPUT_TXT));
            N = in.nextInt();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void writeToFile(int sum) throws IOException {
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

    public int getN() {
        return N;
    }
}
