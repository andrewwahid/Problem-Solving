import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeArrays {

    public static double findMedianSortedArrays(ArrayByFactor A, ArrayByFactor B) {
        long middle = A.size(), n = B.size();
        long left = (middle + n + 1) / 2;
        long right = (middle + n + 2) / 2;
        return (getkth(A, 0, B, 0, left) + getkth(A, 0, B, 0, right)) / 2.0;
    }

    public static double getkth(ArrayByFactor A, long aStart, ArrayByFactor B, long bStart, long k) {
        if (aStart > A.size() - 1) return B.get(bStart + k - 1);
        if (bStart > B.size() - 1) return A.get(aStart + k - 1);
        if (k == 1) return Math.min(A.get(aStart), B.get(bStart));

        long aMid = Long.MAX_VALUE, bMid = Long.MAX_VALUE;
        if (aStart + k/2 - 1 < A.size()) aMid = A.get(aStart + k/2 - 1);
        if (bStart + k/2 - 1 < B.size()) bMid = B.get(bStart + k/2 - 1);

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2); // Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2); // Check: bRight + aLeft
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().trim();
        long n = Long.parseLong(input.split(" ")[0]);
        long x = Long.parseLong(input.split(" ")[1]);

        input = bufferedReader.readLine().trim();
        long m = Long.parseLong(input.split(" ")[0]);
        long y = Long.parseLong(input.split(" ")[1]);

        ArrayByFactor A = new ArrayByFactor(x, n);
        ArrayByFactor B = new ArrayByFactor(y, m);

        System.out.printf("%.1f", findMedianSortedArrays(A, B));

        bufferedReader.close();
    }
}

class ArrayByFactor{
    long factor;
    long length;

    public ArrayByFactor(long factor, long length) {
        this.factor = factor;
        this.length = length;
    }

    long get(long index){
        return (index+1) * factor;
    }

    public long size() {
        return length;
    }
}
