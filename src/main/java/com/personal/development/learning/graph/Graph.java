package com.personal.development.learning.graph;

import java.util.*;

/**
 * A class representing a graph, with an edge list and adjacency list.
 * 
 * DO NOT EDIT THIS CLASS!!!
 * 
 * @author CS 1332 TAs
 * @version 1.0
 */
public class Graph<T> {

    private Set<Edge<T>> edges;
    private Map<Vertex<T>, List<VertexDistancePair<T>>> adjacencyList;
    private boolean directed;

    /**
     * Constructor to build a Graph from an edge list.
     * 
     * @param edges the edge list to build the graph from.
     */
    public Graph(LinkedHashSet<Edge<T>> edges) {
        this.adjacencyList = new HashMap<>();
        this.edges = edges;
        for (Edge<T> e : edges) {
            adjacencyList.putIfAbsent(e.getU(),
                    new ArrayList<VertexDistancePair<T>>());
            adjacencyList.putIfAbsent(e.getV(),
                    new ArrayList<VertexDistancePair<T>>());
            adjacencyList.get(e.getU()).add(
                    new VertexDistancePair<T>(e.getV(), e.getWeight()));
            if (!e.isDirected()) {
                adjacencyList.get(e.getV()).add(
                        new VertexDistancePair<T>(e.getU(), e.getWeight()));
            } else {
                this.directed = true;
            }
        }
    }

    /**
     * Constructor to build a graph from a set of vertices and
     * an edge list to allow for isolated vertices.
     *
     * @param vertices the vertex set
     * @param edges the edge set
     */
    public Graph(Set<Vertex<T>> vertices, LinkedHashSet<Edge<T>> edges) {
        this.adjacencyList = new HashMap<>();
        this.edges = edges;

        for (Vertex<T> v : vertices) {
            adjacencyList.put(v, new ArrayList<VertexDistancePair<T>>());
        }

        for (Edge<T> e : edges) {
            adjacencyList.get(e.getU()).add(
                    new VertexDistancePair<T>(e.getV(), e.getWeight()));
            if (!e.isDirected()) {
                adjacencyList.get(e.getV()).add(
                        new VertexDistancePair<T>(e.getU(), e.getWeight()));
            } else {
                this.directed = true;
            }
        }
    }

    /**
     * Gets the edge list of this graph.
     * 
     * @return the edge list of this graph
     */
    public Set<Edge<T>> getEdgeList() {
        return edges;
    }

    /**
     * Gets the adjacency list of this graph.
     * 
     * @return the adjacency list of this graph
     */
    public Map<Vertex<T>, List<VertexDistancePair<T>>> getAdjacencyList() {
        return adjacencyList;
    }
    
    /**
     * Gets whether or not the edges of this graph are directed.
     * 
     * @return true if this graph is directed, false otherwise
     */
    public boolean isDirected() {
        return directed;
    }
}
