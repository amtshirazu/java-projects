import java.util.ArrayList;

public class Condiments extends Urun implements IUrun{
    public Condiments(){
        
    }
    
    public Condiments(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity){
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }


     public void EnKisaIsimliUrunIsimGuncelle(String yeniIsim){
        int minName = Integer.MAX_VALUE;
        int i = 0;
        int pos = 0;

        for (Condiments bev : Main_2274.condiments) {
            int namelength = bev.getName().length();

            if(namelength < minName){
                minName = namelength;
                pos = i;
            }

            i++;
        }


        int count = 0;
        for (Condiments produBeverages : Main_2274.condiments) {
            if (count == pos) {
               produBeverages.name = yeniIsim;
               break;
            }
            count++;
       }


     }


    public void YeniUrunEkle(ArrayList<Urun> urunList, int pos, String newName, String newWeigt,
            double newPrice) {

                int total = 0;
                int count = 0;
        for (Condiments produBeverages : Main_2274.condiments) {
            total = total + produBeverages.getStockQuantity(); 
            count++;
        }
        total = total / count;

        Condiments bev = new Condiments();
        bev.name = newName;
        bev.weight = newWeigt;
        bev.unitPrice = newPrice;
        bev.stockQuantity = total;
        bev.categoryIndex = 1;

        Main_2274.condiments.add(bev);

        return ;
    }


    public void UrunStokGuncelle(int adet, boolean GirisMi, int pos) {
        int count = 0;

        for (Condiments produBeverages : Main_2274.condiments) {

            if (count == pos - 1) {
                if (GirisMi && produBeverages.getStockQuantity() < 10) {
                    produBeverages.stockQuantity = produBeverages.getStockQuantity() + adet;
                } else if(!GirisMi && produBeverages.getStockQuantity() > 10){
                    produBeverages.stockQuantity = produBeverages.getStockQuantity() - adet;
                }
                break;
            }
            count++;
        }

    }

    public void UrunFiyatGuncelle(boolean indirimMi, int pos) {

        int count = 0;

        for (Condiments produBeverages : Main_2274.condiments) {

            if (count == pos - 1) {
                if (indirimMi) {
                    produBeverages.unitPrice = ((100 - 20) / 100) * produBeverages.getUnitPrice();
                } else {
                    produBeverages.unitPrice = ((100 + 20) / 100) * produBeverages.getUnitPrice();
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

        for (Condiments bev : Main_2274.condiments) {
            int namelength = bev.getStockQuantity();

            if (namelength < minName) {
                minName = namelength;
                pos = i;
            }

            i++;
        }

        Main_2274.condiments.remove(pos);
    }

    
}
