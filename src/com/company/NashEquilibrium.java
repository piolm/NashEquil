package com.company;

import java.io.PrintStream;

public class NashEquilibrium {
    public static void print(int[][] matrix, PrintStream out) {
        for (int[] I : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                out.print(I[i] + "\t");
            }
            out.print('\n');
        }
    }

    public static void print(boolean[][] matrix, PrintStream out) {
        for (boolean[] B : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                out.print(B[i] + "\t");
            }
            out.print('\n');
        }
    }

    public static boolean[][] calc(int[][] forA, int[][] forB, boolean Min) {
        if (Min) {
            int[] minv = new int[forA.length];
            for (int i = 0; i < forA[0].length; i++) {
                int min = forA[0][i];
                for (int j = 1; j < forA.length; j++) {
                    if (forA[j][i] < min) {
                        min = forA[j][i];
                    }
                }
                minv[i] = min;
            }
            boolean[][] equilA = new boolean[forA.length][forA[0].length];
            for (int i = 0; i < forA[0].length; i++) {
                for (int j = 0; j < forA.length; j++) {
                    equilA[j][i] = (forA[j][i] == minv[i]);
                }
            }

            minv = new int[forB.length];
            for (int i = 0; i < forB.length; i++) {
                int min = forB[i][0];
                for (int j = 1; j < forB[0].length; j++) {
                    if(forB[i][j] < min) {
                        min = forB[i][j];
                    }
                }
                minv[i] = min;
            }

            boolean[][] res = new boolean[forB.length][forB[0].length];
            for (int i = 0; i < forB.length; i++) {
                for (int j = 0; j < forB[0].length; j++) {
                    res[i][j] = (forB[i][j] == minv[i]) && equilA[i][j];
                }
            }
            return res;
        }

        else {
            int[] maxv = new int[forA.length];
            for (int i = 0; i < forA[0].length; i++) {
                int max = forA[0][i];
                for (int j = 1; j < forA.length; j++) {
                    if (forA[j][i] > max) {
                        max = forA[j][i];
                    }
                }
                maxv[i] = max;
            }

            boolean[][] equilA = new boolean[forA.length][forA[0].length];
            for (int i = 0; i < forA[0].length; i++) {
                for (int j = 0; j < forA.length; j++) {
                    equilA[j][i] = (forA[j][i] == maxv[i]);
                }
            }

            maxv = new int[forB.length];
            for (int i = 0; i < forB.length; i++) {
                int max = forB[i][0];
                for (int j = 1; j < forB[0].length; j++) {
                    if(forB[i][j] > max) {
                        max = forB[i][j];
                    }
                }
                maxv[i] = max;
            }

            boolean[][] res = new boolean[forB.length][forB[0].length];
            for (int i = 0; i < forB.length; i++) {
                for (int j = 0; j < forB[0].length; j++) {
                    res[i][j] = (forB[i][j] == maxv[i]) && equilA[i][j];
                }
            }
            return res;
        }
    }
}