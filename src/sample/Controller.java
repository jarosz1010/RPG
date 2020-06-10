package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javax.swing.*;

import Monster.*;
import javafx.util.Duration;

import java.util.Collection;

public class Controller {
    @FXML
    private Text charakterInfo;
    @FXML
    private Text EXPInfo;
    @FXML
    private Text StrInfo;
    @FXML
    private Text DexInfo;
    @FXML
    private Text IntInfo;
    @FXML
    private Text VitInfo;
    @FXML
    private Text SpeedInfo;
    @FXML
    private Text LvInfo;
    @FXML
    private Text HPInfo;
    @FXML
    private Text DefInfo;
    @FXML
    private TextField Name;
    @FXML
    private TextArea fightLog;
    @FXML
    private Text healCountInfo;

    Player player = new Player();
    Monster mon = new Goblin();
    int winer = 0;
    int healcount =3;
    @FXML
    private ImageView Rycerz;
    @FXML
    private ImageView Smok;
    @FXML
    protected void SubmitName(ActionEvent event) {
        //Okno dialogowe
        JFrame frame = new JFrame("Podaj imie");
        String name = JOptionPane.showInputDialog(frame, "Podaj swoje imie");

        String imie = name;
        player = new Player(imie);
        charakterInfo.setText(imie);
        EXPInfo.setText(Integer.toString(player.getExp()));
        StrInfo.setText(Integer.toString(player.getStrenth()));
        DexInfo.setText(Integer.toString(player.getDexterity()));
        IntInfo.setText(Integer.toString(player.getInteligent()));
        VitInfo.setText(Integer.toString(player.getVitallyty()));
        SpeedInfo.setText(Integer.toString(player.getSpeed()));
        LvInfo.setText(Integer.toString(player.getLevel()));
        HPInfo.setText(Integer.toString(player.getHealth()));
        DefInfo.setText(Integer.toString(player.getDefense()));
    }

    public void Change_Image() {
        int i = 0;
        Image rycerz1 = new Image(getClass().getResourceAsStream("/Image/rycerz1.jpg"));
        Image rycerz2 = new Image(getClass().getResourceAsStream("/Image/rycerz2.jpg"));
        Image rycerz3 = new Image(getClass().getResourceAsStream("/Image/rycerz3.jpg"));
        Image rycerz4 = new Image(getClass().getResourceAsStream("/Image/rycerz4.jpg"));
        Image rycerz5 = new Image(getClass().getResourceAsStream("/Image/rycerz5.jpg"));
        Image smok1 = new Image(getClass().getResourceAsStream("/Image/smok1.png"));
        Image smok2 = new Image(getClass().getResourceAsStream("/Image/smok2.png"));
        Image smok3 = new Image(getClass().getResourceAsStream("/Image/smok3.png"));
        Image smok4 = new Image(getClass().getResourceAsStream("/Image/smok4.png"));
        Image smok5 = new Image(getClass().getResourceAsStream("/Image/smok5.png"));
        Image smok6 = new Image(getClass().getResourceAsStream("/Image/smok6.png"));
        Image smok7 = new Image(getClass().getResourceAsStream("/Image/smok7.png"));
        Image smok8 = new Image(getClass().getResourceAsStream("/Image/smok8.png"));
        Image smok9 = new Image(getClass().getResourceAsStream("/Image/smok9.png"));
        Image smok10 = new Image(getClass().getResourceAsStream("/Image/smok10.png"));

        Image[] smoki = {smok1,smok2, smok3, smok4, smok5, smok6, smok7, smok8, smok9, smok10};
        Image[] rycerze = {rycerz1, rycerz2, rycerz3, rycerz4, rycerz5};

        Timeline timeLine = new Timeline();
        Collection<KeyFrame> frames = timeLine.getKeyFrames();
        Timeline timeLine2 = new Timeline();
        Collection<KeyFrame> frames2 = timeLine.getKeyFrames();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO ;
        // Tutaj koniecznie dwa razy wiekszy czas bo mniej zdjec
        Duration frameGap2 = Duration.millis(200);
        Duration frameTime2 = Duration.ZERO ;
        for (Image img : smoki) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e -> Smok.setImage(img)));
        }
        for (Image img2 : rycerze) {
            frameTime2 = frameTime2.add(frameGap2);
            frames2.add(new KeyFrame(frameTime2, e -> Rycerz.setImage(img2)));
        }
        timeLine.setCycleCount(1);

        timeLine2.setCycleCount(1);
        timeLine.play();
        timeLine2.play();
    }

    @FXML
    protected void fight(ActionEvent event) {
        Change_Image();
        while (winer == 0) {
            int monsterDamage = mon.attack(mon.getDiceCount(), mon.getDamage()) - player.getDefense();
            int playerDamage = player.attack();
            if (monsterDamage < 0) {
                monsterDamage = 0;
            }
            if (mon.getSpeed() > player.getSpeed()) {
                player.setHealth( player.getHealth() - monsterDamage);
                   // Animacja
                if (player.getHealth() <= 0) {
                    winer = 1;
                    break;
                }
                mon.setHealth( mon.getHealth() - playerDamage);
                   // Animacja
                if (mon.getHealth() <= 0) {
                    winer = 2;
                    break;
                }
            } else {
                mon.setHealth(mon.getHealth() - playerDamage);
                  //  Animacja
                if (mon.getHealth() <= 0) {
                    winer = 2;
                    break;
                }
                player.setHealth(player.getHealth() - monsterDamage );
                  //  Animacja
                if (player.getHealth() <= 0) {
                    winer = 1;
                    break;
                }
            }


            fightLog.appendText("Player damage: " + playerDamage + " | current "+ mon.getName() +" health: "+ mon.getHealth() + "\n");
            fightLog.appendText(mon.getName() +" damage: " + monsterDamage + " | current player health: "+ player.getHealth() + "\n");
        }
        if (winer == 1){
            //Okno YOU DIED
            fightLog.appendText("\n");
            fightLog.appendText("YOU DIED\n");

        } else {
            fightLog.appendText("\n");
            fightLog.appendText(mon.getName() + " pokonany \n");
            player.setExp(player.getExp() + mon.getExp());
            if (player.getExp() >= player.nextLevel(player.getLevel())) {
                player.levelUp();
                healcount = 3;
                healCountInfo.setText(" You have "+ healcount + " heal potion");
                fightLog.appendText("\n");
                fightLog.appendText("LEVEL UP! \n");
                printStat();
            }else {
                printStat();
            }
            winer = 0;
        }
        mon = new Goblin();
    }

    @FXML
    protected void heal(ActionEvent event){
        Dice dice = new Dice();
        if(winer == 1) {
            fightLog.appendText("You can't heal, because you are dead\n");
        } else {
            if (healcount > 0) {
                if (player.getHealth() < player.getMaxHP())  {
                    player.setHealth(player.getHealth() + dice.roll(2,20));
                    printStat();
                    --healcount;
                    healCountInfo.setText(" You have "+ healcount + " heal potion");
                }
            } else {
                fightLog.appendText("You can't heal\n");
            }
        }

    }

    void printStat(){
        EXPInfo.setText(Integer.toString(player.getExp()));
        StrInfo.setText(Integer.toString(player.getStrenth()));
        DexInfo.setText(Integer.toString(player.getDexterity()));
        IntInfo.setText(Integer.toString(player.getInteligent()));
        VitInfo.setText(Integer.toString(player.getVitallyty()));
        SpeedInfo.setText(Integer.toString(player.getSpeed()));
        LvInfo.setText(Integer.toString(player.getLevel()));
        HPInfo.setText(Integer.toString(player.getHealth()));
        DefInfo.setText(Integer.toString(player.getDefense()));
    }
}
