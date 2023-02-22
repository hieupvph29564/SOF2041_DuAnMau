/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.impl;

import domainmodels.CuaHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import repositorys.ICuaHangRepository;
import utilities.DBContext;

/**
 *
 * @author virus
 */
public class CuaHangRepository implements ICuaHangRepository {

    @Override
    public List<CuaHang> getAllCuaHang() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[DiaChi]
                             ,[ThanhPho]
                             ,[QuocGia]
                         FROM [dbo].[CuaHang]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<CuaHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ch);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public CuaHang getOneCuaHang(String ma) {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[DiaChi]
                             ,[ThanhPho]
                             ,[QuocGia]
                         FROM [dbo].[CuaHang]
                         WHERE [Ma] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<CuaHang> list = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return ch;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addCuaHang(CuaHang ch) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[CuaHang]
                                  ([Ma]
                                  ,[Ten]
                                  ,[DiaChi]
                                  ,[ThanhPho])
                            VALUES
                                  (?
                                  ,?
                                  ,?
                                  ,?)
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateCuaHang(CuaHang ch, String ma) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[CuaHang]
                         SET [Ma] = ?
                            ,[Ten] = ?
                            ,[DiaChi] = ?
                            ,[ThanhPho] = ?
                       WHERE [Ma] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteCuaHang(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[CuaHang]
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
