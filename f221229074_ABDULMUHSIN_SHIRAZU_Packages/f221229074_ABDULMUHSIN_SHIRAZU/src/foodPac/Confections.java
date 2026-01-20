package src.foodPac;

import java.util.*;
public class Confections extends Urun {
    
    public Confections(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super(name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }
    public static ArrayList<Confections>  changeData(ArrayList<Confections> confections,String name,String newName,String newWeigt,double newPrice,int newstokMiktar){

        int hold = 0;
        for (Confections product : confections) {
            if(product.name.equals(name)){
                hold = 1;
                product.name = newName;
                product.weight = newWeigt;
                product.unitPrice = newPrice;
                product.stockQuantity = newstokMiktar;
                break;
            }
        }

        if(hold == 0){
            System.out.println("The name you entered does not exist in confections list");
        }

        return confections;
    }

    public static ArrayList<Confections>  callChangeData(ArrayList<Confections> confections,String name,String newName,String newWeigt,double newPrice,int newstokMiktar){
        confections = changeData(confections,name,newName,newWeigt,newPrice,newstokMiktar);
        return confections;
    }
}

