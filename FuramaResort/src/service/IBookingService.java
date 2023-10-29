package model;

public interface IBookingService extends Service{
    void addNewBooking(Booking booking);
    void displayBookings();
}
