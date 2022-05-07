package cryptoanalizer;

import java.util.Scanner;

public class Start {

    public static Scanner scan = new Scanner(System.in);
    public static CaesarCipher caesar = new CaesarCipher();

    public static void main(String[] args) {

        printMenu();
        printChooseMenu();

    }

    private static void printMenu () {
        System.out.println("Добро пожаловать в Криптоанализатор! \nЧто вы хотите сделать? ");
        System.out.println("1: Зашифровать данные!\n2: Расшифровать данные!");
        System.out.println("3: Расшифровать данные методом \"brute force\"!");
        System.out.print("4: Выход!\nВыберите действия: ");
    }

    private static void printChooseMenu() {
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                System.out.print("Введите путь к файлу: ");
                String path = scan.next();
                System.out.print("Введите ключ: ");
                int key = scan.nextInt();
                caesar.encoding(path, key);
                System.out.println("Ваш зашифрованный файл находится в: src/files/encrypted-file.txt");
                break;
            case 2:
                System.out.print("Введите путь к файлу: ");
                String path2 = scan.next();
                System.out.print("Введите ключ: ");
                int key2 = scan.nextInt();
                caesar.decoding(path2, key2);
                System.out.println("Ваш расшифрованный файл находится в: src/files/decrypted-file.txt");
                break;
            case 3:
                System.out.print("Введите путь к файлу: ");
                String path3 = scan.next();
                caesar.methodBruteForce(path3);
                System.out.println("Ваш расшифрованный файл находится в: src/files/bruteforce-file.txt");
                break;
            case 4:
                System.out.println("До свиданья!");
                break;
            default:
                System.out.println("Вы ввели некорретную цифру.");
        }
    }
}
