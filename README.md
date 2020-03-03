# Interview Prep

TODO: go through and add CTCI sections for resources

TODO: add images/gifs (?)

TODO: bold 'section titles' (?)

TODO: add pros/cons (?)

TODO: change '(overview)' to 'Overview'

TOOD: change '###' headers to '##'?

TODO: add packages to java examples in README

Below is review material I use to prepare for technical software engineering interviews.

## Overview

- [Big O](#big-o)
- [String Buffer](#stringbuffer)
- [Array](#array)
- [ArrayList](#arraylist)
- [Linked List](#linked-list)
- [Doubly Linked List](#doubly-linked-list)
- [Stack](#stack)
- [Queue](#queue)
- [Tree](#tree)
- [Graph](#graph)
- [Sorting](#sorting)
- [Search](#search)
- [Divide and Conquer](#divide-and-conquer)
- [Integer Representation](#integer-representation)
- [Java Data Structures](#java-data-structures)
- [Java Specifics](#java-specifics)
    - [Quick Review](#quick-review) 
    - [Abstract vs Interface](#abstract-vs-interface)
    - [Comparable](#comparable)
    - [Enum](#enum)
    - [Errors](#errors)
    - [Shallow vs Deep Copy](#shallow-vs-deep-copy)
    - [List vs Set](#list-vs-set)
    - [Iterable](#iterable)

## Big O

Rules

1. Different steps get added (i.e. a for loop then a different for loop)
2. Drop constants, i.e. O(7n) => O(n)
3. Different inputs, different variables, i.e. merge(a[], b[]) => O(a*b)
4. Drop non-dominate terms, i.e. O(n + n^2) = O(n^2)

O(1) < O(logn) < O(n) < O(nlogn) < O(n<sup>2</sup>) < O(2<sup>n</sup>) < O(n!)

![big o graph](img/big-o.png)

Resources

- TODO

## StringBuffer

- because String is immutable, when concatenating them using '+' have to copy all chars from left and right string
- more efficient concatenation of strings is StringBuffer which maintains itself as a an array of chars behind the scenes, and only produces strings when calling `toString()`

Resources

- [Java Doc](https://docs.oracle.com/javase/9/docs/api/java/lang/StringBuilder.html)

Java Example

```java
// initialize
StringBuilder sb = new StringBuilder();
sb.append("Hello ");
sb.append("world");
sb.append('!');
String helloWorld = sb.toString(); // returns "Hello world!"
```

## Array

Resources

- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/array)

Operations

- lookup (at index): return the element at index n
- insert: insert element at index n, move all elements after index n (to +1 current index)
- delete: remove element at index n, move all elements after index n (to -1 current index)
- append: insert element at end of array

Big O

operation | worst case
--- | ---
space | O(n)
lookup | O(1)
insert | O(n)
delete | O(n)
append | O(1)

Java Example

```java
// initialize
int[] ints = new int[3];
// insert
ints[0] = 1;
ints[1] = 5;
// lookup
int five = ints[1];
```

## ArrayList

- aka dynamic array
- dynamically resizing array (implements List)
- array underlies implementation, and when runs out of space, creates a new underlying array with double capacity, copy all elements to that array

Resources

- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/dynamic-array)
- [Java Docs](https://docs.oracle.com/javase/9/docs/api/java/util/ArrayList.html)

Operations

- same as [array](#array)

Big O

operation | average case | worst case
--- | --- | ---
space | O(n) | O(n) 
lookup | O(1) | O(1)
append | O(1) | O(n)*
insert | O(n) | O(n)
delete | O(n) | O(n)

*occurs if underlying array runs out of space

Java Example

```java
// initialize
List<Integer> ints = new ArrayList<Integer>();
// insert
ints.add(1);
ints.add(5);
// lookup
int five = ints.get(1);
// delete
ints.remove(1); // removes (and returns) 5
```

## Linked List

- sequential list where data is stored in nodes, and each node points to the next node
- start (first node) of linked list is called the head, end (last node) called the tail
- last node (tail) points to null

Resources

- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/linked-list)
- [CMU Overview](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html)
- [CMU Java Implementation](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java)
- [Personal Implementation](./examples/LinkedList.java)
- [Java Doc (technically a doubly linked list)](https://docs.oracle.com/javase/9/docs/api/java/util/LinkedList.html)

Operations

- prepend: add item to front of list (point head to new item, point new item to old head)
- append: add item to end of list (point old last item to new item, point tail to new item)
- lookup: find element in list (start at the head and traverse list until the item is found)
- insert: insert element into specified point (could be at an index, could be after some element)
- delete: remove specified item (fist find it, then remove it by pointing the previous items pointer to point to the 'next next' item, aka the deleted item's next item)

Big O

operation |  worst case
--- | --- 
space | O(n)
lookup | O(n)
prepend | O(1)
append | O(1)*
insert | O(n)
delete | O(n)

*so long as you keep a reference to `tail`, if all you have is a reference to `head` then it's O(n)

Pros

- adding elements to end and beginning is super fast (O(1))
- removing/retreiving first element (head) is super fast (O(1))
- flexible size

Cons

- can't directly access individual elements (no 'random access') - have to traverse list

Java Example

```java
// initialize
List<Integer> ints = new LinkedList<Integer>();
// prepend
ints.addFirst(1);
// append
ints.add(3);
// also append
ints.addLast(5);
// get first
int one = ints.getFirst();
// get last
int five = ints.getLast();
// remove item from middle
boolean found = ints.remove(new Integer(3)); 
// remove item from tail
five = ints.removeLast();
// remove item from head
one = ints.removeFirst();
```

## Doubly Linked List

- same as [linked list](#linked-list) except all nodes maintain a pointer to the previous node

Resources

- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/linked-list)
- [Java Doc](https://docs.oracle.com/javase/9/docs/api/java/util/LinkedList.html)
- [Princeton Implementation](https://algs4.cs.princeton.edu/13stacks/DoublyLinkedList.java.html)
- [Personal Implementation](./examples/DoublyLinkedList.java)

Pros (over singly linked list)

- can traverse list backwards
- given just a pointer to a node, can perform delete/insert (opposed to having to traverse entire list)
- delete/insert easier to implement (don't have store/update reference to previous pointer while traversing list)

Cons

- requires more space
- slightly more complex

(Big O and Java Example are same as [Linked List](#linked-list))

## Stack

- stores item in last in, first out (LIFO) order
- can use linked list or dynamic array to implement
    - linked list
        - push: insert element to head
        - pop: remove element from head, return
        - peak: return data of head
    - dynamic array
        - keep track of topOfStack (-1 when initialized)
        - push: increment top of stack, store arr[topOfStack] = element
        - pop: return arr[topOfStack], decrement topOfStack

Resources

- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/stack)
- [Princeton Implementation](https://introcs.cs.princeton.edu/java/43stack/Stack.java.html)
- [Personal Implementation](./examples/Stack.java)
- [Java Doc](https://docs.oracle.com/javase/9/docs/api/java/util/Stack.html)

Operations

- push: add an element to the top of the stack
- pop (also delete): return and remove the element from the top of the stack
- peek: return the element from the top of the stack

Big O

operation |  worst case
--- | --- 
space | O(n)
push | O(1)
pop | O(1)
peek | O(1)

Java Example

```java
// initialize
Stack<Integer> stack = new Stack<Integer>();
// push
stack.push(1);
stack.push(5);
// peek
int five = stack.peek();
// pop
five = stack.pop();
int one = stack.pop();
```


## Queue

- stores items in first in first out (FIFO) order
- can use linked list (MUCH preferred, WAY easier) or dynamic array
    - linked list: enqueue (insert) items at tail, dequeue (remove) items at head

Resources
- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/queue)
- [Personal Implementation](./examples/Queue.java)
- [Princeton Implementation](https://algs4.cs.princeton.edu/13stacks/Queue.java.html)
- [Java Doc](https://docs.oracle.com/javase/9/docs/api/java/util/Queue.html)

Operations

- enqueue: add element to back of queue
- dequeue: remeove element from front of queue
- peek: view element at front of queue

Big O

operation |  worst case
--- | --- 
space | O(n)
enqueue | O(1)
dequeue | O(1)
peek | O(1)


Java Example

```java
// initialize
Queue<Integer> queue = new LinkedList<Integer>();
// enqueue
queue.add(5);
queue.add(1);
// peek
int five = queue.peek();
// dequeue
five = queue.remove();
int one = queue.remove();
```

## Tree

- terminology
    - nodes: entries which link to 0 or more children (also typically contain data)
    - root: top most node (all nodes in tree descend from the root)
    - leaf node: no children
    - depth: number of edges/links from the root to a node (starting at 0)
    - height: depth from a node to furthest/deepest leaf
- general
    - efficient insertion and searching

Resources
- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/tree)
- [CMU (overview)](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html)


Pros
- trees reflect structural relationships in the data
- trees are used to represent hierarchies
- trees provide efficient insertion and searching

### Binary Tree

- tree where every node has 2 or fewer children (usually called 'left' and 'right')
- balanced binary tree
    - height is small relative to number of nodes it has
    - height is usually O(log(n))
    - different definitions, but typically (a) left/right subtree height differ by at most 1, (b) both subtrees are balanced
- complete tree
    - completely filled (all nodes have 2 children), with only exception for bottom (deepest) level which is filled from left to right
    - height is at most O(logN)
- full binary tree
    - each nodes has either 0 or 2 children
- perfect binary tree
    - every level is completely full

Resources
- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/binary-tree)
- [Personal Implementation](./examples/BinaryTree.java)

Operations

- insert: add a node to the tree
- delete: remove a node from the tree
- search: search for an item in the tree

Big O

operation |  worst case
--- | --- 
space | O(n)
insert | O(n)
delete | O(n)
lookup | O(n)

### Binary Search Tree

- a binary tree where all left children are less than and all right children are greater than the current node

Resources
- [Interview Cake (overview)](https://www.interviewcake.com/concept/java/binary-search-tree)
- [Princeton Implementation](https://algs4.cs.princeton.edu/32bst/BST.java.html)
- [Personal Implementation](./examples/BinarySearchTree.java)

Operations

same as [Binary Tree](#binary-tree)

Big O

operation |  worst case | balanced
--- | --- | ---
space | O(n) | O(n)
insert | O(n) | O(log(n))
delete | O(n) | O(log(n))
lookup | O(n) | O(log(n))

### Traversal

#### Depth First Search (DFS)

- explore one path (one child, then one of their children, then one of THEIR children...) as deep as possible before trying the next path
- can be easily implemented using recursion
- three orders
    - preorder: process current node, then left subtree, then right subtree
    - inorder: process left subtree, current node, then right subtree
    - postorder: process left subtree, then right subtree, then current node
- doesn't necessarily find the shortest path to what's being searched (whereas BFS does)

Resources

- [Interview Cake Overview](https://www.interviewcake.com/concept/java/dfs)
- [Personal Implementation](./examples/BinaryTree.java)

Psuedo Code

```
// in order traversal
dfs(node) {
    if (node == null)
        return;
    
    dfs(node.left);
    process(node);
    dfs(node.right);
}
```

#### Breadth First Search (BFS)

- explore all child nodes, then explore all their children, and so on
- will find the shortest path between starting node and any traversed node

Resources
- [Interview Cake Overview](https://www.interviewcake.com/concept/java/bfs)

Psuedo Code

```
bfs(node)
    queue.enqueue(node)
    while !queue.isEmpty()
        current = queue.dequeue()
        // NOTE: 'current' might be null
        process(current)
        queue.enqueue(node.left)
        queue.enqueue(node.right)
```

## Graph

- an interconnected network consisting of vertex/nodes (the actual data elements) which are connected by edges
- pros: representing things that connect to other things
- cons: most graph algorithms are O(nlogn) or slower
- directed vs. undirected
    - directed: edges 'point' from one node to the other (i.e. for a->b, can only go from a to b, vs y<->z can go back and forth)
    - undirected: can traverse edge any which way (direction doesn't matter)
- cyclic vs. acyclic
    - cylcic: path along edges form a vertex (back) to itself
    - acyclic: graph with no cycles
- weighted: each edge has an associated weight (i.e. roads with distances)
- directed acyclic graph (DAG)
    - directed graph without cycles
- multiple ways to represent in code
    - multi dimensional array (list of edges)
    - hashmap of vertex to adjacent vertices (i.e. `hashmap<vertex, LinkedList<vertex>>`
- note
    - possible for a graph to be disconnected (have networks of verteces not connected to other networks of verteces)
- advanced
    - Dijkstras Algorithm (?)
    - Minimum Spanning Tree (?)

Resources
- [Interview Cake Overview](https://www.interviewcake.com/concept/java/graph)
- [Portland State University Overview](http://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/Graphs.html)
- [Personal Implementation](./examples/Graph.java)

### Traversal

- NOTE: dfs/bfs on a directed graph may not print out all verteces, i.e. if starting point is a node with only in-arrows

#### Depth First Search

Resources
- [Personal Implementation](./examples/Graph.java)
- [Psuedo Code](https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/tutorial/)

Psuedo Code

```
dfs(graph, node) {
    node.visted = true
    for neighbor in graph.getNeighbors(node)
        if neighbor.visited == false
            dfs(neighbor)
}
```

#### Breadth First Search

Resources
- [Personal Implementation](./examples/Graph.java)
- [Psuedo Code](https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/tutorial/)

Psuedo Code

```
bfs(graph, node) {
    queue.enqueue(node)
    while(!queue.isEmpty())
        current = queue.dequeue
        process(current)
        current.visted = true
        for neighbor in graph.getNeighbors(current)
            if !neighbor.visited
                queue.enqueue(neighbor)
}
```

## Sorting

- rearranges elements in an array in order (usually ascending) based on some comparison operator
- popular sorting algorithms can be broken down into two categories
    - simple sort: average O(n²)
        - selection sort
        - insertion sort
    - efficient sort: average O(nlog(n))
        - merge sort
        - quicksort
        - heapsort

Big O

Resources
- [Interview Cake Big O Cheat Sheet](https://www.interviewcake.com/sorting-algorithm-cheat-sheet)
- [Wikipedia](https://en.wikipedia.org/wiki/Sorting_algorithm)

operation |  worst | best | average | space
--- | --- | --- | --- | ---
selection sort | O(n²) | O(n²) | O(n²) | O(1)
insertion sort | O(n²) | O(n) | O(n²) | O(1)
merge sort | O(nlog(n)) | O(nlog(n)) | O(nlog(n)) | O(n)
quicksort | O(n²) | O(nlog(n)) | O(nlog(n)) | O(log(n))
heapsort | O(nlog(n)) | O(n) | O(nlog(n)) | O(1)

### Insertion Sort

TODO: finish

Resources
- [Interview Cake Overview](https://www.interviewcake.com/concept/python/insertion-sort)
- [Personal Implmentation](./examples/InsertionSort.java)

### Merge Sort

TODO: finish

Resources
- [Interview Cake Overview](https://www.interviewcake.com/concept/python/merge-sort)
- [Personal Implmentation](./examples/MergeSort.java)
- [Geeks for Geeks Overview](https://www.geeksforgeeks.org/merge-sort/)

## Search

### Binary Search

- finds an item in a sorted array
- worst case O(log(n)) time
- algorithm: pick the middle of the array - if found, return index, other wise if less than, choose new middle to left, otherwise if greatar than, choose new middle to right

Resources
- [Interview Cake Binary Search](https://www.interviewcake.com/concept/java/binary-search)
- [Personal Implmentation](./examples/BinarySearch.java)

Psuedo Code

TODO

## Search

TODO

## Integer Representation

TODO

## Java Data Structures

TODO: cleanup/finish

- simple list: [`ArrayList`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) (O(1) for get, set, O(1) for amortized add)
- simple list: [`LinkedList`](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html) (TODO)
- sorted list: doesn't really exist as a datastructure, could just call `Collections.sort()` on a list
- simple set: [`HashSet`](https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html) (O(1) for add, remove, contains)
- sorted set: [`TreeSet`](https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html) (O(log(n)) for add, remove, contains)
- simple map: [`HashMap`](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html) (O(1) for get, put)
- sorted map: [`TreeMap`](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html) (sorted via keys, O(log(n)) for containsKey, get, put and remove)
- queue: [`Queue`](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html) (note this is an interface, need to use something like `LinkedList` to actually implement)
- stack: [ `Stack`](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)

## Java Specifics

### Quick Review

Basic Hello World Example

```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!")
    }
}
```

This file could be called something like `HelloWorld.java`. To compile the file run `$ javac HelloWorld.java` and to execute the program run `$ java HelloWorld`

Resources

- [Princeton Cheatsheet](https://introcs.cs.princeton.edu/java/11cheatsheet/)

### Abstract vs Interface

- both allow for abstraction of implmentation

topic |  Abstract class | Interface
--- | --- | ---
methods | can have abstract and non-abstract methods (also default, static methods) | only abstract methods
final variables | can contain non final variables | variables are final by default
variable types | final, non-final, static and non-static variables | only static and final variables
implementation | can implement interface | can't implement abstract class
implementing | use keyword extend | use keyword implements
multiple implements | can extend another class and implement multiple interfaces | interfaces can only extend other interfaces
variable accessiblity | supports private, protected... | public by default

Resources

- [Geeks for Geeks](https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/)
- [Personal Example](./examples/java/AbstractInterfaceStuff.java)

### Comparable

Resources

- [Java Doc](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)
- [Personal Example](./examples/java/ComparableExample.java)

Java Example

```java
class Event implements Comparable<Event> {
    String name;
    LocalDateTime date;

    public Event(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public int compareTo(Event event) {
        return this.date.compareTo(event.date);
    }
}
```

### Enum

Resources

- [Java Doc](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
- [Personal Example](./examples/java/EnumExample.java)
- [Mkyong Examples](https://www.mkyong.com/java/java-enum-example/)

### Errors

TODO

### Shallow vs Deep Copy

TODO

### List vs Set

List

- ordered collection
- maintains elements in insertion order
- can contain duplicates
- positional access
- [Java Doc](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

Set

- unordered collection
- elements are not maintained any order
- no duplicates (all elements unique)
- no positional access
- [Java Doc](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)

Both

- implement Collection, Iterable

### Iterable

TODO