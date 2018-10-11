/* Author Spencer Dant
 * C# programming
 * 7/12/18
 * Tic Tac Toe game*/


using System;
using System.Security.Cryptography.X509Certificates;

namespace TicTacToe
{   //class to handle unknown excpetions
    public class UnknownErrorException : Exception
    {
        public UnknownErrorException(String message)
        {
            Console.WriteLine("Unknown Error");
        }
    }
    //class to handle duplicate move exception  excpetions
    public class BadMoveException:Exception
    {
        public BadMoveException(String message)
        {
            Console.WriteLine("Invalid Move");
        }
    }

    //Game class
    internal class Game
    {
        char[,] grid = new char[3,3];

        //Constructor
        public Game()
        {
            for (int x = 0; x < 3; x++)
            {
                for (int y = 0; y < 3; y++)
                {
                    grid[x, y] = '.';
                }
            }
        }

        //End of game checker
        public bool Ended()
        {
            //This is sloppy but works
            if ((grid[0, 0] == 'X') && (grid[0, 1] == 'X') && (grid[0, 2] == 'X')) { return true; }
            if ((grid[1, 0] == 'X') && (grid[1, 1] == 'X') && (grid[1, 2] == 'X')) { return true; }
            if ((grid[2, 0] == 'X') && (grid[2, 1] == 'X') && (grid[2, 2] == 'X')) { return true; }

            if ((grid[0, 0] == 'X') && (grid[1, 0] == 'X') && (grid[2, 0] == 'X')) { return true; }
            if ((grid[0, 1] == 'X') && (grid[1, 1] == 'X') && (grid[2, 1] == 'X')) { return true; }
            if ((grid[0, 2] == 'X') && (grid[1, 2] == 'X') && (grid[2, 2] == 'X')) { return true; }

            if ((grid[0, 0] == 'X') && (grid[1, 1] == 'X') && (grid[2, 2] == 'X')) { return true; }
            if ((grid[0,2] == 'X') && (grid[1, 1] == 'X')&& (grid[2, 0] == 'X'))  { return true; }

            if ((grid[0, 0] == 'O') && (grid[0, 1] == 'O') && (grid[0, 2] == 'O')) { return true; }
            if ((grid[1, 0] == 'O') && (grid[1, 1] == 'O') && (grid[1, 2] == 'O')) { return true; }
            if ((grid[2, 0] == 'O') && (grid[2, 1] == 'O') && (grid[2, 2] == 'O')) { return true; }

            if ((grid[0, 0] == 'O') && (grid[1, 0] == 'O') && (grid[2, 0] == 'O')) { return true; }
            if ((grid[0, 1] == 'O') && (grid[1, 1] == 'O') && (grid[2, 1] == 'O')) { return true; }
            if ((grid[0, 2] == 'O') && (grid[1, 2] == 'O') && (grid[2, 2] == 'O')) { return true; }

            if ((grid[0, 0] == 'O') && (grid[1, 1] == 'O') && (grid[2, 2] == 'O')) { return true; }
            if ((grid[0, 2] == 'O') && (grid[1, 1] == 'O') && (grid[2, 0] == 'O')) { return true; }
            return false;
        }

        //Move input function
        internal void Move(int position, char player)
        {
            //throws arugment excpeton if number is out of range
            if ((position < 0) || (position > 8))
            {
                throw new ArgumentException("Not a valid number");
            }

            //Throws a bad move exception if place on board is alread ocupied 
            if ((grid[position % 3, (position / 3)] == 'X') || (grid[position % 3, (position / 3)] == 'O'))
            {
                throw new BadMoveException("Bad Move");
            }

            grid[position % 3, (position /3)] = player;
           
        }

        //Prints the board
        public void Print()
        {
            Console.Clear();

            Console.WriteLine("Key");
            int cell = 0;
            for (int y = 0; y < 3; y++)
            {
                if (y >= 1) Console.WriteLine("---+---+---");
                for (int x = 0; x < 3; x++)
                {
                    if (x >= 1) Console.Write("|");
                    Console.Write(" {0} ", cell++);
                }
                Console.WriteLine();
            }


            Console.WriteLine();
            for (int y = 0; y < 3; y++)
            {
                if (y >= 1) Console.WriteLine("---+---+---");
                for (int x = 0; x < 3; x++)
                {
                    if (x >= 1) Console.Write("|");
                    Console.Write(" {0} ", grid[x,y]);
                }
                Console.WriteLine();
            }





        }

    }
}