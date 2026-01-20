import java.util.ArrayList;

public class Beverages extends Urun implements IUrun {

    public Beverages() {

    }

    public Beverages(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super(name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }

    public void EnKisaIsimliUrunIsimGuncelle(String yeniIsim) {
        int minName = Integer.MAX_VALUE;
        int i = 0;
        int pos = 0;

        for (Beverages bev : Main_2274.beverages) {
            int namelength = bev.getName().length();

            if (namelength < minName) {
                minName = namelength;
                pos = i;
            }

            i++;
        }

        for (Beverages produBeverages : Main_2274.beverages) {
            int count = 0;
            if (count == pos) {
                produBeverages.name = yeniIsim;
                break;
            }
        }

    }


    public void YeniUrunEkle(ArrayList<Urun> urunList, int pos, String newName, String newWeigt,
            double newPrice) {

                int total = 0;
                int count = 0;
        for (Beverages produBeverages : Main_2274.beverages) {
            total = total + produBeverages.getStockQuantity(); 
            count++;
        }
        total = total / count;

        Beverages bev = new Beverages();
        bev.name = newName;
        bev.weight = newWeigt;
        bev.unitPrice = newPrice;
        bev.stockQuantity = total;
        bev.categoryIndex = 1;

        Main_2274.beverages.add(bev);

        return ;
    }

    public void UrunStokGuncelle(int adet, boolean GirisMi, int pos) {

        adet += 10;
        int count = 0;

        for (Beverages produBeverages : Main_2274.beverages) {

            if (count == pos - 1) {
                if (GirisMi) {
                    produBeverages.stockQuantity = produBeverages.getStockQuantity() + adet;
                } else {
                    produBeverages.stockQuantity = produBeverages.getStockQuantity() - adet;
                }
                break;
            }
            count++;
        }

    }

    public void UrunFiyatGuncelle(boolean indirimMi, int pos) {

        int count = 0;

        for (Beverages produBeverages : Main_2274.beverages) {

            if (count == pos - 1) {
                if (indirimMi) {
                    produBeverages.unitPrice = ((100 - 10) / 100) * produBeverages.getUnitPrice();
                } else {
                    produBeverages.unitPrice = ((100 + 10) / 100) * produBeverages.getUnitPrice();
                }
                break;
            }
            count++;
        }

    }

   
    public  void StokEnAzOlanUrunSil(){
        int minName = Integer.MAX_VALUE;
        int i = 0;
        int pos = 0;

        for (Beverages bev : Main_2274.beverages) {
            int namelength = bev.getStockQuantity();

            if (namelength < minName) {
                minName = namelength;
                pos = i;
            }

            i++;
        }

        Main_2274.beverages.remove(pos);


    }
}
