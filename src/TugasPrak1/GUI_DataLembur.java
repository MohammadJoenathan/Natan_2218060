    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TugasPrak1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;;

/**
 *
 * @author ASUS
 */
public class GUI_DataLembur extends javax.swing.JFrame {

    /**
     * Creates new form GUI_DataLembur
     */
    public GUI_DataLembur() {
        initComponents();
        tampil(); // Memanggil method tampil()
        tampil_idKryn(); // Memanggil method tampil_idKryn()
        tampil_namaKryn(); // Memanggil method tampil_namaKryn()
        txtTotalGaji.setText(Integer.toString(0)); // Memberikan nilai awal 0 untuk textfield total gaji
    }
    
    public void batal() {
        // Mengosongkan semua textfield dan membatalkan pemilihan buttongrup
        txtTanggal.setText("");
        txtdurasiLembur.setText("");
        txtPajak.setText("");
        txtgajiLembur.setText("");
        txtTotalGaji.setText("");
    }
    
    public Connection conn;
    // Variabel conn digunakan untuk menyimpan koneksi ke database
    
    String id_kar1, nama_kar1, tanggal1, dur_lem1, pajak1, gaji_lem1, alasan_lem1, total_gaji1;
    // Membuat variabel baru yang digunakan untuk menyimpan data yang akan ditampilkan dalam textfield dan buttongrup saat item dipilih
    
    void itempilih() {
        // Membuat method itempilih() yang digunakan untuk menetapkan nilai textfield dan memilih buttongrup berdasarkan nilai variabel yang telah disimpan sebelumnya
        cmbIdKar.setSelectedItem(id_kar1);
        cmbNamaKar.setSelectedItem(nama_kar1);
        txtTanggal.setText(tanggal1);
        txtdurasiLembur.setText(dur_lem1);
        txtPajak.setText(pajak1);
        txtgajiLembur.setText(gaji_lem1);
        cmbpilihAlasan.setSelectedItem(alasan_lem1);
        txtTotalGaji.setText(total_gaji1);
    }
    
    public void koneksi() throws SQLException {
    // Membuat method koneksi() yang digunakan untuk membuat koneksi ke database MySQL menggunakan driver JDBC
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/OOP_PembayaranGajiPerusahaan?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_DataLembur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_DataLembur.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_DataLembur.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    
    public void tampil() {
    // Membuat method tampil()yang digunakan untuk menampilkan data dari tabel tb_datalembur ke dalam komponen tabel table_pembayarangaji
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID Karyawan");
        tabelhead.addColumn("Nama Karyawan");
        tabelhead.addColumn("Tanggal");
        tabelhead.addColumn("Durasi_Lembur");
        tabelhead.addColumn("Pajak");
        tabelhead.addColumn("Gaji_Lembur");
        tabelhead.addColumn("Alasan_Lembur");
        tabelhead.addColumn("Total_Gaji");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_datalembur";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                // Menambahkan baris dengan nilai-nilai yang sesuai ke model tabel
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9),});
            }
            // Mengatur model tabel ke tabel tb_datalembur
            table_lembur.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    
    public void tampil_idKryn() {
        try {
            koneksi();
            
            // Mengambil data id_karyawan dari tabel tb_pembayarangaji
            String sql = "SELECT id_karyawan FROM tb_pembayarangaji order by id_karyawan asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            
            // Menambahkan id_karyawan ke elemen combobox cmbIdKar
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbIdKar.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_namaKryn() {
        try {
            koneksi();
            
            // Mengambil data nama_karyawan dari tabel tb_pembayarangaji
            String sql = "SELECT nama_karyawan FROM tb_pembayarangaji order by nama_karyawan asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            
            // Menambahkan nama_karyawan ke elemen combobox cmbIdKar
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbNamaKar.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int hit_gaji(){
        // Mengambil nilai pajak dan gaji lembur dari elemen input
        int pajak, gaji_lembur, gaji_bersih, total_gaji;

        try {
            pajak = Integer.parseInt(txtPajak.getText());
            gaji_lembur = Integer.parseInt(txtgajiLembur.getText());
            gaji_bersih = 4000000; // Memberikan nilai gaji_bersih sebesar 4000000
            
            // Menghitung total gaji bersih
            total_gaji = (gaji_bersih + gaji_lembur) - pajak;
        } catch (NumberFormatException e) {
            // Menampilkan pesan kesalahan jika nilai pajak atau gaji lembur tidak valid
            JOptionPane.showMessageDialog(null, "Nilai pajak atau gaji lembur tidak valid!");
            return 0;
        }
        // Menampilkan total gaji di elemen txtTotalGaji
        txtTotalGaji.setText(String.valueOf(total_gaji));
        return total_gaji;
    }
    
    public void refresh() {
    // Membuat instance baru dari GUI_DataLembur dan menampilkannya
        new GUI_DataLembur().setVisible(true);
        this.setVisible(false);
    }
    
    public void insert() {
        // Mendapatkan nilai-nilai dari textfield dan buttongrup
        String id_karyawan = (String) cmbIdKar.getSelectedItem();
        String nama_karyawan = (String) cmbNamaKar.getSelectedItem();
        String tanggal = txtTanggal.getText();
        String durasi_lembur = txtdurasiLembur.getText();
        String pajak = txtPajak.getText();
        String gaji_lembur = txtgajiLembur.getText();
        String alasan_lembur = (String) cmbpilihAlasan.getSelectedItem();
        String total_gaji = txtTotalGaji.getText();
        try {
            koneksi();
            // Membuat statement untuk koneksi database
            Statement statement = conn.createStatement();
            // Menambahkan data baru ke tabel tb_datalembur
            statement.executeUpdate("INSERT INTO tb_datalembur(id_karyawan, nama_karyawan, tanggal, durasi_lembur, pajak, gaji_lembur, alasan_lembur, total_gaji)"
                    + "VALUES('" + id_karyawan + "','" + nama_karyawan + "','" + tanggal + "','" + durasi_lembur + "','" + pajak + "','" + gaji_lembur + "', '" + alasan_lembur + "', '" + total_gaji + "')");
            statement.close();
            // Menampilkan pesan sukses setelah menambahkan data
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Lembur!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
    }
    refresh();
}
    
    public void update() {
        // Mendapatkan nilai-nilai dari textfield dan buttongrup
        String id_karyawan = (String) cmbIdKar.getSelectedItem();
        String nama_karyawan = (String) cmbNamaKar.getSelectedItem();
        String tanggal = txtTanggal.getText();
        String durasi_lembur = txtdurasiLembur.getText();
        String pajak = txtPajak.getText();
        String gaji_lembur = txtgajiLembur.getText();
        String alasan_lembur = (String) cmbpilihAlasan.getSelectedItem();
        String total_gaji = txtTotalGaji.getText();
        
        String idkar_lama = id_kar1;
        String namakar_lama = nama_kar1;
        try {
            // Membuat statement untuk koneksi database
            Statement statement = conn.createStatement();
            // Menjalankan query UPDATE untuk memperbarui data dalam tabel tb_datalembur
            statement.executeUpdate("UPDATE tb_datalembur SET id_karyawan='" + id_karyawan + "'," + "nama_karyawan='" + nama_karyawan + "'"
                    + ",tanggal='" + tanggal + "',durasi_lembur='" + durasi_lembur + "',pajak='" + pajak + "',gaji_lembur='" + gaji_lembur + 
                    "',alasan_lembur='" + alasan_lembur + "',total_gaji='" + total_gaji + "' WHERE id_karyawan ='" + idkar_lama + "' AND nama_karyawan='" + namakar_lama + "'");
            statement.close();
            conn.close();
            // Menampilkan pesan sukses setelah memperbarui data
            JOptionPane.showMessageDialog(null, "Update Data Lembur!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    
    public void delete() {
        // Menampilkan dialog konfirmasi untuk menghapus data
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                // Query DELETE untuk menghapus data dari tabel tb_datalembur
                String sql = "DELETE FROM tb_datalembur WHERE id_karyawan='" + cmbIdKar.getSelectedItem() + "' AND nama_karyawan='" + cmbNamaKar.getSelectedItem() + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                
                // Menampilkan pesan sukses setelah menghapus data
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal di hapus");
            }
        }
        refresh();
    }
    
    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                
                // Query SELECT untuk mencari data berdasarkan id_karyawan
                String sql = "SELECT * FROM tb_datalembur WHERE `id_karyawan` LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql);
                //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    // Menampilkan data yang ditemukan ke elemen-elemen input
                    cmbIdKar.setSelectedItem(rs.getString(2));
                    cmbNamaKar.setSelectedItem(rs.getString(3));
                    txtTanggal.setText(rs.getString(4));
                    txtdurasiLembur.setText(rs.getString(5));
                    txtPajak.setText(rs.getString(6));
                    txtgajiLembur.setText(rs.getString(7));
                    cmbpilihAlasan.setSelectedItem(rs.getString(8));
                    txtTotalGaji.setText(rs.getString(9));
                } else {
                    // Menampilkan pesan jika tidak ada data yang dicari
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        txtdurasiLembur = new javax.swing.JTextField();
        txtgajiLembur = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_lembur = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPajak = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbpilihAlasan = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnPemGaji = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        cmbIdKar = new javax.swing.JComboBox<>();
        cmbNamaKar = new javax.swing.JComboBox<>();
        txtTotalGaji = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DATA LEMBUR KARYAWAN");

        jLabel2.setText("ID Karyawan");

        jLabel3.setText("Nama Karyawan");

        jLabel4.setText("Tanggal");

        jLabel5.setText("Durasi Lembur");

        jLabel6.setText("Pajak");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        table_lembur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama Karyawan", "Tanggal", "Durasi Lembur", "Pajak", "Gaji Lembur", "Alasan Lembur", "Total Gaji"
            }
        ));
        table_lembur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_lemburMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_lembur);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel7.setText("Gaji Lembur");

        txtPajak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPajakActionPerformed(evt);
            }
        });

        jLabel8.setText("Alasan Lembur");

        cmbpilihAlasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beban Kerja Yang Banyak", "Deadline Yang Ketat", "Menambah Penghasilan" }));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnPemGaji.setText("Form Pembayaran Gaji");
        btnPemGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPemGajiActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbIdKar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~ID Karyawan~" }));

        cmbNamaKar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Nama Karyawan~" }));

        jLabel9.setText("Total Gaji");

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalGaji)
                    .addComponent(txtPajak)
                    .addComponent(txtgajiLembur)
                    .addComponent(cmbpilihAlasan, 0, 175, Short.MAX_VALUE)
                    .addComponent(cmbIdKar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbNamaKar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTanggal)
                    .addComponent(txtdurasiLembur)
                    .addComponent(btnProses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(561, 561, 561)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnPemGaji)))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCetak)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBatal)
                                .addComponent(btnClose)
                                .addComponent(btnUpdate)
                                .addComponent(btnHapus)
                                .addComponent(btnPemGaji))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbIdKar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbNamaKar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbpilihAlasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtdurasiLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtgajiLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        insert(); // Memanggil method insert()
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose(); // Menutup jendela saat tombol Close diklik
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete(); // Memanggil method delete()
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtPajakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPajakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPajakActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal(); // Memanggil method batal()
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update(); // Memanggil method update()
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPemGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemGajiActionPerformed
        // TODO add your handling code here:
        new GUI_PembayaranGaji().setVisible(true); // Membuka jendela GUI_PembayaranGaji saat tombol Pembayaran Gaji diklik
    }//GEN-LAST:event_btnPemGajiActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        cari(); // Memanggil method cari()
    }//GEN-LAST:event_btnSearchActionPerformed

    private void table_lemburMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_lemburMouseClicked
        // TODO add your handling code here:
        int tabel = table_lembur.getSelectedRow(); // Mendapatkan baris yang dipilih saat mengklik tb_datalembur
        // Menyimpan nilai-nilai baris yang dipilih ke variabel-variabel
        id_kar1 = table_lembur.getValueAt(tabel, 0).toString();
        nama_kar1 = table_lembur.getValueAt(tabel, 1).toString();
        tanggal1 = table_lembur.getValueAt(tabel, 2).toString();
        dur_lem1 = table_lembur.getValueAt(tabel, 3).toString();
        pajak1 = table_lembur.getValueAt(tabel, 4).toString();
        gaji_lem1 = table_lembur.getValueAt(tabel, 5).toString();
        alasan_lem1 = table_lembur.getValueAt(tabel, 6).toString(); 
        total_gaji1 = table_lembur.getValueAt(tabel, 7).toString();
        itempilih(); // Memanggil metode itempilih()
    }//GEN-LAST:event_table_lemburMouseClicked

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        hit_gaji(); // Memanggil method hit_gaji()
    }//GEN-LAST:event_btnProsesActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_DataLembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_DataLembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_DataLembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_DataLembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_DataLembur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPemGaji;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbIdKar;
    private javax.swing.JComboBox<String> cmbNamaKar;
    private javax.swing.JComboBox<String> cmbpilihAlasan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_lembur;
    private javax.swing.JTextField txtPajak;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTotalGaji;
    private javax.swing.JTextField txtdurasiLembur;
    private javax.swing.JTextField txtgajiLembur;
    // End of variables declaration//GEN-END:variables
}
