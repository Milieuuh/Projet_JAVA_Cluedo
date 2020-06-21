package sample;

import IHM.Fenetre.FenetreMenu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group() ;
        primaryStage.setTitle("CLUEDO");
        primaryStage.setScene(new Scene(root, 400, 500));
        FenetreMenu f = new FenetreMenu(primaryStage);
        root.getChildren().add(f) ;
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
