package code;
/*
 import library packages
 */
import javafx.scene.control.Label;
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
// Mouse
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
//Property
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.beans.property.Property;
//Shape
import javafx.scene.shape.Path;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

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

    Path path ;
    Path path2;

    LineTo lineTo = new LineTo();
    MoveTo moveTo = new MoveTo();
    LineTo lineTo2 = new LineTo();
    MoveTo moveTo2 = new MoveTo();

    //Label label = new Label("Mouse Polyline Drawing");
    boolean draw= true,    first=true,  notDone=false, second=false;
    int x0 = 100, y0 = 100;
    int x1 = 150, y1 = 150;

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

    public Pane createFrontPage()
    {    
        t1 = new Text(10, 100, "This is a test");
        t1.setText("Demonstration of Assignment for\nJava, GUI and Visualization: CS5405");
        t5 = new Text(10, 140, "This is my orignal code, No IDE used in the submission. \n I did not give my code to anyone or \nI did not use anypne's code in this work");
        t6 = new Text(10, 180, "\nLink: url address for reference to specific page and quotation");
                      
        t2 = new Text(10, 80, "This is a test");
        t2.setFont(new Font(20));
        t2.setFill(Color.RED);
        t2.setWrappingWidth(500);
        t2.setTextAlignment(TextAlignment.CENTER);
        t2.setText("Demonstration of Assignment 8 for\nJava, GUI and Visualization: CS5405");
        
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
                      "Draw two free hand polylines or paths. Be as artistic as you can. \nON Canvas, Demo code for one polyline is for your guidance. \nRefer to how two functions of mouse are used: MouseMoved, and MouseClicked.");
        t7.setFont(new Font(20));
        t7.setFill(Color.BLUE);
        t7.setWrappingWidth(600);
        t7.setTextAlignment(TextAlignment.JUSTIFY);

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
            {pane4.getChildren().clear();
                pane4.getChildren().add(pane1);
                interactivePolylineDrawing();
                interactivePolylineDrawing2();
                }
                );
        button2.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane2);});
        button3.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane3);});
        return root;
    }

    public void interactivePolylineDrawing()
    {
        // path initialization
        path = new Path();
        // add the required start point of the path
        path.getElements().add(new MoveTo(x0,y0));
        path.setStrokeWidth(2);
        path.setStroke(Color.BLUE);
        // mouse drawing,    get the started
        scene.setOnMouseMoved(mouseHandler);

        scene.setOnMouseClicked(mouseEvent->{
            // freeze the point and get to a new point
        if(first)
        { 
            if (mouseEvent.getClickCount()==1)
            {
                first=false;
                x0= (int) mouseEvent.getX();y0= (int) mouseEvent.getY();
                //path.getElements().clear();
                pane1.getChildren().remove(path);
                lineTo.setX(x0);lineTo.setY(y0);
                path = new Path();
                path.getElements().add(new MoveTo(x0,y0));
                
                // path initialization
                path.setStrokeWidth(2);
                path.setStroke(Color.BLUE);
                // add the start point of the path
                pane1.getChildren().add(path);
            } 
        }
        else
        {
            if (mouseEvent.getClickCount()==1)
            {   
                x0 = (int) mouseEvent.getX();
                y0 = (int) mouseEvent.getY();
                lineTo= new LineTo();
                lineTo.setX(x0);
                lineTo.setY(y0);
                moveTo.setX(x0);
                moveTo.setY(y0);
                if (draw)
                {   //path.getElements().add(moveTo);
                    path.getElements().add(new LineTo(x0,y0));
                }
            }
        }   
        if (mouseEvent.getClickCount()>1)
        {
            draw=false;
            second=true;
        }}  );
    }


    public void interactivePolylineDrawing2()
    {
        if(second)
        {
            if(!draw)
            {
                draw=true;
            }
            path2 = new Path();
            // add the required start point of the path
            path2.getElements().add(new MoveTo(x1,y1));
            path2.setStrokeWidth(2);
            path2.setStroke(Color.RED);
            // mouse drawing,    get the started
            scene.setOnMouseMoved(mouseHandler2);
            scene.setOnMouseClicked(mouseEvent->{
            // freeze the point and get to a new point
            if(second)
            { 
                if (mouseEvent.getClickCount()==1)
                {
                    second=false;
                    x1= (int) mouseEvent.getX();
                    y1= (int) mouseEvent.getY();
                    //path.getElements().clear();
                    pane1.getChildren().remove(path2);
                    lineTo2.setX(x1);
                    lineTo2.setY(y1);
                    path2 = new Path();
                    path2.getElements().add(new MoveTo(x1,y1));
                    
                    // path initialization
                    path2.setStrokeWidth(2);
                    path2.setStroke(Color.RED);
                    // add the start point of the path
                    pane1.getChildren().add(path2);
                } 
            }
            else
                if (mouseEvent.getClickCount()==1)
                {   x1 = (int) mouseEvent.getX();
                    y1 = (int) mouseEvent.getY();
                    lineTo2= new LineTo();
                    lineTo2.setX(x1);
                    lineTo2.setY(y1);
                    moveTo2.setX(x1);
                    moveTo2.setY(y1);
                    if (draw)
                    {   //path.getElements().add(moveTo);
                        path2.getElements().add(new LineTo(x1,y1));
                    }
                }
            
            if (mouseEvent.getClickCount()>1)
                draw=false;
            //   notDone=false;
        }  );
    }}

    
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() 
    {
        @Override
        public void handle(MouseEvent mouseEvent) {
            double x =mouseEvent.getX();
            double y =mouseEvent.getY();
            if (draw)
            {
                lineTo.setX(x);
                lineTo.setY(y);
                path.getElements().add(lineTo);
                
            }
            
        }
    };

    EventHandler<MouseEvent> mouseHandler2 = new EventHandler<MouseEvent>() 
    {
        @Override
        public void handle(MouseEvent mouseEvent) {
            double x =mouseEvent.getX();
            double y =mouseEvent.getY();
            if (draw)
            {
             //  lineTo= new LineTo(); creates line through every pixel.
                lineTo2.setX(x);
                lineTo2.setY(y);
                path2.getElements().add(lineTo2);
            }
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
