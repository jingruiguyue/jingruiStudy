package com.test.study.algorithm;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CommonAlgorithm {

	/**
	 * 求总和
	 * @param info
	 * @return
	 */
	public static int countSum(PlayInfo info)
	{
		return info.getOneRed()+info.getTwoRed()+info.getThreeRed()
		+ info.getFourRed()+info.getFiveRed()+info.getSixRed();
	}
	@SuppressWarnings("rawtypes")
	public static List<Integer> listSort(List<Integer> list)
	{
		Collections.sort(list);
		int temp = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(temp == integer)
			{
				iterator.remove();
			}
			temp = integer;
		}
		return list;
	}
	/**
	 * 计算推荐红球
	 * @param info
	 * @return
	 */
	public static List<Integer> countResult(PlayInfo info)
	{
		int sum = countSum(info);
		List<Integer> list = new ArrayList<Integer>();
		int one = (sum-info.getOneRed())/info.getOneRed()%10;
		list.add(one);
		System.out.println("第一组尾数推荐:"+ one);
		int two = (sum-info.getTwoRed())/info.getTwoRed()%10;
		list.add(two);
		System.out.println("第二组尾数推荐:"+ two);
		int three = (sum-info.getThreeRed())/info.getThreeRed()%10;
		list.add(three);
		System.out.println("第三组尾数推荐:"+ three);
		int four = (sum-info.getFourRed())/info.getFourRed()%10;
		list.add(four);
		System.out.println("第四组尾数推荐:"+ four);
		int five = (sum-info.getFiveRed())/info.getFiveRed()%10;
		list.add(five);
		System.out.println("第五组尾数推荐:"+ five);
		int six = (sum-info.getSixRed())/info.getSixRed()%10;
		list.add(six);
		System.out.println("第六组尾数推荐:"+ six);

		return list;
		
	}
	/**
	 * 推荐可能开出的红球
	 * @param sum
	 * @param redBall
	 * @param listRes
	 * @return
	 */
	private static List<Integer> countRedBall(int sum,int redBall,List<Integer> listRes)
	{

		int temp = (sum-redBall)/redBall%10;
		System.out.println("计算结果："+temp);
		//int negateExact =  Math.negateExact(temp);
		listRes.add(temp);
//		int res1 = temp+10;
//		listRes.add(res1);
//		int res2 = temp+20;
//		listRes.add(res2);
//		int res3 = temp+30;
//		if(res3 < 34)
//		{
//			listRes.add(res3);
//		}
		return listRes;
	}
	/**
	 * 用绝杀红球集合到推荐集合中去对比并移除绝杀号
	 * @param listRes 推荐号集合
	 * @param killList 杀球号 集合
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<Integer> chooseRedBall(List<Integer> listRes,List<Integer> killList)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		for (Integer integer : listRes) {
			boolean res = true;
			for (Integer kill : killList) {
				if(integer == kill)
				{
					res=false;
					break;
				}
			}
			if(res)
			{
				list.add(integer);
			}
		}
		return list;
		
	}
}
