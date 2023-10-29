package model;

public interface IFacilityService extends Service{
    void addNewVilla(Villa villa);
    void addNewHouse(House house);
    void addNewRoom(Room room);
    void displayVillas();
    void displayHouses();
    void displayRooms();
}