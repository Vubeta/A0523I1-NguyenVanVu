package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotBlank(message = "First name is not be empty")
    @Size(min = 5, message = "First name >=5 character")
    @Size(max = 45, message = "First name <=45 character")
    private String userFirstName;
    @NotBlank(message = "Last name is not be empty")
    @Size(min = 5, message = "Last name >=5 character")
    @Size(max = 45, message = "Last name <=45 character")
    private String userLastName;
    @Pattern(regexp = "^0\\d{9,10}$", message = "Phone number is not valid")
    private String userPhoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirthDate;
    @Email(message = "Email is not valid")
    private String userEmail;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean is18YearsOld() {
        //convert java.util.Date to LocalDate
        LocalDate birthLocalDate = this.userBirthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        //Get current date
        LocalDate currentDate = LocalDate.now();

        //Calculate time between 2 date
        Period period = Period.between(birthLocalDate, currentDate);

        //Check is enough 18 years old
        return period.getYears() >= 18;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.is18YearsOld()){
            errors.rejectValue("userBirthDate","","Not enough 18 years old");
        }
    }
}
