package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> basketItemList = new ArrayList<>();

    public Basket() {
    }

    public List<BasketItem> getBasketItemList(){
        return basketItemList;
    }

    public int getNumberOfItems(){
        return basketItemList.size();
    }

    public void addToBasket(BasketItem basketItem) {basketItemList.add(basketItem);}

    public void removeFromBasket(BasketItem basketItem) {basketItemList.remove(basketItem);}

    public int totalSum(){
        int sum = 0;
        for (BasketItem basketItem: basketItemList) {
            sum += basketItem.getPrice();
        }
        return sum;
    }

    public void setBasketItemList(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
    }


}
