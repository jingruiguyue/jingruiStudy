package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 生成 1-33 红球所有 6 选 6 组合，并支持按包含号码/和值范围/排除号码筛选。
 */
public class RedCombinationTool {
    private static final int RED_MIN = 1;
    private static final int RED_MAX = 33;
    private static final int RED_COUNT = 6;

    /**
     * 总体思想是把所有可能的组合号码全部生成，然后根据选定的胆码，确定杀掉的号码，再猜和值范围，然后在所有结果中查找满足条件的结果
     * @param args
     */
    public static void main(String[] args) {
        // 在这里指定运行参数
        // 例如：String[] params = {"--include=1,2,3", "--exclude=4,5", "--min-sum=60", "--max-sum=120"};
        String[] params = {
                 "--include=5,23,24", //胆码
                 "--exclude=1,2,3,4,10,11,12,13,14,16,18,19,22,25,28,30,31,32,33", //杀号
                 "--min-sum=100", //最小和值
                 "--max-sum=120" //最大和值
                // "--output=red_combinations.txt",
                // "--regenerate"
        };

        Options options = Options.parse(params);
        if (options == null) {
            printUsage();
            return;
        }

        File outputFile = new File(options.outputPath);
        if (options.regenerate || !outputFile.exists()) {
            try {
                generateAllCombinations(outputFile);
            } catch (IOException e) {
                throw new RuntimeException("写入文件失败: " + outputFile.getAbsolutePath(), e);
            }
        }

        if (options.includeReds.isEmpty() && !options.hasSumRange() && options.excludeReds.isEmpty()) {
            List<Integer> randomPick = randomPick();
            System.out.println("随机一注： " + formatBalls(randomPick));
            return;
        }

        try {
            MatchResult result = printMatches(outputFile, options);
            System.out.println("匹配结果共 " + result.matched + " 条");
            if (options.hasSumRange() && !result.otherNumbers.isEmpty()) {
                System.out.println("其他号码: " + formatCommaSeparated(result.otherNumbers));
            }
        } catch (IOException e) {
            throw new RuntimeException("读取文件失败: " + outputFile.getAbsolutePath(), e);
        }
    }

    private static void generateAllCombinations(File outputFile) throws IOException {
        File parent = outputFile.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int[] comb = new int[RED_COUNT];
            generateDfs(writer, comb, 0, RED_MIN);
        }
    }

    private static void generateDfs(BufferedWriter writer, int[] comb, int index, int start) throws IOException {
        if (index == RED_COUNT) {
            writer.write(formatBalls(comb));
            writer.newLine();
            return;
        }
        for (int i = start; i <= RED_MAX - (RED_COUNT - index) + 1; i++) {
            comb[index] = i;
            generateDfs(writer, comb, index + 1, i + 1);
        }
    }

    private static MatchResult printMatches(File outputFile, Options options) throws IOException {
        int matched = 0;
        java.util.TreeSet<Integer> otherNumbers = new java.util.TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LineInfo info = parseLineWithOther(line, options.includeReds);
                if (matches(info, options)) {
                    System.out.println(line);
                    if (options.hasSumRange()) {
                        otherNumbers.addAll(info.otherNumbers);
                    }
                    matched++;
                }
            }
        }
        return new MatchResult(matched, new ArrayList<>(otherNumbers));
    }

    private static boolean matches(LineInfo info, Options options) {
        for (int v : options.includeReds) {
            if (!info.contains(v)) return false;
        }
        for (int v : options.excludeReds) {
            if (info.contains(v)) return false;
        }
        if (options.hasSumRange()) {
            if (info.sum < options.minSum || info.sum > options.maxSum) return false;
        }
        return true;
    }

    private static LineInfo parseLineWithOther(String line, List<Integer> includeReds) {
        String[] parts = line.split(" ");
        int sum = 0;
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            int v = Integer.parseInt(parts[i]);
            numbers[i] = v;
            sum += v;
        }
        LineInfo info = new LineInfo(numbers, sum);
        for (int v : numbers) {
            if (!includeReds.contains(v)) {
                info.otherNumbers.add(v);
            }
        }
        if (includeReds.isEmpty()) {
            info.otherNumbers.clear();
            for (int v : numbers) info.otherNumbers.add(v);
        }
        return info;
    }

    private static String formatCommaSeparated(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append(formatBall(numbers.get(i)));
        }
        return sb.toString();
    }

    private static List<Integer> randomPick() {
        List<Integer> pool = new ArrayList<>(RED_MAX);
        for (int i = RED_MIN; i <= RED_MAX; i++) pool.add(i);
        Collections.shuffle(pool, new Random());
        List<Integer> pick = new ArrayList<>(pool.subList(0, RED_COUNT));
        Collections.sort(pick);
        return pick;
    }

    private static String formatBalls(int[] balls) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < balls.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(formatBall(balls[i]));
        }
        return sb.toString();
    }

    private static String formatBalls(List<Integer> balls) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < balls.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(formatBall(balls.get(i)));
        }
        return sb.toString();
    }

    private static String formatBall(int ball) {
        return String.format("%02d", ball);
    }

    private static void printUsage() {
        System.out.println("用法：");
        System.out.println("  java game.RedCombinationTool --include=1,2,3 --exclude=4,5 --min-sum=60 --max-sum=120");
        System.out.println("参数说明：");
        System.out.println("  --include=列表      必须包含的红球号码，1-6 个，逗号分隔，如 1,2,3");
        System.out.println("  --exclude=列表      排除的红球号码，逗号分隔，如 4,5");
        System.out.println("  --min-sum=最小和值  指定红球和值最小值");
        System.out.println("  --max-sum=最大和值  指定红球和值最大值");
        System.out.println("  --output=路径       输出组合文件路径，默认 red_combinations.txt");
        System.out.println("  --regenerate        强制重新生成所有组合文件");
        System.out.println("说明：");
        System.out.println("  不传 --include 且不传和值范围，则随机输出一注。");
    }

    private static class Options {
        List<Integer> includeReds = new ArrayList<>();
        List<Integer> excludeReds = new ArrayList<>();
        String outputPath = "red_combinations.txt";
        boolean regenerate = false;
        int minSum = -1;
        int maxSum = -1;

        static Options parse(String[] args) {
            Options options = new Options();
            for (String arg : args) {
                if (arg.startsWith("--include=")) {
                    options.includeReds = parseNumberList(arg.substring("--include=".length()));
                } else if (arg.startsWith("--exclude=")) {
                    options.excludeReds = parseNumberList(arg.substring("--exclude=".length()));
                } else if (arg.startsWith("--min-sum=")) {
                    options.minSum = parseNonNegativeInt(arg.substring("--min-sum=".length()));
                } else if (arg.startsWith("--max-sum=")) {
                    options.maxSum = parseNonNegativeInt(arg.substring("--max-sum=".length()));
                } else if (arg.startsWith("--output=")) {
                    options.outputPath = arg.substring("--output=".length()).trim();
                } else if (arg.equals("--regenerate")) {
                    options.regenerate = true;
                } else {
                    return null;
                }
            }
            if (options.includeReds.size() > RED_COUNT) {
                throw new IllegalArgumentException("包含号码最多 6 个");
            }
            if (!options.excludeReds.isEmpty()) {
                for (int v : options.excludeReds) {
                    if (options.includeReds.contains(v)) {
                        throw new IllegalArgumentException("包含号码和排除号码不能重复: " + v);
                    }
                }
            }
            if (options.hasSumRange()) {
                if (options.minSum > options.maxSum) {
                    throw new IllegalArgumentException("最小和值不能大于最大和值");
                }
            } else if (options.minSum != -1 || options.maxSum != -1) {
                throw new IllegalArgumentException("和值范围需要同时设置最小值和最大值");
            }
            return options;
        }

        boolean hasSumRange() {
            return minSum >= 0 && maxSum >= 0;
        }
    }

    private static int parseNonNegativeInt(String value) {
        try {
            int v = Integer.parseInt(value.trim());
            if (v < 0) throw new NumberFormatException();
            return v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("和值必须是非负整数");
        }
    }

    private static List<Integer> parseNumberList(String value) {
        List<Integer> list = new ArrayList<>();
        String trimmed = value.trim();
        if (trimmed.isEmpty()) return list;
        String[] parts = trimmed.split(",");
        for (String p : parts) {
            String s = p.trim();
            if (s.isEmpty()) continue;
            int v;
            try {
                v = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("号码格式错误: " + s);
            }
            if (v < RED_MIN || v > RED_MAX) {
                throw new IllegalArgumentException("号码超出范围: " + v);
            }
            if (!list.contains(v)) list.add(v);
        }
        Collections.sort(list);
        return list;
    }

    private static class LineInfo {
        final int[] numbers;
        final int sum;
        final List<Integer> otherNumbers;

        LineInfo(int[] numbers, int sum) {
            this.numbers = numbers;
            this.sum = sum;
            this.otherNumbers = new ArrayList<>();
        }

        boolean contains(int value) {
            for (int n : numbers) {
                if (n == value) return true;
            }
            return false;
        }
    }

    private static class MatchResult {
        final int matched;
        final List<Integer> otherNumbers;

        MatchResult(int matched, List<Integer> otherNumbers) {
            this.matched = matched;
            this.otherNumbers = otherNumbers;
        }
    }
}
