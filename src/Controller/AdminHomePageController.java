package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class AdminHomePageController {
    @FXML
    public Hyperlink foods, books, students, professors, classes;

    public void goToFoodsPage(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource() == foods)
            new PageLoader().loadScene("/View/FoodSelecting.fxml");
    }

    public void goToBooksPage(ActionEvent actionEvent) {
    }

    public void goToStudentsPage(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource() == students)
            new PageLoader().loadScene("/View/AdminsStudentListView.fxml");
    }

    public void goToProfessorsPage(ActionEvent actionEvent) {
    }

    public void goToClassesPage(ActionEvent actionEvent) {
    }
}
