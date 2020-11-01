package rio.develop.shopapplication.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {

    public ProductDto(int productID, String name, String type, int price, String picLink) {
        this.productID = productID;
        this.price = price;
        this.name = name;
        this.type = type;
        this.picLink = picLink;
    }

    private long productID;

    private String name;

    private String type;

    private int price;

    private String picLink;

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
