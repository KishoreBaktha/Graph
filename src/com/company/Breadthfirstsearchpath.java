package com.company;

import java.beans.IntrospectionException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Breadthfirstsearchpath {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public Breadthfirstsearchpath(Graph g,int s)
    {
        edgeTo=new int[g.V()];
        marked=new boolean[g.V()];
        for(int i=0;i<g.V();i++)
            marked[i]=false;
        bfs(g,s);
    }
    private void bfs(Graph g,int v)
    {
        Queue<Integer> q=new PriorityQueue<Integer>() ;
        q.add(v);
        marked[v]=true;
        while(!q.isEmpty())
        {
            int vertex=q.remove();
            for(int w:g.adj(vertex))
            {
                if(!marked[w])
                {
                    q.add(w);
                    marked[w]=true;
                    edgeTo[w]=vertex;
                }
            }
        }

    }
    public boolean hasPath(int v)
    {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPath(v))return null;
        Stack<Integer> path=new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        Graph g=new Graph(scanner.nextInt(),scanner.nextInt());
        for(int i=0;i<g.E();i++)
        {
            int v=scanner.nextInt();
            int w=scanner.nextInt();
            g.addEdge(v,w);
        }
        Breadthfirstsearchpath breadthfirstsearchpath=new Breadthfirstsearchpath(g,0);
        for(int i=0;i<g.V();i++)
            System.out.println(i+"- "+breadthfirstsearchpath.edgeTo[i]);
        System.out.println("Path to-"+breadthfirstsearchpath.pathTo(4));
    }
}
