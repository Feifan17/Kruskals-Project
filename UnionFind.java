
public class UnionFind {

    private int[] parent;
    private int[] rank;

    //UnionFind constructor.
    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

    }

    //make set for vertex v.
    public void MakeSet(int v) {

        this.parent[v] = v;
    }

    //find Set with path compression.
    public int FindSet(int v) {

        int result = v;
        if (this.parent[v] == v) {
            return result;
        } else {
            result = this.FindSet(this.parent[v]);
            this.parent[v] = result;
        }
        return result;
    }

    //union sets by height.
    public void UnionByHeight(int v1, int v2) {

        int v1Root = this.FindSet(v1);
        int v2Root = this.FindSet(v2);

        if (this.rank[v1Root] > this.rank[v2Root]) {
            this.parent[v2Root] = v1Root;
        } else if (this.rank[v1Root] < this.rank[v2Root]) {
            this.parent[v1Root] = v2Root;
        } else {
            this.parent[v2Root] = v1Root;
            this.rank[v1] += 1;
        }
    }
}
