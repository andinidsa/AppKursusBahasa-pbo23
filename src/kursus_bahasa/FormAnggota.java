package kursus_bahasa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import myConnection.Koneksi;
import myEntity.Anggota;
import myEntityManager.AnggotaManager;
import myFunction.JTableAnggota;

public class FormAnggota extends javax.swing.JFrame {

    public FormAnggota() {
        initComponents();
        setLocationRelativeTo(null); //agar frame di center
        setResizable(false); //agar ukuran frame tdk dpt diubah
        tblAnggota.setModel(aTable);
        tampilTabel();
    }
    private void bersih ()
    {
        txtIdAnggota.setText("");
        txtIdBahasa.setText("");
        txtIdJadwal.setText("");
        txtNamaAnggota.setText("");
        txtAlamat.setText("");
        txtNoHP.setText("");     
    }
    
    JTableAnggota aTable = new JTableAnggota();
    Connection _Ccn;
    Statement st;
    Koneksi db = new Koneksi ();
    
    private void tampilTabel()
    {
        try
        {
            _Ccn = db.getConnection();
            st = _Ccn.createStatement();
            int row = tblAnggota.getRowCount();
            for (int i = 0; i < row; i++)
            {
                aTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from anggota"
                    + " where nama_anggota like '%"+txtCari.getText()+"%'"
                    + " order by id_anggota asc");
            while (rs.next())
            {
                Anggota a = new Anggota();
                a.setId_anggota(rs.getString ("id_anggota"));
                a.setId_bahasa(rs.getString("id_bahasa"));
                a.setId_jadwal(rs.getString("id_jadwal"));
                a.setNama_anggota(rs.getString("nama_anggota"));
                a.setAlamat(rs.getString("alamat"));
                a.setNoHP(rs.getString("noHP"));
                aTable.add(a);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }
  private boolean isEmpty(){
        if(txtIdAnggota.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Perlu Memasukkan ID Anggota","", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
         
        return true;
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        IdAnggota = new javax.swing.JLabel();
        txtIdAnggota = new javax.swing.JTextField();
        IdBahasa = new javax.swing.JLabel();
        txtIdBahasa = new javax.swing.JTextField();
        IdJadwal = new javax.swing.JLabel();
        txtIdJadwal = new javax.swing.JTextField();
        NamaAnggota = new javax.swing.JLabel();
        txtNamaAnggota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        Alamat = new javax.swing.JLabel();
        NoHP = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnggota = new javax.swing.JTable();
        Cari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        Keluar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(79, 112, 156));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 239, 231));
        jLabel1.setText("FORM ANGGOTA");

        IdAnggota.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdAnggota.setForeground(new java.awt.Color(245, 239, 231));
        IdAnggota.setText("ID Anggota");

        txtIdAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAnggotaActionPerformed(evt);
            }
        });

        IdBahasa.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdBahasa.setForeground(new java.awt.Color(245, 239, 231));
        IdBahasa.setText("ID Bahasa");

        txtIdBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBahasaActionPerformed(evt);
            }
        });

        IdJadwal.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        IdJadwal.setForeground(new java.awt.Color(245, 239, 231));
        IdJadwal.setText("ID Jadwal");

        txtIdJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdJadwalActionPerformed(evt);
            }
        });

        NamaAnggota.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        NamaAnggota.setForeground(new java.awt.Color(245, 239, 231));
        NamaAnggota.setText("Nama Anggota");

        txtNamaAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaAnggotaActionPerformed(evt);
            }
        });

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        Alamat.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Alamat.setForeground(new java.awt.Color(245, 239, 231));
        Alamat.setText("Alamat");

        NoHP.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        NoHP.setForeground(new java.awt.Color(245, 239, 231));
        NoHP.setText("No HP");

        txtNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHPActionPerformed(evt);
            }
        });
        txtNoHP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoHPKeyTyped(evt);
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

        jPanel1.setBackground(new java.awt.Color(79, 112, 156));

        tblAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAnggota);

        Cari.setForeground(new java.awt.Color(255, 255, 255));
        Cari.setText("Cari");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(Cari)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh)
                        .addComponent(btnReset))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cari)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button_5735775 (2).png"))); // NOI18N
        Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IdBahasa)
                                    .addComponent(IdAnggota))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtIdBahasa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IdJadwal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Alamat)
                                        .addComponent(NoHP))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNoHP)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(NamaAnggota)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addComponent(txtNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah)))
                        .addGap(45, 45, 45))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Keluar)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Keluar)))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NamaAnggota)
                            .addComponent(txtNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Alamat)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdAnggota))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdBahasa)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdJadwal))
                        .addGap(16, 16, 16)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoHP)
                    .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAnggotaActionPerformed

    private void txtIdBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBahasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBahasaActionPerformed

    private void txtNamaAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaAnggotaActionPerformed

    private void txtNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHPActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
      if (txtIdAnggota.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Anggota Harus Diisi");
            txtIdAnggota.requestFocus();
        }
        else if(txtIdBahasa.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Bahasa Harus Diisi");
            txtIdBahasa.requestFocus();
        }
         else if(txtIdJadwal.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "ID Jadwal Harus Diisi");
            txtIdJadwal.requestFocus();
        }
        else if(txtNamaAnggota.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Nama Harus Diisi");
            txtNamaAnggota.requestFocus();
        }
        else if(txtAlamat.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Alamat Harus Diisi");
            txtAlamat.requestFocus();
        }
        else if(txtNoHP.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "No HP Harus Diisi");
            txtNoHP.requestFocus();
        }
        else
        {
            Anggota anggo = new Anggota(txtIdAnggota.getText(),txtIdBahasa.getText(),txtIdJadwal.getText(),
                    txtNamaAnggota.getText(),txtAlamat.getText(),txtNoHP.getText());
            AnggotaManager am = new AnggotaManager();
            int i=am.inputData(anggo);
            if (i==1)
            {
                JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
                bersih();
                txtIdAnggota.requestFocus();    
                tampilTabel();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
                txtIdAnggota.requestFocus();
            }
        } 
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
         if (txtIdAnggota.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
        else
        {
            int jawab = JOptionPane.showConfirmDialog(rootPane,
                    "Hapus Anggota "+txtIdAnggota.getText()+"?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab==JOptionPane.YES_OPTION)
            {
                AnggotaManager am = new AnggotaManager();
                if (am.hapusData(Integer.parseInt(txtIdAnggota.getText()))==1)
                {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    bersih();
                    txtIdAnggota.requestFocus();
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
         Anggota anggo = new Anggota (txtIdAnggota.getText(),txtIdBahasa.getText(), txtIdJadwal.getText(),
                 txtNamaAnggota.getText(),txtAlamat.getText(),txtNoHP.getText());
         AnggotaManager am = new AnggotaManager();
         int i = am.ubahData(anggo);
         if (i==1)
         {
             JOptionPane.showMessageDialog (null,"Anggota Berhasil Diubah");
             bersih();
             txtIdAnggota.requestFocus();
           
         }
         else {
             JOptionPane.showMessageDialog(null, "Anggota Gagal Diubah");
             txtIdAnggota.requestFocus();
         }
     }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        txtIdAnggota.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void txtNoHPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHPKeyTyped
        if (!Character.isDigit(evt.getKeyChar()))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNoHPKeyTyped

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        tampilTabel();
    }//GEN-LAST:event_txtCariKeyTyped

    private void tblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnggotaMouseClicked
       txtIdAnggota.setText(tblAnggota.getValueAt(tblAnggota.getSelectedRow(),0).toString());
       txtIdBahasa.setText(tblAnggota.getValueAt(tblAnggota.getSelectedRow(),1).toString());
       txtIdJadwal.setText(tblAnggota.getValueAt(tblAnggota.getSelectedRow(),2).toString());
       txtNamaAnggota.setText(tblAnggota.getValueAt(tblAnggota.getSelectedRow(),3).toString());
       txtAlamat.setText(tblAnggota.getValueAt(tblAnggota.getSelectedRow(),4).toString());
       txtNoHP.setText(tblAnggota.getValueAt(tblAnggota.getSelectedRow(),5).toString());
    }//GEN-LAST:event_tblAnggotaMouseClicked

    private void txtIdJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdJadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdJadwalActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tampilTabel();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //setExtendedState(FormUtama.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtIdAnggota.setText("");
        txtIdBahasa.setText("");
        txtIdJadwal.setText("");
        txtNamaAnggota.setText("");
        txtAlamat.setText("");
        txtNoHP.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Cari;
    private javax.swing.JLabel IdAnggota;
    private javax.swing.JLabel IdBahasa;
    private javax.swing.JLabel IdJadwal;
    private javax.swing.JLabel Keluar;
    private javax.swing.JLabel NamaAnggota;
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
    private javax.swing.JTable tblAnggota;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdBahasa;
    private javax.swing.JTextField txtIdJadwal;
    private javax.swing.JTextField txtNamaAnggota;
    private javax.swing.JTextField txtNoHP;
    // End of variables declaration//GEN-END:variables
}
