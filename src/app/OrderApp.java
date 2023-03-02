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
        Cart cart = new Cart();

        System.out.println("\uD83C\uDF54 BurgerQueen Order Service");
        menu.printMenu();
        int input = scanner.nextInt();
        if (input == 0) {
            cart.printCart();
        }
    }
}