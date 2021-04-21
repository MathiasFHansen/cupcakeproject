package business.entities;

public class Cupcake {

    CupcakeTop cupcakeTop;
    CupcakeBottom cupcakeBottom;
    private int totalprice;

    public Cupcake(CupcakeTop cupcakeTop, CupcakeBottom cupcakeBottom) {
        this.cupcakeTop = cupcakeTop;
        this.cupcakeBottom = cupcakeBottom;
    }

    public int totalprice () {
        int totalprice = cupcakeBottom.getPrice() + cupcakeTop.getPrice();
        return totalprice;
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

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
