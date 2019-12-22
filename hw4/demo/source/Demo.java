// Liem Thanh Ho
//CS5405 Java GUI & Visualization
//Sabberwahl

package code;
//Basic minimum
import javafx.application.Application;
import javafx.scene.layout.*;//Pane, VBox,GridPane,
import javafx.scene.Scene;
import javafx.stage.Stage;
//Other components
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
// for circle
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
//actions items
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//for rectangle
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class Demo extends Application 
{
    Pane root;
    @Override
    public void start(Stage stage) 
    {
        root = new Pane();
        createTextField();
        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("Demo TextField Circle Rectangle: Liem Thanh Ho");
        stage.setScene(scene);
        stage.show();
    }
    /** declare Label and Text variables */
    Label label;
    TextField tField;

    /** Create label */
    public void createTextField ()
    {
        label = new Label();
        label.setText("\tCircle or Rectangle");
        label.setTextAlignment(TextAlignment.CENTER);
        

        tField = new TextField("Type 'C' for Circle or 'R' for Rectangle");
        tField.setMinWidth(1000);

        // Create and register the handler
        tField.setOnAction((ActionEvent e) -> 
        {
            String str = tField.getText();
            tField.setText( "" );  // clear data entry field
            label.setText(str);

            if(str.equals("C") || str.equals("c"))
            {
                root.getChildren().clear();
                createCircle();
                
            }
            if(str.equals("R") || str.equals("r"))
            {
                root.getChildren().clear();
                createRectangle();
            }
            

        });

        
        root.getChildren().addAll(label,tField);
    }
    
    public Circle createCircle()
    {
        // Create a circle and set its properties
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);

        circle.setStroke(Color.BLUE);
        circle.setFill(Color.CYAN);// null for no color or white, default black
        Label label= new Label("Liem Thanh Ho");
        root.getChildren().addAll(tField,label,circle);
        return circle;
    }
    
    public Rectangle createRectangle()
    {
        // Create a circle and set its properties
        Rectangle rectangle = new Rectangle(100, 100, 200, 100);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.CYAN);// null for no color or white, default black
        Label label= new Label("Liem Thanh Ho");
        root.getChildren().addAll(tField,label,rectangle);
        return rectangle;
    }
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}

