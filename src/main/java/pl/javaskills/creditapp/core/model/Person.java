package pl.javaskills.creditapp.core.model;

public class Person {
    private PersonalData personalData;
    private ContactData contactData;

    public Person(PersonalData personalData, ContactData contactData) {
        this.personalData = personalData;
        this.contactData = contactData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }
}
