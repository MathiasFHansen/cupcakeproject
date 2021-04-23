package business.entities;

public class CupcakeTop {
    private int cupcakeTopId;
    private String name;
    private int price;

    public CupcakeTop(int cupcakeTopId, String name, int price) {
        this.cupcakeTopId = cupcakeTopId;
        this.name = name;
        this.price = price;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public void setCupcakeTopId(int cupcakeTopId) {
        this.cupcakeTopId = cupcakeTopId;
    }

    public String getName() {
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
