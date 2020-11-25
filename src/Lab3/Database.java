package Lab3;

import java.util.ArrayList;

public class Database {

    ArrayList<Cylinder> cylinders;
    ArrayList<Circle> circles;

    public Database() {
        cylinders = new ArrayList<>();
        circles = new ArrayList<>();
    }

    public Database(ArrayList<Circle> circles, ArrayList<Cylinder> cylinders) {
        this.circles = circles;
        this.cylinders = cylinders;
    }

    public static String averageVolume(ArrayList<Cylinder> cylinders)
    {
        double volume = 0;
        for (Cylinder cylinder : cylinders) {
            volume += cylinder.getVolume();
        }
        volume /= cylinders.size();

        return "\nAverage volume of a cylinder = " + volume;
    }

    //,{"length":63.0,"radius":10.0,"square":314.0},{"length":38.0,"radius":6.0,"square":113.0},{"length":50.0,"radius":8.0,"square":201.0}][{"height":5.0,"length":31.0,"radius":5.0,"square":0.0,"volume":393.0},{"height":22.0,"length":63.0,"radius":10.0,"square":0.0,"volume":6912.0},{"height":12.0,"length":38.0,"radius":6.0,"square":0.0,"volume":1357.0},{"height":4.0,"length":50.0,"radius":8.0,"square":0.0,"volume":804.0}]

    public void clear() {
        this.cylinders.clear();
        this.circles.clear();
    }

    public static String maxSquare(final ArrayList<Circle> circles)
    {
        double max = circles.get(0).getSquare();
        for (Circle circle : circles) {
            if (circle.getSquare() > max) {
                max = circle.getSquare();
            }
        }
        return "\nMax square of a circle: " + max;
    }




}
