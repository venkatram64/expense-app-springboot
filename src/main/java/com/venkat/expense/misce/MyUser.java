package com.venkat.expense.misce;

/*
Make the constructor private
Expose a public, static inner class
The inner "builder" class is entirely mutable
Use it to create entirely immutable instance
 */

public class MyUser {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String location;

    private MyUser(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.location = builder.location;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    //inner class to build the parent object
    public static class Builder{

        public String firstName;
        public String lastName;
        public String email;
        public String location;

        public MyUser build(){
            return new MyUser(this);
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder location(String location){
            this.location = location;
            return this;
        }
    }

    public static void main(String[] args) {

        MyUser user = MyUser.builder()
                .firstName("Venkatram")
                .lastName("Veerareddy")
                .email("venkat.veerareddy@gmail.com")
                .location("Bagyanagar")
                .build();

        System.out.println(user);
    }
}
