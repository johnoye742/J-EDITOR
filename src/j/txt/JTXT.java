/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j.txt;

import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author John
 */
public class JTXT extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 
        Group root = new Group();
        TextField ta = new TextField();
      ta.setLayoutX(50);
      ta.setLayoutY(60);
      TextArea nm = new TextArea();
     Label l = new Label("Enter File Name: ");
     
    l.setLabelFor(nm);
     nm.setLayoutX(70);
     nm.setLayoutY(100);



      Alert al = new Alert(AlertType.INFORMATION);
      
      Button btn = new Button("Save");
      btn.setLayoutX(500);
      btn.setLayoutY(300);
      File fe = new File("/Users/John/My Documents/J Editor");
      if(!fe.exists()) {
          fe.mkdir();
      }
      btn.setOnAction((a) -> {
          try {
      String txt = ta.getText();
      File fe1 = new File("/Users/John/My Documents/J Editor/"+txt);
      if(fe1.createNewFile()) {
          FileWriter fw = new FileWriter(fe1);
          fw.write(nm.getText());
          fw.close();
          al.setTitle("File Saved");
          al.setContentText("File Saved at: "+fe1.getAbsolutePath());
          al.show();
      }
          } catch(Exception e) {
              
          }
      });
      ObservableList ol = root.getChildren();
        ol.add(ta);
        ol.add(nm);
        ol.add(l);
        ol.add(btn);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("J Editor");
       
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
