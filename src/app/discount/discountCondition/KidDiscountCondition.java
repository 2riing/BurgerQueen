package app.discount.discountCondition;

import app.discount.discountPolicy.FixedAmountDiscountPolicy;

import java.util.Scanner;

public class KidDiscountCondition {

    private boolean isSatisfied;
    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(500);

    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("나이를 알려주세요!");
        int input = scanner.nextInt();

        setSatisfied(input < 20);
    }

    public int applyDiscount(int price) {
        return fixedAmountDiscountPolicy.calculateDiscountedPrice(price);
    }
}
