package supplier;

import fruit.FruitEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Bios
 * @className Shop
 * @description
 * @date 2024/02/03
 */
public class Shop {
    private static volatile boolean FULL_DIS_FLAG = false;
    private static Map<BigDecimal, BigDecimal> FULL_DIS_MAP = new HashMap<>();

    static {
        FULL_DIS_MAP.put(BigDecimal.valueOf(100), BigDecimal.valueOf(10));
    }
    public static BigDecimal checkout(Map<FruitEnum, Integer> shoppingCart) {
        if (Objects.isNull(shoppingCart) || shoppingCart.size() ==0) {
            return BigDecimal.ZERO;
        }
        AtomicReference<BigDecimal> countSum = new AtomicReference<>(BigDecimal.ZERO);
        // 计算价格(包含折扣)
        shoppingCart.forEach(
                (fruitEnum,count) -> {
                    countSum.set(countSum.get().add(fruitEnum.countPrice().multiply(BigDecimal.valueOf(count))));
                }
        );

        // 超市是否开启满减
        if (FULL_DIS_FLAG) {
            // 满
            AtomicReference<BigDecimal> all = new AtomicReference<>(BigDecimal.ZERO);
            // 减
            AtomicReference<BigDecimal> dis = new AtomicReference<>(BigDecimal.ZERO);
            FULL_DIS_MAP.forEach(
                    (k,v) -> {
                        // 找到匹配的最大满减
                        if (countSum.get().compareTo(k) >= 0) {
                            // 是否比上一个满减的all大
                            if (k.compareTo(all.get()) > 0) {
                                // all换为更大的满减
                                all.set(k);
                                dis.set(v);
                            }
                        }
                    }
            );

            // 满减次数
            BigDecimal disCount = countSum.get().divide(all.get(), RoundingMode.DOWN);
            // 满减总金额
            BigDecimal allDisMoney = dis.get().multiply(disCount);

            return countSum.get().subtract(allDisMoney);
        }

        return countSum.get();
    }

    public static void openFullReduction() {
        FULL_DIS_FLAG = true;
    }
}
