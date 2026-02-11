package com.test.study.algorithm;

import java.io.IOException;

public class Crawler163 {

	public PlayInfo comeTo163() throws IOException {
		PlayInfo info = new PlayInfo();
		int[] result = new int[7];
		info.setOneRed(result[0]);
		info.setTwoRed(result[1]);
		info.setThreeRed(result[2]);
		info.setFourRed(result[3]);
		info.setFiveRed(result[4]);
		info.setSixRed(result[5]);
		info.setGreen(result[6]);
		return info;
	}
}
