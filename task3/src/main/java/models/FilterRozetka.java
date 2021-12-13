package models;

public class FilterRozetka {
    private String product;
    private String company;
    private int price;

    public FilterRozetka(String product, String company, int price) {
        this.product = product;
        this.company = company;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }
}
