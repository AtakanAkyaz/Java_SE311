// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System
//Receiver
class Security{

    public void Action(Room _Room ,boolean _OpenCLose){//If compute method execute order then security notifies according to its status.

        if(_OpenCLose == true){
            System.out.println(_Room.getName()+" is Unlocked by Security");
        }
        else{
            System.out.println(_Room.getName()+ " is locked by Security");
        }

    }
}