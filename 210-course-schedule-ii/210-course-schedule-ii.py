from enum import Enum


class Color(Enum):
    WHITE = 0
    GREY = 1
    BLACK = 2
    

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        visited = [Color.WHITE] * numCourses
        adj = self.edges_to_adj(numCourses, prerequisites)  # Adjacency list
        stack = deque()  # To keep track of all postorder elements
        
        # Visiting all components
        has_cycle = False
        for src in range(numCourses):
            has_cycle = has_cycle or self.topological_sort(adj, src, visited, stack)
            
        # Cycle is found
        if has_cycle: return []
        
        # Cycle not found
        # Reverse of postorder
        order = []
        while stack:
            order.append(stack.pop())
            
        return order
    
    
    def edges_to_adj(self, vertices: int, edges: List[List[int]]):
        # Edge list to adjacency list
        adj = [[] for _ in range(vertices)]
        
        for e in edges:
            tail = e[1]
            head = e[0]
            
            adj[tail].append(head)
            
        return adj
    
    
    def topological_sort(self, adj: List[List[int]], src: int, 
                         visited: List[Color], stack: deque) -> bool:
        # Return True if has cycle
        # O(V + E) time & O(V) space
        
        # Base case
        if visited[src] == Color.GREY: return True
        if visited[src] == Color.BLACK: return False
        
        visited[src] = Color.GREY
        
        # Recursive case
        has_cycle = False
        for neigh in adj[src]:
            has_cycle = has_cycle or self.topological_sort(adj, neigh, visited, stack)
        
        # Postorder
        visited[src] = Color.BLACK
        stack.append(src)
        
        return has_cycle
        