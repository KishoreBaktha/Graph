package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrimMST {
    public boolean[] marked;
    public Queue<Edge> mst;
    public MinPQ<Edge> pq;
    public PrimMST(EdgeWeightedGraph graph)
    {
        pq=new MinPQ<Edge>();
        mst=new PriorityQueue<Edge>();
        marked=new boolean[graph.V()];
        visit(graph,0);
        while (!pq.isEmpty())
        {
            Edge e=pq.delMin();
            int v=e.either(),w=e.other(v);
            if(marked[v]&&marked[w])
                continue;
            mst.add(e);
            if(!marked[v])visit(graph,v);
            if(!marked[w]) visit(graph,w);
        }
    }
    public void visit(EdgeWeightedGraph graph,int v)
    {
        marked[v]=true;
        for(Edge e:graph.adj(v))
        {
            if(!marked[e.other(v)])
                pq.insert(e);
        }
    }
    public Iterable<Edge> edges()
    {
        return mst;
    }
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
        PrimMST primMST=new PrimMST(graph);
        for(Edge ed:primMST.edges())
        {
            System.out.println(ed.v+"-"+ed.w);
        }
        //System.out.println(kruskalMST.edges());
    }
}
