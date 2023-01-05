import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Test
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] E = new double[3][3];
        for (int k = 0; k < E.length; k++) {
            for (int l = 0; l < E[0].length; l++) {
                E[k][l] = sc.nextDouble();
            }
        }

        for (int k = 0; k < E.length; k++) {
            for (int l = 0; l < E[0].length; l++) {
                System.out.print(" "+E[k][l]);
            }
            System.out.println();
        }
        double[][] M = new double[E.length-1][E[0].length-1];
        int r = sc.nextInt();
        int c = sc.nextInt();
        int mini = 0;
        int minj = 0;
        int minor_r = r-1;
        int minor_c = c-1;

        for (int row = 0; row <= 2; row++) {
                if (row != minor_r) {
                    for (int col = 0; col <= 2; col++) {
                        if (col != minor_c) {
                            M[mini][minj] = E[row][col];
                            minj++;
                        }
                        if (minj == 2) minj = 0;
                    }
                    mini++;
                }
            }
        for (int k = 0; k < M.length; k++) {
            for (int l = 0; l < M[0].length; l++) {
                System.out.print(" "+M[k][l]);
            }
            System.out.println();
        }
        double D = M[0][0]*M[1][1] - M[0][1]*M[1][0];
        System.out.println(D);
    }
}
