package sample;

import java.util.Random;

public class Dice {

    public int roll(int DiceCount, int Dice) {
        Random rand = new Random();
        int result = 0;
        for (int i = 0; i < DiceCount; i++) {

            result += rand.nextInt(Dice);
        }
        return result;
    }
}
