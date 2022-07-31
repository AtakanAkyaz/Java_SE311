import java.util.ArrayList;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

// this is an abstract class for equipments to make sure that every equipmet which is extendede from "Equipmet" has those methods. (For Abstract factory pattern)
public abstract class Equipment {

	abstract public void displayName();
	abstract  public void setState(boolean state);
	abstract public boolean getState();
	abstract public void Attach (Student student);
	abstract public void Detach  (Student student);
	abstract public void showEquipments(EquipmentFactory fac,ArrayList<Equipment> _audioEquip,ArrayList<Equipment> _videoEquip,ArrayList<Equipment> _editEquip) ;
}
// Software extends from EditEquipment
class Software extends EditEquipment {
	public Software(String _Name, boolean _State) {
		super(_Name, _State);
	}
	public void setState(boolean state) { // change the state of the Software object
		State =state;
		if(State == false){
			State =state;
			Notify();// This is where we send notification to attached students when condition is changed
		}
		else{
			State =state;
			Notify();
		}
	}
	public boolean getState() {// get state of the Software object's state
		return State;
	}
}
//Edit equipment extends form "Equipments"
class EditEquipment extends Equipment{
	protected ArrayList<Student> students = new ArrayList<Student>();
	protected String Name;
	protected boolean State;

	public String getName() {
		return Name;
	}
	
	public EditEquipment(String _Name, boolean _State){
		Name = _Name;
		State = _State;
	}

	public void Attach (Student student){// Attach student to students arrayList
		students.add(student);
	}

	@Override
	public void Detach(Student student) {// Detach student from students arrayList
		for (int i = 0; i< students.size(); i++) {

			if (students.get(i).getName().equals(student.getName())) {
				students.remove(i);
				return;
			}
		}
	}



	public void Notify(){// Notify the attached student
		for (int i = 0; i < students.size(); i++) {
			students.get(i).SofwareUpdate(this);

		}

	}

	public boolean getState() {
		return State;
	}

	@Override
	public void displayName() {

		System.out.println(Name);
	}

	@Override
	public void setState(boolean state) {
		
	}

	@Override
	public void showEquipments(EquipmentFactory fac, ArrayList<Equipment> audioEquip, ArrayList<Equipment> videoEquip,
			ArrayList<Equipment> editEquip) {// Show the all EditEquipment objects
		fac = new EditEquipmentFactory();
		fac.printInformation(editEquip);
		
	}

}

// Video Equipment

class Camera extends VideoEquipment {


	public Camera(String _Name, boolean _State) {
		super(_Name, _State);
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}


	public boolean getState() {// get state of the Software object's state
		return State;
	}

}

class Tripod extends VideoEquipment {


	public Tripod(String _Name, boolean _State) {
		super(_Name, _State);
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {// get state of the Software object's state
		return State;
	}
}

class LightingKit extends VideoEquipment {
		
	protected String Name;

	public LightingKit(String _Name, boolean _State) {
		super(_Name, _State);
		Name = _Name;
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {// get state of the Software object's state
		return State;
	}

	/*protected int model;*/
	
	public void displayName() {
		System.out.println(Name);
	}
	

}

class LightStand extends LightingKit {



	public LightStand(String _Name, boolean _State) {
		super(_Name, _State);
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {
		return State;
	}
}

class PowerSupply extends LightingKit {
	public PowerSupply(String _Name, boolean _State) {
		super(_Name, _State);
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {
		return State;
	}
	
}

class Umbrella extends LightingKit {
	public Umbrella(String _Name, boolean _State) {
		super(_Name, _State);
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {
		return State;
	}
	
}


 class VideoEquipment extends Equipment {
	protected ArrayList<Student> students = new ArrayList<Student>();
	protected String Name;
	protected boolean State;

	public String getName() {
		return Name;
	}

	public VideoEquipment(String _Name, boolean _State){
		Name = _Name;
		State = _State;
	}

	public void Attach (Student student){// Attach student to students arrayList
		students.add(student);

	}

	@Override
	public void Detach(Student student) {// Detach student from students arrayList
		for (int i = 0; i< students.size(); i++) {

			if (students.get(i).getName().equals(student.getName())) {
				students.remove(i);
				return;
			}
		}
	}


	public void Notify(){// Notify the attached student 
		for (int i = 0; i < students.size(); i++) {
			students.get(i).VideoEquipmentUpdate(this);
		}
	}

	public boolean isState() {
		return State;
	}

	@Override
	public void displayName() {
		System.out.println(Name);
	}

	@Override
	public void setState(boolean state) {

	}

	@Override
	public boolean getState() {
		return State;
	}

	@Override
	public void showEquipments(EquipmentFactory fac, ArrayList<Equipment> audioEquip, ArrayList<Equipment> videoEquip,
			ArrayList<Equipment> editEquip) {
		fac = new VideoEquipmentFactory();
		fac.printInformation(videoEquip);
		
	}

}

 // Audio Equipment
 

class Microphone extends AudioEquipment {


	public Microphone(String _Name, boolean _State) {
		super(_Name, _State);
	}
	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {
		return State;
	}
}

class Amplifier extends AudioEquipment {


	public Amplifier(String _Name, boolean _State) {
		super(_Name, _State);
	}
	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {
		return State;
	}
}

class LoudSpeaker extends AudioEquipment {


	public LoudSpeaker(String _Name, boolean _State) {
		super(_Name, _State);
	}

	public void setState(boolean state) {// change the state of the Software object
		State =state;
		Notify();// This is where we send notification to attached students when condition is changed
	}
	public boolean getState() {
		return State;
	}
}


 class AudioEquipment extends Equipment {
	protected  ArrayList<Student> students = new ArrayList<Student>();
	protected String Name;
	protected boolean State;

	public String getName() {
		return Name;
	}

	public AudioEquipment(String _Name, boolean _State){
		Name = _Name;
		State = _State;
	}
	public void Attach (Student student){// Attach student to students arrayList
		students.add(student);

	}

	@Override
	public void Detach(Student student) {// Detach student from students arrayList
		for (int i = 0; i< students.size(); i++) {
			if (students.get(i).getName().equals(student.getName())) {
				students.remove(i);
				return;
			}
		}
	}


	public void Notify(){// Notify the attached student 
		for (int i = 0; i < students.size(); i++) {
			students.get(i).AudioEquipmentUpdate(this);
		}
	}

	public boolean getState() {
		return State;
	}
	
	@Override
	public void displayName() {
		System.out.println(Name );
	}

	@Override
	public void setState(boolean state) {

	}

	@Override
	public void showEquipments(EquipmentFactory fac, ArrayList<Equipment> audioEquip, ArrayList<Equipment> videoEquip,
			ArrayList<Equipment> editEquip) {// Show the all EditEquipment objects
		fac = new AudioEquipmentFactory();
		fac.printInformation(audioEquip);
		
	}




}