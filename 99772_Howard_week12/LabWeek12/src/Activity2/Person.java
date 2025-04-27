package Activity2;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1;
    private String name;
    private int age;
    private String campus;

    public Person(String name, int age, String campus) {
        this.name = name;
        this.age = age;
        this.campus = campus;
    }
    @Override
    public String toString() {
        return "Person{name= '" + getName() + "', age=" + getAge() + ", campus='" + getCampus() + "'}";
    }
    
    public String getName() {
        return this.name;
    }

    public void setAge(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public String getCampus() {
        return this.campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

}
