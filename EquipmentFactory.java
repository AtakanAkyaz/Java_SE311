import java.util.ArrayList;
import java.util.Scanner;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

abstract class EquipmentFactory {// create abstract EquipmentFactory to make other factories 
	public final void create(String name , ArrayList<Equipment> array) {// a method "create" which call abstract "hook" , "printInformation" , "addEquipments" methods...
		hook(name);														//... so we don't need to call all of them one by one (Template method)
		addEquipments(array);
		printInformation(array);
	}
	protected final void printInformation(ArrayList<Equipment> arrayList) {// print the arrayList's objects
		System.out.println("Audio equipments : ");
		for (int i = 0 ; i< arrayList.size() ; i++) {
			System.out.print(i + " * " + arrayList.get(i)+" : ");
			arrayList.get(i).displayName();
		}
		System.out.println("**************************************");
	};
	protected abstract void addEquipments(ArrayList<Equipment> arrayList);
	protected void hook(String a) {// a method for extra methods if the subclass needed to execute
	}
}


class AudioEquipmentFactory extends EquipmentFactory {
	Scanner scan = new Scanner(System.in);
	Equipment microphone;
	Equipment LoudSpeaker;
	Equipment Amplifier;
	@Override
	protected void hook(String a){// extra methods we need to add subclass 
		microphone = createMicrophone();
		Amplifier = createAmplifier();
		LoudSpeaker = createLoudSpeaker();
	}
	@Override
	protected void addEquipments(ArrayList<Equipment> arrayList) {// override the abstract class as needed and add object to "arrayList" variable
		arrayList.add(microphone);
		arrayList.add(LoudSpeaker);
		arrayList.add(Amplifier);
		
	}
	
	protected AudioEquipment createMicrophone() { // create new Micraphone object by taken variable
		System.out.println("Give Micraphone name");
		String microphoneName = scan.next();
		return new Microphone(microphoneName,true );
	}

	protected AudioEquipment createAmplifier() {// create new Amplifier object by taken variable
		System.out.println("Give Amplifier name");
		String amplifierName = scan.next();
		return new Amplifier(amplifierName,true);
	}

	protected AudioEquipment createLoudSpeaker() {// create new LoudSpeaker object by taken variable
		System.out.println("Give Loud Speaker name");
		String loudSpeakerName = scan.next();
		return new LoudSpeaker(loudSpeakerName,true);
	}				
	
}
	

class EditEquipmentFactory extends EquipmentFactory {
	Scanner scan = new Scanner(System.in);
	Equipment softWare;
	@Override
	protected void hook(String name) {// extra methods we need to add subclass 
		softWare = createEditEquipment();
	}
	
	@Override
	protected void addEquipments(ArrayList<Equipment> arrayList) {// override the abstract class as needed and add object to "arrayList" variable
		// TODO Auto-generated method stub
		arrayList.add(softWare);
	}
	protected EditEquipment createEditEquipment() {// create new SoftWare object by taken variable
		System.out.println("Give Software name");
		String softwareName = scan.next();
		return new Software(softwareName , true);
	}	
	
}

	
class VideoEquipmentFactory extends EquipmentFactory {
	Scanner scan = new Scanner(System.in);
	VideoEquipment camera ;
	VideoEquipment tripod ;
	LightingKit lightStand ;
	LightingKit powerSupply ;
	LightingKit umbrella ;
	@Override
	public void hook(String a){// extra methods we need to add subclass 
		camera =createCamera();
		tripod = createTripod();
		lightStand = createLightStand();
		powerSupply = createPowerSupply();
		umbrella = createUmbrella();
	}

	@Override
	protected void addEquipments(ArrayList<Equipment> arrayList) {// override the abstract class as needed and add object to "arrayList" variable
		// TODO Auto-generated method stub
		arrayList.add(camera);
		arrayList.add(tripod);
		arrayList.add(lightStand);
		arrayList.add(powerSupply);
		arrayList.add(umbrella);
	}
	
	protected Camera createCamera() {// create new Camera object by taken variable
		System.out.println("Give Camera name");
		String cameraName = scan.next();
		return new Camera(cameraName,true);
	}					
	
	protected Tripod createTripod() {// create new Tripod object by taken variable
		System.out.println("Give Tripod name");
		String tripodName = scan.next();
		return new Tripod(tripodName ,true);
	}
	
	protected LightStand createLightStand() {	// create new LightStand object by taken variable
		System.out.println("Give Light Stand name");
		String lightStandName = scan.next();
		return new LightStand(lightStandName/*,10*/,true);
	}

	protected PowerSupply createPowerSupply() {// create new PowerSupply object by taken variable
		System.out.println("Give Power Supply name");
		String powerSupplyName = scan.next();
		return new PowerSupply(powerSupplyName,true);
	}

	protected Umbrella createUmbrella() {// create new Umbrella object by taken variable
		System.out.println("Give Umbrella name");
		String umbrellaName = scan.next();
		return new Umbrella(umbrellaName,true);
	}	

}

