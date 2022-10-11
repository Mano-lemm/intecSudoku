package be.sudoku.utils;

public class Pair implements Comparable<Pair>{
    public Short x, y;

    public Pair(){}

    public Pair(Short x, Short y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.x < o.y){
            return -1;
        }
        if(this.x == o.x){
            if(this.y < o.y){
                return -1;
            }
            if(this.y == o.y){
                return 0;
            }
            if(this.y > o.y){
                return 1;
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " : " + String.valueOf(y);
    }
}
