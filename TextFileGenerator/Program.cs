using System;
using System.IO;
using System.Collections.Generic;

//Made by Richard Wilson Roberts III
//The purpose is to try out different functions and techniques in C# in order to refresh my knowledge of programming.
//date created: 03/03/2021

namespace TextFileGenerator
{
    class Program
    {
        static void Main(string[] args)
        {

            string textInput = "";
            int keyCount = 0;
            char loopContinue = ' ';
            int randomKey = 0;

            ///this is the entry message and notes section of the program. I'll write the methods later after completing the functionality.
            //welcoming message
            Console.WriteLine("This program will test user input, random number generator and converting the user input to a text file.");
            Console.WriteLine("Along with some other functions I may add. I'll add an option to where you'll see the notes of what I added.");
            Console.WriteLine();
            

            //data dictionary to hold user generated data
            Dictionary<int, string> dataDictionary = new Dictionary<int, string>();

            ///this is where the user inputs data. I'll add a loop to where they can build a data dictionary.
            ///The keys will be automatically generated from a counter in the loop, but the user can input the data. I'll try testing it like a suit of cards.
            ///The random number generator will be used to pull out the data from the dictionary. 
            ///TODO:
            ///send everything into methods/separate classes.
            ///add a check to where they user can't put anything else in the loopContinue variable.

            Random random = new Random();

            while(!loopContinue.Equals('n'))
            {
                
                //separate here
                Console.Write("Type the text for the data dictonary here: ");
                textInput = Console.ReadLine();
                Console.WriteLine();
                dataDictionary.Add(keyCount, textInput);

                keyCount++;

                //separate here
                Console.WriteLine("Continue?");
                Console.Write("Type y(yes) or n(no) here: ");
                loopContinue = char.ToLower(char.Parse(Console.ReadLine()));
                Console.WriteLine();
            }

            randomKey = random.Next(0, keyCount);


            //output message
            Console.WriteLine("With this, there should be an output file in bin directory. The file will also have the program's current directory in it.");


            ///This is what the program will do. I'll try to do it from another class after confirming everything I want to do works.
           try
            {
                FileStream file = new FileStream("Output.txt", FileMode.OpenOrCreate);
                StreamWriter writer = new StreamWriter(file);
                writer.WriteLine("This is one of the things you typed: {0}. The key is: {1}", dataDictionary[randomKey], randomKey);
                writer.WriteLine();
                writer.WriteLine("This was generated on: {0} on {1}.", DateTime.Now.ToLongTimeString(), DateTime.Now.ToLongDateString());
                writer.WriteLine();
                writer.WriteLine("This file is also located at: " + Directory.GetCurrentDirectory());

                writer.Close();
            }

            catch (IOException error)
            {
                Console.WriteLine("Something went wrong. Below is the error message:");
                Console.WriteLine(error.Message);
                Console.WriteLine("Press anything to continue?");
                Console.ReadKey();
                return;
            }



            
        }
    }
}
