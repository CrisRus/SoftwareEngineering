package sample.Model;

public class User {


    private String username;
    private String password;
    private int accountNumber;

    public User(){}

    public User(String name, int accountNumber ){
        this.username=name;
        this.accountNumber=accountNumber;

    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean verify(){
        return username!=null&&!username.isEmpty() && accountNumber!=0;
    }
}
