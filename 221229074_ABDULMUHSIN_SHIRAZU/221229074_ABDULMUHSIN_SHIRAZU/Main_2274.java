import java.util.*;
import java.io.*;

public class Main_2274 {

    static ArrayList<Urun> urunList = new ArrayList<Urun>();
    static ArrayList<Beverages> beverages = new ArrayList<Beverages>();
    static ArrayList<Confections> confections = new ArrayList<Confections>();
    static ArrayList<Condiments> condiments = new ArrayList<Condiments>();
    static ArrayList<DairyProducts> dairyProducts = new ArrayList<DairyProducts>();
    static ArrayList<Cereals> cereals = new ArrayList<Cereals>();

    public static void main(String[] args) {

        String filename = "Urun.txt";

        ListeOlustur(filename);
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
                    urunList = Urun.updateBasedOnPriceThreshold(urunList, minfiyat, stockIncrease);
                    yazdir(urunList);
                    break;
                case 2:
                    System.out.println("Enter indirim percentage:");
                    int indirim = scanner.nextInt();
                    System.out.println("Enter threshold:");
                    int threshold = scanner.nextInt();
                    urunList = Urun.discountBasedOnPriceThreshold(urunList, threshold, indirim);
                    yazdir(urunList);
                    break;
                case 3:
                    Beverages.displayTotalStockPrice(beverages);
                    break;

                case 4:
                    System.out.println("Enter N:");
                    int N = scanner.nextInt();
                    System.out.println("Enter yeniPrice:");
                    int yeniPrice = scanner.nextInt();
                    condiments = Condiments.changePrice(condiments, N, yeniPrice);

                    for (Condiments part : condiments) {
                        System.out.println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
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
                                        .println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                                                + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                    
                            System.out.println("\n");
                    break;
                case 6:
                    System.out.println("Enter minimum price:");
                    int min = scanner.nextInt();
                    System.out.println("Enter maximum price:");
                    int max = scanner.nextInt();

                    DairyProducts.filterDiaryProduct(dairyProducts,min, max);
                    break;
                case 7:
                System.out.println("Enter threshod:");
                   threshold = scanner.nextInt();
                    cereals  = Cereals.deleteProduct(cereals,threshold);

                    System.out.println("\n");
                    System.out.println("After:");
                    for (Cereals part : cereals) {
                        System.out
                                .println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
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

    static void ListeOlustur(String filename) {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line + "\n");
                String parts[] = line.trim().split("[\\s]+");
                //System.out.println(parts.length + "\n");
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


    static void yazdir(ArrayList<Urun> urunList) {

        for (Urun part : urunList) {
            System.out
                    .println(part.getName() + "\t" + part.getCategoryIndex() + "\t" + part.getWeight() + "\t"
                            + part.getUnitPrice() + "\t" + part.getStockQuantity());
        }

        System.out.println("\n");
    }

}
