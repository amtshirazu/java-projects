package src.foodPac;

import java.util.*;
public class Beverages extends Urun {

    public Beverages(){
        
    }
    
    public Beverages(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity){
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }


    @Override
    public  ArrayList<Urun>  discountBasedOnPriceThreshold(ArrayList<Urun> urunList,int threshold,int indirim){
        for (Urun urun : urunList) {
            if((urun instanceof Beverages) && urun.getUnitPrice() < threshold){
                urun.unitPrice = urun.getUnitPrice()*((100-indirim)/100.0);
                System.out.println(urun.getName() + "\t" + urun.getCategoryIndex() + "\t" + urun.getWeight() + "\t"
                                        + urun.getUnitPrice() + "\t" + urun.getStockQuantity());
            }

        }

        System.out.println("\n");
        return urunList;
    }


    public static void  displayTotalStockPrice(ArrayList<Beverages> beverages){

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


    public static void  displayTotalStockPrice(ArrayList<Beverages> beverages, int increase){

        int totalQuantity = 0;
        for (Beverages urun : beverages) {
            totalQuantity += urun.getStockQuantity();
        }

        totalQuantity += increase;

        for (Beverages part : beverages) {
            System.out
                    .println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                            + part.getUnitPrice() + "\t" + part.getStockQuantity());
        }

        System.out.println("\n");
        System.out.println("Total StockQuantity of beverages: " + totalQuantity + "\n");
    }


    
}