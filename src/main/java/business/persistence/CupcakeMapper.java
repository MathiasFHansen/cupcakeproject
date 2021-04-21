package business.persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.entities.CupcakeBottom;
import business.entities.CupcakeTop;
import business.exceptions.UserException;

public class CupcakeMapper {
    private Database database;

    public CupcakeMapper(Database database) { this.database = database;}


    public List<CupcakeTop> getAllCupcakeTops() throws UserException {
        List<CupcakeTop> cupcakeTopList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake_top";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("cupcake_top_id");
                    String name = rs.getString("name");
                    cupcakeTopList.add(new CupcakeTop(id, name));
                }
                return cupcakeTopList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<CupcakeBottom> getAllCupcakeBottoms() throws UserException {
        List<CupcakeBottom> cupcakeBottomList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake_bund";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("cupcake_bund_id");
                    String name = rs.getString("name");
                    cupcakeBottomList.add(new CupcakeBottom(id, name));
                }
                return cupcakeBottomList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public String getCupcakeBottomName(int id) throws UserException {
        String name = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT name FROM cupcake_bund WHERE cupcake_bund_id = ?;";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    name = rs.getString("name");
                    return name;
                }
                else {
                    return name;
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (UserException | SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

}
