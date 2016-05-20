package logic;

/**
 * Created by Mateusz on 20.05.2016.
 * Project InferenceEngine
 */
public class Board {
    public Board(int width,int height) {
        this.width = width;
        this.height = height;

        board = new int[width][height];
        for(int i = 0; i < width;i++)
            for(int j = 0; j < height;j++)
                board[i][j]=1;


    }

    public Board() {
        width = 7;
        height = 7;
        board = new int[width][height];
        for(int i = 0; i < width;i++)
            for(int j = 0; j < height;j++) {
                if((i<2 && j < 2)||(i>4 && j>4)||(i>4 && j<2) || (j>4 && i<2))
                    board[i][j] = 2;
                else
                    board[i][j]=1;
            }

        board[3][3] = 0;

    }

    public int width;
    public int height;
    public int [][]board;

}
