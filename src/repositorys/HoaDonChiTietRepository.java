/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import domainmodels.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getAllHoaDon() {
        String query = """
                       SELECT [IdHoaDon]
                             ,[IdChiTietSP]
                             ,[SoLuong]
                             ,[DonGia]
                         FROM [dbo].[HoaDonChiTiet]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonChiTiet(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getBigDecimal(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDonChiTiet getOneHoaDon(String ma) {
        String query = """
                      SELECT [IdHoaDon]
                        ,[IdChiTietSP]
                        ,[SoLuong]
                        ,[DonGia]
                    FROM [dbo].[HoaDonChiTiet]
                       WHERE [IdHoaDon] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new HoaDonChiTiet(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getBigDecimal(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addHoaDon(HoaDonChiTiet gh) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[HoaDonChiTiet]
                                  ([IdHoaDon]
                                  ,[IdChiTietSP]
                                  ,[SoLuong]
                                  ,[DonGia])
                            VALUES
                                  (?
                                  ,?
                                  ,?
                                  ,?)
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getIdHoaDon());
            ps.setObject(2, gh.getIdChiTietSP());
            ps.setObject(3, gh.getSoLuong());
            ps.setObject(4, gh.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateHoaDon(HoaDonChiTiet gh, String ma) {
        int check = 0;
        String query = """
                     UPDATE [dbo].[HoaDonChiTiet]
                         SET [IdHoaDon] = ?
                            ,[IdChiTietSP] =?
                            ,[SoLuong] = ?
                            ,[DonGia] = ?
                       WHERE [IdHoaDon] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getIdHoaDon());
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

    public boolean deleteHoaDon(String ma) {
        int check = 0;
        String query = """
                      DELETE FROM [dbo].[HoaDonChiTiet]
                            WHERE [IdHoaDon] = ?
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
