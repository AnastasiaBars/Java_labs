package ru.vlsu.lab5.bean;

public class Shop {
    public Shop(int idShop, String name, String address, String phone) {
        this.idShop = idShop;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    private int idShop;
    private String name;
    private String address;
    private String phone;

    @Override
    public String toString(){
        return String.valueOf(idShop + " " + name + " " + address + " " + phone);
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
