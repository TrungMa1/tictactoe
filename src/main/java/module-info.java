module com.example.tictactoever2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoever2 to javafx.fxml;
    exports com.example.tictactoever2;
}