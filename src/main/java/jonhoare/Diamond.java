package jonhoare;

import java.util.Arrays;
import java.util.List;

public class Diamond {

  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        throw new BadInput();
      }
      Diamond diamond = new Diamond(args[0]);
      System.out.println(diamond);
    } catch (RuntimeException e) {
      System.err.println(e.getLocalizedMessage());
      System.exit(1);
    }
  }

  private static final String SPACE = " ";
  private final List<String> diamond;

  public Diamond(String character) {
    if (character == null || !character.matches("^[A-Z]$")) {
      throw new BadInput();
    }
    int middleCharIndex = character.charAt(0) - 'A'; // A=0, B=1 etc.
    int diamondSize = middleCharIndex * 2 + 1;
    String[] diamondArray = new String[diamondSize];
    for (int i = 0; i <= middleCharIndex; i++) {
      String line = getDiamondLine(i, middleCharIndex);
      diamondArray[i] = line;
      if (i < middleCharIndex) {
        diamondArray[diamondSize - 1 - i] = line;
      }
    }
    this.diamond = Arrays.asList(diamondArray);
  }

  private static String getDiamondLine(int i, int n) {
    // 'A' is a special case since it only appears once on the line
    if (i == 0) {
      String spaces = SPACE.repeat(n);
      return spaces + "A" + spaces;
    }
    // All other chars appear twice
    String spacesAtEnds = SPACE.repeat(n - i);
    String spacesInMiddle = SPACE.repeat(2 * i - 1);
    String character = String.valueOf((char) ('A' + i));
    return spacesAtEnds + character + spacesInMiddle + character + spacesAtEnds;
  }

  @Override
  public String toString() {
    return String.join("\n", diamond);
  }
}
