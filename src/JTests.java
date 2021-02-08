import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.Test;

class JTests {
	private interact ar;//interact instance for testing
	private Vehicle v;//vehicle instance for testing
	@After
	public void teardown() {
		ar=null;//setting null values after each test
		v=null;
	}
	@Test
public void getVehicleTest() {
		try {
			v=new Vehicle(23,"Toyota",2010,"Camry");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//checks all the getter methods 
	if(v.getID()!=23||v.getyear()!=2010||v.getMake()!="Toyota"||v.getModel()!="Camry") {
		fail("The getter methods need to be fixed");
	}

	
	
}
	@Test
public void setVehicleTest() {
	try {
		v=new Vehicle(23,"Toyota",2010,"Camry");//creating a new vehicle instance
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*setting fields to check setter methods in the vehicle class*/
	v.setID(12);
	v.setMake("Honda");
	v.setModel("Civic");
	v.setyear(2009);
	/*getting the values of vehicle after the setter 
	*methods are called to check if they have updates
	*/
	if(v.getID()!=12||v.getyear()!=2009||v.getMake()!="Honda"||v.getModel()!="Civic") {
		fail("The setter methods need to be fixed");
	}
	
}

	@Test
	void createVehicletest() {
		/*checking if a vehicle can be created from the interact class successfully*/
		ar=new interact();
		ar.createVehicle(24,2008, "Mitsubishi", "Pajero");
		if (ar.getbyId(24)==null) {
			fail("The create method has to be fixed, its not able to create vehicle");
		}
		
	}
	@Test
	void getallTest() {
		/*
		 * we create an instance of the interact class and add vehicles to it
		 * then we store the added items field
		 * after that we see if all the added items reflect in the arraylist
		 * by using getall() function
		 * after that we match the fields of the objects we just created
		 * and if they exist in the list
		 */
		ar=new interact();
		ar.createVehicle(24,2008, "Mitsubishi", "Pajero");
		ar.createVehicle(23,2007, "Honda", "CRV");
		ar.createVehicle(30,2007, "Suzuki", "Jimmy");
		int id[]= {24,23,30};
		int year[]= {2008,2007,2007};
		String make[]= {"Mitsubishi","Honda","Suzuki"};
		String Model[]= {"Pajero","CRV","Jimmy"};
		if(ar.getall().size()!=3) {
			fail("The getall method is facing a problem, it is not adding items properly");
		}
		ArrayList<Vehicle>vh=ar.getall();
		for(int i=0;i<vh.size();i++) {
			if(vh.get(i).getID()!=id[i]) {
				fail("There is a problem in storing vehicle fields for interact class");
			}
			if(vh.get(i).getyear()!=year[i]) {
				fail("There is a problem in storing vehicle fields for interact class");
			}
			if(!vh.get(i).getMake().equals(make[i])) {
				fail("There is a problem in storing vehicle fields for interact class");
			}
			if(!vh.get(i).getModel().equals(Model[i])) {
				fail("There is a problem in storing vehicle fields for interact class");
			}

		}
	}
	@Test
	void deleteTests() {
		/*
		 * we create 3 vehicle elements in the list and 
		 * check if the delted element reflects in the arraylist size
		 * after that we check the ids of the vehicle and if there is a matching id
		 * then we can say that the delete method has a problem
		 */
		ar=new interact();
		ar.createVehicle(24,2008, "Mitsubishi", "Pajero");
		ar.createVehicle(23,2007, "Honda", "CRV");
		ar.createVehicle(30,2007, "Suzuki", "Jimmy");
		v=ar.deletebyId(23);
		ArrayList<Vehicle>vh=ar.getall();
		if(vh.size()!=2) {
			fail("There is a problem in deletebyID method");
		}
for(int i=0;i<vh.size();i++) {
	if(v.getID()==vh.get(i).getID()) {
		fail("The element still exists, delete is not wworking");
	}
}
	}
	@Test
	void updateTests() {
		/*
		 * At first we create 2 vehicles and
		 * add it to the interact object that we have 
		 * after that  we update one vehicle objects field
		 * and then check if that change is reflected in the persistent
		 * arraylist in the interact class to confirm updates
		 */
		ar=new interact();
		ar.createVehicle(24,2008, "Mitsubishi", "Pajero");
		ar.createVehicle(23,2007, "Honda", "CRV");
	  ar.update(24, "Make Toyota");
      if(!ar.getbyId(24).getMake().equals("Toyota")) {
    	  fail("The Make is not updated by the update method in interact class");
      }
      ar.update(24, "Model Camry");
      if(!ar.getbyId(24).getModel().equals("Camry")) {
    	  fail("The model is not updated by the update method in interact class");
      }
      ar.update(24, "year 2009"); 
      if(ar.getbyId(24).getyear()!=2009) {
    	  fail("The year is not updated by the update method in interact class");
      }
      ar.update(24, "id 36");
       if(ar.getbyId(36)==null) {
    	   fail("The ID is not updated by the update method in interact class");
       }
		}

}
