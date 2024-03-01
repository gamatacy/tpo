import org.example.DFS;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DFSTest {

    @ParameterizedTest
    @MethodSource("graphProvider")
    public void testDFS(List<Integer>[] graph, int startVertex, int[] expected) {
        assertArrayEquals(expected, DFS.search(graph, startVertex));
    }

    @Test
    public void testInvalidGraph() {
        List<Integer>[] graph = null;
        assertThrows(IllegalArgumentException.class, () -> DFS.search(graph, 2));
    }

    @Test
    public void testInvalidStartVertex() {
        List<Integer>[] graph = new List[4];
        for (int i = 0; i < 4; i++) {
            graph[i] = new LinkedList<>();
        }
        assertThrows(IllegalArgumentException.class, () -> DFS.search(graph, 5));
    }

    static List<Object[]> graphProvider() {
        List<Object[]> data = new LinkedList<>();

        List<Integer>[] graph1 = new List[4];
        for (int i = 0; i < 4; i++) {
            graph1[i] = new LinkedList<>();
        }
        graph1[0].add(1);
        graph1[0].add(2);
        graph1[1].add(2);
        graph1[2].add(0);
        graph1[2].add(3);
        graph1[3].add(3);
        data.add(new Object[]{graph1, 2, new int[]{2, 0, 1, 3}});

        List<Integer>[] graph2 = new List[5];
        for (int i = 0; i < 5; i++) {
            graph2[i] = new LinkedList<>();
        }
        graph2[0].add(1);
        graph2[0].add(2);
        graph2[1].add(3);
        graph2[1].add(4);
        graph2[2].add(4);
        data.add(new Object[]{graph2, 0, new int[]{0, 1, 3, 4, 2}});

        return data;
    }

}
