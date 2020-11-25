package Lab3;

public class Circle implements IFigure {
    private double radius;
    private double length;
    private double square;


    public Circle(final double radius)
    {
        this.setRadius(radius);
        this.setLength();
        this.setSquare();
    }

    public Circle(){}

    public void setLength()
    {
        this.length = Math.round(2 * Math.PI * this.radius);
    }

    public void setSquare()
    {
        this.square = Math.round(Math.PI * (Math.pow(this.radius, 2)));
    }

    public double getRadius()
    {
        return this.radius;
    }

    /**
     * Calculates the radius
     *
     * @param radius radius of the circle
     */
    public void setRadius(final double radius)
    {
        if (radius > 0) {
            this.radius = radius;
        }
        else {
            this.radius = 1;
        }
    }

    @Override
    public String toString()
    {
        return "\nCircle\nRadius: " + radius + "\nLength: " + getLength() + "\nSquare: " + getSquare() + "\n";
    }

    public double getLength()
    {
        return length;
    }

    public double getSquare()
    {
        return square;
    }
}