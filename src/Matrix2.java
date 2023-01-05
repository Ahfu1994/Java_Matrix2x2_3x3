import java.util.Scanner;

public class Matrix2
{
    double E11, E12, E21, E22;
    public Matrix2 add(Matrix2 E)
    {
        Matrix2 result = new Matrix2();
        result.E11 = E11+E.E11;
        result.E12 = E12+E.E12;
        result.E21 = E21+E.E21;
        result.E22 = E22+E.E22;
        return result;
    }
    public Matrix2 minus(Matrix2 E)
    {
        Matrix2 result = new Matrix2();
        result.E11 = E11-E.E11;
        result.E12 = E12-E.E12;
        result.E21 = E21-E.E21;
        result.E22 = E22-E.E22;
        return result;
    }
    public Matrix2 mul(Matrix2 E)
    {
        Matrix2 result = new Matrix2();
        result.E11 = E11*E.E11 + E12*E.E21;
        result.E12 = E11*E.E12 + E12*E.E22;
        result.E21 = E21*E.E11 + E22*E.E21;
        result.E22 = E21*E.E12 + E22*E.E22;
        return result;
    }
    public double det()
    {
        double result = E11*E22 - E12*E21;
        return result;
    }
    public double minor(int i, int j)
    {
        double m = 0 ;
        if (i==1 && j == 1) m = E22;
        if (i==1 && j == 2) m = E21;
        if (i==2 && j == 1) m = E12;
        if (i==2 && j == 2) m = E11;
        return m;
    }
    public double cof(int i, int j)
    {
        //formula cofactor(i,j)  =  (-1)^(i+j)*M(I,j)
        double c = Math.pow(-1,i+j)*minor(i,j);
        return c;
    }
    public Matrix2 adj()
    {

//        Adjoint =  | Cof11  Cof12 |
//                   | Cof21  Cof22 |
        Matrix2 result = new Matrix2();
        result.E11 = cof(1,1);
        result.E12 = cof(2,1);
        result.E21 = cof(1,2);
        result.E22 = cof(2,2);
        return result;
    }
    public  Matrix2 inverse()
    {
        Matrix2 result = new Matrix2();
        double d = det();
        result = adj();
        result.E11 /= d;
        result.E12 /= d;
        result.E21 /= d;
        result.E22 /= d;
        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Matrix2 x = new Matrix2();
        x.E11 = sc.nextDouble();
        x.E12 = sc.nextDouble();
        x.E21 = sc.nextDouble();
        x.E22 = sc.nextDouble();

//        Matrix2 y = new Matrix2();
//        y.E11 = sc.nextDouble();
//        y.E12 = sc.nextDouble();
//        y.E21 = sc.nextDouble();
//        y.E22 = sc.nextDouble();

//        Matrix2 z = x.add(y);
//        Matrix2 q = x.minus(y);
        Matrix2 w = x.inverse();
//        double u = x.det();
//        int i = sc.nextInt();
//        int j = sc.nextInt();
//        double g = x.cof(i,j);

//        System.out.println(z.E11+"\n"+z.E12+"\n"+z.E21+"\n"+z.E22);
        System.out.println(w.E11+"\n"+w.E12+"\n"+w.E21+"\n"+w.E22);
//        System.out.println(u);
//        System.out.println("Cofactor"+i+j+" : "+g);
    }

}
