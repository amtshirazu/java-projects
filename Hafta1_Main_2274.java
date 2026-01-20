import java.util.Scanner;


public class Hafta1_Main_2274{
    static void forward(int x, int start) {
        int[] answers = new int[30];
        answers[0] = start;
        int counter = 0;
        for (int i = (start + 1); i < x; i++) {
            int hold = 0;
            for (int j = 0; j <= counter; j++) {
                if (i % answers[j] == 0) {
                    hold = 1;
                    break;
                }
            }

            if (hold == 0) {
                counter++;
                answers[counter] = i;

                for (int k = 0; k <= counter; k++) {
                    System.out.print(answers[k] + " ");
                }
                System.out.print("\n");
            }
        }

        System.out.println("Toplam sayi adeti: " + (counter + 1));
    }

    static void backward(int x, int start) {
        int[] answers = new int[30];
        answers[0] = x;
        int counter = 0;
        for (int i = x - 2; i > start; i -= 2) {
            int hold = 0;
            for (int j = 0; j <= counter; j++) {
                if (answers[j] % i == 0) {
                    hold = 1;
                    break;
                }
            }

            if (hold == 0) {
                counter++;
                answers[counter] = i;

                for (int k = 0; k <= counter; k++) {
                    System.out.print(answers[k] + " ");
                }
                System.out.print("\n");
            }
        }

        System.out.println("Toplam sayi adeti: " + (counter + 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of X:");
        int x = scanner.nextInt();

        System.out.println("Soru 1:");
        forward(x, 3);
        
        System.out.println("Soru 2:");
        backward(x, 3);
        scanner.close();
    }
    
}