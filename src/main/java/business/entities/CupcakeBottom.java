package business.entities;

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
