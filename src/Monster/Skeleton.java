package Monster;

import java.util.Random;

public class Skeleton implements Monster {

    private int health;
    private int Speed;
    private int damage;
    private int diceCount;


    public Skeleton() {
        this.health = 30;
        this.Speed = 4;
        this.damage = 4;
        this.diceCount = 2;
    }

    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public int getExp() {
        return 4;
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

        return result + 1;
    }
}
