package src.com.test.study.algorithm.number;

/**
 *
 */
public class LiangShuZhiHeInArray {
    public static void main(String[] args) {

    }
    //判断数组nums中两个元素之和等于target的元素下标值
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
