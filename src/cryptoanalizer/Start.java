package cryptoanalizer;

public class Start {
    public static void main(String[] args) {
        System.out.println("start");

        CaesarCipher caesar = new CaesarCipher();
        caesar.encoding(1);

    }
}
