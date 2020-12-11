package com.company.CodingBat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.incrementExact;
import static java.lang.Math.max;

/**
 * Created by Home on 08.01.2017.
 */
public class Warmup2 {

    public static String stringX(String str) {
        String x = "x";
        String string = "";
        for (int i = 0; i < str.length(); ++i) {
            String sub = str.substring(i, i + 1);
            if (!(i > 0 && i < str.length() - 1 && (sub.equals(x)))) {
                string += sub;
            }
        }
        return string;
    }

    @Test
    public void testStringX() {
        String str = stringX("xxHxix");
        System.out.println(str);
        String str1 = stringX("abxxxcd");
        System.out.println(str1);
        String str2 = stringX("xabxxxcdx");
        System.out.println(str2);
    }

//     0,1, 4,5, 8,9

    public String altPairs(String str) {
        String string = "";
        if (str.length() >= 10) {
            string = str.substring(0, 2) + str.substring(4, 6) + str.substring(8, 10) + str.substring(12, 14);
        } else if (str.length() >= 6 && str.length() <= 10) {
            string = str.substring(0, 2) + str.substring(4, 6);
        } else if (str.length() >= 2 && str.length() <= 6) {
            string = str.substring(0, 2);
        } else if (str.length() == 1) {
            string = str.substring(0);
        }
        return string;
    }

    @Test
    public void altPairs() {
        String str = altPairs("kitten");
        System.out.println(str);
        String str1 = altPairs("Chocolate");
        System.out.println(str1);
        String str2 = altPairs("CodingHorror");
        System.out.println(str2);
    }

    public String altPairs2(String str) {
        String string = "";
        for (int i = 0; i < str.length(); i += 4) {
            int end = i + 2;
            if (end > str.length()) {
                end = str.length();
            }
            string += str.substring(i, end);
        }
        return string;
    }

    @Test
    public void altPairs2() {
        String str = altPairs2("kitten");
        System.out.println(str);
        String str1 = altPairs2("Chocolate");
        System.out.println(str1);
        String str2 = altPairs2("CodingHorror");
        System.out.println(str2);
    }

//    public String stringYak(String str) {
//        String yak = "yak";
//        String string = "";
//
//        for (int i = 0; i < str.length(); i += 3) {
//            int end = i + 3;
//            if (end > str.length()) {
//                end = str.length();
//            }
//            String sub = str.substring(i, end);
//            if (!(sub.equals(yak))) {
//                string += sub;
//            }
//        }
//        return string;
//    }

    public String stringYak(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 < str.length() && str.charAt(i) == 'y' && str.charAt(i + 2) == 'k') {
                i = i + 2;
            } else {
                result = result + str.charAt(i);
            }
        }
        return result;
    }

    @Test
    public void stringYak() {
        String str3 = stringYak("HiyakHi");
        System.out.println(str3);
        String str4 = stringYak("xxxyakyyyakzzz");
        System.out.println(str4);
        String str = stringYak("yakpak");
        System.out.println(str);
        String str1 = stringYak("pakyak");
        System.out.println(str1);
        String str2 = stringYak("yak123ya");
        System.out.println(str2);

    }

    public int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void array667() {
        System.out.println(array667(new int[]{6, 6, 2}));
        System.out.println(array667(new int[]{6, 6, 2, 6}));
        System.out.println(array667(new int[]{6, 7, 2, 6}));

    }

    public boolean noTriples(int[] nums) {
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i - 1] == nums[i] && nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void noTriples() {

        System.out.println(noTriples(new int[]{1, 1, 2, 2, 1}));
        System.out.println(noTriples(new int[]{1, 1, 2, 2, 2, 1}));
        System.out.println(noTriples(new int[]{1, 1, 1, 2, 2, 2, 1}));
    }

    public String extraEnd(String str) {
        String string = str.substring(str.length() - 2);
        return string + string + string;
    }

    @Test
    public void extraEnd() {
        System.out.println(extraEnd("Hello"));
        System.out.println(extraEnd("ab"));
        System.out.println(extraEnd("Hi"));
    }

    public String firstHalf(String str) {
        String string = "";
        for (int i = 0; i > str.length() / 2; i++) {
            string += str.substring(i, i + 1);
        }
        return string;
    }

    @Test
    public void firstHalf() {
        System.out.println(firstHalf("WooHoo"));
        System.out.println(firstHalf("HelloThere"));
        System.out.println(firstHalf("abcdef"));
    }

    public String right2(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            return str.substring(str.length() - 1, str.length() - 2);
        }
    }

    @Test
    public void right2() {
        System.out.println(right2("Hello"));
        System.out.println(right2("java"));
        System.out.println(right2("Hi"));
    }

    public String twoChar(String str, int index) {
        if (index < 0 || str.substring(index, str.length()).length() < 2) {
            return str.substring(0, 2);
        } else {
            return str.substring(index, 2);
        }
    }

    @Test
    public void twoChar() {
        System.out.println(twoChar("java", 0));
        System.out.println(twoChar("java", 2));
        System.out.println(twoChar("java", 3));
        System.out.println(twoChar("Hello", 1));
    }

    public String lastChars(String a, String b) {
        if (a.length() == 0) {
            a = "@";
        }
        if (b.length() == 0) {
            b = "@";
        }
        if (a.length() > 0) {
            a = a.substring(0, 1);
        }
        if (b.length() > 0) {
            b = b.substring(b.length() - 1);
        }
        return a + b;
    }

    @Test
    public void lastChars() {
        System.out.println(lastChars("hi", ""));
        System.out.println(lastChars("", ""));
        System.out.println(lastChars("kitten", ""));
    }

    public String conCat(String a, String b) {
        if (!a.isEmpty() && !b.isEmpty() && a.substring(a.length() - 1).equals(b.substring(0, 1))) {
            return a.substring(0, a.length() - 1) + b;
        } else {
            return a + b;
        }
    }

    @Test
    public void conCat() {
        System.out.println(conCat("abc", "cat"));
        System.out.println(conCat("dog", "cat"));
        System.out.println(conCat("abc", ""));
    }

    public String lastTwo(String str) {
        if (str.length() > 2) {
            return str.substring(0, str.length() - 1) +
                    str.substring(str.length() - 1);
        } else if (str.length() == 2) {
            return str.substring(str.length() - 1) + str.substring(0, str.length() - 1);
        }
        return str;
    }

    public boolean sameFirstLast(int[] nums) {
        if (nums.length > 1 && nums[0] == nums[nums.length - 1]) {
            return true;
        }
        return false;
    }

    public int sum3(int[] nums) {
        int summ = 0;
        for (int i = 0; i < nums.length; i++) {
            summ += nums[i];
        }
        return summ;
    }

    public int[] reverse3(int[] nums) {
        int[] array = new int[3];
        int count = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            array[count++] = nums[i];
        }
        return array;
    }

    public int[] maxEnd3(int[] nums) {
        int count = nums.length - 1;
        if (nums[0] > nums[nums.length - 1]) {
            while (count >= 0) {
                nums[count] = nums[0];
                count--;
            }
        } else {
            while (count >= 0) {
                nums[count] = nums[nums.length - 1];
                count--;
            }
        }
        return nums;
    }

    public int[] makeLast(int[] nums) {
        int[] array = new int[nums.length * 2];
        int count = 0;
        for (int i = 0; i <= array.length; i++) {
            if (i == array.length) {
                array[count] = nums[nums.length - 1];
            } else {
                array[count++] = 0;
            }
        }
        return array;
    }

    @Test
    public void makeLast() {
        int[] array = {4, 5, 6};
        int[] array1 = {1, 2};
        int[] array2 = {3};
        makeLast(array);
        makeLast(array1);
        makeLast(array2);
    }

    public boolean double23(int[] nums) {
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                count2++;
            }
            if (nums[i] == 3) {
                count3++;
            }
        }
        if (count2 == 2 || count3 == 2) {
            return true;
        }
        return false;
    }

    public int[] biggerTwo(int[] a, int[] b) {
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < a.length; i++) {
            aSum += a[i];
        }
        for (int i = 0; i < b.length; i++) {
            bSum += b[i];
        }
        if (aSum > bSum) {
            return a;
        } else if (aSum == bSum) {
            return a;
        } else {
            return b;
        }

    }


    public int teaParty(int tea, int candy) {
        int mod = tea / (candy * 2);
        int mod2 = candy / (tea * 2);
        if ((tea / candy >= 2 || candy / tea >= 2) && tea >= 5 && candy >= 5) {
            return 2;
        } else if ((tea + candy) >= 5 && tea >= 5 && candy >= 5) {
            return 1;
        } else if (tea < 5 || candy < 5) {
            return 0;
        }
        return 0;
    }

    @Test
    public void teaParty() {
        System.out.println(teaParty(11, 6));
        System.out.println(teaParty(5, 9));
    }

    public String fizzString(String str) {
        if (str.substring(0, 1).equals("f") && str.substring(str.length()).equals("b")) {
            return "FizzBuzz";
        }
        if (str.substring(0, 1).equals("f")) {
            str = "Fizz";
        }
        if (str.substring(str.length()).equals("b")) {
            str = "Buzz";
        }
        return str;
    }

    public boolean lessBy10(int a, int b, int c) {
        if (Math.abs(a - 10) > b || Math.abs(a - 10) > c) {
            return true;
        } else if (Math.abs(b - 10) > a || Math.abs(b - 10) > c) {
            return true;
        } else if (Math.abs(c - 10) > a || Math.abs(c - 10) > b) {
            return true;
        } else return false;
    }


    public int maxMod5(int a, int b) {
        if (a == b) {
            return 0;
        }

        if (a % 5 > b % 5 || a < b) {
            return b;
        } else {
            return a;
        }
    }

    @Test
    public void maxMod5() {
        System.out.println(maxMod5(3, 2));
        System.out.println(maxMod5(5, 9));
    }

    public int sumLimit(int a, int b) {
        int lengthA = String.valueOf(a).length();
        int ab = a + b;
        int lengthAB = String.valueOf(ab).length();
        if (lengthA > lengthAB) {
            return a;
        } else return ab;
    }

    public int noTeenSum(int a, int b, int c) {
        int A = fixTeen(a);
        int B = fixTeen(b);
        int C = fixTeen(c);
        return A + B + C;
    }

    public int fixTeen(int n) {
        if (n >= 13 && n < 15 || n > 16 && n <= 19) {
            return 0;
        }
        return n;
    }

    @Test
    public void noTeenSum() {
        System.out.println(noTeenSum(2, 13, 1));
        System.out.println(noTeenSum(2, 1, 14));
        System.out.println(noTeenSum(2, 1, 17));
    }

    public int round10(int num) {
        int res = 0;
        int division = num / 10;
        if (num % 10 > 4) {
            res = ((division + 1) * 10);
        } else res = (division * 10);
        return res;
    }

    @Test
    public void round10() {
        System.out.println(round10(16));
        System.out.println(round10(17));
        System.out.println(round10(11));
    }


    public int blackjack(int a, int b) {
        if (a > 21 && b > 21) {
            return 0;
        }
        if (a < 22 && b < 22) {
            if (21 - a > 21 - b) {
                return b;
            } else return a;
        } else if (a < 21 && b > 21) {
            return a;
        } else return b;
    }

    @Test
    public void blackjack() {
        System.out.println(blackjack(19, 22));
        System.out.println(blackjack(22, 19));
        System.out.println(blackjack(22, 50));
    }


    public boolean evenlySpaced(int a, int b, int c) {
        int max = maxInt(a, b, c);
        if (max == a) {
            if (a - b == b - c || a - c == c - b) {
                return true;
            }
        } else if (max == b) {
            if (b - a == a - c || b - c == c - a) {
                return true;
            }
        } else if (max == c) {
            if (c - a == a - b || c - b == b - a) {
                return true;
            }
        }
        return false;
    }

    public int maxInt(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else return c;
    }

    @Test
    public void evenlySpaced() {
        System.out.println(evenlySpaced(6, 2, 4));
        System.out.println(evenlySpaced(10, 9, 11));

    }

    public String doubleChar(String str) {
        String string = " ";
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            string = string + str.substring(i, i + 1) + str.substring(i, i + 1);
        }
        return string;
    }

    @Test
    public void doubleChar() {
        System.out.println(doubleChar("AAbb"));
        System.out.println(doubleChar("Hi-There"));

    }

    public boolean xyzThere(String str) {
        boolean flag = false;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                if (i != 0 && str.substring(i - 1, i).equals(".")) {
                    flag = false;
                    continue;
                }
                flag = true;
            }
        }
        return flag;
    }

    @Test
    public void xyzThere() {
        System.out.println(xyzThere("abc.xyzxyz"));
        System.out.println(xyzThere("xyz.abc"));

    }


    public boolean xyBalance(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("x")) {
                flag = false;
                for (int j = i; j < str.length(); j++) {
                    if (str.substring(j, j + 1).equals("y")) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    @Test
    public void xyBalance() {
        System.out.println(xyBalance("aaaa"));
        System.out.println(xyBalance("yaaxbb"));
    }

    public String mixString(String a, String b) {
        String str = "";
        int i = 0;
        int j = -1;
        for (; i < a.length(); i++) {
            str += a.substring(i, i + 1);
            j++;
            for (; j < b.length(); j++) {
                str += b.substring(j, j + 1);
                break;
            }
        }
        if (j < b.length()) {
            str += b.substring(j + 1, b.length());
        } else if (i < a.length()) {
            str += a.substring(i + 1, a.length());
        }
        return str;
    }

    @Test
    public void mixString() {
        System.out.println(mixString("Hi", "There"));
        System.out.println(mixString("abc", "xyz"));
    }

    public String repeatSeparator(String word, String sep, int count) {
        String string = "";
        for (int i = 0; i <= count; i++) {
            if (i < count) {
                string = string + word + sep;
            } else {
                string += word;
            }
        }
        return string;
    }

    public boolean prefixAgain(String str, int n) {
        for (int i = n; i < str.length() - n + 1; i++) {
            String string = str.substring(0, n);
            int j = i + n;
            if (str.substring(0, n).equals(str.substring(i, i + n))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void prefixAgain() {
        System.out.println(prefixAgain("xyzxyxyxy", 3));
        System.out.println(prefixAgain("abXYabc", 2));
    }

    public boolean xyzMiddle(String str) {
        String leftStr = "";
        String rightStr = "";
        int i = 0;
        while (i < str.length() - 2) {
            if (str.substring(i, i + 3).equals("xyz") && i >= (str.length() / 2) - 2) {
                leftStr = str.substring(0, i);
                rightStr = str.substring(i + 3, str.length());
                if (Math.abs(leftStr.length() - rightStr.length()) < 2) {
                    return true;
                } else {
                    return false;
                }
            }
            i++;
        }
        return false;
    }

    @Test
    public void xyzMiddle() {
        System.out.println(xyzMiddle("AxyzBBB"));
        System.out.println(xyzMiddle("xyzz"));
    }

    public String getSandwich(String str) {
        int start = 0;
        int finish = 0;
        for (int i = 0; i <= str.length() / 2 - 5; i++) {
            if (str.substring(i, i + 5).equals("bread")) {
                start = i + 5;
                break;
            }
        }

        for (int j = str.length(); j > str.length() / 2 + 5; j--) {
            if (str.substring(j - 5, j).equals("bread")) {
                finish = j - 5;
                break;
            }
        }
        return str.substring(start, finish);
    }

    @Test
    public void getSandwich() {
        System.out.println(getSandwich("breadAbread"));
        System.out.println(getSandwich("breaxbreadybread"));
    }

    public String getSandwich2(String str) {
        int start = 0;
        int finish = 0;
        for (int i = 0; i <= str.length() - 5; i++) {
            if (str.substring(i, i + 5).equals("bread")) {
                start = i + 5;
                break;
            }
        }

        for (int j = str.length(); j > start + 5; j--) {
            if (str.substring(j - 5, j).equals("bread")) {
                finish = j - 5;
                break;
            }
        }
        if (start != 0 && finish != 0) {
            return str.substring(start, finish);
        }
        return "";
    }

    @Test
    public void getSandwich2() {
        System.out.println(getSandwich2("xyz"));
        System.out.println(getSandwich2("xxbreadyy"));
        System.out.println(getSandwich2("abcbreaz"));
    }

    public boolean sameStarChar(String str) {
        int count = 0;
        boolean flag = true;
        while (count < str.length() - 1) {
            if (str.substring(count, count + 1).equals("*") && count != 0 && count != str.length() - 1) {
                if (str.substring(count - 1, count).equals(str.substring(count + 1, count + 2))) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            count++;
        }
        return flag;
    }

    @Test
    public void sameStarChar() {
        System.out.println(sameStarChar(""));
        System.out.println(sameStarChar("*xa*a*b"));
        System.out.println(sameStarChar("12*2*3*"));
    }

    public String oneTwo(String str) {
        String newStr = "";
        for (int i = 0; i < str.length() - 2; i += 3) {
            newStr = newStr + str.substring(i + 1, i + 3) + str.substring(i, i + 1);
        }
        return newStr;
    }

    @Test
    public void oneTwo() {
        System.out.println(oneTwo("abc"));
        System.out.println(oneTwo("tcagdo"));
    }

    public String zipZap(String str) {
        String string = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.length() > 2 && str.substring(i, i + 1).equals("z") &&
                    str.substring(i + 2, i + 3).equals("p")) {
                string = string + str.substring(i, i + 1) + str.substring(i + 2, i + 3);
                i += 2;
            } else {
                string += str.substring(i, i + 1);
            }
        }
        return string;
    }

    @Test
    public void zipZap() {
        System.out.println(zipZap("abcppp"));
        System.out.println(zipZap("z"));
    }

    public String starOut(String str) {
        String string = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.length() > 1) {
                if (i == 0) {
                    if (!str.substring(i, i + 1).equals("*")
                            && !str.substring(i + 1, i + 2).equals("*")) {
                        string = str.substring(i, i + 1);
                    }
                } else if (i == str.length() - 1) {
                    if (!str.substring(i - 1, i).equals("*") &&
                            !str.substring(i, i + 1).equals("*")) {
                        string = string + str.substring(i);
                    }
                } else if (!str.substring(i, i + 1).equals("*") &&
                        !str.substring(i + 1, i + 2).equals("*") &&
                        !str.substring(i - 1, i).equals("*")) {
                    string = string + str.substring(i, i + 1);
                }
            } else if (!str.substring(i, i + 1).equals("*")) {
                string = str.substring(i, i + 1);
            }
        }
        return string;
    }

    @Test
    public void starOut() {
        System.out.println(starOut("a"));
        System.out.println(starOut("a*bc"));
    }


    public String plusOut(String str, String word) {
        String string = "";
        for (int i = 0; i <= str.length() - 1; ) {
            if (i <= str.length() - word.length() && str.substring(i, i + word.length()).equals(word)) {
                string += word;
                i = i + word.length();
            } else if (i == str.length() - word.length()) {
                for (int j = 0; j < word.length(); j++) {
                    string += "+";
                }
                i = i + word.length();
            } else {
                string += "+";
                i++;
            }
        }
        return string;
    }

    @Test
    public void plusOut() {
        System.out.println(plusOut("cXYZ", "XY"));
        System.out.println(plusOut("abXYabcXYZ", "ab"));
    }

    public String wordEnds(String str, String word) {
        String string = "";
        for (int i = 0; i <= str.length() - 1; ) {
            if (i <= str.length() - word.length() && str.substring(i, i + word.length()).equals(word)) {
                if (i > 0) {
                    string += str.substring(i - 1, i);
                }
                if (i != str.length() - word.length()) {
                    string += str.substring(i + word.length(), i + word.length() + 1);
                    i += word.length();
                    continue;
                }
            }
            i++;
        }
        return string;
    }

    @Test
    public void wordEnds() {
        System.out.println(wordEnds("XYXY", "XY"));
        System.out.println(wordEnds("abcXY123XYijk", "XY"));
    }

    // str.substring(index + 1, index + 2).equals(" ") ||

    public int countYZ(String str) {
        int index = 0;
        int count = 0;
        while (index < str.length()) {
            if (str.substring(index, index + 1).toLowerCase().equals("y") ||
                    str.substring(index, index + 1).toLowerCase().equals("z")) {
                if (index == str.length() - 1 ||
                        !(str.toLowerCase().charAt(index + 1) >= 'a' && str.toLowerCase().charAt(index + 1) <= 'z')) {
                    count++;
                }
            }
            index++;
        }
        return count;
    }

    @Test
    public void countYZ() {
//        System.out.println(countYZ("y2bz"));
        System.out.println(countYZ("DAY abc XYZ"));
    }

    public String withoutString(String base, String remove) {
        int start = 0;
        int finish = 0;
        int count = 0;
        String str = base;
        for (int i = 0; i <= base.length() - remove.length(); ) {
            if (base.substring(i, i + remove.length()).toLowerCase().equals(remove.toLowerCase())) {
                start = i - count;
                finish = i + remove.length() - 1 - count;
                str = removeString(str, start, finish);
                count += remove.length();
                i += remove.length();
                continue;
            }
            i++;
        }
        return str;
    }

    private String removeString(String str, int start, int finish) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < start || i > finish) {
                string += str.substring(i, i + 1);
            }
        }
        return string;
    }


    @Test
    public void withoutString() {
        System.out.println(withoutString("abxxxxab", "xx"));
        System.out.println(withoutString("xxx", "xx"));
    }

    public boolean equalIsNot(String str) {
        int countIs = 0;
        int countNot = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("is")) {
                countIs++;
            }
        }

        for (int j = 0; j < str.length() - 2; j++) {
            if (str.substring(j, j + 3).equals("not")) {
                countNot++;
            }
        }

        if (countIs == countNot) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void equalIsNot() {
        System.out.println(equalIsNot("isisnotno7Not"));
        System.out.println(equalIsNot("This is notnot"));
    }

    public boolean gHappy(String str) {
        boolean flag = false;
        if (str.isEmpty()) return true;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("g")) {
                if (i != str.length() - 1 && str.substring(i + 1, i + 2).equals("g")
                        || i != 0 && str.substring(i - 1, i).equals("g")) {
                    flag = true;
                    i++;
                } else flag = false;
            }
        }
        return flag;
    }

    @Test
    public void gHappy() {
        System.out.println(gHappy("xxgggxyg"));
        System.out.println(gHappy("g"));

    }

    public int countTriple(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 1).equals(str.substring(i + 1, i + 2))
                    && str.substring(i, i + 1).equals(str.substring(i + 2, i + 3))) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void countTriple() {
        System.out.println(countTriple("abcXXXabc"));
        System.out.println(countTriple("xxxabyyyycd"));
    }

    public int sumDigits(String str) {
        int sum = 0;
        int count = 0;
        char ch;
        while (count < str.length()) {
            ch = str.charAt(count);
            if (Character.isDigit(ch)) {
                sum += Integer.parseInt(str.substring(count, count + 1));
            }
            count++;
        }
        return sum;
    }

    @Test
    public void sumDigits() {
        System.out.println(sumDigits("aa1bc2d3"));
        System.out.println(sumDigits("aa11b33"));
    }

    public String sameEnds(String string) {
        String start = "";
        String end = "";
        //       int index = string.length() / 2;
        int j = string.length() / 2;
        for (int i = 0; i < string.length() / 2; i++) {
            start = string.substring(i, i + 1);
//            j = index;
            for (; j < string.length(); j++) {
                if (start.equals(string.substring(j, j + 1))) {
                    end += string.substring(j, j + 1);
                    j = ++j;
                    break;
                }
            }
            if (i == 0 && end.length() == 0) {
                return end;
            }
        }
        return end;
    }

    @Test
    public void sameEnds() {
        System.out.println(sameEnds("Hello! and Hello!"));
        System.out.println(sameEnds("xavaXYZjava"));
    }

    public String mirrorEnds(String string) {
        String start = "";
        String end = "";
        String result = "";
        int j = string.length();

        for (int i = 0; i <= string.length() / 2; i++) {
            if (!string.isEmpty()) {
                start = string.substring(i, i + 1);

                for (; j > string.length() / 2; j--) {
                    end = string.substring(j - 1, j);
                    if (!start.equals(end)) {
                        return result;
                    } else if (start.equals(end) && result.length() == string.length() / 2) {
                        result = string;
                        return result;
                    } else if (start.equals(end)) {
                        result += string.substring(j - 1, j);
                        j = --j;
                        break;
                    }
                }
            } else {
                return string;
            }
        }
        return result;
    }

    public String mirrorEndsBest(String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(string.length() - i - 1))
                result.append(string.charAt(i));
            else
                break;
        }

        return result.toString();
    }

    public String mirrorEnds2(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.substring(i, i + 1).equals(string.substring(string.length() - i - 1, string.length() - i))) {
                result += string.substring(i, i + 1);
            } else break;
        }
        return result;
    }

    @Test
    public void mirrorEnds2() {
        System.out.println(mirrorEnds2("band andab"));
        System.out.println(mirrorEnds2("abXYZba"));
    }

    public int maxBlock(String str) {
        String twins = "";
        String muchTwins = "";

        for (int i = 1; i <= str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                if (i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    twins += str.substring(i, i + 1);
                    continue;
                } else {
                    twins += str.substring(i - 1, i + 1);
                }
            }

            if (twins.length() > muchTwins.length()) {
                muchTwins = twins;
            }
            twins = "";
        }
        if (!str.isEmpty() && muchTwins.isEmpty()) return 1;
        return muchTwins.length();
    }

    public int maxBlock2(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        int current = 1;
        int max = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (current > max) {
                    max = current;
                } else current = 1;
            } else current++;
        }
        return Math.max(current, max);
    }

    @Test
    public void maxBlock() {
        System.out.println(maxBlock("xyz"));
        System.out.println(maxBlock("xyzz"));
    }

    public int sumNumbers(String str) {
        int sum = 0;
        String digits = "";
        String currentDigits = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                currentDigits += str.substring(i, i + 1);
                continue;
            }
            if (digits.isEmpty()) {
                digits = currentDigits;
                currentDigits = "";
            }
            if (!digits.isEmpty() && !currentDigits.isEmpty()) {
                sum = countSum(digits, currentDigits);
                digits = String.valueOf(sum);
                currentDigits = "";
            }
        }
        if (!digits.isEmpty() && currentDigits.isEmpty()) {
            sum = Integer.parseInt(digits);
        } else if (!digits.isEmpty() && !currentDigits.isEmpty()) {
            sum = countSum(digits, currentDigits);
        }
        return sum;
    }

    public int countSum(String digits, String currentDigits) {
        int sum = 0;
        StringBuilder string = new StringBuilder();
        StringBuilder str = new StringBuilder();
        String big = String.valueOf(Math.max(Integer.parseInt(digits), Integer.parseInt(currentDigits)));
        String small = String.valueOf(Math.min(Integer.parseInt(digits), Integer.parseInt(currentDigits)));
        str.append(big.substring(0, big.length() - small.length()));

        int j = str.length();
        for (int i = 0; i < small.length(); i++) {
            for (; j < big.length(); ) {
                string.append(Integer.parseInt(small.substring(i, i + 1))
                        + Integer.parseInt(big.substring(j, j + 1)));
                j++;
                break;
            }
        }
        str.append(string);
        sum = Integer.parseInt(String.valueOf(str));
        return sum;
    }

    @Test
    public void sumNumbers() {
        System.out.println(sumNumbers("5hoco1a1e"));
        System.out.println(sumNumbers("a1234bb11"));
    }

    public int sumNumbers2(String str) {
        int sum = 0;
        int i = 0;
        int begin;
        int end;

        while (i < str.length() && !Character.isDigit(str.charAt(i)))
            i++;

        begin = i;
        end = i;

        while (i < str.length()) {
            if (!Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(str.substring(begin, end));
                while (i < str.length() && !Character.isDigit(str.charAt(i)))
                    i++;

                begin = i;
                end = i;
            } else {
                end++;
                i++;
            }
        }

        if (end > begin)
            sum += Integer.parseInt(str.substring(begin, end));

        return sum;
    }

    @Test
    public void sumNumbers2() {
        System.out.println(sumNumbers2("a1234bb11"));
        System.out.println(sumNumbers2("5hoco1a1e"));
    }

    public String notReplace(String str) {
        int i = 0;
        StringBuilder string = new StringBuilder();

        while (i < str.length()) {
            if (i != str.length() - 1 && str.substring(i, i + 2).toLowerCase().equals("is")) {
                if (i != 0) {
                    if (i == str.length() - 2 && !Character.isLetter(str.charAt(i - 1))) {
                        string.append("is not");
                        i += 2;
                    } else if (i < str.length() - 2 && !Character.isLetter(str.charAt(i - 1)) && !Character.isLetter(str.charAt(i + 2))) {
                        string.append("is not");
                        i += 2;
                    } else {
                        string.append(str.substring(i, i + 1));
                        i++;
                    }
                } else if (i < str.length() - 2 && !Character.isLetter(str.charAt(i + 2))) {
                    string.append("is not");
                    i += 2;
                } else if (str.length() == 2) {
                    string.append("is not");
                    i += 2;
                } else {
                    string.append(str.substring(i, i + 1));
                    i++;
                }
            } else {
                string.append(str.substring(i, i + 1));
                i++;
            }
        }
        return String.valueOf(string);
    }

    @Test
    public void notReplace() {
        System.out.println(notReplace("is"));
        System.out.println(notReplace("is his"));
    }

    //Array - 2:

    public int countEvens(int[] nums) {
        int sumEvens = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sumEvens++;
            }
        }
        return sumEvens;
    }

    public int bigDiffMy(int[] nums) {
        int max = 0;
        int min = 0;
        int currentMax = 0;
        int currentMin = 0;

        for (int i = 0; i < nums.length - 1; i += 2) {
            currentMax = Math.max(nums[i], nums[i + 1]);
            currentMin = Math.min(nums[i], nums[i + 1]);
            if (currentMax > max) {
                max = currentMax;
            }
            if (i == 0) {
                min = currentMin;
            }
            if (currentMin < min) {
                min = currentMin;
            }
        }
        return max - min;
    }

    public int bigDiff(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return max - min;
    }

    @Test
    public void bigDiff() {
        int[] arr = {10, 3, 5, 6};
        System.out.println(bigDiff(arr));
        int[] arr1 = {7, 2, 10, 9};
        System.out.println(bigDiff(arr1));
    }

    public int centeredAverage(int[] nums) {
        int sum = 0;
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return (sum - min - max) / (nums.length - 2);
    }

    @Test
    public void centeredAverage() {
        int[] arr = {1, 2, 3, 4, 100};
        System.out.println(centeredAverage(arr));
        int[] arr1 = {-10, -4, -2, -4, -2, 0};
        System.out.println(centeredAverage(arr1));
    }

    public int sum13(int[] nums) {
        int sum = 0;
        int count = 0;
        while (count < nums.length) {
            if (nums[count] == 13) {
                count += 2;
            } else sum += nums[count++];
        }
        return sum;
    }

    @Test
    public void sum13() {
        int[] arr = {1, 2, 2, 1};
        System.out.println(sum13(arr));
        int[] arr1 = {1, 2, 2, 13, 1};
        System.out.println(sum13(arr1));
    }

    public int sum67(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == 7) {
                        i += (j - i);
                        break;
                    }
                }
            } else sum += nums[i];
        }
        return sum;
    }

    @Test
    public void sum67() {
        int[] arr = {1, 6, 2, 2, 7, 1, 6, 99, 99, 7};
        System.out.println(sum67(arr));
        int[] arr1 = {1, 2, 2, 6, 99, 99, 7, 2};
        System.out.println(sum67(arr1));
    }

    public boolean has22(int[] nums) {
        boolean flag = false;
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] == 2 && nums[index + 1] == 2) {
                flag = true;
            }
            index++;
        }
        return flag;
    }

    @Test
    public void has22() {
        int[] arr = {1, 2, 2};
        System.out.println(has22(arr));
        int[] arr1 = {2, 1, 2};
        System.out.println(has22(arr1));
    }

    public boolean lucky13(int[] nums) {
        boolean flag = true;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1 || nums[i] == 3) {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    @Test
    public void lucky13() {
        int[] arr = {2, 7, 2, 1};
        System.out.println(lucky13(arr));
        int[] arr1 = {1, 2, 3};
        System.out.println(lucky13(arr1));
    }

    public boolean sum28(int[] nums) {
        int sum2 = 0;
        int count = 0;
        while (count < nums.length) {
            if (nums[count] == 2) {
                sum2 += 2;
            }
            count++;
        }
        if (sum2 == 8) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void sum28() {
        int[] arr = {2, 3, 2, 2, 4, 2};
        System.out.println(sum28(arr));
        int[] arr1 = {2, 3, 2, 2, 4, 2, 2};
        System.out.println(sum28(arr1));
    }

    public boolean more14(int[] nums) {
        int count1 = 0;
        int count4 = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 4) {
                count4++;
            }
            i++;
        }
        if (count1 > count4) return true;
        else return false;
    }

    @Test
    public void more14() {
        int[] arr = {1, 4, 1};
        System.out.println(more14(arr));
        int[] arr1 = {1, 4, 1, 4};
        System.out.println(more14(arr1));
    }

    public boolean only14(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 4) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    @Test
    public void only14() {
        int[] arr = {};
        System.out.println(only14(arr));
    }

    public boolean isEverywhere(int[] nums, int val) {
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == val || nums[i + 1] == val) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    @Test
    public void isEverywhere() {
        int[] arr = {1, 2, 1, 3};
        System.out.println(isEverywhere(arr, 1));
        int[] arr1 = {2, 1, 2, 1};
        System.out.println(isEverywhere(arr1, 1));
    }

    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (; j < nums1.length; ) {
                if (Math.abs(nums2[j] - nums1[i]) > 0 &&
                        Math.abs(nums2[j] - nums1[i]) <= 2) count++;
                break;
            }
            j++;
        }
        return count;
    }

    @Test
    public void matchUp() {
        int[] arr = {1, 2, 3};
        int[] arr1 = {2, 3, 3};
        System.out.println(matchUp(arr, arr1));
        int[] arr2 = {5, 3};
        int[] arr3 = {5, 5};
        System.out.println(matchUp(arr2, arr3));
    }

    public boolean has77(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] == 7 && nums[i + 1] == 7)) {
                flag = true;
            }
            if ((i <= nums.length - 3) && (nums[i] == 7 && nums[i + 2] == 7)) {
                flag = true;
            }
        }
        return flag;
    }

    @Test
    public void has77() {
        int[] arr = {2, 7, 2, 2, 7, 2};
        System.out.println(has77(arr));
    }

    public boolean has12_1(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == 2) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public boolean has12(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flag = true;
            }
            if (flag && nums[i] == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean modThree_1(int[] nums) {
        boolean flag = false;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) {
                flag = true;
            } else if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 && nums[i + 2] % 2 != 0) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean modThree(int[] nums) {
        boolean flag = false;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2 && nums[i] % 2 == nums[i + 2] % 2)
                return true;
        }
        return flag;
    }

    public boolean haveThree(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] == 3 && nums[i + 1] != 3) {
                count++;
            } else if (i == nums.length - 1 && nums[i - 1] != 3 && nums[i] == 3) {
                count++;
            } else if (nums[i - 1] != 3 && nums[i] == 3 && nums[i + 1] != 3) {
                count++;
            }
        }
        if (count == 3)
            return true;
        return false;
    }

    public boolean haveThreeRightVersion(int[] nums) {
        int count = 0;

        if (nums.length >= 1 && nums[0] == 3)
            count++;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 3 && nums[i] == 3)
                return false;

            if (nums[i] == 3)
                count++;
        }

        return count == 3;
    }

    public boolean sameEndsFirst(int[] nums, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        for (int i = nums.length - len; i > nums.length; i--) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] != nums[i]) return false;
            }
        }
        return true;
    }

    public boolean sameEndsSheet(int[] nums, int len) {
        int n = nums.length - len;
        for (int k = 0; k < len; k++) {
            for (; n < nums.length; ) {
                if (nums[k] != nums[n]) return false;
                break;
            }
            n++;
        }
        return true;
    }

    public boolean sameEnds(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[nums.length - len + i])
                return false;
        }

        return true;
    }

    @Test
    public void sameEndss() {
        int[] arr = {5, 6, 45, 99, 13, 5, 6};
        System.out.println(sameEnds(arr, 2));
    }

    public boolean tripleUp(int[] nums) {
        boolean flag = false;
        if (nums.length < 3) return false;
        for (int i = 1; i < nums.length; i++) {
            if ((Math.abs(nums[i]) - (Math.abs(nums[i - 1])) == 1)) {
                flag = true;
            } else flag = false;
        }
        return flag;
    }

    @Test
    public void tripleUp() {
        int[] arr = {10, 9, 8, -100, -99, 99, 100};
        System.out.println(tripleUp(arr));
    }

    public int[] shiftLeft(int[] nums) {
        int temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) nums[i] = temp;
            else nums[i] = nums[i + 1];
        }
        return nums;
    }

    @Test
    public void shiftLeft() {
        int[] arr = {6, 2, 5, 3};
        System.out.println(shiftLeft(arr));
    }


    public int[] shiftLeft2(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) array[i] = nums[0];
            array[i] = nums[i + 1];
        }
        return array;
    }


    public int[] pre4(int[] nums) {
        int[] array = new int[0];
        int count = 0;
        int length = 0;
        int temp = 0;
        while (count < nums.length) {
            if (nums[count] == 4) {
                temp = count;
                break;
            } else length++;
            count++;
        }

        if (temp != 0) {
            array = new int[length];
            for (int i = 0; i < temp; i++) {
                array[i] = nums[i];
            }
        }
        return array;
    }

    public int[] post4(int[] nums) {
        int i = nums.length - 1;

        while (nums[i] != 4) {
            i--;
        }

        int[] array = new int[nums.length - 1 - i];

        for (int j = 0; j < array.length; j++) {
            array[j] = nums[j + i + 1];
        }
        return array;
    }

    @Test
    public void post4() {
        int[] arr = {4, 1, 4, 2};
        System.out.println(post4(arr));
    }

    public int[] notAlone(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (i != 0 && i != nums.length - 1) {
                    if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                        int max = Math.max(nums[i - 1], nums[i + 1]);
                        nums[i] = Math.max(max, nums[i]);
                    }
                }
            }
        }
        return nums;
    }

    @Test
    public void notAlone() {
        int[] arr = {1, 2, 3};
        System.out.println(notAlone(arr, 2));
    }

    public int[] zeroFrontX(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j - 1] == 0) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    @Test
    public void zeroFront() {
        int[] arr = {0, 1, 1, 1, 0, 0, 0, 1};
        System.out.println(zeroFront(arr));
    }

    public int[] zeroFront(int[] nums) {
        if (nums.length == 0)
            return nums;

        int i = 0;

        while (nums[i] == 0)
            i++;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return nums;
    }

    public int[] withoutTen1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 10) {
                nums[i] = 0;
                int j = i + 1;
                while (j < nums.length && nums[j] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    j++;
                }
                i--;
            }
            i++;
        }
        return nums;
    }

    public int[] withoutTen(int[] nums) {
        int i = 0;

        while (i < nums.length && nums[i] != 10)
            i++;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != 10) {
                nums[i] = nums[j];
                nums[j] = 10;
                i++;
            }
        }

        for (; i < nums.length; i++)
            nums[i] = 0;

        return nums;
    }

    @Test
    public void withoutTen() {
        int[] arr = {1, 10, 10, 2};
        System.out.println(withoutTen(arr));
    }

    public int[] zeroMax1(int[] nums) {
        int i = 0;
        int max = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 != 0) {
                        if (max < nums[j])
                            max = nums[j];
                        nums[i] = max;
                    }
                }
            }
            i++;
            max = 0;
        }
        return nums;
    }

    @Test
    public void zeroMax() {
        int[] arr = {0, 5, 0, 3};
        System.out.println(zeroMax(arr));
    }

    public int[] zeroMax(int[] nums) {
        int i = nums.length - 1;

        while (i >= 0 && nums[i] % 2 == 0)
            i--;

        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] == 0)
                nums[j] = nums[i];

            if (nums[j] % 2 == 1 && nums[j] > nums[i])
                i = j;
        }

        return nums;
    }

    public int[] evenOdd(int[] nums) {
        int i = 0;

        while (i < nums.length && nums[i] % 2 == 0)
            i++;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return nums;
    }

    @Test
    public void evenOdd() {
        int[] arr = {1, 1, 0, 1, 0};
        System.out.println(evenOdd(arr));
    }

    public String[] fizzBuzz1(int start, int end) {
        String[] str = new String[end - start];
        int j = start;
        for (int i = 0; i < end - start; i++) {
            for (; j < end; ) {
                if (j % 3 == 0 && j % 5 == 0) str[i] = "FizzBuzz";
                else if (j % 3 == 0) str[i] = "Fizz";
                else if (j % 5 == 0) str[i] = "Buzz";
                else str[i] = String.valueOf(j);
                break;
            }
            j++;
        }
        return str;
    }

    @Test
    public void fizzBuzz() {
        System.out.println(fizzBuzz(30, 36));
    }

    public String[] fizzBuzz(int start, int end) {
        String[] arr = new String[end - start];

        for (int i = start; i < end; i++) {
            if (i % 15 == 0) {
                arr[i - start] = "FizzBuzz";
            } else if (i % 3 == 0) {
                arr[i - start] = "Fizz";
            } else if (i % 5 == 0) {
                arr[i - start] = "Buzz";
            } else {
                arr[i - start] = String.valueOf(i);
            }
        }

        return arr;
    }

    public int maxSpan(int[] nums) {
        int maxSpan = 0;
        int currSpan = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) currSpan = j - i;
                if (currSpan > maxSpan) maxSpan = currSpan;
            }
        }
        return maxSpan;
    }

    @Test
    public void maxSpan() {
        int[] arr = {1, 2, 1, 1, 3};
        System.out.println(maxSpan(arr));
    }

    public int[] fix341(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 4) {
                        int temp = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
        return nums;
    }

    public int[] fix34_1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3 && nums[i + 1] != 4) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 4) {
                        int temp = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
            if (i != 0 && nums[i] == 4 && nums[i - 1] != 3) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] == 3 && nums[j + 1] != 4) {
                        int temp = nums[j + 1];
                        nums[j + 1] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public int[] fix34(int[] nums) {
        int i = 0;

        while (i < nums.length && nums[i] != 3)
            i++;

        int j = i + 1;

        while (j < nums.length && nums[j] != 4)
            j++;

        while (i < nums.length) {
            if (nums[i] == 3) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;

                while (j < nums.length && nums[j] != 4)
                    j++;
            }
            i++;
        }
        return nums;
    }

    @Test
    public void fix34() {
        int[] arr = {5, 3, 5, 4, 5, 4, 5, 4, 3, 5, 3, 5};
        System.out.println(fix34(arr));
    }

    public int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4 && nums[i + 1] != 5) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 5) {
                        int temp = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
            if (nums[i] == 5 && (i == 0 || nums[i - 1] != 4)) {
                for (int k = i + 1; k < nums.length; k++) {
                    if (nums[k] == 4) {
                        int temp = nums[k + 1];
                        nums[k + 1] = nums[i];
                        nums[i] = temp;
                    }
                }
            }
        }
        return nums;
    }

    public boolean canBalance1(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum1 += nums[j];
            }
            for (int k = i + 1; k < nums.length; k++) {
                sum2 += nums[k];
            }
            if (sum1 == sum2) return true;
            else {
                sum1 = 0;
                sum2 = 0;
            }
        }
        return false;
    }

    @Test
    public void canBalance() {
        int[] arr = {1, 1, 1, 2, 1};
        System.out.println(canBalance(arr));
    }

    public boolean canBalance(int[] nums) {
        int first = 0;
        int second = 0;

        for (int i = 0; i < nums.length; i++)
            second += nums[i];

        for (int i = 0; i <= nums.length - 2; i++) {
            first += nums[i];
            second -= nums[i];

            if (first == second)
                return true;
        }

        return false;
    }

    public boolean linearIn1(int[] outer, int[] inner) {
        boolean flag = true;
        for (int i = 0; i < inner.length; i++) {
            for (int j = 0; j < outer.length; j++) {
                if (inner[i] == outer[j]) {
                    flag = true;
                    break;
                } else if (j == outer.length - 1 && flag == false) return false;
                else flag = false;
            }
        }
        return flag;
    }

    @Test
    public void linearIn() {
        int[] arr = {1, 2, 4, 6};
        int[] arr2 = {2, 3, 4};
        System.out.println(linearIn(arr, arr2));
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int i = 0;
        int j = 0;

        while (i < inner.length && j < outer.length) {
            if (inner[i] > outer[j]) {
                j++;
            } else if (inner[i] < outer[j]) {
                return false;
            } else {
                i++;
            }
        }

        if (i != inner.length)
            return false;

        return true;
    }

    public int[] squareUp1(int n) {
        int[] arr = new int[n * n];
        int count = 1;
        int index = 0;
        if (n < 1) return arr;
        for (int i = n; i <= arr.length; i += n) {
            int j = i - 1;
            for (int k = 0; k < count; k++) {
                for (; j >= 0; ) {
                    arr[j] = ++index;
                    break;
                }
                j--;
            }
            count++;
            index = 0;
        }
        return arr;
    }

    public int[] squareUp(int n) {
        int[] arr = new int[n * n];

        if (n == 0)
            return arr;

        for (int i = n - 1; i < arr.length; i += n) {
            for (int j = i; j >= i - i / n; j--)
                arr[j] = i - j + 1;
        }

        return arr;
    }

    @Test
    public void squareUp() {
        System.out.println(squareUp(4));
    }

    public int[] seriesUp1(int n) {
        int[] arr = new int[n * (n + 1) / 2];
        int count = 1;
        int num = 0;
        for (int i = 0; i < arr.length; i += count - 1) {
            int k = 0;
            for (int j = i; j < arr.length; j++) {
                for (; k < count; ) {
                    arr[j] = ++num;
                    break;
                }
                k++;
            }
            count++;
            num = 0;
        }
        return arr;
    }

    public int[] seriesUp(int n) {
        int[] arr = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[index + j] = j + 1;
            }
            index += i;
        }
        return arr;
    }

    @Test
    public void seriesUp() {
        System.out.println(seriesUp(3));
    }

    public int maxMirror1(int[] nums) {
        int count = 0;
        int maxCount = 0;
        int j = nums.length - 1;
        for (int i = 0; i <= nums.length / 2; i++) {
            if (j <= nums.length / 2) {
                j = nums.length - 1;
                count = 0;
            }
            for (; j >= nums.length / 2; ) {
                if (i == j - 1 && nums[i] == nums[j]) {
                    count += 2;
                    break;
                }
                if (nums[i] == nums[j] && i + 2 == j) {
                    if (count == 0) return 3;
                    else return count * 2 + 3;
                }
                if (nums[i] == nums[j]) {
                    count++;
                    j--;
                    break;
                } else {
                    if (j == nums.length / 2 && count != 0) {
                        j = nums.length - 1;
                        count = 0;
                    } else {
                        count = 0;
                        j--;
                    }
                }
            }
            if (count > maxCount)
                maxCount = count;
        }
        return maxCount;
    }

    public int maxMirror(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
                if (nums[i + count] == nums[j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }

    @Test
    public void maxMirror() {
        int[] arr = {9, 1, 1, 4, 2, 1, 1, 1};
        System.out.println(maxMirror(arr));
    }

    public int countClumps1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[i] == nums[j + 1]) {
                        i++;
                    } else break;
                }
            }
        }
        return count;
    }

    public int countClumps(int[] nums) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            int val = nums[i];
            i++;
            int length = 1;
            while (i < nums.length && nums[i] == val) {
                i++;
                length++;
            }

            if (length > 1)
                count++;
        }

        return count;
    }

    @Test
    public void countClumps() {
        int[] arr = {2, 2, 1, 1, 1, 2, 1, 1, 2, 2};
        System.out.println(countClumps(arr));
    }


    public boolean scoresClump1(int[] scores) {
        for (int i = 1; i < scores.length - 1; i++) {
            if (scores[i] - scores[i - 1] <= 2
                    && scores[i + 1] - scores[i] <= 2
                    && scores[i + 1] - scores[i - 1] <= 2) {
                return true;
            }
        }
        return false;
    }


    public boolean scoresClump(int[] scores) {
        int count = 0;
        int temp = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] - scores[i - 1] <= 2) {
                if (i > 1 && scores[i] - temp <= 2) count++;
                else count += 2;
            }
            temp = scores[i - 1];
        }
        if (count >= 3) return true;
        else return false;
    }

    @Test
    public void scoresClump() {
        int[] arr = {3, 4, 5};
        System.out.println(scoresClump(arr));
    }

    public int scoresAverage(int[] scores) {
        int first = average(scores, 0, scores.length / 2);
        int second = average(scores, scores.length / 2, scores.length);

        if (first > second) return first;
        else return second;
    }

    int average(int[] scores, int start, int end) {
        int sum = 0;
        int count = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
            count++;
        }
        return sum / count;
    }

    @Test
    public void scoresAverage() {
        int[] arr = {2, 2, 4, 4};
        System.out.println(scoresAverage(arr));
    }

    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == len) count++;
        }
        return count;
    }

    public String[] wordsFront(String[] words, int n) {
        String[] str = new String[n];

        for (int i = 0; i < words.length; i++) {
            if (n > 0) str[i] = words[i];
            n--;
        }
        return str;
    }

    @Test
    public void wordsFront() {
        String[] arr = {"a", "b", "c", "d"};
        System.out.println(wordsFront(arr, 1));
    }

    public List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != len) list.add(words[i]);
        }
        return list;
    }

    public boolean hasOne(int n) {
        while (n != 0) {
            if (n % 10 == 1)
                return true;
            n /= 10;
        }
        return false;
    }

    public boolean dividesSelf(int n) {
        int i = n;
        int temp = 0;
        boolean flag = false;
        while (i != 0) {
            temp = i % 10;
            if (temp != 0 && n % temp == 0)
                flag = true;
            else return false;
            i /= 10;
        }
        return flag;
    }

    @Test
    public void dividesSelf() {
        System.out.println(dividesSelf(32));
    }

    public int[] copyEvens(int[] nums, int count) {
        int[] arr = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count != 0 && nums[i] % 2 == 0) {
                arr[index++] = nums[i];
                count--;
            }
        }
        return arr;
    }

    @Test
    public void copyEvens() {
        int[] arr = {3, 2, 4, 5, 8};
        System.out.println(copyEvens(arr, 2));
    }

    public int[] copyEndy(int[] nums, int count) {
        int[] arr = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < count) {
                if (isEndy(nums[i])) {
                    arr[index++] = nums[i];
                }
            }
        }
        return arr;
    }

    public boolean isEndy(int n) {
        if (n >= 0 && n <= 10 || n >= 90 && n <= 100)
            return true;
        return false;
    }

    @Test
    public void copyEndy() {
        int[] arr = {12, 11, 10, 89, 101, 4};
        System.out.println(copyEndy(arr, 1));
    }

    public int matchUp(String[] a, String[] b) {
        int count = 0;
        int i = 0;
        while (i < a.length) {
            if (!b[i].isEmpty() && !a[i].isEmpty() && b[i].substring(0, 1).equals(a[i].substring(0, 1))) {
                count++;
            }
            i++;
        }
        return count;
    }

    @Test
    public void matchUp1() {
        String[] arr = {"aa", "bb", "cc"};
        String[] arr2 = {"aaa", "xx", "bb"};
        System.out.println(matchUp(arr, arr2));
    }

    public int scoreUp(String[] key, String[] answers) {
        int count = 0;
        for (int i = 0; i < key.length; i++) {
            if (!answers[i].isEmpty() &&
                    answers[i].equals(key[i])) {
                count += 4;
            } else if (answers[i].equals("?") || answers[i].isEmpty()) {
                count += 0;
            } else {
                count -= 1;
            }
        }
        return count;
    }


    @Test
    public void scoreUp() {
        String[] arr = {"a", "a", "b", "b"};
        String[] arr2 = {"?", "c", "?", "?"};
        System.out.println(scoreUp(arr, arr2));
    }


    public int scoresSpecial(int[] a, int[] b) {
        return largestSpecialScore(a) + largestSpecialScore(b);
    }

    public int largestSpecialScore(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 10 == 0 && array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) == 0) {
            if (aId == bId) return 0;
            else if (aId > bId) return 1;
            else return -1;
        } else if (aName.compareTo(bName) > 0) return 1;
        else return -1;
    }

    @Test
    public void userCompare() {
        System.out.println(userCompare("bb", 5, "bb", 1));
    }


    public String[] mergeTwo1(String[] a, String[] b, int n) {
        String[] array = new String[n];
        String temp= "";
        for (int i = 0; i < n; i++) {
            if (temp != "" && !isDouble(array, temp) && a[i].compareTo(temp) > 0) {
                array[i] = temp;
            } else if (temp != "" && !isDouble(array, temp) &&  b[i].compareTo(temp) > 0) {
                array[i] = temp;
            } else {
                if (a[i].compareTo(b[i]) == 0) {
                    array[i] = a[i];
                } else if (a[i].compareTo(b[i]) > 0) {
                    array[i] = b[i];
                    temp = a[i];
                } else {
                    array[i] = a[i];
                    temp = b[i];
                }
            }
        }
        return array;
    }

    public String[] mergeTwo2(String[] a, String[] b, int n) {
        String[] array = new String[n];
        int index = 0;
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            for ( ; j < b.length; ) {
                if (a[i].compareTo(b[j]) == 0) {
                    array[index++] = a[j];
                    j++;
                    break;
                } else if (a[i].compareTo(b[i]) > 0) {
                    array[index++] = b[j];
                    j++;
                    break;
                } else {
                    array[index++] = a[j];
                    j++;
                    break;
                }
            }
        }
        return array;
    }

    public String[] mergeTwoMy(String[] a, String[] b, int n) {
        String[] array = new String[n];
        String temp = "";
        for (int i = 0; i < n; i++) {
            if (a[i].compareTo(b[i]) > 0) {
                if (temp != "" && !isDouble(array, temp) && temp.compareTo(b[i]) < 0) {
                    array[i] = temp;
                    if (b[i].compareTo(temp) < 0 || isDouble(array, temp)) {
                        temp = b[i];
                    }
                } else {
                    array[i] = b[i];
                    if (temp == "" || a[i].compareTo(temp) < 0 || isDouble(array, temp)) {
                        temp = a[i];
                    }
                }
            } else {
                if (temp != "" && !isDouble(array, temp) && temp.compareTo(a[i]) < 0) {
                    array[i] = temp;
                    if (a[i].compareTo(temp) < 0 || isDouble(array, temp)) {
                        temp = a[i];
                    }
                } else {
                    array[i] = a[i];
                    if (temp == "" || b[i].compareTo(temp) < 0 || isDouble(array, temp)) {
                        temp = b[i];
                    }
                }
            }
        }
        return array;
    }

    public boolean isDouble(String[] array, String str) {
        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i])) return true;
        }
        return false;
    }

    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] arr = new String[n];
        int aIndex = 0;
        int bIndex = 0;

        for(int index = 0; index < n; index++) {
            if(a[aIndex].compareTo(b[bIndex]) < 0) {
                arr[index] = a[aIndex];
                aIndex++;
            } else if(a[aIndex].compareTo(b[bIndex]) > 0) {
                arr[index] = b[bIndex];
                bIndex++;
            } else {
                arr[index] = a[aIndex];
                aIndex++;
                bIndex++;
            }
        }

        return arr;
    }

    @Test
    public void mergeTwo() {
        String[] arr = {"a", "c", "z"};
        String[] arr2 = {"b", "f", "z"};
        System.out.println(mergeTwo(arr, arr2, 3));
    }

    public int commonTwo(String[] a, String[] b) {
        int count = 0;
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < a.length && bIndex < b.length) {
            while (aIndex > 0 && aIndex < a.length && a[aIndex].equals(a[aIndex - 1])) {
                aIndex++;
            }
            while (bIndex > 0 && bIndex < b.length && b[bIndex].equals(b[bIndex - 1])) {
                bIndex++;
            }
            if (aIndex < a.length && bIndex < b.length && a[aIndex].compareTo(b[bIndex]) < 0) {
                aIndex++;
            } else if (aIndex < a.length && bIndex < b.length && a[aIndex].compareTo(b[bIndex]) > 0) {
                bIndex++;
            } else if (aIndex < a.length && bIndex < b.length){
                count++;
                aIndex++;
                bIndex++;
            }
        }
        return count;
    }


    @Test
    public void commonTwo2() {
        String[] arr = {"a", "a", "b", "b", "c"};
        String[] arr2 = {"b", "b", "b"};
        System.out.println(commonTwo2(arr, arr2));
    }

    public int commonTwo2(String[] a, String[] b) {
        int count = 0;
        int aIndex = 0;
        int bIndex = 0;

        if (a[0].equals(b[0])) {
            count++;
            aIndex++;
            bIndex++;
        } else if (a[0].compareTo(b[0]) < 0) {
            aIndex++;
        } else {
            bIndex++;
        }

        while (aIndex < a.length && bIndex < b.length) {
            if (aIndex > 0 && a[aIndex - 1].equals((a[aIndex]))) {
                aIndex++;
            } else if (a[aIndex].equals(b[bIndex])) {
                count++;
                aIndex++;
                bIndex++;
            } else if (a[aIndex].compareTo(b[bIndex]) < 0) {
                aIndex++;
            } else {
                bIndex++;
            }
        }
        return count;
    }

    public int sumHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            count += Math.abs(heights[i + 1] - heights[i]);
        }
        return count;
    }

    @Test
    public void sumHeights() {
        int[] arr = {5, 3, 6, 7, 2};
        System.out.println(sumHeights(arr, 2, 4));
    }

    public int sumHeights2(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (heights[i + 1] > heights[i]) {
                count += Math.abs(heights[i + 1] - heights[i]) * 2;
            } else {
                count += Math.abs(heights[i + 1] - heights[i]);
            }
        }
        return count;
    }

    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (Math.abs(heights[i + 1] - heights[i]) >= 5) {
                count++;
            }
        }
        return count;
    }

    public int factorial(int n) {
        int result = 0;
        if (n == 1) {
            return 1;
        } else {
            result = factorial(n - 1) * n;
        }
        return result;
    }

    public int bunnyEars2(int bunnies) {
        if (bunnies < 1) return bunnies;
        if (bunnies % 2 == 0) return 3 + bunnyEars2(bunnies - 1);
        return 2 + bunnyEars2(bunnies - 1);
    }

    @Test
    public void bunnyEars2() {
        System.out.println(bunnyEars2(2));
    }

    public int sumDigits(int n) {
        if (n / 10 == 0) return n;
        return n % 10 + sumDigits(n / 10);
    }

    public int count7(int n) {
        if (n == 0) return 0;
        if (n % 10 == 7)
            return 1 + count7(n / 10);
        return count7(n / 10);
    }

    @Test
    public void count7() {
        System.out.println(count7(717));
    }

    public int count8(int n) {
        if (n == 0) return 0;
        if (n % 10 == 8) {
            if ((n / 10) % 10 == 8) {
                return 2 + count8(n / 10);
            }
            return 1 + count8(n / 10);
        } else {
            return count8(n / 10);
        }
    }

    @Test
    public void count8() {
        System.out.println(count8(8818));
    }

    public int powerN(int base, int n) {
        if (n == 1) return 1;
        return base * powerN(base, n - 1);
    }

    public int countX(String str) {
        if (str.length() == 0) return 0;
        if (str.substring(str.length() - 1, str.length()).equals("x"))
            return 1 + countX(str.substring(0, str.length() - 1));
        return countX(str.substring(0, str.length() - 1));
    }

    @Test
    public void countX() {
        System.out.println(countX("xxhixx"));
    }

    public int countHi(String str) {
        if (str.length() <= 1) return 0;
        if (str.substring(str.length() - 2, str.length()).equals("hi"))
            return 1 + countHi(str.substring(0, str.length() - 1));
        return countHi(str.substring(0, str.length() - 1));
    }

    @Test
    public void countHi() {
        System.out.println(countHi(""));
    }

    public String changeXY(String str) {
        if (str.length() == 0) return str;
        if(str.charAt(0) == 'x')
            return 'y' + changeXY(str.substring(1));
        return str.charAt(0) + changeXY(str.substring(1));
    }

    @Test
    public void changeXY() {
        System.out.println(changeXY("codex"));
    }

    public String changePi(String str) {
        if (str.length() <= 1) return str;
        if (str.substring(0, 2).equals("pi"))
            return "3.14" + changePi(str.substring(2));
        return str.substring(0, 1) + changePi(str.substring(1));
    }

    @Test
    public void changePi() {
        System.out.println(changePi("xpix"));
    }

    public String noX(String str) {
        if (str.length() == 0) return str;
        if (str.charAt(0) == 'x')
            return noX(str.substring(1));
        return str.charAt(0) + noX(str.substring(1));
    }

    @Test
    public void noX() {
        System.out.println(noX("xaxb"));
    }

    public boolean array6My(int[] nums, int index) {
        if (nums.length == 0) return false;
        if (index == nums.length - 1 && nums[index] == 6) return true;
        if (index == nums.length - 1) return false;
        if (nums[index] == 6)
            return true;
        return array6(nums, ++index);
    }

    public boolean array6(int[] nums, int index) {
        if(index >= nums.length)
            return false;

        return nums[index] == 6 || array6(nums, index + 1);
    }

    @Test
    public void array6() {
        int[] arr = {6};
        System.out.println(array6(arr, 0));
    }

    public int array11(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (nums[index] == 11)
            return 1 + array11(nums, ++index);
        return array11(nums, ++index);
    }

    @Test
    public void array11() {
        int[] arr = {1, 2, 11};
        System.out.println(array11(arr, 0));
    }

    public boolean array220My(int[] nums, int index) {
        if (index  >= nums.length) return false;
        if (nums[index] % 10 == 0)
            return true;
        return array220(nums, ++index);
    }

    public boolean array220(int[] nums, int index) {
        if(index >= nums.length - 1)
            return false;
        return nums[index + 1] == 10 * nums[index] || array220(nums, index + 1);
    }

    @Test
    public void array220() {
        int[] arr = {20, 2, 21};
        System.out.println(array220(arr, 0));
    }

    public String allStar(String str) {
        if (str.length() <= 1) return str;
        return str.substring(0, 1) + "*" + allStar(str.substring(1));
    }

    @Test
    public void allStar() {
        System.out.println(allStar("hello"));
    }


    public String pairStar(String str) {
        if (str.length() <= 1) return str;
        if (str.substring(0, 1).equals(str.substring(1, 2)))
            return str.substring(0, 1) + "*" + pairStar(str.substring(1));
        return str.substring(0, 1) + pairStar(str.substring(1));
     }

    @Test
    public void pairStar() {
        System.out.println(pairStar("hello"));
    }

    public String endX(String str) {
        if (str.length() <= 1) return str;
        if (str.substring(0, 1).equals("x"))
            return endX(str.substring(1)) + str.substring(0, 1);
        return str.substring(0, 1) + endX(str.substring(1));
    }

    @Test
    public void endX() {
        System.out.println(endX("xxre"));
    }

    public int countAbc(String str) {
        if (str.length() < 3) return 0;
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba"))
            return 1 + countAbc(str.substring(1));
        return countAbc(str.substring(1));
    }

    @Test
    public void countAbc() {
        System.out.println(countAbc("ababc"));
    }

    public int count11(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("11"))
            return 1 + count11(str.substring(2));
        return count11(str.substring(1));
    }

    @Test
    public void count11() {
        System.out.println(count11("111"));
    }

    public String stringClean(String str) {
        if (str.length() <= 2) return str;
        if (str.substring(0, 1).equals(str.substring(1, 2)))
            return str.substring(0, 1) + stringClean(str.substring(2));
        return stringClean(str.substring(1));
    }

    @Test
    public void stringClean() {
        System.out.println(stringClean("111"));
    }


    public int countHi2(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0,1).equals("x") && str.substring(1, 2).equals("x"))
            return countHi2(str.substring(3));
        if (str.substring(0, 1).equals("x"))
            return countHi2(str.substring(2));
        if (str.substring(0, 2).equals("hi"))
            return 1 + countHi2(str.substring(2));
        return countHi2(str.substring(1));
    }

    @Test
    public void countHi2() {
        System.out.println(countHi2("xxhi"));
    }

    public String parenBit(String str) {

        if (str.substring(0, 1).equals("(")
                && str.substring(str.length() - 1, str.length()).equals(")")) {
            return str;
        }
        if (str.substring(0, 1).equals("(")) {
            return parenBit(str.substring(0, str.length() - 1));
        }

        return parenBit(str.substring(1));
    }

    @Test
    public void parenBit() {
        System.out.println(parenBit("xyz(abc)123"));
    }

    public boolean strCopies(String str, String sub, int n) {
        if (str.length() < sub.length() && n != 0) return false;
        if (n == 0) return true;
        if (str.substring(0, sub.length()).equals(sub))
            return strCopies(str.substring(1), sub, --n);
        return strCopies(str.substring(1), sub, n);
    }

    @Test
    public void strCopies() {
        System.out.println(strCopies("iiijjj", "ii", 2));
    }

    public int strDist(String str, String sub) {
        if (str.length() < sub.length()) return 0;
        if (str.substring(0, sub.length()).equals(sub) &&
                str.substring(str.length() - sub.length(), str.length()).equals(sub))
            return str.length();
        if (str.substring(0, sub.length()).equals(sub))
            return strDist(str.substring(0, str.length() - 1), sub);
        return strDist(str.substring(1), sub);
    }

    @Test
    public void strDist() {
        System.out.println(strDist("cccatcowcatxx", "cat"));
    }

    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }


    public List<Integer> square(List<Integer> nums) {
        nums.replaceAll(n -> n * n);
        return nums;
    }

    public List<String> addStar(List<String> strings) {
        strings.replaceAll(n -> n + "*");
        return strings;
    }

    public List<String> copies3(List<String> strings) {
        strings.replaceAll(n -> n += n + n);
        return strings;
    }

    public List<String> moreY(List<String> strings) {
        strings.replaceAll(n -> "y" + n + "y");
        return strings;
    }

    public List<Integer> math1(List<Integer> nums) {
        nums.replaceAll(n -> (n + 1) * 10);
        return nums;
    }

    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }

    public List<String> lower(List<String> strings) {
        strings.replaceAll(n -> n.toLowerCase());
        return strings;
    }

    public List<String> noX1(List<String> strings) {
        strings.replaceAll(n -> n.replaceAll("x", ""));
        return strings;
    }

    public List<String> noX2(List<String> strings) {
        return strings.stream()
                .map(s -> s.replaceAll("x",""))
                .collect(Collectors.toList());
    }

    @Test
    public void noX1() {
        List<String> strings = new ArrayList<>();
        strings.add("ax");
        strings.add("bb");
        strings.add("cx");
        System.out.println(noX1(strings));
    }

    public List<Integer> noNeg(List<Integer> nums) {
        nums.removeIf(n -> n < 0);
        return nums;
    }

    public List<Integer> no9(List<Integer> nums) {
        nums.removeIf(n -> n % 10 == 9);
        return nums;
    }

    public List<Integer> noTeen(List<Integer> nums) {
        nums.removeIf(n -> n >= 13 && n <= 19);
        return nums;
    }

    public List<String> noLong(List<String> strings) {
        strings.removeIf(n -> n.length() >= 4);
        return strings;
    }

    public List<String> noZ(List<String> strings) {
        strings.removeIf(n -> n.contains("z"));
        return strings;
    }

    public List<String> no34(List<String> strings) {
        strings.removeIf(n -> n.length() >= 3 && n.length() <= 4);
        return strings;
    }

    public List<String> noYY(List<String> strings) {
        return strings.stream()
                .map(n -> n + "y")
                .filter(n -> !n.contains("yy"))
                .collect(Collectors.toList());
    }

    public List<Integer> two2(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * 2)
                .filter(n -> !(n % 10 == 2))
                .collect(Collectors.toList());
    }

    public List<Integer> square56(List<Integer> nums) {
        return nums.stream()
                .map(n -> (n * n) + 10)
                .filter(n -> n % 10 != 5 && n % 10 != 6)
                .collect(Collectors.toList());
    }

    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
            map.put("a", "");
        }
        return map;
    }

    public Map<String, String> mapShare(Map<String, String> map) {
        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
        }
        if (map.containsKey("c")) {
            map.remove("c");
        }
        return map;
    }

    public Map<String, String> mapAB(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            map.put("ab", map.get("a") + map.get("b"));
        }
        return map;
    }

    public Map<String, String> topping1(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }

        map.put("bread", "butter");

        return map;
    }

    public Map<String, String> topping2(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("yogurt", map.get("ice cream"));
        }
        if (map.containsKey("spinach"))
            map.put("spinach", "nuts");

        return map;
    }

    public Map<String, String> topping3(Map<String, String> map) {
        if (map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }
        if (map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }

    public Map<String, String> mapAB2(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b") &&
                map.get("a").equals(map.get("b"))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }

    public Map<String, String> mapAB3(Map<String, String> map) {
        if (map.containsKey("a") && !map.containsKey("b")) {
            map.put("b", map.get("a"));
        }

        if (map.containsKey("b") && !map.containsKey("a")) {
            map.put("a", map.get("b"));
        }
        return map;
    }

    public Map<String, String> mapAB4(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            if (map.get("a").length() > map.get("b").length()) {
                map.put("c", map.get("a"));
            } else if (map.get("b").length() > map.get("a").length()) {
                map.put("c", map.get("b"));
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        }
        return map;
    }

    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap();
        for (String str : strings) {
            map.put(str, 0);
        }
        return map;
    }

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings)
            map.put(str, str.length());
        return map;
    }


    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings)
            map.put(str.substring(0, 1), str.substring(str.length() - 1, str.length()));
        return map;
    }

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String str : strings) {
            if (!map.containsKey(str)) {
                for (int i = 0; i < strings.length; i++) {
                    if (str.equals(strings[i])) {
                        count++;
                    }
                }
                map.put(str, count);
                count = 0;
            }
        }
        return map;
    }

    @Test
    public void wordCount() {
        String[] arr = {"a", "b", "a", "c", "b"};
        System.out.println(wordCount(arr));
    }

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        int count = 0;
        for (String str : strings) {
            String word = str;
            count++;
            for (int i = count; i < strings.length; i++) {
                if (str.substring(0, 1).equals(strings[i].substring(0, 1))
                        && !map.containsKey(str.substring(0, 1))) {
                    word += strings[i];
                }
            }
            if (word.equals(str) && !map.containsKey(str.substring(0, 1))) {
                map.put(str.substring(0, 1), str);
            }

            if ( !map.containsKey(str.substring(0, 1))) {
                map.put(str.substring(0, 1), word);
            }
        }
        return map;
    }

    @Test
    public void firstChar() {
        String[] arr = {"apple", "bells", "salt", "aardvark", "bells", "sun", "zen", "bells"};
        System.out.println(firstChar(arr));
    }

    public String wordAppend1(String[] strings) {
        String string = "";
        int count = 0;
        int index = 0;
        for (String str : strings) {
            for (int i = index; i < strings.length; i += 2) {
                if (str.equals(strings[i])) {
                    count++;
                }
             }
            for (int i = 0; i < count / 2; i++) {
                string += str;
                index++;
            }
            count = 0;
        }
        return string;
    }

    @Test
    public void wordAppend() {
        String[] arr = {"not", "and", "or", "and", "this", "and", "or", "that", "not"};
        System.out.println(wordAppend(arr));
    }

    public String wordAppend(String[] strings) {
        String result = "";
        Map<String, Integer> map = new HashMap<>();

        for (String currentString : strings) {
            int i = 0;
            if (map.containsKey(currentString)) {
                i = map.get(currentString) + 1;
                map.put(currentString, i);
                if (i % 2 == 0) {
                    result = result + currentString;
                }
            } else {
                map.put(currentString, i + 1);
            }
        }

        return result;
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str : strings) {
            int count = 0;
            if (!map.containsKey(str)) {
                for (int i = 0; i < strings.length; i++) {
                    if (str.equals(strings[i])) {
                        count++;
                    }
                }
                if (count > 0) {
                    map.put(str, true);
                } else {
                    map.put(str, false);
                }
            }
        }
        return map;
    }

    public String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i].substring(0, 1))) {
                String temp = strings[i];
                strings[i] = strings[map.get(strings[i].substring(0, 1))];
                strings[map.get(strings[i].substring(0, 1))] = temp;
                map.remove(strings[i].substring(0, 1));
            } else {
                map.put(strings[i].substring(0, 1), i);
            }
        }
        return strings;
    }

    public String[] firstSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Boolean> disabledMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i].substring(0, 1))
                    && disabledMap.get(strings[i].substring(0, 1)).equals(false)) {
                String temp = strings[i];
                strings[i] = strings[map.get(strings[i].substring(0, 1))];
                strings[map.get(strings[i].substring(0, 1))] = temp;
                disabledMap.put(strings[i].substring(0, 1), true);
            } else {
                map.put(strings[i].substring(0, 1), i);
                if (!disabledMap.containsKey(strings[i].substring(0, 1)))
                    disabledMap.put(strings[i].substring(0, 1), false);
            }
        }
        return strings;
    }

    @Test
    public void firstSwap() {
        String[] arr = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
        System.out.println(firstSwap(arr));
    }

    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        if (groupSum(start + 1, nums, target - nums[start])) return true;
        if (groupSum(start + 1, nums, target)) return true;
        return false;
    }

    @Test
    public void groupSum() {
        int[] arr = {2, 4, 8};
        System.out.println(groupSum(0, arr, 10));
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);
        if (nums[start] == 6)
            return groupSum6(start + 1, nums, target - 6);
        if (groupSum6(start + 1, nums, target - nums[start])) return true;
        if (groupSum6(start + 1, nums, target)) return true;
        return false;
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        if (groupNoAdj(start + 2, nums, target - nums[start]))
            return true;
        if (groupNoAdj(start + 1, nums, target))
            return true;
        return false;
    }

    @Test
    public void groupNoAdj() {
        int[] arr = {2, 5, 10, 4};
        System.out.println(groupNoAdj(0, arr, 14));
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        if (nums[start] % 5 == 0) {
            if (start + 1 <= nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            } else {
                return groupSum5(start + 1, nums, target - nums[start]);
            }
        }
        if (groupSum5(start + 1, nums, target - nums[start])) return true;
        if (groupSum5(start + 1, nums, target)) return true;
        return false;
    }

    @Test
    public void groupSum5() {
        int[] arr = {2, 5, 10, 4};
        System.out.println(groupSum5(0, arr, 7));
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length) return target == 0;

        int i = start;
        int sum = 0;

        while(i < nums.length && nums[start] == nums[i]) {
            sum += nums[i];
            i++;
        }

        if(groupSumClump(i, nums, target - sum))
            return true;

        if(groupSumClump(i, nums, target))
            return true;

        return false;
    }

    public boolean groupSumClump1(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (nums[i] == nums[i + 1]) {
                map.put(nums[i], 1);
            }
        }

        if(map.containsKey(nums[start])) {
            if (groupSumClump(start + 1, nums, target - nums[start])) return true;
        }
        if (groupSumClump(start + 1, nums, target)) return true;
        return false;
    }

    @Test
    public void groupSumClump() {
        int[] arr = {8, 2, 2, 1};
        System.out.println(groupSumClump(0, arr, 9));
    }

    public boolean splitArray(int[] nums) {
        return recursiveHelper(0, nums, 0, 0);
    }

    private boolean recursiveHelper(int start, int[] nums, int group1, int group2) {
        if (start >= nums.length) return group1 == group2;
        if (recursiveHelper(start + 1, nums, group1 + nums[start], group2))
            return true;
        if(recursiveHelper(start + 1, nums, group1, group2 + nums[start]))
            return true;
        return false;
    }

    public boolean splitOdd10(int[] nums) {
        return recursiveHelper10(0, nums, 0, 0);
    }

    private boolean recursiveHelper10(int start, int[] nums, int group1, int group2) {
        if (start >= nums.length) return group1 % 10 == 0 && group2 % 2 != 0;
        if (recursiveHelper10(start + 1, nums, group1 + nums[start], group2))
            return true;
        if (recursiveHelper10(start + 1, nums, group1, group2 + nums[start]))
            return true;
        return false;
    }

    @Test
    public void splitArray() {
        int[] arr = {5, 2, 3};
        System.out.println(splitArray(arr));
    }

    public boolean split53(int[] nums) {
        return recursiveHelper53(0, nums, 0, 0);
    }

    private boolean recursiveHelper53(int start, int[] nums, int group1, int group2) {
        if (start >= nums.length) return group1 == group2;
        if (nums[start] % 5 == 0) {
            return (recursiveHelper53(start + 1, nums, group1 + nums[start], group2));
        }
        if (nums[start] % 3 == 0) {
            return (recursiveHelper53(start + 1, nums, group1, group2 + nums[start]));
        }

        if (recursiveHelper53(start + 1, nums, group1 + nums[start], group2))
            return true;
        if (recursiveHelper53(start + 1, nums, group1, group2 + nums[start]))
            return true;
        return false;
    }

    @Test
    public void split53() {
        int[] arr = {3, 5, 8};
        System.out.println(split53(arr));
    }



}





