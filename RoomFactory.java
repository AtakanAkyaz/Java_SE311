import java.util.ArrayList;
import java.util.Scanner;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

abstract class RoomFactory {// create abstract RoomFactory to make other factories 
		public final void create(String name , ArrayList<Room> array) {// a method "create" which call abstract "hook" , "printInformation" , "addEquipments" methods...
			hook(name);												   //... so we don't need to call all of them one by one (Template method)
			addRooms(array);
		}
		protected final void printInformation(ArrayList<Room> arrayList) {// print the arrayList's objects
			System.out.println("Rooms : ");
			for (int i = 0 ; i< arrayList.size() ; i++) {
				System.out.print(i + " * " + arrayList.get(i)+" : ");
				arrayList.get(i).displayName();
			}
			System.out.println("**************************************");
		};
		protected abstract void addRooms(ArrayList<Room> arrayList);
		protected void hook(String a) {// a method for extra methods if the subclass needed to execute
		}
}


class EditRoomFactory extends RoomFactory{
	Scanner scan = new Scanner(System.in);
	Room editRoom;
	protected void hook(String a){// extra methods we need to add subclass
		editRoom = createEditRoom(a);
	}
	protected void addRooms(ArrayList<Room> arrayList) {// override the abstract class's method as needed and add object to "arrayList" variable
		arrayList.add(editRoom);
		
	}
	
	protected EditRoom createEditRoom(String a) { // create new EditRoom object by taken variable
		return new EditRoom(a,true,false);
	}
}


class ShootRoomFactory extends RoomFactory{
	Scanner scan = new Scanner(System.in);
	Room ShootRoom;
	protected void hook(String a){// extra methods we need to add subclass
		ShootRoom = createShootRoom(a);
	}
	protected void addRooms(ArrayList<Room> arrayList) {// override the abstract class's method as needed and add object to "arrayList" variable
		arrayList.add(ShootRoom);
		
	}
	
	protected ShootRoom createShootRoom(String a) { // create new ShootRoom object by taken variable
		return new ShootRoom(a,true,false);
	}
}
