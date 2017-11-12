public class OctagonalPrism extends Prism
{
    public OctagonalPrism(double height, char compareType, double side)
    {
        super(height, compareType, side);
    }

    @Override
    public double calcBaseArea()
    {
        double baseArea = 2.0 * (1.0 + Math.sqrt(2.0)) * Math.pow(this.getSide(),2.0);
        return baseArea;
    }

    @Override
    public double calcVolume()
    {
        double volume = this.calcBaseArea() * this.getHeight();
        return volume;
    }

    
}
