package com.company;

import java.util.Scanner;

public class connectedcomponents {
    private boolean[] marked;
    private int[] id;
    int count=0;
    public connectedcomponents(Graph g)
    {
        id=new int[g.V()];
        marked=new boolean[g.V()];
        for(int i=0;i<g.V();i++)
            marked[i]=false;
        for(int i=0;i<g.V();i++)
        {
            if(!marked[i])
            {
                dfs(g,i);
                count++;
            }
        }
    }
    private void dfs(Graph g,int v)
    {
        marked[v]=true;
        id[v]=count;
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                dfs(g,w);
            }
        }
    }
    private int getCount()
    {
        return count;
    }
    private int getid(int v)
    {
        return id[v];
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Graph g = new Graph(scanner.nextInt(), scanner.nextInt());
        for (int i = 0; i < g.E(); i++)
        {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g.addEdge(v, w);
        }
        connectedcomponents connectedcomponents=new connectedcomponents(g);
        System.out.println("number of connected components-"+connectedcomponents.getCount());
        if(connectedcomponents.getid(9)==connectedcomponents.getid(6))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
