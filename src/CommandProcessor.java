import java.util.Scanner;

public class CommandProcessor {
    public static void process() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add\n2.Remove\n3.Notes\n4.Export\n5.Exit");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1:
                        
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        System.out.println("Goodluck :)");
                        return;
                    default:
                        System.out.println("Enter number in range!");
                }
            } catch (Exception e) {
                System.out.println("Enter input like human!");
            }
        }
    }
}
