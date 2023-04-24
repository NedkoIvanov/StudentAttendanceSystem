package com.attendance.demo.model.binding;

public class RegisterBindingModel {

    //ToDo : validation

    private String email;

    private String password;

    private String confirmPassword;

    private String firstName;

    private String familyName;

    private String egn;

    private String phoneNumber;

    //when user is registered(by admin) the application is going to redirect admin to page of sessions available aobut the course
    //and admin is going to choose which course the teacher is going to be responsible for
    private String courseName;

    public RegisterBindingModel(String email, String password, String confirmPassword, String firstName,
                                String familyName, String egn, String phoneNumber, String courseName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.familyName = familyName;
        this.egn = egn;
        this.phoneNumber = phoneNumber;
        this.courseName = courseName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
