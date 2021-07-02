package com.personal.development.learning.graph.bfs;

import com.personal.development.learning.graph.Graph;
import com.personal.development.learning.graph.Vertex;
import com.personal.development.learning.graph.VertexDistancePair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {
	/**
	 * Perform breadth first search on the given graph, starting at the start
	 * Vertex.  You will return a List of the vertices in the order that
	 * you visited them.  Make sure to include the starting vertex at the
	 * beginning of the list.
	 *
	 * When exploring a Vertex, make sure you explore in the order that the
	 * adjacency list returns the neighbors to you.  Failure to do so may
	 * cause you to lose points.
	 *
	 * You may import/use {@code java.util.Queue}, {@code java.util.Set},
	 * {@code java.util.Map}, {@code java.util.List}, and any classes
	 * that implement the aforementioned interfaces.
	 *
	 * @throws IllegalArgumentException if any input is null, or if
	 *         {@code start} doesn't exist in the graph
	 * @param start the Vertex you are starting at
	 * @param graph the Graph you are traversing
	 * @param <T> the data type representing the vertices in the graph.
	 * @return a List of vertices in the order that you visited them
	 */
	public static <T> List<Vertex<T>> breadthFirstSearch(Vertex<T> start, Graph<T> graph) {
		if ((start == null) || (graph == null)) {
			throw new IllegalArgumentException("Due to Vertex or Graph" + " is null");
		}
		if (!(graph.getAdjacencyList().containsKey(start))) {
			throw new IllegalArgumentException("Due to start value does not exist in the graph");
		}
		
		Queue<Vertex<T>> next = new LinkedList<>(); //A data structure to save/access exploring a node adjacency's
		next.add(start);
		
		List<Vertex<T>> result = new java.util.ArrayList<>(); //A data structure to save visited nodes
		result.add(start);
		
		Map<Vertex<T>, List<VertexDistancePair<T>>> adjacencyList = graph.getAdjacencyList();
		while (!(next.isEmpty())) {
			Vertex<T> curVertex = next.remove();
			for (VertexDistancePair<T> vertex : adjacencyList.get(curVertex)) {
				if (!(result.contains(vertex.getVertex()))) {
					result.add(vertex.getVertex());
					next.add(vertex.getVertex());
					
				}
			}
		}
		return result;
	}
}
