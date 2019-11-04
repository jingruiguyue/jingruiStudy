package com.test.study.baseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujingrui3 on 2019/5/1.
 */
public class TempMain {

    public static void main(String[] args) {

        int makeFeedTime = 15/5;
        System.out.println("取商数："+makeFeedTime);


//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//        System.out.println("当前时间："+format.format(new Date()));
//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("234");
//        list.add(10,"sdfa");
//        List<String> temp = new ArrayList<>();
//        temp.addAll(list);
//        list.removeAll(list);
//        System.out.println("temp:"+temp.size());
//        System.out.println("list:"+list.isEmpty());

//        for (String str:images){
//            JSONObject jsonObject = JSONObject.parseObject(str);
//            ImageDTO imageDTO = new ImageDTO();
//            imageDTO.setUrl(jsonObject.getString("url"));
//            imageDTO.setWidth(jsonObject.getInteger("width"));
//            imageDTO.setHeight(jsonObject.getInteger("height"));
//            resultList.add(imageDTO);
//        }
//        String[] images = imageUrl.split("@");
//        System.out.println("大小："+images.length);
//        for (String str:images){
//            System.out.println(str);
//        }
//        temp.remove(0);
//        System.out.println("list大小：" + list.size() + "第一个元素：" + list.get(0));
//        System.out.println("temp大小："+temp.size()+"第一个元素："+temp.get(0));
//        List<String> listOld = new ArrayList<>();
//
//        listOld.add("123");
//        listOld.add("234");
//
//        boolean res = list.removeAll(listOld);
//        System.out.println("移除结果"+res);
//        System.out.println("第一个元素" + list.get(0));
//        System.out.println("第二个元素"+list.get(1));
    }

    public static class TempNullList {

        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            System.out.println("第一个元素："+list.get(0));
        }
    }
}
