
package kursus_bahasa;

import java.sql.Connection;
import java.sql.Statement;
import myConnection.Koneksi;
import javax.swing.JOptionPane;
import myEntity.Bahasa;
import myEntityManager.BahasaManager;

public class FormBahasa extends javax.swing.JFrame {

    public FormBahasa() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void bersih ()
    {
        txtIdBahasa.setText("");
        txtNamaBahasa.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IdBahasa = new javax.swing.JLabel();
        txtIdBahasa = new javax.swing.JTextField();
        NamaBahasa = new javax.swing.JLabel();
        txtNamaBahasa = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        frmAnggota = new javax.swing.JLabel();
        Keluar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(79, 112, 156));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        IdBahasa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        IdBahasa.setForeground(new java.awt.Color(245, 239, 231));
        IdBahasa.setText("ID Bahasa");

        txtIdBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBahasaActionPerformed(evt);
            }
        });

        NamaBahasa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        NamaBahasa.setForeground(new java.awt.Color(245, 239, 231));
        NamaBahasa.setText("Nama Bahasa");

        txtNamaBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBahasaActionPerformed(evt);
            }
        });

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

        frmAnggota.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        frmAnggota.setForeground(new java.awt.Color(245, 239, 231));
        frmAnggota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmAnggota.setText("FORM BAHASA");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(btnSimpan)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NamaBahasa)
                            .addComponent(IdBahasa))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdBahasa)
                            .addComponent(txtNamaBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(frmAnggota)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Keluar)
                        .addGap(8, 8, 8))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(Keluar)
                .addGap(1, 1, 1)
                .addComponent(frmAnggota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdBahasa)
                    .addComponent(txtIdBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NamaBahasa)
                    .addComponent(txtNamaBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBahasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBahasaActionPerformed

    private void txtNamaBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBahasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBahasaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (txtIdBahasa.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Bahasa Harus Diisi");
            txtIdBahasa.requestFocus();
        }
       else if (txtNamaBahasa.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Nama harus diisi");
           txtNamaBahasa.requestFocus();
       }
       else
       {
           Bahasa bhs= new Bahasa (txtIdBahasa.getText(),txtNamaBahasa.getText());
           BahasaManager bhsm=new BahasaManager();
        int i=bhsm.inputData(bhs);
        if(i==1)
        {
            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
            bersih();
            txtIdBahasa.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
                txtIdBahasa.requestFocus();
            }
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        txtIdBahasa.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if (!Character.isDigit(evt.getKeyChar()));
        {
            evt.consume();
        }
    }//GEN-LAST:event_formKeyTyped

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (txtIdBahasa.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
        else
        {
            int jawab = JOptionPane.showConfirmDialog(rootPane,
                    "Hapus Bahasa "+txtIdBahasa.getText()+"?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab==JOptionPane.YES_OPTION)
            {
                BahasaManager bhsm = new BahasaManager();
                if (bhsm.hapusData(Integer.parseInt(txtIdBahasa.getText()))==1)
                {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    bersih();
                    txtIdBahasa.requestFocus();
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
            java.util.logging.Logger.getLogger(FormBahasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBahasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBahasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBahasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormBahasa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdBahasa;
    private javax.swing.JLabel Keluar;
    private javax.swing.JLabel NamaBahasa;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel frmAnggota;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIdBahasa;
    private javax.swing.JTextField txtNamaBahasa;
    // End of variables declaration//GEN-END:variables
}
