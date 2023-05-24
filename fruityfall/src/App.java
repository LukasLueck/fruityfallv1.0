import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Scene newScene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FruityFall v1.0");

        // Fensterfarbe ändern
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: orange;");

        // VBox erstellen
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        // Bild einfügen
        Image image = new Image("fruityfall_logo.png");
        ImageView imageView = new ImageView(image);
        vbox.getChildren().add(imageView);
        // Bildgröße anpassen
        double newWidth = 400; // Neue Breite des Bildes
        double newHeight = 150; // Neue Höhe des Bildes
        imageView.setFitWidth(newWidth);
        imageView.setFitHeight(newHeight);

        // Button hinzufügen
        Button button = new Button("START THE GAME");
        vbox.getChildren().add(button);

        root.getChildren().add(vbox);
        StackPane.setAlignment(vbox, Pos.CENTER);

        mainScene = new Scene(root, 600, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Ereignislistener für Button hinzufügen
        button.setOnAction(e -> handleButtonClicked());
    }

    // Methode zum Behandeln des Button-Klicks
    private void handleButtonClicked() {
        // Neue Scene erstellen
        StackPane newRoot = new StackPane();
        newRoot.setStyle("-fx-background-color: orange;");
        Button backButton = new Button("zurück zum Startbildschirm");
        newRoot.getChildren().add(backButton);
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);

        newScene = new Scene(newRoot, 600, 500);
        primaryStage.setScene(newScene);

        // Ereignislistener für Back-Button hinzufügen
        backButton.setOnAction(e -> handleBackButtonClicked());
    }

    // Methode zum Behandeln des Back-Button-Klicks
    private void handleBackButtonClicked() {
        primaryStage.setScene(mainScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}