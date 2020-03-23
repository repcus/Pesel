import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("PESEL number data extractor\nEnter a PESEL number: ");
        String newPesel = keyboard.nextLine();
        Pesel pesel = new Pesel(newPesel);
        System.out.println(String.format("\tPesel: %s\n\tDate of birth: %s\n\tGender: %s", pesel.getPesel(), pesel.getBirthDate(), pesel.getGender()));
    }
}
