package com.company;

import java.util.Scanner;

public class SP {
    public SP(EdgeWeightedGraph graph)
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
        DiEdgeWeightedGraph graph=new DiEdgeWeightedGraph(v);
        for(int i=0;i<e;i++)
        {
            int v1=scanner.nextInt();
            int v2=scanner.nextInt();
            double weight=scanner.nextDouble();
            DirectedEdge edge=new DirectedEdge(v1,v2,weight);
            graph.addEdge(edge);
        }
        for(DirectedEdge ed:graph.adj(0))
            System.out.println(ed.v+"->"+ed.w+ ed.weight);
//        MST mst=new MST(graph);
//        for(edge e:mst.edges())
//            System.out.println(e);
//        System.out.println(mst.weight());
    }
}

class DirectedEdge implements Comparable<DirectedEdge>
{
    int v,w;
    double weight;
    public DirectedEdge(int v,int w,double weight)
    {
        this.v=v;
        this.w=w;
        this.weight=weight;
    }
    public int from()
    {
        return v;
    }
    public int to()
    {
        return w;
    }
    public double weight()
    {
        return weight;
    }
    @Override
    public int compareTo(DirectedEdge that) {
        if(this.weight<that.weight)return -1;
        else if(this.weight==that.weight)return 0;
        else return 1;
    }
}
class DiEdgeWeightedGraph {
    private int V, E;
    private Bag<DirectedEdge>[] adj;

    public DiEdgeWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }

    public int V() {
        return V;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

//    public Iterable<Edge> edges() {
//        Bag<Edge> list = new Bag<Edge>();
//        for (int v = 0; v < V; v++) {
//            int selfLoops = 0;
//            for (Edge e : adj(v)) {
//                if (e.other(v) > v) {
//                    list.add(e);
//                }
//                // add only one copy of each self loop (self loops will be consecutive)
//                else if (e.other(v) == v) {
//                    if (selfLoops % 2 == 0) list.add(e);
//                    selfLoops++;
//                }
//            }
//        }
//        return list;
//    }

}