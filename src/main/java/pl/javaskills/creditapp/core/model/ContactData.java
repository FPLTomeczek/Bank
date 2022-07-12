package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.util.Optional;

public class ContactData {
    @NotNull
    @Regex(Constants.EMAIL_REGEX)
    private final String email;
    @NotNull
    @Regex(Constants.PHONE_NUMBER_REGEX)
    private final String phoneNumber;
    @NotNull
    private final Optional<Address> correspondenceAddress;
    @NotNull
    @ValidateObject
    private final Address homeAddress;

    private ContactData(String email, String phoneNumber,
                       Optional<Address> correspondenceAddress,
                       Address homeAddress) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.correspondenceAddress = correspondenceAddress;
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Optional<Address> getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public static class Builder{
        private String email;
        private String phoneNumber;
        private Address correspondenceAddress;
        private Address homeAddress;

        private Builder(){}

        public static Builder create() {return new Builder();}

        public Builder withEmail(String email)
        {
            this.email = email;
            return this;
        }

        public Builder withPhoneNumber(String PhoneNumber)
        {
            this.phoneNumber = PhoneNumber;
            return this;
        }

        public Builder withCorrespondenceAddress(Address correspondenceAddress)
        {
            this.correspondenceAddress = correspondenceAddress;
            return this;
        }

        public Builder withHomeAddress(Address homeAddress)
        {
            this.homeAddress = homeAddress;
            return this;
        }

        public ContactData build()
        {
            Optional<Address> correspondenceAddress = this.homeAddress.equals(this.correspondenceAddress) ?
                    Optional.empty() : Optional.ofNullable(this.correspondenceAddress);
            return new ContactData(this.email, this.phoneNumber, correspondenceAddress, this.homeAddress);
        }
    }

}
