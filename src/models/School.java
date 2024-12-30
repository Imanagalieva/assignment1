package models;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public Iterable<Person> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : members) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }
}
