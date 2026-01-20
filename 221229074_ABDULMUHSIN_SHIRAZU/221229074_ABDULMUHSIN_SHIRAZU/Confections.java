import java.util.ArrayList;

public class Confections extends Urun {
    
    public Confections(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity){
        super( name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }

    public static ArrayList<Confections>  changeData(ArrayList<Confections> confections,String name,String newName,String newWeigt,double newPrice,int newstokMiktar){

        for (Confections product : confections) {
            if(product.name.equals(name)){
                product.name = newName;
                product.weight = newWeigt;
                product.unitPrice = newPrice;
                product.stockQuantity = newstokMiktar;
                break;
            }
        }

        return confections;
    }
}
