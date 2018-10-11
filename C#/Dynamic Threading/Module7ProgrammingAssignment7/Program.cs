//Author: Spencer Dant
//C# programming
//8/5/2018
//Multithreaded program to find the numbers with the highest numbers of divisors for a given range

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Module7ProgrammingAssignment7
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                //Gets input for max number
                Console.Write("Enter max numbers: ");
                int MAX = Int32.Parse(Console.ReadLine());

                //Array for storing the numbers
                int[] numArray = new int[MAX];
                for (int i = 0; i < MAX - 1; i++)
                {
                    numArray[i] = i;
                }

                //Gets input for number of threads
                Console.Write("Enter number of threads: ");
                int threads = Int32.Parse(Console.ReadLine());

                //creates the thread array
                Thread[] threadArray = new Thread[threads + 1];

                //Calculates the range needed to split the numbers between the threads
                int range = MAX / threads;

                //Creates low end of the range
                int[] low = new int[threads];
                low[0] = 0;
                for (int i = 1; i < threads; i++)
                {
                    low[i] = low[i - 1] + range;
                }

                //Creates array of the high end of the range
                int[] high = new int[threads];
                high[0] = range;
                for (int i = 1; i < threads; i++)
                {
                    high[i] = high[i - 1] + range;
                }

                //This is the list to store the numbers with the highest divisors
                List<int> numbers = new List<int>();

                //Bool check to see if the first search is complete by all threads
                bool done = false;

                //counter 
                int count = 0;

                //Locker object to hold the threads and join them together
                object locker = new object();

                //universal counter for the maximum number of divisors 
                int maxDivisors = 0;

                //Loop to create the threads and give each thread the correct variables 
                for (int i = 0; i < threads + 1; i++)
                {
                    int temp = i;

                    //Thread creation 
                    threadArray[temp] = new Thread(() =>
                    {
                        lock (locker)
                        {

                        // First search to find the maximum divisor in the range of numbers
                        for (int l = low[temp]; l < high[temp]; l++)
                            {
                                int divisors = 1;
                                for (int k = 1; k < numArray[l]; k++)
                                {
                                    if (numArray[l] % k == 0)
                                    {
                                        divisors++;
                                        if (divisors > maxDivisors)
                                        {
                                            maxDivisors = divisors;

                                        }
                                    }
                                }

                            }

                        //Stall the thread so all threads can update the maxDivisor before searching for all numbers with the max divisor
                        Monitor.Wait(locker);

                        //Finds all numbers with the max divisor 
                        for (int l = low[temp]; l < high[temp]; l++)
                            {
                                int divisors = 1;
                                for (int k = 1; k < numArray[l]; k++)
                                {
                                    if (numArray[l] % k == 0)
                                    {
                                        divisors++;
                                        if (divisors == maxDivisors)
                                        {
                                            numbers.Add(numArray[l]);
                                        }
                                    }
                                }
                            }
                        }

                    });
                }

                //Thread to check if the other threads are all done with first search. Restarts the when this condition is true
                threadArray[threads] = new Thread(() =>
                {
                    lock (locker)
                    {
                        while (done != true)
                        {
                            count = 0;
                            for (int i = 0; i < threads; i++)
                            {
                                if (threadArray[i].ThreadState == ThreadState.WaitSleepJoin) ;
                                {
                                    count++;
                                }

                                if (count == threads - 1)
                                {
                                    done = true;
                                }
                            }
                        }
                        Monitor.PulseAll(locker);
                    }
                });

                //Starts all the threads
                for (int i = 0; i < threads + 1; i++)
                {
                    threadArray[i].Start();

                }

                //Joins all the threads
                for (int i = 0; i < threads + 1; i++)
                {
                    threadArray[i].Join();

                }


                //Outputs
                Console.WriteLine("Max number is: " + MAX);
                Console.WriteLine("Number of threads: " + threads);
                Console.WriteLine("Max number of divisors: " + maxDivisors);
                Console.Write("Numbers with most factors: ");
                for (int i = 0; i < numbers.Count(); i++)
                {
                    Console.Write(numbers[i] + "  ");
                }
                Console.ReadLine();
            }
        }
        
        
    }
}
