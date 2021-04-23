package web.commands;

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



        int rowsInserted = userFacade.updateBalance(user.getId(), 100);
        if (rowsInserted == 1)
        {
            request.setAttribute("userEntryList", userFacade.getAllUsersByIdRole());

        }




        return pageToShow;
    }
}
