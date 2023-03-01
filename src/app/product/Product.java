package app.product;

public class Product {
    private int id;
    private String name;
    private int price;
    private int kcal;

    public Product(){}

    public  Product(int id, String name, int price, int kcal){
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }

    // id getter
    public int getId() {
        return id;
    }

    // id setter
    public void setId(int id){
        this.id = id;
    }

    // name getter
    public String getName(){
        return name;
    }

    // name setter
    public void setName(String name){
        this.name = name;
    }

    // price getter
    public int getPrice(){
        return price;
    }
    // price setter
    public void setPrice(int price){
        this.price = price;
    }
    // kcal getter
    public int getKcal(){
        return kcal;
    }
    // kcal setter
    public void setKcal(int kcal){
        this.kcal = kcal;
    }
}
