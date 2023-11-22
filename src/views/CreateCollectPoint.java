package views;

import DAO.PontosColetaDAO;
import entity.CollectPoint;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

public class CreateCollectPoint extends javax.swing.JFrame {

    private GeoPosition geoPositionSelected;
    PontosColetaDAO pontosColetaDAO = new PontosColetaDAO();

    public CreateCollectPoint() {
        initComponents();
        this.setLocationRelativeTo(null);
        initMap();
    }

    private void initMap() {
        JXMapKit mapKit = new JXMapKit();
        mapKit.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        GeoPosition initialPosition = new GeoPosition(-27.237536666590675, -48.62617492675781);
        mapKit.setAddressLocation(initialPosition);
        mapKit.setZoom(7);

        Set<Waypoint> waypoints = new HashSet<>();

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        mapKit.getMainMap().setOverlayPainter(waypointPainter);
        mapKit.getMainMap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                geoPositionSelected = mapKit.getMainMap().convertPointToGeoPosition(e.getPoint());
                Waypoint newWaypoint = new DefaultWaypoint(geoPositionSelected);
                waypoints.clear();
                waypoints.add(newWaypoint);
                waypointPainter.setWaypoints(waypoints);
                mapKit.getMainMap().repaint();
            }
        });
        this.panelMap.setLayout(new BorderLayout());
        this.panelMap.add(mapKit);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        goBackButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        localEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        localName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        localCity = new javax.swing.JTextField();
        localTypeOfWaste = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelMap = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        goBackButton.setFont(new java.awt.Font("JetBrainsMono NFM ExtraBold", 1, 18)); // NOI18N
        goBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seta.png"))); // NOI18N
        goBackButton.setText("Voltar ");
        goBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBackButtonMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("JetBrainsMono NF ExtraBold", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro do Ponto de Coleta");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel3.setText("Nome Local");

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel4.setText("E-mail");

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel5.setText("Cidade");

        localTypeOfWaste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lâmpadas", "Pilhas e Baterias", "Papéis e Papelão", "Resíduos Eletrônicos", "Resíduos Orgânicos", "Óleo de Cozinha" }));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de Resíduo");

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel7.setText("Endereço (Localização)");

        panelMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelMapLayout = new javax.swing.GroupLayout(panelMap);
        panelMap.setLayout(panelMapLayout);
        panelMapLayout.setHorizontalGroup(
            panelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMapLayout.setVerticalGroup(
            panelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(localEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(localCity, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addComponent(localName)
                        .addComponent(localTypeOfWaste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localCity, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localTypeOfWaste, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(goBackButton)))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBackButton)
                    .addComponent(logo))
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackButtonMouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_goBackButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = this.localName.getText();
        String email = this.localEmail.getText();
        String city = this.localCity.getText();
        String typeOfWaste = (String) this.localTypeOfWaste.getSelectedItem();
        Double latitude = this.geoPositionSelected.getLatitude();
        Double longitude = this.geoPositionSelected.getLongitude();

        if (nullOrEmpty(name) || nullOrEmpty(email) || nullOrEmpty(city) || nullOrEmpty(typeOfWaste) || latitude == null || longitude == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CollectPoint nP = new CollectPoint(0, name, email, city, typeOfWaste, latitude, longitude);

        boolean cadastroSucesso = pontosColetaDAO.cadastrarPontoColeta(nP);

        if (cadastroSucesso) {
            limparCampos();
            JOptionPane.showMessageDialog(null, "Ponto de coleta cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Você nao pode cadastrar duas coletas do mesmo material.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public Boolean nullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
    
    private void limparCampos() {
        this.localName.setText("");
        this.localEmail.setText("");
        this.localCity.setText("");
        this.localTypeOfWaste.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel goBackButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField localCity;
    private javax.swing.JTextField localEmail;
    private javax.swing.JTextField localName;
    private javax.swing.JComboBox<String> localTypeOfWaste;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelMap;
    // End of variables declaration//GEN-END:variables
}
