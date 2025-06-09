package com.Ramzy842.sms;
import com.Ramzy842.sms.model.Student;
public class App {
    public static void main (String args[])
    {
        Student s1 = new Student(0, "Ramzy", "Chahbani", 24, "ramzychahbani@gmail.com", "Computer science", 3);
        System.out.println(s1.getAge());
    }
}