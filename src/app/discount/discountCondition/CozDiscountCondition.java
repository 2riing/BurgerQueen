package app.discount.discountCondition;

import app.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.Scanner;

public class CozDiscountCondition {
    private boolean isSatisfied;
    private FixedRateDiscountPolicy fixedRateDiscountPolicy = new FixedRateDiscountPolicy(10);

    public boolean isSatisfied() {
      return isSatisfied;
    };

    private void setIsSatisfied(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");
        int input = scanner.nextInt();

        if (input == 1) setIsSatisfied(true);
        else setIsSatisfied(false);
    }

    public int applyDiscount(int price) {
        return fixedRateDiscountPolicy.calculateDiscountedPrice(price);
    }


}
