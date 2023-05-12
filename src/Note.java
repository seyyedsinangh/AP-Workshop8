import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {
    private final String title;
    private final String text;
    private final LocalDate date;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
        this.date = LocalDate.now();
    }

    public String getTitle() {return title;}

    public String getText() {return text;}

    public LocalDate getDate() {return date;}
}
