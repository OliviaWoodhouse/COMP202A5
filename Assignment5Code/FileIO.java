import java.util.ArrayList;
import java.io.*;
public class FileIO {
  //Name: Olivia Woodhouse
  //ID: 260734701
  
  //reads a files and returns a new character
  public static Character readCharacter(String fileName) {
    try {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      String n = br.readLine();
      String aV1 = br.readLine();
      double aV = Double.parseDouble(aV1);
      String mHV1 = br.readLine();
      double mHV = Double.parseDouble(mHV1);
      String nW1 = br.readLine();
      int nW = Integer.parseInt(nW1);
      Character c = new Character(n,aV,mHV,nW);
      br.close();
      fr.close();
      return c;
    }catch(FileNotFoundException e) {
      throw new IllegalArgumentException("That file was not found.");
    }catch(IOException e) {
      throw new IllegalArgumentException("There was an IO exception.");
    }
  }
  
  //takes a filename of spells to read and returns an ArrayList of Spells
  public static ArrayList<Spell> readSpells(String fileNameSpells) {
    try {
      FileReader fr = new FileReader(fileNameSpells);
      BufferedReader br = new BufferedReader(fr);
      String fullLine = br.readLine();
      String[] fullLineSplit = fullLine.split(" ");
      String n = fullLineSplit[0];
      String minD1 = fullLineSplit[1];
      double minD = Double.parseDouble(minD1);
      String maxD1 = fullLineSplit[2];
      double maxD = Double.parseDouble(maxD1);
      String sSC1 = fullLineSplit[3];
      double sSC = Double.parseDouble(sSC1);
      Spell s = new Spell(n,minD,maxD,sSC);
      br.close();
      fr.close();
      ArrayList<Spell> spellsAvailable = new ArrayList<Spell>();
      spellsAvailable.add(s);
      return spellsAvailable;
    }catch(FileNotFoundException e) {
      throw new IllegalArgumentException("That file was not found.");
    }catch(IOException e) {
      throw new IllegalArgumentException("There was an IO exception.");
    }
  }
  
  //writes a character to a file
  public static void writeCharacter(Character player, String filename) {
    try {
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(player.getName()+"\n");
      bw.write(player.getAttackValue()+"\n");
      bw.write(player.getMaxHealthValue()+"\n");
      bw.write(player.getNumWins()+"\n");
      bw.close();
      fw.close();
    }catch(IOException e) {
      throw new IllegalArgumentException("There was an IO exception.");
    }
  }
  
}


