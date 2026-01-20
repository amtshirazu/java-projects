import java.util.ArrayList;

public class DairyProducts extends Urun {

    public DairyProducts(String name, int categoryIndex, String unitWeight, double unitPrice, int stockQuantity) {
        super(name, categoryIndex, unitWeight, unitPrice, stockQuantity);
    }

    public static void filterDiaryProduct(ArrayList<DairyProducts> dairyProducts, int min, int max){
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
}

