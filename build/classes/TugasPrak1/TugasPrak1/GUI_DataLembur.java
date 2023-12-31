/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TugasPrak1;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

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
        DataLembur lembur = new DataLembur();
        txtPajak.setText("25000");
        txtPajak.setEnabled(false);
        // Mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableModel dataModel
        DefaultTableModel dataModel = (DefaultTableModel) table_lembur.getModel();
        // Mendapatkan jumlah baris yang ada dalam model data saat ini
        int rowCount = dataModel.getRowCount();
        while (rowCount > 0) {
            dataModel.removeRow(rowCount - 1);
            // Menghapus baris terakhir dari model data
            rowCount = dataModel.getRowCount();
            // Memperbarui nilai rowCount setelah penghapusan baris terakhir
        }
    }
    
    public void clear() {
        txtID.setText("");
        txtNama.setText("");
        txtTanggal.setText("");
        txtdurasiLembur.setText("");
        txtgajiLembur.setText("");
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
        txtID = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
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
        pilihAlasan = new javax.swing.JComboBox<>();

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
                "ID Karyawan", "Nama Karyawan", "Alasan Lembur", "Tanggal", "Durasi Lembur", "Gaji Lembur", "Gaji Bersih", "Total Gaji"
            }
        ));
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

        pilihAlasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beban Kerja Yang Banyak", "Deadline Yang Ketat", "Menambah Penghasilan" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPajak, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                            .addComponent(txtgajiLembur)))
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(pilihAlasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(62, 62, 62)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTanggal)
                            .addComponent(txtdurasiLembur, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtNama)
                            .addComponent(txtID))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtdurasiLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgajiLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pilihAlasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus)
                            .addComponent(btnClose)))
                    .addComponent(btnCetak))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {
        // Memeriksa apakah semua inputan telah diisi
        if (txtID.getText().isEmpty() || txtNama.getText().isEmpty() || txtTanggal.getText().isEmpty() ||
                txtdurasiLembur.getText().isEmpty() || txtgajiLembur.getText().isEmpty()) {
            throw new Exception("Mohon isi semua inputan");
        }
        // Mengambil model data dari tabel
        DefaultTableModel dataModel = (DefaultTableModel) table_lembur.getModel();
        // Inisialisasi sebuah ArrayList bernama 'list'
        List list = new ArrayList<>();
        // Mengatur tabel untuk membuat kolom dari model secara otomatis
        table_lembur.setAutoCreateColumnsFromModel(true);
        // Membuat instance dari kelas Lembur
        DataLembur lembur = new DataLembur();
        String Alasan; // Membuat sebuah variabel baru dengan nama Alasan bertipe String
        lembur.idKaryawan(txtID.getText());
        lembur.namaKaryawan(txtNama.getText());
        if (pilihAlasan.getSelectedIndex() ==0) { // Combobox untuk memilih alasan lembur
            Alasan = lembur.Alasan1(); // Memilih Alasan 1
        } else if (pilihAlasan.getSelectedIndex() == 1){
            Alasan = lembur.Alasan2(); // Memilih Alasan 2
        } else {
            Alasan = lembur.Alasan3(); // Memilih Alasan 3
        }
        lembur.tanggal(txtTanggal.getText());
        lembur.durasiLembur(Integer.parseInt(txtdurasiLembur.getText()));
        lembur.setGajiLembur(Integer.parseInt(txtgajiLembur.getText()));

        // Menambahkan data-data dari objek DataLembur ke dalam ArrayList 'list'
        list.add(lembur.idKaryawan());
        list.add(lembur.namaKaryawan());
        list.add(Alasan);
        list.add(lembur.tanggal());
        list.add(lembur.durasiLembur());
        list.add(lembur.getGajiLembur());
        list.add(lembur.Pajak());
        list.add(lembur.hitGaji());

        // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
        dataModel.addRow(list.toArray());
        // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
        clear();
        } catch (NumberFormatException e) {
            // Menampilkan exception jika terjadi kesalahan inputan yang tidak valid 
            JOptionPane.showMessageDialog(null, "Mohon masukkan angka yang valid", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Menampilkan exception umum
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
            JOptionPane.showMessageDialog(null, "Data anda Ditambahkan Ke tabel");
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        //exit 
        dispose(); 
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        // Mengambil model data dari tabel
        DefaultTableModel dataModel = (DefaultTableModel) table_lembur.getModel();

        // Mendapatkan indeks baris yang dipilih
        int selectedRow = table_lembur.getSelectedRow();

        // Memastikan ada baris yang dipilih sebelum menghapus
        if (selectedRow != -1) {
            // Menghapus baris yang dipilih dari model tabel
            dataModel.removeRow(selectedRow);
        } else {
            // Jika tidak ada baris yang dipilih, berikan pesan atau lakukan tindakan lain
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtPajakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPajakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPajakActionPerformed

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
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilihAlasan;
    private javax.swing.JTable table_lembur;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPajak;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtdurasiLembur;
    private javax.swing.JTextField txtgajiLembur;
    // End of variables declaration//GEN-END:variables
}
