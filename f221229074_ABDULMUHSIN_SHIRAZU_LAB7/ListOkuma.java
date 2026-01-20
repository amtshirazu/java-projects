import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListOkuma {

    protected static void ListeOlustur(String filename) {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

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
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void callList(String filename){
        ListeOlustur(filename);
    }
}
