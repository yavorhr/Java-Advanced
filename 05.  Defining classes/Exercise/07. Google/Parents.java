package Google;

public class Parents {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthday;
    }
}
