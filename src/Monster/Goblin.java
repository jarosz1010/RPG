package Monster;

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
