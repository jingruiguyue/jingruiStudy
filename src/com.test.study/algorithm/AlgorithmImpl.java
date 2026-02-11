package com.test.study.algorithm;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlgorithmImpl implements Algorithm {

	public List<PlayInfo> colorBallAlgorithm(PlayInfo playInfo) {
		
		return null;
	}

	
	/**
	 * 用和值减去每一个红球在与红球取商在与十取余   得到的余数加十的倍数，但不大于33
	 * @param playInfo 
	 * @return 推荐的红球结果集
	 */
	public List<Integer> sumMinalTwoResult(PlayInfo playInfo) 
	{
		List<Integer> list = CommonAlgorithm.countResult(playInfo);
		return CommonAlgorithm.listSort(list);
	}
	/**
	 * ６减２测红法就是将本期中奖红号的第６位分别与第１位及第４位相减，其差数，
	 * 数差个位的替数、补数、减数（也含它们的邻数及同尾数）视为下期中奖红号的预测号。 
	 * @param playInfo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Integer> sixMinalTwoResult(PlayInfo playInfo)
	{
		int six = playInfo.getSixRed();
		int one = playInfo.getOneRed();
		int four = playInfo.getFourRed();
		int sixMinusOne = (six - one)%10;
		int sixMinusFour = (six - four)%10;
		List<Integer> list = new ArrayList<Integer>();
		//第六个球减去第一个球，只取同尾数和邻数
		int tongO = sixMinusOne + 10;
		list.add(tongO);
		int tongT = sixMinusOne + 20;
		list.add(tongT);
		int linshuO = sixMinusOne + 1;
		list.add(linshuO);
		int linshuT = sixMinusOne - 1;
		list.add(linshuT);
		// 替数就是隔５期，如：１与６，２与７、３与８、４与９、５与０
		//第六个球与第四个球的差，取替数+10、邻数+10、凑数+10、补数取本身
		int tishu = sixMinusFour + 5 + 10;
		list.add(tishu);
		//补数，就是和１０数，如：１与９、２与８、３与７、４与６
		int bushuAdd = sixMinusFour + 1;
		list.add(bushuAdd);
		int bushuMinus = sixMinusFour - 1;
		list.add(bushuMinus);
		//凑数就是和５数，如１与４、２与３、６与９、７与８
		int coushuWu = 5 - sixMinusFour ;
		list.add(coushuWu);
		int coushuShiWu = 15 - sixMinusFour;
		list.add(coushuShiWu);
		//邻数，就本身 ± 数，如５的邻数６与４
		int linshu = sixMinusFour + 1;
		list.add(linshu);
		int linshuM = sixMinusFour - 1;
		list.add(linshuM);
		//同尾数，个位相同数，如：８与１８、２８。 
		CommonAlgorithm.listSort(list);
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(integer <= 0 )
			{
				iterator.remove();
			}
		}
		return list;
	}
	public List<Integer> lanqiuResult(PlayInfo playInfo)
	{
		List<Integer> list = new ArrayList<Integer>();
		int lanqiu = playInfo.getGreen();
		fiveteenMinus(list,lanqiu);
		nineteenMinus(list,lanqiu);
		tweentyOneMinus(list,lanqiu);
		lanqiuCheng2(list,lanqiu);
		lanQiuWeiShuCheng4(list,lanqiu);
		lanQiuAdd7OrMinus7(list,lanqiu);
		lanQiuAdd6(list,lanqiu);
		lanQiuAdd2(list,lanqiu);
		CommonAlgorithm.listSort(list);
		
		return list;
	}
	
	/**
	 * 第一组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> oneTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(19);
		list.add(28);
		return list;
	}
	/**
	 * 第二组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> twoTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(11);
		list.add(20);
		list.add(29);
		return list;
	}
	/**
	 * 第三组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> threeTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(12);
		list.add(21);
		list.add(30);
		return list;
	}
	/**
	 * 第四组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> foueTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(13);
		list.add(22);
		list.add(31);
		return list;
	}
	/**
	 * 第五组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> fiveTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(14);
		list.add(23);
		list.add(32);
		return list;
	}
	/**
	 * 第六组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> sixTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(15);
		list.add(24);
		list.add(25);
		return list;
	}
	/**
	 * 第七组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> sevenTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(16);
		list.add(17);
		list.add(26);
		return list;
	}
	/**
	 * 第八组不可能同时出现的红球
	 * @return
	 */
	public List<Integer> eightTeamRedBall()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(9);
		list.add(18);
		list.add(27);
		return list;
	}
	/**
	 * 篮球用15减去上期篮球为下期要杀掉的篮球
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> fiveteenMinus(List<Integer> list,int lanqiu)
	{
		int res = 15 - lanqiu;
		if(res < 0)
		{
			return list;
		}
		else if(res > 10)
		{
			list.add(res);
			list.add(res % 10);
		}
		else if(res > 0 && res < 7)
		{
			list.add(res);
			list.add(res +10);
		}
		else if(res > 6 && res < 10)
		{
			list.add(res);
		}
		else if(res == 10)
		{
			list.add(res);
		}
		return list;
	}
	/**
	 * 篮球用19减去上期篮球为下期要杀掉的篮球
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> nineteenMinus(List<Integer> list,int lanqiu)
	{
		int res = 19 - lanqiu;
	
		if(res > 16)
		{
			list.add(res % 10);
		}
		else if((res > 0 && res < 7) || (res > 10 && res <17))
		{
			int temp = res % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(res > 6 && res < 10)
		{
			list.add(res);
		}
		else if(res == 10)
		{
			list.add(res);
		}
		return list;
	}
	/**
	 * 篮球用21减去上期篮球为下期要杀掉的篮球
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> tweentyOneMinus(List<Integer> list,int lanqiu)
	{
		int res = 21 - lanqiu;
		//最大值20   最小值5
		if(res > 16)
		{
			int temp = res % 10;
			if(temp == 0)
			{
				list.add(10);
			}
			else
			{
				list.add(temp);
			}
			
		}
		else if((res > 4 && res < 7) || (res > 10 && res <17))
		{
			int temp = res % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(res > 6 && res < 10)
		{
			list.add(res);
		}
		else if(res == 10)
		{
			list.add(res);
		}
		return list;
	}
	/**
	 * 用上期篮球乘以2 与10的余数 为要杀的尾数
	 * @param list
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> lanqiuCheng2(List<Integer> list,int lanqiu)
	{
		int tem = (lanqiu * 2)%10;
		if(tem > 6 && tem < 10)
		{
			list.add(tem);
		}
		else if((tem > 0 && tem < 7) || (tem > 10 && tem <17))
		{
			int temp = tem % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(tem == 10)
		{
			list.add(tem);
		}
		return list;
	}
	/**
	 * 篮球尾数乘以4 结果为要杀的号
	 * @param list
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> lanQiuWeiShuCheng4(List<Integer> list,int lanqiu)
	{
		int tem = (lanqiu % 10)*4;
		if(tem > 6 && tem < 10)
		{
			list.add(tem);
		}
		else if((tem > 0 && tem < 7) || (tem > 10 && tem <17))
		{
			int temp = tem % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(tem == 10)
		{
			list.add(tem);
		}
		return list;
	}
	/**
	 * 篮球大于14减7，小于14加7,杀16以内（含16）个位数相同的号码
	 * @param list
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> lanQiuAdd7OrMinus7(List<Integer> list,int lanqiu)
	{
		int tem = 0;
		if(lanqiu > 14)
		{
			tem = lanqiu - 7;
		}
		else if(lanqiu < 14)
		{
			tem = lanqiu + 7;
		}
		else
		{
			tem = lanqiu;
		}
		if(tem > 6 && tem < 10)
		{
			list.add(tem);
		}
		else if((tem > 0 && tem < 7) || (tem > 10 && tem <17))
		{
			int temp = tem % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(tem > 16 && tem < 20) 
		{
			list.add(tem%10);
		}
		else if(tem == 10 || tem == 20)
		{
			list.add(10);
		}
		return list;
	}
	/**
	 * 篮球加2,杀16+6个位数相同的号码
	 * @param list
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> lanQiuAdd6(List<Integer> list,int lanqiu)
	{
		int tem = lanqiu + 6;
		if(tem > 6 && tem < 10)
		{
			list.add(tem);
		}
		else if((tem > 0 && tem < 7) || (tem > 10 && tem <17) || (tem > 20 && tem < 23))
		{
			int temp = tem % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(tem > 16 && tem < 20) 
		{
			list.add(tem%10);
		}
		else if(tem == 10 || tem == 20)
		{
			list.add(10);
		}
		return list;
	}
	/**
	 * 篮球加2,杀16+2个位数相同的号码
	 * @param list
	 * @param lanqiu
	 * @return
	 */
	private List<Integer> lanQiuAdd2(List<Integer> list,int lanqiu)
	{
		int tem = lanqiu + 2;
		if(tem > 6 && tem < 10)
		{
			list.add(tem);
		}
		else if((tem > 0 && tem < 7) || (tem > 10 && tem <17))
		{
			int temp = tem % 10;
			list.add(temp);
			list.add(temp +10);
		}
		else if(tem > 16 && tem < 19) 
		{
			list.add(tem%10);
		}
		else if(tem == 10)
		{
			list.add(10);
		}
		return list;
	}
	
	
}
