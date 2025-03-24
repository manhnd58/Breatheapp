package ChucNang;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BreatheApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle(100);
        circle.setFill(Color.web("#87CEEB")); 

       
        Text text = new Text("Hít vào");
        text.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");


        StackPane root = new StackPane(circle, text);
        Scene scene = new Scene(root, 400, 400);


        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(4), circle);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();


        scaleTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            double progress = newTime.toSeconds() % 4;
            if (progress < 2) {
                text.setText("Hít vào");
            } else {
                text.setText("Thở ra");
            }
        });


        primaryStage.setTitle("Breathe App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
