package com.test.study.arithmetic;

import java.util.*;

/**
 * @PACKAGE_NAME: com.test.study.arithmetic
 * @USER: xujingrui3
 * @DATE: 2019/11/8
 **/
public class GroupInfo {

    /**
     * 写一个35个数的5个组合结果集
     *
     * @return
     */
    public static List<String> getGroupInfo() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            for (int j = i+1; j < 33; j++) {
                for (int k = j+1; k < 34; k++) {
                    for (int l = k+1; l < 35; l++) {
                        for (int m = l+1; m < 36; m++) {
                            String str = null;
                            if(i > 9){
                                str = i+" "+j+" "+k+" "+l+" "+m;
                            }else{
                                String stri=String.valueOf(i),strj=String.valueOf(j),
                                        strk=String.valueOf(k),strl=String.valueOf(l),strm=String.valueOf(m);
                                if(i < 10){
                                    stri = "0"+stri;
                                }
                                if(j < 10){
                                    strj = "0"+strj;
                                }
                                if(k < 10){
                                    strk = "0"+strk;
                                }
                                if(l < 10){
                                    strl = "0"+strl;
                                }
                                if(m < 10){
                                    strm = "0"+strm;
                                }
                                str = stri+" "+strj+" "+strk+" "+strl+" "+strm;
                            }
                            list.add(str);
                        }
                    }
                }
            }
        }

        return list;

    }

    /**
     * 输入一个数字，找出对应的组合数
     * @param number
     * @param inputList
     * @return
     */
    public static List<String> inputOneNumberResult(int number,List<String> inputList){

        List<String> list = new ArrayList<>();
        if(number > 35){
            return list;
        }
        String tempStr = number > 9 ? String.valueOf(number) : "0"+number;
        for (String str: inputList) {
            if(str.contains(tempStr)){
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 过滤同时包含三个号码的结果集，参数如果是小于10的字符串，则需要在数字钱加0；形如：“02”
     * @param one
     * @param two
     * @param three
     * @return
     */
    public static List<String> filterThreeNumber(String one,String two,String three){
        List<String> resList = new ArrayList<>();
        List<String> list = getGroupInfo();
        for (String str : list) {
            if(str.contains(one) && str.contains(two) && str.contains(three)){
                continue;
            }
            resList.add(str);
        }

        return resList;
    }

    /**
     * 快捷的遍历：itar；iter;
     *  用双色球的开奖结果进行相加，将结果去重以后输出，作为大乐透的推荐号码
     * @param resultArray
     * @return
     */
    public static String countPlusRecommend(int[] resultArray){
        StringBuilder builder = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < resultArray.length; i++) {
            int i1 = resultArray[i];
            for (int j = i+1; j < resultArray.length; j++) {
                int temp = resultArray[i] + resultArray[j];
                if(temp > 35){
                    temp = temp-35;
                }
                set.add(temp);
                if(temp >= 10){
                    builder.append(" "+temp);
                }else{
                    builder.append(" 0"+temp);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("方法结果："+list);

        return builder.toString();
    }

    /**
     * 用双色球的开奖结果进行相减，将结果去重以后输出，作为大乐透的推荐号码
     * @param resultArray
     * @return
     */
    public static String countMinusRecommend(int[] resultArray){
        Set<Integer> set = new HashSet<>();
        for (int i = resultArray.length-1; i > 0; i--) {
            int i1 = resultArray[i];
            for (int j = i-1; j >= 0; j--) {
                int temp = resultArray[i] - resultArray[j];
                set.add(temp);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("方法结果："+list);

        return list.toString();
    }

    public static void main(String[] args) {
        //计算推荐
        int[] tempArray = new int[]{1,7,9,11,24,32};
        System.out.println("看看结果："+countMinusRecommend(tempArray));

//        List<String> list = getGroupInfo();
//        //我想要包含的号码的组合是： 4 9 25
//        list = inputOneNumberResult(20,list);
//        list = inputOneNumberResult(12,list);
//        list = inputOneNumberResult(29,list);
//        list = inputOneNumberResult(26,list);
//        list = inputOneNumberResult(27,list);
//        for (int i=0;i<list.size();i++) {
//            String str=list.get(i);
//            System.out.println("输出结果："+str);
//        }
//        System.out.println("原始总记录数："+getGroupInfo().size());
//        System.out.println("过滤后记录数："+list.size());
    }
}
