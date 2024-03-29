/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spkdesi.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import spkdesi.models.ModelPakai;

/**
 *
 * @author 6P52
 */
public class FrmPakai extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int collIndex) {
            return false;
        }
    };
    DefaultTableModel model1 = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int collIndex) {
            return false;
        }
    };

    /**
     * Creates new form FrmPakai
     */
    public FrmPakai() {
        initComponents();
        tblPakai();
        tblBarang();
        loadTblBarang();
        loadData();
    }

    public void tblPakai() {
        tblPakai.setModel(model);
        model.addColumn("Kode Pakai");
        model.addColumn("Tanggal");
        model.addColumn("Jenis");
        model.addColumn("Ukuran");
        model.addColumn("Jumlah");
    }

    public void tblBarang() {
        tblBarang.setModel(model1);
        model1.addColumn("Kode Barang");
        model1.addColumn("Jenis");
        model1.addColumn("Ukuran");
        model1.addColumn("Stok");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrmBarang = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodePakai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        txtJenis = new javax.swing.JTextField();
        txtUkuran = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        btnPilih = new javax.swing.JButton();
        txtTgl = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        btnBaru = new usu.widget.ButtonGlass();
        btnSimpan = new usu.widget.ButtonGlass();
        btnUpdate = new usu.widget.ButtonGlass();
        btnHapus = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPakai = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 78, 9));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Lucida Calligraphy", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBarang);

        javax.swing.GroupLayout FrmBarangLayout = new javax.swing.GroupLayout(FrmBarang.getContentPane());
        FrmBarang.getContentPane().setLayout(FrmBarangLayout);
        FrmBarangLayout.setHorizontalGroup(
            FrmBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FrmBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        FrmBarangLayout.setVerticalGroup(
            FrmBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrmBarangLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Form Pemakaian Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel2.setText("Kode Pakai");

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal");

        txtKodePakai.setEditable(false);
        txtKodePakai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel6.setText("Kode Barang");

        jLabel7.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel7.setText("Jenis Barang");

        jLabel8.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel8.setText("Ukuran");

        txtKodeBarang.setEditable(false);
        txtKodeBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtJenis.setEditable(false);
        txtJenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtUkuran.setEditable(false);
        txtUkuran.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel9.setText("Jumlah");

        txtJumlah.setEditable(false);
        txtJumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnPilih.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPilih.setText("...");
        btnPilih.setEnabled(false);
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        txtTgl.setEnabled(false);
        txtTgl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTglPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUkuran, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtJenis, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtJumlah)
                    .addComponent(txtKodePakai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtKodeBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilih))
                    .addComponent(txtTgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKodePakai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        btnBaru.setText("Baru");
        btnBaru.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setText("Edit");
        btnUpdate.setEnabled(false);
        btnUpdate.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPakai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPakai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPakaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPakai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String tanggal;

    public void loadTblBarang() {
        ModelPakai m = new ModelPakai();
        ResultSet r = m.read();
        try {
            model1.getDataVector().removeAllElements();
            while (r.next()) {
                Object obj[] = new Object[4];
                obj[0] = r.getString("kd_persediaan");
                obj[1] = r.getString("nama_kategori");
                obj[2] = r.getString("satuan");
                obj[3] = r.getString("stok");
                model1.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String autoNumber() {
        ModelPakai mp = new ModelPakai();
        String number = mp.getId();
        if (number.equals("")) {
            number = "P001";
        } else {
            number = number.substring(2);
            int angka = Integer.parseInt(number);
            angka++;
            if (angka < 10) {
                number = "00" + angka;
            } else if (angka >= 10 && angka < 100) {
                number = "0" + angka;
            } else if (angka >= 100 && angka < 1000) {
                number = "" + angka;
            } else {
                number = String.valueOf(angka);
            }
            if (number.length() > 5) {
                number = number.substring(number.length() - 5, number.length());
            }
            number = "P" + number;
        }
        return number;
    }

    public void loadId() {
        txtKodePakai.setText(autoNumber());
    }

    public void loadData() {
        ModelPakai m = new ModelPakai();
        ResultSet r = m.read_pakai();
        try {
            model.getDataVector().removeAllElements();
            while (r.next()) {
                Object obj[] = new Object[5];
                obj[0] = r.getString("kd_pakai");
                obj[1] = r.getString("tgl_pakai");
                obj[2] = r.getString("nama_kategori");
                obj[3] = r.getString("satuan");
                obj[4] = r.getString("jml_pakai");
                model.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPersediaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        // TODO add your handling code here:    
        if (btnBaru.getText().equals("Baru")) {
            btnBaru.setText("Batal");
            btnSimpan.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtTgl.setEnabled(true);
            //txtKodeBarang.setEditable(true);
            //txtJenis.setEditable(true);
            //txtUkuran.setEditable(true);
            txtJumlah.setEditable(true);
            btnPilih.setEnabled(true);
            loadId();
        } else {
            btnBaru.setText("Baru");
            btnUpdate.setText("Edit");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtUkuran.setEditable(false);
            txtTgl.setEnabled(false);
            //txtKodeBarang.setEditable(false);
            //txtJenis.setEditable(false);
            //txtUkuran.setEditable(false);
            txtJumlah.setEditable(false);
            btnPilih.setEnabled(false);
            txtKodePakai.setText("");
            txtTgl.setDate(null);
            txtKodeBarang.setText("");
            txtJenis.setText("");
            txtUkuran.setText("");
            txtJumlah.setText("");
        }
    }//GEN-LAST:event_btnBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:            
        ModelPakai mh = new ModelPakai();
        String a = txtJenis.getText();
        String b = txtKodeBarang.getText();
        int jml = Integer.valueOf(txtJumlah.getText());
        ResultSet c = mh.ambil(b);
        try {
            c.next();
            int stok = c.getInt("stok");
            int hasil = stok - jml;
            if (hasil >= 0) {
                if (!a.equals("")) {

                    String data[] = {txtKodePakai.getText(),
                        txtKodeBarang.getText(),
                        tanggal,
                        txtJumlah.getText()
                    };
                    if (mh.insert(data) > 0) {
                        JOptionPane.showMessageDialog(null, "Data Masuk");
                        loadId();
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal");
                    }
                    loadData();
                    btnBaru.setText("Baru");
                    btnSimpan.setEnabled(false);
                    btnUpdate.setEnabled(true);
                    btnHapus.setEnabled(true);
                    txtUkuran.setEditable(false);
                    txtTgl.setEnabled(false);
                    txtJumlah.setEditable(false);
                    btnPilih.setEnabled(false);
                    txtKodePakai.setText("");
                    txtTgl.setDate(null);
                    txtKodeBarang.setText("");
                    txtJenis.setText("");
                    txtUkuran.setText("");
                    txtJumlah.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Inputkan semua data User", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah pemakaian melebihi stok yang tersedia");
                txtKodePakai.setText("");
                txtTgl.setDate(null);
                txtKodeBarang.setText("");
                txtJenis.setText("");
                txtUkuran.setText("");
                txtJumlah.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:       
        if (btnUpdate.getText().equals("Edit")) {
            btnUpdate.setText("Update");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnHapus.setEnabled(false);
            btnBaru.setText("Batal");
            txtJenis.setEditable(false);
            txtTgl.setEnabled(true);
            txtJumlah.setEditable(true);
            btnPilih.setEnabled(true);
        } else {
            //Fungsi update            
            ModelPakai mj = new ModelPakai();
            if (txtJenis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "inputkan nama jenis");
            } else {
                String data[] = {txtKodePakai.getText(),
                    txtKodeBarang.getText(),
                    tanggal,
                    txtJumlah.getText()
                };
                if (mj.update(data) > 0) {
                    loadData();
                    JOptionPane.showMessageDialog(null, "Data terupdate");
                    txtJenis.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            }
            btnBaru.setText("Baru");
            btnUpdate.setText("Edit");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtUkuran.setEditable(false);
            txtTgl.setEnabled(false);
            txtJumlah.setEditable(false);
            btnPilih.setEnabled(false);
            txtKodePakai.setText("");
            txtTgl.setDate(null);
            txtKodeBarang.setText("");
            txtJenis.setText("");
            txtUkuran.setText("");
            txtJumlah.setText("");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:  
        int i = tblPakai.getSelectedRow();
        String kd = (String) tblPakai.getValueAt(i, 0);
        ModelPakai mk = new ModelPakai();
        String data[] = {kd};
        if (JOptionPane.showConfirmDialog(this, "Yakin menghapus data?", "Peringatan", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            mk.delete(data);
            JOptionPane.showMessageDialog(null, "Data terhapus");
            //
            loadData();
            btnBaru.setText("Baru");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtJenis.setEditable(false);
            txtKodePakai.setText("");
            txtTgl.setDate(null);
            txtKodeBarang.setText("");
            txtJenis.setText("");
            txtUkuran.setText("");
            txtJumlah.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Batal Menghapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        FrmBarang.setBounds(300, 300, 472, 350);
        FrmBarang.setVisible(true);
    }//GEN-LAST:event_btnPilihActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        int i = tblBarang.getSelectedRow();
        String kode = (String) tblBarang.getValueAt(i, 0);
        txtKodeBarang.setText(kode);
        String jenis = (String) tblBarang.getValueAt(i, 1);
        txtJenis.setText(jenis);
        String satuan = (String) tblBarang.getValueAt(i, 2);
        txtUkuran.setText(satuan);
        txtJumlah.requestFocus();
        FrmBarang.setVisible(false);
    }//GEN-LAST:event_tblBarangMouseClicked

    private void txtTglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTglPropertyChange
        // TODO add your handling code here:
        if (txtTgl.getDate() != null) {
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = Format.format(txtTgl.getDate());
        }
    }//GEN-LAST:event_txtTglPropertyChange

    private void tblPakaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPakaiMouseClicked
        // TODO add your handling code here:
        int i = tblPakai.getSelectedRow();
        String kd = (String) tblPakai.getValueAt(i, 0);
        btnUpdate.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBaru.setText("Batal");
        ModelPakai m = new ModelPakai();
        ResultSet r = m.pilih(kd);
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateValue = null;
        try {
            r.next();
            txtKodePakai.setText(r.getString("kd_pakai"));
            dateValue = Format.parse((String) r.getString("tgl_pakai"));
            txtTgl.setDate(dateValue);
            txtKodeBarang.setText(r.getString("kd_persediaan"));
            txtJenis.setText(r.getString("nama_kategori"));
            txtUkuran.setText(r.getString("satuan"));
            txtJumlah.setText(r.getString("jml_pakai"));
        } catch (SQLException ex) {
            Logger.getLogger(FrmPakai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FrmPakai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblPakaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog FrmBarang;
    private usu.widget.ButtonGlass btnBaru;
    private usu.widget.ButtonGlass btnHapus;
    private javax.swing.JButton btnPilih;
    private usu.widget.ButtonGlass btnSimpan;
    private usu.widget.ButtonGlass btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTable tblPakai;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodePakai;
    private com.toedter.calendar.JDateChooser txtTgl;
    private javax.swing.JTextField txtUkuran;
    // End of variables declaration//GEN-END:variables
}
