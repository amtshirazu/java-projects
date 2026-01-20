import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TumSiniflar22_074 {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			boolean inProgress = true;
			String sentence = "";
			while (inProgress) {
				System.out.println("Menu: ");
				System.out.println("1.Yeni metin giriniz");
				System.out.println("2.Kelimeler kac kez ");
				System.out.println("3.Kac cumle var ");
				System.out.println("4.Her bir cumledeki ilk ve son kelimeleri cumle uzerinde yer degistiriniz.");
				System.out.println("0.Exit" + "\n");
				System.out.println("Choose: ");
				int choice = scanner.nextInt();
				scanner.nextLine();// consume the line following it

				switch (choice) {
				case 1:
					System.out.println("Enter metin :");
					sentence = scanner.nextLine();
					break;

				case 2:
					if (!sentence.isEmpty()) {
						wordCount(sentence); // Call word count method
					} else {
						System.out.println("Enter the text first.");
					}
					break;

				case 3:
					if (!sentence.isEmpty()) {
						sentenceCount(sentence); // Call word count method
					} else {
						System.out.println("Enter the text first.");
					}
					break;

				case 4:
					if (!sentence.isEmpty()) {
						changeFirstAndLast(sentence); // Call new Sentece method
					} else {
						System.out.println("Enter the text first.");
					}
					break;

				case 0:
					System.out.println("Exiting");
					inProgress = false;
					break;

				default:
					System.out.println("wrong choice!");
				}
			}

			scanner.close();
		}

		// functions

		static void sentenceCount(String sentence) {
			String Sentences[] = sentence.split("\\.");
			System.out.println("Number of sentences:" + Sentences.length);

			for (String sent : Sentences) {
				System.out.println(sent);
			}

		}

		static void wordCount(String sentence) {
			ArrayList<String> Word = new ArrayList<String>(); // for holding words wihtout repeating them
			ArrayList<Integer> wordAmount = new ArrayList<Integer>(); // keeping count of word repeatition
			String WordArray[] = sentence.toLowerCase().split("[\\s\\.]+"); // for splitting sentence into words

			// finding number of times a word is repeated
			for (String word : WordArray) {
				int pos = Word.indexOf(word); // index of words

				if (pos == -1) {
					Word.add(word);
					wordAmount.add(1);
				} else if (pos != -1) {
					wordAmount.set(pos, wordAmount.get(pos) + 1);
				}
			}

			for (String string : Word) {
				System.out.println(string);// debugging
			}

			System.out.println("Number of different words:" + Word.size());// debugging

			for (int i = 0; i < Word.size(); i++) {
				System.out.println(Word.get(i) + ": " + wordAmount.get(i));
			}

			int mostOccuring = wordAmount.size();
			int most = 1;
			for (int i = 0; i < wordAmount.size(); i++) {
				int count = 0;

				for (int j = 0; j < wordAmount.size(); j++) {

					if (wordAmount.get(i) >= wordAmount.get(j)) {
						count++;
					}

				}

				if (count == mostOccuring && most < 4) {
					System.out.println("Most occuring word " + most);
					System.out.println(Word.get(i) + ": " + wordAmount.get(i));
					mostOccuring--;
					most++;
				}

			}

		}

		static void changeFirstAndLast(String sentence) {
			String Sentences[] = sentence.split("\\.");

			for (int i = 0; i < Sentences.length; i++) {
				String[] words = Sentences[i].split("\\s+");

				String temp = words[0];
				words[0] = words[(words.length) - 1];
				words[(words.length) - 1] = temp;

				char ch1 = words[0].charAt(0);// for fist word
				ch1 = Character.toUpperCase(ch1);
				words[0] = ch1 + words[0].substring(1);

				char ch2 = words[(words.length) - 1].charAt(0);// for last word
				ch2 = Character.toLowerCase(ch2);
				words[(words.length) - 1] = ch2 + words[(words.length) - 1].substring(1);

				Sentences[i] = String.join(" ", words) + ".";
			}

			String newSentence = String.join("", Sentences);

			System.out.println(newSentence);

		}

}
