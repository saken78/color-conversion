import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String userChc;
        Scanner userInp = new Scanner(System.in);
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            clearScreen();
            System.out.println("\n");
            System.out.println("COLOR CONVERSION");
            System.out.println("\n=============");
            System.out.println("1. HEX TO RGB");
            System.out.println("=============");
            System.out.println("=============");
            System.out.println("2. RGB TO HEX");
            System.out.println("=============");
            System.out.print("\n\nPilihan anda: ");

            userChc = userInp.next();

            switch (userChc) {
                case "1":
                    System.out.print("\nHEX = ");
                    String hexCl = userInp.next();
                    rgb(hexCl);
                    break;

                case "2":
                    System.out.println("RGB <= 255");
                    System.out.print("RED = ");
                    int r = userInp.nextInt();
                    System.out.print("GREEN = ");
                    int g = userInp.nextInt();
                    System.out.print("BLUE = ");
                    int b = userInp.nextInt();
                    hex(r, g, b);
                    break;

                default:
                    System.err.println("INDEX ERROR ");
            }
            isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan");
        }
    }
    private static void rgb (String hex) throws IOException{
        hex = hex;
        hex = hex.replace("#", "");

        // System.out.println(hex.length()); i just wnt to know the length , ignore it if you dont use

        String red = hex.substring(0, 2);
        String green = hex.substring(2, 4);
        String blue = hex.substring(4, 6);
        int r = Integer.parseInt(red, 16);   // "1E" → 30    // int method to convert string to int
        int g = Integer.parseInt(green, 16); // "90" → 144
        int b = Integer.parseInt(blue, 16);  // "FF" → 255

        System.out.printf("RGB = %d,%d,%d",r ,g, b);

    }
    private static boolean getYesorNo(String message){
        Scanner userInp = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihanUser = userInp.next();

        while(!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihanUser = userInp.next();
        }

        return pilihanUser.equalsIgnoreCase("y");

    }
    private static void hex (int r, int g, int b) throws IOException {
        String hex = "123, 120, 124";
        System.out.println(hex.length());
        String rgb = String.format("#%02X%02X%02X", r, g, b);
        System.out.println("HEX = " + rgb);


    }
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("tidak bisa clear screen");
        }
    }
}


// isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan");
