package repository;

public interface ITaiKhoanNganHangRepository<T> {
    void them(T taiKhoanNganHang);
    void xoa(T taiKhoanNganHang);
    void xem();
    void tim();
}
