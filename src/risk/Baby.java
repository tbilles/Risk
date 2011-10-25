package risk;

public class Baby extends Child {
    private static final long serialVersionUID = 1L;
    public boolean criesOverNight;

    public Baby(String n, int a, boolean walk, boolean cries) {
        super(n, a, walk);
        criesOverNight = cries;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(": ");
        sb.append(criesOverNight ? "Cries" : "DoesntCry");

        return sb.toString();
    };
};
