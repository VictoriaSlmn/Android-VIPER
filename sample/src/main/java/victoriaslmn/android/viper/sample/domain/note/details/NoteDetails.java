package victoriaslmn.android.viper.sample.domain.note.details;

import victoriaslmn.android.viper.sample.domain.mark.MarkColor;
import victoriaslmn.android.viper.sample.domain.note.list.Note;

public class NoteDetails extends Note {
    private final String content;

    public NoteDetails(Integer id, MarkColor color, String title, String content) {
        super(id, color, title);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
