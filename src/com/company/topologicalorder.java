package com.company;

import java.util.Scanner;
import java.util.Stack;

public class topologicalorder {
    private boolean[] marked;
    Stack<Integer> reversepost=new Stack<Integer>();
    public topologicalorder(DiGraph g)
    {
        marked=new boolean[g.V()];
        for(int i=0;i<g.V();i++)
            marked[i]=false;
        for(int i=0;i<g.V();i++)
        {
            if(!marked[i])
                dfs(g,i);
        }
    }
    private void dfs(DiGraph g,int v)
    {
        marked[v]=true;
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                dfs(g,w);
            }
        }
        System.out.println("push "+v);
        reversepost.push(v);
    }
    public void reversePost()
    {
        int n=reversepost.size();
        for(int i=0;i<n;i++)
            System.out.println(reversepost.pop());
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        DiGraph g=new DiGraph(scanner.nextInt(),scanner.nextInt());
        for(int i=0;i<g.E();i++)
        {
            int v=scanner.nextInt();
            int w=scanner.nextInt();
            g.addEdge(v,w);
        }
        topologicalorder topologicalorder=new topologicalorder(g);
        //System.out.println(topologicalorder.reversePost());
        topologicalorder.reversePost();
    }
}
