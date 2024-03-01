package com.company.ibm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/maximum-items-that-can-be-bought-from-the-cost-array-based-on-given-conditions/

public class ShoppingCard {
    public static int findMaxDistinctItems(int n, int k, List<Integer> arr) {
        Collections.sort(arr);

        int m = n - arr.size();
        
        int[] pre = new int[arr.size()];
        pre[0] = arr.get(0);

        int result = 0;

        if (pre[0] <= k) {
            result = 1;
        }
        
        for (int i = 1; i < m - 1; i++) {
            pre[i] = pre[i - 1] + arr.get(i);
            
            if (pre[i] <= k) {
                result = i + 1;
            }
        }
        
        pre[m - 1] = arr.get(m - 1);
        
        for (int i = m - 1; i < arr.size(); i++) {
            if (i >= m) {
                pre[i] += pre[i - m] + arr.get(i);
            }
            
            if (pre[i] <= k) {
                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMaxDistinctItems(10, 10, Arrays.asList(1, 3, 8)));
    }

}
