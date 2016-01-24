package victoriaslmn.android.viper.sample.domain.contacts;

import java.io.Serializable;

public class Contact implements Serializable {
    public static final int SAMPLE_MAX_CONTACT_COUNT = 10;
    private final int id;
    private final String name;

    public Contact(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Contact message = (Contact) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
