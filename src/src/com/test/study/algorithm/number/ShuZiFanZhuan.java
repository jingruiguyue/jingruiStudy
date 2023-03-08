package src.com.test.study.algorithm.number;

public class ShuZiFanZhuan {
    public static void main(String[] args) {
        int testNum = -54218;
        int res = reverse(testNum);
        System.out.println("测试结果："+res);
    }

    /**
     * 数字反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


}
