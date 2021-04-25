package business.services;
import business.entities.*;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;
import java.util.List;

public class CupcakeFacade {
    private CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database) { this.cupcakeMapper = new CupcakeMapper(database); }

    public List<CupcakeTop> getAllCupcakeTops() throws UserException{
        return cupcakeMapper.getAllCupcakeTops();
    }

    public List<CupcakeBottom> getAllCupcakeBottoms() throws UserException {
        return cupcakeMapper.getAllCupcakeBottoms();
    }

    public String getCupcakeBottomName(int id) throws UserException {
        return cupcakeMapper.getCupcakeBottomName(id);
    }

    public Order createOrder (Order order) throws UserException {
        return order;
    }

    public List<OrderLine> getAllOrdersFromDatabase(int id) throws UserException {
        return cupcakeMapper.getAllOrdersFromDatabase(id);
    }
}
