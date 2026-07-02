package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> listOfMaps = new ArrayList<>();
        Map<Integer, Map<Character, Integer>> columnMaps = new HashMap<>();
        Map<List<Integer>, Map<Character, Integer>> map3x3Maps = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            Map<Character, Integer> rowMap = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    rowMap.put(board[i][j], rowMap.getOrDefault(board[i][j], 0) + 1);

                    var columnMap = columnMaps.getOrDefault(j, new HashMap<>());
                    columnMap.put(board[i][j], columnMap.getOrDefault(board[i][j], 0) + 1);
                    columnMaps.put(j, columnMap);

                    List<Integer> pair = new ArrayList<>();
                    pair.add(i / 3);
                    pair.add(j / 3);

                    var map = map3x3Maps.getOrDefault(pair, new HashMap<>());
                    map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                    map3x3Maps.put(pair, map);
                }
                listOfMaps.add(rowMap);
            }
        }

        boolean rows = listOfMaps.stream()
                .flatMap(m -> m.values().stream())
                .anyMatch(e -> e > 1);

        boolean columns = columnMaps.values().stream()
                .flatMap(i -> i.values().stream())
                .anyMatch(e -> e > 1);

        boolean s3x3 = map3x3Maps.values().stream()
                .flatMap(i -> i.values().stream())
                .anyMatch(e -> e > 1);

        return !rows && !columns && !s3x3;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]
                {
                        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}

                }
        ));
    }
}
