package src.foodPac;

import java.util.*;
public class Cereals extends Urun {
    
    public Cereals(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }

    protected static ArrayList<Cereals>  deleteProduct(ArrayList<Cereals> cereals,int threshold){
        int hold = 0;

        Iterator<Cereals> it = cereals.iterator();
        System.out.println("Before:");
        while(it.hasNext()) {
            Cereals cereal = it.next();
            System.out.println(cereal.getName() + "\t" + cereal.getCategoryIndex() + "\t" + cereal.getWeight() + "\t"
              + cereal.getUnitPrice() + "\t" + cereal.getStockQuantity());
            if(cereal.unitPrice < threshold){
                hold = 1;
                it.remove();
            }
        }

        if(hold == 0){
            System.out.println("No product in range to delete");
        }
        return cereals;
    }

    public static ArrayList<Cereals>  callDeleteProduct(ArrayList<Cereals> cereals,int threshold){
        cereals = deleteProduct( cereals, threshold);
        return cereals;
    }
}

