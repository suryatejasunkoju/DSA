package step15_graphs.lecture1_learning;

import java.util.*;

import static utils.Utility.printArray;
import static utils.Utility.printListOfList;

public class _5BFS {
    public static void main(String[] args) {
        //Breadth-first-search (OR) Level Order Traversal
        //UnDirectedGraphs:-
        //https://lh3.googleusercontent.com/NWoEVFT-U8F9TX7Kv1CEZ4qZbQUFcg1AipZUQb1vXRyXBDw2jWibgp9ASxiSCz6NP8eqayu5jg6VzACkayc7w3fNCikTgPsdPkI4MC_1rRqOL7VM5XvUydVcTDq89ehdKcBwNJHRYV7fPyNmucJ7Nq8
        List<List> adjacencyList1 = new ArrayList<>();
        adjacencyList1.add(Arrays.asList());
        adjacencyList1.add(Arrays.asList(2, 5));
        adjacencyList1.add(Arrays.asList(1,3,5));
        adjacencyList1.add(Arrays.asList(2, 4, 5));
        adjacencyList1.add(Arrays.asList(3, 5));
        adjacencyList1.add(Arrays.asList(1,2,3,4));
        printListOfList(adjacencyList1);

        breadthFirstSearch(adjacencyList1, 6);


        //Time Complexity: for each node(n times), we are traversing all the nodes adjacent to it.  ==> O(2E)(all adjacent nodes of all nodes)
        //Space Complexity: visited array- O(n)  +  queue-O(n)  +  bfsList-O(n)  ==> O(3*n) ==> O(n)

        //https://lh6.googleusercontent.com/ww-QXmwaaReNu6QHZE6JnDp0kw32F1_lYQnuheL6nqwaKO_EuHVsop61MDlHaseC85kItfGpUTAVbuaJAyvQ3ekQXW1CQfMKY90RMVYdpn9AwDKpXcVZ0trE9evt2HItjTN2cMIZhZxSzaP17cPAzWA
        List<List> adjacencyList2 = new ArrayList<>();
        adjacencyList2.add(Arrays.asList());
        adjacencyList2.add(Arrays.asList(2, 5));
        adjacencyList2.add(Arrays.asList(1,3,5));
        adjacencyList2.add(Arrays.asList(2, 4, 5));
        adjacencyList2.add(Arrays.asList(3, 5));
        adjacencyList2.add(Arrays.asList(1,2,3,4));


        breadthFirstSearch(adjacencyList2, 6);
    }

    private static List<Integer> breadthFirstSearch(List<List> adjacencyList, int N) {
        boolean[] visited = new boolean[N];
//        printArray(visited);
        Queue<Integer> queue = new LinkedList<>();

        List<List> levelWiseList = new ArrayList<>();
        List<Integer> bfsList = new ArrayList<>();

        Integer firstLevelNode = 1;  //since, one-indexed graph
        levelWiseList.add(Arrays.asList(firstLevelNode));
        bfsList.add(firstLevelNode);
        queue.add(firstLevelNode);
        visited[firstLevelNode] = true;
        System.out.println("29.visited node="+firstLevelNode);

        int level = 1;

        while (queue.size() > 0)
        {
            List list = adjacencyList.get(queue.poll());
            levelWiseList.add(new ArrayList<>());
            for (int i = 0; i < list.size(); i++) {
                Integer node = (Integer) list.get(i);
                if (!visited[node])
                {
                    queue.add(node);
                    visited[node] = true;
                    System.out.println("visited node="+node);
                    levelWiseList.get(level).add(node);
                    bfsList.add(node);
                }
            }
            level++;
        }
        System.out.println("LevelWiseList:-");
        printListOfList(levelWiseList);
        System.out.println("bfsList:-"+bfsList+"\n ----------------------------------------------------------------");
        return bfsList;
    }
}
