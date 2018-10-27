package com.company;
import java.util.*;
public class MST {
    public MST(EdgeWeightedGraph graph)
    {

    }
//    Iterable<Edge> edges()
//    {
//
//    }
//    private double weight()
//    {
//
//    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt();
        int e=scanner.nextInt();
        EdgeWeightedGraph graph=new EdgeWeightedGraph(v);
        for(int i=0;i<e;i++)
        {
            int v1=scanner.nextInt();
            int v2=scanner.nextInt();
            double weight=scanner.nextDouble();
            Edge edge=new Edge(v1,v2,weight);
            graph.addEdge(edge);
        }
        for(Edge ed:graph.edges())
            System.out.println(ed.v+"-"+ed.w+ ed.weight);
//        MST mst=new MST(graph);
//        for(edge e:mst.edges())
//            System.out.println(e);
//        System.out.println(mst.weight());
    }
}

 class Edge implements Comparable<Edge>
{
    int v,w;
    double weight;
  public Edge(int v,int w,double weight)
  {
      this.v=v;
      this.w=w;
      this.weight=weight;
  }
  public int either()
  {
      return v;
  }
  public int other(int vertex)
  {
      if(vertex==v) return w;
      else
          return v;
  }
    @Override
    public int compareTo(Edge that) {
        if(this.weight<that.weight)return -1;
        else if(this.weight==that.weight)return 0;
        else return 1;
    }
}
class EdgeWeightedGraph
{
    private  int V,E;
    private Bag<Edge>[] adj;
    public EdgeWeightedGraph(int V)
    {
        this.V=V;
        adj=(Bag<Edge>[])new Bag[V];
        for(int v=0;v<V;v++ )
            adj[v]=new Bag<Edge>();
    }
    public int V()
    {
        return V;
    }
    public void addEdge(Edge e)
    {
        int v=e.either(),w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
    public Iterable<Edge> adj(int v)
    {
        return adj[v];
    }
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

}