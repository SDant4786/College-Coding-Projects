#Author Spencer Dant
#7/19/18
#Python Programming
#FibonacciNumbers
def FibonacciNumbers(number):
    num1 = 1
    num2 = 1
    print(num1)
    print(num2)
    for x in range(1,number-1):
        num3 = num1+num2
        num1 = num2
        num2 = num3
        print(num3)
def FibonacciNumbers2(number):
    num1 = 1
    num2 = 1
    for x in range(1,number-1):
        num3=num1+num2
        num1=num2
        num2=num3
    print(num3)

number = input("Enter the number of Fibonacci numbers to show: ")

number = int (number)

FibonacciNumbers(number)

number = input("Enter the number of the desired Fibonacci number to show:  ")

number = int (number)

FibonacciNumbers2(number)