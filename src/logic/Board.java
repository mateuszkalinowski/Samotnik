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
    public void reset() {
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
    public boolean[] possibleDirections(int x,int y) {
        boolean result[] = new boolean[4];
        result[0]=false;
        result[1]=false;
        result[2]=false;
        result[3]=false;
        try {
            if(board[x][y-2]==0 && board[x][y-1]==1 && board[x][y]==1)
                result[0]=true;
        } catch (ArrayIndexOutOfBoundsException e) {
           result[0]=false;
        }
        try {
            if(board[x+2][y]==0 && board[x+1][y]==1 && board[x][y]==1)
                result[1]=true;
        } catch (ArrayIndexOutOfBoundsException e) {
            result[1]=false;
        }
        try {
            if(board[x][y+2]==0 && board[x][y+1]==1 && board[x][y]==1)
                result[2]=true;
        } catch (ArrayIndexOutOfBoundsException e) {
            result[2]=false;
        }
        try {
            if(board[x-2][y]==0 && board[x-1][y]==1 && board[x][y]==1)
                result[3]=true;
        } catch (ArrayIndexOutOfBoundsException e) {
            result[3]=false;
        }

        return result;
    }
    public boolean anyMoves() {
        for(int x = 0; x < width;x++){
            for(int y = 0; y < height;y++) {
                boolean moves[] = possibleDirections(x,y);
                if(moves[0] || moves[1] || moves[2] || moves[3])
                    return true;
            }
        }
        return false;
    }

    public int width;
    public int height;
    public int [][]board;

}
