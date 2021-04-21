package web.commands;

import business.entities.UserEntry;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUserTableFromDatabaseCommand extends CommandProtectedPage{

    UserFacade userFacade;
    public GetUserTableFromDatabaseCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {


        List<UserEntry> userEntryList = userFacade.getAllUsersByIdRole();

        request.setAttribute("userEntryList",userEntryList);

        return pageToShow;
    }
}
