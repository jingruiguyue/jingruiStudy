package com.test.study.arithmetic;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        List<String> list = getGroupInfo();
        //我想要包含的号码的组合是： 4 9 25
        list = inputOneNumberResult(20,list);
        list = inputOneNumberResult(12,list);
        list = inputOneNumberResult(29,list);
        for (int i=0;i<list.size();i++) {
            String str=list.get(i);
            System.out.println("输出结果："+str);
        }
        System.out.println("总记录数："+list.size());
    }
}
