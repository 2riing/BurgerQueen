package app;

import app.discount.discountCondition.CozDiscountCondition;
import app.discount.discountCondition.KidDiscountCondition;
import app.product.Product;

public class Order {
    private Cart cart;
    Product[] items;

    public Order(){};
    public Order(Cart cart){
        this.cart = cart;
        this.items = cart.items;
    };

    public void makeOrder(){

        CozDiscountCondition cozDiscountCondition = new CozDiscountCondition();
        KidDiscountCondition kidDiscountCondition = new KidDiscountCondition();

        cozDiscountCondition.checkDiscountCondition();
        kidDiscountCondition.checkDiscountCondition();

        int totalPrice = cart.calculateTotalPrice();

        int finalPrice = totalPrice;

        if(cozDiscountCondition.isSatisfied()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);
        if(kidDiscountCondition.isSatisfied()) finalPrice = kidDiscountCondition.applyDiscount(finalPrice);

        System.out.println("[ð£] ì£¼ë¬¸ì´ ìë£ëììµëë¤. ");
        System.out.println("[ð£] ì£¼ë¬¸ ë´ì­ì ë¤ìê³¼ ê°ìµëë¤. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetail();

        System.out.println("-".repeat(60));
        System.out.printf("ê¸ì¡ í©ê³      : %dì\n", totalPrice);
        System.out.printf("í ì¸ ì ì© ê¸ì¡      : %dì\n", finalPrice);
        System.out.println();
    }
}
