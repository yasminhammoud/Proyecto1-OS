
package mattelfactory;

/**
 *Representa la simulación 
 * 
 * @author Valeria_Yasmin
 */
public class Interface extends javax.swing.JFrame {
    
    Factory mattelFactory = new Factory();
    
    
    /** Crea una nueva interfaz
     * 
     * 
     * En el constructor se le colocan propiedades a la interfaz y se inicializa el txt y 
     * luego la producción
     */
    public Interface() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mattelFactory.ReadTxt();
        mattelFactory.StartProduction();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        DaysLeft = new javax.swing.JTextField();
        BossStatus = new javax.swing.JTextField();
        AmountOfButtons = new javax.swing.JTextField();
        AmountOfBodies = new javax.swing.JTextField();
        AmountOfLegs = new javax.swing.JTextField();
        AmountOfPana = new javax.swing.JTextField();
        ManagerStatus = new javax.swing.JTextField();
        AmountOfArms = new javax.swing.JTextField();
        BackgroundState = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ButtonProducer = new javax.swing.JTextField();
        ArmProducer = new javax.swing.JTextField();
        BodyProducer = new javax.swing.JTextField();
        LegProducer = new javax.swing.JTextField();
        PanaProducer = new javax.swing.JTextField();
        HireArmProducer = new javax.swing.JButton();
        FireArmProducer = new javax.swing.JButton();
        FireButtonProducer = new javax.swing.JButton();
        FireBodyProducer = new javax.swing.JButton();
        FirePanaProducer = new javax.swing.JButton();
        FireLegProducer = new javax.swing.JButton();
        HireButtonProducer = new javax.swing.JButton();
        HireBodyProducer = new javax.swing.JButton();
        HireLegProducer = new javax.swing.JButton();
        HirePanaProducer = new javax.swing.JButton();
        BackgroundProduction = new javax.swing.JLabel();

        jTabbedPane2.addTab("tab1", jTabbedPane3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DaysLeft.setEditable(false);
        DaysLeft.setBackground(new java.awt.Color(153, 153, 153));
        DaysLeft.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        DaysLeft.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DaysLeft.setToolTipText("");
        DaysLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaysLeftActionPerformed(evt);
            }
        });
        jPanel2.add(DaysLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 80, -1));

        BossStatus.setEditable(false);
        BossStatus.setBackground(new java.awt.Color(153, 153, 153));
        BossStatus.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        BossStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BossStatus.setToolTipText("");
        BossStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BossStatusActionPerformed(evt);
            }
        });
        jPanel2.add(BossStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 80, 20));

        AmountOfButtons.setEditable(false);
        AmountOfButtons.setBackground(new java.awt.Color(153, 153, 153));
        AmountOfButtons.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AmountOfButtons.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AmountOfButtons.setToolTipText("");
        AmountOfButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountOfButtonsActionPerformed(evt);
            }
        });
        jPanel2.add(AmountOfButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 80, -1));

        AmountOfBodies.setEditable(false);
        AmountOfBodies.setBackground(new java.awt.Color(153, 153, 153));
        AmountOfBodies.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AmountOfBodies.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AmountOfBodies.setToolTipText("");
        AmountOfBodies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountOfBodiesActionPerformed(evt);
            }
        });
        jPanel2.add(AmountOfBodies, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 80, -1));

        AmountOfLegs.setEditable(false);
        AmountOfLegs.setBackground(new java.awt.Color(153, 153, 153));
        AmountOfLegs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AmountOfLegs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AmountOfLegs.setToolTipText("");
        AmountOfLegs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountOfLegsActionPerformed(evt);
            }
        });
        jPanel2.add(AmountOfLegs, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 80, -1));

        AmountOfPana.setEditable(false);
        AmountOfPana.setBackground(new java.awt.Color(153, 153, 153));
        AmountOfPana.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AmountOfPana.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AmountOfPana.setToolTipText("");
        AmountOfPana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountOfPanaActionPerformed(evt);
            }
        });
        jPanel2.add(AmountOfPana, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 80, -1));

        ManagerStatus.setEditable(false);
        ManagerStatus.setBackground(new java.awt.Color(153, 153, 153));
        ManagerStatus.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ManagerStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ManagerStatus.setToolTipText("");
        ManagerStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagerStatusActionPerformed(evt);
            }
        });
        jPanel2.add(ManagerStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 80, 20));

        AmountOfArms.setEditable(false);
        AmountOfArms.setBackground(new java.awt.Color(153, 153, 153));
        AmountOfArms.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AmountOfArms.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AmountOfArms.setToolTipText("");
        AmountOfArms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountOfArmsActionPerformed(evt);
            }
        });
        jPanel2.add(AmountOfArms, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 80, -1));

        BackgroundState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FactoryState.png"))); // NOI18N
        jPanel2.add(BackgroundState, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        jTabbedPane1.addTab("Estado de la Fábrica", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonProducer.setEditable(false);
        ButtonProducer.setBackground(new java.awt.Color(153, 153, 153));
        ButtonProducer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ButtonProducer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ButtonProducer.setToolTipText("");
        ButtonProducer.setPreferredSize(new java.awt.Dimension(20, 20));
        ButtonProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProducerActionPerformed(evt);
            }
        });
        jPanel3.add(ButtonProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 40, 40));

        ArmProducer.setEditable(false);
        ArmProducer.setBackground(new java.awt.Color(153, 153, 153));
        ArmProducer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ArmProducer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ArmProducer.setToolTipText("");
        ArmProducer.setMinimumSize(new java.awt.Dimension(20, 20));
        ArmProducer.setPreferredSize(new java.awt.Dimension(20, 20));
        ArmProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArmProducerActionPerformed(evt);
            }
        });
        jPanel3.add(ArmProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 40, 40));

        BodyProducer.setEditable(false);
        BodyProducer.setBackground(new java.awt.Color(153, 153, 153));
        BodyProducer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BodyProducer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BodyProducer.setToolTipText("");
        BodyProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BodyProducerActionPerformed(evt);
            }
        });
        jPanel3.add(BodyProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 40, 40));

        LegProducer.setEditable(false);
        LegProducer.setBackground(new java.awt.Color(153, 153, 153));
        LegProducer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LegProducer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LegProducer.setToolTipText("");
        LegProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LegProducerActionPerformed(evt);
            }
        });
        jPanel3.add(LegProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 40, 40));

        PanaProducer.setEditable(false);
        PanaProducer.setBackground(new java.awt.Color(153, 153, 153));
        PanaProducer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PanaProducer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanaProducer.setToolTipText("");
        PanaProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanaProducerActionPerformed(evt);
            }
        });
        jPanel3.add(PanaProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 40, 40));

        HireArmProducer.setBackground(new java.awt.Color(51, 51, 51));
        HireArmProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        HireArmProducer.setForeground(new java.awt.Color(255, 255, 255));
        HireArmProducer.setText("Contratar");
        HireArmProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HireArmProducerActionPerformed(evt);
            }
        });
        jPanel3.add(HireArmProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        FireArmProducer.setBackground(new java.awt.Color(51, 51, 51));
        FireArmProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        FireArmProducer.setForeground(new java.awt.Color(255, 255, 255));
        FireArmProducer.setText("Despedir");
        FireArmProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireArmProducerActionPerformed(evt);
            }
        });
        jPanel3.add(FireArmProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        FireButtonProducer.setBackground(new java.awt.Color(51, 51, 51));
        FireButtonProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        FireButtonProducer.setForeground(new java.awt.Color(255, 255, 255));
        FireButtonProducer.setText("Despedir");
        FireButtonProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireButtonProducerActionPerformed(evt);
            }
        });
        jPanel3.add(FireButtonProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        FireBodyProducer.setBackground(new java.awt.Color(51, 51, 51));
        FireBodyProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        FireBodyProducer.setForeground(new java.awt.Color(255, 255, 255));
        FireBodyProducer.setText("Despedir");
        FireBodyProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireBodyProducerActionPerformed(evt);
            }
        });
        jPanel3.add(FireBodyProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        FirePanaProducer.setBackground(new java.awt.Color(51, 51, 51));
        FirePanaProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        FirePanaProducer.setForeground(new java.awt.Color(255, 255, 255));
        FirePanaProducer.setText("Despedir");
        FirePanaProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirePanaProducerActionPerformed(evt);
            }
        });
        jPanel3.add(FirePanaProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, -1, -1));

        FireLegProducer.setBackground(new java.awt.Color(51, 51, 51));
        FireLegProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        FireLegProducer.setForeground(new java.awt.Color(255, 255, 255));
        FireLegProducer.setText("Despedir");
        FireLegProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FireLegProducerActionPerformed(evt);
            }
        });
        jPanel3.add(FireLegProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        HireButtonProducer.setBackground(new java.awt.Color(51, 51, 51));
        HireButtonProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        HireButtonProducer.setForeground(new java.awt.Color(255, 255, 255));
        HireButtonProducer.setText("Contratar");
        HireButtonProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HireButtonProducerActionPerformed(evt);
            }
        });
        jPanel3.add(HireButtonProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        HireBodyProducer.setBackground(new java.awt.Color(51, 51, 51));
        HireBodyProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        HireBodyProducer.setForeground(new java.awt.Color(255, 255, 255));
        HireBodyProducer.setText("Contratar");
        HireBodyProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HireBodyProducerActionPerformed(evt);
            }
        });
        jPanel3.add(HireBodyProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        HireLegProducer.setBackground(new java.awt.Color(51, 51, 51));
        HireLegProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        HireLegProducer.setForeground(new java.awt.Color(255, 255, 255));
        HireLegProducer.setText("Contratar");
        HireLegProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HireLegProducerActionPerformed(evt);
            }
        });
        jPanel3.add(HireLegProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        HirePanaProducer.setBackground(new java.awt.Color(51, 51, 51));
        HirePanaProducer.setFont(new java.awt.Font("Kristen ITC", 0, 10)); // NOI18N
        HirePanaProducer.setForeground(new java.awt.Color(255, 255, 255));
        HirePanaProducer.setText("Contratar");
        HirePanaProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HirePanaProducerActionPerformed(evt);
            }
        });
        jPanel3.add(HirePanaProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        BackgroundProduction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FactoryProduction.png"))); // NOI18N
        jPanel3.add(BackgroundProduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 500));

        jTabbedPane1.addTab("Producción", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DaysLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaysLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DaysLeftActionPerformed

    private void BossStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BossStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BossStatusActionPerformed

    private void AmountOfButtonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountOfButtonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountOfButtonsActionPerformed

    private void AmountOfBodiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountOfBodiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountOfBodiesActionPerformed

    private void AmountOfLegsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountOfLegsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountOfLegsActionPerformed

    private void AmountOfPanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountOfPanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountOfPanaActionPerformed

    private void ManagerStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagerStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManagerStatusActionPerformed

    private void AmountOfArmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountOfArmsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountOfArmsActionPerformed

    private void ButtonProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProducerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonProducerActionPerformed

    private void ArmProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArmProducerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArmProducerActionPerformed

    private void BodyProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BodyProducerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BodyProducerActionPerformed

    private void LegProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LegProducerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LegProducerActionPerformed

    private void PanaProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanaProducerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PanaProducerActionPerformed

    private void FireArmProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireArmProducerActionPerformed
        mattelFactory.fireArmProducer();
    }//GEN-LAST:event_FireArmProducerActionPerformed

    private void FireButtonProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireButtonProducerActionPerformed
        mattelFactory.fireButtonProducer();
    }//GEN-LAST:event_FireButtonProducerActionPerformed

    private void FireBodyProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireBodyProducerActionPerformed
        mattelFactory.fireBodyProducer();
    }//GEN-LAST:event_FireBodyProducerActionPerformed

    private void FirePanaProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirePanaProducerActionPerformed
        mattelFactory.fireAssembler();
    }//GEN-LAST:event_FirePanaProducerActionPerformed

    private void FireLegProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireLegProducerActionPerformed
        mattelFactory.fireLegProducer();
    }//GEN-LAST:event_FireLegProducerActionPerformed

    private void HirePanaProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HirePanaProducerActionPerformed
        mattelFactory.hireAssembler();
    }//GEN-LAST:event_HirePanaProducerActionPerformed

    private void HireButtonProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HireButtonProducerActionPerformed
        mattelFactory.hireButtonProducer();
    }//GEN-LAST:event_HireButtonProducerActionPerformed

    private void HireArmProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HireArmProducerActionPerformed
        // TODO add your handling code here:
        mattelFactory.hireArmProducer();
    }//GEN-LAST:event_HireArmProducerActionPerformed

    private void HireBodyProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HireBodyProducerActionPerformed
        // TODO add your handling code here:
        mattelFactory.hireBodyProducer();
    }//GEN-LAST:event_HireBodyProducerActionPerformed

    private void HireLegProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HireLegProducerActionPerformed
        // TODO add your handling code here:
        mattelFactory.hireLegProducer();
    }//GEN-LAST:event_HireLegProducerActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JTextField AmountOfArms;
    protected static javax.swing.JTextField AmountOfBodies;
    protected static javax.swing.JTextField AmountOfButtons;
    protected static javax.swing.JTextField AmountOfLegs;
    protected static javax.swing.JTextField AmountOfPana;
    protected static javax.swing.JTextField ArmProducer;
    private javax.swing.JLabel BackgroundProduction;
    private javax.swing.JLabel BackgroundState;
    protected static javax.swing.JTextField BodyProducer;
    protected static javax.swing.JTextField BossStatus;
    protected static javax.swing.JTextField ButtonProducer;
    protected static javax.swing.JTextField DaysLeft;
    private javax.swing.JButton FireArmProducer;
    private javax.swing.JButton FireBodyProducer;
    private javax.swing.JButton FireButtonProducer;
    private javax.swing.JButton FireLegProducer;
    private javax.swing.JButton FirePanaProducer;
    private javax.swing.JButton HireArmProducer;
    private javax.swing.JButton HireBodyProducer;
    private javax.swing.JButton HireButtonProducer;
    private javax.swing.JButton HireLegProducer;
    private javax.swing.JButton HirePanaProducer;
    protected static javax.swing.JTextField LegProducer;
    protected static javax.swing.JTextField ManagerStatus;
    protected static javax.swing.JTextField PanaProducer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane6;
    // End of variables declaration//GEN-END:variables

}
