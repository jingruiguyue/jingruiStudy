package src.com.test.study.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串相关面试题集
 */
public class StringExam {
    public static void main(String[] args) {
        String s = "pakakwweab";
        int len = getMaxLength(s);
        int sl = lengthOfLongestSubstring(s);
        System.out.println("不重复子串长度是："+sl);
    }

    public static int lengthOfLongestSubstring(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        for(int left = 0, right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while(set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }

    public static int getMaxLength(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int maxLength = 1;
        int countLength = 0;
        int left = 0;
        int right = 0;
        char[] countArray = str.toCharArray();
        for (int i = 0; i < countArray.length; i++) {

            right = i ;
            int tempLeft = left;
            boolean isTrue = true;
            while(tempLeft < right){
                if(countArray[tempLeft] == countArray[right]){
                    left = right;
                    if(countLength > maxLength){
                        maxLength = countLength;
                        countLength = 0;
                    }
                    isTrue = false;
                    break;
                }else{
                    tempLeft++;

                }
            }
            if(i == countArray.length-1){
                if(countLength > maxLength){
                    maxLength = countLength;
                }
                return maxLength;
            }
            if(isTrue){
                countLength++;
            }

//            if(countArray[left] == countArray[right]){
//                left = right;
//
//
//            }else{
//                left++;
//                countLength++;
//            }
        }


        return maxLength;
    }
}
