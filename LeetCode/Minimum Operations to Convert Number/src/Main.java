import java.util.*;

class Entry {
    int cost;
    int parent;
    int state;

    public Entry(int cost, int state, int parent) {
        this.cost = cost;
        this.state = state;
        this.parent = parent;
    }
}

public class Main {

    public ArrayList<Entry> getAvailableMoves(Entry state, int[] nums){
        ArrayList<Entry> result = new ArrayList<>();
        int newCost = state.cost+1;
        for (int i = 0; i < nums.length; i++) {
            result.add(new Entry(newCost, state.state + nums[i], state.state));
            result.add(new Entry(newCost, state.state - nums[i], state.state));
            result.add(new Entry(newCost, state.state ^ nums[i], state.state));
        }
        return result;
    }

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> entries = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        entries.add(start);
        int cost = 0;
        while (!entries.isEmpty()){
            int queueSize = entries.size();
            while (queueSize > 0){
                queueSize--;
                int current = entries.remove();
                if (current == goal) return cost;
                visited.add(current);
                for (int k=0; k<nums.length; k++) {
                    int plus = current + nums[k];
                    int minus = current - nums[k];
                    int xor = current ^ nums[k];
                    if (plus == goal || minus == goal || xor == goal) return cost+1;
                    if (plus >= 0 && plus <= 1000 && !visited.contains(plus)){
                        entries.add(plus);
                        visited.add(plus);
                    }
                    if (minus >= 0 && minus <= 1000 && !visited.contains(minus)){
                        entries.add(minus);
                        visited.add(minus);
                    }
                    if (xor >= 0 && xor <= 1000 && !visited.contains(xor)){
                        entries.add(xor);
                        visited.add(xor);
                    }
                }
            }
            cost++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minimumOperations(new int[]{70,83,-93,47,-81,94,64,84,4,28,37,99,42,74}, 95, -25));
    }
}
