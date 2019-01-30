/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zmusic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Evandro
 */
public class ZMusic extends Application {
    
        private double xOffset = 0;
        private double yOffset = 0;
        public static Stage primarystage;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        primarystage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
            
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
            
        });
        
         Scene scene = new Scene(root);
         scene.setFill(Color.TRANSPARENT);
         stage.setScene(scene);
         stage.initStyle(StageStyle.TRANSPARENT);
         stage.show();
    }

            public static void PrimPlano( String scr){
            switch(scr){
                case "a": primarystage.setAlwaysOnTop(true);
            }
        }
        
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
