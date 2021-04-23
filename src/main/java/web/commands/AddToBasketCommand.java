package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.ArrayList;
import java.util.List;

public class AddToBasketCommand extends CommandProtectedPage {

    CupcakeFacade cupcakeFacade;


    public AddToBasketCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.cupcakeFacade = new CupcakeFacade(database);
    }




    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {


        int cupcakeTopId;
        int cupcakeBottomId;
        int quantity;

        try {
            cupcakeTopId = Integer.parseInt(request.getParameter("cupcakeTop"));
            cupcakeBottomId = Integer.parseInt(request.getParameter("cupcakeBottom"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException ex) {
                throw new UserException("Fejl i indtastning på");
        }

        List<CupcakeTop> cupcakeTopList = (List<CupcakeTop>) request.getServletContext().getAttribute("cupcakeTopList");
        List<CupcakeBottom> cupcakeBottomList = (List<CupcakeBottom>) request.getServletContext().getAttribute("cupcakeBottomList");

        HttpSession session = request.getSession();

        Basket basket = (Basket) session.getAttribute("basket");


        if (basket == null){
            basket = new Basket();
        }

        CupcakeTop cupcakeTop = getCupcakeTopItemFromId(cupcakeTopList, cupcakeTopId);
        CupcakeBottom cupcakeBottom = getCupcakeBottomItemFromId(cupcakeBottomList, cupcakeBottomId);
        BasketItem basketItem = new BasketItem(cupcakeTop, cupcakeBottom, quantity);

        basket.addToBasket(basketItem);

        session.setAttribute("basket", basket);



        return pageToShow;
    }

    private CupcakeTop getCupcakeTopItemFromId(List<CupcakeTop> cupcakeTopList, int cupcakeTopId){
        for (CupcakeTop cupcakeTop : cupcakeTopList) {
            if (cupcakeTop.getCupcakeTopId() == cupcakeTopId){
                return cupcakeTop;
            }
        }
        return null;
    }

    private CupcakeBottom getCupcakeBottomItemFromId(List<CupcakeBottom> cupcakeBottomList, int cupcakeBottomId){
        for (CupcakeBottom cupcakeBottom : cupcakeBottomList) {
            if (cupcakeBottom.getCupcakeBottomId() == cupcakeBottomId){
                return cupcakeBottom;
            }
        }
        return null;
    }
}
