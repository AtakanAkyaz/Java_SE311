import java.util.ArrayList;
// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

public class Student implements Observer {
    private String StudentName;
    private boolean EquipmentState;
    private String EquipmentName;
    private AudioEquipment _AudioEquipment;
    private EditEquipment _EditEquipment;
    private VideoEquipment _VideoEquipment;
    private EditRoom _EditRoom;
    private String RoomName;
    private boolean RoomState;
    private ShootRoom _ShootRoom;




    public Student(String name) {
        StudentName = name;
    }
    
    public String getName() {
    	return StudentName;
    }

    public void set_EditRoom(EditRoom _EditRoom){
        this._EditRoom = _EditRoom;
    }

    public void set_ShootRoom(ShootRoom _ShootRoom) {
        this._ShootRoom = _ShootRoom;
    }

    public void set_AudioEquipment(AudioEquipment _AudioEquipment) {
        this._AudioEquipment = _AudioEquipment;
    }

    public void set_EditEquipment(EditEquipment _EditEquipment) {
        this._EditEquipment = _EditEquipment;
    }

    public void set_VideoEquipment(VideoEquipment _VideoEquipment) {
        this._VideoEquipment = _VideoEquipment;
    }

    @Override
    public void AudioEquipmentUpdate(AudioEquipment audioEquipment) { //When the notify method is called in the audio equipment class. It enters the audio equipment update method and notifies according to its status.
        _AudioEquipment = audioEquipment;
        EquipmentName = audioEquipment.getName();
        EquipmentState = audioEquipment.getState();

        if(EquipmentState == false){
            System.out.println(EquipmentName +" is Full : (Notified for " + StudentName +" )" );
        }
        else{
            System.out.println(EquipmentName +" is empty (Notified for " + StudentName +" )" );
        }
    }

    @Override
    public void EditRoomUpdate(EditRoom editRoom) {//When the notify method is called in the Edit Room class. It enters the Edit Room Update method and notifies according to its status.
        _EditRoom = editRoom;
        RoomName = editRoom.getName();
        RoomState = editRoom.getState();
        if(RoomState == false){
            System.out.println(RoomName +" is Full : (Notified for " + StudentName +" )" );
        }
        else{
            System.out.println(RoomName +" is empty (Notified for " + StudentName +" )" );
        }

    }

    @Override
    public void ShootRoomUpdate(ShootRoom shootRoom) {//When the notify method is called in the Shoot Room class. It enters the Shoot Room Update method and notifies according to its status.
        _ShootRoom = shootRoom;
        RoomName = shootRoom.getName();
        RoomState = shootRoom.getState();
        if(RoomState == false){
            System.out.println(RoomName +" is Full : (Notified for " + StudentName +" )" );
        }
        else{
            System.out.println(RoomName +" is empty (Notified for " + StudentName +" )" );
        }

    }


    public void SofwareUpdate(EditEquipment editEquipment){//When the notify method is called in the Sofware class. It enters the Sofware Update method and notifies according to its status.
        _EditEquipment = editEquipment;
        EquipmentName = editEquipment.getName();
        EquipmentState = editEquipment.getState();

        if(EquipmentState == false){
            System.out.println(EquipmentName +" is Full : (Notified for " + StudentName +" )" );
        }
        else{
            System.out.println(EquipmentName +" is empty (Notified for " + StudentName +" )" );
        }


    }

    public void VideoEquipmentUpdate(VideoEquipment videoequipment){//When the notify method is called in the Video Equipment class. It enters the Video Equipment Update method and notifies according to its status.
        _VideoEquipment = videoequipment;
        EquipmentName = videoequipment.getName();
        EquipmentState = videoequipment.getState();

        if(EquipmentState == false){
            System.out.println(EquipmentName +" is Full : (Notified for " + StudentName +" )" );
        }
        else{
            System.out.println(EquipmentName +" is empty (Notified for " + StudentName +" )" );
        }
    }




    public void getEquip(int e ,ArrayList<Equipment> EquipmentArray, DepartmantPerson p , Student s){ //To reserve equipment use depertman person's setEquipment method by taken variables
        p.setEquipment(e,EquipmentArray,s);
    }

    public void letEquip(int e, ArrayList<Equipment> EquipmentArray, DepartmantPerson p ,Student s){//To reserve equipment use depertman person's letEquipState method by taken variables
        p.letEquipState(e,EquipmentArray,s);
    }
    
    public void getRoom(int e ,ArrayList<Room> RoomArray, DepartmantPerson p , Student s){//To reserve room use depertman person's setRoom method by taken variables
        p.setRoom(e,RoomArray,s);
    }

    public void letRoom(int e, ArrayList<Room> RoomArray, DepartmantPerson p ,Student s){//To reserve room use depertman person's letRoom method by taken variables
        p.letRoom(e,RoomArray,s);
    }



}
