package fruit;

import java.math.BigDecimal;

/**
 * @author Bios
 * @className FruitEnum
 * @description
 * @date 2024/02/03
 */
public enum FruitEnum {
    Apple(BigDecimal.valueOf(8),BigDecimal.ONE),
    Strawberry(BigDecimal.valueOf(13), BigDecimal.ONE),
    Mango(BigDecimal.valueOf(20), BigDecimal.ONE),
    StrawberryDis8(BigDecimal.valueOf(13), BigDecimal.valueOf(0.8));
    private BigDecimal price;
    private BigDecimal discount;
    FruitEnum(BigDecimal price, BigDecimal discount) {
        this.price = price;
        this.discount = discount;
    }

    public BigDecimal countPrice() {
        return price.multiply(discount);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
