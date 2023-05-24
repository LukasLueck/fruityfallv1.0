import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FruityFall v1.0");
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 600, 500);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}