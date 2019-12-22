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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
//actions items
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//paint and othe useful classes
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
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
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
    StackPane demo = new StackPane();
    StackPane demo1 = new StackPane();
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
    Image imagePlay, imageRefresh, imageStop;

    public Pane createFrontPage()
    {   
        FanPane fan = new FanPane();
        StackPane demo = new StackPane();
        imagePlay = new Image("images/play.png");
        ImageView btPlay = new ImageView(imagePlay);
        btPlay.setFitHeight(40); 
        btPlay.setFitWidth(40);
        imageRefresh = new Image("images/refresh.png");
        ImageView Reverse = new ImageView(imageRefresh);
        Reverse.setFitHeight(40); 
        Reverse.setFitWidth(40);
        imageStop = new Image("images/stop.png");
        ImageView Stop = new ImageView(imageStop);
        Stop.setFitHeight(40); 
        Stop.setFitWidth(40);
        demo.getChildren().addAll(fan);        
        HBox hBox = new HBox(5);
        Button btResume = new Button("",btPlay);
        Button btReverse = new Button("",Reverse);
        Button btStop = new Button("",Stop);

        Slider slAdjustBlades;
        slAdjustBlades = new Slider(1,15,1);
        slAdjustBlades.setShowTickLabels(true);
        slAdjustBlades.setShowTickMarks(true);
        slAdjustBlades.setStyle("-fx-border-color: blue;-fx-border-radius: 4;-fx-border-width: 2;");

        Slider slAdjustSpeed;
        HBox LowhBox = new HBox(5);
        slAdjustSpeed = new Slider(1,15,1);
        slAdjustSpeed.setShowTickLabels(true);
        slAdjustSpeed.setShowTickMarks(true);
        slAdjustSpeed.setStyle("-fx-border-color: blue;-fx-border-radius: 4;-fx-border-width: 2;");




        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll( btResume,btReverse,btStop,slAdjustBlades);
        LowhBox.setAlignment(Pos.CENTER);
        LowhBox.getChildren().add(slAdjustSpeed);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(fan);
        pane.setTop(hBox);
        pane.setBottom(LowhBox);


        pane1.widthProperty().addListener(e -> fan.setW(fan.getWidth()));
        pane1.heightProperty().addListener(e -> fan.setH(fan.getHeight()));
        

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e -> fan.move()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();

        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fan.reverse());
        btStop.setOnAction(e -> animation.pause());

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
        
        t1 = new Text(10, 100, "This is a test");
        t1.setText("Demonstration of Assignment for\nJava, GUI and Visualization: CS5405");
        t5 = new Text(10, 140, "This is my orignal code, No IDE used in the submission. \n I did not give my code to anyone or \nI did not use anypne's code in this work");
        t6 = new Text(10, 180, "\nLink: url address for reference to specific page and quotation");
                      
        t2 = new Text(10, 80, "This is a test");
        t2.setFont(new Font(20));
        t2.setFill(Color.RED);
        t2.setWrappingWidth(500);
        t2.setTextAlignment(TextAlignment.CENTER);
        t2.setText("Demonstration of Assignment 10 for\nJava, GUI and Visualization: CS5405");
        
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
                      "This is an extension of previous homework. Turn in the complete program including (fan, start/pause, reverse,  animation done in the previous HW).\nFor additional interaction with animation, add\n1.	a slider to specify the number of blades in the fan,\n2.	a slider to specify the speed of the fan.\n");
        t7.setFont(new Font(20));
        t7.setFill(Color.BLUE);
        t7.setWrappingWidth(600);
        t7.setTextAlignment(TextAlignment.JUSTIFY);

        //demo.getChildren().addAll(circle1,circle2,circle3,pane); //ImageDemo
        //demo1.getChildren().addAll(demo,pane);
        pane1.getChildren().addAll(demo,pane); //ImageDemo
        pane2.getChildren().addAll(t2,t3,t4); //author
        pane3.getChildren().addAll(t7); //problem
        pane4.getChildren().addAll(pane3);
        
        //demo.relocate(135,25);//ImageDemo
        //pane1.relocate(135,25);
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
                pane4.getChildren().addAll(pane);});
        button2.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane2);});
        button3.setOnAction(ae->
            {pane4.getChildren().clear();pane4.getChildren().add(pane3);});
        return root;
    }

class FanPane extends Pane {
    private double w = 400;
    private double h = 400;
    private double radius = Math.min(w, h) * 0.45;
    private Arc arc[] = new Arc[4];
    private double startAngle = 30;
    private Circle circle = new Circle(w / 2, h / 2, radius);
    
    public FanPane() {
        circle.setStroke(Color.TRANSPARENT);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
        
        for (int i = 0; i < 4; i++) {
            arc[i] = new Arc(w / 2, h / 2, radius * 0.9, radius * 0.9, startAngle + i * 90, 35);
            arc[i].setFill(Color.RED); // Set fill color
            arc[i].setType(ArcType.ROUND);
            getChildren().addAll(arc[i]);
        }
    }
    
    private double increment = 5;
    
    public void reverse() {
        increment = -increment;
    }
    
    public void move() {
        setStartAngle(startAngle + increment);
    }
    
    public void setStartAngle(double angle) {
        startAngle = angle;
        setValues();
    }
    
    public void setValues() {
        radius = Math.min(w, h) * 0.45;
        circle.setRadius(radius);
        circle.setCenterX(w / 2);
        circle.setCenterY(h / 2);
        
        for (int i = 0; i < 4; i++) {
            arc[i].setRadiusX(radius * 0.9);
            arc[i].setRadiusY(radius * 0.9);
            arc[i].setCenterX(w / 2);
            arc[i].setCenterY(h / 2);
            arc[i].setStartAngle(startAngle + i * 90);
        }
    }
    
    public void setW(double w) {
        this.w = w;
        setValues();
    }
    
    public void setH(double h) {
        this.h = h;
        setValues();
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
