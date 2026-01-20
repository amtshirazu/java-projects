import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import src.foodPac.Beverages;
import src.foodPac.Cereals;
import src.foodPac.Condiments;
import src.foodPac.Confections;
import src.foodPac.DairyProducts;
import src.foodPac.Main_2274;
import src.foodPac.Urun;

import java.util.*;
public class Tumsiniflar_2274 {

    class Main_2274 {

    public static ArrayList<Urun> urunList = new ArrayList<Urun>();
    public static ArrayList<Beverages> beverages = new ArrayList<Beverages>();
    public static ArrayList<Confections> confections = new ArrayList<Confections>();
    public static ArrayList<Condiments> condiments = new ArrayList<Condiments>();
    public static ArrayList<DairyProducts> dairyProducts = new ArrayList<DairyProducts>();
    public static ArrayList<Cereals> cereals = new ArrayList<Cereals>();

    public static void main(String[] args) {

        String filename = "src\\listPac\\Urun.txt";

        ListOkuma.callList(filename);
        Menu();

    }

    static void Menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean inprogress = true;
        while (inprogress) {
            System.out.println("1.updateBasedOnPriceThreshold");
            System.out.println("2.discountBasedOnPriceThreshold");
            System.out.println("3.displayTotalStockPrice");
            System.out.println("4.changePrice");
            System.out.println("5.changeData");
            System.out.println("6.filterDiaryProduct");
            System.out.println("7.deleteProduct");
            System.out.println("8.cikis");
            System.out.println("Choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter minimum price:");
                    int minfiyat = scanner.nextInt();
                    System.out.println("Enter amount to be increased on each stock:");
                    int stockIncrease = scanner.nextInt();
                    System.out.println("Override icin ayni seyler kullanacak!");
                    Urun urun = new Urun();
                    urunList = urun.updateBasedOnPriceThreshold(urunList, minfiyat, stockIncrease);
                    yazdir(urunList);

                    Condiments cond = new Condiments();
                    urunList = cond.updateBasedOnPriceThreshold(urunList, minfiyat, stockIncrease);
                    yazdir(urunList);
                    break;
                case 2:
                    System.out.println("Enter indirim percentage:");
                    int indirim = scanner.nextInt();
                    System.out.println("Enter threshold:");
                    int threshold = scanner.nextInt();

                    urun = new Urun();
                    urunList = urun.discountBasedOnPriceThreshold(urunList, threshold, indirim);
                    yazdir(urunList);

                    Beverages bev = new Beverages();
                    urunList = bev.discountBasedOnPriceThreshold(urunList, threshold, indirim);
                    yazdir(urunList);
                    break;
                case 3:
                    Beverages.displayTotalStockPrice(beverages);


                    System.out.println("Enter increase:");
                    int increase = scanner.nextInt();
                    Beverages.displayTotalStockPrice(beverages,increase);
                    break;

                case 4:
                    System.out.println("Enter N:");
                    int N = scanner.nextInt();
                    System.out.println("Enter yeniPrice:");
                    int yeniPrice = scanner.nextInt();
                    condiments = Condiments.changePrice(condiments, N, yeniPrice);

                    for (Condiments part : condiments) {
                        System.out.println(
                                part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                    }

                    System.out.println("\n");


                    System.out.println("Enter price:");
                    int price = scanner.nextInt();
                    condiments = Condiments.changePrice(condiments,price);

                    for (Condiments part : condiments) {
                        System.out.println(
                                part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                    }

                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Enter the name of the urun you want to change:");
                    String name = scanner.nextLine();
                    System.out.println("Enter newName:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter newWeigt:");
                    String newWeigt = scanner.nextLine();
                    System.out.println("Enter newPrice:");
                    int newPrice = scanner.nextInt();
                    System.out.println("Enter newstokMiktar:");
                    int newstokMiktar = scanner.nextInt();
                    confections = Confections.changeData(confections, name, newName, newWeigt,
                            newPrice, newstokMiktar);

                    for (Confections part : confections) {
                        System.out
                                .println(
                                        part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                                + part.getUnitPrice() + "\t" + part.getStockQuantity());
                    }

                    System.out.println("\n");

                    System.out.println("Enter concatName:");
                    scanner.nextLine();
                    String concat = scanner.nextLine();
                    confections = Confections.changeData(confections,concat);

                    for (Confections part : confections) {
                        System.out
                                .println(
                                        part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                                + part.getUnitPrice() + "\t" + part.getStockQuantity());
                    }

                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("Enter minimum price:");
                    int min = scanner.nextInt();
                    System.out.println("Enter maximum price:");
                    int max = scanner.nextInt();

                    DairyProducts.filterDiaryProduct(dairyProducts, min, max);

                    System.out.println("Enter minimum price for overloading:");
                    min = scanner.nextInt();
                    DairyProducts.filterDiaryProduct(dairyProducts, min);
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("Enter threshod:");
                    threshold = scanner.nextInt();
                    cereals = Cereals.deleteProductOrIncreaseprice(cereals, threshold);

                    System.out.println("\n");
                    System.out.println("After:");
                    for (Cereals part : cereals) {
                        System.out
                                .println(
                                        part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                                + part.getUnitPrice() + "\t" + part.getStockQuantity());
                    }

                    System.out.println("\n");


                    System.out.println("Enter price for overloading:");
                    price = scanner.nextInt();
                    cereals = Cereals.deleteProductOrIncreaseprice(cereals, threshold, price);

                    System.out.println("\n");
                    System.out.println("After:");
                    for (Cereals part : cereals) {
                        System.out
                                .println(
                                        part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                                + part.getUnitPrice() + "\t" + part.getStockQuantity());
                    }

                    System.out.println("\n");

                    break;
                case 8:
                    System.out.println("Exiting.....");
                    inprogress = false;
                    break;
            }
        }

        scanner.close();

    }

    static void yazdir(ArrayList<Urun> urunList) {

        for (Urun part : urunList) {
            System.out
                    .println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                            + part.getUnitPrice() + "\t" + part.getStockQuantity());
        }

        System.out.println("\n");
    }

}


class Urun {
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


class Beverages extends Urun {

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

 class Condiments extends Urun {

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
                        urun.stockQuantity = 50000;
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


 class Confections extends Urun {
    
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


    public static ArrayList<Confections>  changeData(ArrayList<Confections> confections,String concat){
        for (Confections product : confections) {  
            //System.out.println(concat);
                product.name = product.getName() + "_" + concat;
        }
        return confections;
    }

}



class DairyProducts extends Urun {

    public DairyProducts() {
        
    }

    public DairyProducts(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super(name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }

    public static void filterDiaryProduct( ArrayList<DairyProducts> dairyProducts, int min, int max){
        int hold = 0;
        System.out.println("Products in range:");
        for (DairyProducts product : dairyProducts) {
            if (product.getUnitPrice() > min && product.getUnitPrice() < max) {
                hold = 1;
                System.out.println(product.getName() + "\t" + product.getCategoryIndex() + "\t" + product.getWeight() + "\t"
                                + product.getUnitPrice() + "\t" + product.getStockQuantity());
            }
        }

        if(hold == 0){
            System.out.println("No product is in this range");
        }

        System.out.println("\n");

        System.out.println("All products in dairyProducts:");
        for(DairyProducts product:dairyProducts){
            System.out.println(product.getName() + "\t" + product.getCategoryIndex() + "\t" + product.getWeight() + "\t"
                    + product.getUnitPrice() + "\t" + product.getStockQuantity());
        }
    }


    public static void filterDiaryProduct( ArrayList<DairyProducts> dairyProducts, int min){
        int hold = 0;
        System.out.println("Products less than " + min);
        for (DairyProducts product : dairyProducts) {
            if (product.getUnitPrice() < min ) {
                hold = 1;
                System.out.println(product.getName() + "\t" + product.getCategoryIndex() + "\t" + product.getWeight() + "\t"
                                + product.getUnitPrice() + "\t" + product.getStockQuantity());
            }
        }

        if(hold == 0){
            System.out.println("No product is less than " + min);
        }

        System.out.println("\n");

        System.out.println("All products in dairyProducts:");
        for(DairyProducts product:dairyProducts){
            System.out.println(product.getName() + "\t" + product.getCategoryIndex() + "\t" + product.getWeight() + "\t"
                    + product.getUnitPrice() + "\t" + product.getStockQuantity());
        }
    }
}



class Cereals extends Urun {
    
    public Cereals(){
        
    }
    
    public Cereals(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }


    public static ArrayList<Cereals>  deleteProductOrIncreaseprice(ArrayList<Cereals> cereals,int threshold){
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

    public static ArrayList<Cereals>  deleteProductOrIncreaseprice(ArrayList<Cereals> cereals,int threshold,int price){
        int hold = 0;

        Iterator<Cereals> it = cereals.iterator();
        System.out.println("Before:");
        while(it.hasNext()) {
            Cereals cereal = it.next();
            System.out.println(cereal.getName() + "\t" + cereal.getCategoryIndex() + "\t" + cereal.getWeight() + "\t"
              + cereal.getUnitPrice() + "\t" + cereal.getStockQuantity());
            if(cereal.unitPrice > threshold){
                hold = 1;
                cereal.unitPrice+=price;
            }
        } 

        if(hold == 0){
            System.out.println("No product in range to delete");
        }
        return cereals;
    }


}





    class ListOkuma {

    protected static void ListeOlustur(String filename) {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line + "\n");
                String parts[] = line.trim().split("[\\s]+");
                // System.out.println(parts.length + "\n");
                String adi = parts[0];
                int index = Integer.parseInt(parts[1]);
                String weight = parts[2];
                double unitPrice = Double.parseDouble(parts[3]);
                int stockQuantity = Integer.parseInt(parts[4]);

                Urun urun;
                switch (index) {
                    case 1:
                        urun = new Beverages(adi, index, weight, unitPrice, stockQuantity);
                        Main_2274.beverages.add((Beverages) urun);
                        Main_2274.urunList.add(urun);
                        break;
                    case 2:
                        urun = new Condiments(adi, index, weight, unitPrice, stockQuantity);
                        Main_2274.condiments.add((Condiments) urun);
                        Main_2274.urunList.add(urun);
                        break;
                    case 3:
                        urun = new Confections(adi, index, weight, unitPrice, stockQuantity);
                        Main_2274.confections.add((Confections) urun);
                        Main_2274.urunList.add(urun);
                        break;

                    case 4:
                        urun = new DairyProducts(adi, index, weight, unitPrice, stockQuantity);
                        Main_2274.dairyProducts.add((DairyProducts) urun);
                        Main_2274.urunList.add(urun);
                        break;
                    case 5:
                        urun = new Cereals(adi, index, weight, unitPrice, stockQuantity);
                        Main_2274.cereals.add((Cereals) urun);
                        Main_2274.urunList.add(urun);
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void callList(String filename){
        ListeOlustur(filename);
    }
}

    
}
