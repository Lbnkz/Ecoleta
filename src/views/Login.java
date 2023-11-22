package views;

import DAO.PontosColetaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        tfdCity = new javax.swing.JTextField();
        searchCollectionPoints = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createCollectPointButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        tfdCity.setToolTipText("Cidade");
        tfdCity.setBorder(null);

        searchCollectionPoints.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        searchCollectionPoints.setText("BUSCAR");
        searchCollectionPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCollectionPointsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel1.setText("Cidade");

        jLabel3.setFont(new java.awt.Font("JetBrainsMono NF", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 33, 83));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("de resíduos");
        jLabel3.setAutoscrolls(true);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("JetBrainsMono NF", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 33, 83));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Seu marketplace de coleta ");
        jLabel4.setAutoscrolls(true);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ou");

        createCollectPointButton.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        createCollectPointButton.setText("CADASTRAR PONTO DE COLETA");
        createCollectPointButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCollectPointButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createCollectPointButton, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addComponent(searchCollectionPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfdCity))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo)
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdCity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchCollectionPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createCollectPointButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Boolean nullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
    
    private void searchCollectionPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCollectionPointsActionPerformed
        String city = this.tfdCity.getText();
        boolean verify = PontosColetaDAO.buscarCidadeNome(city);

        if (nullOrEmpty(city) || verify == false) {
            JOptionPane.showMessageDialog(null, "Preencha o campo cidade com um ponto válido!");
        } else {
            this.dispose();
            new CollectionPoints(city).setVisible(true);
        }
    }//GEN-LAST:event_searchCollectionPointsActionPerformed

    private void createCollectPointButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCollectPointButtonActionPerformed
        this.dispose();
        new CreateCollectPoint().setVisible(true);
    }//GEN-LAST:event_createCollectPointButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createCollectPointButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logo;
    private javax.swing.JButton searchCollectionPoints;
    private javax.swing.JTextField tfdCity;
    // End of variables declaration//GEN-END:variables
}
