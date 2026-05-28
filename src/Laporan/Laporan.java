
package Laporan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import myConnection.Koneksi;
import myEntity.Anggota;
import myEntity.Bahasa;
import myEntity.Jadwal;
import myEntity.Transaksi;
import myEntity.Tutor;
import myFunction.JTableAnggota;
import myFunction.JTableBahasa;
import myFunction.JTableJadwal;
import myFunction.JTableTransaksi;
import myFunction.JTableTutor;


public class Laporan extends javax.swing.JFrame {
    
Koneksi con = new Koneksi();

    public Laporan() {
        
        initComponents();
        setLocationRelativeTo(null); //agar frame di center
        setResizable(false); //agar ukuran frame tdk dpt diubah
        tblBahasa.setModel(bTable);
        tampilTabelBahasa();
        tblTutor.setModel(trTable);
        tampilTabelTutor();
        tblJadwal.setModel(jTable);
        tampilTabelJadwal();
        tblAnggota.setModel(aTable);
        tampilTabelAnggota();
        tblTransaksi.setModel(tTable);
        tampilTabelTransaksi();
    }
    JTableBahasa bTable = new JTableBahasa();
    JTableTutor trTable = new JTableTutor();
    JTableJadwal jTable = new JTableJadwal();
    JTableAnggota aTable = new JTableAnggota();
    JTableTransaksi tTable = new JTableTransaksi();
    Connection _Ccn;
    Statement st;
   
    
    private void tampilTabelAnggota()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblAnggota.getRowCount();
            for (int i = 0; i < row; i++)
            {
                aTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from anggota"
                    + " where nama_anggota like '%"+txtCariAnggota.getText()+"%'"
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
    
    private void tampilTabelBahasa()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblBahasa.getRowCount();
            for (int i = 0; i < row; i++)
            {
                bTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from bahasa"
                    + " where nama_bahasa like '%"+txtCariBahasa.getText()+"%'"
                    + " order by id_bahasa asc");
            while (rs.next())
            {
                Bahasa b = new Bahasa();
                b.setId_bahasa(rs.getString("id_bahasa"));
                b.setNama_bahasa(rs.getString("nama_bahasa"));
                bTable.add(b);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }
    
   private void tampilTabelTutor()
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
                    + " where nama_tutor like '%"+txtCariTutor.getText()+"%'"
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
   
    private void tampilTabelJadwal()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblJadwal.getRowCount();
            for (int i = 1; i < row; i++)
            {
                jTable.removeRow(0,row);
            }
            ResultSet rs = st.executeQuery ("select * from jadwal"
                    + " where id_jadwal like '%"+txtCariJadwal.getText()+"%'"
                    + " order by id_jadwal asc");
            while (rs.next())
            {
                Jadwal j = new Jadwal();
                j.setId_jadwal(rs.getString("id_jadwal"));
                j.setId_bahasa(rs.getString("id_bahasa"));
                j.setHari(rs.getString("hari"));
                j.setWaktu(rs.getString("waktu"));
                j.setKelas(rs.getString("kelas"));
                jTable.add(j);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    } 
    
        private void tampilTabelTransaksi()
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
                    + " where id_anggota like '%"+txtCariTransaksi.getText()+"%'"
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utama = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        keluar = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        labelAnggota = new javax.swing.JLabel();
        labelBahasa = new javax.swing.JLabel();
        labelTutor = new javax.swing.JLabel();
        labelJadwal = new javax.swing.JLabel();
        labelTransaksi = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        panelAngota = new javax.swing.JPanel();
        lbAnggota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnggota = new javax.swing.JTable();
        btnCetakLapAng = new javax.swing.JButton();
        txtCariAnggota = new javax.swing.JTextField();
        CariAng = new javax.swing.JLabel();
        panelBahasa = new javax.swing.JPanel();
        lbBahasa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBahasa = new javax.swing.JTable();
        btnCetakLapBhs = new javax.swing.JButton();
        txtCariBahasa = new javax.swing.JTextField();
        CariBhs = new javax.swing.JLabel();
        panelTutor = new javax.swing.JPanel();
        lblTutor = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTutor = new javax.swing.JTable();
        btnCetakLapTor = new javax.swing.JButton();
        txtCariTutor = new javax.swing.JTextField();
        CariTutor = new javax.swing.JLabel();
        panelJadwal = new javax.swing.JPanel();
        lbJadwal = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblJadwal = new javax.swing.JTable();
        btnCetakLapJad = new javax.swing.JButton();
        txtCariJadwal = new javax.swing.JTextField();
        CariJad = new javax.swing.JLabel();
        panelTransaksi = new javax.swing.JPanel();
        lbTransaksi = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnCetakLapTrans = new javax.swing.JButton();
        txtCariTransaksi = new javax.swing.JTextField();
        CariTrans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        utama.setBackground(new java.awt.Color(79, 112, 156));
        utama.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(79, 112, 156));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LAPORAN");

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/keluar.png"))); // NOI18N
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(keluar)
                .addGap(9, 9, 9))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(keluar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        utama.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1121, 90));

        left.setBackground(new java.awt.Color(245, 239, 231));
        left.setForeground(new java.awt.Color(245, 239, 231));

        labelAnggota.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelAnggota.setText("Anggota");
        labelAnggota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAnggotaMouseClicked(evt);
            }
        });

        labelBahasa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelBahasa.setText("Bahasa");
        labelBahasa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelBahasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBahasaMouseClicked(evt);
            }
        });

        labelTutor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelTutor.setText("Tutor");
        labelTutor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTutorMouseClicked(evt);
            }
        });

        labelJadwal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelJadwal.setText("Jadwal");
        labelJadwal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelJadwalMouseClicked(evt);
            }
        });

        labelTransaksi.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelTransaksi.setText("Transaksi");
        labelTransaksi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTransaksiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelBahasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(labelAnggota)
                .addGap(45, 45, 45)
                .addComponent(labelBahasa)
                .addGap(36, 36, 36)
                .addComponent(labelTutor)
                .addGap(36, 36, 36)
                .addComponent(labelJadwal)
                .addGap(34, 34, 34)
                .addComponent(labelTransaksi)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        utama.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 210, 660));

        panelAngota.setBackground(new java.awt.Color(245, 239, 231));
        panelAngota.setPreferredSize(new java.awt.Dimension(955, 513));

        lbAnggota.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lbAnggota.setText("DATA ANGGOTA");

        jScrollPane1.setBackground(new java.awt.Color(79, 112, 156));

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
        jScrollPane1.setViewportView(tblAnggota);

        btnCetakLapAng.setText("Cetak");
        btnCetakLapAng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLapAngActionPerformed(evt);
            }
        });

        txtCariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariAnggotaActionPerformed(evt);
            }
        });
        txtCariAnggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariAnggotaKeyTyped(evt);
            }
        });

        CariAng.setText("Cari");

        javax.swing.GroupLayout panelAngotaLayout = new javax.swing.GroupLayout(panelAngota);
        panelAngota.setLayout(panelAngotaLayout);
        panelAngotaLayout.setHorizontalGroup(
            panelAngotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAngotaLayout.createSequentialGroup()
                .addGroup(panelAngotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAngotaLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(lbAnggota))
                    .addGroup(panelAngotaLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(panelAngotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAngotaLayout.createSequentialGroup()
                                .addComponent(btnCetakLapAng)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CariAng)
                                .addGap(18, 18, 18)
                                .addComponent(txtCariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelAngotaLayout.setVerticalGroup(
            panelAngotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAngotaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbAnggota)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAngotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCetakLapAng)
                    .addComponent(txtCariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CariAng))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TabbedPane.addTab("tab1", panelAngota);

        panelBahasa.setBackground(new java.awt.Color(245, 239, 231));
        panelBahasa.setPreferredSize(new java.awt.Dimension(955, 513));

        lbBahasa.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lbBahasa.setText("DATA BAHASA");

        jScrollPane2.setBackground(new java.awt.Color(79, 112, 156));

        tblBahasa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblBahasa);

        btnCetakLapBhs.setText("Cetak");
        btnCetakLapBhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLapBhsActionPerformed(evt);
            }
        });

        txtCariBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariBahasaActionPerformed(evt);
            }
        });
        txtCariBahasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariBahasaKeyTyped(evt);
            }
        });

        CariBhs.setText("Cari");

        javax.swing.GroupLayout panelBahasaLayout = new javax.swing.GroupLayout(panelBahasa);
        panelBahasa.setLayout(panelBahasaLayout);
        panelBahasaLayout.setHorizontalGroup(
            panelBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBahasaLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(lbBahasa)
                .addContainerGap(445, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBahasaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelBahasaLayout.createSequentialGroup()
                        .addComponent(btnCetakLapBhs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CariBhs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCariBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        panelBahasaLayout.setVerticalGroup(
            panelBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBahasaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbBahasa)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetakLapBhs)
                    .addComponent(CariBhs))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TabbedPane.addTab("tab2", panelBahasa);

        panelTutor.setBackground(new java.awt.Color(245, 239, 231));
        panelTutor.setPreferredSize(new java.awt.Dimension(955, 513));

        lblTutor.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblTutor.setText("DATA TUTOR");

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
        jScrollPane3.setViewportView(tblTutor);

        btnCetakLapTor.setText("Cetak");
        btnCetakLapTor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLapTorActionPerformed(evt);
            }
        });

        txtCariTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariTutorActionPerformed(evt);
            }
        });
        txtCariTutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariTutorKeyTyped(evt);
            }
        });

        CariTutor.setText("Cari");

        javax.swing.GroupLayout panelTutorLayout = new javax.swing.GroupLayout(panelTutor);
        panelTutor.setLayout(panelTutorLayout);
        panelTutorLayout.setHorizontalGroup(
            panelTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTutorLayout.createSequentialGroup()
                .addGroup(panelTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTutorLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(lblTutor))
                    .addGroup(panelTutorLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(panelTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelTutorLayout.createSequentialGroup()
                                .addComponent(btnCetakLapTor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CariTutor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCariTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelTutorLayout.setVerticalGroup(
            panelTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTutorLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTutor)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetakLapTor)
                    .addComponent(CariTutor))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TabbedPane.addTab("tab3", panelTutor);

        panelJadwal.setBackground(new java.awt.Color(245, 239, 231));
        panelJadwal.setPreferredSize(new java.awt.Dimension(955, 513));

        lbJadwal.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lbJadwal.setText("DATA JADWAL");

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
        jScrollPane4.setViewportView(tblJadwal);

        btnCetakLapJad.setText("Cetak");
        btnCetakLapJad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLapJadActionPerformed(evt);
            }
        });

        txtCariJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariJadwalActionPerformed(evt);
            }
        });
        txtCariJadwal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariJadwalKeyTyped(evt);
            }
        });

        CariJad.setText("Cari");

        javax.swing.GroupLayout panelJadwalLayout = new javax.swing.GroupLayout(panelJadwal);
        panelJadwal.setLayout(panelJadwalLayout);
        panelJadwalLayout.setHorizontalGroup(
            panelJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJadwalLayout.createSequentialGroup()
                .addGroup(panelJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJadwalLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(lbJadwal))
                    .addGroup(panelJadwalLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(panelJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelJadwalLayout.createSequentialGroup()
                                .addComponent(btnCetakLapJad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CariJad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCariJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelJadwalLayout.setVerticalGroup(
            panelJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJadwalLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbJadwal)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetakLapJad)
                    .addComponent(CariJad))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TabbedPane.addTab("tab4", panelJadwal);

        panelTransaksi.setBackground(new java.awt.Color(245, 239, 231));
        panelTransaksi.setPreferredSize(new java.awt.Dimension(955, 513));

        lbTransaksi.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lbTransaksi.setText("DATA TRANSAKSI");

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
        jScrollPane5.setViewportView(tblTransaksi);

        btnCetakLapTrans.setText("Cetak");
        btnCetakLapTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLapTransActionPerformed(evt);
            }
        });

        txtCariTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariTransaksiActionPerformed(evt);
            }
        });
        txtCariTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariTransaksiKeyTyped(evt);
            }
        });

        CariTrans.setText("Cari");

        javax.swing.GroupLayout panelTransaksiLayout = new javax.swing.GroupLayout(panelTransaksi);
        panelTransaksi.setLayout(panelTransaksiLayout);
        panelTransaksiLayout.setHorizontalGroup(
            panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransaksiLayout.createSequentialGroup()
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransaksiLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(lbTransaksi))
                    .addGroup(panelTransaksiLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelTransaksiLayout.createSequentialGroup()
                                .addComponent(btnCetakLapTrans)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CariTrans)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelTransaksiLayout.setVerticalGroup(
            panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransaksiLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbTransaksi)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetakLapTrans)
                    .addComponent(CariTrans))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TabbedPane.addTab("tab5", panelTransaksi);

        utama.add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 53, 959, 660));

        getContentPane().add(utama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAnggotaMouseClicked
        TabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_labelAnggotaMouseClicked

    private void labelBahasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBahasaMouseClicked
        TabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_labelBahasaMouseClicked

    private void labelTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTutorMouseClicked
        TabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_labelTutorMouseClicked

    private void labelJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelJadwalMouseClicked
        TabbedPane.setSelectedIndex(3);
    }//GEN-LAST:event_labelJadwalMouseClicked

    private void labelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTransaksiMouseClicked
        TabbedPane.setSelectedIndex(4);
    }//GEN-LAST:event_labelTransaksiMouseClicked

    private void txtCariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariAnggotaActionPerformed

    private void txtCariBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariBahasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariBahasaActionPerformed

    private void txtCariTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariTutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariTutorActionPerformed

    private void txtCariJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariJadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariJadwalActionPerformed

    private void txtCariTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariTransaksiActionPerformed

    private void btnCetakLapJadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLapJadActionPerformed
        java.io.File fileJad = new java.io.File("..\\Laporan\\lap\\reportJadwal.jasper");
        try {
            net.sf.jasperreports.engine.JasperReport jasper;
            jasper = (net.sf.jasperreports.engine.JasperReport)
            net.sf.jasperreports.engine.util.JRLoader.loadObject(fileJad.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,con.getConnection());
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
        }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnCetakLapJadActionPerformed

    private void btnCetakLapAngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLapAngActionPerformed
        java.io.File fileAng = new java.io.File("..\\Laporan\\lap\\reportAnggota.jasper");
        try {
            net.sf.jasperreports.engine.JasperReport jasper;
            jasper = (net.sf.jasperreports.engine.JasperReport)
            net.sf.jasperreports.engine.util.JRLoader.loadObject(fileAng.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,con.getConnection());
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
        }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        }  
    }//GEN-LAST:event_btnCetakLapAngActionPerformed

    private void btnCetakLapBhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLapBhsActionPerformed
     java.io.File fileBhs = new java.io.File("..\\Laporan\\lap\\reportBahasa.jasper");
        try {
            net.sf.jasperreports.engine.JasperReport jasper;
            jasper = (net.sf.jasperreports.engine.JasperReport)
            net.sf.jasperreports.engine.util.JRLoader.loadObject(fileBhs.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,con.getConnection());
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
        }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        }  
    }//GEN-LAST:event_btnCetakLapBhsActionPerformed

    private void btnCetakLapTorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLapTorActionPerformed
        java.io.File fileTutor = new java.io.File("..\\Laporan\\lap\\reportTutor.jasper");
        try {
            net.sf.jasperreports.engine.JasperReport jasper;
            jasper = (net.sf.jasperreports.engine.JasperReport)
            net.sf.jasperreports.engine.util.JRLoader.loadObject(fileTutor.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,con.getConnection());
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
        }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnCetakLapTorActionPerformed

    private void btnCetakLapTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLapTransActionPerformed
        java.io.File fileTrans = new java.io.File("..\\Laporan\\lap\\reportTransaksi.jasper");
        try {
            net.sf.jasperreports.engine.JasperReport jasper;
            jasper = (net.sf.jasperreports.engine.JasperReport)
            net.sf.jasperreports.engine.util.JRLoader.loadObject(fileTrans.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,con.getConnection());
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
        }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnCetakLapTransActionPerformed

    private void txtCariAnggotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariAnggotaKeyTyped
        tampilTabelAnggota();
    }//GEN-LAST:event_txtCariAnggotaKeyTyped

    private void txtCariBahasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBahasaKeyTyped
        tampilTabelBahasa();
    }//GEN-LAST:event_txtCariBahasaKeyTyped

    private void txtCariTutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariTutorKeyTyped
        tampilTabelTutor();
    }//GEN-LAST:event_txtCariTutorKeyTyped

    private void txtCariJadwalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariJadwalKeyTyped
        tampilTabelJadwal();
    }//GEN-LAST:event_txtCariJadwalKeyTyped

    private void txtCariTransaksiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariTransaksiKeyTyped
        tampilTabelTransaksi();
    }//GEN-LAST:event_txtCariTransaksiKeyTyped

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        dispose();
    }//GEN-LAST:event_keluarMouseClicked

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CariAng;
    private javax.swing.JLabel CariBhs;
    private javax.swing.JLabel CariJad;
    private javax.swing.JLabel CariTrans;
    private javax.swing.JLabel CariTutor;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton btnCetakLapAng;
    private javax.swing.JButton btnCetakLapBhs;
    private javax.swing.JButton btnCetakLapJad;
    private javax.swing.JButton btnCetakLapTor;
    private javax.swing.JButton btnCetakLapTrans;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel keluar;
    private javax.swing.JLabel labelAnggota;
    private javax.swing.JLabel labelBahasa;
    private javax.swing.JLabel labelJadwal;
    private javax.swing.JLabel labelTransaksi;
    private javax.swing.JLabel labelTutor;
    private javax.swing.JLabel lbAnggota;
    private javax.swing.JLabel lbBahasa;
    private javax.swing.JLabel lbJadwal;
    private javax.swing.JLabel lbTransaksi;
    private javax.swing.JLabel lblTutor;
    private javax.swing.JPanel left;
    private javax.swing.JPanel panelAngota;
    private javax.swing.JPanel panelBahasa;
    private javax.swing.JPanel panelJadwal;
    private javax.swing.JPanel panelTransaksi;
    private javax.swing.JPanel panelTutor;
    private javax.swing.JTable tblAnggota;
    private javax.swing.JTable tblBahasa;
    private javax.swing.JTable tblJadwal;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTable tblTutor;
    private javax.swing.JTextField txtCariAnggota;
    private javax.swing.JTextField txtCariBahasa;
    private javax.swing.JTextField txtCariJadwal;
    private javax.swing.JTextField txtCariTransaksi;
    private javax.swing.JTextField txtCariTutor;
    private javax.swing.JPanel utama;
    // End of variables declaration//GEN-END:variables

}
