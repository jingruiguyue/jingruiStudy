package src.com.test.study.algorithm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class QuickSortMain {

    public static void main(String[] str){
        int[] testArray = {9,1,8,5,3,4,2,6,7};
        System.out.println("排序前"+ Arrays.toString(testArray));
        quickSortMethod(testArray,0,testArray.length-1);
        System.out.println("排序后"+Arrays.toString(testArray));

        HashSet<Integer> setsss = new HashSet<Integer>();
        HashMap<Integer,String> map = new HashMap<Integer,String>();


    }
    public static void quickSortMethod(int[] array,int low,int high){
        int valueA,valueB,indexA;
        if(low < high){

            indexA = low;
            valueA = array[indexA];

            for (int i = low+1; i <= high ; i++) {
                if(array[i] < valueA){
                    indexA++;
                    valueB=array[indexA];
                    array[indexA]=array[i];
                    array[i]=valueB;
                }
            }
            valueB=array[low];
            array[low]=array[indexA];
            array[indexA]=valueB;

            quickSortMethod(array,low,indexA-1);
            quickSortMethod(array,indexA+1,high);
        }
        System.out.println("方法中排序后"+Arrays.toString(array));
    }

}
