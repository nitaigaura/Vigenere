import java.util.Scanner;
public class Vigenere {
    static char arr [][] = new char[26][26];
    static String key = "";
    static String text = "";
    static String newKey = "";
    static String encryption = "";
    public static void printMatrix(){
        char current = 'a';
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                arr [i][j] = current;
                current++;
                if(current > 'z')
                    current = 'a';
            }
            current = (char) ('a' + i+1);
        }
    }
    static void VigenereCipher (){
        int m = -1;
        int n = -1;
        for (int k = 0; k < text.length(); k++) {
            char textChar = text.charAt(k);
            char keyChar = newKey.charAt(k);
            for (int i = 0; i < arr.length; i++) {
                if(arr[i][0] == textChar){
                    m = i;
                    break;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if(arr[0][j] == keyChar){
                    n = j;
                    break;
                }
            }
            if(m != -1 && n != -1){
                encryption += arr[m][n];
            }
        }
        System.out.println(encryption);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Text to encrypt: ");
        text = input.nextLine();
        printMatrix();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter key: ");
        key = input.nextLine();
        int keyLength = key.length();
        int textLength = text.length();
        newKey = key;
        if(keyLength>textLength){
            System.out.println("Error, text length can't be smaller than key length.");
            System.exit(0);
        }
        if (keyLength != textLength){
            int newKeyLength = textLength - keyLength;
            for (int i = 0; i < newKeyLength; i++) {
                if(i>=keyLength)
                    i=0;
                newKey += key.charAt(i);
                if(newKey.length() == textLength)
                    break;
            }
        }
        System.out.println(newKey);
        VigenereCipher();
    }
}
