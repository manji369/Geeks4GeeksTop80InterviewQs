class Node:
    def __init__(self, val=None):
        self.data = val
        self.left = None
        self.right = None

class singlyConnectedNode:
    def __init__(self, val=None):
        self.data = val
        self.next = None

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWordEnd = False
