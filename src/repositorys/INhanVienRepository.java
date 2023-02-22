/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.NhanVien;
import java.util.List;

/**
 *
 * @author virus
 */
public interface INhanVienRepository {

    NhanVien getOne(String ma);

    List<NhanVien> getAllNhanVien();

    boolean addNhanVien(NhanVien nv);

    boolean updateNhanVien(NhanVien nv, String ma);

    boolean deleteNhanVien(String ma);
}
