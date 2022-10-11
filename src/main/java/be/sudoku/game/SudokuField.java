package be.sudoku.game;

import be.sudoku.utils.Utils;
import be.sudoku.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class SudokuField {
    Short[][] field;
    Random rand;

    public SudokuField(){
        rand = new Random();
        generateNewField();
    }

    private Boolean generateField(int x, int y){
        ArrayList<Short> available = getAvailable(x, y);
        Collections.shuffle(available);
        Pair index = Utils.advanceIndex(x, y);
        for (Short shor : available) {
            field[x][y] = shor;
            if(index == null || generateField(index.x, index.y)){
                return true;
            }
        }
        field[x][y] = 0;
        return false;
    }

    private ArrayList<Short> getAvailable(int x, int y) {
        ArrayList<Short> nums = Utils.allNums();
        ArrayList<Pair> indices = Utils.relevantIndices(x, y);
        for (Pair i : indices) {
            if(nums.contains(field[i.x][i.y])){
                nums.remove(field[i.x][i.y]);
            }
        }
        return nums;
    }

    private void generateNewField() {
        field = new Short[9][9];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
        generateField(0, 0);
    }

    public void makePuzzle(int difficulty){
        HashSet<Pair> indices = new HashSet<>();
        while(indices.size() < difficulty){
            indices.add(new Pair((short) rand.nextInt(), (short) rand.nextInt()));
        }

        for (Pair pair : indices) {
            field[pair.x][pair.y] = 0;
        }
    }

    public Short getField(int x, int y){
        return field[x][y];
    }

    @Override
    public String toString() {
        String s = "";
        for (Short[] shorts : field) {
            for (Short shor : shorts) {
                s += shor;
            }
            s += "\n";
        }
        return s;
    }
}
