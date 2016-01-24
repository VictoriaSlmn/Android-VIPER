package victoriaslmn.android.viper.sample.domain.messages;

import victoriaslmn.android.viper.sample.domain.contacts.Contact;

public class Message {
    private final int id;
    private final Contact contact;
    private final String content;
    private final long timestamp;

    public Message(int id, Contact contact, String content, long timestamp) {
        this.id = id;
        this.contact = contact;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
