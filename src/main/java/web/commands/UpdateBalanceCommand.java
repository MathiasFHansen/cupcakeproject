package web.commands;

import business.entities.UserEntry;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateBalanceCommand extends CommandProtectedPage{

    UserFacade userFacade;
    public UpdateBalanceCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int userEntryId = Integer.parseInt(request.getParameter("id"));
        int addBalance = Integer.parseInt(request.getParameter("addBalance"));
        int currentBalance = userFacade.getUserBalance(userEntryId);

        int newBalance = currentBalance+addBalance;


        if (addBalance > 0) {
            int rowsInserted = userFacade.updateBalance(userEntryId, newBalance);
            if (rowsInserted == 1) {
                request.setAttribute("userEntryList", userFacade.getAllUsersByIdRole());
            }
        } else if (addBalance < 0) {
            throw new UserException("Du kan ikke indsætte negative værdier på balancen");
        }
        else if (addBalance == 0){
            throw new UserException("Du kan ikke indsætte 0 til balancen");
        }

        return pageToShow;
    }
}
