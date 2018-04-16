import java.util.Random;
import java.util.ArrayList;
public class Character {
  //Name: Olivia Woodhouse
  //ID: 260734701
  
  private String name;
  private double attackValue;
  private final double maxHealthValue;
  private double currentHealthValue;
  private int numWins;
  private static ArrayList<Spell> spellsAvailable;
  
  //constructor
  public Character(String n, double aV, double mHV, int nW) {
    this.name = n;
    this.attackValue = aV;
    this.maxHealthValue = mHV;
    this.currentHealthValue = mHV;
    this.numWins = nW;
  }
  
  //toString method
  public String toString() {
    return "Name: "+this.name+" Current Health: "+this.currentHealthValue;
  }
  
  //calculates how much attack damage one character does in a battle
  public double calcAttack() {
    Random randomValue = new Random();
    double x = randomValue.nextDouble()*0.3 + (0.7-0.3);
    double attackDamage = this.attackValue*x;
    return attackDamage;
  }
  
  //updates character's current health
  public void takeDamage(double damage) {
    this.currentHealthValue = this.maxHealthValue-damage;
  }
  
  //increases the number of wins of the character by one
  public void increaseWins() {
    this.numWins++;
  }
  
  //prints character instances
  public void printCharacter() {
    System.out.println(this.toString());
    System.out.println("Attack: "+this.attackValue);
    System.out.println("Number of Wins: "+this.numWins);
  }
  
  //gets current health value
  public double getCurrentHealthValue() {
    return this.currentHealthValue;
  }
  
  //gets name
  public String getName() {
    return this.name;
  }
  
  //gets attack value
  public double getAttackValue() {
    return this.attackValue;
  }
  
  //gets max health value
  public double getMaxHealthValue() {
    return this.maxHealthValue;
  }
  
  //gets number of wins so far in the battle game
  public int getNumWins() {
    return this.numWins;
  }
  
  //setter method of the spells attribute
  public void setSpells(Spell s) {
    ArrayList<Spell> spellsAvailable = new ArrayList<Spell>();
    spellsAvailable.add(s);
    //did i do this right sos???
  }
  
  //calculates damage of the spell a character wants to cast
  public double castSpell(String spellName) {
    double answer = 0;
    for (int i=0;i<spellsAvailable.size();i++) {
      Spell s = spellsAvailable.get(i);
      if (spellName.equalsIgnoreCase(s.getName())) {
        double damage = s.getDamage();
        if (damage==0) {
          System.out.println(this.name+" tried to cast "+s.getName()+", but they don't know that spell.");
          return damage;
        }
        else {
          System.out.println(this.name+" casted "+s.getName()+" for damage of "+damage+".");
          return damage;
        }
      }
    }
    System.out.println(this.name+" tried to cast "+spellName+" but they don't know that spell.");
    return 0;
  }
  
}




