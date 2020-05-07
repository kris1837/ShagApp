package kz.sirius.myapplication.entity;

public class Drink {
    private String name;
    private String companyName;
    private boolean isAlcoholic;
    private boolean isCarbonated;
    private boolean isSweet;

    public Drink(String name, String companyName, boolean isAlcoholic, boolean isCarbonated, boolean isSweet) {
        this.name = name;
        this.companyName = companyName;
        this.isAlcoholic = isAlcoholic;
        this.isCarbonated = isCarbonated;
        this.isSweet = isSweet;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public boolean isCarbonated() {
        return isCarbonated;
    }

    public boolean isSweet() {
        return isSweet;
    }
}
