
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
public class ManageFruit {

    ArrayList<Fruit> mylist;

    public ManageFruit(ArrayList<Fruit> mylist) {
        this.mylist = mylist;
    }

    public ManageFruit() {
        this.mylist = new ArrayList<>();
    }

    public void addFruit(Fruit fruit) {
        if(!Validation.checkIdexist(mylist, fruit)){
            mylist.add(fruit);
            return; 
        }
        System.out.println("ID exist");
        
        
    }

    public Fruit getFruitbychoice(int choice) {
        int count = 1;
        for (Fruit fruit : mylist) {
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (count - 1 == choice) {
                return fruit;
            }
        }
        return null;
    }

    public void displayFruitList() {
        int count = 1; 
        System.out.printf("|%10s|%15s|%15s|%15s", "| ++ Item ++ ", " |++ Fruit Name ++ |", " ++ Origin ++ |", " ++ Price ++ |\n");
        for (Fruit fruit : mylist) {
            if(fruit.getQuantity()!=0){
                System.out.print("\t"+count+". ");
            count++; 
            fruit.displayFruit();
            }
            
        }
    }
}
