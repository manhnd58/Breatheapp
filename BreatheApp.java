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
        // Vòng tròn trung tâm
        Circle circle = new Circle(100);
        circle.setFill(Color.web("#87CEEB")); // Màu xanh nhẹ

        // Văn bản hướng dẫn
        Text text = new Text("Hít vào");
        text.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Container
        StackPane root = new StackPane(circle, text);
        Scene scene = new Scene(root, 400, 400);

        // Hiệu ứng phóng to / thu nhỏ
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(4), circle);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        // Đổi văn bản theo chu kỳ
        scaleTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            double progress = newTime.toSeconds() % 4;
            if (progress < 2) {
                text.setText("Hít vào");
            } else {
                text.setText("Thở ra");
            }
        });

        // Cài đặt Stage
        primaryStage.setTitle("Breathe App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}