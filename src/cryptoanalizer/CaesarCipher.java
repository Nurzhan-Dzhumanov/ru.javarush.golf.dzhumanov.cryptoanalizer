package cryptoanalizer;

import java.io.*;
import java.util.Scanner;

public class CaesarCipher {
    static final String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    static char cipher(char symbol, int key) {
        if (RU_ALPHABET.indexOf(symbol) != -1) {
            return RU_ALPHABET.charAt((RU_ALPHABET.indexOf(symbol) + key) % RU_ALPHABET.length());
        } else return symbol;
    }


    public void encoding(int Key) {
        try (Scanner scan = new Scanner(System.in);

             FileReader fileReader = new FileReader(scan.nextLine());
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             FileWriter fileWriter = new FileWriter("src/files/encrypted file.txt");
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


    public void decoding(int Key) {

    }
}
