package repository;

import entities.LoaiSanPham;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import service.INTFLoaiSanPham;
import utils.JDBCHelper;

public class LoaiSanPhamRepository implements INTFLoaiSanPham {

    private static final Logger logger = Logger.getLogger(LoaiSanPhamRepository.class.getName());

    String selectAll = "select * from LoaiSanPham";
    String selectID = "select * from LoaiSanPham where Ma_LoaiSanPham= ?";
    String selectById = "select * from LoaiSanPham where IDLoaiSanPham =?";
    String update = "update LoaiSanPham set  TenLoaiSanPham =?, TrangThai=? where Ma_LoaiSanPham=?";
    String insert = "INSERT INTO LoaiSanPham (Ma_LoaiSanPham, TenLoaiSanPham, TrangThai) VALUES (?, ?, ?)";

    @Override
    public void insert(LoaiSanPham sp) {
//        JDBCHelper.update(insert, sp.getMaLoaiSanPham(), sp.getTenLoaiSanPham(), sp.isTrangThai());
        JDBCHelper.update(insert, sp.getMaLoaiSanPham(), sp.getTenLoaiSanPham(), sp.isTrangThai());
    }

    @Override
    public void update(LoaiSanPham sp) {
//        JDBCHelper.update(update, sp.getTenLoaiSanPham(), sp.isTrangThai(), sp.getMaLoaiSanPham());
        JDBCHelper.update(update, sp.getTenLoaiSanPham(), sp.isTrangThai(), sp.getMaLoaiSanPham());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LoaiSanPham selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<LoaiSanPham> selectBySQL(String sql, Object... args) {
        List<LoaiSanPham> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                LoaiSanPham ms = new LoaiSanPham();
                ms.setIdLoaiSanPham(rs.getInt("IDLoaiSanPham"));
                ms.setMaLoaiSanPham(rs.getString("Ma_LoaiSanPham"));
                ms.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                ms.setTrangThai(rs.getBoolean("TrangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public String selecNameById(int id) {
        // Kiểm tra xem id có hợp lệ không
        if (id <= 0) {
            logger.warning("ID không hợp lệ: " + id);
            return null;
        }

        // Thực hiện truy vấn để lấy danh sách loại sản phẩm
        List<LoaiSanPham> list = selectBySQL(selectById, id);

        // Kiểm tra và trả về kết quả
        if (!list.isEmpty()) {
            return list.get(0).getTenLoaiSanPham();
        } else {
            logger.warning("Không tìm thấy loại sản phẩm với ID: " + id);
            return null;
        }
    }

    public int selectIdByName(String name) {
        List<LoaiSanPham> list = selectBySQL("select * from LoaiSanPham where TenLoaiSanPham =?", name);
        if (!list.isEmpty()) {
            return list.get(0).getIdLoaiSanPham();
        } else {
            logger.warning("Không tìm thấy loại sản phẩm với tên: " + name);
            return -1;
        }
    }

    public LoaiSanPham selectID1(String id) {
        List<LoaiSanPham> list = selectBySQL(selectID, id);
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            logger.warning("Không tìm thấy loại sản phẩm với mã: " + id);
            return null;
        }
    }

    public int select_Max_id_java() {
        try {
            String sql = "select max(IDLoaiSanPham) from LoaiSanPham";
            ResultSet rs = JDBCHelper.query(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
