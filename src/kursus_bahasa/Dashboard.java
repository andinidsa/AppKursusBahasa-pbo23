
package kursus_bahasa;

import Laporan.Laporan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
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
    Koneksi con = new Koneksi ();
    
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
                   // + " where nama_anggota like '%"+txtCari.getText()+"%'"
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
                    //+ " where id_anggota like '%"+txtCari.getText()+"%'"
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
    
    private void tampilTabelBahasa()
    {
        try
        {
            _Ccn = con.getConnection();
            st = _Ccn.createStatement();
            int row = tblBahasa.getRowCount();
            for (int i = 0; i < row; i++)
            {
                bTable.removeRow(5,row);
            }
            ResultSet rs = st.executeQuery ("select * from bahasa"
                   // + " where nama_anggota like '%"+txtCari.getText()+"%'"
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
            for (int i = 1; i < row; i++)
            {
                trTable.removeRow(1,row);
            }
            ResultSet rs = st.executeQuery ("select * from tutor"
                   // + " where nama_anggota like '%"+txtCari.getText()+"%'"
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
                jTable.removeRow(1,row);
            }
            ResultSet rs = st.executeQuery ("select * from jadwal"
                   // + " where nama_anggota like '%"+txtCari.getText()+"%'"
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utama = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        lbabout = new javax.swing.JLabel();
        lbmaster = new javax.swing.JLabel();
        lblaporan = new javax.swing.JLabel();
        keluar = new javax.swing.JLabel();
        body1 = new javax.swing.JPanel();
        FORM = new javax.swing.JPanel();
        pBahasa = new javax.swing.JPanel();
        frmBahasa = new javax.swing.JLabel();
        iconBahasa = new javax.swing.JLabel();
        pJadwal = new javax.swing.JPanel();
        frmJadwal = new javax.swing.JLabel();
        iconJadwal = new javax.swing.JLabel();
        pTutor = new javax.swing.JPanel();
        frmTutor = new javax.swing.JLabel();
        iconTutor = new javax.swing.JLabel();
        pTransaksi = new javax.swing.JPanel();
        iconTransaksi = new javax.swing.JLabel();
        frmTransaksi = new javax.swing.JLabel();
        pAnggota = new javax.swing.JPanel();
        frmAnggota = new javax.swing.JLabel();
        iconAnggota = new javax.swing.JLabel();
        ABOUT = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        deskripsiAp = new javax.swing.JTextArea();
        Biodata = new javax.swing.JLabel();
        ManualBook = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LAPORAN = new javax.swing.JPanel();
        panelkiri = new javax.swing.JPanel();
        lTransaksi = new javax.swing.JPanel();
        lpTransaksi = new javax.swing.JLabel();
        lTutor = new javax.swing.JPanel();
        lpTutor = new javax.swing.JLabel();
        lJadwal = new javax.swing.JPanel();
        lpJadwal = new javax.swing.JLabel();
        lAnggota = new javax.swing.JPanel();
        lpAnggota1 = new javax.swing.JLabel();
        lBahasa = new javax.swing.JPanel();
        lpAnggota = new javax.swing.JLabel();
        pk = new javax.swing.JPanel();
        panellaporan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnBahasa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBahasa = new javax.swing.JTable();
        pnTutor = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTutor = new javax.swing.JTable();
        pnJadwal = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblJadwal = new javax.swing.JTable();
        pnTransaksi = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        pnAnggota = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAnggota = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        utama.setBackground(new java.awt.Color(79, 112, 156));

        header.setBackground(new java.awt.Color(245, 239, 231));

        lbabout.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbabout.setText("About");
        lbabout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbaboutMouseClicked(evt);
            }
        });

        lbmaster.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbmaster.setText("Master");
        lbmaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbmasterMouseClicked(evt);
            }
        });

        lblaporan.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblaporan.setText("Laporan");
        lblaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaporanMouseClicked(evt);
            }
        });

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
                .addGap(238, 238, 238)
                .addComponent(lbabout)
                .addGap(149, 149, 149)
                .addComponent(lbmaster)
                .addGap(142, 142, 142)
                .addComponent(lblaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(keluar)
                .addGap(11, 11, 11))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbabout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmaster, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(keluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body1.setPreferredSize(new java.awt.Dimension(1200, 637));

        FORM.setBackground(new java.awt.Color(245, 239, 231));

        pBahasa.setBackground(new java.awt.Color(245, 239, 231));
        pBahasa.setMinimumSize(new java.awt.Dimension(0, 0));
        pBahasa.setPreferredSize(new java.awt.Dimension(188, 159));
        pBahasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pBahasaMouseClicked(evt);
            }
        });

        frmBahasa.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        frmBahasa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmBahasa.setText("FORM BAHASA");
        frmBahasa.setMaximumSize(new java.awt.Dimension(157, 26));
        frmBahasa.setMinimumSize(new java.awt.Dimension(157, 26));
        frmBahasa.setPreferredSize(new java.awt.Dimension(157, 26));

        iconBahasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/language_12872674 (1).png"))); // NOI18N

        javax.swing.GroupLayout pBahasaLayout = new javax.swing.GroupLayout(pBahasa);
        pBahasa.setLayout(pBahasaLayout);
        pBahasaLayout.setHorizontalGroup(
            pBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBahasaLayout.createSequentialGroup()
                .addGroup(pBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBahasaLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(iconBahasa))
                    .addGroup(pBahasaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(frmBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pBahasaLayout.setVerticalGroup(
            pBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBahasaLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(iconBahasa)
                .addGap(1, 1, 1)
                .addComponent(frmBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pJadwal.setBackground(new java.awt.Color(245, 239, 231));
        pJadwal.setMinimumSize(new java.awt.Dimension(0, 0));
        pJadwal.setPreferredSize(new java.awt.Dimension(188, 159));
        pJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pJadwalMouseClicked(evt);
            }
        });

        frmJadwal.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        frmJadwal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmJadwal.setText("FORM JADWAL");
        frmJadwal.setMaximumSize(new java.awt.Dimension(157, 26));
        frmJadwal.setMinimumSize(new java.awt.Dimension(157, 26));
        frmJadwal.setPreferredSize(new java.awt.Dimension(157, 26));

        iconJadwal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconJadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deadline_4229248 (1).png"))); // NOI18N

        javax.swing.GroupLayout pJadwalLayout = new javax.swing.GroupLayout(pJadwal);
        pJadwal.setLayout(pJadwalLayout);
        pJadwalLayout.setHorizontalGroup(
            pJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJadwalLayout.createSequentialGroup()
                .addGroup(pJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJadwalLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(iconJadwal))
                    .addGroup(pJadwalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(frmJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pJadwalLayout.setVerticalGroup(
            pJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJadwalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconJadwal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frmJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pTutor.setBackground(new java.awt.Color(245, 239, 231));
        pTutor.setMinimumSize(new java.awt.Dimension(0, 0));
        pTutor.setPreferredSize(new java.awt.Dimension(188, 159));
        pTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTutorMouseClicked(evt);
            }
        });

        frmTutor.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        frmTutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmTutor.setText("FORM TUTOR");
        frmTutor.setMaximumSize(new java.awt.Dimension(157, 26));
        frmTutor.setMinimumSize(new java.awt.Dimension(157, 26));
        frmTutor.setPreferredSize(new java.awt.Dimension(157, 26));

        iconTutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconTutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/teacher_3471363 (2).png"))); // NOI18N

        javax.swing.GroupLayout pTutorLayout = new javax.swing.GroupLayout(pTutor);
        pTutor.setLayout(pTutorLayout);
        pTutorLayout.setHorizontalGroup(
            pTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTutorLayout.createSequentialGroup()
                .addGroup(pTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTutorLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(iconTutor))
                    .addGroup(pTutorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(frmTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pTutorLayout.setVerticalGroup(
            pTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTutorLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(iconTutor)
                .addGap(3, 3, 3)
                .addComponent(frmTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pTransaksi.setBackground(new java.awt.Color(245, 239, 231));
        pTransaksi.setMinimumSize(new java.awt.Dimension(0, 0));
        pTransaksi.setPreferredSize(new java.awt.Dimension(188, 159));
        pTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTransaksiMouseClicked(evt);
            }
        });

        iconTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/solana_9071412 (2).png"))); // NOI18N

        frmTransaksi.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        frmTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmTransaksi.setText("FORM TRANSAKSI");
        frmTransaksi.setMaximumSize(new java.awt.Dimension(157, 26));
        frmTransaksi.setMinimumSize(new java.awt.Dimension(157, 26));
        frmTransaksi.setPreferredSize(new java.awt.Dimension(157, 26));

        javax.swing.GroupLayout pTransaksiLayout = new javax.swing.GroupLayout(pTransaksi);
        pTransaksi.setLayout(pTransaksiLayout);
        pTransaksiLayout.setHorizontalGroup(
            pTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTransaksiLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(iconTransaksi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(frmTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pTransaksiLayout.setVerticalGroup(
            pTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTransaksiLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(iconTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frmTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pAnggota.setBackground(new java.awt.Color(245, 239, 231));
        pAnggota.setPreferredSize(new java.awt.Dimension(188, 159));
        pAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pAnggotaMouseClicked(evt);
            }
        });

        frmAnggota.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        frmAnggota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frmAnggota.setText("FORM ANGGOTA");
        frmAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frmAnggotaMouseClicked(evt);
            }
        });

        iconAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/multiple-users_7729412 (1).png"))); // NOI18N

        javax.swing.GroupLayout pAnggotaLayout = new javax.swing.GroupLayout(pAnggota);
        pAnggota.setLayout(pAnggotaLayout);
        pAnggotaLayout.setHorizontalGroup(
            pAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnggotaLayout.createSequentialGroup()
                .addGroup(pAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAnggotaLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(iconAnggota))
                    .addGroup(pAnggotaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(frmAnggota)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pAnggotaLayout.setVerticalGroup(
            pAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAnggotaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(iconAnggota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frmAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout FORMLayout = new javax.swing.GroupLayout(FORM);
        FORM.setLayout(FORMLayout);
        FORMLayout.setHorizontalGroup(
            FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FORMLayout.createSequentialGroup()
                .addGroup(FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FORMLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(pAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(pTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FORMLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(pJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(pBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(pTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        FORMLayout.setVerticalGroup(
            FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FORMLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pAnggota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pTransaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );

        ABOUT.setBackground(new java.awt.Color(245, 239, 231));
        ABOUT.setPreferredSize(new java.awt.Dimension(1158, 595));

        jScrollPane7.setBackground(new java.awt.Color(0, 153, 153));

        deskripsiAp.setBackground(new java.awt.Color(245, 239, 231));
        deskripsiAp.setColumns(20);
        deskripsiAp.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        deskripsiAp.setForeground(new java.awt.Color(79, 112, 156));
        deskripsiAp.setRows(5);
        deskripsiAp.setText("     CDI adalah aplikasi berbasis dekstop untuk kursus bahasa yang terdiri dari, bahasa\n Inggris, Jepang, Korea. Yang nantinya proses pembelajaran dilakukan selama 6 bulan. \nAplikasi desktop kursus bahasa ini dirancang dengan fitur yang terstruktur. Aplikasi ini \nmemiliki formulir bahasa yang memudahkan pengguna memilih dan menyesuaikan \npreferens bahasa sesuai kebutuhan mereka. \n     Selain itu, fitur jadwal yang terintegrasi di aplikasi ini memungkinkan admin dapat \nmelihat dan merencanakan jadwal kursus mereka (anggota)dengan mudah. Profil dan\nkualifikasi tutor dapat diakses dengan cepat, membantu admin memilih tutor yang sesuai\ndengan kebutuhan anggota. Karena proses belajar dilakukan secara tatap muka\nsehingga  memungkinkan anggota kursus bekerja sama dan berinteraksi satu sama lain,\nyang menghasilkan komunitas belajar yang dinamis. \n     Selain itu, ada laporan transaksi yang memudahkan pencatatan transaksi keuangan \ndan pembayaran.");
        deskripsiAp.setBorder(null);
        deskripsiAp.setCaretColor(new java.awt.Color(245, 239, 231));
        deskripsiAp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                deskripsiApAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane7.setViewportView(deskripsiAp);

        Biodata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/people_3369137 (1).png"))); // NOI18N
        Biodata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BiodataMouseClicked(evt);
            }
        });

        ManualBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book_1124937 (1).png"))); // NOI18N
        ManualBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManualBookMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/multilingual_6314107 (1).png"))); // NOI18N

        javax.swing.GroupLayout ABOUTLayout = new javax.swing.GroupLayout(ABOUT);
        ABOUT.setLayout(ABOUTLayout);
        ABOUTLayout.setHorizontalGroup(
            ABOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ABOUTLayout.createSequentialGroup()
                .addGroup(ABOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ABOUTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ABOUTLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(Biodata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ManualBook)))
                .addContainerGap())
        );
        ABOUTLayout.setVerticalGroup(
            ABOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ABOUTLayout.createSequentialGroup()
                .addGroup(ABOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ABOUTLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ABOUTLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(ABOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ABOUTLayout.createSequentialGroup()
                        .addComponent(ManualBook)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ABOUTLayout.createSequentialGroup()
                        .addComponent(Biodata)
                        .addGap(37, 37, 37))))
        );

        LAPORAN.setBackground(new java.awt.Color(79, 112, 156));
        LAPORAN.setPreferredSize(new java.awt.Dimension(1150, 595));

        lTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lTransaksiMouseClicked(evt);
            }
        });

        lpTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpTransaksi.setText("LAPORAN TRANSAKSI");
        lpTransaksi.setMaximumSize(new java.awt.Dimension(192, 26));
        lpTransaksi.setMinimumSize(new java.awt.Dimension(192, 26));
        lpTransaksi.setPreferredSize(new java.awt.Dimension(192, 26));

        javax.swing.GroupLayout lTransaksiLayout = new javax.swing.GroupLayout(lTransaksi);
        lTransaksi.setLayout(lTransaksiLayout);
        lTransaksiLayout.setHorizontalGroup(
            lTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lTransaksiLayout.createSequentialGroup()
                .addComponent(lpTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        lTransaksiLayout.setVerticalGroup(
            lTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lpTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lTutorMouseClicked(evt);
            }
        });

        lpTutor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpTutor.setText("LAPORAN TUTOR");
        lpTutor.setMaximumSize(new java.awt.Dimension(192, 26));
        lpTutor.setMinimumSize(new java.awt.Dimension(192, 26));
        lpTutor.setPreferredSize(new java.awt.Dimension(192, 26));

        javax.swing.GroupLayout lTutorLayout = new javax.swing.GroupLayout(lTutor);
        lTutor.setLayout(lTutorLayout);
        lTutorLayout.setHorizontalGroup(
            lTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lpTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        lTutorLayout.setVerticalGroup(
            lTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lTutorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lpTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lJadwalMouseClicked(evt);
            }
        });

        lpJadwal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpJadwal.setText("LAPORAN JADWAL");
        lpJadwal.setMaximumSize(new java.awt.Dimension(180, 26));
        lpJadwal.setMinimumSize(new java.awt.Dimension(180, 26));
        lpJadwal.setPreferredSize(new java.awt.Dimension(180, 26));

        javax.swing.GroupLayout lJadwalLayout = new javax.swing.GroupLayout(lJadwal);
        lJadwal.setLayout(lJadwalLayout);
        lJadwalLayout.setHorizontalGroup(
            lJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lJadwalLayout.createSequentialGroup()
                .addComponent(lpJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        lJadwalLayout.setVerticalGroup(
            lJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lJadwalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lpJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAnggotaMouseClicked(evt);
            }
        });

        lpAnggota1.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lpAnggota1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpAnggota1.setText("ANGGOTA");
        lpAnggota1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout lAnggotaLayout = new javax.swing.GroupLayout(lAnggota);
        lAnggota.setLayout(lAnggotaLayout);
        lAnggotaLayout.setHorizontalGroup(
            lAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lAnggotaLayout.createSequentialGroup()
                .addComponent(lpAnggota1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lAnggotaLayout.setVerticalGroup(
            lAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lAnggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lpAnggota1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        lBahasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lBahasaMouseClicked(evt);
            }
        });

        lpAnggota.setBackground(new java.awt.Color(79, 112, 156));
        lpAnggota.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        lpAnggota.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpAnggota.setText("BAHASA");
        lpAnggota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout lBahasaLayout = new javax.swing.GroupLayout(lBahasa);
        lBahasa.setLayout(lBahasaLayout);
        lBahasaLayout.setHorizontalGroup(
            lBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lBahasaLayout.createSequentialGroup()
                .addComponent(lpAnggota)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lBahasaLayout.setVerticalGroup(
            lBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lBahasaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lpAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout panelkiriLayout = new javax.swing.GroupLayout(panelkiri);
        panelkiri.setLayout(panelkiriLayout);
        panelkiriLayout.setHorizontalGroup(
            panelkiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkiriLayout.createSequentialGroup()
                .addGroup(panelkiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelkiriLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelkiriLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelkiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
            .addComponent(lTransaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelkiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelkiriLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(lAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );
        panelkiriLayout.setVerticalGroup(
            panelkiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkiriLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(lBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(lTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(lTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelkiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelkiriLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(lAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(507, Short.MAX_VALUE)))
        );

        pk.setPreferredSize(new java.awt.Dimension(978, 400));

        javax.swing.GroupLayout pkLayout = new javax.swing.GroupLayout(pk);
        pk.setLayout(pkLayout);
        pkLayout.setHorizontalGroup(
            pkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );
        pkLayout.setVerticalGroup(
            pkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pnBahasa.setMaximumSize(null);
        pnBahasa.setOpaque(false);
        pnBahasa.setPreferredSize(new java.awt.Dimension(1025, 0));
        pnBahasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnBahasaMouseClicked(evt);
            }
        });

        jScrollPane2.setMaximumSize(null);

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
        tblBahasa.setMaximumSize(null);

        javax.swing.GroupLayout pnBahasaLayout = new javax.swing.GroupLayout(pnBahasa);
        pnBahasa.setLayout(pnBahasaLayout);
        pnBahasaLayout.setHorizontalGroup(
            pnBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(pnBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE))
            .addGroup(pnBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnBahasaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tblBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnBahasaLayout.setVerticalGroup(
            pnBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(pnBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnBahasaLayout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 420, Short.MAX_VALUE)))
            .addGroup(pnBahasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnBahasaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tblBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnTutor.setMaximumSize(null);

        jScrollPane3.setMaximumSize(null);

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
        tblTutor.setMaximumSize(null);
        jScrollPane3.setViewportView(tblTutor);

        javax.swing.GroupLayout pnTutorLayout = new javax.swing.GroupLayout(pnTutor);
        pnTutor.setLayout(pnTutorLayout);
        pnTutorLayout.setHorizontalGroup(
            pnTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(pnTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE))
        );
        pnTutorLayout.setVerticalGroup(
            pnTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(pnTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTutorLayout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 330, Short.MAX_VALUE)))
        );

        pnJadwal.setMaximumSize(null);

        jScrollPane4.setMaximumSize(null);

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
        tblJadwal.setMaximumSize(null);
        jScrollPane4.setViewportView(tblJadwal);

        javax.swing.GroupLayout pnJadwalLayout = new javax.swing.GroupLayout(pnJadwal);
        pnJadwal.setLayout(pnJadwalLayout);
        pnJadwalLayout.setHorizontalGroup(
            pnJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(pnJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE))
        );
        pnJadwalLayout.setVerticalGroup(
            pnJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(pnJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnJadwalLayout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 422, Short.MAX_VALUE)))
        );

        pnTransaksi.setMaximumSize(null);

        jScrollPane5.setMaximumSize(null);

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
        tblTransaksi.setMaximumSize(null);
        jScrollPane5.setViewportView(tblTransaksi);

        javax.swing.GroupLayout pnTransaksiLayout = new javax.swing.GroupLayout(pnTransaksi);
        pnTransaksi.setLayout(pnTransaksiLayout);
        pnTransaksiLayout.setHorizontalGroup(
            pnTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(pnTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE))
        );
        pnTransaksiLayout.setVerticalGroup(
            pnTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(pnTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
        );

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
        jScrollPane6.setViewportView(tblAnggota);

        javax.swing.GroupLayout pnAnggotaLayout = new javax.swing.GroupLayout(pnAnggota);
        pnAnggota.setLayout(pnAnggotaLayout);
        pnAnggotaLayout.setHorizontalGroup(
            pnAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(pnAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE))
        );
        pnAnggotaLayout.setVerticalGroup(
            pnAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnggotaLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout panellaporanLayout = new javax.swing.GroupLayout(panellaporan);
        panellaporan.setLayout(panellaporanLayout);
        panellaporanLayout.setHorizontalGroup(
            panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellaporanLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnBahasa, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnTutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panellaporanLayout.setVerticalGroup(
            panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellaporanLayout.createSequentialGroup()
                    .addContainerGap(71, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(panellaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panellaporanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout LAPORANLayout = new javax.swing.GroupLayout(LAPORAN);
        LAPORAN.setLayout(LAPORANLayout);
        LAPORANLayout.setHorizontalGroup(
            LAPORANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LAPORANLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelkiri, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(997, Short.MAX_VALUE))
            .addGroup(LAPORANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAPORANLayout.createSequentialGroup()
                    .addContainerGap(204, Short.MAX_VALUE)
                    .addComponent(pk, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(LAPORANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAPORANLayout.createSequentialGroup()
                    .addContainerGap(204, Short.MAX_VALUE)
                    .addComponent(panellaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        LAPORANLayout.setVerticalGroup(
            LAPORANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LAPORANLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelkiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LAPORANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LAPORANLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pk, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
            .addGroup(LAPORANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LAPORANLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panellaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout body1Layout = new javax.swing.GroupLayout(body1);
        body1.setLayout(body1Layout);
        body1Layout.setHorizontalGroup(
            body1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ABOUT, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
            .addGroup(body1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FORM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(body1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LAPORAN, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE))
        );
        body1Layout.setVerticalGroup(
            body1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ABOUT, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
            .addGroup(body1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FORM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(body1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LAPORAN, javax.swing.GroupLayout.PREFERRED_SIZE, 637, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout utamaLayout = new javax.swing.GroupLayout(utama);
        utama.setLayout(utamaLayout);
        utamaLayout.setHorizontalGroup(
            utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, utamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(body1, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        utamaLayout.setVerticalGroup(
            utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(body1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbaboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbaboutMouseClicked
        body1.removeAll();
        body1.repaint();
        body1.revalidate();
        
        body1.add(ABOUT);
        body1.repaint();
        body1.revalidate();
    }//GEN-LAST:event_lbaboutMouseClicked

    private void lbmasterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbmasterMouseClicked
        body1.removeAll();
        body1.repaint();
        body1.revalidate();
        
        body1.add(FORM);
        body1.repaint();
        body1.revalidate();
    }//GEN-LAST:event_lbmasterMouseClicked

    private void lblaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaporanMouseClicked
        Laporan lap = new Laporan();
        lap.setVisible(true);
    }//GEN-LAST:event_lblaporanMouseClicked

    private void frmAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frmAnggotaMouseClicked

    }//GEN-LAST:event_frmAnggotaMouseClicked

    private void lBahasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lBahasaMouseClicked

    }//GEN-LAST:event_lBahasaMouseClicked

    private void lTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTutorMouseClicked
        
    }//GEN-LAST:event_lTutorMouseClicked

    private void lJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lJadwalMouseClicked
       
    }//GEN-LAST:event_lJadwalMouseClicked

    private void lTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lTransaksiMouseClicked
        
    }//GEN-LAST:event_lTransaksiMouseClicked

    private void pnBahasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBahasaMouseClicked
         
    }//GEN-LAST:event_pnBahasaMouseClicked

    private void lAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAnggotaMouseClicked
  
    }//GEN-LAST:event_lAnggotaMouseClicked

    private void pBahasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pBahasaMouseClicked
        FormBahasa bhs = new FormBahasa();
        bhs.setVisible(true);
    }//GEN-LAST:event_pBahasaMouseClicked

    private void pJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pJadwalMouseClicked
        FormJadwal jad = new FormJadwal();
        jad.setVisible(true);
    }//GEN-LAST:event_pJadwalMouseClicked

    private void pTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTutorMouseClicked
        FormTutor tr = new FormTutor();
        tr.setVisible(true);
    }//GEN-LAST:event_pTutorMouseClicked

    private void pTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTransaksiMouseClicked
        FormTransaksi trans = new FormTransaksi();
        trans.setVisible(true);
    }//GEN-LAST:event_pTransaksiMouseClicked

    private void pAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pAnggotaMouseClicked
        FormAnggota anggo = new FormAnggota();
        anggo.setVisible(true);
    }//GEN-LAST:event_pAnggotaMouseClicked

    private void deskripsiApAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_deskripsiApAncestorAdded
       
    }//GEN-LAST:event_deskripsiApAncestorAdded

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        dispose();
    }//GEN-LAST:event_keluarMouseClicked

    private void BiodataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BiodataMouseClicked
        FormBiodata fb = new FormBiodata();
        fb.setVisible(true);
    }//GEN-LAST:event_BiodataMouseClicked

    private void ManualBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManualBookMouseClicked
        try {
            String filePath = "..\\icon\\SI22C_Kelompok 1_Manual Book.pdf";
            String[] command = {"cmd", "/c", "start", "\"DummyTitle\"", filePath};
            Process process = Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace(); // Menampilkan detail kesalahan pada konsol
            JOptionPane.showMessageDialog(null, "Error opening PDF file. Check file details.");
        }
        
    }//GEN-LAST:event_ManualBookMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ABOUT;
    private javax.swing.JLabel Biodata;
    private javax.swing.JPanel FORM;
    private javax.swing.JPanel LAPORAN;
    private javax.swing.JLabel ManualBook;
    private javax.swing.JPanel body1;
    private javax.swing.JTextArea deskripsiAp;
    private javax.swing.JLabel frmAnggota;
    private javax.swing.JLabel frmBahasa;
    private javax.swing.JLabel frmJadwal;
    private javax.swing.JLabel frmTransaksi;
    private javax.swing.JLabel frmTutor;
    private javax.swing.JPanel header;
    private javax.swing.JLabel iconAnggota;
    private javax.swing.JLabel iconBahasa;
    private javax.swing.JLabel iconJadwal;
    private javax.swing.JLabel iconTransaksi;
    private javax.swing.JLabel iconTutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel keluar;
    private javax.swing.JPanel lAnggota;
    private javax.swing.JPanel lBahasa;
    private javax.swing.JPanel lJadwal;
    private javax.swing.JPanel lTransaksi;
    private javax.swing.JPanel lTutor;
    private javax.swing.JLabel lbabout;
    private javax.swing.JLabel lblaporan;
    private javax.swing.JLabel lbmaster;
    private javax.swing.JLabel lpAnggota;
    private javax.swing.JLabel lpAnggota1;
    private javax.swing.JLabel lpJadwal;
    private javax.swing.JLabel lpTransaksi;
    private javax.swing.JLabel lpTutor;
    private javax.swing.JPanel pAnggota;
    private javax.swing.JPanel pBahasa;
    private javax.swing.JPanel pJadwal;
    private javax.swing.JPanel pTransaksi;
    private javax.swing.JPanel pTutor;
    private javax.swing.JPanel panelkiri;
    private javax.swing.JPanel panellaporan;
    private javax.swing.JPanel pk;
    private javax.swing.JPanel pnAnggota;
    private javax.swing.JPanel pnBahasa;
    private javax.swing.JPanel pnJadwal;
    private javax.swing.JPanel pnTransaksi;
    private javax.swing.JPanel pnTutor;
    private javax.swing.JTable tblAnggota;
    private javax.swing.JTable tblBahasa;
    private javax.swing.JTable tblJadwal;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTable tblTutor;
    private javax.swing.JPanel utama;
    // End of variables declaration//GEN-END:variables
}
