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
 * Q52. Depth First Traversal (or Search) for a graph is similar to Depth First
Traversal of a tree. The only catch here is, unlike trees, graphs may contain
cycles, so we may come to the same node again. To avoid processing a node more
than once, we use a boolean visited array.
 * 
 * 
 * Main Function:
 * q52depthFirstTraversalOrDfsForAGraph g = new q52depthFirstTraversalOrDfsForAGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs(2);
 * 
 */

import java.io.*;
import java.util.*;

public class q52depthFirstTraversalOrDfsForAGraph {
    private int V;
    private LinkedList<Integer> adj[];
    
    q52depthFirstTraversalOrDfsForAGraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++)
            adj[i] = new LinkedList();
    }
    
    void addEdge(int u, int v){
        adj[u].add(v);
    }
    
    void dfsUtil(int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> i = adj[s].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                dfsUtil(n, visited);
        }
    }
    
    void dfs(int s){
        boolean[] visited = new boolean[V];
        dfsUtil(s, visited);
        System.out.println("");
    }
}
