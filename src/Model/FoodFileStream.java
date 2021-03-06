package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FoodFileStream {
    public void write(List<Food> list, String file) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            for (Food f : list)
                out.writeObject(f);
        } catch (IOException e) {
            System.out.println("error opening food file");
        } catch (NoSuchElementException e) {
            System.out.println("food input error");
        }
        finally {
            try {
                if(out != null)
                    out.close();
            } catch (IOException e) {
                System.out.println("error closing food file");
            }
        }
    }

    public List<Food> read(String file) {
        List<Food> list = new ArrayList<>();
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                Food f = (Food) input.readObject();
                list.add(f);
            }
        } catch (EOFException e) {
            return list;
        } catch (ClassNotFoundException e) {
            System.out.println("food class not found.");
        }catch (IOException e) {
            System.out.println("error opening food file.");
        } finally {
            try {
                if(input != null)
                    input.close();
            } catch (IOException e) {
                System.out.println("error closing food file.");
            }
        }
        return list;
    }
}
