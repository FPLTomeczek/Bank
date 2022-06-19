package pl.javaskills.creditapp.core.model;

public class PersonTestFactory {

    public static Person create(int dependants, SourcesOfIncome... sourcesOfIncomes) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(Education.MIDDLE)
                .withNumOfFamilyDependants(dependants)
                .build();

        return Person.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData( new FinanceData(sourcesOfIncomes))
                .build();
    }

    public static Person create(MaritalStatus maritalStatus, Education education, int dependants, SourcesOfIncome... sourcesOfIncomes) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(maritalStatus)
                .withEducation(education)
                .withNumOfFamilyDependants(dependants)
                .build();

        return Person.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData( new FinanceData(sourcesOfIncomes))
                .build();
    }

    public static Person create(MaritalStatus maritalStatus) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(maritalStatus)
                .withEducation(Education.MIDDLE)
                .withNumOfFamilyDependants(2)
                .build();

        return Person.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static Person create(Education education) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(education)
                .withNumOfFamilyDependants(2)
                .build();

        return Person.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static Person create() {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withEducation(Education.MIDDLE)
                .withNumOfFamilyDependants(2)
                .build();


        return Person.Builder.create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

        public static Person create ( double totalMonthlyIncomeInPln, int numOfDependants,
        Education education, MaritalStatus maritalStatus){
            PersonalData personalData = PersonalData.Builder.create()
                    .withName("test")
                    .withLastName("test")
                    .withMothersMaidenName("test")
                    .withMaritalStatus(maritalStatus)
                    .withEducation(education)
                    .withNumOfFamilyDependants(numOfDependants)
                    .build();

            return Person.Builder.create()
                    .withPersonalData(personalData)
                    .withContactData(null)
                    .withFinanceData(new FinanceData(
                            new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln)))
                    .build();
        }
    }

