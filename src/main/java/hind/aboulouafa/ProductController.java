package hind.aboulouafa;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

    public class ProductController {
        @FXML private TextField nameField;
        @FXML private TextField priceField;
        @FXML private ListView<Product> productList;

        private final ObservableList<Product> products = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            productList.setItems(products);
        }

        @FXML
        public void addProduct() {
            String name = nameField.getText();
            String priceText = priceField.getText();

            if (name.isEmpty() || priceText.isEmpty()) {
                showAlert("Champs manquants", "Veuillez remplir tous les champs.");
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                Product product = new Product(name, price);
                products.add(product);
                nameField.clear();
                priceField.clear();
            } catch (NumberFormatException e) {
                showAlert("Erreur de format", "Le prix doit être un nombre.");
            }
        }

        private void showAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }


