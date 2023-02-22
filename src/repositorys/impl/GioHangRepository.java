/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.impl;

import domainmodels.GioHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repositorys.IGioHangRepository;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class GioHangRepository implements IGioHangRepository {

    @Override
    public List<String> getAllIdKH() {
        String query = """
                       SELECT id FROM KhachHang;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<String> list = new ArrayList();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GioHang> getAllGioHang() {
        String query = """
                     SELECT [Id]
                           ,[IdKH]
                           ,[IdNV]
                           ,[Ma]
                           ,[NgayTao]
                           ,[NgayThanhToan]
                           ,[TenNguoiNhan]
                           ,[DiaChi]
                           ,[Sdt]
                           ,[TinhTrang]
                       FROM [dbo].[GioHang]
                     """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<GioHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new GioHang(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getInt(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addGioHang(GioHang gh) {
        int check = 0;
        String query = """
                        INSERT INTO [dbo].[GioHang]
                                   ([Ma]
                                   ,[IdKH]
                                   ,[TenNguoiNhan]
                                   ,[TinhTrang])
                             VALUES
                                   (?
                                   ,?
                                   ,?
                                   ,?);
                        """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getMa());
            ps.setObject(2, gh.getIdKH());
            ps.setObject(3, gh.getTenNguoiNhan());
            ps.setObject(4, gh.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateGioHang(GioHang gh, String ma) {
        int check = 0;
        String query = """
                        UPDATE [dbo].[GioHang]
                           SET [Ma] = ?
                              ,[TenNguoiNhan] = ?
                              ,[TinhTrang] = ?
                         WHERE [Ma] = ?
                        """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gh.getMa());
            ps.setObject(2, gh.getTenNguoiNhan());
            ps.setObject(3, gh.getTinhTrang());
            ps.setObject(4, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGioHang(String ma) {
        int check = 0;
        String query = """
                       DELETE FROM [dbo].[GioHang]
                             WHERE [Ma] = ?
                        """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
