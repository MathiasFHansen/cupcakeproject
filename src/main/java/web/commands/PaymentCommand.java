package web.commands;

import business.entities.Basket;
import business.entities.BasketItem;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.services.CupcakeFacade;
import business.services.UserFacade;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentCommand extends CommandProtectedPage{

    UserFacade userFacade;
    CupcakeMapper cupcakeMapper;


    public PaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
        this.cupcakeMapper = new CupcakeMapper(database);
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

                int orderUserId = userFacade.getUserFromId("email");

                Order order = new Order(basket, orderUserId);


                cupcakeMapper.createOrder(order);
            }
            else if (price > currentBalance){
                throw new UserException("Brugeren har ikke råd til at købe denne ordre");
            }
        }

        return pageToShow;
    }
}
