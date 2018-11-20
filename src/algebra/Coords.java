package algebra;
import java.util.ArrayList;

public class Coords
{
    private double x;
    private double y;

    public static Coords getClosestPointFromOrigin(ArrayList<Coords> points)
    {
        Coords closest = points.get(0);
        for (Coords v : points)
        {
            if (v.distanceFromOrigin() < closest.distanceFromOrigin())
            {
                closest = v;
            }
        }
        return closest;
    }

    public Coords(double x, double y)
    {
        this.x = x;
        this.y = y;

    }
    public Coords(double x)
    {
        this.x = x; this.y = 0;

    }
    public Coords()
    {
        this.x = 0; this.y = 0;

    }
    public Coords(Coords other)
    {
        this.x = other.x; this.y = other.y;
    }

    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public String toString()
    {
        return "( " + x + " , " + y + " )";
    }

    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public void reflectOnXAxis()
    {
        x = -x;
    }
    public void reflectionOnYAxis()
    {
        y = -y;
    }
    public void reflectOnOrigin()
    {
        x = -x;
        y = -y;
    }
    public void translate(double horizontal, double vertical)
    {
        x += horizontal;
        y += vertical;

    }
    public void dilate(double dilationFactor)
    {
        x *= dilationFactor;
        y *= dilationFactor;
    }

    public double distanceFromOrigin()
    {
        return Math.sqrt((x * x)+(y * y));
    }
    public double distanceFrom(Coords other)
    {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    public boolean equals(Coords otherPoint)
    {
        if (this.x == otherPoint.x && this.y == otherPoint.y)
            return true;
        else
            return false;
    }
    public double getSlopeOfLineSegment(Coords other)
    {
        return (other.y - this.y) / (other.x - this.x);
    }
    public boolean slopeOfLineSegmentDefined(Coords other)
    {
        if (other.x == this.x)
            return true;
        else
            return false;
    }
}
