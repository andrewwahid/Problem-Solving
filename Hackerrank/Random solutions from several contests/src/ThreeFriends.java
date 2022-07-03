import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class ThreeFriends {

    public static long minimumWeight(int n, long[][] edges, int src1, int src2, int dest)
    {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        ArrayList<ArrayList<Edge>> rev_graph = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
            rev_graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            graph.get((int) edges[i][0]).add(new Edge((int) edges[i][1], edges[i][2]));
            rev_graph.get((int) edges[i][1]).add(new Edge((int) edges[i][0], edges[i][2]));
        }

        long[] source1ToX = new long[n];
        long[] source2ToX = new long[n];
        long[] destinationToX = new long[n];

        Arrays.fill(source1ToX, -1);
        Arrays.fill(source2ToX, -1);
        Arrays.fill(destinationToX, -1);

        dijkstra(graph, source1ToX, src1);
        dijkstra(graph, source2ToX, src2);
        dijkstra(rev_graph, destinationToX, dest);

        long result = Long.MAX_VALUE;
        for (int i=0; i < n; i++)
        {
            long cost1 = source1ToX[i];
            long cost2 = source2ToX[i];
            long cost3 = destinationToX[i];

            if (cost1!=-1&&cost2!=-1&&cost3!=-1)
            {
                long length = cost1 + cost2 + cost3;
                result = Math.min(result, length);
            }
        }
        return result == Long.MAX_VALUE ? -1 : result;
    }

    public static void dijkstra(ArrayList<ArrayList<Edge>> graph, long[] result, int source)
    {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->(int)(a.cumulativeCost -b.cumulativeCost));
        queue.add(new Pair(source,0));
        boolean[] visited = new boolean[graph.size()];

        while(queue.size()>0)
        {
            int size = queue.size();

            while(size-- > 0)
            {
                Pair pair = queue.poll();

                if(!visited[pair.ed])
                {
                    ArrayList<Edge> edges = graph.get(pair.ed);
                    for(Edge edge : edges)
                    {
                        if(!visited[edge.edge])
                            queue.add(new Pair(edge.edge,edge.weight + pair.cumulativeCost));
                    }
                    result[pair.ed] = pair.cumulativeCost;
                    visited[pair.ed] = true;
                }
            }
        }
    }

    public static double min(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().trim();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);


        long[][] edges = new long[m][3];


        IntStream.range(0, m).forEach(i -> {
            try {
                String line = bufferedReader.readLine().replaceAll("\\s+$", "");
                String[] values = line.split(" ");
                edges[i] = new long[]{Long.parseLong(values[0]) - 1, Long.parseLong(values[1]) - 1, Long.parseLong(values[2])};
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        //
        input = bufferedReader.readLine().trim();
        int nasserHouse = Integer.parseInt(input.split(" ")[0]) - 1;
        int khaledHouse = Integer.parseInt(input.split(" ")[1]) - 1;
        int hossamHouse = Integer.parseInt(input.split(" ")[2]) - 1;
        //
        bufferedReader.close();
        //
        /*if (m <= 3){
            System.out.println("-1");
            return;
        }*/
        //
        /*if (true){
            long testCost = minimumWeight(n, edges, 1, 0, 2);
            System.out.println(testCost);
            return;
        }*/
        long cost1 = minimumWeight(n, edges, khaledHouse, hossamHouse, nasserHouse);
        //
        long cost2 = minimumWeight(n, edges, nasserHouse, khaledHouse, hossamHouse);
        //
        long cost3 = minimumWeight(n, edges, nasserHouse, hossamHouse, khaledHouse);
        //

        boolean resultPrinted = false;
        if (cost1 == -1 && cost2 == -1 && cost3 == -1){
            System.out.println("-1");
            return;
        }
        if (cost1 == -1){
            cost1 = Integer.MAX_VALUE;
        }
        if (cost2 == -1){
            cost2 = Integer.MAX_VALUE;
        }
        if (cost3 == -1){
            cost3 = Integer.MAX_VALUE;
        }
        if (cost1 < cost2 && cost1 < cost3){
            resultPrinted = true;
            System.out.println((nasserHouse+1) + " " + cost1);
        }
        if (cost2 < cost1 && cost2 < cost3){
            resultPrinted = true;
            System.out.println((hossamHouse+1) + " " + cost2);
        }
        if (cost3 < cost2 && cost3 < cost1){
            resultPrinted = true;
            System.out.println((khaledHouse+1) + " " + cost3);
        }
        if (!resultPrinted){
            if (cost1 == cost2 && cost1 == cost3){
                System.out.println((min(hossamHouse, khaledHouse, nasserHouse) + 1) + " " + cost1);
            }else{
                if (cost1 == cost2){
                    System.out.println((Math.min(nasserHouse, hossamHouse) + 1) + " " + cost1);
                }
                if (cost1 == cost3){
                    System.out.println((Math.min(nasserHouse, khaledHouse) + 1) + " " + cost1);
                }
                if (cost2 == cost3){
                    System.out.println((Math.min(hossamHouse, khaledHouse) + 1) + " " + cost2);
                }
            }
        }
        //////////////////////////////

    }
}

class Edge
{
    int edge;
    long weight;

    Edge(int edge, long weight)
    {
        this.edge = edge;
        this.weight = weight;
    }
}

class Pair
{
    int ed;
    long cumulativeCost;

    Pair(int ed, long cumulativeCost)
    {
        this.ed=ed;
        this.cumulativeCost = cumulativeCost;
    }
}