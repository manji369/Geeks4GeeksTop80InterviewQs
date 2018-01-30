'''
Q81. Given a directed graph, check whether the graph contains a cycle or not.
Your function should return true if the given graph contains at least one cycle,
else return false. For example, the following graph contains three cycles
0->2->0, 0->1->2->0 and 3->3, so your function must return true.
'''

from collections import defaultdict

class Graph:

    def __init__(self, v):
        self.graph = defaultdict(list)
        self.V = v

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def hasCycleUtil(self, node, visited, recStack):
        visited[node] = True
        recStack[node] = True
        for neighbor in self.graph[node]:
            if not visited[neighbor]:
                if self.hasCycleUtil(neighbor, visited, recStack):
                    return True
            elif recStack[neighbor]:
                return True
        recStack[node] = False
        return False

    def hasCycle(self):
        visited = [False]*self.V
        recStack = [False]*self.V
        for node in range(self.V):
            if not visited[node]:
                if self.hasCycleUtil(node, visited, recStack):
                    return True
        return False

g = Graph(4)
g.addEdge(0, 1)
g.addEdge(0, 2)
g.addEdge(1, 2)
g.addEdge(2, 0)
g.addEdge(2, 3)
g.addEdge(3, 3)
print(g.hasCycle())
