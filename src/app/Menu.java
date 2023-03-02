package app;

import app.product.Product;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;
import app.product.subproduct.Drink;

public class Menu {
    // Product 타입의 변수 products를 통해서 생성자
    private Product[] products;

    public Menu(){}
    public Menu(Product[] products){
        this.products = products;
    }

    public void printMenu(){
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }
    public void printHamburgers(boolean printPrice){
        System.out.println("🍔 햄버거");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }
    public void printSides(boolean printPrice){
        System.out.println("🍟 사이드");
        for (Product product : products) {
            if (product instanceof Side) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    public void printDrinks(boolean printPrice){
        System.out.println("🥤 음료");
        for (Product product : products) {
            if (product instanceof Drink) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product) {
        System.out.printf(
                "(%d) %s %5dKcal %5d원\n",
                product.getId(), product.getName(), product.getKcal(), product.getPrice()
        );
    }
}
