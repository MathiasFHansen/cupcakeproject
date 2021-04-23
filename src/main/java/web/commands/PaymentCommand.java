package web.commands;

import business.entities.Basket;
import business.entities.BasketItem;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CupcakeFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentCommand extends CommandProtectedPage{

    UserFacade userFacade;

    public PaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        Basket basket = (Basket) session.getAttribute("basket");

        int price = basket.totalSum();
        int currentBalance = user.getBalance();

        if (price <= currentBalance) {
            int newBalance = currentBalance-price;
            user.setBalance(newBalance);
            int rowsInserted = userFacade.updateBalance(user.getId(), newBalance);
            if (rowsInserted == 1) {
                request.setAttribute("userEntryList", userFacade.getAllUsersByIdRole());
            }
            else if (price > currentBalance){
                throw new UserException("Brugeren har ikke råd til at købe denne ordre");
            }
        }

        //basket.getBasketItemList().clear();

        return pageToShow;
    }
}
