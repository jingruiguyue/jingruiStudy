package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 双色球机选主程序
 */
public class ShuangSeQiu {
    private static final int RED_COUNT = 6;
    private static final int RED_MIN = 1;
    private static final int RED_MAX = 33;
    private static final int BLUE_MIN = 1;
    private static final int BLUE_MAX = 16;
    /**
     * 总体思想：随机生成结果；想要几个推荐结果，杀掉的红色号码，杀掉的蓝色号码
     * @param args
     */
    public static void main(String[] args) {
        // 在这里指定运行参数
//        String[] params = {
//控制结果是几注                "--count=5",
//排除的红色号码                "--exclude-red=1,2,3",
//排除的蓝色号码                "--exclude-blue=4,5"
//        };
        String[] params = {
                "--count=5",
                "--exclude-blue=4,5"
        };

        Options options = Options.parse(params);
        if (options == null) {
            printUsage();
            return;
        }

        Random random = new Random();
        for (int i = 1; i <= options.count; i++) {
            List<Integer> reds = pickReds(random, options.excludeReds);
            int blue = pickBlue(random, options.excludeBlues);
            System.out.print("第 " + i + " 注：");
            System.out.println("红：" + formatBalls(reds));
            System.out.println("蓝：" + formatBall(blue));
        }
    }

    private static List<Integer> pickReds(Random random, List<Integer> excludeReds) {
        List<Integer> pool = new ArrayList<>(RED_MAX);
        for (int i = RED_MIN; i <= RED_MAX; i++) {
            if (!excludeReds.contains(i)) {
                pool.add(i);
            }
        }
        if (pool.size() < RED_COUNT) {
            throw new IllegalArgumentException("排除红球过多，无法选出 " + RED_COUNT + " 个红球");
        }
        Collections.shuffle(pool, random);
        List<Integer> selected = new ArrayList<>(pool.subList(0, RED_COUNT));
        Collections.sort(selected);
        return selected;
    }

    private static int pickBlue(Random random, List<Integer> excludeBlues) {
        List<Integer> pool = new ArrayList<>(BLUE_MAX);
        for (int i = BLUE_MIN; i <= BLUE_MAX; i++) {
            if (!excludeBlues.contains(i)) {
                pool.add(i);
            }
        }
        if (pool.isEmpty()) {
            throw new IllegalArgumentException("排除蓝球过多，无法选出 1 个蓝球");
        }
        return pool.get(random.nextInt(pool.size()));
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
        System.out.println("  java game.ShuangSeQiu --count=2 --exclude-red=1,2,3 --exclude-blue=4,5");
        System.out.println("参数说明：");
        System.out.println("  --count=注数           生成几注结果，默认 1");
        System.out.println("  --exclude-red=列表     排除红球号码，逗号分隔，如 1,2,3");
        System.out.println("  --exclude-blue=列表    排除蓝球号码，逗号分隔，如 4,5");
    }

    private static class Options {
        int count = 1;
        List<Integer> excludeReds = new ArrayList<>();
        List<Integer> excludeBlues = new ArrayList<>();

        static Options parse(String[] args) {
            Options options = new Options();
            for (String arg : args) {
                if (arg.startsWith("--count=")) {
                    options.count = parsePositiveInt(arg.substring("--count=".length()));
                } else if (arg.startsWith("--exclude-red=")) {
                    options.excludeReds = parseNumberList(arg.substring("--exclude-red=".length()), RED_MIN, RED_MAX);
                } else if (arg.startsWith("--exclude-blue=")) {
                    options.excludeBlues = parseNumberList(arg.substring("--exclude-blue=".length()), BLUE_MIN, BLUE_MAX);
                } else {
                    return null;
                }
            }
            if (options.count <= 0) return null;
            return options;
        }
    }

    private static int parsePositiveInt(String value) {
        try {
            int v = Integer.parseInt(value.trim());
            if (v <= 0) throw new NumberFormatException();
            return v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("注数必须是正整数");
        }
    }

    private static List<Integer> parseNumberList(String value, int min, int max) {
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
            if (v < min || v > max) {
                throw new IllegalArgumentException("号码超出范围: " + v);
            }
            if (!list.contains(v)) list.add(v);
        }
        return list;
    }
}
