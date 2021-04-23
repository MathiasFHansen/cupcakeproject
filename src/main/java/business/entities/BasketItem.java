package business.entities;

public class BasketItem {

    private CupcakeTop cupcakeTop;
    private CupcakeBottom cupcakeBottom;
    private int quantity;

    public BasketItem(CupcakeTop cupcakeTop, CupcakeBottom cupcakeBottom, int quantity) {
        this.cupcakeTop = cupcakeTop;
        this.cupcakeBottom = cupcakeBottom;
        this.quantity = quantity;
    }

    public int getPrice(){
        return (cupcakeTop.getPrice() + cupcakeBottom.getPrice()) * quantity;
    }

    public CupcakeTop getCupcakeTop() {
        return cupcakeTop;
    }

    public void setCupcakeTop(CupcakeTop cupcakeTop) {
        this.cupcakeTop = cupcakeTop;
    }

    public CupcakeBottom getCupcakeBottom() {
        return cupcakeBottom;
    }

    public void setCupcakeBottom(CupcakeBottom cupcakeBottom) {
        this.cupcakeBottom = cupcakeBottom;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
