package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
int obrazek_x = 50;
int obrazek_y = 300;
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Tu trzeba podac odpowiednia sciezke do pliku
        String sciezka = "C:\\Users\\\\testowy\\\\IdeaProjects\\Test\\";
        primaryStage.setTitle("Hello World");

        final ImageView knight_Image = new ImageView();
        final ImageView dragon_Image = new ImageView();
        Image image1 = new Image(new FileInputStream(sciezka + "knight2.png"), 200, 200, false, false);
        Image image2 = new Image(new FileInputStream(sciezka + "knight.jpg"), 200, 200, false, false);
        Image image3 = new Image(new FileInputStream(sciezka + "dragon.png"), 200, 200, false, false);
        Image image4 = new Image(new FileInputStream(sciezka + "dragon2.png"), 200, 200, false, false);

        knight_Image.setX(obrazek_x);
        knight_Image.setY(obrazek_y);
        knight_Image.setImage(image1);
        dragon_Image.setX(800);
        dragon_Image.setY(300);
        dragon_Image.setImage(image3);

        Group root = new Group(knight_Image, dragon_Image);



        Scene scena = new Scene(root, 1000, 800);
        scena.setRoot(root);

        //Sterowanie klawiszami
        scena.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.W) {
                obrazek_y = obrazek_y - 30;

                knight_Image.setY(obrazek_y);
            }
            if(key.getCode()== KeyCode.A) {
                obrazek_x = obrazek_x - 30;
                knight_Image.setX(obrazek_x);
            }
            if(key.getCode()== KeyCode.S) {
                obrazek_y = obrazek_y + 30;
                knight_Image.setY(obrazek_y);
            }
            if(key.getCode()== KeyCode.D) {
                obrazek_x = obrazek_x + 30;
                knight_Image.setX(obrazek_x);
            }
            if(key.getCode()== KeyCode.SPACE) {
                knight_Image.setImage(image2);
                if(obrazek_x + 100 > 600 && (obrazek_y +100 > 300 && obrazek_y +100 < 500)) {
                    dragon_Image.setImage(image4);
                }
            }

        });
        // Zeby po puszczeniu spacji powracal normalny wyglad rycerza

        scena.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if(key.getCode()== KeyCode.SPACE) {
                knight_Image.setImage(image1);
                dragon_Image.setImage(image3);
            }
        });

        primaryStage.setScene(scena);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
