// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System

interface Order{
    public void Execute();
}

//ConcreteCommand
class UnlockDoor implements  Order{
    private Security security;
    private Room  Room;
    private boolean OpenClose;

    public UnlockDoor(Security _security, Room _Room , boolean _OpenClose){
        security = _security;
        Room = _Room;
        OpenClose = _OpenClose;
    }



    @Override
    public void Execute() {
        security.Action(Room,OpenClose );
    }
}