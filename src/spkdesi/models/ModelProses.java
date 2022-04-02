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
public class ModelProses extends Koneksi {

    private static final Logger LOG = Logger.getLogger(ModelProses.class.getName());

    public ResultSet read_data_lampau(String kd_persediaan, String tgl_dari, String tgl_sampai) {
        ResultSet r = null;
        String sql
                = "SELECT CONCAT(MONTH(tgl_pakai),'/',YEAR(tgl_pakai)) AS periode, "
                + "MONTH(tgl_pakai) AS bulan, "
                + "tgl_pakai, "
                + "SUM(jml_pakai) AS jumlah_bulanan "
                + "FROM tbl_pakai "
                + "WHERE kd_persediaan = '" + kd_persediaan + "' "
                + "AND (tgl_pakai <= '" + tgl_sampai + "' and tgl_pakai >= '" + tgl_dari + "') "
                + "GROUP BY YEAR(tgl_pakai), MONTH(tgl_pakai) "
                + "ORDER BY tgl_pakai";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelProses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int insert(String[] param) {
        int i = 0;
        String sql = "INSERT INTO tbl_peramalan VALUES(?, ?, ?, ?, ?, ?)";
        try {
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
            Logger.getLogger(ModelProses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

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

    public ResultSet selectJenis(String nama) {
        ResultSet r = null;
        String sql = "SELECT tbl_pakai.kd_persediaan FROM tbl_kategori where nama_kategori = '" + nama + "'";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            r = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String getId() {
        String id = "";
        String sql = "SELECT kd_peramalan FROM tbl_peramalan ORDER BY kd_peramalan DESC";
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
}
