package com.company.leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {

    static class RandomizedSet {
        private Set<Integer> set;

        public RandomizedSet() {
            this.set = new HashSet<>();
        }

        public boolean insert(int val) {
            return set.add(val);
        }

        public boolean remove(int val) {
            return set.remove(val);
        }

        public int getRandom() {
            int random = new Random().nextInt(set.size());
            int i = 0;
            for (Integer integer : set) {
                if (i == random)
                    return integer;
                i++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
//["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//[[],[1],[2],[2],[],[1],[2],[]]
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
    }

}
