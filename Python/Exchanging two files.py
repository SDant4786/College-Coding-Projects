#Author: Spencer Dant
#Python Programming
#7/28/2018
#Exchanging two files
import os

#This is the cheating way to do it
def cheating(data1,data2):
   os.rename(data2, 'temp')
   os.rename(data1, data2)
   os.rename('temp', data1) 
   
#This creates a temperary file to store the first file 
#for copying
def copying(data1,data2): 
    temp_file = open("temp.txt", 'r+')
    #first => temp
    for line_str in data1:
        temp_file.write(line_str)
    #second => first
    for line_str in data2:
        data1.write(line_str)
    #temp => second  
    for line_str in temp_file:
        data2.write(line_str)
    #closes temp file
    temp_file.close
#inputs with exception handling
file1 = input("Enter name for first file: ")
try:
    data_file1 = open (file1, 'r+')
except FileNotFoundError:
    print("The file", file1, "Does not exsist")
file2 = input("Enter name for second file: ")
try: 
    data_file2 = open(file2, 'r+')
except FileNotFoundError:
    print("The file", file2, "Does not exsist")
#calls cheating function
cheating(data_file1,data_file2)
#calls copying function
copying(data_file1,data_file2)
#closes files
data_file1.close
data_file2.close

