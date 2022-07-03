package TheFundraisingProblem;
import java.util.*;

public class Solution {
    static int groupsCount;
    static int studentsPerGroup;
    static int[][] charm;
    static int totalTables;
    static int[][] generosities;
    static int maxStudentApproaches;

    /*
     * Complete the guestTable function below.
     */
    static void guestTable(int[] generosities) {

    }

    /*
     * Complete the solve function below.
     */
    static void solve() {


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = Integer.parseInt(scanner.nextLine());
        for (int tcItr = 0; tcItr < tc; tcItr++) {
            String[] mnt = scanner.nextLine().split(" ");
            groupsCount = Integer.parseInt(mnt[0].trim());
            studentsPerGroup = Integer.parseInt(mnt[1].trim());
            totalTables = Integer.parseInt(mnt[2].trim());

            // charm[i][j] is group i, student j
            charm = new int[groupsCount][studentsPerGroup];
            for (int charmRowItr = 0; charmRowItr < groupsCount; charmRowItr++) {
                String[] charmRowItems = scanner.nextLine().split(" ");
                for (int charmColumnItr = 0; charmColumnItr < studentsPerGroup; charmColumnItr++) {
                    int charmItem = Integer.parseInt(charmRowItems[charmColumnItr].trim());
                    charm[charmRowItr][charmColumnItr] = charmItem;
                }
                Arrays.sort(charm[charmRowItr]);
            }

            generosities = new int[totalTables][];
            for (int tItr = 0; tItr < totalTables; tItr++) {
                String[] xg = scanner.nextLine().split(" ");
                int x = Integer.parseInt(xg[0]);
                int[] g = new int[x];

                for (int generositiesItr = 0; generositiesItr < x; generositiesItr++) {
                    int generositiesItem = Integer.parseInt(xg[generositiesItr+1].trim());
                    g[generositiesItr] = generositiesItem;
                }

                generosities[tItr] = g;
            }
            maxStudentApproaches = Integer.parseInt(scanner.nextLine().trim());
            solve();
        }
    }
}

