public class Main {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int[] account = accounts[i];
            int wealth = 0;
            for (int k = 0; k < account.length; k++) {
                wealth += account[k];
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        Main main = new Main();

    }
}
