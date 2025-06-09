
public class Person {
    private int _id;
    private String _name;
    private int _age;
    private String _email;
    public Person(int id, String name, int age, String email)
    {
        setId(id);
        setName(name);
        setAge(age);
        setEmail(email);
    }
    public void setId(int id)
    {
        this._id = id;
    }
    public void setName(String name)
    {
        this._name = name;
    }
    public void setAge(int age)
    {
        this._age = age;
    }
    public void setEmail(String email)
    {
        this._email = email;
    }
    public int getId()
    {
        return _id;
    }
    public String getName()
    {
        return _name;
    }
    public int getAge()
    {
        return _age;
    }
    public String getEmail()
    {
        return _email;
    }    
}
