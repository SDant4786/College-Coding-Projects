//Cylinder with class

#include <iostream>
#include <cmath>

using namespace std;

//class decleration
class cylinderType
{
public:
	double getRadius(double radius);
	double getHeight(double height);
	double getPaintCost(double paintCost);
	double getShippingCost(double shippingCost);
	double area(double radius, double height, double totalArea);
	double shippingPaintCost(double totalArea, double paintCost, double totalPaintCost);
	void printShipping(double shippingCost) const;
	void printCostOfPainting(double totalPaintCost) const;


private:
	double radius;
	double height;
	double paintCost;
	double shippingCost;
	double totalArea;
	double totalPaintCost;
};
//get radius funcion
double cylinderType::getRadius(double radius) {
	do {

		if (radius >= 0) {
			radius = radius;
			return radius;
		}
		else
			cout << "Please enter a number 0 or higher" << endl;
		cin >> radius;
	} while (radius < 0);
	return radius;
}
//get height function
double cylinderType::getHeight(double height) {
	do {
		if (height > 0) {
			height = height;
			return height;
		}
		else
			cout << "Please enter a number 0 or higher" << endl;
		cin >> height;
	} while (height < 0);
	return height;
}
//get paint cost function
double cylinderType::getPaintCost(double paintCost) {
	do {
		if (paintCost >= 0) {
			paintCost = paintCost;
			return paintCost;
		}
		else
			cout << "Please enter a number 0 or higher" << endl;
	} while (paintCost <0);
	return paintCost;
}
//get shipping cost function
double cylinderType::getShippingCost(double shippingCost) {
	do {
		if (shippingCost >= 0) {
			shippingCost = shippingCost;
			return shippingCost;
		}
		else
			cout << "Please enter a number 0 or higher" << endl;
		cin >> shippingCost;
	} while (shippingCost <0);
}
//finds the area from the radius and height
double cylinderType::area(double radius, double height, double totalArea) {
	return totalArea = (2 * 3.1416*radius*height) + ((2 * 3.1416*(radius*radius)));

}
//calculates the cost of painting the area of the cylinder
double cylinderType::shippingPaintCost(double totalArea, double paintCost, double totalPaintCost) {
	return totalPaintCost = totalArea * paintCost;


}
//prints the shipping cost
void cylinderType::printShipping(double shippingCost) const {
	cout << shippingCost << endl;
}
//prints painting cost
void cylinderType::printCostOfPainting(double totalPaintingCost)const {
	cout << totalPaintingCost << endl;
}




double radius, height, paintCost, shippingCost, totalArea, totalPaintingCost, area;
char close = ' ';


int main() {

	do {
		//delcares the class member cylinder1 
		cylinderType cylinder1;
		//get required data from user
		//radius
		cout << "Enter the radius of the cylinder in feet" << endl;
		cin >> radius;
		cylinder1.getRadius(radius);
		//height
		cout << "Enter the height of the cylinder in feet" << endl;
		cin >> height;
		cylinder1.getHeight(height);
		//shipping cost
		cout << "Enter the shipping cost per liter for the cylinder" << endl;
		cin >> shippingCost;
		cylinder1.getShippingCost(shippingCost);
		//painting clost
		cout << "ENter the painting cost per square foot for the cylinder" << endl;
		cin >> paintCost;
		cylinder1.getPaintCost(paintCost);
		//uses the function area to get the total area and assigns to variable totalArea		
		totalArea = cylinder1.area(radius, height, totalArea);
		//uses the funtion shippingPaintCost to get the total and assings it to variable totalPaintCost		
		totalPaintingCost = cylinder1.shippingPaintCost(totalArea, paintCost, totalPaintingCost);
		//prints the information
		//cost to ship
		cout << "The shipping cost for this cylinder is " << endl;
		cylinder1.printShipping(shippingCost);
		//cost to paint
		cout << "The painting cost for this cylinder is " << endl;
		cylinder1.printCostOfPainting(totalPaintingCost);
		//end program conditions
		cout << "To run again enter 'y' or 'Y'. To close the program, enter any other charcter" << endl;
		// do while loop to loop program		
		cin >> close;

	} while ((close != 'Y') && (close != 'y'));
	return 0;
}