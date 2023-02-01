/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import viewmodels.ChucVuViewModel;
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
public class ChucVuRepository {

    public List<ChucVuViewModel> getAllChucVu() {
        String query = """
                      SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[ChucVu]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChucVuViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVuViewModel cv = new ChucVuViewModel(rs.getString(2), rs.getString(3));
                list.add(cv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ChucVuViewModel getOneChucVu(String ma) {
        String query = """
                      SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[ChucVu]
                         WHERE [Ma] = ?;
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVuViewModel cv = new ChucVuViewModel(rs.getString(2), rs.getString(3));
                return cv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addChucVu(ChucVuViewModel cv) {
        int check = 0;
        String query = """
                      INSERT INTO [dbo].[ChucVu]
                                 ([Ma]
                                 ,[Ten])
                           VALUES
                                 (?
                                 ,?);
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateChucVu(ChucVuViewModel cv, String ma) {
        int check = 0;
        String query = """
                    UPDATE [dbo].[ChucVu]
                         SET [Ma] = ?
                            ,[Ten] = ?
                       WHERE [Ma] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteChucVu(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[ChucVu]
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
