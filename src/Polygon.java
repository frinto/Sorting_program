public abstract class Polygon implements Comparable<Polygon>
{
    private double height;
    private char compareType;

    public Polygon(double height, char compareType)
    {
        this.height = height;
        this.compareType = compareType;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public char getCompareType()
    {
        return compareType;
    }

    public void setCompareType(char compareType)
    {
        this.compareType = compareType;
    }

    public int compareTo(Polygon polygon)
    {
        //TODO
        if (compareType == 'h' || compareType == 'H')
        {
            if (this.getHeight() > polygon.getHeight())
            {
                return 1;
            } else if (this.getHeight() < polygon.getHeight())
            {
                return -1;
            } else
            {
                return 0;
            }
        }

        if (compareType == 'a' || compareType == 'A')
        {
            if (this.calcBaseArea() > polygon.calcBaseArea())
            {
                return 1;
            } else if (this.calcBaseArea() < polygon.calcBaseArea())
            {
                return -1;
            } else
            {
                return 0;
            }
        }

        if(compareType == 'v' || compareType == 'V'){
            if(this.calcVolume() > polygon.calcVolume())
            {
                return 1;
            }
            else if(this.calcVolume() < polygon.calcVolume())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        
        return 2;
    }

    @Override
    public String toString()
    {
        return "Polygon{" +
                "height=" + height +
                ", compareType=" + compareType +
                '}';
    }

    public abstract double calcBaseArea();

    public abstract double calcVolume();
}
