package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KruskalMST {
    private Bag<Edge> mst=new Bag<Edge>();
    public KruskalMST(EdgeWeightedGraph graph)
    {
        MinPQ<Edge> minPQ=new MinPQ<Edge>();
        for(Edge e:graph.edges())
            minPQ.insert(e);
        UF uf=new UF(graph.V());
        while(!minPQ.isEmpty()&&mst.size()<graph.V()-1)
        {
            Edge pq=minPQ.delMin();
            int v=pq.either(),w=pq.other(v);
            //detect cycle
            if(!uf.connected(v,w))
            {
                uf.union(v,w);
                mst.add(pq);
            }

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
        KruskalMST kruskalMST=new KruskalMST(graph);
        for(Edge ed:kruskalMST.edges())
        {
           System.out.println(ed.v+"-"+ed.w);
        }
        //System.out.println(kruskalMST.edges());
    }
}
