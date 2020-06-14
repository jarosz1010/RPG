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
    private ImageView Potion1;
    @FXML
    private ImageView Potion2;
    @FXML
    private ImageView Potion3;
  //  private Text healCountInfo;

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

    @FXML
    protected void fight(ActionEvent event) {

        while (winer == 0) {
            int monsterDamage = mon.attack(mon.getDiceCount(), mon.getDamage()) - player.getDefense();
            int playerDamage = player.attack();
            if (monsterDamage < 0) {
                monsterDamage = 0;
            }
            if (mon.getSpeed() > player.getSpeed()) {

                player.setHealth( player.getHealth() - monsterDamage);

                if (player.getHealth() <= 0) {
                    mon.animation_Attack(Monster_IV);
                    player.animation_Fall(Player_IV);
                    winer = 1;
                    break;
                }
                mon.setHealth( mon.getHealth() - playerDamage);

                if (mon.getHealth() <= 0) {
                    mon.animation_Fall(Monster_IV);
                    player.animation_Attack(Player_IV);
                    winer = 2;
                    break;
                }


            } else {

                mon.setHealth(mon.getHealth() - playerDamage);

                if (mon.getHealth() <= 0) {
                    mon.animation_Fall(Monster_IV);
                    player.animation_Attack(Player_IV);
                    winer = 2;
                    break;
                }
                player.setHealth(player.getHealth() - monsterDamage );
            
                if (player.getHealth() <= 0) {
                    mon.animation_Attack(Monster_IV);
                    player.animation_Fall(Player_IV);
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
               // healCountInfo.setText(" You have "+ healcount + " heal potion");
                Potion1.setVisible(true);
                Potion2.setVisible(true);
                Potion3.setVisible(true);
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
                    if(healcount==2) {
                        Potion3.setVisible(false);
                    }else if(healcount==1){
                        Potion2.setVisible(false);
                    }else if(healcount==0){
                        Potion1.setVisible(false);
                    }

                   // healCountInfo.setText(" You have "+ healcount + " heal potion");
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
