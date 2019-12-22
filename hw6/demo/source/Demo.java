package code;
/*
 import library packages
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

/**
 *
 * @author Liem Thanh Ho
 */

public class Demo extends Application {
       /** create layouts*/
       // Panes 
    Pane pane1 = new Pane();
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
        image = new Image("images/clock.png",true);

        //top left
        imageView1 = new ImageView(image);
        imageView1.setFitHeight(50); 
        imageView1.setFitWidth(50);
        imageView1.setX(0);
        imageView1.setY(0);
        imageView1.setRotate(90);

        //top right
        imageView2 = new ImageView(image);
        imageView2.setFitHeight(50); 
        imageView2.setFitWidth(50);
        imageView2.setX(600);
        imageView2.setY(0);
        imageView2.setRotate(270);

        //bottom left
        imageView3 = new ImageView(image);
        imageView3.setFitHeight(50); 
        imageView3.setFitWidth(50);
        imageView3.setX(0);
        imageView3.setY(400);
        imageView3.setRotate(180);

        //bottom right
        imageView4 = new ImageView(image);
        imageView4.setFitHeight(50); 
        imageView4.setFitWidth(50);
        imageView4.setX(600);
        imageView4.setY(400);
        imageView4.setRotate(0);

        //center
        imageView5 = new ImageView(image);
        imageView5.setFitHeight(150); 
        imageView5.setFitWidth(150);
        imageView5.setX(250);
        imageView5.setY(150);

        t1 = new Text(10, 100, "This is a test");
        t1.setText("Demonstration of Assignment for\nJava, GUI and Visualization: CS5405");
        t5 = new Text(10, 140, "This is my orignal code, No IDE used in the submission. \n I did not give my code to anyone or \nI did not use anypne's code in this work");
        t6 = new Text(10, 180, "\nLink: url address for reference to specific page and quotation");
                      
        t2 = new Text(10, 80, "This is a test");
        t2.setFont(new Font(20));
        t2.setFill(Color.RED);
        t2.setWrappingWidth(500);
        t2.setTextAlignment(TextAlignment.CENTER);
        t2.setText("Demonstration of Assignment 6 for\nJava, GUI and Visualization: CS5405");
        
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
                      "Write a program with three buttons:\n\n• Button1 action: displays pane with course information, your name on color and some font, and relevant information in different color and different font, as shown in the class.\n• Button2 action: Give description of assignment, cover page.\n• Button3 action: Use your own picture, display it in the center of pane, scale, rotate and display four different variations of your picture in four corners of the display pane. Sample demos from class may be used to understand how to do it.\n\nTurn in the Demo.jar file on the canvas. \n\nTurn in the printed copy of source code and sample screenshots of program output in the class.");
        t7.setFont(new Font(20));
        t7.setFill(Color.BLUE);
        t7.setWrappingWidth(600);
        t7.setTextAlignment(TextAlignment.JUSTIFY);
        
       //
        pane1.getChildren().addAll(imageView1,imageView2,imageView3,imageView4,imageView5); //ImageDemo

        pane2.getChildren().addAll(t2,t3,t4); //author
        pane3.getChildren().addAll(t7); //problem
        pane4.getChildren().addAll(pane3);
        
        pane1.relocate(10,50);
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
