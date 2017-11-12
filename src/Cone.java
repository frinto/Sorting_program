public class Cone extends Polygon
{
    private double radius;
    
    public Cone(double height, char compareType, double radius)
    {
        super(height, compareType);
        this.radius = radius;
    }

    @Override
    public double calcBaseArea()
    {
        double baseArea = Math.PI * Math.pow(this.radius, 2.0);
        return baseArea;
    }

    @Override
    public double calcVolume()
    {
        double volume = (1.0/3.0) * Math.PI * Math.pow(this.radius, 2.0) * this.getHeight();
        return volume;
    }

    
}
