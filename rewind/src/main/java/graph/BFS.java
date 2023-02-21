package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Vertex<String> human1 = new Vertex<>("human1");
        Vertex<String> human2 = new Vertex<>("human2");
        Vertex<String> human3 = new Vertex<>("human3");
        Vertex<String> human4 = new Vertex<>("human4");
        Vertex<String> human5 = new Vertex<>("human5");
        Vertex<String> human6 = new Vertex<>("human6");
        Vertex<String> human7 = new Vertex<>("human7");
        Vertex<String> human8 = new Vertex<>("human8");

        human1.addAdjacentVertex(human2);
        human1.addAdjacentVertex(human3);
        human1.addAdjacentVertex(human4);
        human1.addAdjacentVertex(human5);

        human2.addAdjacentVertex(human1);
        human2.addAdjacentVertex(human6);

        human3.addAdjacentVertex(human2);
        human3.addAdjacentVertex(human6);

        human4.addAdjacentVertex(human1);

        human5.addAdjacentVertex(human7);
        human5.addAdjacentVertex(human8);

        human6.addAdjacentVertex(human2);
        human6.addAdjacentVertex(human3);

        human7.addAdjacentVertex(human5);
        human7.addAdjacentVertex(human8);

        human8.addAdjacentVertex(human7);

        Queue<Vertex<String>> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        BFS(human1, queue, visited);
    }

    private static <T> void BFS(Vertex<T> vertex, Queue<Vertex<T>> queue, Map<T, Boolean> visited) {
        visited.put(vertex.getValue(), Boolean.TRUE);
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();

            System.out.println("vertex: " + currentVertex.getValue());

            for (Vertex<T> adjacentVertex : currentVertex.getAdjacentVertices()) {
                if (visited.containsKey(adjacentVertex.getValue())) {
                    continue;
                }

                visited.put(adjacentVertex.getValue(), Boolean.TRUE);
                queue.offer(adjacentVertex);
            }
        }
    }
}
