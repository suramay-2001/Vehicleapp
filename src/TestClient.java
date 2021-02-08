import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class TestClient {
public static void main(String args[]) throws IOException {
	interact ar= new interact();//new interact object
	ArrayList <Vehicle>vhh=new ArrayList<Vehicle>();//arraylist to store vehicles obtained in getall()
	Scanner in = new Scanner (System.in);//scanner input object
	String ch="";//character to check quit condition
	while(ch!="q"){
		
		System.out.println("please enter q to quit or GET,CREATE,UPDATE,DELETE with Vehicles or Vehicles/{id} route");
		String st=in.nextLine();//accepting user input
		String[] st1=st.split(" ");
	if(st1[0].equals("CREATE")) {
		if(st1[1].trim().contentEquals("Vehicles")) {
			System.out.println("Enter the details of the Vehicle in the order id year Make Model");
			String sw=in.nextLine();
			String[] sw1=sw.split(" ");
			if(Integer.parseInt(sw1[1])>2050||Integer.parseInt(sw1[1])<1950) {
				//checking for a valid year input
				System.out.println("Enter the year between 1950 and 2050");
			}
			else if(sw1[2].isBlank()||sw1[2].isEmpty()||sw1[2]==null||sw1[3].isBlank()||sw1[3].isEmpty()||sw1[3]==null) {
				System.out.println("You have entered invalid fields");//filters out invalid input.
			}else {
			ar.createVehicle(Integer.parseInt(sw1[0]), Integer.parseInt(sw1[1]), sw1[2], sw1[3]);//if all inputs are valid
			//the vehicle is created and added in the arraylist of the interact class object.
			}
		}
	}
	if(st1[0].contentEquals("UPDATE")){
		/*
		 * first the user asks for an update request
		 * then the id for the vehicle is asked and the user provides that
		 * after the id is searched if the id exists then 
		 * the field and the value of the field is prompted
		 * if the element with the id is found 
		 * then the field asked is updated with the value
		 */
		if(st1[1].trim().contentEquals("Vehicles")) {
			System.out.println("Enter the ID of the vehicle you want to alter along with the field and the value seperated by spaces");
			String s=in.nextLine();
			String accept[] =s.split(" ");
			String s1=accept[1]+" "+accept[2];
			Vehicle v=ar.update(Integer.parseInt(accept[0]),s1);
			if(v==null) {
				System.out.println("Could not update");
			}
			else {
				System.out.println("The updated item has id,year,make,and model as "+v.getID()+" "+v.getyear()+" "+v.getMake()+" "+v.getModel());
			}
			
		}
		
	}

	if(st1[0].equalsIgnoreCase("DELETE")) {
		/*
		 * the user has only one route for this option and needs to enter the id to delete
		 * the ID is extracted and searched if the element exists in the system 
		 * if the element with a matching id exists then the program 
		 * deletes and  prints the deleted element info to the user.
		 */
		if(st1[1].contains("Vehicles/")) {
			int pos=0;int pos1=0;
			String id="";
		for(int i=0;i<st1[1].length();i++) {
			if(st1[1].charAt(i)=='{') {
				pos=i;
			}
			else if(st1[1].charAt(i)=='}') {
				pos1=i;
			}
		}
		if(pos1>pos) {
			id=st1[1].substring(pos+1, pos1);
			Vehicle v=ar.deletebyId(Integer.parseInt(id));
			System.out.println("The deleted item has id,year,make,and model as"+v.getID()+" "+v.getyear()+" "+v.getMake()+" "+v.getModel());
		}
		else {
			System.out.println("There is an error in the input");
			}
		
	}
	}
	
	if(st1[0].equals("GET")) {
		/*
		 * We first check if the user has asked for GET
		 * then we check for the route
		 */
	
		if(st1[1].equalsIgnoreCase("Vehicles")) {
			/*
			 * if the user chooses this route then the route will get
			 * all the vehicle objects and print their information
			 */
			vhh=ar.getall();
			for(int i=0;i<vhh.size();i++) {
				System.out.println(vhh.get(i).getID()+" "+vhh.get(i).getyear()+" "+vhh.get(i).getMake()+" "+vhh.get(i).getModel()+" ");
			}
		}
		else if(st1[1].contains("Vehicles/")) {
			/*
			 * if the user chooses this route then the id will be extracted 
			 * and the element will be searched by id 
			 * if the requests element exists then the user will recieve 
			 * information about it
			 */
			int pos=0;int pos1=0;
			String id="";
			for(int i=0;i<st1[1].length();i++) {
				if(st1[1].charAt(i)=='{') {
					pos=i;
				}
				else if(st1[1].charAt(i)=='}') {
					pos1=i;
				}
			}
			if(pos1>pos) {
				id=st1[1].substring(pos+1, pos1);
				Vehicle v=ar.getbyId(Integer.parseInt(id));
				System.out.println("The item requested has id,year,make,and model as "+v.getID()+" "+v.getyear()+" "+v.getMake()+" "+v.getModel());
			}
		}
	}
	/*
	 * if the character entered by the user is q then the program exits.
	 */
	if(st1[0].trim().contentEquals("q")) {
		ch="q";
		break;
	}

	}
	
	
}
}
