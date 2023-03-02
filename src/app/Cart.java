package app;

import app.product.Product;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    // 금액 합계하는 메서드 하나 해줌니까?


    public void printCart() {
        // 장바구니에 물견이 있을 때는 출력!
        if(items.length > 0) {
            calculateTotalPrice();
            printCartItemDetail();
        } else {
            System.out.println("장바구니에 물건이 없습니다!");
            // 이전 메뉴로 돌아가는 로직
        }
    }
    public int calculateTotalPrice() {
        // 여기 안에서 쓰고 return 할거니까 지역변수로 선언
        int totalPrices = 0;
        for (Product item : items) {
            totalPrices += item.getPrice();
        }
        return totalPrices;
    }
    private void printCartItemDetail(){
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        for (Product item : items) {
            // Product로 업캐스팅 되어있으니, BurgerSet 멤버를 사용할 수 있도록 다운캐스팅
            BurgerSet burgerSet = (BurgerSet) item;
            if (item instanceof BurgerSet){
                System.out.printf(
                        "%s %5d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        item.getName(), item.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "있음" : "없음"
                );
            } else if (item instanceof Hamburger) {
                System.out.printf(
                        "%s %5d원 (단품)",
                        item.getName(), item.getPrice()
                );
            } else if (item instanceof Side) {
                System.out.printf(
                        "%s %5d원 (케첩 %d개)",
                        item.getName(), item.getPrice(), ((Side) item).getKetchup()
                );
            } else if (item instanceof Drink) {
                System.out.printf(
                        "%s %5d원 (케첩 %d개)",
                        item.getName(), item.getPrice(), ((Drink) item).hasStraw()
                );
            }
        }

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요.");

        String input = scanner.nextLine();
        if (input.equals("")) {

        }
    }

}
