package web.commands;

import business.entities.OrderLine;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandCustomerOrderPage extends CommandProtectedPage{

    CupcakeMapper cupcakeMapper;
    UserMapper userMapper;

    public CommandCustomerOrderPage(String pageToShow, String role) {
        super(pageToShow, role);
        this.cupcakeMapper = new CupcakeMapper(database);
        this.userMapper = new UserMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {


        int userId = userMapper.getUserFromId("email");

        List<OrderLine> orderList = cupcakeMapper.getAllOrdersFromDatabase(userId);

        request.setAttribute("orderList", orderList);

        return pageToShow;
    }
}
