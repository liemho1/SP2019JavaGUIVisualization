package code;
// Minimum requirement
import javafx.scene.layout.*;// Pane, StackPane etc
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
// Other properties
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Demo extends Application 
{
    
    Pane root;
    Scene scene;
    @Override // Override the start method in the Application class
    public void start(Stage stage) 
    {
        root = new StackPane();  // Create layout for scene
        scene = new Scene(root, 700, 400);    // Create a scene for stage
        createRectangle();   // create rectangle and add it to layout
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
       //optional
        stage.setTitle("ShowRectangle: Liem Thanh Ho"); // Set the stage title
    }

    public void createCircle()
    {
        // Create a circle and set its properties
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLUE);
        circle.setStrokeWidth(4);
        circle.setFill(Color.WHITE);// no color or white
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        circle.radiusProperty().bind(scene.heightProperty().divide(3));
        //create label
        Label label= new Label("CircleDemo");
        label.setFont(new Font(40));
        label.setTextFill(Color.RED);
        root.getChildren().addAll(circle,label);
    }

    public void createRectangle()
    {
        Rectangle rectangle = new Rectangle(100, 100, 200, 100);
        rectangle.setStroke(Color.BLUE);
        rectangle.setStrokeWidth(4);
        rectangle.setFill(Color.WHITE);// null for no color or white, default black
        rectangle.widthProperty().bind(scene.widthProperty().divide(2));
        rectangle.heightProperty().bind(scene.heightProperty().divide(2));
        //create label
        Label label= new Label("Liem Thanh Ho");
        label.setFont(new Font(40));
        label.setTextFill(Color.RED);
        root.getChildren().addAll(rectangle,label);
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}




