package pl.javaskills.creditapp.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.util.AgeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("Family members should be sorted by age desc")
    public void test1(){

        //given
        final FamilyMember familyMember1 = new FamilyMember("John", AgeUtils.generateBirthDate(18));
        final FamilyMember familyMember2 = new FamilyMember("Jane", AgeUtils.generateBirthDate(5));
        final FamilyMember familyMember3 = new FamilyMember("Jarret", AgeUtils.generateBirthDate(40));
        List<FamilyMember> familyMemberList = Arrays.asList(familyMember1,familyMember2,familyMember3);

        //when
        Person person = NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .build();

        //then
        assertNotNull(person.getFamilyMembers());
        assertTrue(person.getFamilyMembers().size()==3);
        assertEquals(familyMember3, person.getFamilyMembers().get(0));
        assertEquals(familyMember1, person.getFamilyMembers().get(1));
        assertEquals(familyMember2, person.getFamilyMembers().get(2));

    }

}