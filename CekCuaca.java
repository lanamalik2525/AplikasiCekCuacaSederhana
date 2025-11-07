package cekcuaca;

import javax.swing.JOptionPane;

public class CekCuaca extends javax.swing.JFrame {

    public CekCuaca() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblKota = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        btnCek = new javax.swing.JButton();
        lblHasil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Cek Cuaca");

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        lblJudul.setText("🌤 Aplikasi Cek Cuaca Sederhana");

        lblKota.setText("Masukkan Nama Kota:");

        btnCek.setText("Cek Cuaca");
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });

        lblHasil.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        lblHasil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHasil.setText("Hasil cuaca akan muncul di sini...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKota)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCek, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJudul))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblJudul)
                .addGap(20, 20, 20)
                .addComponent(lblKota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCek)
                .addGap(18, 18, 18)
                .addComponent(lblHasil)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {
        String kota = txtKota.getText().trim();

        if (kota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String hasil = cekCuacaKota(kota);
        lblHasil.setText("Cuaca di " + kota + ": " + hasil);
    }

    private String cekCuacaKota(String kota) {
        kota = kota.toLowerCase();
        switch (kota) {
            case "jakarta":
                return "Cerah Berawan ☀️";
            case "bandung":
                return "Hujan Ringan 🌧";
            case "surabaya":
                return "Panas Terik 🔥";
            case "bali":
                return "Cerah dan Berangin 🌤";
            case "medan":
                return "Berawan ⛅";
            default:
                return "Data cuaca tidak tersedia ❓";
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CekCuaca().setVisible(true);
        });
    }

    private javax.swing.JButton btnCek;
    private javax.swing.JLabel lblHasil;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKota;
    private javax.swing.JTextField txtKota;
}
