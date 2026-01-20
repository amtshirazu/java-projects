package src.foodPac;

import java.util.*;
public class Beverages extends Urun {

    public Beverages(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity){
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }

     protected static void  displayTotalStockPrice(ArrayList<Beverages> beverages){

        int totalQuantity = 0;
        for (Beverages urun : beverages) {
            totalQuantity += urun.getStockQuantity();
        }

        for (Beverages part : beverages) {
            System.out
                    .println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                            + part.getUnitPrice() + "\t" + part.getStockQuantity());
        }

        System.out.println("\n");
        System.out.println("Total StockQuantity of beverages: " + totalQuantity + "\n");
    }

    public static void callDisplayTotalStockPrice(ArrayList<Beverages> beverages){
        displayTotalStockPrice(beverages);
    }
}