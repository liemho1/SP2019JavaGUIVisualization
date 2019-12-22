package code;
/*
 import library packages
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.application.Application;
//actions items
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//paint and othe useful classes
import javafx.scene.paint.Color;
import javafx.scene.text.*;//Font,FontWeight,FontPosture,TextAlignment
//images
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static java.lang.Math.*;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


/**
 *
 * @author Liem Thanh Ho
 */

public class Demo extends Application {
       /** create layouts*/
       // Panes 
    Pane pane1 = new Pane();
    StackPane demo = new StackPane();
    Pane pane2 = new Pane();
    Pane pane3 = new Pane();
    Pane pane4 = new Pane();
    Pane root = new Pane();
    Scene scene;
    Stage stage;

    
    public void start(Stage stage) {
       
       // root.getChildren().addAll(pane1,button1,button2,button3);//first panne the controls
        root = createFrontPage();
        scene= new Scene(root,700,600,Color.GRAY);
        stage.setTitle("Demo by Liem Thanh Ho");
        stage.setScene(scene);
        stage.show();
    }
    
    Text t1,t2,t3,t4,t5,t6,t7;
    Button button1,button2,button3;
    Image image;    
    ImageView imageView1,imageView2 ,imageView3,imageView4,imageView5;

    public Pane createFrontPage()
    {
        Slider slider = new Slider();
        slider.setShowTickLabels(true);
        //slider.setShowTickMarks(true);  
        slider.setMin(0);
        slider.setMax(10);  
        //slider.setBlockIncrement(1);
        //slider.setMinorTickCount(1);
        


        //slHorizontal.setStyle("-fx-border-color: white;-fx-border-radius: 4;-fx-border-width: 1;");
        //slHorizontal.setValue(10);

        Circle circle1 = new Circle(500, 135, 200); 
        circle1.setFill(Color.WHITE); 
        circle1.setStroke(Color.VIOLET);
        circle1.setStrokeWidth(4);

        Circle circle2 = new Circle(500, 135, 125); 
        circle2.setFill(Color.LIGHTPINK); 
        circle2.setStroke(Color.VIOLET);
        circle2.setStrokeWidth(3);

        Circle circle3 = new Circle(500, 135, 50); 
        circle3.setFill(Color.BLUE); 
        circle3.setStroke(Color.VIOLET);
        circle3.setStrokeWidth(2);

        Arc arc1 = new Arc(150, 100, 80, 80, 20, 40); //Create an arc
        arc1.setStyle ("-fx-fill:red;-fx-type:round;-fx-stroke-width:5");
        arc1.setType(ArcType.ROUND); // Set arc type


        

        t1 = new Text(10, 100, "This is a test");
        t1.setText("Demonstration of Assignment for\nJava, GUI and Visualization: CS5405");
        t5 = new Text(10, 140, "This is my orignal code, No IDE used in the submission. \n I did not give my code to anyone or \nI did not use anypne's code in this work");
        t6 = new Text(10, 180, "\nLink: url address for reference to specific page and quotation");
                      
        t2 = new Text(10, 80, "This is a test");
        t2.setFont(new Font(20));
        t2.setFill(Color.RED);
        t2.setWrappingWidth(500);
        t2.setTextAlignment(TextAlignment.CENTER);
        t2.setText("Demonstration of Assignment 7 for\nJava, GUI and Visualization: CS5405");
        
        t3 = new Text(10, 120, "\nPresented by\n\nLiem Thanh Ho, \n\nlthpkh@mst.edu\n\n");
        t3.setFont(new Font(20));
        t3.setFill(Color.GREEN);
        t3.setWrappingWidth(500);
        t3.setTextAlignment(TextAlignment.CENTER);
        
        t4 = new Text(10, 260, "\nThis is my orignal code, No IDE used in the submission. \nI did not give my code to anyone or I did not use anyone's code in this work. \nI follow the rules of the academic Honesty");
        t4.setFont(new Font(20));
        t4.setFill(Color.BLUE);
        t4.setWrappingWidth(600);
        t4.setTextAlignment(TextAlignment.CENTER);
        t7 = new Text(10, 40,
                      "Write a program with three buttons:\n\n• Button1 action: displays pane with course information, your name on color and some font, and relevant information in different color and different font, as shown in the class.\n• Button2 action: Give description of assignment, cover page.\n• Button3 action: Create a slider with range 1 to 10. Create a circle and read a slider value into an integer n. Divide the circle into n sectors. Fill 1/3 each sector sector with a color say red, the rest 2/3 sector remains unfilled.\n\nTurn in the Demo.jar file on the canvas. \n\nTurn in the printed copy of source code and sample screenshots of program output in the class.");
        t7.setFont(new Font(20));
        t7.setFill(Color.BLUE);
        t7.setWrappingWidth(600);
        t7.setTextAlignment(TextAlignment.JUSTIFY);
        
       //
        demo.getChildren().addAll(circle1,circle2,circle3); //ImageDemo
        pane1.getChildren().addAll(demo,slider,arc1); //ImageDemo
        pane2.getChildren().addAll(t2,t3,t4); //author
        pane3.getChildren().addAll(t7); //problem
        pane4.getChildren().addAll(pane3);
        
        demo.relocate(135,25);//ImageDemo
        pane2.relocate(10,50);
        pane3.relocate(10,50);
        pane4.relocate(10,100);
    
        button1 =  new Button("ImageDemo");
        button2 =  new Button("Author");
        button3 =  new Button("Problem");
    
        button1.relocate(400,20);
        button2.relocate(100,20); //author
        button3.relocate(250,20); // problem
        root.getChildren().addAll(button2,button3,button1,pane4);
        button1.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane1);});
        button2.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane2);});
        button3.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane3);});
        return root;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
