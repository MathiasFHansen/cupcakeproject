package business.persistence;

import business.entities.CupcakeTop;
import business.entities.UserEntry;
import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        System.out.println("am i here?" + user.getEmail());
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT user_id, role, balance FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    int id = rs.getInt("user_id");
                    int balance = rs.getInt("balance");
                    User user = new User(email, password, role, balance);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<UserEntry> getAllUsersByIdRole() throws UserException {
        List<UserEntry> userEntryList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake.users WHERE ROLE = 'customer';";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("user_id");
                    String email = rs.getString("email");
                    int balance = rs.getInt("balance");
                    userEntryList.add(new UserEntry(id, email, balance));
                }
                return userEntryList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

//    public UserEntry getUserEntryById(int userEntryId) throws UserException {
//
//        try (Connection connection = database.connect()) {
//            String sql = "SELECT * FROM cupcake.users WHERE id = ?";
//
//            try (PreparedStatement ps = connection.prepareStatement(sql)) {
//
//                ps.setInt(1, userEntryId);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next()) {
//                    int newId = rs.getInt("id");
//                    String email = rs.getString("email");
//                    int balance = rs.getInt("balance");
//                    return new UserEntry(newId, email, balance);
//                }
//                throw new UserException("Sportsgren findes ikke for sport_id = " +userEntryId);
//
//            } catch (SQLException ex) {
//                throw new UserException(ex.getMessage());
//            }
//        } catch (SQLException ex) {
//            throw new UserException("Connection to database could not be established");
//        }
//    }

    public int updateBalance(int userEntryId, int balance) throws UserException {

        try (Connection connection = database.connect()) {

            //TODO: Money needs to be added ontop of current balance instead of replacing it. + Exceptionhandling
            String sql = "UPDATE cupcake.users SET balance = ? WHERE user_id =?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, balance);
                ps.setInt(2, userEntryId);
                int rowsInserted = ps.executeUpdate();
                return rowsInserted;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public int getUserBalance(int id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake.users WHERE user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int balance = rs.getInt("balance");
                    return balance;
                }
                return 0;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public int getUserFromId(String email) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT user_id FROM cupcake.users WHERE email = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("user_id");
                    return id;
                }
                return 0;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
