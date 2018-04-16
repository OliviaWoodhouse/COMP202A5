import java.util.Random;
public class Spell {
  //Name: Olivia Woodhouse
  //ID: 260734701
  
  private String name;
  private double minDamage;
  private double maxDamage;
  private double spellSuccessChance;
  //do i make this 0 to 1 here or in another method???
  
  //constructor
  public Spell(String n, double minD, double maxD, double sSC) {
    if (minD<0||minD>maxD) {
      throw new IllegalArgumentException("The minimum damage is not valid please try something else.");
    }
    if (sSC<0||sSC>1) {
      throw new IllegalArgumentException("The chance of success for the spell must be in the range of 0 to 1.");
    }
    this.name = n;
    this.minDamage = minD;
    this.maxDamage = maxD;
    this.spellSuccessChance = sSC;
  }
  
  //gets the name of the spell
  public String getName() {
    return this.name;
  }
  
  //generates the damage for a spell casting
  public double getDamage() {
    Random randomNumGen = new Random();
    double num1 = randomNumGen.nextDouble();
    if (num1>this.spellSuccessChance) {
      return 0;
    }
    else {
      return num1;
    }
  }
  
  //toString method
  public String toString() {
    double percentSuccess = this.spellSuccessChance*100;
    return ("Name: "+this.name+" Minimum Damage: "+this.minDamage+" Maximum Damage: "+this.maxDamage+" Chance of Success: "+percentSuccess+"%");
  }
  
}




