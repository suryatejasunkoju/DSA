package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static String removeSpacesInBetweenCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static List<Integer> getArrayListFromStr(String arrAsString) {
//        System.out.print("arrAsString="+arrAsString+",");
        List<Integer> integerList = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d+").matcher(arrAsString);
        while (matcher.find()) {
            integerList.add(Integer.parseInt(matcher.group()));
        }
//        System.out.println("returning integerList="+integerList);
        return integerList;
    }
    public static Integer[][] initializeAllZeroes(Integer[][] matrix){
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j <matrix[i].length; j++)
            {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }
    public static Integer[] initializeAllZeroes(Integer[] array){
        for (int j = 0; j <array.length; j++)
        {
            array[j] = 0;
        }
        return array;
    }
    public static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("]");
        }
    }

    public static void printListOfList(List<List> listList)
    {
        for (int i = 0; i < listList.size(); i++)
        {
            List list = listList.get(i);
            System.out.println(list);
        }
    }
    public static void printArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]+",");
        }
        System.out.println("]");
    }

    public static void printArray(boolean[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]+",");
        }
        System.out.println("]");
    }
}
