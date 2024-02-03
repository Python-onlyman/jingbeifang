package consume;

import fruit.FruitEnum;
import supplier.Shop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bios
 * @className ConsumeA
 * @description
 * @date 2024/02/03
 */
public class Consume {
    public static void main(String[] args) {
        Integer appCount = 0;
        Integer strawberryCount = 0;
        Integer mangoCount = 0;
        Integer strawberryDisCount8 = 0;
        // 顾客 A 在超市购买了若19斤苹果和23斤草莓
        Map<FruitEnum, Integer> shoppingCart = new HashMap<>();
        appCount = 19;
        strawberryCount = 23;
        shoppingCart.put(FruitEnum.Apple, appCount);
        shoppingCart.put(FruitEnum.Strawberry, strawberryCount);
        System.out.println(String.format("顾客A购买%s斤苹果,%s斤草莓,结账%s元", appCount, strawberryCount, Shop.checkout(shoppingCart)));

        // 清空购物车
        shoppingCart.clear();
        // 现在顾客 B 在超市购买了16斤苹果、 3斤草莓和6斤芒果
        appCount = 16;
        strawberryCount = 3;
        mangoCount = 6;
        shoppingCart.put(FruitEnum.Apple, appCount);
        shoppingCart.put(FruitEnum.Strawberry, strawberryCount);
        shoppingCart.put(FruitEnum.Mango, mangoCount);
        System.out.println(String.format("顾客B购买%s斤苹果,%s斤草莓,%s斤芒果,结账%s元", appCount, strawberryCount,mangoCount, Shop.checkout(shoppingCart)));

        // 清空购物车
        shoppingCart.clear();
        // 现在顾客 C 在超市购买了24斤苹果、 3斤草莓和26斤芒果
        appCount = 24;
        strawberryDisCount8 = 10;
        mangoCount = 26;
        shoppingCart.put(FruitEnum.Apple, appCount);
        shoppingCart.put(FruitEnum.StrawberryDis8, strawberryDisCount8);
        shoppingCart.put(FruitEnum.Mango, mangoCount);
        System.out.println(String.format("顾客C购买%s斤苹果,%s斤八折草莓,%s斤芒果,结账%s元", appCount, strawberryDisCount8,mangoCount, Shop.checkout(shoppingCart)));

        // 开启满减
        Shop.openFullReduction();
        // 清空购物车
        shoppingCart.clear();

        // 购物满 100 减 10 块。 现在顾客 D 在超市购买了 28 斤苹果、 61斤草莓和 66斤芒果
        appCount = 28;
        strawberryDisCount8 = 61;
        mangoCount = 66;
        shoppingCart.put(FruitEnum.Apple, appCount);
        shoppingCart.put(FruitEnum.StrawberryDis8, strawberryDisCount8);
        shoppingCart.put(FruitEnum.Mango, mangoCount);
        System.out.println(String.format("顾客D参与满100-10,购买%s斤苹果,%s斤八折草莓,%s斤芒果,结账%s元", appCount, strawberryDisCount8,mangoCount, Shop.checkout(shoppingCart)));
    }

}
