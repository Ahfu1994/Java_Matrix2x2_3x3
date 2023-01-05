import java.util.Scanner;

public class MulDiv
{
    double a, b;
    public double size()
    {
        double s = Math.sqrt(a*a + b*b);
        return s;
    }
    public double angle()
    {
        double re = Math.atan(b/a);
        return re;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Complex x = new Complex();
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();

        double y = x.size();
        double q = x.angle();

        System.out.println(y);
        System.out.println(q);





    }
}
