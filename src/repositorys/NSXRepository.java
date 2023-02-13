/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import domainmodels.NSX;
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
public class NSXRepository {

    public List<NSX> getAllNSX() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[NSX]
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<NSX> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NSX(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public NSX getOneNSX(String ma) {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[NSX]
                         WHERE [Ma] = ?
                       """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new NSX(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addNSX(NSX sp) {
        int check = 0;
        String query = """
                     INSERT INTO [dbo].[NSX]
                                ([Ma]
                                ,[Ten])
                          VALUES
                                (?
                                ,?)
                     """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateNSX(NSX sp, String ma) {
        int check = 0;
        String query = """
                     UPDATE [dbo].[NSX]
                                               SET [Ma] = ?
                                                  ,[Ten] = ?
                                             WHERE [Ma] = ?
                     """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean removeNSX(String ma) {
        int check = 0;
        String query = """
                     DELETE FROM [dbo].[NSX]
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
