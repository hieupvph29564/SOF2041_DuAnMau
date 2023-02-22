/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.impl;

import domainmodels.NhanVien;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import repositorys.INhanVienRepository;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class NhanVienRepository implements INhanVienRepository {

    @Override
    public NhanVien getOne(String ma) {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[TenDem]
                             ,[Ho]
                             ,[GioiTinh]
                             ,[NgaySinh]
                             ,[DiaChi]
                             ,[Sdt]
                             ,[MatKhau]
                             ,[IdCH]
                             ,[IdCV]
                             ,[IdGuiBC]
                             ,[TrangThai]
                         FROM [dbo].[NhanVien]
                          WHERE [Ma] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[TenDem]
                             ,[Ho]
                             ,[GioiTinh]
                             ,[NgaySinh]
                             ,[DiaChi]
                             ,[Sdt]
                             ,[MatKhau]
                             ,[IdCH]
                             ,[IdCV]
                             ,[IdGuiBC]
                             ,[TrangThai]
                         FROM [dbo].[NhanVien]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<NhanVien> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addNhanVien(NhanVien nv) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[NhanVien]
                                  ([Ma]
                                  ,[Ten]
                                  ,[TenDem]
                                  ,[Ho]
                                  ,[GioiTinh]
                                  ,[DiaChi]
                                  ,[TrangThai])
                            VALUES
                                  (?
                                  ,?
                                  ,?
                                  ,?
                                  ,?
                                  ,?
                                  ,?);
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateNhanVien(NhanVien nv, String ma) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[NhanVien]
                          SET [Ma] = ?
                             ,[Ten] = ?
                             ,[TenDem] = ?
                             ,[Ho] = ?
                             ,[GioiTinh] = ?
                             ,[DiaChi] = ?
                             ,[TrangThai] = ?
                        WHERE [Ma] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getTrangThai());
            ps.setObject(8, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteNhanVien(String ma) {
        int check = 0;
        String query = """
                      DELETE FROM [dbo].[NhanVien]
                             WHERE [Ma] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
