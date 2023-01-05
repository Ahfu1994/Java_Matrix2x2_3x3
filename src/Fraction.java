import java.util.Scanner;

public class Fraction
{
    public int N,D;

    public Fraction reduce()
    {
        Fraction result = new Fraction();
        result.N = N;
        result.D = D;
        if (result.D<0)
        {
            result.N = N*(-1);
            result.D = D*(-1);
        }
        int gcd = GCD( result.N, result.D);
        result.N /= gcd;
        result.D /= gcd;
        return result;
    }
    public Fraction add(Fraction f)
    {
        Fraction result = new Fraction();
        result.N = N*f.D+D*f.N;
        result.D = D*f.D;
        if (result.D<0)
        {
            result.N = N*(-1);
            result.D = D*(-1);
        }
        int gcd = GCD(result.N, result.D);
        result.N /= gcd;
        result.D /= gcd;
        return result;
    }
    public Fraction minus(Fraction f)
    {
        Fraction result = new Fraction();
        result.N = N*f.D-D*f.N;
        result.D = D*f.D;
        if (result.D<0)
        {
            result.N = N*(-1);
            result.D = D*(-1);
        }
        int gcd = GCD(result.N, result.D);
        result.N /= gcd;
        result.D /= gcd;
        return result;
    }
    public Fraction mul(Fraction f)
    {
        Fraction result = new Fraction();
        result.N = N*f.N;
        result.D = D*f.D;
        int gcd = GCD(result.N, result.D);
        result.N /= gcd;
        result.D /= gcd;
        return result;
    }

    public Fraction div(Fraction f)
    {
        Fraction result = new Fraction();
        result.N = N*f.D;
        result.D = D*f.N;
        int gcd = GCD(result.N, result.D);
        result.N /=gcd;
        result.D /=gcd;
        return result;
    }
    public static int GCD(int a, int b)
    {
        if (a<0)
        {
            a = a*(-1);
        }
        if (b<0)
        {
            b = b*(-1);
        }
        if (a>b)
        {
        }
        else
        {
            int t = a;
            a = b;
            b = t;
        }
        while (b>0)
        {
            a = a%b;
            int t = a;
            a = b;
            b = t;
        }
        return a;
    }

    public static Fraction max(Fraction f1,Fraction f2)
    {
        Fraction max = new Fraction();
        double a, b;
        a = (double)f1.N/f1.D;
        b = (double)f2.N/f2.D;
        if (a>b)
        {
           max.N = f1.N;
           max.D = f1.D;
        }
        else
        {
            max.N = f2.N;
            max.D = f2.D;
        }
        return max;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Fraction fraction1 = new Fraction();
        fraction1.N = sc.nextInt();
        fraction1.D = sc.nextInt();

        Fraction fraction2 = new Fraction();
        fraction2.N = sc.nextInt();
        fraction2.D = sc.nextInt();

        Fraction a = new Fraction();
        a = fraction1.mul(fraction2);

        Fraction b = new Fraction();
        b = fraction1.div(fraction2);

//        Fraction c = new Fraction();
//        c= max(fraction1,fraction2);

        System.out.println(a.N+"\n"+a.D);
        System.out.println(b.N+"\n"+b.D);
//        System.out.println(c.N+"\n"+c.D);

    }
}
