import java.util.HashSet;
import java.util.Set;

public class Main {
    public boolean isValidSudoku(char[][] board) {
        // first check for each 3x3 grid
        for (int i = 0; i < 9; i++) {
            Set<Character> tiles = new HashSet<>();
            int x = 3 * (i%3);
            int y = ( (int) (i / 3)) * 3;
            int boxX = x;
            int boxY = y;
            int index = 0;
            while (index < 9){
                char tile = board[y][x];
                if (tile != '.' && tiles.contains(tile)) return false;
                tiles.add(tile);
                index++;
                x = boxX + (index % 3);
                y = boxY + (index / 3);
            }
        }
        // second check each row for repetition
        for (int i = 0; i < 9; i++) {
            Set<Character> tiles = new HashSet<>();
            int column = 0;
            while (column < 9){
                char tile = board[i][column];
                if (tile != '.' && tiles.contains(tile)) return false;
                tiles.add(tile);
                column++;
            }
        }
        // third check each column for repetition
        for (int i = 0; i < 9; i++) {
            Set<Character> tiles = new HashSet<>();
            int row = 0;
            while (row < 9){
                char tile = board[row][i];
                if (tile != '.' && tiles.contains(tile)) return false;
                tiles.add(tile);
                row++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isValidSudoku(new char[][] {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }
}
