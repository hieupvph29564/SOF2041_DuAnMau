/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import domainmodels.GioHangChiTiet;
import java.util.ArrayList;
import java.util.List;
import repositorys.IGioHangChiTietRepository;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class GioHangChiTietRepository implements IGioHangChiTietRepository {

    @Override
    public List<String> getAllMaGioHang() {
        String query = """
                       SELECT Id FROM GioHang;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<String> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<String> getAllMaSanPham() {
        String query = """
                       SELECT Id FROM ChiTietSP;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<String> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<GioHangChiTiet> getAllGioHang() {
        String query = """
                       SELECT [IdGioHang]
                             ,[IdChiTietSP]
                             ,[SoLuong]
                             ,[DonGia]
                             ,[DonGiaKhiGiam]
                         FROM [dbo].[GioHangChiTiet]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<GioHangChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new GioHangChiTiet(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getBigDecimal(4), rs.getBigDecimal(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addGioHang(GioHangChiTiet gh) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[GioHangChiTiet]
                                  ([IdGioHang]
                                  ,[IdChiTietSP]
                                  ,[SoLuong])
                            VALUES
                                  (?
                                  ,?
                                  ,?)
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getIdGioHang());
            ps.setObject(2, gh.getIdChiTietSP());
            ps.setObject(3, gh.getSoLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateGioHang(GioHangChiTiet gh, String ma) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[GioHangChiTiet]
                          SET [SoLuong] = ?
                        WHERE [IdGioHang] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getSoLuong());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteGioHang(String ma) {
        int check = 0;
        String query = """
                      DELETE FROM [dbo].[GioHangChiTiet]
                            WHERE [IdGioHang] = ?
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
