package business.entities;

import business.exceptions.UserException;
import business.persistence.Database;
import business.services.CupcakeFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CupcakeBottom {

    private int cupcakeBottomId;
    private String name;
    private int price;

    public CupcakeBottom(int cupcakeBottomId, String name) {
        this.cupcakeBottomId = cupcakeBottomId;
        this.name = name;
    }



    public int getCupcakeBottomId() {
        return cupcakeBottomId;
    }

    public void setCupcakeBottomId(int cupcakeBottomId) {
        this.cupcakeBottomId = cupcakeBottomId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
