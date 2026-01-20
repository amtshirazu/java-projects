package src.foodPac;

import java.util.*;

public class Urun {
    protected String name;
    protected int categoryIndex;
    protected String weight;
    protected double unitPrice;
    protected int stockQuantity;

    public Urun() {
    
    }

    public Urun(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        this.name = name;
        this.categoryIndex = categoryIndex;
        this.weight = unitWeight;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }


    public String getName(){
    	return name; 
    }
    
    public int getCategoryIndex(){
    	return categoryIndex; 
    }
    
    public String getWeight(){
    	return weight; 
    }
    
    public double getUnitPrice(){
    	return unitPrice;
    }
    
    public int getStockQuantity(){
    	return stockQuantity;
    }

    public  ArrayList<Urun>  updateBasedOnPriceThreshold(ArrayList<Urun> urunList,int minfiyat,int stockIncrease){

        for (Urun urun : urunList) {
            if(urun.getUnitPrice() > minfiyat){
                urun.stockQuantity += stockIncrease;

                System.out.println(urun.getName() + "\t" + urun.getCategoryIndex() + "\t" + urun.getWeight() + "\t"
                                        + urun.getUnitPrice() + "\t" + urun.getStockQuantity());
            }
        }

        System.out.println("\n");
        return urunList;
    }
    
    public ArrayList<Urun>  discountBasedOnPriceThreshold(ArrayList<Urun> urunList,int threshold,int indirim){

        for (Urun urun : urunList) {
            if(urun.getUnitPrice() > threshold){
                urun.unitPrice = urun.getUnitPrice()*((100-indirim)/100.0);
                System.out.println(urun.getName() + "\t" + urun.getCategoryIndex() + "\t" + urun.getWeight() + "\t"
                                        + urun.getUnitPrice() + "\t" + urun.getStockQuantity());
            }

        }

        System.out.println("\n");
        return urunList;
    }

   
}
