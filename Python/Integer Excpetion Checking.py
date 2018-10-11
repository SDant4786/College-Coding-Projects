#Author Spencer Dant
#Python Programming
#7/26/18
#Integer Manipulation with Exception checking
undefined = False
parsed = False
num = 0
while not parsed:
    try:
        num1 = int(input ("Enter first Number: "))
        parsed = True
    except ValueError:
        print ("Invalid Input")
parsed = False

while not parsed:
    try:         
        num2 = int(input ("Enter second Number: "))
        parsed = True
    except ValueError:
        print ("Invlaid Input")
parsed = False

while not parsed:
    try:
        num3 = int(input ("Enter third Number: "))
        parsed = True
    except ValueError:
        print ("Invalid Input")
divided = False

try:
    num= num1/num2
except ZeroDivisionError:
    undefined = True
    print ("Division By Zero")
num = num+num3

if undefined is True:
    print("Number is undefined")
else:
    print (num)
