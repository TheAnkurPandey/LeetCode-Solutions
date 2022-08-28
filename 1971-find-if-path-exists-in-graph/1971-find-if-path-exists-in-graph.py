from enum import Enum

class Color(Enum):
    WHITE = 0
    GREY = 1
    BLACK = 2
    
    
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        adj = self.edges_to_adj(n, edges)
        visited = [Color.WHITE] * n
        
        return self.has_path(adj, source, destination, visited)
        
    
    def edges_to_adj(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        # O(E) time & O(1) space
        
        adj = [ [] for i in range(n) ]
        
        for e in edges:
            vertex_a = e[0]
            vertex_b = e[1]
            
            adj[vertex_a].append(vertex_b)
            adj[vertex_b].append(vertex_a)
            
        return adj
    
    
    def has_path(self, adj: List[List[int]], src: int, dest: int, visited: List[Color]) -> bool:
        # O(V + E) time & O(V) space
        
        # Base case
        if src == dest: return True
        if visited[src] != Color.WHITE: return False
        
        visited[src] = Color.GREY
        
        # Recursive case
        path_found = False
        for neigh in adj[src]:
            path_found = path_found or self.has_path(adj, neigh, dest, visited)
            
        return path_found
        