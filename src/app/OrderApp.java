package app;

import app.product.Product;
import app.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getAllProducts();
        Menu menu = new Menu(products);
        Cart cart = new Cart(productRepository, menu);

        System.out.println("\uD83C\uDF54 BurgerQueen Order Service");
        while(true) {
            menu.printMenu();
            String input = scanner.nextLine();
            if (input.equals("+")){
                // 주문내역 출력
                break;
            } else {
                int num = Integer.parseInt(input);
                if (num == 0) cart.printCart();
                else if (0 < num && num < products.length + 1) {
                    cart.addToCart(num);
                }
            }
        }
    }
}