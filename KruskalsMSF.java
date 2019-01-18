import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KruskalsMSF {

    /**
     * Compare {@code String}s in the order based on their weights.
     */
    private static class EdgeWeightComparator implements Comparator<String> {
        @Override
        public int compare(String e1, String e2) {

            int result = 0;
            int e1Colon = e1.indexOf(':');
            int e2Colon = e2.indexOf(':');
            int w1 = Integer.parseInt(e1.substring(e1Colon + 1));
            int w2 = Integer.parseInt(e2.substring(e2Colon + 1));

            if (w1 < w2) {
                result = -1;
            } else if (w1 > w2) {
                result = 1;
            }

            return result;
        }

    }

    public static void main(String[] args) {

        try {
            //read input file.
            File graphX = new File(args[0]);
            Scanner graphReader = new Scanner(graphX);
            Scanner edgeCount = new Scanner(graphX);

            //Since the first line of the input file is the number of vertices
            //numberOfEdges is initialized with value -1.
            int numberOfEdges = -1;
            while (edgeCount.hasNext()) {
                numberOfEdges++;
                edgeCount.nextLine();
            }

            //n is the number of vertices.
            int n = graphReader.nextInt();

            //initialize union-find data structure.
            UnionFind F = new UnionFind(n);

            //initially, each set represents a single vertex.
            for (int i = 0; i < n; i++) {
                F.MakeSet(i);
            }
            //initialize edge weight comparator and minimum priority queue.
            Comparator<String> WeightComparator = new EdgeWeightComparator();
            PriorityQueue<String> MinQueue = new PriorityQueue<>(numberOfEdges,
                    WeightComparator);

            //before the scanner is used to read input as a integer
            //and now it's used to read input as a string
            //so this line ensures that the scanner works correctly.
            graphReader.nextLine();

            //add all of the edges into minimum priority queue.
            while (graphReader.hasNext()) {
                String edge = graphReader.nextLine();
                MinQueue.add(edge);
            }

            //add edges into MST using Kruskal algorithm until MST contains (n-1) edges.
            int m = 0;
            while (!MinQueue.isEmpty() && m < n - 1) {
                String e = MinQueue.remove();
                int eComa = e.indexOf(',');
                int eColon = e.indexOf(':');
                int source = Integer.parseInt(e.substring(0, eComa));
                int destination = Integer
                        .parseInt(e.substring(eComa + 1, eColon));
                if (F.FindSet(source) != F.FindSet(destination)) {
                    System.out.println(e);
                    F.UnionByHeight(source, destination);
                    m++;
                }
            }
            //close graphReader and edgeCount.
            graphReader.close();
            edgeCount.close();

        } catch (Exception e) {
            System.out.println(args[0] + "is an invalid file");
        }

    }

}
