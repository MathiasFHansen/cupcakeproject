package business.entities;

public class CupcakeTopEntry {

    private int cupcakeTopEntryId;
    private String name;
    private int price;

    public CupcakeTopEntry(int cupcakeTopEntryId, String name, int price) {
        this.cupcakeTopEntryId = cupcakeTopEntryId;
        this.name = name;
        this.price = price;
    }



    public int getCupcakeBottomEntryId() {
        return cupcakeTopEntryId;
    }

    public void setCupcakeBottomEntryId(int cupcakeBottomId) {
        this.cupcakeTopEntryId = cupcakeBottomId;
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
