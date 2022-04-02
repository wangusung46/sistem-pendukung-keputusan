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
public class ModelBeli extends Koneksi {

    private static final Logger LOG = Logger.getLogger(ModelBeli.class.getName());

    public ResultSet read() {
        ResultSet r = null;
        String sql
                = "SELECT tbl_persediaan.kd_persediaan, "
                + "tbl_kategori.nama_kategori, "
                + "tbl_persediaan.satuan, "
                + "tbl_persediaan.stok "
                + "FROM tbl_kategori, tbl_persediaan "
                + "WHERE tbl_kategori.kd_kategori=tbl_persediaan.kd_kategori "
                + "ORDER BY tbl_persediaan.kd_persediaan ASC";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public ResultSet read_beli() {
        ResultSet r = null;
        String sql
                = "SELECT tbl_beli.kd_beli, "
                + "tbl_beli.tgl_beli, "
                + "tbl_kategori.nama_kategori, "
                + "tbl_persediaan.satuan, "
                + "tbl_pemasok.nama_pemasok, "
                + "tbl_beli.jml_barang, "
                + "tbl_beli.harga "
                + "FROM tbl_kategori, tbl_persediaan, tbl_beli, tbl_pemasok "
                + "WHERE tbl_kategori.kd_kategori = tbl_persediaan.kd_kategori "
                + "AND tbl_persediaan.kd_persediaan = tbl_beli.kd_persediaan "
                + "AND tbl_pemasok.kd_pemasok = tbl_beli.kd_pemasok "
                + "ORDER BY tbl_beli.kd_beli ASC";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public ResultSet pilih(String kode) {
        ResultSet r = null;
        String sql
                = "SELECT * "
                + "FROM tbl_kategori, tbl_persediaan, tbl_beli, tbl_pemasok "
                + "WHERE tbl_kategori.kd_kategori = tbl_persediaan.kd_kategori "
                + "AND tbl_persediaan.kd_persediaan = tbl_beli.kd_persediaan "
                + "AND tbl_pemasok.kd_pemasok=tbl_beli.kd_pemasok "
                + "AND kd_beli= '" + kode + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int insert(String[] param) {
        int i = 0;
        try {
            String sql = "INSERT INTO tbl_beli VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);
            p.setString(3, param[2]);
            p.setString(4, param[3]);
            p.setString(5, param[4]);
            p.setString(6, param[5]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int update(String[] param) {
        int i = 0;
        String sql
                = "UPDATE tbl_beli "
                + "SET kd_pemasok = ?, "
                + "kd_persediaan = ?, "
                + "jml_barang = ?, "
                + "harga = ? "
                + "WHERE kd_beli = ?";
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
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public int delete(String[] param) {
        int i = 0;
        String sql = "DELETE FROM tbl_beli WHERE kd_beli = ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public ResultSet readPemasok() {
        ResultSet i = null;
        String sql = "Select * FROM tbl_pemasok";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public String getId() {
        String id = "";
        String sql = "SELECT kd_beli FROM tbl_beli ORDER BY kd_beli DESC";
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

    public ResultSet selectJenis(String nama) {
        ResultSet r = null;
        String sql = "SELECT * FROM tbl_pemasok where nama_pemasok= '" + nama + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelBeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
