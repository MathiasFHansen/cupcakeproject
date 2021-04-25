package business.entities;

public class Order {

    Basket basket;
    int id;

    public Order(Basket basket, int id) {
        this.basket = basket;
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
