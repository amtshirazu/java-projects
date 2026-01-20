package src.foodPac;

import src.listPac.*;
import java.util.*;

public class Main_2274 {

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
