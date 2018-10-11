#Auther: Spencer Dant
#Python Programming
#7/11/18
#String encryption
user = input("Enter String :")
user = str(user)
i = 0
output = ""
for letter in user:
    temp = ord(user[i])
    temp = temp -97
    temp = 26 - temp
    temp = temp +97
    output += chr(temp)
    i = i+1
print(output)