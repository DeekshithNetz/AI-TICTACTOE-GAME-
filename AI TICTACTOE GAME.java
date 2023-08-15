//import java.util.*;
import java.io.*;
import java.util.Random;
//import java.lang.NullPointerException;
class user {
  public static int row = 4, col = 4, count = 0, B1 = 0, B2 = 0, B3 = 0, s = 0, init = 0;
  public static String block[][] = new String[row][col];
  public static void main(String args[]) throws IOException {
    user m = new user();
    m.Huser();
  }
  void Huser() throws IOException {
    DataInputStream key = new DataInputStream(System.in);
    user m = new user();
    try {
      System.out.println("enter the row number");
      row = Integer.parseInt(key.readLine());
      System.out.println("enter the column ");
      col = Integer.parseInt(key.readLine());
      if (block[row][col] == null) {
        block[row][col] = "X";
        count += 1;
      } else {
        System.out.println("The desired block is full");
        Huser();
      }

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("error 1 chance lost ");

    }

    Dis h = new Dis();
    h.play();
    if (count >= 5) {
      int x = wincheck();
      if (x == 1) {
        System.out.println("you won");
        System.out.println("press 'c' to continue or 'e' to exit");
        String in = key.readLine();
        if (in.equals("C") || in.equals("c")) {
          count = 0;
          newgame();
        } else {
          System.exit(0);
        }
      }
    }

    if (count == 9) {
      System.out.println("draw");
      System.out.println("press 'c' to continue or 'e' to exit");
      String in = key.readLine();
      if (in.equals("C") || in.equals("c")) {
        newgame();
      } else {
        System.exit(0);
      }

    }
    computer();

  }
  void computer() throws IOException {
    DataInputStream key = new DataInputStream(System.in);
    try {
      Thread.sleep(1000);
      System.out.println("Thinking....");
      Thread.sleep(4000);
    } catch (InterruptedException o) {

    }
    Random rd = new Random();
    outer: while (true) {

      row = rd.nextInt(3) + 1;
      col = rd.nextInt(3) + 1;
      System.out.println("row" + row + "col" + col);
      // AI SYSTEM BLOCK 0
      if (block[2][2] == null && s < 1) {
        block[2][2] = "O";
        count += 1;
        s += 1;
        break;
      }
      //new AI BLOCK V1 BLOCK 1
      //null exception removed
      // AI SYSTEM BLOCK 0
      if (block[2][2] == null && s < 1) {
        block[2][2] = "O";
        count += 1;
        s += 1;
        break;
      }

      // new AI BLOCK V1 BLOCK 1
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j <= 0; j++) {
          if (((block[i + 1][j + 1] != null && block[i + 1][j + 2] != null) &&
              ((block[i + 1][j + 1].equals("X") && block[i + 1][j + 2].equals("X")) ||
                (block[i + 1][j + 1].equals("O") && block[i + 1][j + 2].equals("O")))) ||
            ((block[i + 1][j + 2] != null && block[i + 1][j + 3] != null) &&
              ((block[i + 1][j + 2].equals("X") && block[i + 1][j + 3].equals("X")) ||
                (block[i + 1][j + 2].equals("O") && block[i + 1][j + 3].equals("O")))) ||
            ((block[i + 1][j + 1] != null && block[i + 1][j + 3] != null) &&
              ((block[i + 1][j + 1].equals("X") && block[i + 1][j + 3].equals("X")) ||
                (block[i + 1][j + 1].equals("O") && block[i + 1][j + 3].equals("O"))))) {

            if (block[i + 1][j + 1] == null) {
              block[i + 1][j + 1] = "O";
              count += 1;
              break outer;
            }
            if (block[i + 1][j + 2] == null) {
              block[i + 1][j + 2] = "O";
              count += 1;
              break outer;
            }
            if (block[i + 1][j + 3] == null) {
              block[i + 1][j + 3] = "O";
              count += 1;
              break outer;
            }
          }
        }
      }

      //2nd block AI
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j <= 0; j++) {
          if (((block[j + 1][i + 1] != null && block[j + 2][i + 1] != null) &&
              ((block[j + 1][i + 1].equals("X") && block[j + 2][i + 1].equals("X")) ||
                (block[j + 1][i + 1].equals("O") && block[j + 2][i + 1].equals("O")))) ||
            ((block[j + 2][i + 1] != null && block[j + 3][i + 1] != null) &&
              ((block[j + 2][i + 1].equals("X") && block[j + 3][i + 1].equals("X")) ||
                (block[j + 2][i + 1].equals("O") && block[j + 3][i + 1].equals("O")))) ||
            ((block[j + 1][i + 1] != null && block[j + 3][i + 1] != null) &&
              ((block[j + 1][i + 1].equals("X") && block[j + 3][i + 1].equals("X")) ||
                (block[j + 1][i + 1].equals("O") && block[j + 3][i + 1].equals("O"))))) {

            if (block[j + 1][i + 1] == null) {
              block[j + 1][i + 1] = "O";
              count += 1;
              break outer;
            }
            if (block[j + 2][i + 1] == null) {
              block[j + 2][i + 1] = "O";
              count += 1;
              break outer;
            }
            if (block[j + 3][i + 1] == null) {
              block[j + 3][i + 1] = "O";
              count += 1;
              break outer;
            }
          }
        }
      }

      //AI BLOCK 3 
      for (int i = 0; i <= 0; i++) {
        for (int j = 0; j <= 0; j++) {
          if (((block[i + 1][j + 1] != null && block[i + 2][j + 2] != null) &&
              ((block[i + 1][j + 1].equals("X") && block[i + 2][j + 2].equals("X")) ||
                (block[i + 1][j + 1].equals("O") && block[i + 2][j + 2].equals("O")))) ||
            ((block[i + 2][j + 2] != null && block[i + 3][j + 3] != null) &&
              ((block[i + 2][j + 2].equals("X") && block[i + 3][j + 3].equals("X")) ||
                (block[i + 2][j + 2].equals("O") && block[i + 3][j + 3].equals("O")))) ||
            ((block[i + 1][j + 1] != null && block[i + 3][j + 3] != null) &&
              ((block[i + 1][j + 1].equals("X") && block[i + 3][j + 3].equals("X")) ||
                (block[i + 1][j + 1].equals("O") && block[i + 3][j + 3].equals("O"))))) {

            if (block[i + 1][j + 1] == null) {
              block[i + 1][j + 1] = "O";
              count += 1;
              break outer;
            }
            if (block[i + 2][j + 2] == null) {
              block[i + 2][j + 2] = "O";
              count += 1;
              break outer;
            }
            if (block[i + 3][j + 3] == null) {
              block[i + 3][j + 3] = "O";
              count += 1;
              break outer;
            }
          }
        }
      }

      //AI BLOCK 4
      for (int i = 0; i <= 0; i++) {
        for (int j = 0; j <= 0; j++) {
          if (((block[i + 1][j + 3] != null && block[i + 2][j + 2] != null) &&
              ((block[i + 1][j + 3].equals("X") || block[i + 1][j + 3].equals("O")) &&
                block[i + 2][j + 2].equals("X"))) ||
            ((block[i + 2][j + 2] != null && block[i + 3][j + 1] != null) &&
              ((block[i + 2][j + 2].equals("X") || block[i + 2][j + 2].equals("O")) &&
                block[i + 3][j + 1].equals("X"))) ||
            ((block[i + 1][j + 3] != null && block[i + 3][j + 1] != null) &&
              ((block[i + 1][j + 3].equals("X") || block[i + 1][j + 3].equals("O")) &&
                block[i + 3][j + 1].equals("X")))) {

            if (block[i + 1][j + 3] == null) {
              block[i + 1][j + 3] = "O";
              count += 1;
              break outer;
            }
            if (block[i + 2][j + 2] == null) {
              block[i + 2][j + 2] = "O";
              count += 1;
              break outer;
            }
            if (block[i + 3][j + 1] == null) {
              block[i + 3][j + 1] = "O";
              count += 1;
              break outer;
            }
          }
        }
      }

      //NORMAL INITIALISATION 
      if (block[row][col] == null) {
        block[row][col] = "O";
        count += 1;
        break;
      }

    }
    Dis hi = new Dis();
    hi.play();
    if (count >= 5) {
      int x = wincheck();
      if (x == 1) {
        System.out.println("AI won");
        System.out.println("press 'c' to continue or 'e' to exit");
        String in = key.readLine();
        if (in.equals("C") || in.equals("c")) {
          count = 0;
          newgame();
        } else {
          System.exit(0);
        }
      }

    }

    System.out.print("\nyour turn\n");
    user m = new user();
    m.Huser();

  }

  int wincheck() throws IOException {
    DataInputStream obj = new DataInputStream(System.in);
    // 1st check
    if (block[1][1] != null && block[1][1].equals(block[1][1 + 1])) {
      if (block[1][1].equals(block[1][1 + 2])) {
        return 1;
      }
    }
    // 2nd check
    if (block[1][1] != null && block[1][1].equals(block[1 + 1][1 + 1])) {
      if (block[1][1].equals(block[1 + 2][1 + 2])) {
        return 1;

      }
    }
    // 3rd check
    if (block[1][1] != null && block[1][1].equals(block[1 + 1][1])) {
      if (block[1][1].equals(block[1 + 2][1])) {
        return 1;

      }
    }
    // 4th check
    if (block[1][1 + 1] != null && block[1][1 + 1].equals(block[1 + 1][1 + 1])) {
      if (block[1][1 + 1].equals(block[1 + 2][1 + 1])) {
        return 1;

      }
    }
    // 5th check
    if (block[1][1 + 2] != null && block[1][1 + 2].equals(block[1 + 1][1 + 1])) {
      if (block[1][1 + 2].equals(block[1 + 2][1])) {
        return 1;

      }
    }
    // 6th check
    if (block[1 + 1][1] != null && block[1 + 1][1].equals(block[1 + 1][1 + 1])) {
      if (block[1 + 1][1].equals(block[1 + 1][1 + 2])) {
        return 1;

      }
    }
    // 7th check
    if (block[1][1 + 2] != null && block[1][1 + 2].equals(block[1 + 1][1 + 2])) {
      if (block[1][1 + 2].equals(block[1 + 2][1 + 2])) {
        return 1;

      }
    }
    // 8th check
    if (block[1 + 2][1] != null && block[1 + 2][1].equals(block[1 + 2][1 + 1])) {
      if (block[1 + 2][1].equals(block[1 + 2][1 + 2])) {
        return 1;

      }
    }
    return 0;
  }
  //new game initialisation and process
  void newgame() throws IOException {
    //reset
    int i, j;
    for (i = 1; i <= 3; i++) {
      for (j = 1; j <= 3; j++) {
        if (block[i][j] != null)
          block[i][j] = null;

      }
    }

    //call again
    Huser();
  }

}
class Dis extends user {
  void play() {

    int i, j;
    for (i = 1; i <= 3; i++) {
      for (j = 1; j <= 3; j++) {
        if (block[i][j] == null) {
          System.out.print("_|");
          continue;
        } else {
          System.out.print(block[i][j] + "|");
        }
      }
      System.out.print("\n");
    }

  }
}