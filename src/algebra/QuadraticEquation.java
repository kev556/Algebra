package algebra;

public class QuadraticEquation
{
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public QuadraticEquation(QuadraticEquation other)
    {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }
    public QuadraticEquation()
    {
        a = 1;
        b = 0;
        c = 0;
    }
    public QuadraticEquation(double coefficient, Coords vertex)
    {
        a = coefficient;

        b = (-vertex.getX() * 2) * coefficient;

        c = Math.pow(vertex.getX(), 2) + vertex.getY();
    }
    public String toString()
    {
        return a + "x^2 " + b + "x " + c;
    }
    public double getDiscriminant()
    {
        return (Math.pow(b, 2) - (4 * a * c));
    }
    public boolean hasRealRoots()
    {
        if (b > 0 && c < 0)
            return false;
        return true;
    }
    public boolean hasEqualRoots()
    {
        if (Math.pow(b/2, 2) == c)
            return true;
        return false;
    }
    public boolean hasMinimum()
    {
        if (a > 0)
            return true;
        return false;
    }
    public boolean hasMaximum()
    {
        if (hasMinimum())
            return false;
        return true;
    }
    public LinearEquation axisOfSymmetry()
    {
        return new LinearEquation(1, 0, a/b);
    }
    public Coords vertex()
    {
        double x = b / (-2 * a);
        return new Coords(x, c - (a * x * x));
    }
    public LinearEquation derivative()
    {
        return new LinearEquation(2 * a, -1, b);
    }
    public QuadraticRoots getRoots()
    {
        if (!hasRealRoots())
            return new QuadraticRoots(new ComplexNumber(-b / (2 * a), Math.sqrt(-1 * Math.pow(b, 2)) + (4 * a * c) / (2 * a)));
        return new QuadraticRoots(-b /(2 * a), Math.sqrt(-1 * Math.pow(b, 2)) + (4 * a * c) / (2 * a));
    }
}
