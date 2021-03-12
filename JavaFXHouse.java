
package javafxhouse;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class JavaFXHouse extends Application{
Group group;
GraphicsContext gc;
  
   // launch the application
   public void start(Stage stage)
   {
       // set title for the stage
       stage.setTitle("creating canvas");
       // create a canvas
       Canvas canvas = new Canvas(600.0f, 600.0f);
       // graphics context
       gc = canvas.getGraphicsContext2D();   
       // create a Group
       group = new Group(canvas);
draw1();
       // create a scene
       Scene scene = new Scene(group, 600, 600);
       // set the scene
       stage.setScene(scene);
       stage.show();
   }
  
   public void draw1()
   {
//sky
gc.setFill(Color.LIGHTBLUE);
gc.fillRect(0, 0, 600, 250);

//lawn
gc.setFill(Color.GREEN);
gc.fillRect(0, 250, 600, 600);
  //create the roof
Polyline triangle = new Polyline();
triangle.getPoints().addAll(new Double[]{
300.0, 0.0, 550.0, 150.0,50.0, 150.0,300.0, 0.0, });
triangle.setStroke(Color.BLACK);
triangle.setFill(Color.WHITE);
group.getChildren().add(triangle);
  //rectangle below roof
Rectangle rect = new Rectangle(70, 150, 460, 30);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//base of house
rect = new Rectangle(70, 180, 460, 330);
//what each num does 1=x 2=y 3,4=size of rect
rect.setFill(Color.RED);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);


//doors
rect = new Rectangle(125, 295, 80, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
Windows(142, 310);

rect = new Rectangle(260, 275, 80, 190);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
Windows(277, 310);

rect = new Rectangle(395, 295, 80, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
Windows(412, 310);

//pillars between doors
pillar(350, 180);
pillar(480, 180);
pillar(220, 180);
pillar(80, 180);
//staris below pillars
stairs(120, 460);

rect = new Rectangle(260, 210, 80, 40);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

rect = new Rectangle(70, 460, 460, 10);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

   }
  
public void Windows(int x, int y)
{
Rectangle rect;
  
for(int i = 0, j=0; i<5; i++, j+=30)
{
rect = new Rectangle( x, y+j, 15, 25 ); //black left
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
rect = new Rectangle( x+30, y+j, 15, 25 ); //black right
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
}
}
  
public void pillar(int x, int y)
{
Rectangle rect;
int width=35, height=270;
  
rect = new Rectangle( x, y, width, height ); //pillar
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
rect = new Rectangle( x-5, y+height, 45, 10 ); ////pillar base
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//circles on pillars
Circle circle1 = new Circle();
// circle1
int radius=10;
circle1.setFill(Color.WHITE);
circle1.setStroke(Color.BLACK);
circle1.setRadius(radius);
circle1.setCenterX(x);
circle1.setCenterY(y+radius);
group.getChildren().add(circle1);

Circle circle2 = new Circle();
// circle2   
circle2.setFill(Color.WHITE);
circle2.setStroke(Color.BLACK);
circle2.setRadius(radius);
circle2.setCenterX(x+width);
circle2.setCenterY(y+radius);
group.getChildren().add(circle2);
}
  
public void stairs(int x, int y)
{
Rectangle rect;
int width=360, height=10;
  
for(int i=1; i<=11; i++)
{
    //11 steps
rect = new Rectangle(x, y, width, 10);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);   
x= x-10; //decrease width for next stair by 10
y= y+height; //increase height for next stair
width = width + 20; //increase width for next stair by 10
}
}

   // Main Method
   public static void main(String args[])
   {
// launch the application
launch(args);
   }
}
