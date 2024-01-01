public class Child {
    private String name;
    private String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Child setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public Child setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", getName(),getBirthday());
    }
}
