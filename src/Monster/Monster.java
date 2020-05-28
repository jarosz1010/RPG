package Monster;

public interface Monster {
    String getName();
    int getExp();

    int getHealth();
    int getSpeed();
    int getDamage();
    int getDiceCount();

    void setHealth(int damage);

    int attack(int DiceCount, int Dice);
}
