/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TugasPrak1;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableColumnModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class GUI_PembayaranGaji extends javax.swing.JFrame {

    /**
     * Creates new form GUI_PembayaranGaji
     */
    public GUI_PembayaranGaji() {
        initComponents();
        tampil();
//        // Mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableModel dataModel
//        DefaultTableModel dataModel = (DefaultTableModel) table_pembayarangaji.getModel();
//        // Mendapatkan jumlah baris yang ada dalam model data saat ini
//        int rowCount = dataModel.getRowCount();
//        while (rowCount > 0) {
//            dataModel.removeRow(rowCount - 1);
//            // Menghapus baris terakhir dari model data
//            rowCount = dataModel.getRowCount();
//            // Memperbarui nilai rowCount setelah penghapusan baris terakhir
//        }
    }
    
    public void batal() {
        txtID.setText("");
        txtNama.setText("");
        txtEmail.setText("");
        txtJabatan.setText("");
        txtGajiPokok.setText("");
        txtTunjangan.setText("");
        txtPajak.setText("");
        txtTotalGaji.setText("");
        buttonGroupMp.clearSelection();
 }
    public Connection conn;
    
    String id_karyawan1, nama1, email1, jabatan1, gapok1, tnj1, pajak1, toji1, mepem1;
    
    public void itempilih() {
        txtID.setText(id_karyawan1);
        txtNama.setText(nama1);
        txtEmail.setText(email1);
        txtJabatan.setText(jabatan1);
        txtGajiPokok.setText(gapok1);
        txtTunjangan.setText(tnj1);
        txtPajak.setText(pajak1);
        txtTotalGaji.setText(toji1);
        if (mepem1.equalsIgnoreCase("Transfer Bank")) {
            radiobtnTransferBank.setSelected(true);
        } else {
            radiobtnTunai.setSelected(true);

        }
    }
    
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/OOP_PembayaranGajiPerusahaan?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID Karyawan");
        tabelhead.addColumn("Nama Karyawan");
        tabelhead.addColumn("Email");
        tabelhead.addColumn("Jabatan");
        tabelhead.addColumn("Gaji Pokok");
        tabelhead.addColumn("Tunjangan");
        tabelhead.addColumn("Pajak");
        tabelhead.addColumn("Total Gaji");
        tabelhead.addColumn("Metode Pembayaran");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_pembayarangaji";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10),});
            }
            table_pembayarangaji.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    
    public void refresh() {
        new GUI_PembayaranGaji().setVisible(true);
        this.setVisible(false);
    }
    
    public void insert() {
        String id_karyawan = txtID.getText();
        String nama_karyawan = txtNama.getText();
        String email = txtEmail.getText();
        String jabatan = txtJabatan.getText();
        String gaji_pokok = txtGajiPokok.getText();
        String tunjangan = txtTunjangan.getText();
        String pajak = txtPajak.getText();
        String total_gaji = txtTotalGaji.getText();
        String metode_pembayaran;
        if (radiobtnTransferBank.isSelected()) {
            metode_pembayaran = "Transfer Bank";
        } else {
            metode_pembayaran = "Tunai";
        }
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_pembayarangaji (id_karyawan, nama_karyawan, email, jabatan, gaji_pokok, tunjangan, pajak, total_gaji, metode_pembayaran)"
                    + "VALUES('" + id_karyawan + "','" + nama_karyawan + "','" + email + "','" + jabatan + "','" + gaji_pokok + "','" + tunjangan + "', '" + pajak + "', '" + total_gaji + "', '" + metode_pembayaran + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Pembayaran Gaji!" + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    
    public void update() {
        String id_karyawan = txtID.getText();
        String nama_karyawan = txtNama.getText();
        String email = txtEmail.getText();
        String jabatan = txtJabatan.getText();
        String gaji_pokok = txtGajiPokok.getText();
        String tunjangan = txtTunjangan.getText();
        String pajak = txtPajak.getText();
        String total_gaji = txtTotalGaji.getText();
        String metode_pembayaran;
        if (radiobtnTransferBank.isSelected()) {
            metode_pembayaran = "Transfer Bank";
        } else {
            metode_pembayaran = "Tunai";
        }
        String idkarlama = id_karyawan1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_pembayarangaji SET id_karyawan='" + id_karyawan + "'," + "nama_karyawan='" + nama_karyawan + "',"
                    + "email='" + email + "'" + ",jabatan='" + jabatan + "',gaji_pokok='" + gaji_pokok + "',tunjangan='"
                    + tunjangan + "pajak='" + pajak + "total_gaji='" + total_gaji + "metode_pembayaran='" + metode_pembayaran + "' WHERE id_karyawan = '" + idkarlama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Mahasiswa Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_pembayarangaji WHERE id_karyawan='" + txtID.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
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
                String sql = "SELECT * FROM tb_pembayarangaji WHERE `id_karyawan`  LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtID.setText(rs.getString(2));
                    txtNama.setText(rs.getString(3));
                    txtEmail.setText(rs.getString(4));
                    txtJabatan.setText(rs.getString(5));
                    txtGajiPokok.setText(rs.getString(6));
                    txtTunjangan.setText(rs.getString(7));
                    txtPajak.setText(rs.getString(8));
                    txtTotalGaji.setText(rs.getString(9));
                    String mp = rs.getString(10);
                    if (mp.equalsIgnoreCase("L")) {
                        radiobtnTransferBank.setSelected(true);
                    } else {
                        radiobtnTunai.setSelected(true);
                    }
                } else {
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

        buttonGroupMp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        txtGajiPokok = new javax.swing.JTextField();
        txtTunjangan = new javax.swing.JTextField();
        txtPajak = new javax.swing.JTextField();
        txtTotalGaji = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        radiobtnTransferBank = new javax.swing.JRadioButton();
        radiobtnTunai = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pembayarangaji = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnPembayaranGaji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SLIP GAJI KARYAWAN");

        jLabel2.setText("ID Karyawan");

        jLabel3.setText("Nama Karyawan");

        jLabel4.setText("Jabatan");

        jLabel5.setText("Gaji Pokok");

        jLabel6.setText("Tunjangan");

        jLabel7.setText("Pajak");

        jLabel8.setText("Total Gaji");

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

        jLabel9.setText("Metode Pembayaran");

        buttonGroupMp.add(radiobtnTransferBank);
        radiobtnTransferBank.setText("Transfer Bank");
        radiobtnTransferBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnTransferBankActionPerformed(evt);
            }
        });

        buttonGroupMp.add(radiobtnTunai);
        radiobtnTunai.setText("Tunai");

        table_pembayarangaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama Karyawan", "Email", "Jabatan", "Gaji Pokok", "Tunjangan", "Pajak", "Total Gaji", "Metode Pembayaran"
            }
        ));
        jScrollPane1.setViewportView(table_pembayarangaji);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel10.setText("Email");

        btnSearch.setText("Search");

        btnBatal.setText("Batal");

        btnUpdate.setText("Update");

        btnPembayaranGaji.setText("Form Pembayaran Gaji");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(radiobtnTunai))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPajak, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtTunjangan)
                                    .addComponent(txtGajiPokok)
                                    .addComponent(txtNama)
                                    .addComponent(txtID)
                                    .addComponent(txtTotalGaji, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtJabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtEmail)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radiobtnTransferBank)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSearch)
                                    .addGap(33, 33, 33)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPembayaranGaji)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTotalGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(radiobtnTransferBank)
                    .addComponent(btnCetak)
                    .addComponent(btnHapus)
                    .addComponent(btnClose)
                    .addComponent(btnBatal)
                    .addComponent(btnUpdate)
                    .addComponent(btnPembayaranGaji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radiobtnTunai)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
        JOptionPane.showMessageDialog(null, "Data anda Ditambahkan Ke tabel");
        // Mengambil model data dari tabel
        DefaultTableModel dataModel = (DefaultTableModel) table_pembayarangaji.getModel();
        // Inisialisasi sebuah ArrayList bernama 'list'
        List list = new ArrayList<>();
        // Mengatur tabel untuk membuat kolom dari model secara otomatis

        table_pembayarangaji.setAutoCreateColumnsFromModel(true);
        // Membuat instance dari kelas PembayaranGaji
        PembayaranGaji gaji = new PembayaranGaji();
       
        gaji.idKaryawan(txtID.getText());
        gaji.namaKaryawan(txtNama.getText());
        gaji.email(txtEmail.getText());
        gaji.jabatan(txtJabatan.getText());
        gaji.gajiPokok(Integer.parseInt(txtGajiPokok.getText()));
        gaji.tunjangan(Integer.parseInt(txtTunjangan.getText()));
        gaji.pajak(Integer.parseInt(txtPajak.getText()));
        gaji.totalGaji(Integer.parseInt(txtTotalGaji.getText()));
        if (radiobtnTransferBank.isSelected()) {
            gaji.metodePembayaran = radiobtnTransferBank.getText();
        } else {
            gaji.metodePembayaran = radiobtnTunai.getText();
        }

        // Menambahkan data-data dari objek PembayaranGaji ke dalam ArrayList 'list'
        list.add(gaji.idKaryawan());
        list.add(gaji.namaKaryawan());
        list.add(gaji.Email());
        list.add(gaji.jabatan());
        list.add(gaji.gajiPokok());
        list.add(gaji.tunjangan());
        list.add(gaji.Pajak());
        list.add(gaji.totalGaji());
        list.add(gaji.metodePembayaran());

        // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
        dataModel.addRow(list.toArray());
        // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
        //clear();
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        //exit 
        dispose(); 
    }//GEN-LAST:event_btnCloseActionPerformed

    private void radiobtnTransferBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnTransferBankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtnTransferBankActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        // Mengambil model data dari tabel
        DefaultTableModel dataModel = (DefaultTableModel) table_pembayarangaji.getModel();

        // Mendapatkan indeks baris yang dipilih
        int selectedRow = table_pembayarangaji.getSelectedRow();

        // Memastikan ada baris yang dipilih sebelum menghapus
        if (selectedRow != -1) {
            // Menghapus baris yang dipilih dari model tabel
            dataModel.removeRow(selectedRow);
        } else {
            // Jika tidak ada baris yang dipilih, berikan pesan atau lakukan tindakan lain
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_PembayaranGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_PembayaranGaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPembayaranGaji;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupMp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radiobtnTransferBank;
    private javax.swing.JRadioButton radiobtnTunai;
    private javax.swing.JTable table_pembayarangaji;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGajiPokok;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPajak;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalGaji;
    private javax.swing.JTextField txtTunjangan;
    // End of variables declaration//GEN-END:variables
}
