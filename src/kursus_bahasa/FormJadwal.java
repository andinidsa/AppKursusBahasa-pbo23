
package kursus_bahasa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import myConnection.Koneksi;
import myEntity.Jadwal;
import myEntityManager.JadwalManager;
import myFunction.JTableJadwal;


public class FormJadwal extends javax.swing.JFrame {
Koneksi con = new Koneksi();
    public FormJadwal() {
        initComponents();
         setLocationRelativeTo(null); //agar frame di center
        setResizable(false);
        tblJadwal.setModel (JTable);
        tampilTabelJadwal();
        
    }

    private void bersih ()
    {
        txtIdJadwal.setText("");
        txtIdBahasa.setText("");
        txtHari.setText("");
        txtWaktu.setText("");   
        txtKelas.setText("");    
        
    }
     JTableJadwal JTable = new JTableJadwal();
    Connection _Ccn;
    Statement st;
    Koneksi db = new Koneksi ();
     private boolean isEmpty(){
        if(txtIdJadwal.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Perlu Memasukkan ID Jadwal","", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
         
        return true;
    }
      private void tampilTabelJadwal()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblJadwal.getRowCount();
            for (int i = 0; i < row; i++)
            {
                JTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from jadwal"
                    + " where id_jadwal like '%"+txtCari.getText()+"%'"
                    + " order by id_jadwal asc");
            while (rs.next())
            {
                Jadwal j = new Jadwal();
                j.setId_jadwal(rs.getString("id_jadwal"));
                j.setId_bahasa(rs.getString("id_bahasa"));
                j.setHari(rs.getString("hari"));
                j.setWaktu(rs.getString("waktu"));
                j.setKelas(rs.getString("kelas"));
                JTable.add(j);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IdJadwal = new javax.swing.JLabel();
        txtIdJadwal = new javax.swing.JTextField();
        IdBahasa = new javax.swing.JLabel();
        txtIdBahasa = new javax.swing.JTextField();
        txtHari = new javax.swing.JTextField();
        Hari = new javax.swing.JLabel();
        Waktu = new javax.swing.JLabel();
        txtWaktu = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        Kelas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Keluar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJadwal = new javax.swing.JTable();
        CariJadwal = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(79, 112, 156));

        IdJadwal.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdJadwal.setForeground(new java.awt.Color(245, 239, 231));
        IdJadwal.setText("ID Jadwal");

        IdBahasa.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdBahasa.setForeground(new java.awt.Color(245, 239, 231));
        IdBahasa.setText("ID Bahasa");

        Hari.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Hari.setForeground(new java.awt.Color(245, 239, 231));
        Hari.setText("Hari");

        Waktu.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Waktu.setForeground(new java.awt.Color(245, 239, 231));
        Waktu.setText("Waktu");

        Kelas.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Kelas.setForeground(new java.awt.Color(245, 239, 231));
        Kelas.setText("Kelas");

        jLabel1.setBackground(new java.awt.Color(245, 239, 231));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 239, 231));
        jLabel1.setText("FORM JADWAL");

        Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button_5735775 (2).png"))); // NOI18N
        Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(79, 112, 156));

        tblJadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        tblJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJadwal);

        CariJadwal.setBackground(new java.awt.Color(0, 0, 0));
        CariJadwal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CariJadwal.setForeground(new java.awt.Color(255, 255, 255));
        CariJadwal.setText("Cari");

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

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CariJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CariJadwal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefresh)
                            .addComponent(btnReset))
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.setRequestFocusEnabled(false);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addGap(83, 83, 83))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(IdJadwal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdBahasa, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(Hari)
                                        .addGap(27, 27, 27))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Waktu)
                                            .addComponent(Kelas))
                                        .addGap(15, 15, 15)))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Keluar)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Keluar)))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Waktu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Kelas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(IdJadwal))
                            .addComponent(Hari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnHapus)
                            .addComponent(btnUbah))
                        .addGap(28, 28, 28)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (isEmpty())
     {
         Jadwal jad = new Jadwal (txtIdJadwal.getText(),txtIdBahasa.getText(),txtHari.getText(),txtWaktu.getText(),txtKelas.getText());
         JadwalManager am = new JadwalManager();
         int i = am.ubahData(jad);
         if (i==1)
         {
             JOptionPane.showMessageDialog (null,"Jadwal Berhasil Diubah");
             bersih();
             txtIdJadwal.requestFocus();
           
         }
         else {
             JOptionPane.showMessageDialog(null, "Jadwal Gagal Diubah");
             txtIdJadwal.requestFocus();
         }
     }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(txtIdJadwal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Jadwal Harus Diisi");
            txtIdJadwal.requestFocus();
        }
        else if(txtIdBahasa.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Id Bahasa Harus Diisi");
            txtIdBahasa.requestFocus();
        }
        else if(txtHari.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Hari Harus Diisi");
            txtHari.requestFocus();
        }
        else if(Waktu.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Waktu Harus Diisi");
            txtWaktu.requestFocus();
        }
        else if(Kelas.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Kelas Harus Diisi");
            txtKelas.requestFocus();
        }
        else
        {
          Jadwal jad = new Jadwal(txtIdJadwal.getText(),txtIdBahasa.getText(),txtHari.getText(),
                    txtWaktu.getText(),txtKelas.getText());
            JadwalManager jadm = new JadwalManager();
            int i=jadm.inputData(jad);
            if (i==1)
            {
                JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
                bersih();
                txtIdJadwal.requestFocus();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
                txtIdJadwal.requestFocus();
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       txtIdJadwal.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (txtIdJadwal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
        else
        {
            int jawab = JOptionPane.showConfirmDialog(rootPane,
                    "Hapus Jadwal "+txtIdJadwal.getText()+"?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab==JOptionPane.YES_OPTION)
            {
                JadwalManager jadm = new JadwalManager();
                if (jadm.hapusData((txtIdJadwal.getText()))==1)
                {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    bersih();
                    txtIdJadwal.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked
        dispose();
    }//GEN-LAST:event_KeluarMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void tblJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJadwalMouseClicked
       txtIdJadwal.setText(tblJadwal.getValueAt(tblJadwal.getSelectedRow(),0).toString());
       txtIdBahasa.setText(tblJadwal.getValueAt(tblJadwal.getSelectedRow(),1).toString());
       txtHari.setText(tblJadwal.getValueAt(tblJadwal.getSelectedRow(),2).toString());
       txtWaktu.setText(tblJadwal.getValueAt(tblJadwal.getSelectedRow(),3).toString());
       txtKelas.setText(tblJadwal.getValueAt(tblJadwal.getSelectedRow(),4).toString());
    }//GEN-LAST:event_tblJadwalMouseClicked

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
      tampilTabelJadwal();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
     tampilTabelJadwal();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtIdJadwal.setText("");
        txtIdBahasa.setText("");
        txtHari.setText("");
        txtWaktu.setText("");
        txtKelas.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CariJadwal;
    private javax.swing.JLabel Hari;
    private javax.swing.JLabel IdBahasa;
    private javax.swing.JLabel IdJadwal;
    private javax.swing.JLabel Kelas;
    private javax.swing.JLabel Keluar;
    private javax.swing.JLabel Waktu;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblJadwal;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHari;
    private javax.swing.JTextField txtIdBahasa;
    private javax.swing.JTextField txtIdJadwal;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtWaktu;
    // End of variables declaration//GEN-END:variables
}
