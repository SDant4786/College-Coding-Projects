/* Author Spencer Dant
 * C# programming
 * 7/12/18
 * Tic Tac Toe game*/

using System;


namespace TicTacToe
{
    class Program
    {
        static void Main()
        {
            Boolean check = false;
            var game = new Game();
            var player = 'X';
            do
            {
                game.Print();

                //Get an integer position
                Console.Write("Enter your move:");
                string input;
                int position;
                do
                {
                    input = Console.ReadLine();
                    //Throw an exception if an  input is not an number
                    //Between this and the other 2 exception handlers, all possible input exceptions
                    //should be handled 
                    try
                    {
                        int num = -1;
                        if (!int.TryParse(input, out num))
                        {
                            throw new UnknownErrorException("Unknown Error");
                        }
                    }
                    catch (UnknownErrorException e)
                    {
                        Console.Write("Enter your move:");

                    }

                } while (!int.TryParse(input, out position));

                //Try catch block to handle the move exceptions
                try
                {
                    game.Move(position, player);
                }
                catch (ArgumentException e)
                {
                    Console.WriteLine("Ivalid Number", e);
                    Console.Write("Press Enter to Continue");
                    check = true;
                    Console.ReadLine();
                }
                catch (BadMoveException e)
                {
                    Console.WriteLine("Press enter to continue");
                    check = true;

                    Console.ReadLine();
                }

                //True false check to make sure the correct player plays after exception handling
                if (check != true)
                {
                    player = (player == 'X') ? 'O' : 'X';
                }
                check = false;

            } while (!game.Ended());
           
        }  
    }
}
