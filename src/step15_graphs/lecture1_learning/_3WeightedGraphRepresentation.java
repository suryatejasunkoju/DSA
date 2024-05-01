package step15_graphs.lecture1_learning;

import utils.PairGeneric;
import utils.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.Utility.printListOfList;
import static utils.Utility.printMatrix;

public class _3WeightedGraphRepresentation {
    public static void main(String[] args) {
        //In adjacency matrix, weights will be saved instead of 1 for nodes having edges.
        //In adjacency list, Pairs will be saved instead of only nodes in each list.

//        5 6
//        1 2 2
//        1 3 3
//        2 4 1
//        2 5 6
//        3 4 4
//        4 5 3
        //https://lh6.googleusercontent.com/CnPL5wUPV5wf2I7lv7jV-GFAoJaXOTZBvmgCgusdczypjn4yLGKPWLtq_rzpmt5EkVOIhxFblvHR8lSKHgCk1Zb8g5k763m0q2rydSWq_znM1I6K_Fc3syLqj4hpRvBOR3b_8MPEZbCjBcgygZudoQQ

        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt(); //n
        int edgeCount = scanner.nextInt(); //m
        System.out.println("nodeCount="+nodeCount+", edgeCount="+edgeCount);
        int temp=edgeCount;
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        List<Triplet> inputEdgeWeightList = new ArrayList<>();
        while(temp-->0)
        {
            Triplet<Integer, Integer, Integer> triplet = new Triplet<>();
            triplet.setU(scanner.nextInt());
            triplet.setV(scanner.nextInt());
            triplet.setW(scanner.nextInt());
            minValue = triplet.getU()<minValue ? triplet.getU(): minValue;
            maxValue = triplet.getU()>maxValue ? triplet.getU(): maxValue;

            minValue = triplet.getV()<minValue ? triplet.getV(): minValue;
            maxValue = triplet.getV()>maxValue ? triplet.getV(): maxValue;

            inputEdgeWeightList.add(triplet);
        }
        System.out.println("minValue="+minValue+", maxValue="+maxValue);
        int[][] adjacencyMatrix = new int[maxValue+1][maxValue+1];
        List<List> adjacencyListRepresentation = new ArrayList<>();
        for (int i = 0; i <= maxValue; i++)
        {
            adjacencyListRepresentation.add(new ArrayList<PairGeneric>());
        }


        for (int i = 0; i < inputEdgeWeightList.size(); i++)
        {
            Triplet triplet = inputEdgeWeightList.get(i);
            System.out.println("adjacencyMatrix[(int) pair.getFirst()][(int) pair.getSecond()]"+adjacencyMatrix[(int) triplet.getU()][(int) triplet.getV()]);
            adjacencyMatrix[(int) triplet.getU()][(int) triplet.getV()]= (int) triplet.getW();
            System.out.println("adjacencyMatrix[(int) pair.getSecond()][(int) pair.getFirst()]="+adjacencyMatrix[(int) triplet.getV()][(int) triplet.getU()]);
            adjacencyMatrix[(int) triplet.getV()][(int) triplet.getU()]= (int) triplet.getW();

            List l1 = adjacencyListRepresentation.get((Integer) triplet.getU());
            l1.add(new PairGeneric<>(triplet.getV(), triplet.getW()));

            List l2 = adjacencyListRepresentation.get((Integer) triplet.getV());
            l2.add(new PairGeneric<>(triplet.getU(), triplet.getW()));
        }
        printMatrix(adjacencyMatrix);
        System.out.println("Graph Representation");
        printListOfList(adjacencyListRepresentation);
    }
}
