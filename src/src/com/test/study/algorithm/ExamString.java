package src.com.test.study.algorithm;

import java.util.Locale;

public class ExamString {
    public static void main(String[] args) {
        String str = "aaabBbbccaaa";
        //着急演示错误的原因是没有调用方法  System.out.println("测试结果："+str);
        System.out.println("测试结果："+getMaxChildString(str));
    }
    public static String getMaxChildString(String str){
        if(str == null || str.length() == 0){
            return "输入字符串不合法，无法截取正确结果！";
        }
        int maxLength = 1;
        int countLength = 0;
        int start = 0;
        int end = 0;
        int countStart = 0;
        String testString = str.toLowerCase(Locale.ROOT);
        char[] countArray = testString.toCharArray();
        for (int i = 0; i < countArray.length; i++) {
            if(countArray[countStart] == countArray[i]){
                countLength++;
                if(countLength > maxLength){
                    maxLength = countLength;
                    start = countStart;
                    end = i;
                }
            }else{
                countStart = i;
                countLength = 1;
            }
        }
        return str.substring(start,end+1);
    }
}
