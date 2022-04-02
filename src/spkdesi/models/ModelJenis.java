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
public class ModelJenis extends Koneksi {

    private static final Logger LOG = Logger.getLogger(ModelJenis.class.getName());

    public ResultSet read() {
        ResultSet r = null;
        String sql = "SELECT * FROM tbl_kategori";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int insert(String[] param) {
        int i = 0;
        try {
            String sql = "INSERT INTO tbl_kategori VALUES(?, ?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int update(String[] param) {
        int i = 0;
        String sql = "UPDATE tbl_kategori SET nama_kategori = ? WHERE kd_kategori = ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(2, param[0]);
            p.setString(1, param[1]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int delete(String[] param) {
        int i = 0;
        String sql = "DELETE FROM tbl_kategori WHERE kd_kategori = ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public String getId() {
        String id = "";
        String sql = "SELECT kd_kategori FROM tbl_kategori ORDER BY kd_kategori DESC";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet resultSet = p.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getString(1);
            }
            LOG.info(p.toString());
        } catch (SQLException e) {
        }
        return id;
    }

    public ResultSet select(String kd) {
        ResultSet r = null;
        String sql = "SELECT * FROM tbl_kategori where kd_kategori = '" + kd + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
