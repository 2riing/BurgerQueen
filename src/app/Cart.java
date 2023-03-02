package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    private ProductRepository productRepository;
    private Menu menu;

    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }
    public void addToCart(int productId) {
        Product product = productRepository.findById(productId);
        // items에 추가 ! 하기 전에 옵션 골라야함
        chooseOption(product);

//        if (product instanceof Hamburger) {
//            Hamburger hamburger = (Hamburger) product;
//            if(hamburger.isBurgerSet()) product = composeSet(hamburger);
//        }

        Product newProduct;
        if (product instanceof Hamburger) newProduct = new Hamburger((Hamburger) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else if (product instanceof Drink) newProduct = new Drink((Drink) product);
        else newProduct = product;

        Product[] newItems = new Product[items.length + 1 ];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = newProduct;
        items = newItems;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }



    private void chooseOption(Product product) {
        String input;
        if (product instanceof Hamburger) {
            System.out.printf(
                    "단품으로 주문하시겠어요? (1)_단품(%5d원) (2)_세트(%5d원)",
                    product.getPrice(), ((Hamburger) product).getBurgerSetPrice()
            );
            int HamburgerNum = scanner.nextInt();
            if (HamburgerNum == 2) {
                ((Hamburger) product).setIsBurgerSet(true);
                composeSet((Hamburger) product);
            };
        }
        else if (product instanceof Side) {
            System.out.println("케첩은 몇개가 필요하신가요?");
            int ketchupNum = scanner.nextInt();// 케첩 개수 입력 받음
            ((Side) product).setKetchup(ketchupNum);// product에 저장
        }
        else if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            int strawNum = scanner.nextInt();
            if (strawNum == 2) ((Drink) product).setHasStraw(false);
        }
    }

    private BurgerSet composeSet(Hamburger hamburger) {
        System.out.println("사이드를 골라주세요");
        menu.printSides(false);

        int sideInput = scanner.nextInt();
        Side side = (Side) productRepository.findById(sideInput);
        // Side 타입일 때만 출력
        Side newSide = new Side(side);
        chooseOption(newSide);

        System.out.println("음료를 골라주세요");
        menu.printDrinks(false);

        int drinkInput = scanner.nextInt();
        // Drink 타입일 때만 출력
        Drink drink = (Drink) productRepository.findById(drinkInput);
        Drink newDrink = new Drink(drink);
        chooseOption(newDrink);

        String name = hamburger.getName() + "세트";
        int price = hamburger.getBurgerSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + + drink.getKcal();

        return new BurgerSet(name, price, kcal, hamburger, newSide, newDrink);
    }

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
