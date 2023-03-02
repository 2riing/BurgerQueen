package app.discount.discountPolicy;

public class FixedAmountDiscountPolicy {

    private int discountAmount;

    public FixedAmountDiscountPolicy(int dircountAmount) {
        this.discountAmount = discountAmount;
    }

    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }
}
