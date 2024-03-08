module com.example.currency_lab2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.currency_lab2 to javafx.fxml;
    exports com.example.currency_lab2;
}