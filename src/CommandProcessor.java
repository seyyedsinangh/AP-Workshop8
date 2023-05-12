import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CommandProcessor {
    private NoteBook noteBook;
    private static Scanner scanner = new Scanner(System.in);

    public CommandProcessor() {
        initializeNoteBook();
    }
    
    public void runCommandLoop() {
        int command = 0;
        while(command != 5) {
            try {
                showMenu();
                command = Integer.parseInt(scanner.nextLine());
                switch (command) {
                    case 1:
                        addNote();
                        break;
                    case 2:
                        removeNote();
                        break;
                    case 3:
                        showNote();
                        break;
                    case 4:
                        export();
                        break;
                    case 5:
                        System.out.println("Goodluck :)");
                        return;
                    default:
                        System.out.println("Enter number in range!");
                }
            }catch (NumberFormatException e) {
                System.out.println("please enter a number");
            }
        }
    }

    private void initializeNoteBook() {
        File noteBookFile = new File("notebook.ser");
        if(noteBookFile.exists()) {
            try(FileInputStream fIn = new FileInputStream("notebook.ser"); ObjectInputStream in = new ObjectInputStream(fIn)) {
                noteBook = (NoteBook) in.readObject();
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        else noteBook = new NoteBook();
    }
    
    private void showMenu() {System.out.println("1.Add\n2.Remove\n3.Notes\n4.Export\n5.Exit");}

    private String getText() {
        StringBuilder lines = new StringBuilder();
        String line = "";
        System.out.println("Enter your text (enter # to finish): ");
        while (true) {
            line = scanner.nextLine();
            if(line.equals("#")) break;
            lines.append("\n" + line);
        }

        return lines.toString();
    }


    private void addNote() {
        System.out.println("Enter your title or enter return to get back:\n");
        String title = scanner.nextLine();

        if (!title.equals("return")) {
            String text = getText();
            Note note = new Note(title, text);
            noteBook.addNote(note);

            try(FileOutputStream fOut = new FileOutputStream("notebook.ser"); ObjectOutputStream out = new ObjectOutputStream(fOut)) {
                out.writeObject(noteBook);
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeNote() {
        noteBook.showNotes();

        System.out.println("choose one of the notes and enter the title, or enter return to get back to main menu.");
        String command = scanner.nextLine();

        if(!command.equals("return")) {
            try(FileOutputStream fOut = new FileOutputStream("notebook.ser"); ObjectOutputStream out = new ObjectOutputStream(fOut)) {
                noteBook.removeNote(command);
                out.writeObject(noteBook);
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showNote() {
        noteBook.showNotes();

        System.out.println("choose one of the notes and enter the title, or enter return to get back to main menu.");
        String noteToRemove = scanner.nextLine();

        if(!noteToRemove.equals("return")) {
            noteBook.showNote(noteToRemove);
        }
    }

    private void export() {
        System.out.println("choose a note to export: \n");
        noteBook.showNotes();

        System.out.println("choose one of the notes and enter the title, or enter return to get back to main menu.");
        String toExport = scanner.nextLine();
        if(!toExport.equals("return")) {
            noteBook.export(toExport);
        }
    }

}
