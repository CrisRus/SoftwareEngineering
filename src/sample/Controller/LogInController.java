package sample.Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.Account;
import sample.Model.DatabaseConnection;
import sample.Model.User;
import sample.Model.UserQueries;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable  {

    private User user;

    @FXML
    TextField username;

    @FXML
    TextField userPassword;


    private UserQueries UQ = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UQ = new UserQueries();
    }

    public void logInButton(ActionEvent ae) {
        String usernameText = username.getText();
        String pw = userPassword.getText();
        User user = UQ.getUser(usernameText,pw);
        if (user.verify()){
            windowView(ae, user);
        }else{
            System.out.println("Wrong username and/or password.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Wrong username and/or password.");
            alert.show();
        }
    }

     public void windowView(Event event, User user) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/account.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());

            window.setScene(scene);
            AccountController controller = loader.getController();
            controller.setUser(user);

            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
     }


}
