import java.io.IOException;
import java.util.ArrayList;

public class interact {

ArrayList<Vehicle> vh=new ArrayList<Vehicle>();//Arraylist that stores all vehicle objects created in th program
  public void createVehicle(int id,int year, String Make,String Model) {
	  try {
		Vehicle v=new Vehicle( id, Make,year, Model);//creating a new vehicle 
		vh.add(v);//adding to the in memory array list to store it.
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
public ArrayList<Vehicle> getall() {
	return vh;//returning the arraylist of all the vehicles
}

public Vehicle getbyId(int id) {
	/*
	 * we get the position of the elemnt we want to return
	 * by matching the unique ids in the list
	 */
	Vehicle v=null;
	for ( int i=0;i<vh.size();i++) {
		if (vh.get(i).getID()==id) {
			v=vh.get(i);
		}
		
	}
	return v;
}

public Vehicle deletebyId(int id) {
	/*
	 * we get the element by its id and remove it from the list
	 * We return it to the user to see its details
	 */
	Vehicle v =getbyId(id); int pos;
	if(v== null) {
		return null;
	}
	else {
	vh.remove(v);
	}
	return v;
}
public void deleteall() {
	vh.clear();//deletes all the elements in arraylist
}
public Vehicle update(int id,String st) {
	/*we get the 
	 * position of the vehicle we want to update.
	 * by going through the arraylist and matching the unique id 
	 * of our vehicle
	 */
	int pos=-1;
	for (int i=0;i<vh.size();i++) {
		if(vh.get(i).getID()==id) {
			pos=i;
		}
	}
	if(pos<0) {
		return null;
	}
	/* We split the string input for the update method into 2 parts
	 * The first part defines the field we want to change
	 * The second part defines the value we want to update
	 * We check if the fields are valid and then change their value
	 */
String s[]=st.split(" ");
if(s[0].trim().equalsIgnoreCase("Make")) {
	if(s[1]!=null&&s[1]!="")
	vh.get(pos).setMake(s[1].trim());
}
if(s[0].trim().equalsIgnoreCase("Model")) {
	if(s[1]!=null&&s[1]!="")
	vh.get(pos).setModel(s[1].trim());
}
if(s[0].trim().equalsIgnoreCase("id")) {
	int ids=Integer.parseInt(s[1].trim());
System.out.println(ids);
	vh.get(pos).setID(ids);
}
if(s[0].trim().equalsIgnoreCase("year")) {
int y=Integer.parseInt(s[1].trim());	
vh.get(pos).setyear(y);
}
return vh.get(pos);//returning the changed element
}

  }
  

