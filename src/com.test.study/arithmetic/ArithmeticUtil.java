package com.test.study.arithmetic;

import java.util.Arrays;

/**
 * 常规算法工具类
 *
 * @USER: xujingrui3
 * @DATE: 2019/10/24
 **/
public class ArithmeticUtil {
    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(Integer[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){
                //如果顺序不对，则交换两个元素
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void quickSort(Integer[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;//左边哨兵的索引
                j=high;//右边哨兵的索引
                //temp就是基准位
                temp = arr[low];//以最左边为  基准位

        while (i<j) {
            //先看右边，依次往左递减
//            //先从右往左找一个小于 基准位的数
//            //当右边的哨兵位置所在的数>基准位的数 时
//            //继续从右往左找（同时 j 索引-1）
//            //找到后会跳出 while循环
            while (temp<=arr[j]&&i<j) {
                j--;
            }

            //再看左边，依次往右递增
            //步骤和上面类似
            while (temp>=arr[i]&&i<j) {
                i++;
            }

            //如果满足条件则交换
            if (i<j) {

//z、y 都是临时参数，用于存放 左右哨兵 所在位置的数据
                       int z = arr[i];
               int y = arr[j];

                 // 左右哨兵 交换数据（互相持有对方的数据）
                arr[i] = y;
                arr[j] = z;

            }

        }

//这时 跳出了 “while (i<j) {}” 循环
//说明 i=j 左右在同一位置
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];//或 arr[low] = arr[j];
        arr[i] = temp;//或 arr[j] = temp;


////i=j
////这时  左半数组<(i或j所在索引的数)<右半数组
////也就是说(i或j所在索引的数)已经确定排序位置， 所以就不用再排序了，
//// 只要用相同的方法 分别处理  左右数组就可以了

        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
//    /**
//     * 快速排序
//     * @param arr
//     * @param low
//     * @param high
//     */
//    public static void quickSort(Integer[] arr,Integer low,Integer high){
//        int i,j,temp,t;
//        if(low>high){
//            return;
//        }
//        i=low;
//        j=high;
//        //temp就是基准位
//        temp = arr[low];
//
//        while (i<j) {
//            //先看右边，依次往左递减
//            while (temp<=arr[j]&&i<j) {
//                j--;
//            }
//            //再看左边，依次往右递增
//            while (temp>=arr[i]&&i<j) {
//                i++;
//            }
//            //如果满足条件则交换
//            if (i<j) {
//                t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
//            }
//
//        }
//        //最后将基准为与i和j相等位置的数字交换
//        arr[low] = arr[i];
//        arr[i] = temp;
//        //递归调用左半数组
//        quickSort(arr, low, j-1);
//        //递归调用右半数组
//        quickSort(arr, j+1, high);
//    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static String selectionSort(Integer[] arr) {

        for(int i=0; i<arr.length; i++) {

            //最小数的索引
            int minIndex = i;
            for(int j=i; j<arr.length; j++) {

                //找到最小数，并记录最小数的索引
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //交换符合条件的数
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return Arrays.toString(arr);
    }

    /**
     * 打印数组信息
     * @param array
     */
    public void display(Integer[] array){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    /*
     * 插入排序方法
     */
    public static void doInsertSort(Integer[] array){
        for(int index = 1; index<array.length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = array[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[leftindex+1] = array[leftindex];
                leftindex--;
            }
            array[leftindex+1] = temp;//把temp放到空位上
        }
    }

}
