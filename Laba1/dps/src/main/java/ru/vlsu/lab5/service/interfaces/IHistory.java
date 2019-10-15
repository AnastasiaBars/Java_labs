package ru.vlsu.lab5.service.interfaces;

import ru.vlsu.lab5.bean.Shop;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface IHistory {
    ArrayList<Shop> getHistory();
    void addHistory(Shop shop);
}