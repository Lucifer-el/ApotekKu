/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apotekku;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author putra
 */
public class Kasir_Interfaces extends javax.swing.JFrame {
    

    /**
     */
public Kasir_Interfaces() {
        initComponents();
    }
private void insertPemesananToDatabase(String idObat, String namaObat, String stok, String harga, String deskripsi, String idEmpl) {
    // Koneksi database dan query INSERT ke tabel pemesanan
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_apotek", "root", "")) {
        String sql = "INSERT INTO pemesanan (id_obat, nama_obat, stok, harga, deskripsi, id_empl) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, idObat);
        stmt.setString(2, namaObat);
        stmt.setString(3, stok);
        stmt.setString(4, harga);
        stmt.setString(5, deskripsi);
        stmt.setString(6, idEmpl);
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Pemesanan berhasil disimpan");
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}

    
private void pemesananPopUp() {
        JTextField idObatField = new JTextField();
        JTextField namaObatField = new JTextField();
        JTextField stokField = new JTextField();
        JTextField hargaField = new JTextField();
        JTextField deskripsiField = new JTextField();
        JTextField idEmplField = new JTextField();
        
        Object[] message = {
            "ID Obat:", idObatField,
            "Nama Obat:", namaObatField,
            "Stok:", stokField,
            "Harga:", hargaField,
            "Deskripsi:", deskripsiField,
            "ID Empl:", idEmplField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Pemesanan Obat", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String idObat = idObatField.getText();
            String namaObat = namaObatField.getText();
            String stok = stokField.getText();
            String harga = hargaField.getText();
            String deskripsi = deskripsiField.getText();
            String idEmpl = idEmplField.getText();
            
            // Sambungkan ke database
            insertPemesananToDatabase(idObat, namaObat, stok, harga, deskripsi, idEmpl);
        }
    }

private void pembayaranPopUp() {
        JTextField idPembayaranField = new JTextField();
        JTextField jumlahBayarField = new JTextField();
        JTextField tanggalBayarField = new JTextField();
        JTextField metodeBayarField = new JTextField();
        JTextField idEmplField = new JTextField();

        Object[] message = {
            "ID Pembayaran:", idPembayaranField,
            "Jumlah Bayar:", jumlahBayarField,
            "Tanggal Bayar:", tanggalBayarField,
            "Metode Bayar:", metodeBayarField,
            "ID Empl:", idEmplField
        };
        
        int option = JOptionPane.showConfirmDialog(this, message, "Pembayaran", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String idPembayaran = idPembayaranField.getText();
            String jumlahBayar = jumlahBayarField.getText();
            String tanggalBayar = tanggalBayarField.getText();
            String metodeBayar = metodeBayarField.getText();
            String idEmpl = idEmplField.getText();

            // Sambungkan ke database
            insertPembayaranToDatabase(idPembayaran, jumlahBayar, tanggalBayar, metodeBayar, idEmpl);
        }
    }

private void laporanPopUp() {
        JTextField idLaporanField = new JTextField();
        JTextField tanggalLaporanField = new JTextField();
        JTextField jenisLaporanField = new JTextField();
        JTextField isiLaporanField = new JTextField();
        JTextField idEmplField = new JTextField();

        Object[] message = {
            "ID Laporan:", idLaporanField,
            "Tanggal Laporan:", tanggalLaporanField,
            "Jenis Laporan:", jenisLaporanField,
            "Isi Laporan:", isiLaporanField,
            "ID Empl:", idEmplField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Laporan", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String idLaporan = idLaporanField.getText();
            String tanggalLaporan = tanggalLaporanField.getText();
            String jenisLaporan = jenisLaporanField.getText();
            String isiLaporan = isiLaporanField.getText();
            String idEmpl = idEmplField.getText();

            // Sambungkan ke database
            insertLaporanToDatabase(idLaporan, tanggalLaporan, jenisLaporan, isiLaporan, idEmpl);
        }
    }

    // Logout method
    private void logout() {
        this.dispose();
        new Form_login().setVisible(true); // Mengarahkan kembali ke login
    }


    private void insertPembayaranToDatabase(String idPembayaran, String jumlahBayar, String tanggalBayar, String metodeBayar, String idEmpl) {
        // Koneksi database dan query INSERT ke tabel pembayaran
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_apotek", "root", "password")) {
            String sql = "INSERT INTO pembayaran (id_pembayaran, jumlah_bayar, tanggal_bayar, metode_bayar, id_empl) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idPembayaran);
            stmt.setString(2, jumlahBayar);
            stmt.setString(3, tanggalBayar);
            stmt.setString(4, metodeBayar);
            stmt.setString(5, idEmpl);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil disimpan");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void insertLaporanToDatabase(String idLaporan, String tanggalLaporan, String jenisLaporan, String isiLaporan, String idEmpl) {
        // Koneksi database dan query INSERT ke tabel laporan
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_apotek", "root", "password")) {
            String sql = "INSERT INTO laporan (id_laporan, tanggal_laporan, jenis_laporan, isi_laporan, id_empl) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idLaporan);
            stmt.setString(2, tanggalLaporan);
            stmt.setString(3, jenisLaporan);
            stmt.setString(4, isiLaporan);
            stmt.setString(5, idEmpl);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
        JButton pemesananButton = new JButton("Pemesanan");
pemesananButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        pemesananPopUp(); // Pastikan ini memanggil metode yang benar
    }
});

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Kasir#01");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 204));
        jButton1.setText("Pemesanan");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 204));
        jButton2.setText("Pembayaran");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 204));
        jButton3.setText("Lapor");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 0));
        jButton4.setText("Log Out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(39, 39, 39))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pemesananPopUp();
            }
        });        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Kasir_Interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kasir_Interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kasir_Interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasir_Interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kasir_Interfaces().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
