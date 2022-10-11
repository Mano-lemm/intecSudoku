package be.sudoku.utils;

import java.util.ArrayList;
import java.util.HashSet;

public class Utils {
    private Utils(){};

    public static ArrayList<Short> allNums(){
        ArrayList<Short> r = new ArrayList<>();
        for (Short i = 0; i < 9; i++) {
            r.add((short) (i + 1));
        }
        return r;
    }

    public static Pair advanceIndex(int x, int y){
        Pair f = new Pair();
        if(x == 8){
            if(y == 8){
                return null;
            }
            f.x = 0;
            f.y = (short) (y + 1);
        } else {
            f.x = (short) (x + 1);
            f.y = (short) y;
        }
        return f;
    }

    private static ArrayList<Pair> rowAndColumn(int x, int y){
        ArrayList<Pair> r = new ArrayList<>();
        int xpassed = 0;
        int ypassed = 0;
        for (short i = 0; i < 9; i++) {
            if(i != x){
                r.add(i - xpassed, new Pair(i, (short) y));
            } else {
                xpassed = 1;
            }
            if(i != y){
                r.add(i - ypassed, new Pair((short) x, i));
            } else {
                ypassed = 1;
            }
        }
        return r;
    }

    private static Integer[] getSingleDimensionBox(int x){
        // TODO: refactor
        Integer[] r = new Integer[3];
        switch (x % 3) {
            case 0:
                r[0] = x;
                r[1] = x + 1;
                r[2] = x + 2;
                break;
            case 1: 
                r[0] = x - 1;
                r[1] = x;
                r[2] = x + 1;
                break;
            case 2:
                r[0] = x - 2;
                r[1] = x - 1;
                r[2] = x;
                break;
        }
        return r;
    }

    private static HashSet<Pair> box(int x, int y){
        HashSet<Pair> r = new HashSet<Pair>();
        Integer[] xbox = getSingleDimensionBox(x);
        Integer[] ybox = getSingleDimensionBox(y);
        for (int i = 0; i < xbox.length; i++) {
            for (int j = 0; j < ybox.length; j++) {
                if(!(xbox[i] == x && ybox[j] == y)){
                    r.add(new Pair((short) (int) xbox[i], (short) (int) ybox[j]));
                }
            }
        }
        return r;
    }

    public static ArrayList<Pair> relevantIndices(int x, int y){
        HashSet<Pair> rSet = new HashSet<Pair>();
        rSet.addAll(rowAndColumn(x, y));
        rSet.addAll(box(x, y));
        ArrayList<Pair> rA = new ArrayList<Pair>();
        rA.addAll(rSet);
        return rA;
    }
}
