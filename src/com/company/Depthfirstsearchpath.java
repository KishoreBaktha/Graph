package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Depthfirstsearchpath {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public Depthfirstsearchpath(Graph g,int s)
    {
        edgeTo=new int[g.V()];
        marked=new boolean[g.V()];
        for(int i=0;i<g.V();i++)
            marked[i]=false;
        dfs(g,s);
    }
    private void dfs(Graph g,int v)
    {
        marked[v]=true;
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                dfs(g,w);
                edgeTo[w]=v;
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
        {
            System.out.println("push-"+x);
            path.push(x);
        }
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
        Depthfirstsearchpath depthfirstsearchpath=new Depthfirstsearchpath(g,0);
        for(int i=0;i<g.V();i++)
            System.out.println(i+"- "+depthfirstsearchpath.edgeTo[i]);
        System.out.println("Path to-"+depthfirstsearchpath.pathTo(2));
    }
}
