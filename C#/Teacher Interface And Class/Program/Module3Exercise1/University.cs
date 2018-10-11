/*Author Spencer Dant
 * C# Programming
 * 7/3/17
 * Teacher position with interfaces*/

using System;
//Super class
public class University
{

    public enum departments
    {
        Math,
        English,
        Geography,
        ComputerScience
    }
    public enum staff
    {
        Dean,
        Administrator,
        Reaseacher,
        Professor
    }
    public enum ResearchSpecialtiy
    {
        psychology,
        physics,
        economics,
        philosophy
    }
    public ResearchSpecialtiy res;
    public staff position;
    public int numberOfStaff;
    public departments dep;
    public string name;
    public double salary;
    //University Consctuctor format: (Departments(1-4,Staff(1-4,name,salary))
    //with proffesor: (Departments(1-4,Staff(1-4,name,salary,proffesor(1-4))
    public University()
    {
    }
    //Department class,"inerites" Univerisyt class, has enumeration for each department
    public class Departments : University
    {


        //constructor
        public Departments(int type, int staff)
        {
            dep = (departments)type;
            numberOfStaff = staff;

        }
        public Departments()
        {

        }
        //Staff class
        public class Staff : Departments
        {
            public Staff() { }
            //Dean constructor
            public class Dean : Staff, ITeachable, IAdmin
            {
                public Dean(string n, double s, int d)
                {
                    dep = (departments)d;
                    position = (staff)1;
                    name = n;
                    salary = s;
                }
                //Administrator constructor
                public class Administrators : Staff, IAdmin
                {
                    public Administrators(string n, double s, int d)
                    {
                        dep = (departments)d;
                        position = (staff)2;
                        name = n;
                        salary = s;
                    }
                }
                //Researcher constructor
                public class Researchers : Staff, ITeachable
                {
                    public Researchers(string n, double s,int d)
                    {
                        dep = (departments)d;
                        position = (staff)3;
                        name = n;
                        salary = s;
                    }
                }
                //Professor constructor
                public class Professor : Staff, ITeachable
                {

                    public Professor(int i, string n, double s,int d)
                    {
                        dep = (departments)d;
                        position = (staff)4;
                        res = (ResearchSpecialtiy)i;
                        name = n;
                        salary = s;
                    }
                }
            }
        }
    }
    public void Teach()
    {
        Console.WriteLine("ITeach test");
    }
    public void Administrate()
    {
        Console.WriteLine("Administrate Test");
    }
}

