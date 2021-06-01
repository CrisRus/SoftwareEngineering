package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Model.Account;
import sample.Model.User;
import sample.Model.UserQueries;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    private User user;
    private Account acc;
    private UserQueries UQ;

    @FXML
    Label accountNumberText;
    @FXML
    Label balancelabel;
    @FXML
    TextField withdrawTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UQ = new UserQueries();
    }

    public void setUser(User user){
        this.user=user;
        accountNumberText.setText(String.valueOf(user.getAccountNumber()));
        acc = UQ.getAccount(user.getAccountNumber());
        String balance = String.valueOf(acc.getAccountBalance());
        balancelabel.setText(balance);
    }

    public void withdraw(ActionEvent event){
        try {
            double amount = Double.parseDouble(withdrawTextField.getText());
            acc.setAccountBalance(acc.getAccountBalance() - amount);
            UQ.setBalance(acc);
            balancelabel.setText(String.valueOf(acc.getAccountBalance()));
        }catch (Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("OOF");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }
}
