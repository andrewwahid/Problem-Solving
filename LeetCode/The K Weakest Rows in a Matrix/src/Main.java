import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class RowEntry {
    Integer index;
    Integer soldiers;

    public RowEntry(int index, int soldiers) {
        this.index = index;
        this.soldiers = soldiers;
    }

}

class RowComparator implements Comparator<RowEntry> {
    public int compare(RowEntry a, RowEntry b)
    {
        if (!a.soldiers.equals(b.soldiers)) {
            return a.soldiers.compareTo(b.soldiers);
        }
        else {
            return a.index.compareTo(b.index);
        }
    }
}

public class Main {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<RowEntry> queue = new PriorityQueue<RowEntry>(new RowComparator());
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int left = 0;
            int right = row.length;
            if (row[0] == 0){
                queue.offer(new RowEntry(i, 0));
                continue;
            }
            if (row[row.length-1] == 1){
                queue.offer(new RowEntry(i, row.length));
                continue;
            }
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (row[mid] == 0){
                    right = mid - 1;
                }else{
                    if (row[mid+1] == 0){
                        queue.offer(new RowEntry(i, mid+1));
                        break;
                    }else{
                        left = mid + 1;
                    }
                }
            }
        }
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            RowEntry entry = queue.remove();
            results[i] = entry.index;
        }
        return results;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(Arrays.toString(main.kWeakestRows(new int[][]{{1,1,1,1,1},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,0},{1,1,1,1,1}}, 3)));

    }
}
