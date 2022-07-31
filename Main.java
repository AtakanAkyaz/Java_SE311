
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		ArrayList<Equipment> audioEquip = new ArrayList<Equipment>();
		ArrayList<Equipment> videoEquip = new ArrayList<Equipment>();
		ArrayList<Equipment> editEquip = new ArrayList<Equipment>();
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Room> shootRooms = new ArrayList<Room>();
		ArrayList<Room> editRooms = new ArrayList<Room>();
		Order order = null;
		Security security = new Security();



		EquipmentFactory EquipFac ;
		RoomFactory RoomFac;
		
		RoomFac = new EditRoomFactory();
		RoomFac.create("roomm5",editRooms);
		RoomFac = new EditRoomFactory();
		RoomFac.create("roomm3",editRooms);
		RoomFac = new ShootRoomFactory();
		RoomFac.create("roomm6",shootRooms);

		
		
		while(flag) {
			DepartmantPerson dPerson = DepartmantPerson.getDepartmantPerson("Atakan", audioEquip, videoEquip, editEquip);
			System.out.println("Choose your process \n 1. Departmant Person \n 2. Student \n 3. To quit system");
			int key = scan.nextInt();
			switch(key) {
				case 1:
					System.out.println("Choose what you want to do \n 1. Add equipment \n 2. Show equipments" );
					int key2 = scan.nextInt();
					switch(key2) {
						case 1:
							System.out.println("Which type of equipment you want to add \n 1. Audio equipment \n 2. Video equipment \n 3. Edit equipment");
							int key3 = scan.nextInt();
							switch(key3) {
								case 1:
									System.out.print("Name of the audio equipment : ");
									String audioEquipName = scan.next();
									EquipFac = new AudioEquipmentFactory();
									EquipFac.create(audioEquipName, audioEquip);
									break;
								case 2:
									System.out.print("Name of the video equipment : ");
									String videoEquipName = scan.next();
									EquipFac = new VideoEquipmentFactory();
									EquipFac.create(videoEquipName, videoEquip);
									break;
								case 3:
									System.out.print("Name of the edit equipment : ");
									String editEquipName = scan.next();
									EquipFac = new EditEquipmentFactory();
									EquipFac.create(editEquipName, editEquip);
									break;
								default:
									System.out.println("You enter the wrong selection");
									break;
							}
							break;
						case 2:
							EquipFac = new AudioEquipmentFactory();
							EquipFac.printInformation(audioEquip);
							EquipFac = new VideoEquipmentFactory();
							EquipFac.printInformation(videoEquip);
							EquipFac = new EditEquipmentFactory();
							EquipFac.printInformation(editEquip);
							break;
						default:
							System.out.println("You enter the wrong selection");
							break;
						
					}
					break;
				case 2:
					/*Adding a new student by taken name from user if the student is already inside the 
					student array return the student dont add second time. (Kinda like singleton)*/
					System.out.println("Give the student name");
					String name = scan.next();
					Student std = new Student(name);
					if(students.size()==0) {
						students.add(std);
					}
					else {
						for(int i = 0 ;i<students.size();i++) {
						if(std.getName().equals(students.get(i).getName())) {
							std = students.get(i);
						}
						else {
							students.add(std);
						}
					}
					}
					
					
					System.out.println("Choose your process \n 1. Show avaible equipments \n 2. Request equipments \n 3. Leave equipment \n 4. Show avaible rooms \n 5. Request room \n 6. Leave room");
					int key4 = scan.nextInt();
					switch(key4) {
						case 1:
							EquipFac = new AudioEquipmentFactory();
							EquipFac.printInformation(audioEquip);
							EquipFac = new VideoEquipmentFactory();
							EquipFac.printInformation(videoEquip);
							EquipFac = new EditEquipmentFactory();
							EquipFac.printInformation(editEquip);
							break;
						case 2:
							System.out.println("Which type of equipment you want to rent \n 1. Audio equipment \n 2. Video equipment \n 3. Edit equipment");
							int key5 = scan.nextInt();
							switch(key5){
								case 1:
									EquipFac = new AudioEquipmentFactory();
									EquipFac.printInformation(audioEquip);
									int audioSelection = scan.nextInt();
									std.getEquip(audioSelection, audioEquip, dPerson, std);
									break;
								case 2:
									EquipFac = new VideoEquipmentFactory();
									EquipFac.printInformation(videoEquip);
									int videoSelection = scan.nextInt();
									std.getEquip(videoSelection, videoEquip, dPerson, std);
									break;
								case 3:
									EquipFac = new EditEquipmentFactory();
									EquipFac.printInformation(editEquip);
									int editSelection = scan.nextInt();
									std.getEquip(editSelection, editEquip, dPerson, std);
									break;
								default:
									System.out.println("You enter the wrong selection");
									break;
							}
							break;
						case 3:
							System.out.println("Which type of equipment you want to leave \n 1. Audio equipment \n 2. Video equipment \n 3. Edit equipment");
							int key6 = scan.nextInt();
							switch(key6){
								case 1:
									EquipFac = new AudioEquipmentFactory();
									EquipFac.printInformation(audioEquip);
									int audioSelection = scan.nextInt();
									std.letEquip(audioSelection, audioEquip, dPerson, std);
									break;
								case 2:
									EquipFac = new VideoEquipmentFactory();
									EquipFac.printInformation(videoEquip);
									int videoSelection = scan.nextInt();
									std.letEquip(videoSelection, videoEquip, dPerson, std);
									break;
								case 3:
									EquipFac = new EditEquipmentFactory();
									EquipFac.printInformation(editEquip);
									int editSelection = scan.nextInt();
									std.letEquip(editSelection, editEquip, dPerson, std);
									break;
								default:
									System.out.println("You enter the wrong selection");
									break;
							}
							break;
						case 4: 
							RoomFac = new EditRoomFactory();
							RoomFac.printInformation(editRooms);
							RoomFac = new ShootRoomFactory();
							RoomFac.printInformation(shootRooms);
							break;
						case 5:
							System.out.println("Which type of room you want to rent \n 1. Edit room \n 2. Shoot room");
							int key7 = scan.nextInt();
							switch(key7){
								case 1:
									RoomFac = new EditRoomFactory();
									RoomFac.printInformation(editRooms);
									int editRoomSelection = scan.nextInt();
									std.getRoom(editRoomSelection, editRooms, dPerson, std);
									order = new UnlockDoor(security,editRooms.get(editRoomSelection),true);// Comment pattern security unlocks the EditingRoom
									dPerson.Compute(order);
									break;
								case 2:
									RoomFac = new ShootRoomFactory();
									RoomFac.printInformation(shootRooms);
									int shootRoomSelection = scan.nextInt();
									std.getRoom(shootRoomSelection, shootRooms, dPerson, std);
									order = new UnlockDoor(security,shootRooms.get(shootRoomSelection),true);// Comment pattern security unlocks the ShootRoom
									dPerson.Compute(order);
									break;
								default:
									System.out.println("You enter the wrong selection");
									break;
							}
							break;
						default:
							System.out.println("You enter the wrong selection");
							break;
						case 6:
							System.out.println("Which type of room you want to leave \n 1. Edit room \n 2. Shoot room");
							int key8 = scan.nextInt();
							switch(key8){
							case 1:
								RoomFac = new EditRoomFactory();
								RoomFac.printInformation(editRooms);
								int editRoomSelection = scan.nextInt();
								std.letRoom(editRoomSelection, editRooms, dPerson, std);

								break;
							case 2:
								RoomFac = new ShootRoomFactory();
								RoomFac.printInformation(shootRooms);
								int shootRoomSelection = scan.nextInt();
								std.letRoom(shootRoomSelection, shootRooms, dPerson, std);

								break;
								default:
									System.out.println("You enter the wrong selection");
									break;
							}
							break;
							
					}
					break;
				case 3:
					System.out.println("System is TERMINATING...");
					flag = false;
					break;
				default:
					System.out.println("You enter the wrong selection");
					break;
			}
		}
	}
}


