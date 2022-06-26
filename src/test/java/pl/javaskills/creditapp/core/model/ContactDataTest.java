package pl.javaskills.creditapp.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactDataTest {

    @Test
    @DisplayName("should set Optional.empty correspondence address, when homeAddress is the same")
    public void test1()
    {
        //given & when
        ContactData cd = ContactData.Builder
                .create()
                .withCorrespondenceAddress(new Address("Wrocławska", "Wrocław", "50-500", "Dolnyslask", "24/5"))
                .withHomeAddress(new Address("Wrocławska", "Wrocław", "50-500", "Dolnyslask", "24/5"))
                .build();

        //then
        assertTrue(cd.getCorrespondenceAddress().isEmpty());
    }


    @Test
    @DisplayName("should set Optional.of correspondence address, when homeAddress is NOT the same")
    public void test2()
    {
        //given & when
        final Address homeAddress = new Address("Wrocławska", "Wrocław", "50-500", "Dolnyslask", "24/5");
        final Address correspondenceAddress = new Address("Wrocławska", "Kraków", "50-500", "Dolnyslask", "24/5");
        ContactData cd = ContactData.Builder
                .create()
                .withCorrespondenceAddress(correspondenceAddress)
                .withHomeAddress(homeAddress)
                .build();

        //then

        assertTrue(cd.getCorrespondenceAddress().isPresent());
        assertEquals(correspondenceAddress, cd.getCorrespondenceAddress().get());
    }
}