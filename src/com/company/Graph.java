package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Graph
{
    private final int V;
    private final int E;
    private Bag<Integer>[] adj;
    public Graph(int V,int E)
    {
        this.V=V;
        this.E=E;
        adj=(Bag<Integer>[])new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]=new Bag<Integer>();
    }
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    public int V()
    {
        return V;
    }
    public int E()
    {
        return E;
    }
    public Iterable<Integer> adj(int V)
    {
        return adj[V];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int V=scanner.nextInt();
        int E=scanner.nextInt();
        Graph g=new Graph(V,E);
        for(int i=0;i<E;i++)
        {
            int v=scanner.nextInt();
            int w=scanner.nextInt();
            g.addEdge(v,w);
        }
        for(int v=0;v<E;v++)
        {
            for(int w:g.adj(v))
                System.out.println(v+" - "+w );
        }
    }
}
class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag.
     *
     * @param item the item to add to this bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}