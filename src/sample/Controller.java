package sample;

import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

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

    Player player = new Player();

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
        int winer = 0;
//        while (winer == 0) {
//            int monsterDamage = mon.attack(mon.getDiceCount(), mon.getDamage()) - player.getDefense();
//            int playerDamage = player.attack();
//            if (monsterDamage < 0) {
//                monsterDamage = 0;
//            }
//            if (mon.getSpeed() > player.getClas().getSpeed()) {
//                player.setHealth( player.getHealth() - monsterDamage);
//                if (player.getHealth() <= 0) {
//                    winer = 1;
//                    break;
//                }
//                mon.setHealth( mon.getHealth() - playerDamage);
//                if (mon.getHealth() <= 0) {
//                    winer = 2;
//                    break;
//                }
//            } else {
//                mon.setHealth(mon.getHealth() - playerDamage);
//                if (mon.getHealth() <= 0) {
//                    winer = 2;
//                    break;
//                }
//                player.setHealth(player.getHealth() - monsterDamage );
//                if (player.getHealth() <= 0) {
//                    winer = 1;
//                    break;
//                }
//            }
//
//            System.out.println("Player damage:" + playerDamage + " current "+ mon.getName() +" health: "+ mon.getHealth());
//            System.out.println( mon.getName() +" damage:" + monsterDamage + " current player health: "+ player.getHealth());
//        }
    }
}
