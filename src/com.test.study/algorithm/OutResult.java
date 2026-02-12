package com.test.study.algorithm;



import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OutResult {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// 手动输入：期号 + 开奖号码（出球顺序，6红1蓝）
		String issue = "2026017";
		int[] drawResult = {5, 29, 1, 3, 18, 32, 4};
		PrintStream consoleOut = System.out;
		PrintStream teeOut = null;

		try {
			appendSeparatorToFile();
			teeOut = createTeePrintStream(consoleOut, new File("out_result.txt"));
			System.setOut(teeOut);
		} catch (IOException ioException) {
			consoleOut.println("初始化输出文件失败: " + ioException.getMessage());
		}

		AlgorithmImpl algorithmImpl = new AlgorithmImpl();
		KillRedBall killRedBall = new KillRedBall();

		PlayInfo info = null;
		try {
			info = buildByManualInput(issue, drawResult);
			info.setPlayTypeInfo(new Date().toString());

			String ball = issue + "期，出球顺序: 红球[" + info.getOneRed() + "," + info.getTwoRed() + "," + info.getThreeRed()
					+ "," + info.getFourRed() + "," + info.getFiveRed() + "," + info.getSixRed() + "] 蓝球[" + info.getGreen() + "]";
			System.out.println(ball);

			// 获取第一种推荐
			List<Integer> list = algorithmImpl.sumMinalTwoResult(info);
			String first = "第一组推荐：";
			first = appendString(first, list);
			System.out.println(first);

			// 获取第一种杀号
			List<Integer> killOne = killRedBall.killOne(info);
			CommonAlgorithm.listSort(killOne);
			String two = "第一组杀号：";
			two = appendString(two, killOne);
			System.out.println(two);

			// 获取第一种推荐和杀号的遗漏
			List<Integer> yilou = new ArrayList<Integer>();

			boolean res = false;
			for (int i = 1; i < 34; i++) {
				for (int j = 0; j < list.size(); j++) {
					if (i == list.get(j)) {
						res = true;
					}
				}
				if (!res) {
					yilou.add(i);
				} else {
					res = false;
				}
			}
			for (Iterator iterator = yilou.iterator(); iterator.hasNext(); ) {
				Integer integer = (Integer) iterator.next();
				for (Integer integ : killOne) {
					if (integer == integ) {
						iterator.remove();
					}
				}
			}

			String three = "遗漏号码：";
			three = appendString(three, yilou);

			// 获取第二种推荐
			List<Integer> slist = algorithmImpl.sixMinalTwoResult(info);

			String str = "第二种推荐：";
			str = appendString(str, slist);

			List<Integer> killTwo = killRedBall.killTwo(info, info.getGreen());

			String kill = "第二种杀号：";
			kill = appendString(kill, killTwo);

			// 计算篮球杀号
			List<Integer> lanqiu = algorithmImpl.lanqiuResult(info);

			String lanqiuStr = "篮球杀号：";
			lanqiuStr = appendString(lanqiuStr, lanqiu);
			System.out.println(lanqiuStr);
		} catch (Exception e) {
			System.out.println("处理失败，期号=" + issue + "，原因=" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (teeOut != null) {
				teeOut.flush();
				System.setOut(consoleOut);
				teeOut.close();
			}
		}
	}

	private static void appendSeparatorToFile() throws IOException {
		File file = new File("out_result.txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write("************************************************************");
			writer.newLine();
		}
	}

	private static PrintStream createTeePrintStream(PrintStream consoleOut, File file) throws IOException {
		OutputStream fileOut = new FileOutputStream(file, true);
		OutputStream tee = new TeeOutputStream(consoleOut, fileOut);
		return new PrintStream(tee, true, "UTF-8");
	}

	private static class TeeOutputStream extends OutputStream {
		private final OutputStream first;
		private final OutputStream second;

		private TeeOutputStream(OutputStream first, OutputStream second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public void write(int b) throws IOException {
			first.write(b);
			second.write(b);
		}

		@Override
		public void flush() throws IOException {
			first.flush();
			second.flush();
		}

		@Override
		public void close() throws IOException {
			flush();
			second.close();
		}
	}

	private static PlayInfo buildByManualInput(String issue, int[] drawResult) {
		if (drawResult == null || drawResult.length != 7) {
			throw new IllegalArgumentException("drawResult 必须是 7 个号码（6红1蓝）");
		}
		validateBalls(drawResult);

		PlayInfo info = new PlayInfo();
		info.setPlayTypeInfo(issue);
		info.setOneRed(drawResult[0]);
		info.setTwoRed(drawResult[1]);
		info.setThreeRed(drawResult[2]);
		info.setFourRed(drawResult[3]);
		info.setFiveRed(drawResult[4]);
		info.setSixRed(drawResult[5]);
		info.setGreen(drawResult[6]);
		return info;
	}

	private static void validateBalls(int[] balls) {
		for (int i = 0; i < 6; i++) {
			if (balls[i] < 1 || balls[i] > 33) {
				throw new IllegalArgumentException("第" + (i + 1) + "个红球超范围(1-33): " + balls[i]);
			}
		}
		if (balls[6] < 1 || balls[6] > 16) {
			throw new IllegalArgumentException("蓝球超范围(1-16): " + balls[6]);
		}
	}

	private static String appendString(String str, List<Integer> list) {
		for (Integer integer : list) {
			str = str + integer.toString() + ",";
		}
		return str;
	}

	/**
	 * 写文件
	 *
	 * @param newStr
	 *            新内容
	 * @throws IOException
	 */
	public static boolean initWriteTxtFile(String newStr) throws IOException {
		// 先读取原有文件内容，然后进行写入操作
		boolean flag = false;
		String filein = newStr + "\r\n";
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			File root = new File("F:");
			File path = new File(root, "initpiaopiao");
			if (!path.exists()) path.mkdirs();
			File file = new File(path, "redresult.txt");
			// 文件路径
			// File file = new File(filePath);
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buf = new StringBuffer();

			// 保存该文件原有的内容
			for (int j = 1; (temp = br.readLine()) != null; j++) {
				buf = buf.append(temp);
				// System.getProperty("line.separator")
				// 行与行之间的分隔符 相当于“\n”
				buf = buf.append(System.getProperty("line.separator"));
			}
			buf.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buf.toString().toCharArray());
			pw.flush();
			flag = true;
		} catch (IOException e1) {
			throw e1;
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return flag;
	}
}
