'''
Q82. Trie | (Insert and Search)
'''

from Node import TrieNode

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = TrieNode()
                cur = cur.children[ch]
            else:
                cur = cur.children[ch]
        cur.isWordEnd = True

    def search(self, word, prefix=False):
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                return False
            else:
                cur = cur.children[ch]
        if prefix:
            return True
        return cur.isWordEnd


t = Trie()
t.insert('hello')
t.insert('hell')
t.insert('bello')
print(t.search('hello'))
print(t.search('be', prefix=True))
print(t.search('a', prefix=True))
