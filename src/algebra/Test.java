package algebra;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test
{
    public static void main(String[] args)
    {
        ArrayList<Coords> points = new ArrayList<Coords>();

        for (int i = 11; i > -1; i--)
        {
            points.add(new Coords(0,i));
        }

        System.out.println(Coords.getClosestPointFromOrigin(points));
    }
}
