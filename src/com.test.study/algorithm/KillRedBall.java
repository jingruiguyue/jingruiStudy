package com.test.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 红球杀号
 * @author jingruiguyue
 *
 */
public class KillRedBall {

	/**
	 * 用开奖红球两两相减的绝对值为杀球号
	 * @return
	 */
	public List<Integer> killOne(PlayInfo info)
	{
		List<Integer> tempList = new ArrayList<Integer>();
		int one  = info.getOneRed();
		tempList.add(one);
		int two = info.getTwoRed();
		tempList.add(two);
		int three = info.getThreeRed();
		tempList.add(three);
		int four = info.getFourRed();
		tempList.add(four);
		int five = info.getFiveRed();
		tempList.add(five);
		int six = info.getSixRed();
		tempList.add(six);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < tempList.size(); i++) {
			for (int j = i+1; j< tempList.size(); j++) {
				int temp = tempList.get(i)-tempList.get(j);
				list.add(Math.abs(temp));
			}
		}
		
		return list;
	}
	/**
	 * 用户红球减篮球的绝对值
	 * @param info当前开奖对象
	 * @param lanqiu 当前开奖的篮球
	 * @return
	 */
	public List<Integer> killTwo(PlayInfo info,int lanqiu)
	{
		List<Integer> tempList = new ArrayList<Integer>();
		int one  = info.getOneRed()-info.getGreen();
		tempList.add(getIs33Sum(one));
		int two = info.getTwoRed()-info.getGreen();
		tempList.add(getIs33Sum(two));
		int three = info.getThreeRed()-info.getGreen();
		tempList.add(getIs33Sum(three));
		int four = info.getFourRed()-info.getGreen();
		tempList.add(getIs33Sum(four));
		int five = info.getFiveRed()-info.getGreen();
		tempList.add(getIs33Sum(five));
		int six = info.getSixRed()-info.getGreen();
		tempList.add(getIs33Sum(six));
		return tempList;
	}
	/**
	 * 判断如果小于0就加33
	 * @return
	 */
	private int getIs33Sum(int temp)
	{
		if(temp < 0)
		{
			return temp + 33;
		}
		else
		{
			return temp;
		}
	}
	/**
	 * 和值拆分百位、十位、各位的和，与每期红球相减
	 * @return
	 */
	public List<Integer> killThree(PlayInfo info)
	{
		int sum = CommonAlgorithm.countSum(info);
		int bai = sum/100;
		int shi = sum/100/10;
		int ge = sum%10;
		int resSum = bai + shi + ge;
		
		return killTwo(info,resSum);
	}
	public List<Integer> killFour()
	{
		return null;
	}
	public List<Integer> killFive()
	{
		return null;
	}
	public List<Integer> killSix()
	{
		return null;
	}
	
}
