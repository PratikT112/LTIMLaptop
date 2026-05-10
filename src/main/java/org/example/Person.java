package org.example;

import java.util.Objects;

public class Person {
    private final String ssn;

    public Person(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(getClass() != obj.getClass()) return false;
        Person that = (Person) obj;
        return Objects.equals(this.ssn, that.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ssn);
    }
}
