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
    public static ArrayList<DairyProducts> dairyProductsList = new ArrayList<>();
    public static ArrayList<Cereals> cerealsList = new ArrayList<>();
    public static ArrayList<Urun> urun = new ArrayList<>();

    public static class VeriGirisiIslemleri {
        public static class ListeleriOlusturma {
            public static void ListeleriOlustur() {
                try (BufferedReader br = new BufferedReader(new FileReader("urunler.txt"))) {

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
                                Urun.DairyProducts dairyProducts = new Urun.DairyProducts(adi, index, weight, unitPrice,
                                        stockQuantity);
                                Urun.dairyProductsList.add(dairyProducts);
                                ur = new Urun(adi, index, weight, unitPrice, stockQuantity);
                                Urun.urun.add(ur);
                                break;
                            case 3:
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
        for (Urun product :Urun.urun) {
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

        public static void IcecekUrunuEkle(String Adi, String BirimAgirligi, double BirimFiyati, int StokMiktari) {

            Beverages bev = new Beverages();
            bev.adi = Adi;
            bev.birimAgirligi = BirimAgirligi;
            bev.birimFiyat = BirimFiyati;
            bev.stokMiktari = StokMiktari;
            bev.CatIndex = 1;

            Urun.beveragesList.add(bev);

            System.out.println("After");
            for (Beverages dairies : Urun.beveragesList) {
                System.out.println(dairies.adi + "\t" + dairies.CatIndex + "\t" + dairies.birimAgirligi + "\t"
                        + dairies.birimFiyat + "\t" + dairies.stokMiktari);
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
 
        public DairyProducts (String adi,int CatIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }

        public static void sutUrunuSil() {
            double averagePrice= 0.0;
            int count = 0;
            System.out.println("Before");
            for (DairyProducts dairies : Urun.dairyProductsList) {
                System.out.println(dairies.adi + "\t"  + dairies.CatIndex + "\t"+  dairies.birimAgirligi + "\t" + dairies.birimFiyat + "\t" + dairies.stokMiktari );
                averagePrice = averagePrice + dairies.birimFiyat;
                count++;
            }
            averagePrice = averagePrice/count;

            System.out.println("\n");

            for (DairyProducts dairies : Urun.dairyProductsList) {
                if(dairies.birimFiyat > averagePrice){
                    Urun.dairyProductsList.remove(dairies);
                }
            }

            System.out.println("After");
            for (DairyProducts dairies : Urun.dairyProductsList) {
                    System.out.println(dairies.adi + "\t"  + dairies.CatIndex + "\t"+  dairies.birimAgirligi + "\t" + dairies.birimFiyat + "\t" + dairies.stokMiktari );
        }
        System.out.println("\n");
    }

    

    public static class Cereals {
        String adi;
        double birimAgirligi;
        double birimFiyat;
        int stokMiktari;
        int CatIndex;

        public Cereals () {
            
        }

        public Cereals (String adi, int CatIndex, double birimAgirligi, double birimFiyati, int stokMiktari) {
            this.adi = adi;
            this.birimAgirligi = birimAgirligi;
            this.birimFiyat = birimFiyati;
            this.stokMiktari = stokMiktari;
            this.CatIndex = CatIndex;
        }


        public static void TahilMinStokEkle(int miktar){
                Cereals minStockProduct = Urun.cerealsList.stream().min(Comparator.comparingInt(p -> p.stokMiktari)).orElse(null);
                if (minStockProduct != null) {
                    minStockProduct.stokMiktari += miktar;
                    System.out.println("Added stock to: " + minStockProduct);
                } else {
                    System.out.println("No cereals found to add stock.");
                }

                System.out.println("After");
            for (Cereals dairies : Urun.cerealsList) {
                    System.out.println(dairies.adi + "\t"  + dairies.CatIndex + "\t"+  dairies.birimAgirligi + "\t" + dairies.birimFiyat + "\t" + dairies.stokMiktari );
            }
        }

       
    }

   
    public static void main(String[] args) {
        Urun.VeriGirisiIslemleri.ListeleriOlusturma.ListeleriOlustur();
        Urun.Beverages.IcecekUrunuEkle("Cola", "200bags",5000, 30);
        Urun.DairyProducts.sutUrunuSil();
        Urun.Cereals.TahilMinStokEkle(5000);
        Urun urun = new Urun();
        urun.urunStokGuncelle("Kahve", false, 30);
        urun.urunAdiDegistir("Cay", "Sugar");
    }

}
