import java.io.*;
import java.util.*;

public class Urun {

    String adi;
    String birimAgirligi;
    double birimFiyat;
    int stokMiktari;
    int CatIndex;

    public Urun() {

    }

    public Urun(String adi, int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        this.adi = adi;
        this.birimAgirligi = birimAgirligi;
        this.birimFiyat = birimFiyati;
        this.stokMiktari = stokMiktari;
        this.CatIndex = CatIndex;
    }

    public static ArrayList<Beverages> beveragesList = new ArrayList<>();
    public static ArrayList<Condiments> condimentsList = new ArrayList<>();
    public static ArrayList<Confections> confectionsList = new ArrayList<>();
    public static ArrayList<DairyProducts> dairyProductsList = new ArrayList<>();
    public static ArrayList<Cereals> cerealsList = new ArrayList<>();
    public static ArrayList<Urun> urun = new ArrayList<>();

    public static class VeriGirisiIslemleri {
        public static class DosyaOkuma {
            public static void ListeleriOlustur() {
                try (BufferedReader br = new BufferedReader(new FileReader("Urun.txt"))) {

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

                        Urun ur;
                        switch (index) {
                            case 1:
                                Urun.Beverages beverages = new Urun.Beverages(adi, index, weight, unitPrice,
                                        stockQuantity);
                                Urun.beveragesList.add(beverages);
                                ur = new Urun(adi, index, weight, unitPrice, stockQuantity);
                                Urun.urun.add(ur);
                                break;
                            case 2:
                                Urun.Condiments condiments = new Urun.Condiments(adi, index, weight, unitPrice,
                                        stockQuantity);
                                Urun.condimentsList.add(condiments);
                                ur = new Urun(adi, index, weight, unitPrice, stockQuantity);
                                Urun.urun.add(ur);
                                break;
                            case 3:
                                Urun.Confections confections = new Urun.Confections(adi, index, weight, unitPrice,
                                        stockQuantity);
                                Urun.confectionsList.add(confections);
                                ur = new Urun(adi, index, weight, unitPrice, stockQuantity);
                                Urun.urun.add(ur);
                                break;
                            case 4:
                                Urun.DairyProducts dairyProducts = new Urun.DairyProducts(adi, index, weight, unitPrice,
                                        stockQuantity);
                                Urun.dairyProductsList.add(dairyProducts);
                                ur = new Urun(adi, index, weight, unitPrice, stockQuantity);
                                Urun.urun.add(ur);
                                break;
                            case 5:
                                Urun.Cereals cereals = new Urun.Cereals(adi, index, weight, unitPrice, stockQuantity);
                                Urun.cerealsList.add(cereals);
                                ur = new Urun(adi, index, weight, unitPrice, stockQuantity);
                                Urun.urun.add(ur);
                                break;
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("List Olusturdu");
                String line;

                System.out.println("Beverages:");
                for (Beverages bev : Urun.beveragesList) {
                    line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                            + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                    System.out.print(line);
                }

                System.out.println("\n");

                System.out.println("Condiments:");
                for (Condiments bev : Urun.condimentsList) {
                    line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                            + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                    System.out.print(line);
                }

                System.out.println("\n");

                System.out.println("Confections:");
                for (Confections bev : Urun.confectionsList) {
                    line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                            + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                    System.out.print(line);
                }

                System.out.println("\n");

                System.out.println("DairyProducts:");
                for (DairyProducts bev : Urun.dairyProductsList) {
                    line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                            + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                    System.out.print(line);
                }

                System.out.println("\n");

                System.out.println("Cereals:");
                for (Cereals bev : Urun.cerealsList) {
                    line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                            + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                    System.out.print(line);
                }

                System.out.println("\n");

            }

        }

        public static class DosyayaYazma {
            public static void Listeyi_Yaz() {

                try (BufferedWriter fw = new BufferedWriter(new FileWriter("Urun.txt"))) {
                    String line;
                    for (Beverages bev : Urun.beveragesList) {
                        line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                                + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                        fw.write(line);
                    }

                    for (Condiments bev : Urun.condimentsList) {
                        line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                                + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                        fw.write(line);
                    }

                    for (Confections bev : Urun.confectionsList) {
                        line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                                + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                        fw.write(line);
                    }

                    for (DairyProducts bev : Urun.dairyProductsList) {
                        line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                                + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                        fw.write(line);
                    }

                    for (Cereals bev : Urun.cerealsList) {
                        line = bev.adi + " " + bev.CatIndex + " " + bev.birimAgirligi + " "
                                + bev.birimFiyat + " " + bev.stokMiktari + "\n";
                        fw.write(line);
                    }

                    fw.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void urunStokGuncelle(String urunAdi, boolean satisMi, int adet) {
        for (Urun product : Urun.urun) {
            if (product.adi.equals(urunAdi)) {
                product.stokMiktari += satisMi ? -adet : adet;
                System.out.println("Updated stock for " + urunAdi + ": " + product.stokMiktari);
                return;
            }
        }

        System.out.println("After");
        for (Urun dairies : Urun.urun) {
            System.out.println(dairies.adi + "\t" + dairies.CatIndex + "\t" + dairies.birimAgirligi + "\t"
                    + dairies.birimFiyat + "\t" + dairies.stokMiktari);
        }

        System.out.println("Product not found.");
    }

    public void urunAdiDegistir(String eskiAdi, String yeniAdi) {
        for (Urun product : Urun.urun) {
            if (product.adi.equals(eskiAdi)) {
                product.adi = yeniAdi;
                System.out.println("Product name updated to: " + yeniAdi);
                return;
            }
        }

        System.out.println("After");
        for (Urun dairies : Urun.urun) {
            System.out.println(dairies.adi + "\t" + dairies.CatIndex + "\t" + dairies.birimAgirligi + "\t"
                    + dairies.birimFiyat + "\t" + dairies.stokMiktari);
        }

        System.out.println("Product not found.");
    }

    public static class Beverages {
        String adi;
        String birimAgirligi;
        double birimFiyat;
        int stokMiktari;
        int CatIndex;

        public Beverages() {

        }

        public Beverages(String adi, int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }

        public static void YeniUrunEkle(ArrayList<Urun> urunList, String newName, String newWeigt, double newPrice) {

            int total = 0;
            int count = 0;
            for (Beverages produBeverages : Urun.beveragesList) {
                total = total + produBeverages.stokMiktari;
                count++;
            }
            total = total / count;

            Beverages bev = new Beverages();
            bev.adi = newName;
            bev.birimAgirligi = newWeigt;
            bev.birimFiyat = newPrice;
            bev.stokMiktari = total;
            bev.CatIndex = 1;

            Urun.beveragesList.add(bev);
        }

        public static void UrunStokGuncelle(int adet, boolean GirisMi, int pos) {

            int count = 0;

            for (Beverages produBeverages : Urun.beveragesList) {

                if (count == pos - 1) {
                    if (GirisMi) {
                        produBeverages.stokMiktari = produBeverages.stokMiktari + adet;
                    } else {
                        produBeverages.stokMiktari = produBeverages.stokMiktari - adet;
                    }
                    break;
                }
                count++;
            }

        }

    }

    public static class Confections {
        String adi;
        String birimAgirligi;
        double birimFiyat;
        int stokMiktari;
        int CatIndex;

        public Confections() {

        }

        public Confections(String adi, int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }

        public static void YeniUrunEkle(ArrayList<Urun> urunList, String newName, String newWeigt, double newPrice) {

            int total = 0;
            int count = 0;
            for (Confections produBeverages : Urun.confectionsList) {
                total = total + produBeverages.stokMiktari;
                count++;
            }
            total = total / count;

            Confections bev = new Confections();
            bev.adi = newName;
            bev.birimAgirligi = newWeigt;
            bev.birimFiyat = newPrice;
            bev.stokMiktari = total;
            bev.CatIndex = 3;

            Urun.confectionsList.add(bev);
        }

        public static void UrunStokGuncelle(int adet, boolean GirisMi, int pos) {

            int count = 0;

            for (Confections produBeverages : Urun.confectionsList) {

                if (count == pos - 1) {
                    if (GirisMi) {
                        produBeverages.stokMiktari = produBeverages.stokMiktari + adet;
                    } else {
                        produBeverages.stokMiktari = produBeverages.stokMiktari - adet;
                    }
                    break;
                }
                count++;
            }

        }

    }

    public static class Condiments {
        String adi;
        String birimAgirligi;
        double birimFiyat;
        int stokMiktari;
        int CatIndex;

        public Condiments() {

        }

        public Condiments(String adi, int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }

        public static void changePrice(int pos, double newPrice) {
            int counter = 0;
            int hold = 0;
            for (Condiments product : Urun.condimentsList) {
                if (counter == (pos - 1)) {
                    hold = 1;
                    product.birimFiyat = newPrice;
                    break;
                }
                counter++;
            }

            if (hold == 0) {
                System.out.println("There is no match for the index you entered");
            }

        }

        public static void UrunFiyatGuncelle(boolean indirimMi, int pos) {
            int count = 0;
            for (Condiments produBeverages : Urun.condimentsList) {
                if (count == pos - 1) {
                    if (indirimMi) {
                        produBeverages.birimFiyat = ((100 - 20) / 100.0) * produBeverages.birimFiyat;
                    } else {
                        produBeverages.birimFiyat = ((100 + 20) / 100.0) * produBeverages.birimFiyat;
                    }
                    break;
                }
                count++;
            }

        }

    }

    public static class DairyProducts {
        String adi;
        String birimAgirligi;
        double birimFiyat;
        int stokMiktari;
        int CatIndex;

        public DairyProducts() {

        }

        public DairyProducts(String adi, int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }

        public static void changePrice(int pos, double newPrice) {
            int counter = 0;
            int hold = 0;
            for (DairyProducts product : Urun.dairyProductsList) {
                if (counter == (pos - 1)) {
                    hold = 1;
                    product.birimFiyat = newPrice;
                    break;
                }
                counter++;
            }

            if (hold == 0) {
                System.out.println("There is no match for the index you entered");
            }

        }

        public static void UrunFiyatGuncelle(boolean indirimMi, int pos) {
            int count = 0;
            for (DairyProducts produBeverages : Urun.dairyProductsList) {
                if (count == pos - 1) {
                    if (indirimMi) {
                        produBeverages.birimFiyat = ((100 - 20) / 100.0) * produBeverages.birimFiyat;
                    } else {
                        produBeverages.birimFiyat = ((100 + 20) / 100.0) * produBeverages.birimFiyat;
                    }
                    break;
                }
                count++;
            }

        }
    }

    public static class Cereals {
        String adi;
        String birimAgirligi;
        double birimFiyat;
        int stokMiktari;
        int CatIndex;

        public Cereals() {

        }

        public Cereals(String adi, int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }

        public static void EnKisaIsimliUrunIsimGuncelle(String yeniIsim) {
            int minName = Integer.MAX_VALUE;
            int i = 0;
            int pos = 0;

            for (Cereals cer : Urun.cerealsList) {
                int namelength = cer.adi.length();

                if (namelength < minName) {
                    minName = namelength;
                    pos = i;
                }

                i++;
            }

            System.out.println(pos);
            int count = 0;
            for (Cereals produBeverages : Urun.cerealsList) {
                if (count == pos) {
                    produBeverages.adi = yeniIsim;
                    break;
                }
                count++;
            }
        }

        public static void StokEnAzOlanUrunSil() {
            int minStock = Integer.MAX_VALUE;
            int i = 0;
            int pos = 0;

            for (Cereals urun : Urun.cerealsList) {
                int stockAmount = urun.stokMiktari;

                if (stockAmount < minStock) {
                    minStock = stockAmount;
                    pos = i;
                }

                i++;
            }

            System.out.println("Bunu siliyor");
            System.out.println(Urun.cerealsList.get(pos).adi + "\t" + Urun.cerealsList.get(pos).CatIndex + "\t"
                    + Urun.cerealsList.get(pos).birimAgirligi + "\t" + Urun.cerealsList.get(pos).birimFiyat + "\t"
                    + Urun.cerealsList.get(pos).stokMiktari);
                    System.out.println("\n");
            Urun.cerealsList.remove(pos);
        }

    }

    public static void main(String[] args) {
        Menu();
    }

    static void Menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean inprogress = true;
        while (inprogress) {
            System.out.println("1.ListOlustur");
            System.out.println("2.YeniUrunEkle Beverages");
            System.out.println("3.YeniUrunEkle Confections");
            System.out.println("4.UrunstokGuncelle Beverages");
            System.out.println("5.UrunstokGuncelle Confections");
            System.out.println("6.UrunFiyatGuncelle Condiments");
            System.out.println("7.UrunFiyatGuncelle Dairy");
            System.out.println("8.ChangePrice Condiments");
            System.out.println("9.ChangePrice Dairy");
            System.out.println("10.EnKisaIsimliUrunIsimGuncelle Cereals");
            System.out.println("11.StokEnAzOlanUrunSil Cereals");
            System.out.println("12.Listeyi_Yaz");
            System.out.println("0.cikis");
            System.out.println("Choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

                case 1:
                   Urun.VeriGirisiIslemleri.DosyaOkuma.ListeleriOlustur();
                    break;
                case 2:
                    System.out.println("Enter newName:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter newWeigt:");
                    String newWeigt = scanner.nextLine();
                    System.out.println("Enter newPrice:");
                    int newPrice = scanner.nextInt();
                    System.out.println("\n");

                    Urun.Beverages.YeniUrunEkle(urun, newName, newWeigt, newPrice);

                    for (Beverages part : Urun.beveragesList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    break;
                case 3:
                    System.out.println("Enter newName:");
                    newName = scanner.nextLine();
                    System.out.println("Enter newWeigt:");
                    newWeigt = scanner.nextLine();
                    System.out.println("Enter newPrice:");
                    newPrice = scanner.nextInt();
                    System.out.println("\n");

                    Urun.Confections.YeniUrunEkle(urun, newName, newWeigt, newPrice);

                    for (Confections part : Urun.confectionsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    break;

                case 4:
                    System.out.println("Enter the pos of Urun:");
                    int pos = scanner.nextInt();
                    System.out.println("Enter girismi:");
                    boolean girismi = scanner.nextBoolean();
                    System.out.println("Enter adet:");
                    int adet = scanner.nextInt();
                    Urun.Beverages.UrunStokGuncelle(adet, girismi, pos);

                    for (Beverages part : Urun.beveragesList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    break;

                case 5:

                    System.out.println("Enter the pos of Urun:");
                    pos = scanner.nextInt();
                    System.out.println("Enter girismi:");
                    girismi = scanner.nextBoolean();
                    System.out.println("Enter adet:");
                    adet = scanner.nextInt();
                    Urun.Confections.UrunStokGuncelle(adet, girismi, pos);

                    for (Confections part : Urun.confectionsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }
                    break;

                case 6:
                    System.out.println("Enter the pos of Urun:");
                    pos = scanner.nextInt();
                    System.out.println("Enter IndrimMi:");
                    boolean indirimMi = scanner.nextBoolean();
                    Urun.Condiments.UrunFiyatGuncelle(indirimMi, pos);

                    for (Condiments part : Urun.condimentsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    break;
                case 7:
                    System.out.println("Enter the pos of Urun:");
                    pos = scanner.nextInt();
                    System.out.println("Enter IndrimMi:");
                    indirimMi = scanner.nextBoolean();

                    Urun.DairyProducts.UrunFiyatGuncelle(indirimMi, pos);

                    for (DairyProducts part : Urun.dairyProductsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }
                    break;
                case 8:
                    System.out.println("Enter the pos of Urun:");
                    int N = scanner.nextInt();
                    System.out.println("Enter yeniPrice:");
                    int yeniPrice = scanner.nextInt();
                    Urun.Condiments.changePrice(N, yeniPrice);

                    for (Condiments part : Urun.condimentsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    System.out.println("\n");

                    break;
                case 9:
                    System.out.println("Enter N:");
                    N = scanner.nextInt();
                    System.out.println("Enter yeniPrice:");
                    yeniPrice = scanner.nextInt();
                    Urun.DairyProducts.changePrice(N, yeniPrice);

                    for (DairyProducts part : Urun.dairyProductsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    System.out.println("\n");
                    break;
                case 10:
                    Urun.Cereals.EnKisaIsimliUrunIsimGuncelle("Sugarrrr");

                    for (Cereals part : Urun.cerealsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }

                    System.out.println("\n");
                    break;
                case 11:
                    Urun.Cereals.StokEnAzOlanUrunSil();

                    for (Cereals part : Urun.cerealsList) {
                        System.out
                                .println(
                                        part.adi + "\t" + part.CatIndex + "\t"
                                                + part.birimAgirligi + "\t"
                                                + part.birimFiyat + "\t" + part.stokMiktari);
                    }
                    break;

                case 12:
                    Urun.VeriGirisiIslemleri.DosyayaYazma.Listeyi_Yaz();
                    break;

                case 0:
                    System.out.println("Exiting.....");
                    inprogress = false;
                    break;
            }
        }

        scanner.close();

    }
}
