#Program: Ch 2 EX 30
#Author: Spencer Dant
#Date: 06/26/2018
#Description: Program to calculate QB passer rating with 
#Passer rating if/else statements 

dummy_str = input("Enter number of pass completions: ")
completions = float(dummy_str)

dummy_str = input("Enter number of pass attempts: ")
attempts = float(dummy_str)

dummy_str = input("Enter total passing yards: ")
yards = float(dummy_str)

dummy_str = input("Enter number of touchdowns: ")
touchdowns=float(dummy_str)

dummy_str = input("Enter number of interceptions: ")
interceptions = float(dummy_str)

C= (((completions/attempts)*100)-30)/20
Y = ((yards/attempts)-3)/4
T = (touchdowns/attempts)*20
I = 2.375-((interceptions/attempts)*35)

passer_rating = ((C+Y+T+I)/6)*100
if passer_rating <= 85:
    print ("The quaterbacks passing rating is poor: ", passer_rating)
elif 85<passer_rating<=90:
    print ("The quaterbacks passing rating is meicore: ",passer_rating)
elif 90<passer_rating<=95:
    print ("The quaterbacks passing rating is good: ",passer_rating )
else:
    print("The quaterbacks passing rating is great: ",passer_rating)
