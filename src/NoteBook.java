import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class NoteBook implements Serializable {
    private HashMap<String,Note> notes;

    public NoteBook(HashMap<String, Note> notes) {
        this.notes = notes;
    }

}
