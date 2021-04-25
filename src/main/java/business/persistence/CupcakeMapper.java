package business.persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.entities.*;
import business.exceptions.UserException;
import business.services.UserFacade;
import com.mysql.cj.AbstractQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                    int price = rs.getInt("price");
                    cupcakeTopList.add(new CupcakeTop(id, name, price));
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
                    int price = rs.getInt("price");
                    cupcakeBottomList.add(new CupcakeBottom(id, name, price));
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



    public void createOrder (Order order) throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `cupcake`.`orderline` (`quantity`, `cupcake_bund_id`, `cupcake_top_id`, `user_id`) VALUES (?, ?, ?, ?);";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                for (BasketItem b: order.getBasket().getBasketItemList()) {
                    ps.setInt(1, b.getQuantity());
                    ps.setInt(2, b.getCupcakeBottom().getCupcakeBottomId());
                    ps.setInt(3, b.getCupcakeTop().getCupcakeTopId());
                    ps.setInt(4, order.getId());
                    ps.executeUpdate();
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public List<OrderLine> getAllOrdersFromDatabase(int id) throws UserException {
        List<OrderLine> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake.orderline WHERE user_id =?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderlineId = rs.getInt("cupcake_bund_id");
                    int quantity = rs.getInt("quantity");
                    int cupcakeBottomId = rs.getInt("cupcake_bund_id");
                    int cupcakeTopId = rs.getInt("cupcake_top_id");
                    int userId = rs.getInt("user_id");
                    orderList.add(new OrderLine(orderlineId, quantity, cupcakeBottomId, cupcakeTopId, userId));
                }
                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
