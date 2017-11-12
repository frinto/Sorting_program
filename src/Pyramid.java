public class Pyramid extends Polygon
{
    private double side;
    
    public Pyramid(double height, char compareType, double side)
    {
        super(height, compareType);
        this.side = side;
    }

    @Override
    public double calcBaseArea()
    {
        double baseArea = Math.pow(this.side,2.0);
        return baseArea;
    }

    @Override
    public double calcVolume()
    {
        double volume = (1.0/3.0) * Math.pow(this.side, 2.0) * this.getHeight();
        return volume;
    }

    
}
