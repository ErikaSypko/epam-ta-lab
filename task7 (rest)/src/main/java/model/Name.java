package model;

import java.util.Objects;

public class Name {
    private String first;
    private String second;

    public Name(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Name))
            return false;
        Name n = (Name) o;
        return n.first.equals(first) && n.second.equals(second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
