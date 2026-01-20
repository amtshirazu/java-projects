import java.util.ArrayList;
import java.util.Scanner;

public class Main_2274 {

    public static ArrayList<Urun> urunList = new ArrayList<Urun>();
    public static ArrayList<Beverages> beverages = new ArrayList<Beverages>();
    public static ArrayList<Confections> confections = new ArrayList<Confections>();
    public static ArrayList<Condiments> condiments = new ArrayList<Condiments>();

    public static void main(String[] args) {
        String filename = "urunler.txt";

        ListOkuma.callList(filename);
        Menu();
    }

    static void Menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean inprogress = true;
        while (inprogress) {
            System.out.println("1.YeniUrunEkle");
            System.out.println("2.EnKisaIsimliUrunIsimGuncelle");
            System.out.println("3.UrunFiyatGuncelle");
            System.out.println("4.UrunstokGuncelle");
            System.out.println("5.StokEnAzOlanUrunSil");
            System.out.println("8.cikis");
            System.out.println("Choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

                case 1:
                    System.out.println("Enter Urun type based on their code:");
                    System.out.println("Beverages : 1");
                    System.out.println("Condiments: 2");
                    System.out.println("Confections : 3");
                    int code = scanner.nextInt();
                    System.out.println("Enter the pos of Urun:");
                    int pos = scanner.nextInt();
                    System.out.println("Enter newName:");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    System.out.println("Enter newWeigt:");
                    String newWeigt = scanner.nextLine();
                    System.out.println("Enter newPrice:");
                    int newPrice = scanner.nextInt();
                   

                    System.out.println("\n");

                    switch (code) {
                        case 1:
                            Beverages bev = new Beverages();
                            bev.YeniUrunEkle(urunList, pos, newName, newWeigt, newPrice);

                            for (Beverages part : beverages) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;
                        case 2:
                            Condiments con = new Condiments();
                            con.YeniUrunEkle(urunList, pos, newName, newWeigt, newPrice);

                            for (Condiments part : condiments) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;

                        case 3:
                        Confections conf = new Confections();
                            conf.YeniUrunEkle(urunList, pos, newName, newWeigt, newPrice);

                            for (Confections part : confections) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;

                        

                    }

                    break;
                case 2:
                    System.out.println("Enter Urun type based on their code:");
                    System.out.println("Beverages : 1");
                    System.out.println("Condiments: 2");
                    System.out.println("Confections : 3");
                    code = scanner.nextInt();

                   

                    switch (code) {
                        case 1:
                        Beverages bev = new Beverages();
                        bev.EnKisaIsimliUrunIsimGuncelle("Sugarrrr");
    
                        for (Beverages part : beverages) {
                            System.out
                                    .println(
                                            part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                    + part.getWeight() + "\t"
                                                    + part.getUnitPrice() + "\t" + part.getStockQuantity());
                        }
                            break;
                        case 2:
                        Condiments cond = new Condiments();
                        cond.EnKisaIsimliUrunIsimGuncelle("Sugarrrr");
    
                        for (Condiments part : condiments) {
                            System.out
                                    .println(
                                            part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                    + part.getWeight() + "\t"
                                                    + part.getUnitPrice() + "\t" + part.getStockQuantity());
                        }
                            break;

                        case 3:

                        Confections conf = new Confections();
                        conf.EnKisaIsimliUrunIsimGuncelle("Sugarrrr");
    
                        for (Confections part : confections) {
                            System.out
                                    .println(
                                            part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                    + part.getWeight() + "\t"
                                                    + part.getUnitPrice() + "\t" + part.getStockQuantity());
                        }

                        break;
                    }

                    break;
                    
                case 3:
                    System.out.println("Beverages : 1");
                    System.out.println("Condiments: 2");
                    System.out.println("Confections : 3");
                    System.out.println("\n");
                    code = scanner.nextInt();

                    System.out.println("\n");

                    switch (code) {
                        case 1:
                        System.out.println("Enter the pos of Urun:");
                            pos = scanner.nextInt();
                            System.out.println("Enter IndrimMi:");
                            boolean indirimMi = scanner.nextBoolean();
                            Beverages bev = new Beverages();
                            bev.UrunFiyatGuncelle(indirimMi, pos);

                            for (Beverages part : beverages) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;
                        case 2:
                        System.out.println("Enter the pos of Urun:");
                            pos = scanner.nextInt();
                            System.out.println("Enter IndrimMi:");
                             indirimMi = scanner.nextBoolean();
                            Condiments cond = new Condiments();
                            cond.UrunFiyatGuncelle(indirimMi, pos);

                            for (Condiments part : condiments) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;

                        case 3:
                            System.out.println("Enter the pos of Urun:");
                            pos = scanner.nextInt();
                            System.out.println("Enter IndrimMi:");
                             indirimMi = scanner.nextBoolean();
                            Confections conf = new Confections();
                            conf.UrunFiyatGuncelle(indirimMi, pos);

                            for (Confections part : confections) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;


                    }
                    break;

                case 4:
                    System.out.println("Beverages : 1");
                    System.out.println("Condiments: 2");
                    System.out.println("Confections : 3");
                    System.out.println("DairyProducts: 4");
                    System.out.println("Cereals: 5");

                         code = scanner.nextInt();

                    switch (code) {
                        case 1:
                        System.out.println("Enter the pos of Urun:");
                            pos = scanner.nextInt();
                            System.out.println("Enter IndrimMi:");
                            boolean girismi = scanner.nextBoolean();
                            System.out.println("Enter adet:");
                            int adet = scanner.nextInt();
                            Beverages bev = new Beverages();
                            bev.UrunStokGuncelle(adet, girismi, pos);

                            for (Beverages part : beverages) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;
                        case 2:
                        System.out.println("Enter the pos of Urun:");
                            pos = scanner.nextInt();
                            System.out.println("Enter IndrimMi:");
                            girismi = scanner.nextBoolean();
                            System.out.println("Enter adet:");
                            adet = scanner.nextInt();
                            Condiments cond = new Condiments();
                            cond.UrunStokGuncelle(adet,girismi, pos);

                            for (Condiments part : condiments) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;

                        case 3:
                            System.out.println("Enter the pos of Urun:");
                            pos = scanner.nextInt();
                            System.out.println("Enter IndrimMi:");
                             girismi = scanner.nextBoolean();
                             System.out.println("Enter adet:");
                            adet = scanner.nextInt();
                            Confections conf = new Confections();
                            conf.UrunStokGuncelle(adet,girismi, pos);

                            for (Confections part : confections) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;


                    }

                    break;

                case 5:
                System.out.println("Beverages : 1");
                    System.out.println("Condiments: 2");
                    System.out.println("Confections : 3");
                    System.out.println("DairyProducts: 4");
                    System.out.println("Cereals: 5");

                         code = scanner.nextInt();

                    switch (code) {
                        case 1:
                            Beverages bev = new Beverages();
                            bev.StokEnAzOlanUrunSil();

                            for (Beverages part : beverages) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;
                        case 2:
                            Condiments cond = new Condiments();
                            cond.StokEnAzOlanUrunSil();

                            for (Condiments part : condiments) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;

                        case 3:
                            
                            Confections conf = new Confections();
                            conf.StokEnAzOlanUrunSil();

                            for (Confections part : confections) {
                                System.out
                                        .println(
                                                part.getName() + "\t" + part.getCategoryIndex() + "\t"
                                                        + part.getWeight() + "\t"
                                                        + part.getUnitPrice() + "\t" + part.getStockQuantity());
                            }
                            break;

                    }

                    break;
                case 8:
                    System.out.println("Exiting.....");
                    inprogress = false;
                    break;
            }
        }

        scanner.close();

    }
}
