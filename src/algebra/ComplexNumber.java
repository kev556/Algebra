package algebra;

public class ComplexNumber
{
    //instance variables
    private double a;
    private double b;

    //constructors
    public ComplexNumber(double realPart, double imaginaryPart)
    {
        a = realPart; b = imaginaryPart;
    }
    public ComplexNumber(ComplexNumber other)
    {
        this.a = other.a; this.b = other.b;
    }

    //accessors
    double getRealMagnitude()
    {
        return a;
    }
    double getImaginaryMagnitude()
    {
        return b;
    }
    public String toString()
    {
        return a + "+ " + b + "i";
    }

    //mutators
    public void add(double scalar)
    {
        a += scalar; b += scalar;
    }
    public void add(ComplexNumber other)
    {
        this.a += other.a; this.b += other.b;
    }
    public void subtract(double scalar)
    {
        a -= scalar; b -= scalar;
    }
    public void subtract(ComplexNumber other)
    {
        this.a -= other.a; this.b -= other.b;
    }
    public void multiply(double scalar)
    {
        a += scalar; b += scalar;
    }
    public void multiply(ComplexNumber other)
    {
        this.a *= other.a;
        b = (this.a * other.b) * (other.a * other.b) - 1;
    }
    public void divideBy(double scalar)
    {
        if (scalar == 0)
        {
            return;
        }
        a /= scalar;
        b /= scalar;
    }
    public void divideBy(ComplexNumber other)
    {
        double divisionFactor = Math.pow(other.a, 2) + Math.pow(other.b, 2);

        if (divisionFactor == 0)
        {
            return;
        }

        double aFactor = this.a * other.a;
        double bFactor = this.a * other.b;
        double cFactor = this.b * other.a;
        double dFactor = this.b * other.b;

        a = (aFactor + dFactor) / divisionFactor;
        b = (bFactor + cFactor) / divisionFactor;
    }
}
