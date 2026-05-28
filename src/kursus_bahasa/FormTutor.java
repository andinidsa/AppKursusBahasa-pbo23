
package kursus_bahasa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myConnection.Koneksi;
import javax.swing.JOptionPane;
import myEntity.Tutor;
import myEntityManager.TutorManager;
import myFunction.JTableTutor;

public class FormTutor extends javax.swing.JFrame {
Koneksi con = new Koneksi();

    public FormTutor() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        tblTutor.setModel(trTable);
        tampilTabel();
    }

    private void bersih ()
    {
        txtIdTutor.setText("");
        txtIdBahasa.setText("");
        txtNamaTutor.setText("");
        txtAlamat.setText("");
        txtNoHP.setText("");
    }
    JTableTutor trTable = new JTableTutor();
    Connection _Ccn;
    Statement st;
    Koneksi db = new Koneksi ();
    
    private void tampilTabel()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblTutor.getRowCount();
            for (int i = 0; i < row; i++)
            {
                trTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from tutor"
                    + " where nama_tutor like '%"+txtCari.getText()+"%'"
                    + " order by id_tutor asc");
            while (rs.next())
            {
                Tutor tr = new Tutor();
                tr.setId_tutor(rs.getString("id_tutor"));
                tr.setId_bahasa(rs.getString("id_bahasa"));
                tr.setNama_tutor(rs.getString("nama_tutor"));
                tr.setAlamat(rs.getString("alamat"));
                tr.setNoHP(rs.getString("noHP"));
                trTable.add(tr);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }
    
   private boolean isEmpty(){
        if(txtIdTutor.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Perlu Memasukkan ID Tutor","", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
         
        return true;
    }
   
   
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtNoHP = new javax.swing.JTextField();
        NoHP = new javax.swing.JLabel();
        Alamat = new javax.swing.JLabel();
        nmTutor = new javax.swing.JLabel();
        IdBahasa = new javax.swing.JLabel();
        IdTutor = new javax.swing.JLabel();
        txtIdTutor = new javax.swing.JTextField();
        txtIdBahasa = new javax.swing.JTextField();
        txtNamaTutor = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Keluar = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTutor = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        Cari = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(79, 112, 156));

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        txtNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHPActionPerformed(evt);
            }
        });

        NoHP.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        NoHP.setForeground(new java.awt.Color(245, 239, 231));
        NoHP.setText("No HP");

        Alamat.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Alamat.setForeground(new java.awt.Color(245, 239, 231));
        Alamat.setText("Alamat");

        nmTutor.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nmTutor.setForeground(new java.awt.Color(245, 239, 231));
        nmTutor.setText("Nama ");

        IdBahasa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        IdBahasa.setForeground(new java.awt.Color(245, 239, 231));
        IdBahasa.setText("ID Bahasa");

        IdTutor.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        IdTutor.setForeground(new java.awt.Color(245, 239, 231));
        IdTutor.setText("ID Tutor");

        txtIdTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdTutorMouseClicked(evt);
            }
        });
        txtIdTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTutorActionPerformed(evt);
            }
        });

        txtNamaTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaTutorActionPerformed(evt);
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

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 239, 231));
        jLabel1.setText("FORM TUTOR");

        Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button_5735775 (2).png"))); // NOI18N
        Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarMouseClicked(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(79, 112, 156));

        tblTutor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTutorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTutor);

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

        Cari.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Cari.setForeground(new java.awt.Color(245, 239, 231));
        Cari.setText("Cari");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Keluar)
                .addGap(13, 13, 13))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdBahasa)
                            .addComponent(nmTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdTutor)
                            .addComponent(txtIdBahasa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(NoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addGap(32, 32, 32)
                        .addComponent(btnReset)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(Keluar)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefresh)
                            .addComponent(btnReset))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdBahasa))
                                .addGap(20, 20, 20))
                            .addComponent(IdTutor, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nmTutor))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(Alamat)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoHP)
                            .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnHapus)
                            .addComponent(btnUbah))
                        .addGap(123, 123, 123))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTutorActionPerformed

    private void txtNamaTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaTutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaTutorActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
      if (txtIdTutor.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Bahasa Harus Diisi");
            txtIdTutor.requestFocus();
        }
       else if (txtIdBahasa.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Id Bahasa harus diisi");
           txtIdBahasa.requestFocus();
       }
       else if (txtNamaTutor.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Nama harus diisi");
           txtNamaTutor.requestFocus();
       }
       else if (txtAlamat.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Alamat harus diisi");
           txtAlamat.requestFocus();
       }
       else if (txtNoHP.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Nomor HP harus diisi");
           txtNoHP.requestFocus();
       }
       else
       {
           Tutor tr = new Tutor (txtIdTutor.getText(),txtIdBahasa.getText(),txtNamaTutor.getText(),txtAlamat.getText(),txtNoHP.getText());
           TutorManager trm =new TutorManager();
        int i=trm.inputData(tr);
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
       txtIdTutor.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
      if (txtIdTutor.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
        else
        {
            int jawab = JOptionPane.showConfirmDialog(rootPane,
                    "Hapus Tutor "+txtIdTutor.getText()+"?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab==JOptionPane.YES_OPTION)
            {
                TutorManager tm = new TutorManager();
                if (tm.hapusData((txtIdTutor.getText()))==1)
                {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    bersih();
                    txtIdTutor.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
                }
            }
        } 
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (isEmpty())
     {
            Tutor tr = new Tutor (txtIdTutor.getText(),txtIdBahasa.getText(),txtNamaTutor.getText(),txtAlamat.getText(),txtNoHP.getText());
         TutorManager am = new TutorManager();
         int i = am.ubahData(tr);
         if (i==1)
         {
             JOptionPane.showMessageDialog (null,"Tutor Berhasil Diubah");
             bersih();
             txtIdTutor.requestFocus();
           
         }
         else {
             JOptionPane.showMessageDialog(null, "Tutor Gagal Diubah");
             txtIdTutor.requestFocus();
         }
     }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void txtNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHPActionPerformed

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked
        dispose();
    }//GEN-LAST:event_KeluarMouseClicked

    private void txtIdTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdTutorMouseClicked
       
    }//GEN-LAST:event_txtIdTutorMouseClicked

    private void tblTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTutorMouseClicked
       txtIdTutor.setText(tblTutor.getValueAt(tblTutor.getSelectedRow(),0).toString());
       txtIdBahasa.setText(tblTutor.getValueAt(tblTutor.getSelectedRow(),1).toString());
       txtNamaTutor.setText(tblTutor.getValueAt(tblTutor.getSelectedRow(),2).toString());
       txtAlamat.setText(tblTutor.getValueAt(tblTutor.getSelectedRow(),3).toString());
       txtNoHP.setText(tblTutor.getValueAt(tblTutor.getSelectedRow(),4).toString());
    }//GEN-LAST:event_tblTutorMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
     tampilTabel();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
     tampilTabel();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtIdTutor.setText("");
        txtIdBahasa.setText("");
        txtNamaTutor.setText("");
        txtAlamat.setText("");
        txtNoHP.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(FormTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Cari;
    private javax.swing.JLabel IdBahasa;
    private javax.swing.JLabel IdTutor;
    private javax.swing.JLabel Keluar;
    private javax.swing.JLabel NoHP;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nmTutor;
    private javax.swing.JTable tblTutor;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdBahasa;
    private javax.swing.JTextField txtIdTutor;
    private javax.swing.JTextField txtNamaTutor;
    private javax.swing.JTextField txtNoHP;
    // End of variables declaration//GEN-END:variables

    

}