#Author:Spencer Dant
#Python Programming
#8/7/2018
#Palindromes tester

def Tester(str1,str2):
    str1 =str1.lower()
    str1 = str1.replace(" ", "")
    lst1 = list(str1)
    
    
    str2 =str2 =str2.lower()
    str2 = str2.replace(" ","")
    lst2 = list(str2)
    
    lst1.reverse()
    i = 0
    for char in lst2:
        if char != lst1[i]:
            return False
        i = i+1
   
    return True
        
tempString1 = str(input("Enter first string: "))
tempString2 = str(input("Enter second string: "))

if Tester(tempString1,tempString2) == True:
     print("The two strings: \n"+tempString1+" \nand: \n"+tempString2+"\n are a palindrome")
else:
    print("The two strings: \n"+tempString1+"\nand: \n"+tempString2+"\nare not a palindrome")


     
