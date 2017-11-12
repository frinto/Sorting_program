public class TriangularPrism extends Prism
{
    public TriangularPrism(double height, char compareType, double side)
    {
        super(height, compareType, side);
    }

    @Override
    public double calcBaseArea()
    {
        double baseArea = (Math.pow(this.getSide(),2.0)*Math.sqrt(3.0)) / 4.0;
        return baseArea;
    }

    @Override
    public double calcVolume()
    {
        double volume = this.calcBaseArea() * this.getHeight();
        return volume;
    }

    
}
