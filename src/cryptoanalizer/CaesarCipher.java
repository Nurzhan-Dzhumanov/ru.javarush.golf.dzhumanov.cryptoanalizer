package cryptoanalizer;

import java.io.*;

public class CaesarCipher {
    static final String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    private static char cipher(char symbol, int key) {
        if (RU_ALPHABET.indexOf(symbol) != -1) {
            return RU_ALPHABET.charAt((RU_ALPHABET.indexOf(symbol) + key) % RU_ALPHABET.length());
        } else return symbol;
    }

    private static char decipher(char symbol, int key) {
        if (RU_ALPHABET.indexOf(symbol) != -1) {
            int index = (RU_ALPHABET.indexOf(symbol) - key) % RU_ALPHABET.length();
            if (index < 0) {
                index = RU_ALPHABET.length() + index;
            }
            return RU_ALPHABET.charAt(index);
        } else return symbol;
    }


    public void encoding(String Path, int Key) {
        try (FileReader fileReader = new FileReader(Path);
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             FileWriter fileWriter = new FileWriter("src/files/encrypted-file.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {


            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine().toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    bufferedWriter.write(cipher(line.charAt(i), Key));
                }
                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }


    public void decoding(String Path, int Key) {
        try (FileReader fileReader = new FileReader(Path);
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             FileWriter fileWriter = new FileWriter("src/files/decrypted-file.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {


            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine().toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    bufferedWriter.write(decipher(line.charAt(i), Key));
                }
                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    public void methodBruteForce(String Path) {
        try (FileReader fileReader = new FileReader(Path);
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             FileWriter fileWriter = new FileWriter("src/files/bruteforce-file.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line = bufferedReader.readLine().toLowerCase();
            for (int i = 0; i < RU_ALPHABET.length(); i++) {
                bufferedWriter.write("Ключ "+ i + ": ");
                for (int j = 0; j < line.length(); j++) {
                    bufferedWriter.write(decipher(line.charAt(j), i));
                }
                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
