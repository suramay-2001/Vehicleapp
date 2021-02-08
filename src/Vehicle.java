import java.io.IOException;

public class Vehicle {
public int id;
public int year;
public String Make;
public String Model;
	
public Vehicle(int i, String M, int y, String Mo) throws IOException {
	    this.id=i;	
		this.Make=M;	
		this.Model=Mo;	
	if(y>=1950&&y<=2050) {
		this.year=y;
	}
	else {
		throw new IOException("The year of the car is not between 1950 and 2050");
	}
}
/* getter method for ID field*/
public int getID() {
	return id;
}
/* gsetter method for ID field*/
public void setID(int id) {
	this.id=id;
}
/* getter method for year field*/
public int getyear() {
	return year;
}
/* setter method for year field*/
public void setyear(int year) {
	this.year=year;
}
/* getter method for Make field*/
public String getMake() {
	return Make;
}
/* setter method for Make field*/
public void setMake(String Make) {
	this.Make=Make;
}
/* getter method for Model field*/
public String getModel() {
	return Model;
}
/* setter method for Model field*/
public void setModel(String Model) {
	this.Model=Model;
}

}
