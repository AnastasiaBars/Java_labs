package ru.vlsu.lab5.service;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ru.vlsu.lab5.bean.Shop;
import ru.vlsu.lab5.service.interfaces.IConnect;
import ru.vlsu.lab5.service.interfaces.IHistory;
import ru.vlsu.lab5.service.interfaces.ISingle;

import javax.ejb.EJB;
import java.sql.*;
import java.util.ArrayList;

@Service
@Scope(value= WebApplicationContext.SCOPE_SESSION)
public class MainService {

    @EJB
    private IConnect iConnect;
    @EJB
    private IHistory iHistory;
    @EJB
    private ISingle iSingle;

    public ArrayList<Shop> getAllShops() {
        ArrayList<Shop> result = new ArrayList<>();
        try {
            Connection conn = iConnect.getConnect();
            Statement statement = conn.createStatement();
            String sql = " select * from java2.Shop;";

            ResultSet rs = statement.executeQuery(sql);
            iConnect.closeConnect(conn);
            while (rs.next()) {
                result.add(new Shop(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Shop getShopById(int id) {
        Shop shop = null;
        try {
            Connection conn = iConnect.getConnect();
            PreparedStatement statement = conn.prepareStatement("select * from java2.Shop where id_Shop=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            iConnect.closeConnect(conn);
            while (rs.next())
                shop = new Shop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }

    public boolean createShop(Shop shop) {
        boolean flag = false;
        try {
            Connection conn = iConnect.getConnect();
            PreparedStatement statement = conn.prepareStatement("insert into java2.Shop values(?,?,?,?)");
            int i = 1;
            statement.setInt(i++, shop.getIdShop());
            statement.setString(i++, shop.getName());
            statement.setString(i++, shop.getAddress());
            statement.setString(i, shop.getPhone());
            flag = (statement.executeUpdate() > 0);
            iConnect.closeConnect(conn);
            iHistory.addHistory(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void updateShop(Shop shop) {
        try {
            Connection conn = iConnect.getConnect();
            PreparedStatement statement = conn.prepareStatement("update java2.Shop set  Name_Shop=?, Address_Shop=?, Phone_Shop=? where id_Shop=?");
            int i = 1;
            statement.setString(i++, shop.getName());
            statement.setString(i++, shop.getAddress());
            statement.setString(i++, shop.getPhone());
            statement.setInt(i, shop.getIdShop());
            statement.executeUpdate();
            iConnect.closeConnect(conn);
            iHistory.addHistory(shop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Shop> getHistory() {
        return iHistory.getHistory();
    }

    public String getMessage() {
        return iSingle.getMessage();
    }
}
