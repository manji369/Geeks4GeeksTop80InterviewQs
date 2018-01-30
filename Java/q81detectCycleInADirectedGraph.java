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
 * Q81. Given a directed graph, check whether the graph contains a cycle or not.
Your function should return true if the given graph contains at least one cycle,
else return false. For example, the following graph contains three cycles
0->2->0, 0->1->2->0 and 3->3, so your function must return true.
 * 
 * 
 * Main Function:
 * q81detectCycleInADirectedGraph g = new q81detectCycleInADirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(g.hasCycle());
 * 
 */

import java.io.*;
import java.util.*;

public class q81detectCycleInADirectedGraph {
    private int V;
    private LinkedList<Integer> adj[];
    
    q81detectCycleInADirectedGraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++)
            adj[i] = new LinkedList();
    }
    
    void addEdge(int u, int v){
        adj[u].add(v);
    }
    
    boolean hasCycleUtil(int node, boolean[] visited, boolean[] recStack){
        visited[node] = true;
        recStack[node] = true;
        for(int neighbor: adj[node]){
            if(!visited[neighbor]){
                if(hasCycleUtil(neighbor, visited, recStack))
                    return true;
            }else if(recStack[neighbor])
                return true;
        }
        recStack[node] = false;
        return false;
    }
    
    boolean hasCycle(){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int node = 0; node < V; node++){
            if(!visited[node]){
                if(hasCycleUtil(node, visited, recStack))
                    return true;
            }
        }
        return false;
    }
}
