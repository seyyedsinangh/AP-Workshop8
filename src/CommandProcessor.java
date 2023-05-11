import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CommandProcessor {
    private static HashMap<String,Note> notes;

    public CommandProcessor() {
        this.notes = new HashMap<>();
    }
    public static void process() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add\n2.Remove\n3.Notes\n4.Export\n5.Exit\n>>");
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

    private void addNote() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your title or enter return to get back:\n>>");
        String title = sc.next();
        switch (title) {
            case "return":
                return;
            default:
                ArrayList<String> lines = new ArrayList<>();
                System.out.println("Enter your text (enter # to finish):>>");
                while (true) {
                    String line = sc.next();
                    if (line.equals("#")) break;
                    lines.add(line);
                }
                String text = "";
                for (String line: lines) {
                    text += line;
                }
                Note note = new Note(title,text);
                try {
                    FileOutputStream fOut = null;
                    try {
                        fOut = new FileOutputStream("notebook.bin");
                    } catch (IOException e) {
                        FileInputStream fIn = new FileInputStream("notebook.bin");
                        fIn.close();
                        fOut = new FileOutputStream("notebook.bin");
                    }
                    ObjectOutputStream out = new ObjectOutputStream(fOut);
                    out.close();
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
