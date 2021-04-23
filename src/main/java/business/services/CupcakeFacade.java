package business.services;
import business.entities.CupcakeBottom;
import business.entities.CupcakeBottomEntry;
import business.entities.CupcakeTop;
import business.entities.CupcakeTopEntry;
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

    public CupcakeBottomEntry getCupcakeBottomEntry(int id) throws UserException {
        return cupcakeMapper.getCupcakeBottomEntry(id);
    }

    public CupcakeTopEntry getCupcakeTopEntry(int id) throws UserException {
        return cupcakeMapper.getCupcakeTopEntry(id);
    }
}
