import java.io.Serializable;

class Person implements Serializable {
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

class Child extends Person {
    public boolean canWalk;

    public Child(String n, int a, boolean walk) {
        super(n, a);
        canWalk = walk;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(": ");
        sb.append(canWalk ? "Walk" : "NoWalk");

        return sb.toString();
    };
};
