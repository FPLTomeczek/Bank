package pl.javaskills.creditapp.core.model;

public class PersonalData {
    private String name;
    private String lastName;
    private String mothersMaidenName;
    private MaritalStatus maritalStatus;
    private Education education;
    private double totalMonthlyIncomeInPln;
    private int numOfFamilyDependants;

    public PersonalData(String name, String lastName, String mothersMaidenName, MaritalStatus maritalStatus, Education education, double totalMonthlyIncomeInPln, int numOfFamilyDependants) {
        this.name = name;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.totalMonthlyIncomeInPln = totalMonthlyIncomeInPln;
        this.numOfFamilyDependants = numOfFamilyDependants;
    }
    public double incomePerFamilyMember()
    {
        return this.totalMonthlyIncomeInPln/this.numOfFamilyDependants;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public double getTotalMonthlyIncomeInPln() {
        return totalMonthlyIncomeInPln;
    }

    public void setTotalMonthlyIncomeInPln(double totalMonthlyIncomeInPln) {
        this.totalMonthlyIncomeInPln = totalMonthlyIncomeInPln;
    }

    public int getNumOfFamilyDependants() {
        return numOfFamilyDependants;
    }

    public void setNumOfFamilyDependants(int numOfFamilyDependants) {
        this.numOfFamilyDependants = numOfFamilyDependants;
    }
}
