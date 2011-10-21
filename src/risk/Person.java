package risk;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public String Name;
    public int Age;

    public Person(String n, int a) {
        Name = n;
        Age = a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Name);
        sb.append(": ");
        sb.append(Age);

        return sb.toString();
    }
}
