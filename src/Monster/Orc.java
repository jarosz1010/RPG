package Monster;

import java.util.Random;

public class Orc implements Monster {

    private int health;
    private int Speed;
    private int damage;
    private int diceCount;


    public Orc() {
        this.health = 25;
        this.Speed = 3;
        this.damage = 6;
        this.diceCount = 2;
    }

    @Override
    public String getName() {
        return "Orc";
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
