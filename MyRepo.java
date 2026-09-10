import java.util.Scanner;

public class MyRepo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String surname = input.nextLine();
        System.out.println(name + surname);
        input.close();
    }
}