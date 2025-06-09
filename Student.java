package com.Ramzy842.sms.model;

public class Student {
    private int _id;
    private String _firstName;
    private String _lastName;
    private int _age;
    private String _email;
    private String _course;
    private double _gpa;

    public Student(int id, String firstName, String lastName, int age, String email, String course, double gpa)
    {
        setId(id);
        setFirstname(firstName);
        setLastName(lastName);
        setAge(age);
        setEmail(email);
        setCourse(course);
        setGpa(gpa);
    }

    // SETTERS
    public void setId(int id)
    {
        this._id = id;
    }
    public void setFirstname(String firstname)
    {
        this._firstName = firstname;
    }
    public void setLastName(String lastName)
    {
        this._lastName = lastName;
    }
    public void setAge(int age)
    {
        this._age = age;
    }
    public void setEmail(String email)
    {
        this._email = email;
    }
    public void setCourse(String course)
    {
        this._course = course;
    }
    public void setGpa(double gpa)
    {
        this._gpa = gpa;
    }
    // GETTERS
    public int getId()
    {
        return _id;
    }
    public String getFirstName()
    {
        return _firstName;
    }
    public String getLastName()
    {
        return _lastName;
    }
    public int getAge()
    {
        return _age;
    }
    public String getEmail()
    {
        return _email;
    }
    public String getCourse()
    {
        return _course;
    }
    public double getGpa()
    {
        return _gpa;
    }
}
