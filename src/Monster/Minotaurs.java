package Monster;

import javafx.scene.image.ImageView;

import java.util.Random;

public class Minotaurs implements Monster{

    private int health;
    private int Speed;
    private int damage;
    private int diceCount;


    public Minotaurs() {
        this.health = 50;
        this.Speed = 2;
        this.damage = 8;
        this.diceCount = 2;
    }

    @Override
    public String getName() {
        return "Minotaurs";
    }

    @Override
    public void animation_Attack(ImageView Monster_IV) {

    }

    @Override
    public void animation_Fall(ImageView Monster_IV) {

    }

    @Override
    public int getExp() {
        return 10;
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

    @Override
    public int attack(int DiceCount, int Dice) {
        Random rand = new Random();
        int result = 0;
        for (int i = 0; i < DiceCount; i++) {

            result += rand.nextInt(Dice);
        }

        return result;
    }

}
