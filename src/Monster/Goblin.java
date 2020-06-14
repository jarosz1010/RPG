package Monster;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Collection;
import java.util.Random;

public class Goblin implements Monster {

    private int health;
    private int Speed;
    private int damage;
    private int diceCount;


    public Goblin() {
        this.health = 20;
        this.Speed = 5;
        this.damage = 6;
        this.diceCount = 1;
    }

    @Override
    public String getName() {
        return "Goblin";
    }

    @Override
    public int getExp() {
        return 2;
    }

    public void setHealth(int value) {
        this.health = value;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getSpeed() {
        return this.Speed;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getDiceCount() {
        return this.diceCount;
    }


    public void animation_Attack(ImageView Monster_IV){
        Image gob1 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka_2/gob_fig.png"));
        Image gob2 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka_2/gob_fig2.png"));
        Image gob3 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka_2/gob_fig3.png"));
        Image gob4 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka_2/gob_fig4.png"));
        Image gob5 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka_2/gob_fig5.png"));
        Image gob6 = new Image(getClass().getResourceAsStream("/Image/Goblin_walka_2/gob_fig6.png"));
        Image[] gobliny = {gob1, gob2, gob3, gob4, gob5, gob6};

        Timeline goblin_attack = new Timeline();
        Collection<KeyFrame> attack_frame = goblin_attack.getKeyFrames();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO ;

        for (Image img2 : gobliny) {
            frameTime = frameTime.add(frameGap);
            attack_frame.add(new KeyFrame(frameTime, e -> Monster_IV.setImage(img2)));
        }
        goblin_attack.setCycleCount(1);

        goblin_attack.play();
    }

    public void animation_Fall(ImageView Monster_IV){
        Image gob1 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek_2/gob_fall.png"));
        Image gob2 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek_2/gob_fall2.png"));
        Image gob3 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek_2/gob_fall3.png"));
        Image gob4 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek_2/gob_fall4.png"));
        Image gob5 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek_2/gob_fall5.png"));
        Image gob6 = new Image(getClass().getResourceAsStream("/Image/Goblin_upadek_2/gob_fall6.png"));

        Image[] gobliny_fall = {gob1, gob2, gob3, gob4, gob5, gob6};

        Timeline goblin_fall = new Timeline();
        Collection<KeyFrame> fall_frame = goblin_fall.getKeyFrames();

        Duration fall_frameGap = Duration.millis(100);
        Duration fall_frameTime = Duration.ZERO ;

        for (Image img2 : gobliny_fall) {
            fall_frameTime = fall_frameTime.add(fall_frameGap);
            fall_frame.add(new KeyFrame(fall_frameTime, e -> Monster_IV.setImage(img2)));
        }
        goblin_fall.setCycleCount(1);

        goblin_fall.play();
    }
    @Override
    public int attack(int DiceCount, int Dice) {
        Random rand = new Random();
        int result = 0;
        for (int i = 0; i < DiceCount; i++) {

            result += rand.nextInt(Dice);
        }

        return result + 2;
    }
}
