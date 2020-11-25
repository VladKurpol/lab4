package Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class FileWorker {

    //--------------Serialize---------------

    public Database serialize(String filename, ArrayList<Circle> circles,ArrayList<Cylinder> cylinders) throws IOException {

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(circles);
            oos.writeObject(cylinders);
            oos.close();
            fos.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return new Database(circles, cylinders);
    }

    public Database deserialize(String filename, ArrayList<Circle> circles,ArrayList<Cylinder> cylinders) throws IOException {

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            circles = (ArrayList<Circle>) ois.readObject();
            cylinders = (ArrayList<Cylinder>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return new Database(circles, cylinders);
    }

    //-----------------------JSON----------------------------

    public void serializeFastjson(String filename, ArrayList<Circle> circles,ArrayList<Cylinder> cylinders) throws IOException {
        FileWriter os = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(os);
        bw.write(JSON.toJSONString(circles));
        bw.write("\n");
        bw.write(JSON.toJSONString(cylinders));
        bw.close();
        os.close();
    }

    public Database deserializeFastjson(String filename, ArrayList<Circle> circles,ArrayList<Cylinder> cylinders) throws IOException {

        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);
        Circle c = null;

        ArrayList<JSONObject> JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
            circles.add(new Circle(st.getDouble("length"), st.getDouble("radius"),st.getDouble("square")));
        }

        JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
            cylinders.add(new Cylinder( st.getDouble("height"), st.getDouble("radius"),st.getDouble("square"),st.getDouble("volume")));
        }

        scanner.close();
        fr.close();

        return new Database(circles, cylinders);
    }

    //--------------------------------------------------

    public void save(String filename, ArrayList<Circle> circles,ArrayList<Cylinder> cylinders) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Circle circle : circles) {
            try {
                bw.write("Circle " + String.valueOf(circle.getRadius()));
                bw.write(System.lineSeparator());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Cylinder cylinder : cylinders) {
            try {
                bw.write("Cylinder " + String.valueOf(cylinder.getRadius()) + " " + String.valueOf(cylinder.getHeight()));
                bw.write(System.lineSeparator());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bw.close();
        fw.close();
    }

    public void read(String filename, ArrayList<Circle> circles,ArrayList<Cylinder> cylinders) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(filename));
        while (scanner.hasNextLine())
        {
            String[] line = scanner.nextLine().split(" ");
            if(line[0].matches("Circle"))
            {
                circles.add(new Circle(Double.valueOf(line[1])));
            }
            else if(line[0] .matches("Cylinder") )
            {
                cylinders.add(new Cylinder(Double.valueOf(line[1]),Double.valueOf(line[2])));
            }
            else
                System.out.println("ERROR");

        }
    }



}