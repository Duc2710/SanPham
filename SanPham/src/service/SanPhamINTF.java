package service;

import entities.SanPham;
import java.util.List;


public interface SanPhamINTF {
    abstract public void insert(SanPham sp);
    
    abstract public void update(SanPham sp);
    
//    abstract public void delete(Integer id);
    
    abstract public List<SanPham> findAllData();
    
    abstract public SanPham selectID(Integer id);
    
    int getTotal();
    
    abstract public SanPham selectID1(String id);
}
