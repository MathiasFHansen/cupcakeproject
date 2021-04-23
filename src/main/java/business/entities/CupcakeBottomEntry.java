package business.entities;

public class CupcakeBottomEntry {

    private int cupcakeBottomEntryId;
    private String name;
    private int price;

    public CupcakeBottomEntry(int cupcakeBottomId, String name, int price) {
        this.cupcakeBottomEntryId = cupcakeBottomId;
        this.name = name;
        this.price = price;
    }



    public int getCupcakeBottomEntryId() {
        return cupcakeBottomEntryId;
    }

    public void setCupcakeBottomEntryId(int cupcakeBottomId) {
        this.cupcakeBottomEntryId = cupcakeBottomId;
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
