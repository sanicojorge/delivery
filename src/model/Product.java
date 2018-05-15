package model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Product {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="prodId")
    private int id;
    private String name;
    private String description;
    private Float price;
    private Float stock;
    private String unit;
    
    public Product(int id, String name, String description, Float price, Float stock, String unit){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.unit = unit;

    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice(){
        return price;
    }

    public void SetPrice(Float price){
        this.price = price;
    }

    public Float getStock(){
        return stock;
    }

    public void setStock(Float stock){
        this.stock = stock;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    
    public String toString() {
        return "Producto id: " + getId() + " nombre: " + getName() +
               " description: " + getDescription() + " precio: " + getPrice() +
               " stock: " + getStock() + "unidad: " + getUnit();
    }
}
