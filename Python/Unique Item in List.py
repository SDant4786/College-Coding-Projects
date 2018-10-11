#Author: Spencer Dant
#Python Programming
#8/7/2018
#Function to find unique items in list

def listCreator(lst):
    lst2 = list()
    for char in lst:
        temp = 0
        for char2 in lst:
            if char == char2:
                temp = temp+1
        if temp ==1:
            lst2.append(char)
    return lst2

testLst = str(input("Enter any number of characters: "))
testLst=list(testLst)

print(listCreator(testLst))

