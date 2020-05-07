package kz.sirius.myapplication.entity;

public class AlibisEntity {
    private String city;
    private String degrees;
    private String windSpeed;

    public AlibisEntity(String city, String degrees, String windSpeed) {
        this.city = city;
        this.degrees = degrees;
        this.windSpeed = windSpeed;
    }

    public String getCity() {
        return city;
    }

    public String getDegrees() {
        return degrees;
    }

    public String getWindSpeed() {
        return windSpeed;
    }
}
