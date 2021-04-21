package web.commands;

import business.entities.UserEntry;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBalanceCommand extends CommandProtectedPage{

    UserFacade userFacade;
    public UpdateBalanceCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        String update = request.getParameter("update");
        //UserEntry userEntry = userFacade.getUserEntryById()
        //request.setAttribute("userID", );

        String userEntryId = (request.getParameter("id"));
        String balance = (request.getParameter("balance"));
        int rowsInserted = userFacade.updateBalance(Integer.parseInt(userEntryId), Integer.parseInt(balance));
        if (rowsInserted == 1)
        {
            request.setAttribute("userEntryList", userFacade.getAllUsersByIdRole());

        }

        return pageToShow;
    }
}
