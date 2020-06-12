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
import java.util.concurrent.TimeUnit;

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
    private ImageView Player_IV;
    @FXML
    private ImageView Monster_IV;
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

    public void Goblin_upadek() {
        int i = 0;

        Image gob1 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek/gob_fall.jpg"));
        Image gob2 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek/gob_fall2.jpg"));
        Image gob3 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek/gob_fall3.jpg"));
        Image gob4 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek/gob_fall4.jpg"));
        Image gob5 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek/gob_fall5.jpg"));
        Image gob6 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek/gob_fall6.jpg"));


        Image play1 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig.jpg"));
        Image play2 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig2.jpg"));
        Image play3 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig3.jpg"));
        Image play4 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig4.jpg"));
        Image[] gobliny = {gob1, gob2, gob3, gob4, gob5, gob6};
        Image[] playery = {play1, play2, play3, play4};

        Timeline timeLine = new Timeline();
        Collection<KeyFrame> frames = timeLine.getKeyFrames();
        Timeline timeLine2 = new Timeline();
        Collection<KeyFrame> frames2 = timeLine.getKeyFrames();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO ;
        Duration frameGap2 = Duration.millis(125);
        Duration frameTime2 = Duration.ZERO ;

        for (Image img : gobliny) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e -> Monster_IV.setImage(img)));
        }
        for (Image img2 : playery) {
            frameTime2 = frameTime2.add(frameGap2);
            frames2.add(new KeyFrame(frameTime2, e -> Player_IV.setImage(img2)));
        }
        timeLine.setCycleCount(1);

        timeLine.play();
        timeLine2.setCycleCount(1);

        timeLine2.play();


    }

    public void Goblin_walka() {
        int i = 0;

        Image gob1 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka/gob_fig.jpg"));
        Image gob2 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka/gob_fig2.jpg"));
        Image gob3 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka/gob_fig3.jpg"));
        Image gob4 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka/gob_fig4.jpg"));
        Image gob5 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka/gob_fig5.jpg"));
        Image gob6 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka/gob_fig6.jpg"));

        Image play1 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall.jpg"));
        Image play2 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall2.jpg"));
        Image play3 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall3.jpg"));
        Image play4 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall4.jpg"));
        Image play5 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall5.jpg"));
        Image[] gobliny = {gob1, gob2, gob3, gob4, gob5, gob6};
        Image[] playery = {play1, play2, play3, play4, play5};

        Timeline timeLine = new Timeline();
        Collection<KeyFrame> frames = timeLine.getKeyFrames();
        Timeline timeLine2 = new Timeline();
        Collection<KeyFrame> frames2 = timeLine.getKeyFrames();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO ;
        Duration frameGap2 = Duration.millis(100);
        Duration frameTime2 = Duration.ZERO ;

        for (Image img : gobliny) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e -> Monster_IV.setImage(img)));
        }
        for (Image img2 : playery) {
            frameTime2 = frameTime2.add(frameGap2);
            frames2.add(new KeyFrame(frameTime2, e -> Player_IV.setImage(img2)));
        }
        timeLine.setCycleCount(1);

        timeLine.play();
        timeLine2.setCycleCount(1);

        timeLine2.play();

    }

    @FXML
    protected void fight(ActionEvent event) {

        while (winer == 0) {
            int monsterDamage = mon.attack(mon.getDiceCount(), mon.getDamage()) - player.getDefense();
            int playerDamage = player.attack();
            if (monsterDamage < 0) {
                monsterDamage = 0;
            }
            if (mon.getSpeed() > player.getSpeed()) {
                Goblin_walka();
                player.setHealth( player.getHealth() - monsterDamage);

                if (player.getHealth() <= 0) {
                    winer = 1;
                    break;
                }
                mon.setHealth( mon.getHealth() - playerDamage);

                if (mon.getHealth() <= 0) {
                    winer = 2;
                    break;
                }


            } else {
                Goblin_upadek();
                mon.setHealth(mon.getHealth() - playerDamage);

                if (mon.getHealth() <= 0) {
                    winer = 2;
                    break;
                }
                player.setHealth(player.getHealth() - monsterDamage );
            
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
