package com.company.TopCoder;
/*
    You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:

    The string has exactly N characters, each of which is either 'A' or 'B'.
    The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
    If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
*/


import java.util.Arrays;

public class AB{
    boolean findRes = false;
    public String createString(int N, int K){
        char AB [] = new char[N];
        // for each potential number of B
        for(int nB = 0;nB<N;nB++) // number of B
            helper(AB,0,  nB, K);
        return findRes? new String(AB) : "";

    }
    private void helper(char[] AB, int start,  int nB, int K){
        int N = AB.length;
        if(findRes==true)
            return;
        if(K<0 || nB<0|| nB > (N-start))
            return;
        if(K==0 && nB == N-start){
            Arrays.fill(AB,start, N, 'B');
            findRes = true;
            return;
        }
        // try to fillin one position at AB[start]
        AB[start] = 'A';
        helper(AB,start+1,nB, K-nB);
        AB[start] = 'B';
        helper(AB,start+1,nB-1, K);
    }
}
