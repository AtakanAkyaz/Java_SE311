import java.util.ArrayList;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

class DepartmantPerson {
	private static DepartmantPerson departmantPerson = null;
	private static String name = null;
	ArrayList<Equipment> audioEquip;
	ArrayList<Equipment> videoEquip;
	ArrayList<Equipment> editEquip;

	
	private DepartmantPerson(String name,ArrayList<Equipment> _audioEquip,ArrayList<Equipment> _videoEquip,ArrayList<Equipment> _editEquip) {
		this.name=name;
		audioEquip= _audioEquip;
		videoEquip = _videoEquip;
		editEquip = _editEquip;
	}
	
	public void getName() {
		System.out.println(name);
	}
	//We didnt use public constructor for DepartmatPerson because we want only one DepartmantPerson so we call this method to create new DepartmatPerson if DepartmatPerson object is null . If DepartmatPerson is not null we call the DepartmatPerson which is already create before (Singleton)
	public static DepartmantPerson getDepartmantPerson(String s,ArrayList<Equipment> _audioEquip,ArrayList<Equipment> _videoEquip,ArrayList<Equipment> _editEquip) {

		if(departmantPerson == null) {
			departmantPerson=new DepartmantPerson(s,_audioEquip,_videoEquip,_editEquip);
			System.out.println("The new reservation person is created and its name is " + name);
		}
		else {
			System.out.println("There is already an reservation person and its name is " + name);
		}
		return departmantPerson;
	}

	public void setEquipment(int e,ArrayList<Equipment> ArrayName,Student _student){// Set the equipment state false
		ArrayName.get(e).Attach(_student);// attach student to object
		
		
		if(ArrayName.get(e).getState() == false ){
			//false
			System.out.println("The room is currently full, please try again later ");
			ArrayName.get(e).setState(false);
			System.out.println(_student.getName());
		}
		else{
			//true
			System.out.println("You Can Enter");
			ArrayName.get(e).setState(false);
			System.out.println("********************");
		}
		
	}

	public void letEquipState(int e,ArrayList<Equipment>  ArrayName,Student _student){//set Euipment's State to true
			ArrayName.get(e).setState(true);
			ArrayName.get(e).Detach(_student);// detach student from object
	}

	public void setRoom(int e,ArrayList<Room> ArrayName,Student _student){// Set the room state false
		ArrayName.get(e).Attach(_student);// attach student to object
		
		
		if(ArrayName.get(e).getState() == false ){
			//false
			System.out.println("The room is currently full, please try again later. ");
			ArrayName.get(e).setState(false);
			System.out.println("********************");

		}
		else{
			//true
			System.out.println("You Can Enter");
			ArrayName.get(e).setState(false);
			System.out.println("********************");
		}
	}

		public void letRoom(int e,ArrayList<Room>  ArrayName,Student _student){//set Room's State to true
			ArrayName.get(e).setState(true);
			ArrayName.get(e).Detach(_student);// detach student from object
	}

	// Invoker
	private ArrayList<Order> _order = new ArrayList<Order>();
	void Compute(Order order){// execute order and add order to _order arraylist
		order.Execute();
		_order.add(order);
	}


}
