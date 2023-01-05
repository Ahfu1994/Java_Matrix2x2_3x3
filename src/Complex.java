import java.util.Scanner;

public class Complex
{
  double a ,b;
  public Complex add(Complex z)
  {
    Complex result = new Complex();
    result.a = a+z.a;
    result.b = b+z.b;
    return result;
  }
  public Complex minus(Complex z)
  {
    Complex result = new Complex();
    result.a = a-z.a;
    result.b = b-z.b;
    return result;
  }
  public Complex mul(Complex z)
  {
    Complex result = new Complex();
    result.a = a * z.a;
    result.b = a * z.b;
    result.b += b * z.a;
    result.a += b * z.b*(-1);
    return result;
  }
  public Complex div(Complex z)
  {

    Complex result = new Complex();
    Complex con = new Complex();
    con = z.conj();
    result.a = a*con.a;
    result.b = a*con.b;
    result.b += b*con.a;
    result.a += b*con.b*(-1);
    double denom = z.a*z.a+z.b*z.b;
    result.a /=denom;
    result.b /=denom;
    return result;

  }
  public Complex conj()
  {
    Complex c = new Complex();
    c.a = a;
    c.b = (-1)*b;
    return c;
  }
  public Complex inv()
  {
    Complex con = new Complex();
    con = conj();
    Complex invZ = new Complex();
    invZ.a = con.a;
    invZ.b = con.b;
    double denom = invZ.a*invZ.a+invZ.b*invZ.b;
    invZ.a /= denom;
    invZ.b /= denom;
    return invZ;
  }
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
    Complex y = new Complex();
    Complex z = new Complex();
    Complex w = new Complex();
    double q, r;

    x.a = sc.nextDouble();
    x.b = sc.nextDouble();

    q = x.size();
    r = x.angle();

    System.out.println(q);
    System.out.println(r);
  }

}
