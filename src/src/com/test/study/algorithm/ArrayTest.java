package src.com.test.study.algorithm;

/**
 * @Classname ArrayTest
 * @Description TODO
 * @Date 2025/02/20 12:25
 * @Created by Bruce
 */
public class ArrayTest {

    public static int[] getNotZeroNum(int[] array){

        int ln = array.length, left = 0, right = 0;
        while(right < ln){
            if(array[right] > 0){
                int temp  = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
            }
            right++;
        }

        return array;
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    public static void main(String[] args) {
       int[] test = {-2,1,-3,4,-1,2,1,-5,4};

       maxSubArray(test);
//       int[] res = getNotZeroNum(test);
//        for (int i = 0; i < res.length ; i++) {
//            System.out.println("数组的值："+res[i]);
//        }

    }
}
