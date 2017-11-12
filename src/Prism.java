public abstract class Prism extends Polygon
{

    private double side;
    
    public Prism(double height, char compareType,double side)
    {
        super(height, compareType);
        this.side = side;
    }

    public double getSide()
    {
        return side;
    }

    public void setSide(double side)
    {
        this.side = side;
    }
}
