package Monster;

import javafx.scene.image.ImageView;

public interface Monster {
    String getName();
    int getExp();

    int getHealth();
    int getSpeed();
    int getDamage();
    int getDiceCount();

    void setHealth(int damage);
    void animation_Attack(ImageView Monster_IV);
    void animation_Fall(ImageView Monster_IV);
    int attack(int DiceCount, int Dice);
}
