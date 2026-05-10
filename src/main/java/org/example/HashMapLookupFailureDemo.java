package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapLookupFailureDemo {
    static class Employee{
        private String id;      // used in equals/hashcode
        private String name;    // not used in equals/hashCode

        Employee(String id, String name) {
            this.id = id; this.name = name;
        }

        public void setId(String id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (getClass() != o.getClass()) return false;
            Employee that = (Employee) o;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Employee{id='" + id + "', name='" + name + "'}";
        }
    }

    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee e = new Employee("E101", "Pratik");

        map.put(e, "Developer"); // hashed into bucket based on id "E101"

        // ❌ Mutate the key's field used in hashCode/equals:
        e.setId("E999"); // now hashCode() and equals() produce different values

        // Lookup with the same object reference
        System.out.println("Direct get with mutated key: " + map.get(e)); // often null

        // Try finding by a logically 'equal' new key with the new id:
        Employee probeNew = new Employee("E999", "Pratik");
        System.out.println("Get with new logically equal key: " + map.get(probeNew)); // null

        // Try finding by original id:
        Employee probeOld = new Employee("E101", "Pratik");
        System.out.println("Get with old logically equal key: " + map.get(probeOld)); // null

        // But the entry is still *physically* in the map:
        System.out.println("Map size = " + map.size());
        System.out.println("Map contains original key reference? " + map.containsKey(e));
        System.out.println("Entries: " + map.entrySet());
    }
}
