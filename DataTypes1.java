/**
 *
 * @author akmal
 */
import java.util.Scanner;
import java.math.BigInteger;

public class DataTypes {
    public static void main(){
        Scanner scan = new Scanner(System.in);
        int banyakInput = scan.nextInt();
        BigInteger[] dataAngka = new BigInteger[banyakInput];
        
        for (int i = 0; i < banyakInput; i++){
            dataAngka[i] = scan.nextBigInteger();
        }
        for (int i = 0; i < banyakInput; i++) {
            BigInteger angka = dataAngka[i];
            
            if (angka.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 && angka.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0){
                System.out.println(angka + " can be fitted in:");
                System.out.println("* byte");
                System.out.println("* Short");
                System.out.println("* Integer");
                System.out.println("* Long");
            }
            else if (angka.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 && angka.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0){
                System.out.println(angka + " can be fitted in:");
                System.out.println("* Short");
                System.out.println("* Integer");
                System.out.println("* Long");
            }
            else if (angka.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 && angka.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0){
                System.out.println(angka + " can be fitted in:");
                System.out.println("* Integer");
                System.out.println("* Long");
            }
            else if (angka.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 && angka.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0){
                System.out.println(angka + " can be fitted in:");
                System.out.println("* Long");
            }
            else {
                System.out.println(angka + " can't be fitted anywhere.");
            }
        }
    }
}