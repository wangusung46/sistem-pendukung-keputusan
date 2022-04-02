

package spkdesi.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spkdesi.koneksi.Koneksi;


public class ModelPeramalan extends Koneksi{

    private static final Logger LOG = Logger.getLogger(ModelPeramalan.class.getName());
    
    public ResultSet read(){
        ResultSet i = null;
        String sql = 
                "SELECT tbl_peramalan.kd_peramalan, "
                + "tbl_peramalan.tgl_peramalan, "
                + "tbl_kategori.nama_kategori, "
                + "tbl_persediaan.satuan, "
                + "tbl_peramalan.alpha, "
                + "tbl_peramalan.mse, "
                + "tbl_peramalan.hasil "
                + "FROM tbl_peramalan, tbl_persediaan, tbl_kategori "
                + "WHERE tbl_kategori.kd_kategori = tbl_persediaan.kd_kategori "
                + "AND tbl_persediaan.kd_persediaan = tbl_peramalan.kd_persediaan "
                + "ORDER BY tbl_peramalan.kd_peramalan ASC ";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery(sql);
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPeramalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public int delete(String []param){
        int i = 0;
        String sql = "DELETE FROM tbl_peramalan WHERE kd_peramalan=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
            LOG.info(p.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ModelPeramalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
