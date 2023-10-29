package repository;

import model.TaiKhoanNganHang;
import model.TaiKhoanThanhToan;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanNganHangRepository implements ITaiKhoanNganHangRepository<TaiKhoanNganHang> {
    private static final String PATH = "data/bank_accounts.csv";
    private static final List<TaiKhoanNganHang> LIST_TAI_KHOAN = new ArrayList<>();

    static {
        List<String> dataList = ReadAndWrite.readFile(PATH);
        for (String data : dataList) {
            String[] d = data.split(",");
            TaiKhoanNganHang benhAn = createBenhAnFromData(d);
            LIST_TAI_KHOAN.add(benhAn);
        }
    }

    @Override
    public void them(TaiKhoanThanhToan taiKhoanNganHang) {

    }

    @Override
    public void xoa(TaiKhoanThanhToan taiKhoanNganHang) {

    }

    @Override
    public void xem() {

    }

    @Override
    public void tim() {

    }
}
