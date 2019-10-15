package ru.vlsu.lab5.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.vlsu.lab5.bean.Shop;
import ru.vlsu.lab5.service.interfaces.IHistory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import java.util.ArrayList;

@Scope(value= WebApplicationContext.SCOPE_SESSION)
@Stateful
@Component
public class History implements IHistory {
    private static ArrayList<Shop> history;

    @Override
    public ArrayList<Shop> getHistory() {
        return history;
    }

    @Override
    public void addHistory(Shop shop) {
        history.add(shop);
    }

    @PostConstruct
    public void initHistory() {
        history = new ArrayList<>();
        System.out.println("History initialized !");
    }
    @PreDestroy
    public void preDestroyHistory(){
        history = null;
        System.out.println("History destroyed");
    }
}

