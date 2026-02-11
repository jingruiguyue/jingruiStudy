package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 快乐8机选：从 1-80 中选 20 个号码，可指定包含/排除号码。
 */
public class KuaiLe8 {
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 80;
    private static final int PICK_COUNT = 20;

    public static void main(String[] args) {
        // 在这里指定运行参数
        // 例如：String[] params = {"--include=1,2,3", "--exclude=4,5"};
        String[] params = {
                // "--include=1,2,3",
                // "--exclude=4,5"
        };

        Options options = Options.parse(params);
        if (options == null) {
            printUsage();
            return;
        }

        List<Integer> result = pickNumbers(options.includeNumbers, options.excludeNumbers);
        System.out.println("快乐8机选： " + formatNumbers(result));
    }

    private static List<Integer> pickNumbers(List<Integer> includeNumbers, List<Integer> excludeNumbers) {
        if (includeNumbers.size() > PICK_COUNT) {
            throw new IllegalArgumentException("包含号码最多 " + PICK_COUNT + " 个");
        }

        List<Integer> pool = new ArrayList<>(NUM_MAX);
        for (int i = NUM_MIN; i <= NUM_MAX; i++) {
            if (!excludeNumbers.contains(i) && !includeNumbers.contains(i)) {
                pool.add(i);
            }
        }

        int need = PICK_COUNT - includeNumbers.size();
        if (pool.size() < need) {
            throw new IllegalArgumentException("可选号码不足，排除过多");
        }

        Collections.shuffle(pool, new Random());
        List<Integer> result = new ArrayList<>(PICK_COUNT);
        result.addAll(includeNumbers);
        result.addAll(pool.subList(0, need));
        Collections.sort(result);
        return result;
    }

    private static String formatNumbers(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(formatNumber(numbers.get(i)));
        }
        return sb.toString();
    }

    private static String formatNumber(int number) {
        return String.format("%02d", number);
    }

    private static void printUsage() {
        System.out.println("用法：");
        System.out.println("  java game.KuaiLe8 --include=1,2,3 --exclude=4,5");
        System.out.println("参数说明：");
        System.out.println("  --include=列表     必须包含的号码，逗号分隔，如 1,2,3");
        System.out.println("  --exclude=列表     排除的号码，逗号分隔，如 4,5");
    }

    private static class Options {
        List<Integer> includeNumbers = new ArrayList<>();
        List<Integer> excludeNumbers = new ArrayList<>();

        static Options parse(String[] args) {
            Options options = new Options();
            for (String arg : args) {
                if (arg.startsWith("--include=")) {
                    options.includeNumbers = parseNumberList(arg.substring("--include=".length()));
                } else if (arg.startsWith("--exclude=")) {
                    options.excludeNumbers = parseNumberList(arg.substring("--exclude=".length()));
                } else {
                    return null;
                }
            }
            for (int v : options.excludeNumbers) {
                if (options.includeNumbers.contains(v)) {
                    throw new IllegalArgumentException("包含号码和排除号码不能重复: " + v);
                }
            }
            return options;
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
            if (v < NUM_MIN || v > NUM_MAX) {
                throw new IllegalArgumentException("号码超出范围: " + v);
            }
            if (!list.contains(v)) list.add(v);
        }
        Collections.sort(list);
        return list;
    }
}
