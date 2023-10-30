module com.oop2.assignment4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop2.assignment4 to javafx.fxml;
    exports com.oop2.assignment4;
}