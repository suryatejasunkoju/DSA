package step15_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utility.initializeAllZeroes;

public class DirectedGraph {
    Integer[][] adjacencyMatrix;
    Integer vertexCount;
    Boolean isZeroIndexed;
    String graphImgUrl;
    List<List> adjacencyList = new ArrayList<>();
    Integer[] visited;


    public DirectedGraph() {
    }

    public DirectedGraph(Integer[][] adjacencyMatrix, Integer vertexCount, Boolean isZeroIndexed, String graphImgUrl, List<List> adjacencyList, Integer[] visited) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.vertexCount = vertexCount;
        this.isZeroIndexed = isZeroIndexed;
        this.graphImgUrl = graphImgUrl;
        this.adjacencyList = adjacencyList;
        this.visited = visited;
    }

    public DirectedGraph(Integer vertexCount) {
        this.vertexCount = vertexCount;
    }


    public Integer[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(Integer[][] adjacencyMatrix) {
        this.adjacencyMatrix = initializeAllZeroes(adjacencyMatrix);
    }

    public Integer getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(Integer vertexCount) {
        this.vertexCount = vertexCount;
    }

    public Boolean getZeroIndexed() {
        return isZeroIndexed;
    }

    public void setZeroIndexed(Boolean zeroIndexed) {
        isZeroIndexed = zeroIndexed;
    }

    public String getGraphImgUrl() {
        return graphImgUrl;
    }

    public void setGraphImgUrl(String graphImgUrl) {
        this.graphImgUrl = graphImgUrl;
    }

    public List<List> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<List> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public Integer[] getVisited() {
        return visited;
    }

    public void setVisited(Integer[] visited) {
        this.visited = visited;
    }


    @Override
    public String toString() {
        return "DirectedGraph{" +
                "adjacencyMatrix=" + Arrays.toString(adjacencyMatrix) +
                ", vertexCount=" + vertexCount +
                ", isZeroIndexed=" + isZeroIndexed +
                ", graphImgUrl='" + graphImgUrl + '\'' +
                ", adjacencyList=" + adjacencyList +
                ", visited=" + Arrays.toString(visited) +
                '}';
    }

    public void printGraphUsingAdjacencyMatrix()
    {
//        System.out.println("---------");
        System.out.println("V="+this.getVertexCount());
        System.out.println("zeroIndexed="+this.getZeroIndexed());
        System.out.println("E="+findEdgeCountForDirectedGraph(this));
        for (int i = 0; i < adjacencyMatrix.length; i++)
        {
            if (!this.isZeroIndexed && i==0){
                continue;
            }
            System.out.print(i+"->{");
            for(int j = 0; j < adjacencyMatrix[i].length; j++) {
                if(adjacencyMatrix[i][j]!=null && adjacencyMatrix[i][j]==1){
                    System.out.print(j);
//                    System.out.print(adjacencyMatrix[i][j]);
//                    if(j!=adjacencyMatrix.length-1)
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
        System.out.println("---------");
//        for (int i = 0; i < adjacencyMatrix.length; i++) {
//            System.out.println(i+" "+ Arrays.toString(adjacencyMatrix[i]));
//        }
    }
    public void printGraphUsingAdjacencyList(){
        Boolean isZeroIndexed = this.getZeroIndexed();
        System.out.println("V="+this.getVertexCount());
        System.out.println("zeroIndexed="+this.getZeroIndexed());
        System.out.println("E="+findEdgeCountForDirectedGraph(this));
        for (int i = 0; i < adjacencyList.size(); i++)
        {
            if(!isZeroIndexed && i==0)
            {
                //skip zero'th list
//                 continue;
            }
            System.out.print(i+"->{");
            List currentList = adjacencyList.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                System.out.print(currentList.get(j)+",");
            }
            System.out.println("}");
        }

//        System.out.println("====");
//        for (int i = 0; i < adjacencyList.size(); i++) {
//            List list = adjacencyList.get(i);
//            System.out.println(list);
//        }
    }

    private Integer findEdgeCountForDirectedGraph(DirectedGraph directedGraph) {
        //This method will handle the case where there are self-node-edges.
        Integer[][] adjacencyMatrix = directedGraph.getAdjacencyMatrix();
        Boolean zeroIndexed = directedGraph.getZeroIndexed();
        Integer edgeCount = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if(!zeroIndexed && i==0){
                continue;
            }
            Integer[] row = adjacencyMatrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1)
                    edgeCount++;
            }
        }
        return edgeCount;
    }

    public void updateAdjacencyMatrix(Integer u, List<Integer> vList) {
//        System.out.println("u="+u+",vList="+vList+",adjacencyMatrix.size="+adjacencyMatrix.length);
        for (int i = 0; i < vList.size(); i++){
            Integer adjacentNode = vList.get(i);
            adjacencyMatrix[u][adjacentNode]=1;
        }
    }

    public void printAllComponents()
    {
        Integer componentCount =0;
        for (int i = 0; i < adjacencyList.size(); i++){
            Boolean zeroIndexed = this.isZeroIndexed;
            if(i==0 && !zeroIndexed){
                continue;
            }
            if(visited[i]!=1){
                traverseComponent(i);
                componentCount++;
            }
        }
        System.out.println("Total components Count="+componentCount);
    }

    private void traverseComponent(int startingNode)
    {
        visited[startingNode]=1;
        List<Integer> list = adjacencyList.get(startingNode);
        System.out.println("traversing started at="+startingNode+", its List="+list);
        for (int i = 0; i < list.size(); i++)
        {
            if (visited[list.get(i)]==1){
                System.out.println(list.get(i)+" is already visited");
                return;
            }
            else{
                visited[list.get(i)]=1;
                System.out.println(list.get(i)+" is visited now");
                traverseComponent(list.get(i));
            }
        }
    }
}
