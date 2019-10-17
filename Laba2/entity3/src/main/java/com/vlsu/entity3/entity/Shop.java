package com.vlsu.entity3.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Shop {
    private int idShop;
    private String name;
    private String address;
    private String phone;
    private Collection<Supply> recordsByIdShop;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID_Shop")
    public int getIdShop() {
        return idShop;
    }
    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Basic
    @Column(name = "Name_Shop")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Address_Shop")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Phone_Shop")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return idShop == shop.idShop &&
                Objects.equals(name, shop.name) &&
                Objects.equals(address, shop.address) &&
                Objects.equals(phone, shop.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShop, name, address, phone);
    }

    @OneToMany(mappedBy = "shopByShopId")
    public Collection<Supply> getRecordsByIdShop() {
        return recordsByIdShop;
    }

    public void setRecordsByIdShop(Collection<Supply> recordsByIdShop) {
        this.recordsByIdShop = recordsByIdShop;
    }
}