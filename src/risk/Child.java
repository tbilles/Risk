package risk;

public class Child extends Person {
    private static final long serialVersionUID = 1L;
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
