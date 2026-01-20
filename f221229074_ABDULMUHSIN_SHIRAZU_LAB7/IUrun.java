import java.util.ArrayList;

public interface IUrun {

    public abstract void UrunStokGuncelle(int adet, boolean GirisMi,int pos);
    public abstract void UrunFiyatGuncelle(boolean indirimMi,int pos);
    public abstract void YeniUrunEkle(ArrayList<Urun> urunList, int pos, String newName, String newWeigt,double newPrice);

}
