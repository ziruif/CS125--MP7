/**
 * game 2048
 * created by Zirui Fan and Ningyi Zhang
 * 2017/12/12
 */
package mp7;
import java.util.Random;

public class Game2048 {
    static int score = 0;
  
   /**
    * move to the left
    * @param puzzle the game matrix
    * @return the game after moving
    */  
    static void moveLeft(int[][] puzzle) {	  
    	int[][] result = new int [4][4];
          int coll = 0;
          for (int i = 0; i < 4; i++) {
            int k = 0;
            for (int j = 0; j < 4; j++) {
              if (puzzle[i][j] != 0) {
                result[i][k] = puzzle[i][j];
                k++;
              }
            }
            for (; k < 4; k++)
              result[i][k] = 0;
          }
          for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
              puzzle[i][j] = result[i][j];
            }
          }
          boolean check = false;
          for (int i = 0; i < 4; i++) {      //第i行    所有行
            for (int j = 0; j < 3; j++) {    //第j列   前三列
              if (puzzle[i][j] == puzzle[i][j + 1] && puzzle[i][j] != 0) {
                coll = j + 1;
                check = true;      //检查到有重复的列
                puzzle[i][j] *= 2;
                break;
              }
            }
            if (check) {
              for (; coll < 3; coll++) {
            	  puzzle[i][coll] = puzzle[i][coll + 1];
              } 
              puzzle[i][coll] = 0;
            }
            check = false;
          }
    }
    
    /**
     * move to the right
     * @param puzzle the game matrix
     * @return the game after moving
     */
    static void moveRight(int[][] puzzle) {
      int[][] result = new int [4][4];
      int coll = 0;
      for (int i = 0; i < 4; i++) {
        int k = 3;
        for (int j = 3; j >= 0; j--) {
          if (puzzle[i][j] != 0){
            result[i][k] = puzzle[i][j];
            k--;
          }
        }
        for (; k >= 0; k--)
          result[i][k] = 0;
      }
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++){
          puzzle[i][j] = result[i][j];
        }
      }
      boolean check = false;
      for (int i = 0; i < 4; i++) {
        for (int j = 3; j >= 1; j--) {
          if (puzzle[i][j] == puzzle[i][j - 1] && puzzle[i][j] != 0) {
            coll = j - 1;
            check = true;
            puzzle[i][j] *= 2;
            break;
          }
        }
        if (check) {
         for (; coll >= 1; coll--) {
        	 puzzle[i][coll] = puzzle[i][coll - 1];
         }
         puzzle[i][coll] = 0;
        }
        check = false;
      }
      
    }
    
    /**
     * move up
     * @param puzzle the game matrix
     * @return the game after moving
     */
    static void moveUp(int[][] puzzle) {
      int[][] result = new int [4][4];
      int roww = 0;
      for (int j = 0; j < 4; j++) {   //col
        int k = 0;
        for (int i = 0; i < 4; i++) {   //row
          if (puzzle[i][j] != 0){
            result[k][j] = puzzle[i][j];
            k++;
          }
        }
        for (; k < 4; k++)
          result[k][j] = 0;
      }
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++){
          puzzle[i][j] = result[i][j];
        }
      }
      boolean check = false;
      for (int i = 0; i < 4; i++) {     //col
        for (int j = 0; j < 3; j++) {    //row
          if (puzzle[j][i] == puzzle[j + 1][i] && puzzle[j][i] != 0) {
            roww = i + 1;
            check = true;
            puzzle[j][i] *= 2;
            break;
          }
        }
        if (check) {
          for (; roww < 3; roww++) {
        	  puzzle[roww][i] = puzzle[roww + 1][i];
          }
          puzzle[roww][i] = 0;
        }
        check = false;
      }
    }
    
    /**
     * move down
     * @param puzzle the game matrix
     * @return the game after moving
     */
    static void moveDown(int[][] puzzle) {
      int[][] result = new int [4][4];
      int roww = 0;
      for (int j = 0; j < 4; j++) {   //col
        int k = 3;
        for (int i = 3; i >= 0; i--) {   //row
          if (puzzle[i][j] != 0){
            result[k][j] = puzzle[i][j];
            k--;
          }
        }
        for (; k >= 0; k--)
          result[k][j] = 0;
      }
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++){
          puzzle[i][j] = result[i][j];
        }
      }
      boolean check = false;
      for (int i = 0; i < 4; i++) {     //col
        for (int j = 3; j >= 1; j--) {    //row
          if (puzzle[j][i] == puzzle[j - 1][i] && puzzle[j][i] != 0) {
            roww = j - 1;
            check = true;
            puzzle[j][i] *= 2;
            break;
          }
        }
        if (check) {
          for (; roww >= 1; roww--) {
        	  puzzle[roww][i] = puzzle[roww - 1][i];
          }
          puzzle[roww][i] = 0;
        }
        check = false;
      }
    }
    
  /**
   * generate a random number from 0 to 3 
   * @return the random number
   */
  static int generateRandint() { 
	Random rand2 = new Random();
	int  n03= rand2.nextInt(4);
	return n03;
  }
  
  /**
   * generate a random 2 after each move
   * @param arr the game
   */
  static void generateRand(int[][] arr) { 
	//initialize the game with random 2 and 4
    int ran1 = generateRandint();
	int ran2 = generateRandint();
	while (arr[ran1][ran2] != 0) {
	  ran1 = generateRandint();
	  ran2 = generateRandint();
	}
	arr[ran1][ran2] = 2;	
	score++;//every time when successfully generate a random 2, score++.
  }
  
  /**
   * show the game
   * @param arr the game
   */
  static void showGame(int[][] arr) {
    for(int i = 0; i < 4; i++) {
  	  for (int j = 0; j < 4; j++) {
  	    int temp = arr[i][j] / 10;
  	    if (temp == 0) {                             //一位
  	      System.out.print(arr[i][j] + "      ");
  	    } else if (temp < 10 && temp > 0) {          //两位
  	      System.out.print(arr[i][j] + "     ");
  	    } else if (temp < 100 && temp > 10) {        //三位
    	  System.out.print(arr[i][j] + "    ");
  	    } else {                                     //四位
  	      System.out.print(arr[i][j] + "   ");
  	    }
  	  }
  	  System.out.println();
  	  System.out.println();
  	  System.out.println();
    }	  
  }
  /**
   * check if the game is over.
   * @param arr current game.
   * @return true if game over.
   */
  static boolean gameOver(int[][] arr) {  
	//no zero in the game
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (arr[i][j] == 0) {
				return false;
			}
		}
	}  
	//no adjacent duplicate entries 
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 4; j++) {
			if (arr[i][j] == arr[i + 1][j]) {
				return false;
			}
		}
	}
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			if (arr[i][j] == arr[i][j + 1]) {
				return false;
			}
		}
	}
	return true;  
  }
  
  /**
   * check if the game is end with 2048
   * @param arr the current game 
   * @return true if the game is end
   */
  static boolean isEnd(int[][] arr) {
	  for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 2048) {
					return true;
				}
			}
		}
	  return false;
  }
   
  /**
   *  show the current score and game
   * @param arr the game
   */
  static void showScore(int[][] arr) {
	  if (!gameOver(arr) && !isEnd(arr)) {
		  System.out.println("score: " + score);
		  showGame(arr);
	  } else if (gameOver(arr)) {
		  System.out.println("Game over!");
		  showGame(arr);
	  } else {
		  System.out.println("Congraduations!");
		  showGame(arr);
	  }
  }
  
  /**
   * move right with random 2 generated
   * @param arr the game
   */
  static void right(int[][] arr) {
	  moveRight(arr);
	  generateRand(arr);
	  System.out.println("move right:");
	  showScore(arr);
	  System.out.println("---");
  }
  
  /**
   * move left with random 2 generated
   * @param arr the game
   */
  static void left(int[][] arr) {
	  moveLeft(arr);
	  generateRand(arr);
	  System.out.println("move left:");
	  showScore(arr);
	  System.out.println("---");
  }
  
  /**
   * move up with random 2 generated
   * @param arr the game
   */
  static void up(int[][] arr) {
	  moveUp(arr);
	  generateRand(arr);
	  System.out.println("move up:");
	  showScore(arr);
	  System.out.println("---");
  }
  
  /**
   * move down with random 2 generated
   * @param arr the game
   */
  static void down(int[][] arr) {
	  moveDown(arr);
	  generateRand(arr);
	  System.out.println("move down:");
	  showScore(arr);
	  System.out.println("---");
  }
  
  //==============================================================================
  public static void main(String[] args) {
	//0 left    1 up    2 right    3 down
	int[][] arr = {{0, 0, 0, 0}, {2, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 4, 0}};
    showGame(arr);
    System.out.println("****************************");
    right(arr);
    down(arr);
	down(arr);
	right(arr);
	down(arr);
	left(arr);
	up(arr);
	right(arr);
	down(arr);
	right(arr);
	right(arr);
	System.out.println("============================");
	
	//case of game over 
	System.out.println("Case of game over:");
	int[][] arr1 = {{2, 4, 4, 16}, {4, 2, 64, 8}, {32, 128, 2, 32}, {256, 2, 4, 16}};
	showGame(arr1);
	System.out.println("---");
	right(arr1);
	right(arr1);
	System.out.println("===========================");
	
	//2048
	System.out.println("Case of win:");
	int[][] arr2 = {{2, 1024, 1024, 16}, {4, 2, 64, 8}, {32, 128, 2, 32}, {256, 2, 4, 16}};
	showGame(arr2);
	right(arr2);
  }
}



































