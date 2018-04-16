import java.util.Scanner;
import java.util.ArrayList;
public class BattleGame {
  //Name: Olivia Woodhouse
  //ID: 260734701
  
  //plays the battle game
  public static void playGame(String fileName1, String fileName2, String fileNameSpells) {
    Character player = FileIO.readCharacter(fileName1);
    player.printCharacter();
    Character monster = FileIO.readCharacter(fileName2);
    monster.printCharacter();
    ArrayList<Spell> spellList = FileIO.readSpells(fileNameSpells);
    for (int i=0;i<spellList.size();i++) {
      Spell s = spellList.get(i);
      System.out.println(s.toString());
      player.setSpells(s);
    }
    Scanner input = new Scanner(System.in);
    while(player.getCurrentHealthValue()>0&&monster.getCurrentHealthValue()>0) {
      System.out.println("Enter a command (attack or quit):");
      String command = input.nextLine();
      if (command.equalsIgnoreCase("attack")) {
        doAttack(player,monster);
        doAttack(monster,player);
        continue;
      }
      else if (command.equalsIgnoreCase("quit")) {
        System.out.println("Thank you for playing! Goodbye.");
        return;
      }
      else {
        player.castSpell(command);
        double damage = player.castSpell(command);
        player.takeDamage(damage);
      }
    }
    if (player.getCurrentHealthValue()<=0) {
      System.out.println("You have lost the game.");
      monster.increaseWins();
    }
    else if (monster.getCurrentHealthValue()<=0) {
      System.out.println("Congratulations!"+player.getName()+" has won the game.");
      player.increaseWins();
    }
    System.out.println(player.getName()+" has won: "+player.getNumWins()+" times");
    System.out.println(monster.getName()+" has won: "+monster.getNumWins()+" times");
    FileIO.writeCharacter(player, "player.txt");
    FileIO.writeCharacter(monster, "monster.txt");
    input.close();
  }
  
  //implements each attack
  public static void doAttack(Character char1,Character char2) {
    double damageDone = char1.calcAttack();
    System.out.println(char1.getName()+" attacks for "+damageDone+" damage!"); 
    char2.takeDamage(damageDone);
    if (char2.getCurrentHealthValue()>0) {
      System.out.println("Name: "+char2.getName()+" Health: "+char2.getCurrentHealthValue());
    }
    else {
      System.out.println(char2.getName()+" was knocked out.");
    }
  }
  
}



