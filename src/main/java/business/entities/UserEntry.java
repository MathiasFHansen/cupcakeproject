package business.entities;

public class UserEntry {

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private int balance;

    public UserEntry(int id, String email, int balance) {
        this.id = id;
        this.email = email;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
