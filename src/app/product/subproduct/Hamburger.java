package app.product.subproduct;

import app.product.Product;

public class Hamburger extends Product {
    private boolean isBurgerSet = false;
    private int burgerSetPrice;

    public Hamburger(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice){
        super(id, name, price, kcal);
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }

    public Hamburger(Hamburger hamburger){
        super(hamburger.getName(), hamburger.getId(), hamburger.getKcal());
        this.isBurgerSet = hamburger.isBurgerSet();
        this.burgerSetPrice = getBurgerSetPrice();
    }

    // isBurgerSet getter
    public boolean isBurgerSet(){
        return isBurgerSet;
    }

    // isBurgerSet setter
    public void setIsBurgerSet(boolean isBurgerSet){
        this.isBurgerSet = isBurgerSet;
    }

    // burgerSetPrice getter
    public int getBurgerSetPrice(){
        return burgerSetPrice;
    }

    // burgerSetPrice setter
    public void setBurgerSetPrice(int burgerSetPrice){
        this.burgerSetPrice = burgerSetPrice;
    }
}
