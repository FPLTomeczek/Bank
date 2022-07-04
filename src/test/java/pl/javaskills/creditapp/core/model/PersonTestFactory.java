package pl.javaskills.creditapp.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTestFactory {
    private static List<FamilyMember> getFamilyMemberList(int dependants) {
        List<FamilyMember> familyMemberList = new ArrayList<>();

        for (int i = 0; i< dependants-1; i++)
        {
            familyMemberList.add(new FamilyMember("John",18));
        }
        return familyMemberList;
    }


    public static NaturalPerson create(int dependants, SourcesOfIncome... sourcesOfIncomes) {

        List<FamilyMember> familyMemberList = getFamilyMemberList(dependants);
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(Education.MIDDLE)
                .build();

        return NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData( new FinanceData(Arrays.asList(sourcesOfIncomes)))
                .build();
    }


    public static NaturalPerson create(MaritalStatus maritalStatus, Education education, int dependants, SourcesOfIncome... sourcesOfIncomes) {
        List<FamilyMember> familyMemberList = getFamilyMemberList(dependants);
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(maritalStatus)
                .withEducation(education)
                .build();

        return NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(new FinanceData(Arrays.asList(sourcesOfIncomes)))
                .build();
    }

    public static NaturalPerson create(MaritalStatus maritalStatus) {
        List<FamilyMember> familyMemberList = Arrays.asList(new FamilyMember("John",18),
                new FamilyMember("Jane",20));
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(maritalStatus)
                .withEducation(Education.MIDDLE)
                .build();

        return NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static NaturalPerson create(Education education) {
        List<FamilyMember> familyMemberList = Arrays.asList(new FamilyMember("John",18),
                new FamilyMember("Jane",20));
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(education)
                .build();

        return NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static NaturalPerson create() {
        List<FamilyMember> familyMemberList = Arrays.asList(new FamilyMember("John",18),
                new FamilyMember("Jane",20));
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(Education.MIDDLE)
                .build();


        return NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

        public static NaturalPerson create (double totalMonthlyIncomeInPln, int numOfDependants,
        Education education, MaritalStatus maritalStatus){
            List<FamilyMember> familyMemberList = getFamilyMemberList(numOfDependants);
            PersonalData personalData = PersonalData.Builder.create()
                    .withName("test")
                    .withLastName("test")
                    .withMothersMaidenName("test")
                    .withMaritalStatus(maritalStatus)
                    .withEducation(education)
                    .build();

            return NaturalPerson.Builder.create()
                    .withFamilyMembers(familyMemberList)
                    .withPersonalData(personalData)
                    .withContactData(null)
                    .withFinanceData(new FinanceData(Arrays.asList(
                            new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln))))
                    .build();
        }
    }

