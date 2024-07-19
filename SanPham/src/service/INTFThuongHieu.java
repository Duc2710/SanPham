package service;

import entities.ThuongHieu;
import java.util.List;

public interface INTFThuongHieu {
     abstract public void insert(ThuongHieu sp);
    
    abstract public void update(ThuongHieu sp);
    
    abstract public void delete(Integer id);
    
    abstract public List<ThuongHieu> selectAll();
    
    abstract public ThuongHieu selectID(Integer id);
    
    abstract public List<ThuongHieu> selectBySQL(String sql, Object...args);
}
