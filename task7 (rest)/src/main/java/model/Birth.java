package model;

import java.util.Objects;

public class Birth {
    private String date;
    private String country;
    private String city;

    public Birth(String date, String country, String city) {
        this.date = date;
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Birth))
            return false;
        Birth b = (Birth) o;
        return b.date.equals(date) && b.country.equals(country)
                && b.city.equals(city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, country, city);
    }
}
