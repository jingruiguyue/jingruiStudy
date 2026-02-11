package com.test.study.algorithm;



import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutResult {

	
	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		
		Crawler163 craw = new Crawler163();
		
		AlgorithmImpl algorithmImpl = new AlgorithmImpl();
		
		KillRedBall killRedBall = new KillRedBall(); 
		
		 PlayInfo info = null;
		try {
			//获得上期开奖信息https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=132224809,2402330538&fm=26&gp=0.jpg
			//info = craw.comeTo163();
			info = new PlayInfo();
			info.setOneRed(7);
			info.setTwoRed(13);
			info.setThreeRed(19);
			info.setFourRed(22);
			info.setFiveRed(26);
			info.setSixRed(32);
			info.setGreen(1);
			info.setPlayTypeInfo("24013期");
			//initWriteTxtFile(info.getPlayTypeInfo());
			String ball = "红球:"+ info.getOneRed()+","+info.getTwoRed()+","+info.getThreeRed()
			+","+info.getFourRed()+","+info.getFiveRed()+","+info.getSixRed()+"  篮球："+info.getGreen();
			//initWriteTxtFile(ball);
			System.out.println(ball);
			//获取第一种推荐
			List<Integer> list = algorithmImpl.sumMinalTwoResult(info);
			String first = "第一组推荐：";
			first = appendString(first,list);
			System.out.println(first);
			//initWriteTxtFile(first);
			
			//获取第一种杀号
			List<Integer> killOne = killRedBall.killOne(info);
			CommonAlgorithm.listSort(killOne);
			String two = "第一组杀号：";
			two = appendString(two,killOne);
			System.out.println(two);
			//initWriteTxtFile(two);
			
			//获取第一种推荐和杀号的遗漏
			List<Integer> yilou = new ArrayList<Integer>();
			
			boolean res = false;
			for(int i=1;i<34;i++) {
				for(int j=0;j<list.size();j++){
					if(i == list.get(j)){
						res = true;
					}
				}
				if(!res){
					yilou.add(i);
				}
				else
				{
					res = false;
				}
			}
			for (Iterator iterator = yilou.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				for(Integer integ : killOne){
					if(integer == integ){
						iterator.remove();
					}
				}
			}
			
			String three = "遗漏号码：";
			three = appendString(three, yilou);
			//initWriteTxtFile(three);
			//获取第二种推荐
			List<Integer> slist = algorithmImpl.sixMinalTwoResult(info);
			
			String str = "第二种推荐：";
			str = appendString(str, slist);
			//initWriteTxtFile(str);
			
			List<Integer> killTwo = killRedBall.killTwo(info, info.getGreen());
			
			String kill = "第二种杀号：";
			kill = appendString(kill, killTwo);
			//initWriteTxtFile(kill);
			//计算篮球杀号
			List<Integer> lanqiu = algorithmImpl.lanqiuResult(info);
			
			String lanqiuStr = "篮球杀号：";
			lanqiuStr = appendString(lanqiuStr, lanqiu);
			System.out.println(lanqiuStr);
			//initWriteTxtFile(lanqiuStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String appendString(String str,List<Integer> list)
	{
		for (Integer integer : list) {
			str = str + integer.toString()+",";
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
      	  File path = new File(root,"initpiaopiao");
      	  if(!path.exists()) path.mkdirs();
      	  File file = new File(path,"redresult.txt");
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
