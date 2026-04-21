import java.util.ArrayList;
import java.util.Arrays;
public class MyProgram
{
    public static int[][] board = new int[9][9];
    public static void main(String[] args){
        initializeBoard();
        printBoard(board);
        
    }
    
    public static int[] getList() {
    int[] nums = new int[9];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }

        for (int i = 0; i < 9; i++) {
            int index = (int)(Math.random() * list.size());
            nums[i] = list.remove(index);
        }

        return nums;
    }
    
    
    public static boolean initializeBoard(){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    int[] nums = getList();
                    for (int i = 0; i < nums.length; i++) {
                        int num = nums[i];
                        if (isValid(row, col, num) == true) {
                            board[row][col] = num;
                            if (initializeBoard() == true) 
                                return true;
                            board[row][col] = 0; 
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }
    
    
    public static boolean isValid(int row, int col, int num){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) 
                return false;
        }
    
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        int boxR = (row / 3) * 3;
        int boxC = (col / 3) * 3;

        for (int i = boxR; i < boxR + 3; i++) {
            for (int j = boxC; j < boxC + 3; j++) {
                if (board[i][j] == num) 
                    return false;
            }
        }

        return true;
}
    
 
    
    
    public static void printBoard(int [][]a){
    for (int row = 0; row < 9; row++) {
        if (row % 3 == 0 && row != 0) 
            System.out.println("---------------------");

        for (int col = 0; col < 9; col++) {
            if (col % 3 == 0 && col != 0) 
                System.out.print("| ");
        
            System.out.print(board[row][col] + " ");
        }
        System.out.println(); 
    }
}


    }
