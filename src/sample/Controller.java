package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import Monster.*;

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

    Player player = new Player();
    Monster mon = new Goblin();
    int winer = 0;
    int healcount =3;

    @FXML
    protected void SubmitName(ActionEvent event) {
        String imie = Name.getText();
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
            fightLog.appendText("YOU DIED");

        } else {
            fightLog.appendText("\n");
            fightLog.appendText(mon.getName() + " pokonany \n");
            player.setExp(player.getExp() + mon.getExp());
            if (player.getExp() >= player.nextLevel(player.getLevel())) {
                player.levelUp();
                healcount = 3;
                fightLog.appendText("\n");
                fightLog.appendText("LEVEL UP! \n");
                printStat();
            }else {
                printStat();
            }
        }
        winer = 0;
        mon = new Goblin();
    }

    @FXML
    protected void heal(ActionEvent event){
        Dice dice = new Dice();
        if(winer != 1) {
            if (healcount > 0) {
                if (player.getHealth() < player.getMaxHP())  {
                    player.setHealth(player.getHealth() + dice.roll(2,20));
                    printStat();
                    --healcount;
                }
            } else {
                fightLog.appendText("You can't heal\n");
            }

        } else {
            fightLog.appendText("You can't heal, because tou are dead\n");
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
