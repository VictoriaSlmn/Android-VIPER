package victoriaslmn.android.viper.sample.domain.note.list;

import victoriaslmn.android.viper.sample.domain.mark.MarkColor;

public class Note {
    private final Integer id;
    private final MarkColor color;
    private final String title;

    public Note(Integer id, MarkColor color, String title) {
        this.id = id;
        this.color = color;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public MarkColor getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }
}
