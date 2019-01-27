package blocks;

import java.util.Random;

public enum Block {

    I(new int[][]{
            {0, 0, 0, 0},
            {1, 1, 1, 1}}),
    O(new int[][]{
            {1, 1},
            {1, 1}}),
    T(new int[][]{
            {0, 1, 0},
            {1, 1, 1}}),
    S(new int[][]{
            {0, 1, 1},
            {1, 1, 0}}),
    Z(new int[][]{
            {1, 1, 0},
            {0, 1, 1}}),
    J(new int[][]{
            {1, 0, 0},
            {1, 1, 1}}),
    L(new int[][]{
            {0, 0, 1},
            {1, 1, 1}});

    int[][] gridFigure;

    Block(int[][] gridFigure){
        this.gridFigure = gridFigure;
    }

    public static Block random(){

        Random random = new Random();
        int blockIndex = random.nextInt(Block.values().length);

        return Block.values()[blockIndex];
    }

}
