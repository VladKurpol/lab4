package Lab3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Database db = new Database();

        db.circles.add(new Circle(5));
        db.circles.add(new Circle(10));
        db.circles.add(new Circle(6));
        db.circles.add(new Circle(8));

        db.cylinders.add(new Cylinder(db.circles.get(0).getRadius(), 5));
        db.cylinders.add(new Cylinder(db.circles.get(1).getRadius(), 22));
        db.cylinders.add(new Cylinder(db.circles.get(2).getRadius(), 12));
        db.cylinders.add(new Cylinder(db.circles.get(3).getRadius(), 4));

        FileWorker fileWorker = new FileWorker();

        fileWorker.save("testfile.txt",db.circles, db.cylinders);
        db.clear();
        fileWorker.read("testfile.txt",db.circles, db.cylinders);

        //----------------------------------------------------------------

        fileWorker.serialize("data_ser.txt", db.circles, db.cylinders);
        db.clear();
        db = fileWorker.deserialize("data_ser.txt", db.circles, db.cylinders);

        //-----------------------------------------------------------------

        fileWorker.serializeFastjson("data_json.json", db.circles, db.cylinders);
        db.clear();
        db = fileWorker.deserializeFastjson("data_json.json", db.circles, db.cylinders);

        System.out.println(db.circles.toString().replace("[", "").replace("]", ""));
        System.out.println(db.cylinders.toString().replace("[", "").replace("]", ""));

        System.out.println(db.maxSquare(db.circles));
        System.out.println(db.averageVolume(db.cylinders));
    }

}