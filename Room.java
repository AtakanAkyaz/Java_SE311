import java.util.ArrayList;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

//this is an abstract class for rooms to make sure that every room which is extendede from "Room" has those methods. (For Abstract factory pattern)
abstract class Room {
	abstract public void displayName();
	abstract  public String getName();
	abstract  public void setState(boolean state);
	abstract public boolean getState();
	abstract  public void setLock(boolean lock);
	abstract public boolean getLock();
	abstract public void Attach (Student student);
	abstract public void Detach  (Student student);
	abstract public void showRooms(RoomFactory fac, ArrayList<Room> EditRooms, ArrayList<Room> ShootRooms) ;

}
// EditRoom extends from Room 
class EditRoom extends Room {
	protected  ArrayList<Student> students = new ArrayList<Student>();
	protected String Name;
	protected boolean State;
	boolean Lock;
	public EditRoom(String _Name, boolean _State , boolean _Lock) {
		Name = _Name;
		State = _State;
		Lock = _Lock;
	}

	@Override
	public void displayName() {
		// TODO Auto-generated method stub
		System.out.println(Name);
	}
	@Override
	public void setLock(boolean lock) {
		Lock = lock;
	}
	@Override
	public boolean getLock() {
		return Lock;
	}

	@Override
	public void setState(boolean state) {// change state of the object 
		// TODO Auto-generated method stub
		State =state;
		if(State == false){
			State =state;
			Notify(); // This is where we send notification to attached students when condition is changed
		}
		else{
			State =state;
			Notify();// This is where we send notification to attached students when condition is changed
		}
	}

	public void Notify(){// Notify the attached student if object's condition is changed
		for (int i = 0; i < students.size(); i++) {
			students.get(i).EditRoomUpdate(this);

		}

	}

	public String getName() {
		return Name;
	}

	@Override
	public boolean getState() {
		// TODO Auto-generated method stub
		return State;
	}

	@Override
	public void Attach(Student student) {// Attach student to students arrayList
		// TODO Auto-generated method stub
		students.add(student);
	}

	@Override
	public void Detach(Student student) {// Detach student from students arrayList
		// TODO Auto-generated method stub
		for (int i = 0; i< students.size(); i++) {

			if (students.get(i).getName().equals(student.getName())) {
				students.remove(i);
				return;
			}
		}
	}

	@Override
	public void showRooms(RoomFactory fac, ArrayList<Room> EditRooms, ArrayList<Room> ShootRooms) {// Show the all EditRooms objects
		// TODO Auto-generated method stub
			fac = new EditRoomFactory();
			fac.printInformation(EditRooms);
		}
	}

// Shoot Room

class ShootRoom extends Room{
	protected  ArrayList<Student> students = new ArrayList<Student>();
	protected String Name;
	protected boolean State;
	boolean Lock;

	public ShootRoom(String _Name, boolean _State , boolean _Lock) {
		Name = _Name;
		State = _State;
		Lock = _Lock;
	}

	@Override
	public void displayName() {
		// TODO Auto-generated method stub
		System.out.println(Name);
	}
	
	@Override
	public void setLock(boolean lock) {
		Lock = lock;
	}
	@Override
	public boolean getLock() {
		return Lock;
	}

	@Override
	public void setState(boolean state) {// change the state of the Software object
		// TODO Auto-generated method stub
		State =state;
		if(State == false){
			State =state;
			Notify();// This is where we send notification to attached students when condition is changed
		}
		else{
			State =state;
			Notify();// This is where we send notification to attached students when condition is changed
		}
	}


	public String getName() {
		return Name;
	}


	public void Notify(){// Notify the attached student 
		for (int i = 0; i < students.size(); i++) {
			students.get(i).ShootRoomUpdate(this);

		}

	}


	@Override
	public boolean getState() {
		// TODO Auto-generated method stub
		return State;
	}

	@Override
	public void Attach(Student student) {// Attach student to students arrayList
		// TODO Auto-generated method stub
		students.add(student);
	}

	@Override
	public void Detach(Student student) {// Detach student from students arrayList
		// TODO Auto-generated method stub
		for (int i = 0; i< students.size(); i++) {

			if (students.get(i).getName().equals(student.getName())) {
				students.remove(i);
				return;
			}
		}
	}

	@Override
	public void showRooms(RoomFactory fac, ArrayList<Room> EditRooms, ArrayList<Room> ShootRooms) {// Show the all ShootRooms objects
		// TODO Auto-generated method stub
			fac = new ShootRoomFactory();
			fac.printInformation(ShootRooms);
		}
	}
