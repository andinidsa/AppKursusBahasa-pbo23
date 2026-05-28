
package kursus_bahasa;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myConnection.Koneksi;
import javax.swing.JOptionPane;
import myEntity.Transaksi;
import myEntityManager.TransaksiManager;
import myFunction.JTableTransaksi;

public class FormTransaksi extends javax.swing.JFrame {
 
    public FormTransaksi() {
        initComponents();
        setLocationRelativeTo(null); //agar frame di center
        setResizable(false);
        tblTransaksi.setModel(tTable);
        tampilTabel();
    }
    private void bersih ()
    {
        txtIdTransaksi.setText("");
        txtIdAnggota.setText("");
        txtTglTransaksi.setText("");
        txtNominal.setText("");
        txtKeterangan.setText("");     
    }
    

    JTableTransaksi tTable = new JTableTransaksi();
    Connection _Ccn;
    Statement st;
    Koneksi con = new Koneksi();
    
    private void tampilTabel()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblTransaksi.getRowCount();
            for (int i = 0; i < row; i++)
            {
                tTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from transaksi"
                    + " where id_anggota like '%"+txtCari.getText()+"%'"
                    + " order by id_transaksi asc");
            while (rs.next())
            {
                Transaksi t = new Transaksi();
                t.setId_Transaksi(rs.getString ("id_transaksi"));
                t.setId_Anggota(rs.getString("id_anggota"));
                t.setTgl_Transaksi(rs.getString("tgl_transaksi"));
                t.setNominal(rs.getString("nominal"));
                t.setKeterangan(rs.getString("keterangan"));               
                tTable.add(t);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }
    private boolean isEmpty(){
        if(txtIdTransaksi.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Perlu Memasukkan ID Transaksi","INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
         
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IdTransaksi = new javax.swing.JLabel();
        IdAnggota = new javax.swing.JLabel();
        TglTransaksi = new javax.swing.JLabel();
        Nominal = new javax.swing.JLabel();
        Keterangan = new javax.swing.JLabel();
        txtIdTransaksi = new javax.swing.JTextField();
        txtIdAnggota = new javax.swing.JTextField();
        txtTglTransaksi = new javax.swing.JTextField();
        txtNominal = new javax.swing.JTextField();
        txtKeterangan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Keluar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(79, 112, 156));

        IdTransaksi.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdTransaksi.setForeground(new java.awt.Color(245, 239, 231));
        IdTransaksi.setText("ID Transaksi");

        IdAnggota.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdAnggota.setForeground(new java.awt.Color(245, 239, 231));
        IdAnggota.setText("ID Anggota");

        TglTransaksi.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TglTransaksi.setForeground(new java.awt.Color(245, 239, 231));
        TglTransaksi.setText("Tgl Transaksi");

        Nominal.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Nominal.setForeground(new java.awt.Color(245, 239, 231));
        Nominal.setText("Nominal");

        Keterangan.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Keterangan.setForeground(new java.awt.Color(245, 239, 231));
        Keterangan.setText("Keterangan");

        txtTglTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglTransaksiActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(79, 112, 156));

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaksi);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cari :");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addGap(172, 172, 172)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh)
                        .addComponent(btnReset))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 239, 231));
        jLabel1.setText("FORM TRANSAKSI");
        jLabel1.setFocusTraversalPolicyProvider(true);

        Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button_5735775 (2).png"))); // NOI18N
        Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Keluar)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdTransaksi)
                            .addComponent(IdAnggota)
                            .addComponent(TglTransaksi)
                            .addComponent(Nominal)
                            .addComponent(Keterangan))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdTransaksi)
                                .addComponent(txtIdAnggota)
                                .addComponent(txtTglTransaksi)
                                .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(31, 31, 31)
                        .addComponent(btnHapus)))
                .addGap(31, 31, 31)
                .addComponent(btnUbah)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(Keluar)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdTransaksi)
                    .addComponent(txtIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdAnggota))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TglTransaksi))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nominal)
                    .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Keterangan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(btnSimpan))
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       if (txtIdTransaksi.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Transaksi Harus Diisi");
            txtIdTransaksi.requestFocus();
        }
        else if(txtIdAnggota.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Anggota Harus Diisi");
            txtIdAnggota.requestFocus();
        }
        else if(txtTglTransaksi.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Tanggal Transaksi Harus Diisi");
            txtTglTransaksi.requestFocus();
        }
        else if(txtNominal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nominal Harus Diisi");
            txtNominal.requestFocus();
        }
        else if(txtKeterangan.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Keterangan Harus Diisi");
            txtKeterangan.requestFocus();
        }
        else
        {
            Transaksi trans = new Transaksi (txtIdTransaksi.getText(),txtIdAnggota.getText(),txtTglTransaksi.getText(),txtNominal.getText(),
                    txtKeterangan.getText());
            TransaksiManager transm = new TransaksiManager();
            int i=transm.inputData(trans);
            if (i==1)
            {
                JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
                bersih();
                txtIdTransaksi.requestFocus();      
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
                txtIdTransaksi.requestFocus();
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
 
        
        
         if (txtIdTransaksi.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
        else
        {
            int jawab = JOptionPane.showConfirmDialog(rootPane,
                    "Hapus Transaksi "+txtIdTransaksi.getText()+"?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab==JOptionPane.YES_OPTION)
            {
                TransaksiManager transm = new TransaksiManager();
                if (transm.hapusData((txtIdTransaksi.getText()))==1)
                {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    bersih();
                    txtIdTransaksi.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tampilTabel();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
       
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        tampilTabel();
    }//GEN-LAST:event_txtCariKeyTyped

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
       txtIdTransaksi.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(),0).toString());
       txtIdAnggota.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(),1).toString());
       txtTglTransaksi.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(),2).toString());
       txtNominal.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(),3).toString());
       txtKeterangan.setText(tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(),4).toString());
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void txtTglTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglTransaksiActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
                if (isEmpty())
     {
            Transaksi trans = new Transaksi (txtIdTransaksi.getText(),txtIdAnggota.getText(),txtTglTransaksi.getText(),txtNominal.getText(),txtKeterangan.getText());
         TransaksiManager trm = new TransaksiManager();
         int i = trm.ubahData(trans);
         if (i==1)
         {
             JOptionPane.showMessageDialog (null,"Transaksi Berhasil Diubah");
             bersih();
             txtIdTransaksi.requestFocus();
           
         }
         else {
             JOptionPane.showMessageDialog(null, "Transaksi Gagal Diubah");
             txtIdTransaksi.requestFocus();
         }
     }

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       txtIdTransaksi.setText("");
       txtIdAnggota.setText("");
       txtTglTransaksi.setText("");
       txtNominal.setText("");
       txtKeterangan.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked
        dispose();
    }//GEN-LAST:event_KeluarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdAnggota;
    private javax.swing.JLabel IdTransaksi;
    private javax.swing.JLabel Keluar;
    private javax.swing.JLabel Keterangan;
    private javax.swing.JLabel Nominal;
    private javax.swing.JLabel TglTransaksi;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdTransaksi;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNominal;
    private javax.swing.JTextField txtTglTransaksi;
    // End of variables declaration//GEN-END:variables
}
