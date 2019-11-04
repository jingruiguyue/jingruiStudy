package com.test.study.baseTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestListRemoveAll {

    public static void main(String[] args) {
        try {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<UserInterestCategoryRedis> userList = new ArrayList<UserInterestCategoryRedis>();
        String string = "2018-10-29 21:59:06";
        UserInterestCategoryRedis user = new UserInterestCategoryRedis("123556第二",2.5,sdf.parse(string),1);
        String string1 = "2018-10-25 21:59:06";
        UserInterestCategoryRedis user2 = new UserInterestCategoryRedis("956756第一",2.5,sdf.parse(string1),2);
        String string2 = "2018-10-26 21:59:06";
        UserInterestCategoryRedis user3 = new UserInterestCategoryRedis("467756第三",2.0,sdf.parse(string2),3);
        userList.add(user3);
        userList.add(user2);
        userList.add(user);

        List<UserInterestCategoryRedis> tempList = new ArrayList<UserInterestCategoryRedis>(userList);
        UserInterestCategoryRedis user22 = tempList.get(1);
        user22.setType(5);

        UserInterestCategoryRedis user33 = tempList.get(2);
        user33.setType(2);
            tempList.remove(tempList.get(1));
            tempList.remove(tempList.get(1));
//        tempList.add(user33);
//        tempList.add(user22);
            for (UserInterestCategoryRedis us: userList){
                System.out.println("userList us.getCatLvl3Id()"+us.getCatLvl3Id()+"us.getType()"+us.getType());
            }
            for (UserInterestCategoryRedis us: tempList){
                System.out.println("tempList us.getCatLvl3Id()"+us.getCatLvl3Id()+"us.getType()"+us.getType());
            }
        userList.removeAll(tempList);
        System.out.println("比较结果："+userList.size());

        }catch (Exception e){
            System.out.println("ddddd");
        }
    }
}
