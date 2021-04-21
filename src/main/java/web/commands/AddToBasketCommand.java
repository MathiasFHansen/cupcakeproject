package web.commands;

import business.entities.Cupcake;
import business.entities.CupcakeBottom;
import business.entities.CupcakeTop;
import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddToBasketCommand extends CommandProtectedPage {

    CupcakeFacade cupcakeFacade;

    public AddToBasketCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.cupcakeFacade = new CupcakeFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

//        String topId = (CupcakeTop) request.getParameter("cupcakeTop");
//        String bottomId = request.getParameter("cupcakeBottom");
//        int price;
//
//        Cupcake cupcake = new Cupcake(topId, bottomId);
//
//        List<Cupcake> cupcakeList =
//
//        if (cupcake != null) {
//
//        }
//
//
//
        HttpSession session =request.getSession();

        CupcakeTop cupcakeTop = (CupcakeTop) session.getAttribute("cupcakeTop");
        CupcakeBottom cupcakeBottom = (CupcakeBottom) session.getAttribute("cupcakeBottom");
        Cupcake cupcake = new Cupcake(cupcakeTop, cupcakeBottom);

        List<Cupcake> cupcakeList = new ArrayList<>();



        System.out.println(cupcakeTop.getCupcakeTopId());




        return "customerpage";
    }
}
