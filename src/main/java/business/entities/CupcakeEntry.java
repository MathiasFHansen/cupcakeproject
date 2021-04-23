package business.entities;

public class CupcakeEntry {

    CupcakeTopEntry cupcakeTopEntry;
    CupcakeBottomEntry cupcakeBottomEntry;
    private int totalprice;

    public CupcakeEntry(CupcakeTopEntry cupcakeTopEntry, CupcakeBottomEntry cupcakeBottomEntry) {
        this.cupcakeTopEntry = cupcakeTopEntry;
        this.cupcakeBottomEntry = cupcakeBottomEntry;

    }

    public int totalprice() {
        int totalprice = cupcakeBottomEntry.getPrice() + cupcakeTopEntry.getPrice();
        return totalprice;
    }

    public CupcakeTopEntry getCupcakeTopEntry() {
        return cupcakeTopEntry;
    }

    public void setCupcakeTopEntry(CupcakeTopEntry cupcakeTopEntry) {
        this.cupcakeTopEntry = cupcakeTopEntry;
    }

    public CupcakeBottomEntry getCupcakeBottomEntry() {
        return cupcakeBottomEntry;
    }

    public void setCupcakeBottomEntry(CupcakeBottomEntry cupcakeBottomEntry) {
        this.cupcakeBottomEntry = cupcakeBottomEntry;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
