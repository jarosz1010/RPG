package sample;

import java.util.Random;


public class Player {
    private int exp;
    private String name;
    private int level;
    private int health;
    private int maxHP=50;
    private int Strenth;
    private int Dexterity;
    private int Inteligent;
    private int Vitallyty;
    private int Speed;
    private int dice;
    private int diceCount;
    private int Defense;


    public Player(String name) {
        this.exp=0;
        this.name = name;
        this.level = 1;
        this.health=maxHP;
        this.Strenth = 15;
        this.Dexterity = 8;
        this.Inteligent = 5;
        this.Vitallyty = 12;
        this.Speed = 5;
        this.diceCount =1;
        this.dice = 6;
        this.Defense = 0;
    }

    public Player() {
        this.exp=0;
        this.name = "Stefan";
        this.level = 0;
        this.health=0;
        this.Strenth = 0;
        this.Dexterity = 0;
        this.Inteligent = 0;
        this.Vitallyty = 0;
        this.Speed = 0;
        this.diceCount =0;
        this.dice = 0;
        this.Defense = 0;
    }

    public int getExp() {
        return exp;
    }
    public String getName(){
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public int getDexterity() {
        return Dexterity;
    }
    public int getInteligent() {
        return Inteligent;
    }
    public int getStrenth() {
        return Strenth;
    }
    public int getVitallyty() {
        return Vitallyty;
    }
    public int getSpeed() {
        return Speed;
    }
    public int getDice() {
        return dice;
    }
    public int getDiceCount() {
        return diceCount;
    }
    public int getDefense() {
        return Defense;
    }
    public int getMaxHP() { return maxHP; }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }
    public void setInteligent(int inteligent) {
        Inteligent = inteligent;
    }
    public void setStrenth(int strenth) {
        Strenth = strenth;
    }
    public void setVitallyty(int vitallyty) {
        Vitallyty = vitallyty;
    }
    public void setSpeed(int speed) {
        Speed = speed;
    }
    public void setDice(int dice) {
        this.dice = dice;
    }
    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }
    public void setDefense(int defense) {
        Defense = defense;
    }

    int attack(){
        Random rand = new Random();
        Dice dice = new Dice();
        int Crit = 1;
        int CritChans = rand.nextInt(20);
        if (CritChans == 20){
            Crit = 2;
        }
        return dice.roll(this.diceCount, this.dice)*Crit + (this.getStrenth())/4;
    }

    public int nextLevel(int level){
        return (int) ((4 * Math.pow(level,2) ) / 2);
    }

    public void levelUp(){
        this.exp -= nextLevel(this.level);
        level += 1;
        this.setStrenth(this.getStrenth()+ 4);
        this.setInteligent(this.getInteligent()+ 2);
        this.setDexterity(this.getDexterity() +1);
        this.setVitallyty(this.getVitallyty()+5);
        this.maxHP += 5;
        this.health = this.health + (int) (0.04 * (this.level^3)+0.8*(this.level^2)+ 2*level);
        this.Defense += this.getDefense()/4;
    }
}
