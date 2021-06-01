import org.junit.Assert;
import sample.Model.User;

import static org.junit.Assert.*;

public class UserTest {

    @org.junit.Test
    public void getName() {
        String name = "testName";
        int accNumber = 10;
        User user = new User(name,accNumber);
        Assert.assertEquals(name, user.getName());
    }

    @org.junit.Test
    public void setName() {
        String name = "testName";
        int accNumber = 10;
        User user = new User(name,accNumber);
        String name2 = "testName2";
        user.setName(name2);
        Assert.assertEquals(name2, user.getName());
    }

    @org.junit.Test
    public void getPassword() {
        String name = "testName";
        int accNumber = 10;
        User user = new User(name,accNumber);
        String password = "password";
        user.setPassword(password);
        Assert.assertEquals(password, user.getPassword());
    }

    @org.junit.Test
    public void getAccountNumber() {
        String name = "testName";
        int accNumber = 10;
        User user = new User(name,accNumber);
        Assert.assertEquals(accNumber, user.getAccountNumber());
    }

    @org.junit.Test
    public void setAccountNumber() {
        String name = "testName";
        int accNumber = 10;
        User user = new User(name,accNumber);
        int accNumber2 = 5;
        user.setAccountNumber(accNumber2);
        Assert.assertEquals(accNumber2, user.getAccountNumber());
    }

    @org.junit.Test
    public void verify() {
        String name = "testName";
        int accNumber = 10;
        User user = new User(name,accNumber);
        Assert.assertTrue(user.verify());
        user = new User();
        Assert.assertFalse(user.verify());
    }
}