package pl.javaskills.creditapp.core.model;

public class PersonTestFactory {

    public static NaturalPerson create(int dependants, SourcesOfIncome... sourcesOfIncomes) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(Education.MIDDLE)
                .withNumOfFamilyDependants(dependants)
                .build();

        return NaturalPerson.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData( new FinanceData(sourcesOfIncomes))
                .build();
    }

    public static NaturalPerson create(MaritalStatus maritalStatus, Education education, int dependants, SourcesOfIncome... sourcesOfIncomes) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(maritalStatus)
                .withEducation(education)
                .withNumOfFamilyDependants(dependants)
                .build();

        return NaturalPerson.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(new FinanceData(sourcesOfIncomes))
                .build();
    }

    public static NaturalPerson create(MaritalStatus maritalStatus) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(maritalStatus)
                .withEducation(Education.MIDDLE)
                .withNumOfFamilyDependants(2)
                .build();

        return NaturalPerson.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static NaturalPerson create(Education education) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(education)
                .withNumOfFamilyDependants(2)
                .build();

        return NaturalPerson.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static NaturalPerson create() {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(Education.MIDDLE)
                .withNumOfFamilyDependants(2)
                .build();


        return NaturalPerson.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

        public static NaturalPerson create (double totalMonthlyIncomeInPln, int numOfDependants,
        Education education, MaritalStatus maritalStatus){
            PersonalData personalData = PersonalData.Builder.create()
                    .withName("test")
                    .withLastName("test")
                    .withMothersMaidenName("test")
                    .withMaritalStatus(maritalStatus)
                    .withEducation(education)
                    .withNumOfFamilyDependants(numOfDependants)
                    .build();

            return NaturalPerson.Builder.create()
                    .withPersonalData(personalData)
                    .withContactData(null)
                    .withFinanceData(new FinanceData(
                            new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln)))
                    .build();
        }
    }

