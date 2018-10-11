#Author: Spencer Dant
#Python Programming
#8/5/2018
#Program that flips a string

def StringFlip(S):
    flipS = ""
    for c in S:
        
       flipS = c + flipS
        
    return flipS

St = str(input("Enter a string"))
print(StringFlip(St))
