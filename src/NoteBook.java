import java.io.*;
import java.util.HashMap;

public class NoteBook implements Serializable {
    private final HashMap<String,Note> notes = new HashMap<>();

    public void showNotes() {
        int ind = 1;
        NoteBook noteBook = readFromFile("notebook.ser");
        if(noteBook == null) System.out.println("note book not found");
        for (Note note: noteBook.notes.values()) {
            System.out.println(ind++ + "- " + note.getTitle() + "\t" + note.getDate().toString());
        }
    }

    public void showNote(String title) {
        if(notes.containsKey(title)) {
            System.out.println(title + "\n" + notes.get(title).getText() + "\n");
            return;
        }
        System.out.println("not found.");
    }

    public void export(String title) {
        NoteBook noteBook = readFromFile("notebook.ser");
        if(noteBook == null) return;
        try (FileWriter export = new FileWriter(title)){
            export.write(title + "\n" + noteBook.notes.get(title).getDate() + noteBook.notes.get(title).getText() + "\n");
        }catch (IOException e) {e.printStackTrace();}
    }
    public void addNote(Note note) {notes.put(note.getTitle(), note);}
    public void removeNote(String title) {notes.remove(title);}

    public static NoteBook readFromFile(String fileNmae) {
        try(FileInputStream fIn = new FileInputStream(fileNmae); ObjectInputStream in = new ObjectInputStream(fIn)) {
            return (NoteBook) in.readObject();
        }catch (FileNotFoundException e) {
            System.out.println("file not found.");
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
