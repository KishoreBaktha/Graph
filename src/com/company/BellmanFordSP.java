package com.company;

import java.util.Scanner;
import java.util.Stack;

public class BellmanFordSP {
    public DirectedEdge[] edgeT0;
    private double distTo[];
    public BellmanFordSP(DiEdgeWeightedGraph graph,int s)
    {
        edgeT0=new DirectedEdge[graph.V()];
        distTo=new double[graph.V()];
        for (int v=0;v<graph.V();v++)
            distTo[v]=Double.MAX_VALUE;
        distTo[s]=0.0;
        for(int i=0;i<graph.V();i++)
        {
            for(int v=0;v<graph.V();v++)
            {
                for(DirectedEdge e:graph.adj(v))
                    relax(e);
            }
        }
    }
    private void relax(DirectedEdge e)
    {
        int v=e.from(),w=e.to();
        if(distTo[w]>distTo[v]+e.weight())
        {
            distTo[w]=distTo[v]+e.weight();
            edgeT0[w]=e;
        }
    }
    private Iterable<DirectedEdge> pathTo(int v)
    {
        Stack<DirectedEdge> path=new Stack<DirectedEdge>();
        for(DirectedEdge e=edgeT0[v];e!=null;e=edgeT0[e.from()])
            path.push(e);
        return path;
    }
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
        BellmanFordSP bellmanFord=new BellmanFordSP(graph,0);
        //System.out.println(kruskalMST.edges());
        for(DirectedEdge ed:bellmanFord.pathTo(6))
        {
            System.out.println(ed.from()+"->"+ed.to() +" "+ed.weight());
        }
    }

}
