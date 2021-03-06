package Entity;

import javax.persistence.*;

/**
 * Created by marioquer on 2017/4/10.
 */
@Entity
public class Product {
    private int id;
    private Double price;
    private String link;
    private ProductType productTypeByTypeid;
    private Seller sellerBySellerid;

    private int typeid;
    private int sellerid;

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "link", nullable = true, length = 200)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (link != null ? !link.equals(product.link) : product.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    public ProductType getProductTypeByTypeid() {
        return productTypeByTypeid;
    }

    public void setProductTypeByTypeid(ProductType productTypeByTypeid) {
        this.productTypeByTypeid = productTypeByTypeid;
    }

    @ManyToOne
    @JoinColumn(name = "sellerid", referencedColumnName = "id")
    public Seller getSellerBySellerid() {
        return sellerBySellerid;
    }

    public void setSellerBySellerid(Seller sellerBySellerid) {
        this.sellerBySellerid = sellerBySellerid;
    }
}
