/*Author Spencer Dant
 * C# Programming
 * 7/3/17
 * Teacher position with interfaces*/

using System;

namespace Program1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Hardcoded Example
            University u = new University.Departments.Staff.Dean("tess", 50.40,2);

            Console.WriteLine();
            Console.WriteLine(u.position+ "  "+u.name +"  " +u.salary+ "  " + u.dep);
            u.Administrate();
            u.Teach();
            Console.ReadLine();
        }
    }
}
