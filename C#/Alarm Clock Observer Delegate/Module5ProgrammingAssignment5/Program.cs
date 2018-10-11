//Author Spencer Dant
//C# Programming
//7/21/18
//Alarm clock program


using System;

namespace Module5ProgrammingAssignment5
{
    //Creates observer class
    class AlarmObserver
    {
        
        public Action TimerDelegate;
        public void TimerObserver()
        {
            TimerDelegate();
        }
    }
    //Alarm clock class
    class AlarmCLock
    {
        //Variables
        String message { get; set; }
        int seconds { get; set; }
        System.Timers.Timer timer;
        private AlarmObserver alarmObserver;
        public int timePassed { get; set; }
        //constructor 
        public AlarmCLock(String message, int seconds)
        {
            this.message = message;
            this.seconds = seconds;
            alarmObserver = new AlarmObserver();
            timer = new System.Timers.Timer();
            //Creates interval 
            timer.Interval = 1000;
            //Assisngs timer.elapased to Ticks method
            timer.Elapsed += Ticks;
            timePassed = 0;
            Console.WriteLine("Timer has been set for " + seconds + " seconds.");

        }
        //Method called when timer is finished
        public void Finished()
        {
            timer.Dispose();
            Console.WriteLine("Timer is finished");
        }
        //method called when timer is paused
        public void PauseAlarm() {
            timer.Stop();
            
            Console.WriteLine("Alarm has been paused");
            
        }
        //method to start alarm
        public void StartAlarm() {
            timer.Start();
            timer.Enabled = true;
            Console.WriteLine("Alarm has been started");
        }
        // method to resume alarm after it has been paused
        public void ResumeAlarm()
        {
            timer.Start();
            Console.WriteLine("Alarm has been resumed");
        }
        //method to cancle alarm
        public void AbortAlarm()
        {
            timer.Dispose();
            Console.WriteLine("Alarm has been aborted");
        }
        //Tick counter/Event
        public void Ticks(Object timer, System.Timers.ElapsedEventArgs e)
        {
            Console.WriteLine((timePassed+1));
            timePassed = timePassed +1;
            if (seconds == timePassed)
            {
                this.Finished();
            }
        }
    } 
   
    class Program
    {
        static void Main(string[] args)
        {
            //program loop
            while (true) { 
                //input for new alarmclock
                Console.WriteLine("Enter the message for the alarm");
            String message = Console.ReadLine();
            Console.WriteLine("Enter the time in seconds");
            String time = Console.ReadLine();
            int t;
            //Exception handleing for time input
            try
            {
                t = Int32.Parse(time);
            }
            catch (FormatException e)
            {
                Console.WriteLine(e.Message);
            }
            t = Int32.Parse(time);
            AlarmCLock alarmClock = new AlarmCLock(message, t);
            int done = alarmClock.timePassed;
                //starts timer loop
            Console.WriteLine("'X' to start \n'C' to pause \n'Z' to Resume\n 'V' to abort alarm \n'E' to create new alarm");
            while (true)
            {
                    //timer loop
                ConsoleKeyInfo key = Console.ReadKey();
                Console.WriteLine();
                if (key.KeyChar == 'X') { alarmClock.StartAlarm(); }
                if (key.KeyChar == 'C') { alarmClock.PauseAlarm(); }
                if (key.KeyChar == 'Z') { alarmClock.ResumeAlarm(); }
                if (key.KeyChar == 'V') { alarmClock.AbortAlarm(); }
                if (t <= done) { alarmClock.Finished(); }
                if (key.KeyChar == 'E') { alarmClock.AbortAlarm();  break; }
            }
        }
            
        }
    }
}
