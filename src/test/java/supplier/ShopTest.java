package supplier;

import fruit.FruitEnum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Bios
 * @className ShopTest
 * @description
 * @date 2024/02/03
 */
public class ShopTest {

    @Test
    public void checkout() {
        Integer appCount = 0;
        Integer strawberryDisCount8 = 0;
        Map<FruitEnum, Integer> shoppingCart = new HashMap<>();
        appCount = 10;
        shoppingCart.put(FruitEnum.Apple, appCount);
        // 验证无折扣正确性
        Assert.assertEquals(FruitEnum.Apple.getPrice().multiply(BigDecimal.valueOf(appCount)), Shop.checkout(shoppingCart));

        // 验证有折扣正确性
        shoppingCart.clear();
        strawberryDisCount8 = 10;
        shoppingCart.put(FruitEnum.StrawberryDis8, strawberryDisCount8);
        Assert.assertEquals(FruitEnum.StrawberryDis8.getPrice().multiply(FruitEnum.StrawberryDis8.getDiscount()).multiply(BigDecimal.valueOf(strawberryDisCount8)), Shop.checkout(shoppingCart));

        // 验证有满减正确性
        shoppingCart.clear();
        strawberryDisCount8 = 10;
        shoppingCart.put(FruitEnum.StrawberryDis8, strawberryDisCount8);
        BigDecimal basicPrice = FruitEnum.StrawberryDis8.getPrice().multiply(FruitEnum.StrawberryDis8.getDiscount()).multiply(BigDecimal.valueOf(strawberryDisCount8));
        BigDecimal disPrice = basicPrice.divide(BigDecimal.valueOf(100), RoundingMode.DOWN).multiply(BigDecimal.valueOf(10));
        BigDecimal finalPrice = basicPrice.subtract(disPrice);
        Shop.openFullReduction();
        Assert.assertEquals(finalPrice, Shop.checkout(shoppingCart));

    }
}