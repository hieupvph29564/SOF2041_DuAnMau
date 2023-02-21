/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import domainmodels.GioHangChiTiet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class GioHangChiTietRepository {

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

    public GioHangChiTiet GetOneGioHang(String ma) {
        String query = """
                       SELECT [IdGioHang]
                             ,[IdChiTietSP]
                             ,[SoLuong]
                             ,[DonGia]
                             ,[DonGiaKhiGiam]
                         FROM [dbo].[GioHangChiTiet]
                       WHERE [IdGioHang] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new GioHangChiTiet(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getBigDecimal(4), rs.getBigDecimal(5));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addGioHang(GioHangChiTiet gh) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[GioHangChiTiet]
                                  ([IdGioHang]
                                  ,[IdChiTietSP]
                                  ,[SoLuong]
                                  ,[DonGia])
                            VALUES
                                  (?
                                  ,?>
                                  ,?>
                                  ,?)
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getIdGioHang());
            ps.setObject(2, gh.getIdChiTietSP());
            ps.setObject(3, gh.getSoLuong());
            ps.setObject(4, gh.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateGioHang(GioHangChiTiet gh, String ma) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[GioHangChiTiet]
                          SET [IdGioHang] = ?
                             ,[IdChiTietSP] = ?
                             ,[SoLuong] = ?
                             ,[DonGia] = ?
                        WHERE [IdGioHang] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getIdGioHang());
            ps.setObject(2, gh.getIdChiTietSP());
            ps.setObject(3, gh.getSoLuong());
            ps.setObject(4, gh.getDonGia());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

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
