package algebra;

public class QuadraticRoots
{
    private ComplexNumber root1;
    private ComplexNumber root2;

    public QuadraticRoots(double r1, double r2)
    {
        root1 = new ComplexNumber(r1, r2);
        root2 = new ComplexNumber(r1, -r2);
    }
    public QuadraticRoots(ComplexNumber r1)
    {
        root1 = new ComplexNumber(r1.getRealMagnitude(), r1.getImaginaryMagnitude());
        root2 = new ComplexNumber(r1.getRealMagnitude(), -r1.getImaginaryMagnitude());
    }

    public ComplexNumber getRoot1()
    {
        return root1;
    }
    public ComplexNumber getRoot2()
    {
        return root2;
    }
    public String toString()
    {
        return "(x = " + -root1.getRealMagnitude() + ") , (x = " + -root2.getRealMagnitude() + " )";
    }
    public boolean areValid()
    {
        if (root1.getImaginaryMagnitude() == 0 && root2.getImaginaryMagnitude() == 0 || root1.getImaginaryMagnitude() == -root2.getImaginaryMagnitude())
            return true;
        return false;
    }
}
