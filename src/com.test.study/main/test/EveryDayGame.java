package com.test.study.main.test;

/**
 * @ClassName: EveryDayGame
 * @Description: 类的描述信息
 * @Author: XuJingrui
 * @Date: 2024/11/21
 */
public class EveryDayGame {

	public static void main(String[] args) {
		String bai = inputSumBaiWei(13, 6);
		System.out.println("BAI结果："+bai);
		String shi = inputSumShiWei(13, 6);
		System.out.println("SHI结果："+shi);
		String ge = inputSumGeWei(13, 6);
		System.out.println("GE结果："+ge);
	}

	private static String inputSumBaiWei(int sum, int bai){
		if(sum < 0 || sum > 27){
			return null;
		}
		if(bai < 0 || bai > 9){
			return null;
		}
		int[] base = {0,1,2,3,4,5,6,7,8,9};
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < base.length; i++) {
			int temp = 0;
			do{
				int sumTemp = bai + base[i] + base[temp];
				if(sum == sumTemp){
					stringBuilder.append(bai).append(" ").append(base[i]).append(" ").append(base[temp]).append(";");
				}
				temp++;
			}while(temp <= 9);
		}

		return stringBuilder.toString();
	}

	private static String inputSumShiWei(int sum, int shi){
		if(sum < 0 || sum > 27){
			return null;
		}
		if(shi < 0 || shi > 9){
			return null;
		}
		int[] base = {0,1,2,3,4,5,6,7,8,9};
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < base.length; i++) {
			int temp = 0;
			do{
				int sumTemp = base[i] + shi + base[temp];
				if(sum == sumTemp){
					stringBuilder.append(base[i]).append(" ").append(shi).append(" ").append(base[temp]).append(";");
				}
				temp++;
			}while(temp <= 9);
		}

		return stringBuilder.toString();
	}

	private static String inputSumGeWei(int sum, int ge){
		if(sum < 0 || sum > 27){
			return null;
		}
		if(ge < 0 || ge > 9){
			return null;
		}
		int[] base = {0,1,2,3,4,5,6,7,8,9};
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < base.length; i++) {
			int temp = 0;
			do{
				int sumTemp = base[i] + base[temp] + ge;
				if(sum == sumTemp){
					stringBuilder.append(base[i]).append(" ").append(base[temp]).append(" ").append(ge).append(";");
				}
				temp++;
			}while(temp <= 9);
		}

		return stringBuilder.toString();
	}

	private static String getRecommentResult(){
		//确定一个范围，和值加减2，得到5个和值
		//确定三个数字，最终结果最多是三个数字
		//最终定两个数字，找出这两个数字涵盖在这个范围的组合结果
		//确定走势和走向，是折还是返回
		//是对称还是紧邻
		//是最冷还是最热
		//是垂直还是大开大合
		//是重复还是完全不重复
		//近三期到五期选三个结果
		//冷热选择三个
		//左邻右舍选择三个
		//历史十期的结果
		//不用想着每次都能正确
		//只要十次能对一次就足矣，就是稳赚不赔

		return null;
	}
}
