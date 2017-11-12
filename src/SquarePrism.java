public class SquarePrism extends Prism
{
    public SquarePrism(double height, char compareType, double side)
    {
        super(height, compareType, side);
    }

    @Override
    public double calcBaseArea()
    {
        double baseArea = Math.pow(this.getSide(), 2.0);
        return baseArea;
    }

    @Override
    public double calcVolume()
    {
        double volume = this.calcBaseArea() * this.getHeight();
        return volume;
    }

    
}
