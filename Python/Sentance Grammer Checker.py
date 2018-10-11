#Auther Spencer Dant
#Python Programming
#7/11/18
#Sentance checker

user = input("Enter a sentance: ")
user = str(user)
output = ""
error = ""
length = len(user)
length = length -1
i = 0
for letter in user:
    if i == 0:
        temp = user[i]
        temp = ord(temp)
        if temp<65 or temp >90:
            temp = temp -32
            temp = chr(temp)
            output += temp
            i +=1
            error = "Non capital letter"
    if i == length:
        temp = user[i]
        temp = ord(temp)
        if temp != 46:
            output+=user[i]
            output += "."
            error += " \nNo period"
            break;
    else:
        output+=user[i]
        i = i +1
print (error)
print (output)            

    
