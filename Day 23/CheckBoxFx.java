import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.event.*;
import javafx.scene.paint.*;

public class CheckBoxFx  extends Application implements EventHandler<ActionEvent>
{
    Text f;
    RadioButton r1,r2,r3;
    CheckBox c1,c2,c3;
    ChoiceBox<Integer> cb;
    public void start(Stage stage)throws Exception

    {
        f=new Text("Hello world");
        HBox hb1=new HBox();
        hb1.getChildren().add(f);
        r1=new RadioButton("Red");
        r2=new RadioButton("Blue");
        r3=new RadioButton("Green");
        ToggleGroup tg=new ToggleGroup();
        r1.setToggleGroup(tg);
         r2.setToggleGroup(tg);
         r3.setToggleGroup(tg);
         HBox hb2=new HBox();
         hb2.getChildren().addAll(r1,r2,r3);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(10,10,10,10));

         c1=new CheckBox("Normal");
        c2=new CheckBox("Bold");
        c3=new CheckBox("Italic");
        HBox hb3=new HBox();
        hb3.getChildren().addAll(c1,c2,c3);
        hb3.setSpacing(15);
        hb3.setPadding(new Insets(10,10,10,10));

        cb=new ChoiceBox<>();
        cb.getItems().addAll(10,20,30,40,50);

         VBox vb=new VBox();
         vb.getChildren().addAll(hb1,hb2,hb3,cb);
         vb.setSpacing(15);
        vb.setPadding(new Insets(10,10,10,10));
        r1.setOnAction(this);
        r2.setOnAction(this);
        r3.setOnAction(this);
        c1.setOnAction(this);
        c2.setOnAction(this);
        c3.setOnAction(this);

         Scene sc=new Scene(vb,500,500);
            stage.setScene(sc);
            stage.show();



    }
    public void handle(ActionEvent ae){
        FontWeight fw=FontWeight.NORMAL;
        FontPosture fp=FontPosture.REGULAR;
        if(r1.isSelected())
        f.setFill(Paint.valueOf("red"));
        if(r2.isSelected())
        f.setFill(Paint.valueOf("blue"));
        if(r3.isSelected())
        f.setFill(Paint.valueOf("green"));

        if(c2.isSelected())
        fw=FontWeight.BOLD;
        if(c3.isSelected())
        fp=FontPosture.ITALIC;
        f.setFont(Font.font("Times New Roman",fw,fp,cb.getValue()));


    }
    public static void main(String args[]){
        launch(args);
    }
} 