package step15_graphs.lecture1_learning;

import utils.PairGeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.Utility.printListOfList;
import static utils.Utility.printMatrix;

public class _2GraphRepresentation {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt(); //n
        int edgeCount = scanner.nextInt(); //m
        System.out.println("nodeCount="+nodeCount+", edgeCount="+edgeCount);
        int temp=edgeCount;
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        List<PairGeneric> inputEdgeList = new ArrayList<>();
        while(temp-->0)
        {
            PairGeneric<Integer, Integer> pair = new PairGeneric<>();
            pair.setFirst(scanner.nextInt());
            pair.setSecond(scanner.nextInt());
            minValue = pair.getFirst()<minValue ? pair.getFirst(): minValue;
            maxValue = pair.getFirst()>maxValue ? pair.getFirst(): maxValue;

            minValue = pair.getSecond()<minValue ? pair.getSecond(): minValue;
            maxValue = pair.getSecond()>maxValue ? pair.getSecond(): maxValue;

            inputEdgeList.add(pair);
        }
        System.out.println("minValue="+minValue+", maxValue="+maxValue);
        int[][] adjacencyMatrix = new int[maxValue+1][maxValue+1];
        List<List> adjacencyListRepresentation = new ArrayList<>();
        for (int i = 0; i <= maxValue; i++)
        {
            adjacencyListRepresentation.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < inputEdgeList.size(); i++)
        {
            PairGeneric pair = inputEdgeList.get(i);
            System.out.println("adjacencyMatrix[(int) pair.getFirst()][(int) pair.getSecond()]"+adjacencyMatrix[(int) pair.getFirst()][(int) pair.getSecond()]);
            adjacencyMatrix[(int) pair.getFirst()][(int) pair.getSecond()]=1;
            System.out.println("adjacencyMatrix[(int) pair.getSecond()][(int) pair.getFirst()]="+adjacencyMatrix[(int) pair.getSecond()][(int) pair.getFirst()]);
            adjacencyMatrix[(int) pair.getSecond()][(int) pair.getFirst()]=1;

            List l1 = adjacencyListRepresentation.get((Integer) pair.getFirst());
            l1.add(pair.getSecond());
            List l2 = adjacencyListRepresentation.get((Integer) pair.getSecond());
            l2.add(pair.getFirst());
        }
        printMatrix(adjacencyMatrix);
        System.out.println("Graph Representation");
        printListOfList(adjacencyListRepresentation);
        //https://lh3.googleusercontent.com/YhQ-8oPpVrlHZ0CuBWTcFLdDptuTmSmtNBhMPMtSfLc3-Z21zD0_rNWN8_M_4pI572jhIIrxLYZTlo8w0PbQEdn-M8HSkKAneSvlG35UW1-KAitO2XrxBp7j2l7fRs3aJtJRF4m6BJM8A7nch5M0keo
    }
}
