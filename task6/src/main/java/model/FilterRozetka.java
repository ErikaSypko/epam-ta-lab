package model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filterRozetka")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterRozetka {
    private String product;
    private String company;
    private String price;

    public String getProduct() {
        return this.product;
    }

    public String getCompany() {
        return company;
    }

    public String getPrice() {
        return price;
    }
}
