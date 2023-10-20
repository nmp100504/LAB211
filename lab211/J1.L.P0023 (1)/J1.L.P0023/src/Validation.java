
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Validation {

    public static boolean checkIdexist(ArrayList<Fruit> arr, Fruit fruit) {
        for (Fruit fruit1 : arr) {
            if (fruit1.getFruitID().equalsIgnoreCase(fruit.getFruitID())) {
                return true;
            }
        }
        return false;
    }


}
