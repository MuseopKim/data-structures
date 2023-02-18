package graph;

import java.util.*;

public class Vertex<T> {

    private T value;
    private List<Vertex<T>> adjacentVertices;

    public Vertex(T value) {
        this.value = value;
        this.adjacentVertices = new ArrayList<>();
    }

    public void addAdjacentVertex(Vertex<T> vertex) {
        this.adjacentVertices.add(vertex);
    }

    public void removeAdjacentVertex(Vertex<T> vertex) {
        for (int i = 0; i < adjacentVertices.size(); i++) {
            Vertex<T> adjacentVertex = adjacentVertices.get(i);

            if (Objects.equals(adjacentVertex.getValue(), vertex.getValue())) {
                adjacentVertices.remove(adjacentVertex);
            }
        }
    }

    public T getValue() {
        return value;
    }

    public List<Vertex<T>> getAdjacentVertices() {
        return adjacentVertices;
    }
}
