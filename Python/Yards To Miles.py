#Author Spencer Dant
#Python Programmin
#7/19/18
#Yards to Miles function

def YardsToMiles(yards):
    miles = yards*.000568
    return miles

yards = input("Enter yards: ")
yards = int(yards)

miles = YardsToMiles(yards)
miles = str(miles)
yards = str(yards)

print(yards+" Yards = " + miles + " Miles")
