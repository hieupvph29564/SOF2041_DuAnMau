/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import domainmodels.ChiTietSP;
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
public class ChiTietSPRepository {

    public List<ChiTietSP> getAllChiTietSP() {
        String query = """
                      SELECT [Id]
                             ,[IdSP]
                             ,[IdNsx]
                             ,[IdMauSac]
                             ,[IdDongSP]
                             ,[NamBH]
                             ,[MoTa]
                             ,[SoLuongTon]
                             ,[GiaNhap]
                             ,[GiaBan]
                         FROM [dbo].[ChiTietSP]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChiTietSP> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
                        rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ChiTietSP getOneChiTietSP(String ma) {
        String query = """
                       SELECT [Id]
                        ,[IdSP]
                        ,[IdNsx]
                        ,[IdMauSac]
                        ,[IdDongSP]
                        ,[NamBH]
                        ,[MoTa]
                        ,[SoLuongTon]
                        ,[GiaNhap]
                        ,[GiaBan]
                    FROM [dbo].[ChiTietSP]
                       WHERE [IdSP = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new ChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
                        rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addChiTietSP(ChiTietSP sp) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[ChiTietSP]
                                  ([Id]
                                  ,[IdSP]
                                  ,[IdNsx]
                                  ,[IdMauSac]
                                  ,[IdDongSP]
                                  ,[SoLuongTon])
                            VALUES
                                  (?
                                  ,?
                                  ,?
                                  ,?
                                  ,?
                                  ,?)
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getId());
            ps.setObject(2, sp.getIdSP());
            ps.setObject(3, sp.getIdNSX());
            ps.setObject(4, sp.getIdMauSac());
            ps.setObject(5, sp.getIdDongSP());
            ps.setObject(6, sp.getSoLuongTon());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateChiTietSP(ChiTietSP sp, String ma) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[ChiTietSP]
                         SET [Id] = ?
                            ,[IdSP] = ?
                            ,[IdNsx] = ?
                            ,[IdMauSac] = ?
                            ,[IdDongSP] = ?
                            ,[SoLuongTon] = ?
                       WHERE [Id] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getId());
            ps.setObject(2, sp.getIdSP());
            ps.setObject(3, sp.getIdNSX());
            ps.setObject(4, sp.getIdMauSac());
            ps.setObject(5, sp.getIdDongSP());
            ps.setObject(6, sp.getSoLuongTon());
            ps.setObject(7, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteChiTietSP(String ma) {
        int check = 0;
        String query = """
                      DELETE FROM [dbo].[ChiTietSP]
                            WHERE [Id] = ?
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
