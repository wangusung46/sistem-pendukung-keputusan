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
public class ModelPakai extends Koneksi {

    private static final Logger LOG = Logger.getLogger(ModelPakai.class.getName());

    public ResultSet read() {
        ResultSet r = null;
        String sql
                = "SELECT tbl_persediaan.kd_persediaan, "
                + "tbl_kategori.nama_kategori, "
                + "tbl_persediaan.satuan, "
                + "tbl_persediaan.stok "
                + "FROM tbl_kategori, tbl_persediaan "
                + "WHERE tbl_kategori.kd_kategori = tbl_persediaan.kd_kategori "
                + "ORDER BY tbl_persediaan.kd_persediaan ASC";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public ResultSet read_pakai() {
        ResultSet r = null;
        String sql
                = "SELECT tbl_pakai.kd_pakai, "
                + "tbl_pakai.tgl_pakai, "
                + "tbl_kategori.nama_kategori, "
                + "tbl_persediaan.satuan, "
                + "tbl_pakai.jml_pakai "
                + "FROM tbl_kategori, tbl_persediaan, tbl_pakai "
                + "WHERE tbl_kategori.kd_kategori = tbl_persediaan.kd_kategori "
                + "AND tbl_persediaan.kd_persediaan=tbl_pakai.kd_persediaan "
                + "ORDER BY tbl_pakai.kd_pakai ASC";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int insert(String[] param) {
        int i = 0;
        try {
            String sql = "INSERT INTO tbl_pakai VALUES(?, ?, ?, ?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int update(String[] param) {
        int i = 0;
        String sql
                = "UPDATE tbl_pakai "
                + "SET kd_persediaan = ?, tgl_pakai = ?, jml_pakai = ? "
                + "WHERE kd_pakai = ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(4, param[0]);
            p.setString(1, param[1]);
            p.setString(2, param[2]);
            p.setString(3, param[3]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int delete(String[] param) {
        int i = 0;
        String sql = "DELETE FROM tbl_pakai WHERE kd_pakai = ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public String getId() {
        String id = "";
        String sql = "SELECT kd_pakai FROM tbl_pakai ORDER BY kd_pakai DESC";
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
        String sql = "SELECT * FROM tbl_pakai WHERE kd_pakai = '" + kd + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public ResultSet pilih(String kode) {
        ResultSet r = null;
        String sql
                = "SELECT tbl_pakai.kd_pakai, "
                + "tbl_pakai.tgl_pakai, "
                + "tbl_persediaan.kd_persediaan, "
                + "tbl_kategori.nama_kategori, "
                + "tbl_persediaan.satuan, "
                + "tbl_pakai.jml_pakai "
                + "FROM tbl_kategori, "
                + "tbl_persediaan, "
                + "tbl_pakai "
                + "WHERE tbl_kategori.kd_kategori=tbl_persediaan.kd_kategori "
                + "AND tbl_persediaan.kd_persediaan=tbl_pakai.kd_persediaan "
                + "AND kd_pakai= '" + kode + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public ResultSet ambil(String kd) {
        ResultSet r = null;
        String sql = "SELECT stok "
                + "FROM tbl_persediaan "
                + "WHERE kd_persediaan= '" + kd + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
