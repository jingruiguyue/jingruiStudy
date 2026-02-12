package com.test.study.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 指定一个数字，计算这个数字等于哪些比他小的数字的和，还可以指定每组计算和值都使用到的数字，可以理解成胆码
 */
public class SumCountRecommend {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 33;
    private static final int DEFAULT_TARGET = 32;//指定要计算的数字，通常是上一期最大的数字
    private static final int DEFAULT_EXACT_COUNT = 2;//计算数字之和的数字个数，2就表示两个数字相加，3就表示三个数字相加
    private static final String DEFAULT_REQUIRED = "5";//所有计算的结果中都包含这个数字

    public static void main(String[] args) {
        try {
            int target = DEFAULT_TARGET;
            int exactCount = DEFAULT_EXACT_COUNT; // 0 代表不限制个数（默认从2个数开始）
            List<Integer> requiredNumbers = new ArrayList<Integer>(); // 支持指定1个或2个数

            if (args != null && args.length > 0) {
                target = Integer.parseInt(args[0]);
            }
            if (args != null && args.length >= 2 && args[1] != null && args[1].trim().length() > 0) {
                exactCount = Integer.parseInt(args[1].trim());
            }
            if (args != null && args.length >= 3 && args[2] != null && args[2].trim().length() > 0) {
                requiredNumbers = parseRequired(args[2].trim());
            } else if (DEFAULT_REQUIRED.length() > 0) {
                requiredNumbers = parseRequired(DEFAULT_REQUIRED);
            }

            List<List<Integer>> results = calculate(target, exactCount, requiredNumbers);
            printResults(target, exactCount, requiredNumbers, results);
        } catch (NumberFormatException e) {
            System.out.println("参数必须是数字，请检查后重试。");
            printUsage();
        } catch (IllegalArgumentException e) {
            System.out.println("参数错误: " + e.getMessage());
        }
    }

    private static List<List<Integer>> calculate(int target, int exactCount, List<Integer> requiredNumbers) {
        if (target < 2 || target > MAX_NUM) {
            throw new IllegalArgumentException("目标数必须在 2-" + MAX_NUM + " 之间");
        }
        if (exactCount < 0) {
            throw new IllegalArgumentException("组合个数不能小于 0");
        }
        if (requiredNumbers.size() > 2) {
            throw new IllegalArgumentException("最多只支持指定 2 个数字");
        }

        int requiredSum = 0;
        for (Integer num : requiredNumbers) {
            if (num == null) {
                throw new IllegalArgumentException("指定数字不能为空");
            }
            if (num < MIN_NUM || num > MAX_NUM) {
                throw new IllegalArgumentException("指定数字超范围(1-33): " + num);
            }
            if (num >= target) {
                throw new IllegalArgumentException("指定数字必须小于目标数: " + num);
            }
            requiredSum += num;
        }
        if (requiredSum > target) {
            throw new IllegalArgumentException("指定数字之和已大于目标数");
        }

        List<Integer> candidates = new ArrayList<Integer>();
        Set<Integer> requiredSet = new LinkedHashSet<Integer>(requiredNumbers);
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            if (i < target && !requiredSet.contains(i)) {
                candidates.add(i);
            }
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>(requiredNumbers);
        backtrack(candidates, 0, target, requiredSum, exactCount, current, results);
        return results;
    }

    private static void backtrack(List<Integer> candidates,
                                  int start,
                                  int target,
                                  int currentSum,
                                  int exactCount,
                                  List<Integer> current,
                                  List<List<Integer>> results) {
        if (currentSum == target) {
            int size = current.size();
            if (exactCount > 0) {
                if (size == exactCount) {
                    results.add(new ArrayList<Integer>(current));
                }
            } else if (size >= 2) {
                results.add(new ArrayList<Integer>(current));
            }
            return;
        }

        if (currentSum > target) {
            return;
        }

        if (exactCount > 0 && current.size() >= exactCount) {
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            int next = candidates.get(i);
            if (currentSum + next > target) {
                continue;
            }
            current.add(next);
            backtrack(candidates, i + 1, target, currentSum + next, exactCount, current, results);
            current.remove(current.size() - 1);
        }
    }

    private static List<Integer> parseRequired(String raw) {
        String[] parts = raw.split(",");
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (String part : parts) {
            String s = part.trim();
            if (s.length() == 0) {
                continue;
            }
            set.add(Integer.parseInt(s));
        }
        return new ArrayList<Integer>(set);
    }

    private static void printResults(int target, int exactCount, List<Integer> required, List<List<Integer>> results) {
        System.out.println("目标数: " + target);
        System.out.println("取值范围: 1-33 且小于目标数");
        if (exactCount > 0) {
            System.out.println("组合个数: " + exactCount);
        } else {
            System.out.println("组合个数: 不限制（从2个数开始）");
        }
        if (required.isEmpty()) {
            System.out.println("指定数字: 无");
        } else {
            System.out.println("指定数字: " + required);
        }

        if (results.isEmpty()) {
            System.out.println("未找到符合条件的组合");
            return;
        }

        System.out.println("组合总数: " + results.size());
        for (List<Integer> group : results) {
            System.out.println(formatGroup(group, target));
        }
    }

    private static String formatGroup(List<Integer> group, int target) {
        List<Integer> sorted = new ArrayList<Integer>(group);
        Collections.sort(sorted);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sorted.size(); i++) {
            if (i > 0) {
                sb.append("+");
            }
            sb.append(sorted.get(i));
        }
        sb.append("=").append(target);
        return sb.toString();
    }

    private static void printUsage() {
        System.out.println("用法: java com.test.study.algorithm.SumCountRecommend <目标数> [组合个数] [指定数字]");
        System.out.println("说明:");
        System.out.println("1) 目标数: 必填，范围 2-33");
        System.out.println("2) 组合个数: 可选，填 0 或不填表示不限制（默认从2个数开始）");
        System.out.println("3) 指定数字: 可选，支持 1 个或 2 个，逗号分隔，例如 5 或 5,9");
        System.out.println("示例:");
        System.out.println("java com.test.study.algorithm.SumCountRecommend 20");
        System.out.println("java com.test.study.algorithm.SumCountRecommend 20 2");
        System.out.println("java com.test.study.algorithm.SumCountRecommend 20 0 5");
        System.out.println("java com.test.study.algorithm.SumCountRecommend 20 0 5,9");
    }
}
