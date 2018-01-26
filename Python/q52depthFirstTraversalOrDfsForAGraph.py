'''
Q52. Depth First Traversal (or Search) for a graph is similar to Depth First
Traversal of a tree. The only catch here is, unlike trees, graphs may contain
cycles, so we may come to the same node again. To avoid processing a node more
than once, we use a boolean visited array.
'''
from collections import defaultdict

class Graph:

    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def dfsUtil(self, s, visited):
        visited[s] = True
        print(s, end=' ')
        for el in self.graph[s]:
            if not visited[el]:
                self.dfsUtil(el, visited)

    def dfs(self, s):
        visited = [False]*len(self.graph)
        self.dfsUtil(s, visited)
        print()

g = Graph()
g.addEdge(0, 1)
g.addEdge(0, 2)
g.addEdge(1, 2)
g.addEdge(2, 0)
g.addEdge(2, 3)
g.addEdge(3, 3)
g.dfs(2)
