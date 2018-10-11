#Program: Ch 2 Ex 20
#Author: Spencer Dant
#Date: 06/26/2018
#Description: Program to calculate accept and check integers
x = False
while x != True:
    dummy_str=input("Enter an integer")
    try:
        dummy_int=int(dummy_str)
        print ("The integer is: ",dummy_int)
        x = True
    except ValueError:
        print("Error, not an int")
    
