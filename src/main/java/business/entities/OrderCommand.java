package business.entities;

import business.exceptions.UserException;
import business.services.CupcakeFacade;
import business.services.UserFacade;
import web.commands.CommandProtectedPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderCommand extends CommandProtectedPage {

    UserFacade userFacade;
    CupcakeFacade cupcakeFacade;

    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
        this.cupcakeFacade = new CupcakeFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        int orderUserId = userFacade.getUserFromId(request.getParameter("email"));


        Basket basket = (Basket) session.getAttribute("basket");

        Order order = new Order(basket, orderUserId);

        cupcakeFacade.createOrder(order);

        return pageToShow;
    }
}
