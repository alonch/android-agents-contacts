package arsp.com.helloworld;

/**
 * Created by alonch on 12/03/15.
 */
public class Agent {
    private int id;
    private String first;
    private String last;
    private String mail;
    private String phone;
    private String address;

    public Agent(int id, String first, String last, String mail, String phone, String address) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return last + ", "+first;
    }
}
