import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    public static char currentPlayer = 'X';
    public static char cpu = 'o';
    public static  Scanner input = new Scanner(System.in);

    public static int playerScore = 0, cpuScore = 0, round = 0;

    public static void main(String[] args) {


do {

    chooseXorO();
    round();
    playTheGame();
    resetScore();
}while (playAgain());




    }


    public static void playTheGame(){
        int currntRound = 1;
        while (round >= currntRound){
            System.out.println("Round: " + currntRound);
            System.out.println("Player = " + playerScore + "        " + "CPU  = " + cpuScore);
            board = new char[][] {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
            for (int i = 0; i < 5; i++)
            {
                print2DArray(board);
                board = chooseSlot(board);
                if (checkWin())
                {
                    playerScore++;
                    print2DArray(board);
                    System.out.println("\n============ You Win!! =========== ");
                    break;
                }else if (i == 4){
                    System.out.println("\n=============== Tie!! =============");
                    break;
                }
                System.out.println("\nCPU turn ");
                board = cpuTurn(board);
                if (checkLose())
                {
                    cpuScore++;
                    System.out.println("\n============ You Lose!! =========== ");

                    break;
                }

            }
            print2DArray(board);
            System.out.println("===================================");
            currntRound++;
            if (playerScore > 1){
                break;
            }else if(cpuScore > 1){
                break;
            }
        }

        System.out.println("Player = " + playerScore + "        " + "CPU  = " + cpuScore);
        if(playerScore > 1){
            System.out.println("=========== Player Win!! ============");
        } else if (cpuScore > 1) {
            System.out.println("=========== CPU Win!! ============");

        }else{
            System.out.println("=========== Tie!! ============");
        }
    }

    public static boolean playAgain(){

        while (true){
            try {
                System.out.println("Do you want to play agian? ");
                System.out.println("1. YES ");
                System.out.println("2. NO ");
                System.out.print("Enter the number: ");
                int choice = input.nextInt();

                switch (choice){
                    case 1:
                        return true;

                    case 2:
                        return false;

                    default:
                        System.out.println("Invalid number, please Enter number from the options ");

                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input, please Enter valid number");
                input.next();
            }
        }
    }
    public static void chooseXorO(){




            int num = 0;
            while (num != 1 && num != 2){
                try {
                    System.out.println("Choose the player you want : ");
                    System.out.println("1. X");
                    System.out.println("2. o");
                    System.out.print("Enter the player number: ");
                num = input.nextInt();
                switch (num){
                    case 1:
                        currentPlayer = 'X';
                        cpu = 'o';
                        break;
                    case 2:
                        currentPlayer = 'o';
                        cpu = 'X';
                        break;
                    default:
                        System.out.println("Invalid number, Please choose number from the menu");
                        break;
                }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    input.next();
                }
            }


    }

    public static void round(){
        do {

            try {

                System.out.println("1. One round");
                System.out.println("2. Three rounds");
                round = input.nextInt();
                switch (round){
                    case 1:
                        round = 1;
                        break;
                    case 2:
                        round = 3;
                        break;
                    default:
                        System.out.println("Invalid input, Please choose 1. for one round or 2. for three rounds");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input");
                input.next();
            }

        }while (round != 1 && round != 3);
    }

    public static void print2DArray(char[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" | " + array[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static char[][] chooseSlot(char[][] board) {
        int row, col;
        while (true) {
            System.out.print("\n Your turn, Please enter a number between 1 and 9: ");
            char choice = input.next().charAt(0);

            switch (choice) {
                case '1':
                    row = 0;
                    col = 0;
                    break;
                case '2':
                    row = 0;
                    col = 1;
                    break;
                case '3':
                    row = 0;
                    col = 2;
                    break;
                case '4':
                    row = 1;
                    col = 0;
                    break;
                case '5':
                    row = 1;
                    col = 1;
                    break;
                case '6':
                    row = 1;
                    col = 2;
                    break;
                case '7':
                    row = 2;
                    col = 0;
                    break;
                case '8':
                    row = 2;
                    col = 1;
                    break;
                case '9':
                    row = 2;
                    col = 2;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    continue;
            }

            if (board[row][col] != 'X' && board[row][col] != 'o') {
                board[row][col] = currentPlayer;
                return board;
            } else {
                System.out.println("Slot already chosen. Choose another.");
            }
        }
    }



    public static char[][] cpuTurn(char [][] board){
        while(true){
           int row = new Random().nextInt(2 - 0 + 1) + 0;
           int col = new Random().nextInt(2 - 0 + 1) + 0;
            if(board[row][col] != 'X' && board[row][col] != 'o' ){
                board[row][col] = cpu;
                break;
            }

        }
        return board;
    }

    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public static boolean checkLose() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == cpu && board[i][1] == cpu && board[i][2] == cpu) ||
                    (board[0][i] == cpu && board[1][i] == cpu && board[2][i] == cpu)) {

                return true;
            }
        }

        return (board[0][0] == cpu && board[1][1] == cpu && board[2][2] == cpu) ||
                (board[0][2] == cpu && board[1][1] == cpu && board[2][0] == cpu);
    }


    public static void resetScore(){
        cpuScore =0;
        playerScore = 0;
        round = 0;
    }

}