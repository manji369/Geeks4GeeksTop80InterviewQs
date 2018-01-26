/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

/**
 *
 * @author manji
 * 
 * 
 * Q51. Breadth First Traversal (or Search) for a graph is similar to Breadth
First Traversal of a tree (See method 2 of this post). The only catch here is,
unlike trees, graphs may contain cycles, so we may come to the same node again.
To avoid processing a node more than once, we use a boolean visited array. For
simplicity, it is assumed that all vertices are reachable from the starting
vertex.
For example, in the following graph, we start traversal from vertex 2. When we
come to vertex 0, we look for all adjacent vertices of it. 2 is also an
adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be
processed again and it will become a non-terminating process. A Breadth First
Traversal of the following graph is 2, 0, 3, 1.
 * 
 * 
 * Main Function:
 * q51breadthFirstTraversalOrBfsForAGraph g = new q51breadthFirstTraversalOrBfsForAGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfs(2);
 * 
 */

import java.io.*;
import java.util.*;

public class q51breadthFirstTraversalOrBfsForAGraph {
    private int V;
    private LinkedList<Integer> adj[];
    
    q51breadthFirstTraversalOrBfsForAGraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++)
            adj[i] = new LinkedList();
    }
    
    void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    void bfs(int s){
        boolean visited[] = new boolean[V];
        int n;
        LinkedList<Integer> q = new LinkedList();
        visited[s] = true;
        q.add(s);
        while(q.size() != 0){
            s = q.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                n = i.next();
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
        System.out.println("");
    }
}
