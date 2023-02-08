/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import domainmodels.HoaDon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class HoaDonRepository {

    public List<HoaDon> getAllHoaDon() {
        String query = """
                       SELECT [Id]
                             ,[IdKH]
                             ,[IdNV]
                             ,[Ma]
                             ,[NgayTao]
                             ,[NgayThanhToan]
                             ,[NgayShip]
                             ,[NgayNhan]
                             ,[TinhTrang]
                             ,[TenNguoiNhan]
                             ,[DiaChi]
                             ,[Sdt]
                         FROM [dbo].[HoaDon]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getDate(6),
                        rs.getDate(7), rs.getDate(8), rs.getInt(9),
                        rs.getString(10), rs.getString(11), rs.getString(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getOneHoaDon(String ma) {
        String query = """
                       SELECT [Id]
                             ,[IdKH]
                             ,[IdNV]
                             ,[Ma]
                             ,[NgayTao]
                             ,[NgayThanhToan]
                             ,[NgayShip]
                             ,[NgayNhan]
                             ,[TinhTrang]
                             ,[TenNguoiNhan]
                             ,[DiaChi]
                             ,[Sdt]
                         FROM [dbo].[HoaDon]
                         WHERE [Ma] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getDate(6),
                        rs.getDate(7), rs.getDate(8), rs.getInt(9),
                        rs.getString(10), rs.getString(11), rs.getString(12));
                return hd;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addHoaDon(HoaDon hd) {
        int check = 0;
        String query = """
                     INSERT INTO [dbo].[HoaDon]
                       			([Ma]
                                  ,[TinhTrang])
                            VALUES
                                  (?
                                  ,?)
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateHoaDon(HoaDon hd, String ma) {
        int check = 0;
        String query = """
                    UPDATE [dbo].[HoaDon]
                        SET [Ma] = ?
                           ,[TinhTrang] = ?
                      WHERE [Ma] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getTinhTrang());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteHoaDon(String ma) {
        int check = 0;
        String query = """
                    DELETE FROM [dbo].[HoaDon]
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
