public class PentagonalPrism extends Prism
{

    public PentagonalPrism(double height, char compareType, double side)
    {
        super(height, compareType, side);
    }

    @Override
    public double calcBaseArea()
    {
        double baseArea = ((5.0 * Math.pow(this.getSide(), 2.0)) * Math.tan(54.0))/4.0;
        return baseArea;
    }

    @Override
    public double calcVolume()
    {
        double volume = this.calcBaseArea() * this.getHeight();
        return volume;
    }

    
}
