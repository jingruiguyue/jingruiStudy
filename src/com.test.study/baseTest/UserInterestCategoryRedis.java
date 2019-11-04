package com.test.study.baseTest;

import java.util.Date;

/**
 * Created by xujingrui3 on 2019/4/28.
 */
public class UserInterestCategoryRedis {

    /**
     * 品类ID
     */
    private String catLvl3Id;
    /**
     * 感兴趣的分数
     */
    private double interestScore;
    /**
     * 加入时间
     */
    private Date joinDate;
    /**
     * 排名序号
     */
    private int sortNo;

    private int type;

    public UserInterestCategoryRedis(){}
    public UserInterestCategoryRedis(String catLvl3Id, double interestScore, Date joinDate,int sortNo) {
        this.catLvl3Id = catLvl3Id;
        this.interestScore = interestScore;
        this.joinDate = joinDate;
        this.sortNo = sortNo;
    }

    public String getCatLvl3Id() {
        return catLvl3Id;
    }

    public void setCatLvl3Id(String catLvl3Id) {
        this.catLvl3Id = catLvl3Id;
    }

    public double getInterestScore() {
        return interestScore;
    }

    public void setInterestScore(double interestScore) {
        this.interestScore = interestScore;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserInterestCategoryRedis [catLvl3Id=" + catLvl3Id + ", interestScore="
                + interestScore + ",joinDate="+joinDate+",sortNo="+sortNo+"]";
    }
}
