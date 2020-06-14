package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Collection;
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
    void animation_Attack(ImageView Player_IV){

        Image play1 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig.jpg"));
        Image play2 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig2.jpg"));
        Image play3 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig3.jpg"));
        Image play4 = new Image(getClass().getResourceAsStream("/Image/Player_walka/play_fig4.jpg"));
        Image[] playery = {play1, play2, play3, play4};

        Timeline timeLine = new Timeline();
        Collection<KeyFrame> frames = timeLine.getKeyFrames();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO ;

        for (Image img2 : playery) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e -> Player_IV.setImage(img2)));
        }
        timeLine.setCycleCount(1);

        timeLine.play();
    }

    void animation_Fall(ImageView Player_IV){
        Image play1 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall.jpg"));
        Image play2 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall2.jpg"));
        Image play3 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall3.jpg"));
        Image play4 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall4.jpg"));
        Image play5 = new Image(getClass().getResourceAsStream("/Image/Player_upadek/play_fall5.jpg"));

        Image[] playery_fall = {play1, play2, play3, play4, play5};

        Timeline player_fall = new Timeline();
        Collection<KeyFrame> fall_frame = player_fall.getKeyFrames();

        Duration fall_frameGap = Duration.millis(100);
        Duration fall_frameTime = Duration.ZERO ;

        for (Image img2 : playery_fall) {
            fall_frameTime = fall_frameTime.add(fall_frameGap);
            fall_frame.add(new KeyFrame(fall_frameTime, e -> Player_IV.setImage(img2)));
        }
        player_fall.setCycleCount(1);

        player_fall.play();
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
