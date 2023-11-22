package views;

import DAO.PontosColetaDAO;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import entity.CollectPoint;
import java.util.List;

public class CollectionPoints extends javax.swing.JFrame {

    private static PontosColetaDAO pontosColetaDAO = new PontosColetaDAO();

    public CollectionPoints(String city) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.title.setText("Ponto de coleta em: " + city);
        loadCollectionPointsOfCity(city);
    }

    private void loadCollectionPointsOfCity(String nm) {
        ArrayList<CollectPoint> points = pontosColetaDAO.buscarPontosColetaPorCidade(nm);
        drawMap(points);
    }

    private void drawMap(ArrayList<CollectPoint> points) {
        JXMapKit mapKit = new JXMapKit();
        mapKit.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        GeoPosition initialPosition = new GeoPosition(-27.237536666590675, -48.62617492675781);
        mapKit.setAddressLocation(initialPosition);
        mapKit.setZoom(7);

        Set<Waypoint> waypoints = new HashSet<>();

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);

        mapKit.getMainMap().setOverlayPainter(waypointPainter);

        for (CollectPoint point : points) {
            Waypoint newWaypoint = new DefaultWaypoint(point.getLatitude(), point.getLongitude());
            waypoints.add(newWaypoint);
            waypointPainter.setWaypoints(waypoints);
        }

        mapKit.getMainMap().repaint();
        this.panelMap.setLayout(new BorderLayout());
        this.panelMap.add(mapKit);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        goBackButton = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelMap = new javax.swing.JPanel();

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

        title.setFont(new java.awt.Font("JetBrainsMono NF ExtraBold", 1, 18)); // NOI18N
        title.setText("Pontos de Coleta em: ");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel7.setText("Localização");

        panelMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelMap.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
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
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackButtonMouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_goBackButtonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel goBackButton;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelMap;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
