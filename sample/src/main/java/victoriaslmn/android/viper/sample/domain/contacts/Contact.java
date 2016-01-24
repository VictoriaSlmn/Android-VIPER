package victoriaslmn.android.viper.sample.domain.contacts;

public class Contact {
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
