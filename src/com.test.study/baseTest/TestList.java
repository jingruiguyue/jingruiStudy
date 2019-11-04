package com.test.study.baseTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xujingrui3 on 2019/4/28.
 */
public class TestList {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<UserInterestCategoryRedis> userInterestCategoryRedisList = new ArrayList<UserInterestCategoryRedis>();
        String string = "2018-10-29 21:59:06";
        UserInterestCategoryRedis user = new UserInterestCategoryRedis("123556第二",2.5,sdf.parse(string),1);
        String string1 = "2018-10-25 21:59:06";
        UserInterestCategoryRedis user2 = new UserInterestCategoryRedis("956756第一",2.5,sdf.parse(string1),2);
        String string2 = "2018-10-26 21:59:06";
        UserInterestCategoryRedis user3 = new UserInterestCategoryRedis("467756第三",2.0,sdf.parse(string2),3);

        userInterestCategoryRedisList.add(user3);
        userInterestCategoryRedisList.add(user2);
        userInterestCategoryRedisList.add(user);
        System.out.println("排序前："+userInterestCategoryRedisList);
//        for (UserInterestCategoryRedis us : userInterestCategoryRedisList){
//
//            System.out.println("排名：****"+us.getCatLvl3Id());
//        }

        Collections.sort(userInterestCategoryRedisList, new Comparator<UserInterestCategoryRedis>() {
            @Override
            public int compare(UserInterestCategoryRedis o1, UserInterestCategoryRedis o2) {
                Double o1Score = o1.getInterestScore();
                Double o2Score = o2.getInterestScore();
                System.out.println("两个对象分数比较的结果："+(o1Score.doubleValue() != o2Score.doubleValue()));
                if (o1Score.doubleValue() != o2Score.doubleValue()) {
                    return o2Score.compareTo(o1Score);
                } else {
                    return o2.getJoinDate().compareTo(o1.getJoinDate());
                }
//                return o2Score.compareTo(o1Score);
            }
        });
        System.out.println("排序后："+userInterestCategoryRedisList);
        for (int i = 0; i < userInterestCategoryRedisList.size(); i++) {
            UserInterestCategoryRedis temp = userInterestCategoryRedisList.get(i);
            if(i == 0){
                temp.setSortNo(1);
            }else if(i == 1){
                temp.setSortNo(2);
            }else if(i == 2){
                temp.setSortNo(3);
            }
        }
        System.out.println("指定排名后："+userInterestCategoryRedisList);

    }


}
