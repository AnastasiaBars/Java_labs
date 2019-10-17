package com.vlsu.entity3.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Supply {
    private int idSupply;
    private Date dateSupply;
    private String tovar;
    private Float value;
    private Integer ShopId;
    private Shop shopByShopId;

    @Id
    @Column(name = "ID_Supply")
    public int getIdSupply() {
        return idSupply;
    }

    public void setIdSupply(int idSupply) {
        this.idSupply = idSupply;
    }

    @Basic
    @Column(name = "Date_Supply")
    public Date getDateSupply() {
        return dateSupply;
    }

    public void setDateSupply(Date dateSupply) {
        this.dateSupply = dateSupply;
    }

    @Basic
    @Column(name = "Value__Supply")
    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Basic
    @Column(name = "Name_tovar")
    public String getTovar() {
        return tovar;
    }

    public void setTovar(String tovar) {
        this.tovar = tovar;
    }

    @Basic
    @Column(name = "Number_Shop")
    public Integer getShopId() {
        return ShopId;
    }

    public void setShopId(Integer ShopId) {
        this.ShopId = ShopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return idSupply == supply.idSupply &&
                Objects.equals(dateSupply, supply.dateSupply) &&
                Objects.equals(tovar, supply.tovar) &&
                Objects.equals(value, supply.value) &&
                Objects.equals(ShopId, supply.ShopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSupply, dateSupply, tovar,value, ShopId);
    }

    @ManyToOne
    @JoinColumn(name = "Number_Shop", referencedColumnName = "ID_Shop")
    public Shop getShopByShopId() {
        return shopByShopId;
    }

    public void setShopByShopId(Shop shopByShopId) {
        this.shopByShopId = shopByShopId;
    }
}
