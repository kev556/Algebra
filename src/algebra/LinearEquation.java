package algebra;

public class LinearEquation
{
    // standard form: ax+by+c = 0
    private double a;
    private double b;
    private double c;

    //static method
    public boolean areValidParams(double a, double b)
    {
        return (a != 0 && b != 0);
    }

    //constructors
    public LinearEquation(double a, double b,  double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public LinearEquation(double slope, Coords point)
    {
        this(-slope, 1, slope * point.getX() -point.getY());
    }
    public LinearEquation(LinearEquation other)
    {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }
    public LinearEquation(Coords point1, Coords point2)
    {
        if (point1.getX() == point2.getX())
        {
            a = 1;
            b = 0;
            c = -point1.getX();
        }
    }
    public LinearEquation(LinearEquation other, Coords point)
    {
        this(other.a / other.b, point);
    }

    //accessors
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getC()
    {
        return c;
    }
    public boolean slopeDefined()
    {
        if (-a / b != 0)
            return true;
        else
            return false;
    }
    public boolean hasYIntercept()
    {
        if (b == 0)
            return true;
        else
            return false;
    }
    public boolean hasXIntercept()
    {
        if (a == 1)
            return true;
        else
            return false;
    }
    public double slope()
    {
        return -a / b;
    }
    public double yIntercept()
    {
        if (hasYIntercept())
            return -c / b;
        else
            return Double.NaN;
    }
    public double xIntercept()
    {
        if (hasXIntercept())
            return -c / a;
        else
            return Double.NaN;
    }
    public double slopeOfPerpendicularLine()
    {
        return b / a;
    }
    public boolean isIncreasing()
    {
        if (-a / b > 0)
            return true;
        else
            return false;
    }
    public boolean isDecreasing()
    {
        if (-a / b < 0)
            return true;
        else
            return false;
    }
    public boolean isHorizontal()
    {
        if (-a / b == 0)
            return true;
        else
            return false;
    }
    public boolean isVertical()
    {
        if (b == 0)
            return true;
        else
            return false;
    }
    public boolean isAFunction()
    {
        return !isVertical();
    }
    public boolean isValidLinearEquation()
    {
        return areValidParams(a, b);
    }
    public boolean isDirectVariation()
    {
        if (c == 0)
            return true;
        else
            return false;
    }

    //other methods
    public boolean equals(LinearEquation other)
    {
        if (this.slope() == other.slope() && this.yIntercept() == other.yIntercept())
            return true;
        else
            return false;
    }
    public LinearEquation parallelLine(Coords point)
    {
        return new LinearEquation( -slope(), point);
    }
    public LinearEquation perpendicularLine(Coords point)
    {
        return new LinearEquation(1 / -slope(), point);
    }
    public double shortestDistanceFrom(Coords point)
    {
        LinearEquation perp = perpendicularLine(point);
        Coords intersection = pointOfIntersection(perp);

        return point.distanceFrom(intersection);
    }
    public LinearEquation inverseFunction()
    {
        return new LinearEquation(b /-a, -1, c / -a);
    }
    public Coords pointOfIntersection(LinearEquation other)
    {
        double y = (this.a * other.c - this.c * other.a) / (this.b * other.a);
        double x = (-b * y - c) / a;

        return new Coords(x,y);
    }
    public boolean isParallel(LinearEquation other)
    {
        if (this.slope() == other.slope())
            return true;
        else
            return false;
    }
    public boolean isPerpendicular(LinearEquation other)
    {
        if (this.slope() == 1/other.slope())
            return true;
        else
            return false;
    }
    public String toString()
    {
        return a + "x " + b + "y " + c;
     }
    public String getSlopeInterceptForm()
    {
        return "y = " + -slope() + "x + " + yIntercept();
    }

}
