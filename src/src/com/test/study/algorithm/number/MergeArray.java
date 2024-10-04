package src.com.test.study.algorithm.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/********************************************************
 * @ClassName:
 * @Description:
 *
 * @Date: 2024/1/4
 * @Author: xujingrui
 * @Version:1.0
 ********************************************************/
public class MergeArray {
    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int[] nums1={1,3,6,0,0,0,0,0};
        int m = 3;
        int[] nums2 = {2,3,4,5,6};
        int n = nums2.length;
        mergeArray.merge(nums1,m,nums2,n);
        System.out.print("结果是：{");
        for (int i=0;i<nums1.length;i++) {
            System.out.print(nums1[i]+",");
        }
        System.out.print("}");

    }
    public int removeRepeatElement(int[] paramArray){
        int length = 0;
        if(paramArray != null){
            length = paramArray.length;
        }
        List<Integer> list = new ArrayList<>();
        if(paramArray.length > 1 ){
            int x=0;
            for(int i = 0;i<paramArray.length;i++){
                if(i == 0){
                    x++;
                }
                int first = paramArray[i];
                int second = paramArray[x];
                if(first == second){

                }
                
                while(first == second){
                    x++;
                    second = paramArray[x];
                }
            }

        }

        return length;
    }
    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        if(nums2 != null && nums2.length > 0){
            int temp = 0;
            for(int i =nums1.length-1; i>=0;i--){

                if(n<0){
                    break;
                }
                int max = 0;
                if(nums1[m] > nums2[n]){
                    max=nums1[m];
                    nums1[m]=0;
                    m--;
                }else{
                    max=nums2[n];
                    n--;
                }
                nums1[i]=max;
            }
        }

    }
}
