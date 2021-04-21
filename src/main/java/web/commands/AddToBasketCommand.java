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

        String cupcakeTop = request.getParameter("cupcakeTop");
        String cupcakeBottom = request.getParameter("cupcakeBottom");
        request.setAttribute("cupcakeTop", cupcakeTop);
        request.setAttribute("cupcakeBottom", cupcakeBottom);

        List<String> cupcakeList = new ArrayList<>();
        cupcakeList.add(cupcakeTop);
        cupcakeList.add(cupcakeBottom);











        return pageToShow;
    }
}
