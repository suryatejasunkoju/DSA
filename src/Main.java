import step15_graphs.DirectedGraph;
import step15_graphs.UnDirectedGraph;
import utils.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Utility.initializeAllZeroes;
import static utils.Utility.removeSpacesInBetweenCharacters;

public class Main {
    public static void main(String[] args)
    {
        //https://csacademy.com/app/graph_editor/
//        List<UnDirectedGraph> unDirectedGraphList = readUndirectedGraphInputFile();
//        printUndirectedGraphList(unDirectedGraphList);

        List<DirectedGraph> directedGraphList = readDirectedGraphInputFile();
        printDirectedGraphList(directedGraphList);
    }

    private static void printDirectedGraphList(List<DirectedGraph> directedGraphList) {
        System.out.println(">>>"+directedGraphList.size());
        for (int i = 0; i < directedGraphList.size(); i++) {
            DirectedGraph graph = directedGraphList.get(i);
            graph.printGraphUsingAdjacencyList();
            graph.printAllComponents();
//            graph.printGraphUsingAdjacencyMatrix();
        }
    }

    private static List<DirectedGraph> readDirectedGraphInputFile() {
        List<DirectedGraph> directedGraphList = new ArrayList<>();
        String filePath = "C:\\surya\\personal\\DSA\\src\\step15\\DirectedGraphInputFile.txt";
        Integer ithGraph = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            int lineNo=1;
            while ((line = br.readLine()) != null)
            {
                line=line.trim();
                line = removeSpacesInBetweenCharacters(line);
                if (line.contains(">>>")){
                    String graphCountStr = line.substring(3, line.length()).trim();
//                    System.out.print("graphCountStr="+graphCountStr+",");
                    Integer graphCount = Integer.valueOf(graphCountStr);
//                    System.out.println(">>>"+graphCountStr);
                    directedGraphList = new ArrayList<>(graphCount);
                }
                else if (line.contains("V="))
                {
                    int index = line.indexOf("V=");
//                    System.out.println("index="+index);

                    String vValueStr = line.substring(index+2, line.length()).trim();
//                    System.out.print("vValueStr="+vValueStr+",");
                    Integer vValue = Integer.valueOf(vValueStr);
//                    System.out.println("vValue="+vValue);

                    ithGraph++;
                    DirectedGraph graph = new DirectedGraph(vValue);
                    directedGraphList.add(graph);
                }
                else if (line.contains("zeroIndexed="))
                {
                    String zeroIndexedStr = line.substring(new String("zeroIndexed=").length(), line.length()).trim();
//                    System.out.print("zeroIndexedStr="+zeroIndexedStr+",");
                    Boolean zeroIndexed = Boolean.valueOf(zeroIndexedStr);
//                    System.out.println("zeroIndexed="+zeroIndexed);

//                    System.out.println("unDirectedGraphList.size()="+unDirectedGraphList.size()+", (ithGraph-1)="+(ithGraph-1));

                    DirectedGraph currentGraph = directedGraphList.get(ithGraph-1);
                    currentGraph.setZeroIndexed(zeroIndexed);
                    if (zeroIndexed){
                        currentGraph.setAdjacencyMatrix(new Integer[currentGraph.getVertexCount()][currentGraph.getVertexCount()]);
                        currentGraph.setAdjacencyList(new ArrayList<>(currentGraph.getVertexCount()));
                        currentGraph.setVisited(initializeAllZeroes(new Integer[currentGraph.getVertexCount()]));
                    }
                    else{
                        currentGraph.setAdjacencyMatrix(new Integer[currentGraph.getVertexCount()+1][currentGraph.getVertexCount()+1]);
                        currentGraph.setAdjacencyList(new ArrayList<>(currentGraph.getVertexCount()+1));
                        currentGraph.setVisited(initializeAllZeroes(new Integer[currentGraph.getVertexCount()+1]));
                    }
                }
                else if (line.contains("->")) {
                    DirectedGraph currentGraph = directedGraphList.get(ithGraph-1);
//                    currentGraph.printGraph();
                    int index = line.indexOf("->");
                    Integer node=Integer.valueOf(line.substring(0,index));
                    List<Integer> adjacencyList = Utility.getArrayListFromStr(line.substring(index+2, line.length()));
//                    System.out.println("node="+node+",adjacencyList="+adjacencyList);
                    currentGraph.updateAdjacencyMatrix(node, adjacencyList);
//                    System.out.println("currentGraph.getZeroIndexed()="+currentGraph.getZeroIndexed()+", currentGraph.getAdjacencyList().size()="+currentGraph.getAdjacencyList().size());
                    if (!currentGraph.getZeroIndexed() && currentGraph.getAdjacencyList().size()==0){
//                        System.out.println("iuhy");
                        List<List> graphAdjacencyList = currentGraph.getAdjacencyList();
                        graphAdjacencyList.add(new ArrayList<>());
                    }

                    List<List> graphAdjacencyList = currentGraph.getAdjacencyList();
//                        System.out.println("graphAdjacencyList.size()="+graphAdjacencyList.size());
                    graphAdjacencyList.add(adjacencyList);
                }
//                System.out.println(lineNo+"."+line);
                lineNo++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return directedGraphList;
    }

    private static void printUndirectedGraphList(List<UnDirectedGraph> unDirectedGraphList) {
        System.out.println(">>>"+unDirectedGraphList.size());
        for (int i = 0; i < unDirectedGraphList.size(); i++) {
            UnDirectedGraph graph = unDirectedGraphList.get(i);
//            graph.printGraphUsingAdjacencyMatrix();
            graph.printGraphUsingAdjacencyList();
        }
    }

    private static List<UnDirectedGraph> readUndirectedGraphInputFile() {
        List<UnDirectedGraph> unDirectedGraphList = new ArrayList<>();
        String filePath = "C:\\surya\\personal\\DSA\\src\\step15\\UndirectedGraphInputFile.txt";
        Integer ithGraph = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNo=1;
            while ((line = br.readLine()) != null)
            {
                line=line.trim();
                line = removeSpacesInBetweenCharacters(line);
                if (line.contains(">>>")){
                    String graphCountStr = line.substring(3, line.length()).trim();
//                    System.out.print("graphCountStr="+graphCountStr+",");
                    Integer graphCount = Integer.valueOf(graphCountStr);
//                    System.out.println(">>>"+graphCountStr);
                    unDirectedGraphList = new ArrayList<>(graphCount);
                }
                else if (line.contains("V="))
                {
                    int index = line.indexOf("V=");
//                    System.out.println("index="+index);

                    String vValueStr = line.substring(index+2, line.length()).trim();
//                    System.out.print("vValueStr="+vValueStr+",");
                    Integer vValue = Integer.valueOf(vValueStr);
//                    System.out.println("vValue="+vValue);

                    ithGraph++;
                    UnDirectedGraph graph = new UnDirectedGraph(vValue);
                    unDirectedGraphList.add(graph);
                }
                else if (line.contains("zeroIndexed="))
                {
                    String zeroIndexedStr = line.substring(new String("zeroIndexed=").length(), line.length()).trim();
//                    System.out.print("zeroIndexedStr="+zeroIndexedStr+",");
                    Boolean zeroIndexed = Boolean.valueOf(zeroIndexedStr);
//                    System.out.println("zeroIndexed="+zeroIndexed);

//                    System.out.println("unDirectedGraphList.size()="+unDirectedGraphList.size()+", (ithGraph-1)="+(ithGraph-1));

                    UnDirectedGraph currentGraph = unDirectedGraphList.get(ithGraph-1);
                    currentGraph.setZeroIndexed(zeroIndexed);
                    if (zeroIndexed){
                        currentGraph.setAdjacencyMatrix(new Integer[currentGraph.getVertexCount()][currentGraph.getVertexCount()]);
                        currentGraph.setAdjacencyList(new ArrayList<>(currentGraph.getVertexCount()));
                        currentGraph.setVisited(new Integer[currentGraph.getVertexCount()]);
                    }
                    else{
                        currentGraph.setAdjacencyMatrix(new Integer[currentGraph.getVertexCount()+1][currentGraph.getVertexCount()+1]);
                        currentGraph.setAdjacencyList(new ArrayList<>(currentGraph.getVertexCount()+1));
                        currentGraph.setVisited(new Integer[currentGraph.getVertexCount()+1]);
                    }
                }
                else if (line.contains("->")) {
                    UnDirectedGraph currentGraph = unDirectedGraphList.get(ithGraph-1);
//                    currentGraph.printGraph();
                    int index = line.indexOf("->");
                    Integer node=Integer.valueOf(line.substring(0,index));
                    List<Integer> adjacencyList = Utility.getArrayListFromStr(line.substring(index+2, line.length()));
//                    System.out.println("node="+node+",adjacencyList="+adjacencyList);
                    currentGraph.updateAdjacencyMatrix(node, adjacencyList);
//                    System.out.println("currentGraph.getZeroIndexed()="+currentGraph.getZeroIndexed()+", currentGraph.getAdjacencyList().size()="+currentGraph.getAdjacencyList().size());
                    if (!currentGraph.getZeroIndexed() && currentGraph.getAdjacencyList().size()==0){
//                        System.out.println("iuhy");
                        List<List> graphAdjacencyList = currentGraph.getAdjacencyList();
                        graphAdjacencyList.add(new ArrayList<>());
                    }

                    List<List> graphAdjacencyList = currentGraph.getAdjacencyList();
//                        System.out.println("graphAdjacencyList.size()="+graphAdjacencyList.size());
                    graphAdjacencyList.add(adjacencyList);
                }
//                System.out.println(lineNo+"."+line);
                lineNo++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return unDirectedGraphList;
    }
}