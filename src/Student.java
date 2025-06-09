
public class Student extends Person {
    private String _course;
    private double _gpa;

    public Student(int id, String name, int age, String email, String course, double gpa)
    {
        super(id, name, age, email);
        setCourse(course);
        setGpa(gpa);
    }

    // SETTERS
    public void setCourse(String course)
    {
        this._course = course;
    }
    public void setGpa(double gpa)
    {
        this._gpa = gpa;
    }
    // GETTERS
    public String getCourse()
    {
        return _course;
    }
    public double getGpa()
    {
        return _gpa;
    }
}
