package business.services;

import business.entities.User;
import business.entities.UserEntry;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.List;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password) throws UserException
    {
        User user = new User(email, password, "customer");
        userMapper.createUser(user);
        return user;
    }

    public List<UserEntry> getAllUsersByIdRole() throws UserException {
        return userMapper.getAllUsersByIdRole();
    }

//    public UserEntry getUserEntryById(int userEntryId) throws UserException {
//        return userMapper.getUserEntryById(userEntryId);
//    }

    public int updateBalance(int userEntryId, int balance) throws UserException {
        return userMapper.updateBalance(userEntryId, balance);
    }
}
