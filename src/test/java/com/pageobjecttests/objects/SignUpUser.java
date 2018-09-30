package com.pageobjecttests.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignUpUser {


    private String firstName;
    private String lastName;
    private String address1;
    private String postcode;
    private String city;
    private String phone;
    private String country;
    private String zone;
    private String email;
    private String password;

    public SignUpUser() {
        firstName = "John";
        lastName = "Doe";
        address1 = "West Side Str. 22/11";
        postcode = "90210";
        city = "San Diego";
        phone = "+1902105545";
        country = "United States";
        zone = "California";
        email = getRandomMail();
        password = "qwe123";
    }

    private String getRandomMail() {
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = df.format(today);
        return "randomemail" + todayDate + "@gmail.com";
    }
    public String getEmail() { return email; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address1;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getZone() {return zone;}

    public String getPassword() {
        return password;
    }
}
