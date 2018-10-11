//Takes 10 time inputs and sorts finds the fastest and slowest times

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
            int end = 0;
            int high = 0;
            int low = 0;
            int count = 1;
            string[] raceString = new string[10];
            double[] raceTime = new double[10];
            Console.WriteLine("Enter all times in hh:mm:ss format");
            //Takes input as string
            while (end != 10){
                string temp;
                
                Console.Write("Race " + count +": " );
                temp = Console.ReadLine();
                if (temp == "-1")
                {
                    break;
                }
                else
                {
                    raceString[end] = temp;
                    
                    end++;
                    count++;
                }
                }
            //Converste string to double in seperate array
            for(int i = 0; i<end; i++)
            {
                var split = raceString[i].Split(':');
                double hour = double.Parse(split[0]);
                double minute = double.Parse(split[1]);
                double seconds = double.Parse(split[2]);
                raceTime[i] = (hour * 3600) + (minute * 60) + seconds;
                
            }
            //Sort fastest
            for (int i = 0; i < end; i++)
            {
                if (raceTime[i] > raceTime[i + 1])
                {
                    high = i;

                }
            }
            //Sort slowest
            for (int i = 0; i < end; i++)
                {

                if (raceTime[i] < raceTime[i + 1])
                    {
                      low = i;

                    }
                }
            //Prints
            for (int i=0; i< end; i++)
            {
                if (i == high)
                {
                    Console.Write("Race " + (i+1) + ": " + raceString[i] + " Fastest" + Environment.NewLine);
                }
                else if (i == low)
                {
                    Console.Write("Race " + (i+1) + ": " + raceString[i] + " Slowest" + Environment.NewLine);

                }
                else
                Console.Write("Race " + (i+1) + ": " +raceString[i] + Environment.NewLine);

            }
            Console.ReadLine();
        }
       
    }
}
