package src.foodPac;

import java.util.*;
public class Condiments extends Urun {

    public Condiments(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity){
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }


    protected static ArrayList<Condiments>  changePrice(ArrayList<Condiments> condiments,int N,double newPrice){

        int counter = 0;
        int hold = 0;
        for (Condiments product : condiments) {
            if(counter == (N-1)){
                hold = 1;
                product.unitPrice = newPrice;
                break;
            }
            counter++;
        }

        if(hold == 0){
            System.out.println("There is no match for the index you entered");
        }

        return condiments;
    }

    public static ArrayList<Condiments>  callChangePrice(ArrayList<Condiments> condiments,int N,double newPrice){
        condiments = changePrice(condiments,N,newPrice);
        return condiments;
    }
}
