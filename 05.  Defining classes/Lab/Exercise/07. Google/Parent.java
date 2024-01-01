public class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthDay) {
        this.name = name;
        this.birthday = birthDay;
    }

    public String getName() {
        return name;
    }

    public Parent setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public Parent setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", getName(),getBirthday());
    }
}
