/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.SanPham;
import java.util.List;

/**
 *
 * @author virus
 */
public interface ISanPhamRepository {

    List<SanPham> getAllSanPHam();

    SanPham getOneSanPHam(String ma);

    boolean addSanPham(SanPham sp);

    boolean updateSanPham(SanPham sp, String ma);

    boolean removeSanPham(String ma);
}
