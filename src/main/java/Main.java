import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Circle cir = new Circle();
        cir.setFill(Color.RED);
        cir.setRadius(30);
        cir.relocate(30,30);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), cir);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        Rectangle rect = new Rectangle();
        rect.setFill(Color.BLUE);
        rect.setWidth(50);
        rect.setHeight(50);
        rect.setLayoutX(30);
        rect.setLayoutY(120);
        rect.setStroke(Color.BURLYWOOD);
        rect.setStrokeWidth(10);

        //movement transition
        TranslateTransition tTransition1 = new TranslateTransition();
        tTransition1.setDuration(Duration.seconds(3));
        tTransition1.setToX(500-30);
        tTransition1.setToY(300-30);

        TranslateTransition tTransition2 = new TranslateTransition();
        tTransition2.setDuration(Duration.seconds(3));
        tTransition2.setToX(500-30);
        tTransition2.setToY(300-120);

        tTransition1.setAutoReverse(true);
        tTransition1.setCycleCount(Animation.INDEFINITE);

        //scale transition
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), cir);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);

        tTransition1.setNode(cir);
        tTransition2.setNode(rect);
        tTransition1.play();
        tTransition2.play();
        scaleTransition.play();

        //------------------------------------------------------------------------------

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                0.0, 0.0, 10.0, 0.0, 10.0, 20.0, 0.0, 20.0);
        polygon.setLayoutX(60);
        polygon.setLayoutY(80);

        Rectangle rectArc = new Rectangle (100, 40, 100, 100);
        rectArc.setArcHeight(50);
        rectArc.setArcWidth(50);
        rectArc.setFill(Color.VIOLET);

        //------------------------------------------------------------------------------

        Path path = new Path();
        path.getElements().add (new MoveTo(10f, 50f));
        path.getElements().add (new CubicCurveTo (40f, 10f, 190f, 140f, 190, 250f));

//        Pane root = new Pane();
        root.getChildren().add(cir);
        root.getChildren().add(rect);
//        root.getChildren().add(polygon);
//        root.getChildren().add(rectArc);
        root.getChildren().add(path);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
