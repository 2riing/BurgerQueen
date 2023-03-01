package app;

import app.product.Product;

public class Menu {
    // Product 타입의 변수 products를 통해서 생성자
    private Product[] products;

    public Menu(Product[] products){
        this.products = products;
    }
}
