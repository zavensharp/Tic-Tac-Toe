package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] mas = new char[3][3];
        char[][] retmas = new char[3][5];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = ' ';
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 | j == 4)
                    retmas[i][j] = '|';
                else
                    retmas[i][j] = mas[i][j - 1];
            }
        }
        char turnmas[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                turnmas[i][j] = mas[3 - j - 1][i];
            }
        }
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(retmas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");

        boolean perem = false;
        int xo = 1;
        int win_x = 0;
        int win_o = 0;
        int countx = 0;
        int counto = 0;
        int countsp = 0;

        while (perem != true) {
            System.out.println("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            char[] coord = coordinates.toCharArray();
            int lett = 0;
            int num = 0;
            for (int i = 0; i < coord.length; i++) {
                if (coord[i] >= 33 & coord[i] <= 47 | coord[i] >= 58) {
                    lett++;
                } else if (coord[i] > 51 & coord[i] < 57) {
                    num++;
                }
            }
            if (lett > 0) {
                System.out.println("You should enter numbers!");
            }
            if (num > 0) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
            if (lett == 0 & num == 0) {
                int x = Integer.parseInt(String.valueOf(coord[0])) - 1;
                int y = Integer.parseInt(String.valueOf(coord[2])) - 1;
                if (turnmas[x][y] != 'X' & turnmas[x][y] != 'O') {
                    if (xo % 2 != 0) {
                        turnmas[x][y] = 'X';
                        xo++;
                    }
                    else if(xo % 2 == 0) {
                        turnmas[x][y] = 'O';
                        xo++;
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }

                for (int i = 0; i < 3; i++) {
                    if (turnmas[i][0] == turnmas[i][1] & turnmas[i][1] == turnmas[i][2]) {
                        if (turnmas[i][0] == 'X')
                            win_x++;
                        else if (turnmas[i][0] == 'O')
                            win_o++;
                    }
                }

                for (int j = 0; j < 3; j++) {
                    if (turnmas[0][j] == turnmas[1][j] & turnmas[0][j] == turnmas[2][j]) {
                        if (turnmas[0][j] == 'X')
                            win_x++;
                        else if (turnmas[0][j] == 'O')
                            win_o++;
                    }
                }

                if (turnmas[0][0] == turnmas[1][1] & turnmas[0][0] == turnmas[2][2]) {
                    if (turnmas[0][0] == 'X')
                        win_x++;
                    else if (turnmas[0][0] == 'O')
                        win_o++;
                }

                if (turnmas[0][2] == turnmas[1][1] & turnmas[0][2] == turnmas[2][0]) {
                    if (mas[0][2] == 'X')
                        win_x++;
                    else if (mas[0][2] == 'O')
                        win_o++;
                }

                for (int i = 0; i < turnmas.length; i++) {
                    for (int j = 0; j<turnmas.length;j++)
                        if (turnmas[i][j] == 'X')
                            countx++;
                        else if (turnmas[i][j] == 'O')
                            counto++;
                        else if (turnmas[i][j] == ' ')
                            countsp++;
                }
            }

            char[][] turnback = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    turnback[i][j] = turnmas[j][2 - i];
                }
            }

            char[][] turnbackres = new char[3][5];
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (j == 0 | j == 4)
                        turnbackres[i][j] = '|';
                    else
                        turnbackres[i][j] = turnback[i][j - 1];
                    System.out.print(turnbackres[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("---------");

            if( countsp == 0 & (countx > 0 & counto > 0)) {
                System.out.println("Draw");
                perem = true;
            }
            else if ((win_o > 0) & win_o != win_x) {
                System.out.println("O wins");
                perem = true;
            }
            else if ((win_x > 0) & win_x != win_o) {
                System.out.println("X wins");
                perem = true;
            }
        }
    }
}
