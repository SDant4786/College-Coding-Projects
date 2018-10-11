//Average mile/KM time for runners caclulator

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            int hours;
            int minutes;
            int seconds;
            int tempTime;
            double tempDistance;
            double miles;
            double km;
            char distance;
            double milesPerMinute;
            double milesPerSecond;
            double kmPerMinute;
            double kmPerSecond;
            string input;
           
            
        //Parses the time into minutes houre and seconds
        System.Console.Write("Enter Time in hh:mm:ss format:  ");
            input = (System.Console.ReadLine());
             var split = input.Split(':');
            hours = int.Parse(split[0]);
            minutes = int.Parse(split[1]);
            seconds = int.Parse(split[2]);

            //Gets either miles or kilmeters
            System.Console.Write("Enter Distance: ");
            tempDistance = double.Parse(System.Console.ReadLine());
            System.Console.Write("For Miles enter 'M' For Kilometers enter 'K': ");
            distance = char.Parse(System.Console.ReadLine());
            while (true)
            {
                if (distance == 'M')
                {
                    miles = tempDistance;
                    km = miles * 1.609344;
                    break;
                }
                else if (distance == 'K')
                {
                    km = tempDistance;
                    miles = km * .62137119;
                    break;
                }
                else
                {
                    System.Console.Write("Error, please enter M or K: ");
                    distance = char.Parse(System.Console.ReadLine());
                }
            }
            tempTime = (hours * 3600) + (minutes * 60) + seconds;

            //Math
            milesPerMinute = Math.Floor((tempTime / 60) / miles);
            milesPerSecond = Math.Round((((tempTime / 60) / miles) - milesPerMinute) * 60);
            miles = Math.Round(miles, 2);

            kmPerMinute = Math.Floor((tempTime / 60) / km);
            kmPerSecond = Math.Round((((tempTime / 60) / km) - kmPerMinute) * 60);
            km = Math.Round(km, 1);

            //Output
            Console.Write("Time: " + hours + ":" + minutes + ":" + seconds + System.Environment.NewLine);
            Console.Write("Distance in miles: " + miles + " Distance in km: " + km + System.Environment.NewLine);
            Console.Write("Pace in minutes per mile: " + milesPerMinute + ":" + milesPerSecond + System.Environment.NewLine);
            Console.Write("Pace in minutes per km: " + kmPerMinute+":"+kmPerSecond );
            Console.ReadLine();
        }
    }
}
