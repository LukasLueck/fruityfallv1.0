import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Scene newScene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FruityFall v1.0");

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

        StackPane root = new StackPane(vbox);
        root.setBackground(createBackground());

        mainScene = new Scene(root, 500, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Ereignislistener für Button hinzufügen
        button.setOnAction(e -> handleButtonClicked());

        // Programm beenden Button hinzufügen
        Button exitButton = new Button("SPIEL BEENDEN");
        StackPane.setAlignment(exitButton, Pos.TOP_LEFT);
        root.getChildren().add(exitButton);

        // Ereignislistener für Exit-Button hinzufügen
        exitButton.setOnAction(e -> handleExitButtonClicked());
    }

    // Methode zum Behandeln des Button-Klicks
    private void handleButtonClicked() {

        // Neue Scene erstellen
        StackPane newRoot = new StackPane();
        newRoot.setBackground(createBackground());

        // Eingabefelder hinzufügen
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        // HBox für Eingabefelder erstellen
        HBox inputBox = new HBox();
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setSpacing(10);
        inputBox.getChildren().addAll(textField1, textField2);

        // Button hinzufügen
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> handleFormSubmission(textField1.getText(), textField2.getText()));

        // VBox für Eingabefelder und Button erstellen
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.getChildren().addAll(inputBox, submitButton);

        // Logo hinzufügen
        Image logoImage = new Image("fruityfall_logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        newRoot.getChildren().add(logoImageView);
        StackPane.setAlignment(logoImageView, Pos.TOP_CENTER);
        // Bildgröße anpassen
        double newWidth = 400; // Neue Breite des Bildes
        double newHeight = 150; // Neue Höhe des Bildes
        logoImageView.setFitWidth(newWidth);
        logoImageView.setFitHeight(newHeight);

        newRoot.getChildren().add(vbox);
        StackPane.setAlignment(vbox, Pos.CENTER);

        // Startbildschirm Button hinzufügen
        Button backButton = new Button("zurück zum Startbildschirm");
        newRoot.getChildren().add(backButton);
        StackPane.setAlignment(backButton, Pos.BOTTOM_LEFT);

        newScene = new Scene(newRoot, 500, 500);
        primaryStage.setScene(newScene);

        // Ereignislistener für Back-Button hinzufügen
        backButton.setOnAction(e -> handleBackButtonClicked());
    }

    // Methode zum Behandeln des Back-Button-Klicks
    private void handleBackButtonClicked() {
        primaryStage.setScene(mainScene);
    }

    // Methode zum Erstellen des Hintergrundes
    private Background createBackground() {
        Image backgroundImage = new Image("background.png");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundImg);
    }

    // Methode zum Behandeln des Exit-Button-Klicks
    private void handleExitButtonClicked() {
        primaryStage.close();
    }

    // Methode zum Behandeln des Formular-Submit
    private void handleFormSubmission(String input1, String input2) {
        // Hier kannst du den Code für die Verarbeitung der Formulardaten hinzufügen
        // Zum Beispiel: Speichern der Daten in einer Datenbank oder Ausführen von weiteren Aktionen
        System.out.println("Spieler 1: " + input1);
        System.out.println("Spieler 2: " + input2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}