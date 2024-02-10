package com.company.leetcode;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                result += isPalindrom(s.substring(i, j + 1)) ? 1 : 0;
            }
        }
        return result;
    }
    
    private static boolean isPalindrom(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("tlthpowwythupxaszmxhqbfbxegiqzdxzesppfjgycyprjyscubntihrfwbeebqgeclzdccxwxezasfzclndmnfjjqoplbxuygtopqtnpatixyydboldybmdoyfwkevwgxmsrdkwjiyoksilsorcbotqitujdaavjbvrjjwtnimpldrnkfuftxnhzfiwzkhslzolbfmdkqhulpjxmbmzqhawiztcbbaggcccttokwkznsctemmdgutldvpybalridbjmupbjijmexzjuvdfntqxuvdoijbbmbpwhbtdbxlhrvbxrfcoyjbrfsowdamohdsoojivwgoopfjwzdjhlzelkdxpsrkfdkjktptahoeanuuuujdybotiitmttzpnbyrxtjetxhydhlvlsmveddtvaobbvdkwxzoyugojhoapbaghgcanazkpauaorgjluszsezbnaqjxtvoxfitnpwsmywlxdimemymuyehyabrpedfkgrwtgyjvzkvahcbekqsofcvseswvtdixaxrjwjinvrruoskqlxcnxrvaqvsnpxdwjpjaupdyfaaxqsnrcrmkmzmtnndniqxglucqwargfzzqwxvaopxwafbzuifptayzoedznsljslpaoytiqnnlxeegbebslvbbsfoqlbokxakkaxdqyttxkdermidtoxjnjwibnlrsuvdkfcvoeagzpsogmcoeihbvyvjcdirnbbpqhdgoirclqapqzsvuesezbhdjoumxwhtwwnxnwyrnyhpaeqzbirnqxsufritrjkgbftmnjwpoakrzokpopwmwjsimwkvblwplsammgwonxrdkfbongodjnvadspxuvcyxlwvwhonvagznjsslbfayoxpqwrizxdhwgskewymhdlurtbekqsmghgzufkmsvrchskdoudtllfflromzwwahigprsrydcsyionczumedayyvldefctkuzafmwsvbifaxzyqywhzpqbeun"));
    }
}
