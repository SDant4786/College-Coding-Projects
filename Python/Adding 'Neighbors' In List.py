#Author: Spencer Dant
#Python Programming
#7/31/2018
#Function to add neighbors in list

listA = [10,20,30,40,50]
listB = []
length = len(listA)-1
index = 0
for x in listA:
    if index == 0:
        temp1 = listA[index]
        temp2 = listA[index+1]
        temp3 = temp1+temp2
        listB.append(temp3)
        index +=1
    elif index == length:
        temp1 = listA[index]
        temp2 = listA[index-1]
        temp3= temp1+temp2
        listB.append(temp3)
        index +=1
    else:
        temp1 = listA[index]
        temp2 = listA[index-1]
        temp3= listA[index+1]
        temp4 = temp1+temp2+temp3
        listB.append(temp4)
        index +=1        
print (listB)