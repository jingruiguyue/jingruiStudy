package src.com.test.study.algorithm;

/**
 * 字符串相关面试题集
 */
public class StringExam {
    public static void main(String[] args) {
        String s = "pakakwweab";
        int len = getMaxLength(s);
        System.out.println("不重复子串长度是："+len);
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
