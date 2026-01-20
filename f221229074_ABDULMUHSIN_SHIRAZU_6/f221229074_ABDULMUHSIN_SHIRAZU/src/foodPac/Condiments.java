package src.foodPac;

import java.util.*;

public class Condiments extends Urun {

    public Condiments(){

    }

    public Condiments(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super(name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }


    @Override
    public ArrayList<Urun> updateBasedOnPriceThreshold(ArrayList<Urun> urunList, int minfiyat,int stockIncrease) {
    
        for (Urun urun : urunList) {
            if (urun instanceof Condiments) {
                    urun.unitPrice = urun.getUnitPrice() - minfiyat;
                   // System.out.println(urun.getStockQuantity());
                    if (urun.getUnitPrice() < 0) {
                        urun.stockQuantity = 0;
                    }
                    System.out.println(urun.getName() + "\t" + urun.getCategoryIndex() + "\t" + urun.getWeight() + "\t"
                            + urun.getUnitPrice() + "\t" + urun.getStockQuantity());
                }
        }

        return urunList;
    }

    public static ArrayList<Condiments> changePrice(ArrayList<Condiments> condiments,int N, double newPrice) {
        int counter = 0;
        int hold = 0;
        for (Condiments product : condiments) {
            if (counter == (N - 1)) {
                hold = 1;
                product.unitPrice = newPrice;
                break;
            }
            counter++;
        }

        if (hold == 0) {
            System.out.println("There is no match for the index you entered");
        }

        return condiments;
    }


    public static ArrayList<Condiments> changePrice(ArrayList<Condiments> condiments, double price) {
        int hold = 0;

        for (Condiments product : condiments) {
            if (product.unitPrice < price) {
                hold = 1;
                product.unitPrice = price;
            }
        }

        if (hold == 0) {
            System.out.println("There is no product whose price is less than the price you entered!");
        }

        return condiments;
    }


    
}
