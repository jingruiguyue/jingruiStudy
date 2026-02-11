package game;

import java.util.*;

/**
 * @ClassName MaJiang
 * @Description TODO（用一句话描述类的作用）
 * @Author xujingrui
 * @Date 2025/12/23 12:16
 */
public class MaJiang {
    // 花色顺序
    private static final List<String> SUIT_ORDER = List.of("万", "筒", "条");
    // 字牌顺序
    private static final List<String> HONOR_ORDER = List.of("东", "南", "西", "北");
    // 牌对应 Unicode 图标
    private static final Map<String, String> TILE_ICON_MAP = Map.ofEntries(
            Map.entry("1万", "🀇"), Map.entry("2万", "🀈"), Map.entry("3万", "🀉"),
            Map.entry("4万", "🀊"), Map.entry("5万", "🀋"), Map.entry("6万", "🀌"),
            Map.entry("7万", "🀍"), Map.entry("8万", "🀎"), Map.entry("9万", "🀏"),

            Map.entry("1筒", "🀙"), Map.entry("2筒", "🀚"), Map.entry("3筒", "🀛"),
            Map.entry("4筒", "🀜"), Map.entry("5筒", "🀝"), Map.entry("6筒", "🀞"),
            Map.entry("7筒", "🀟"), Map.entry("8筒", "🀠"), Map.entry("9筒", "🀡"),

            Map.entry("1条", "🀐"), Map.entry("2条", "🀑"), Map.entry("3条", "🀒"),
            Map.entry("4条", "🀓"), Map.entry("5条", "🀔"), Map.entry("6条", "🀕"),
            Map.entry("7条", "🀖"), Map.entry("8条", "🀗"), Map.entry("9条", "🀘"),

            Map.entry("东", "🀀"), Map.entry("南", "🀁"),
            Map.entry("西", "🀂"), Map.entry("北", "🀃")
    );

    // 玩家类
    static class Player {
        List<String> hand = new ArrayList<>();
        String name;
        Player(String name) { this.name = name; }
    }

    public static void main(String[] args) {

        // 1️⃣ 初始化牌堆
        List<String> deck = initDeck();
        Collections.shuffle(deck);

        // 2️⃣ 创建 4 名玩家
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) players[i] = new Player("玩家" + (i+1));

        // 3️⃣ 发 13 张牌给每个人
        for (int i = 0; i < 13; i++) {
            for (Player p : players) {
                p.hand.add(deck.remove(0));
            }
        }

        // 4️⃣ 玩家手牌排序
        for (Player p : players) sortHand(p.hand);

        // 5️⃣ 输出手牌
        for (Player p : players) {
            System.out.print(p.name + " 手牌：");
            printHandWithIcons(p.hand);
        }

        // 6️⃣ 模拟玩家 1 摸一张牌
        String drawn = deck.remove(0);
        players[0].hand.add(drawn);
        sortHand(players[0].hand);
        System.out.println(players[0].name + " 摸牌: " + TILE_ICON_MAP.get(drawn));
        System.out.print(players[0].name + " 当前手牌：");
        printHandWithIcons(players[0].hand);

        // 7️⃣ 判断玩家 1 是否胡牌
        boolean canHu = canHu(players[0].hand);
        System.out.println(players[0].name + " 是否可胡牌？ " + (canHu ? "可以胡" : "不可以胡"));
    }

    // 初始化牌堆
    private static List<String> initDeck() {
        List<String> deck = new ArrayList<>(136);
        for (String suit : SUIT_ORDER) {
            for (int num = 1; num <= 9; num++) {
                for (int i = 0; i < 4; i++) deck.add(num + suit);
            }
        }
        for (String honor : HONOR_ORDER) {
            for (int i = 0; i < 4; i++) deck.add(honor);
        }
        return deck;
    }

    // 手牌排序（数字牌按花色+数字排序，字牌在后）
    private static void sortHand(List<String> hand) {
        hand.sort((a, b) -> {
            boolean aIsNum = a.length() == 2;
            boolean bIsNum = b.length() == 2;
            if (aIsNum && !bIsNum) return -1;
            if (!aIsNum && bIsNum) return 1;
            if (!aIsNum) return HONOR_ORDER.indexOf(a) - HONOR_ORDER.indexOf(b);

            int suitA = SUIT_ORDER.indexOf(a.substring(1));
            int suitB = SUIT_ORDER.indexOf(b.substring(1));
            if (suitA != suitB) return suitA - suitB;
            return a.charAt(0) - b.charAt(0);
        });
    }

    // 控制台打印手牌
    private static void printHandWithIcons(List<String> hand) {
        for (String t : hand) System.out.print(TILE_ICON_MAP.get(t) + " ");
        System.out.println();
    }

    // 将牌字符串转成整数编码（方便胡牌算法）
    private static int tileToInt(String tile) {
        if (tile.length() == 2) {
            int num = tile.charAt(0) - '0';
            char suit = tile.charAt(1);
            if (suit == '万') return 10 + num;
            if (suit == '筒') return 20 + num;
            if (suit == '条') return 30 + num;
        } else {
            switch (tile) {
                case "东": return 41;
                case "南": return 42;
                case "西": return 43;
                case "北": return 44;
            }
        }
        return -1;
    }

    // 判断是否胡牌
    private static boolean canHu(List<String> tiles) {
        int[] cnt = new int[50];
        for (String t : tiles) cnt[tileToInt(t)]++;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 2) {
                cnt[i] -= 2;
                if (canFormSets(cnt)) return true;
                cnt[i] += 2;
            }
        }
        return false;
    }

    private static boolean canFormSets(int[] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                // 刻子
                if (cnt[i] >= 3) { cnt[i] -= 3; continue; }
                // 顺子（仅数字牌）
                if (i <= 37 && cnt[i+1] > 0 && cnt[i+2] > 0) {
                    cnt[i]--; cnt[i+1]--; cnt[i+2]--; continue;
                }
                return false;
            }
        }
        return true;
    }
}
