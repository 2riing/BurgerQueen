package app;

import app.product.Product;

public class Order {
    private Cart cart;
    Product[] items;

    public Order(){};
    public Order(Cart cart){
        this.cart = cart;
        this.items = cart.items;
    };

    private int makeTotal(){
        int total = 0;
        for (Product item : items){
            total += item.getPrice();
        }
        return total;
    }
    public void makeOrder(){
        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetail();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", makeTotal());
        System.out.println();
    }
}
