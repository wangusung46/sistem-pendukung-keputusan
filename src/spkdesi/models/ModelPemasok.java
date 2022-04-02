/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spkdesi.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spkdesi.koneksi.Koneksi;

/**
 *
 * @author 6P52
 */
public class ModelPemasok extends Koneksi {

    private static final Logger LOG = Logger.getLogger(ModelPemasok.class.getName());

    public ResultSet read() {
        ResultSet i = null;
        String sql = "SELECT * FROM tbl_pemasok";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPemasok.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int insert(String[] param) {
        int i = 0;
        String sql = "INSERT INTO tbl_pemasok values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            p.setString(5, param[4]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPemasok.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int update(String[] param) {
        int i = 0;
        String sql
                = "UPDATE tbl_pemasok "
                + "SET nama_pemasok = ?, "
                + "alamat_pemasok = ?, "
                + "kota = ?, "
                + "no_telepon = ? "
                + "WHERE kd_pemasok = ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(5, param[0]);
            p.setString(1, param[1]);
            p.setString(2, param[2]);
            p.setString(3, param[3]);
            p.setString(4, param[4]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPemasok.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int delete(String[] param) {
        int i = 0;
        String sql = "DELETE FROM tbl_pemasok WHERE kd_pemasok=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPemasok.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public String getId() {
        String id = "";
        String sql = "SELECT kd_pemasok FROM tbl_pemasok ORDER BY kd_pemasok DESC";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet resultSet = p.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getString(1);
            }
            LOG.info(p.toString());
        } catch (SQLException e) {
            Logger.getLogger(ModelPemasok.class.getName()).log(Level.SEVERE, null, e);
        }
        return id;
    }
}
