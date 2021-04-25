package business.entities;

public class OrderLine {

    int orderlineId;
    int quantity;
    int cupcakeBottomId;
    int cupcakeTopId;
    int userId;

    public OrderLine(int orderlineId, int quantity, int cupcakeBottomId, int cupcakeTopId, int userId) {
        this.orderlineId = orderlineId;
        this.quantity = quantity;
        this.cupcakeBottomId = cupcakeBottomId;
        this.cupcakeTopId = cupcakeTopId;
        this.userId = userId;
    }

    public int getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCupcakeBottomId() {
        return cupcakeBottomId;
    }

    public void setCupcakeBottomId(int cupcakeBottomId) {
        this.cupcakeBottomId = cupcakeBottomId;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public void setCupcakeTopId(int cupcakeTopId) {
        this.cupcakeTopId = cupcakeTopId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
