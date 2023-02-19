package graph;

import java.util.HashMap;
import java.util.Map;

public class DFS<T> {

    public static void main(String[] args) {
        Map<String, Boolean> visited = new HashMap<>();

        Vertex<String> human1 = new Vertex<>("human1");
        Vertex<String> human2 = new Vertex<>("human2");
        Vertex<String> human3 = new Vertex<>("human3");
        Vertex<String> human4 = new Vertex<>("human4");
        Vertex<String> human5 = new Vertex<>("human5");
        Vertex<String> human6 = new Vertex<>("human6");
        Vertex<String> human7 = new Vertex<>("human7");

        human1.addAdjacentVertex(human2);
        human2.addAdjacentVertex(human1);

        human3.addAdjacentVertex(human2);
        human3.addAdjacentVertex(human4);

        human4.addAdjacentVertex(human3);
        human4.addAdjacentVertex(human2);

        human5.addAdjacentVertex(human4);
        human5.addAdjacentVertex(human6);

        human6.addAdjacentVertex(human2);
        human6.addAdjacentVertex(human7);
        human6.addAdjacentVertex(human5);

        human7.addAdjacentVertex(human6);

        DFS(human6, visited);
    }

    private static <T> void DFS(Vertex<T> vertex, Map<T, Boolean> visited) {
        visited.put(vertex.getValue(), Boolean.TRUE);

        System.out.println("vertex: " + vertex.getValue());

        for (Vertex<T> adjacentVertex : vertex.getAdjacentVertices()) {
            if (visited.containsKey(adjacentVertex.getValue())) {
                continue;
            }

            DFS(adjacentVertex, visited);
        }
    }
}
