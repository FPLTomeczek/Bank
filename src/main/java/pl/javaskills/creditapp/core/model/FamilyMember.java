package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;

import java.time.LocalDate;
import java.time.Period;

public class FamilyMember implements Comparable<FamilyMember>{
    @NotNull
    private final String name;
    @NotNull
    private final LocalDate birthDate;

    public FamilyMember(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(FamilyMember o) {
        return o.birthDate.compareTo(this.birthDate);
    }
}
