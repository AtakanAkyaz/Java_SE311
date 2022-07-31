// Ali Mentese
// Atakan Akyaz
// Burak Yalcin
// Egemen Ustaoglu
//Asset Management System
public interface Observer {
     void AudioEquipmentUpdate(AudioEquipment _AudioEquipment);

     void SofwareUpdate(EditEquipment _EditEquipment);

     void VideoEquipmentUpdate(VideoEquipment _VideoEquipment);

     void EditRoomUpdate(EditRoom _EditRoom);

     void ShootRoomUpdate(ShootRoom _ShootRoom);
}
