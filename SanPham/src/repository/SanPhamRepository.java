package repository;

import entities.SanPham;
import java.util.ArrayList;
import java.util.List;
import service.SanPhamINTF;
import utils.JDBCHelper;

public class SanPhamRepository implements SanPhamINTF {

    String findAllData = "SELECT * FROM SanPham";
    String select_trangThai = "SELECT * FROM SanPham Where TrangThai = 0";
    String selectID1 = "SELECT * FROM SanPham where IDSanPham = ?";
    String selectID = "SELECT * FROM SanPham where Ma_SanPham = ?";
    String insert = "INSERT INTO [SanPham] ([ID_LoaiSanPham], [ID_ThuongHieu], [Ma_SanPham], [KieuDang], [TenSanPham], [Url_Anh], [TrangThai])"
            + " VALUES (?,?,?,?,?,?,?,?)";
    String update = "Update SanPham set TenSanPham = ?, KieuDang = ?, ID_ThuongHieu = ?, Url_Anh =?, TrangThai = ? where Ma_SanPham = ?";
    String delete = "DELETE FROM SanPham where IDSanpham = ?";
    String selectById = "select * from Vi where IDVi =?";
    String select_Trangthai1 = "SELECT * FROM SanPham WHERE Trangthai = 1";

    @Override
    public void insert(SanPham sp) {
        JDBCHelper.update(insert, sp.getMaSanPham(), sp.getKieuDang(), sp.getTenSanPham(), sp.getUrl_Anh(), sp.isTrangThai());
    }

    @Override
    public void update(SanPham sp) {
        JDBCHelper.update(update, sp.getIdLoaiSanPham(), sp.getIdThuongHieu(), sp.getMaSanPham(), sp.getKieuDang(), sp.getTenSanPham(), sp.isTrangThai(), sp.getUrl_Anh());
    }


    @Override
    public List<SanPham> findAllData() {
//      return select 
    }

    @Override
    public SanPham selectID(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getTotal() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham selectID1(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
