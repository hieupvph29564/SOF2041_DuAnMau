/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import domainmodels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import repositorys.IKhachHangRepository;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class KhachHangRepository implements IKhachHangRepository {

    @Override
    public List<KhachHang> getAllKhachHang() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[TenDem]
                             ,[Ho]
                             ,[NgaySinh]
                             ,[Sdt]
                             ,[DiaChi]
                             ,[ThanhPho]
                             ,[QuocGia]
                             ,[MatKhau]
                         FROM [dbo].[KhachHang]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<KhachHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public KhachHang getOneKhachHang(String ma) {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[TenDem]
                             ,[Ho]
                             ,[NgaySinh]
                             ,[Sdt]
                             ,[DiaChi]
                             ,[ThanhPho]
                             ,[QuocGia]
                             ,[MatKhau]
                         FROM [dbo].[KhachHang]
                       WHERE [Ma] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addKhachHang(KhachHang kh) {
        int check = 0;
        String query = """
                            INSERT INTO [dbo].[KhachHang]
                                  ([Ma]
                                  ,[Ten]
                                  ,[TenDem]
                                  ,[Ho]
                                  ,[DiaChi])
                            VALUES
                                  (?
                                  ,?
                                  ,?
                                  ,?
                                  ,?);
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateKhachHang(KhachHang kh, String ma) {
        int check = 0;
        String query = """
                        UPDATE [dbo].[KhachHang]
                               SET [Ma] = ?
                                  ,[Ten] = ?
                                  ,[TenDem] = ?
                                  ,[Ho] = ?
                                  ,[DiaChi] = ?
                             WHERE [Ma] =  ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean removeKhachHang(String ma) {
        int check = 0;
        String query = """
                      DELETE FROM [dbo].[KhachHang]
                              WHERE [Ma] = ?;
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
