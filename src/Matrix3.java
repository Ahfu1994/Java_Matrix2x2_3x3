import java.util.Arrays;
import java.util.Scanner;

public class Matrix3
{
    public double[][] E = new double[3][3];
    public Matrix3 add(Matrix3 Q)
    {
        Matrix3 result = new Matrix3();
        for (int i = 0; i <E.length ; i++)
        {
            for (int j = 0; j <E[0].length ; j++)
            {
                result.E[i][j] =E[i][j]+Q.E[i][j];
            }
        }
        return result;
    }
    public Matrix3 minus(Matrix3 Q)
    {
        Matrix3 result = new Matrix3();
        for (int i = 0; i <E.length ; i++)
        {
            for (int j = 0; j <E[0].length ; j++)
            {
                result.E[i][j] =E[i][j]-Q.E[i][j];
            }
        }
        return result;
    }
    public Matrix3 mul(Matrix3 Q)
    {

        Matrix3 result = new Matrix3();
        for (int i = 0; i <E.length ; i++)
        {
            for (int j = 0; j <E[0].length ; j++)
            {
                double temp = 0;
                for (int k = 0; k <E.length ; k++)
                {
                    temp =temp+ E[i][k] * Q.E[k][j];
                }
                result.E[i][j] = temp;
            }
        }
        return result;
    }
    public double det()
    {
        double  x, y, z, result = 0;
        x = (E[1][1] * E[2][2]) - (E[2][1] * E[1][2]);
        y = (E[1][0] * E[2][2]) - (E[2][0] * E[1][2]);
        z = (E[1][0] * E[2][1]) - (E[2][0] * E[1][1]);
        return  result = (E[0][0] * x)- (E[0][1] * y) + (E[0][2] * z);
    }
    public double minor(int i, int j)
    {
        double[][] M = new double[E.length-1][E[0].length-1];
        int mini = 0;
        int minj = 0;
        int minor_r = i-1;
        int minor_c = j-1;
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
        double m = M[0][0]*M[1][1] - M[0][1]*M[1][0];
        return m;
    }
    public double cof(int i, int j)
    {
        double c = Math.pow(-1,i+j)*minor(i,j);
        return c;
    }
    public Matrix3 adj()
    {
        Matrix3 Adj = new Matrix3();
        int i,j;
        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 3; ++j)
            {
                Adj.E[i][j] = Double.parseDouble(((E[(j + 1) % 3][(i + 1) % 3] * E[(j + 2) % 3][(i + 2) % 3])
                        - (E[(j + 1) % 3][(i + 2) % 3] * E[(j + 2) % 3][(i + 1) % 3])  + " "));
            }
        }
        return Adj;
    }
    public Matrix3 inverse()
    {
        double D = det();
        Matrix3 inv = adj();
        for (int i = 0; i < E.length; i++)
        {
            for (int j = 0; j < E[0].length; j++)
            {
                inv.E[i][j] /=D ;
            }
        }
        return inv;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Input Matrix A");
        Matrix3 A = new Matrix3();
        for (int i = 0; i <A.E.length ; i++)
        {
            for (int j = 0; j <A.E[0].length ; j++)
            {
                A.E[i][j] = sc.nextDouble();
            }
        }
//        System.out.println("Print Matrix A");
//        for (int i = 0; i <A.E.length ; i++)
//        {
//            for (int j = 0; j <A.E[0].length ; j++)
//            {
//                System.out.print(" "+A.E[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("Input Matrix B");
//        Matrix3 B = new Matrix3();
//        for (int i = 0; i <B.E.length ; i++)
//        {
//            for (int j = 0; j <B.E[0].length ; j++)
//            {
//                B.E[i][j] = sc.nextDouble();
//            }
//        }
//        System.out.println("Print Matrix B");
//        for (int i = 0; i <B.E.length ; i++)
//        {
//            for (int j = 0; j <B.E[0].length ; j++)
//            {
//                System.out.print(" "+B.E[i][j]);
//            }
//            System.out.println();
//        }

//        System.out.println("Print Matrix A mul Matrix B ");
        Matrix3 C = A.inverse();
        for (int i = 0; i <C.E.length ; i++)
        {
            for (int j = 0; j <C.E[0].length ; j++)
            {
                System.out.println(C.E[i][j]);
            }
        }

    }
}

