/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes.IU;

/**
 *
 * @author Foltran
 */
public class ClienteUI extends javax.swing.JFrame {

    /**
     * Creates new form Cliente2UI
     */
    public ClienteUI() {
        initComponents();
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
        p_player1 = new javax.swing.JPanel();
        p_player1_offline = new javax.swing.JPanel();
        p_player1_online = new javax.swing.JPanel();
        lb_player1 = new javax.swing.JLabel();
        lb_saldo1 = new javax.swing.JLabel();
        lb_saldoAtual1 = new javax.swing.JLabel();
        lb_pos1 = new javax.swing.JLabel();
        lb_posAtual1 = new javax.swing.JLabel();
        p_player2 = new javax.swing.JPanel();
        p_player2_offline = new javax.swing.JPanel();
        p_player2_online = new javax.swing.JPanel();
        lb_player2 = new javax.swing.JLabel();
        lb_saldo2 = new javax.swing.JLabel();
        lb_saldoAtual2 = new javax.swing.JLabel();
        lb_pos2 = new javax.swing.JLabel();
        lb_posAtual2 = new javax.swing.JLabel();
        p_player3 = new javax.swing.JPanel();
        p_player3_offline = new javax.swing.JPanel();
        p_player3_online = new javax.swing.JPanel();
        lb_player3 = new javax.swing.JLabel();
        lb_saldo3 = new javax.swing.JLabel();
        lb_saldoAtual3 = new javax.swing.JLabel();
        lb_pos3 = new javax.swing.JLabel();
        lb_posAtual3 = new javax.swing.JLabel();
        p_player4 = new javax.swing.JPanel();
        p_player4_offline = new javax.swing.JPanel();
        p_player4_online = new javax.swing.JPanel();
        lb_player4 = new javax.swing.JLabel();
        lb_saldo4 = new javax.swing.JLabel();
        lb_saldoAtual4 = new javax.swing.JLabel();
        lb_pos4 = new javax.swing.JLabel();
        lb_posAtual4 = new javax.swing.JLabel();
        p_rdados = new javax.swing.JPanel();
        tf_rdados = new javax.swing.JTextField();
        btn_rdados = new javax.swing.JButton();
        tf_rdados1 = new javax.swing.JTextField();
        p_oferta = new javax.swing.JPanel();
        lb_proprietario = new javax.swing.JLabel();
        cb_proprietario = new javax.swing.JComboBox<>();
        lb_propriedade = new javax.swing.JLabel();
        cb_propriedade = new javax.swing.JComboBox<>();
        lb_oferta = new javax.swing.JLabel();
        tf_oferta = new javax.swing.JTextField();
        btn_go = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        m_conectar = new javax.swing.JMenu();
        m_criarSala = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_player1.setBackground(new java.awt.Color(0, 204, 0));
        p_player1.setPreferredSize(new java.awt.Dimension(250, 100));
        p_player1.setLayout(new java.awt.CardLayout());

        p_player1_offline.setBackground(new java.awt.Color(100, 255, 100));
        p_player1_offline.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 50), 3));

        javax.swing.GroupLayout p_player1_offlineLayout = new javax.swing.GroupLayout(p_player1_offline);
        p_player1_offline.setLayout(p_player1_offlineLayout);
        p_player1_offlineLayout.setHorizontalGroup(
            p_player1_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        p_player1_offlineLayout.setVerticalGroup(
            p_player1_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        p_player1.add(p_player1_offline, "player1_offline");

        p_player1_online.setBackground(new java.awt.Color(0, 250, 0));
        p_player1_online.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 150, 50), 3));

        lb_player1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_player1.setText("Player1");

        lb_saldo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldo1.setText("Saldo:");

        lb_saldoAtual1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldoAtual1.setText("Saldo");

        lb_pos1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_pos1.setText("Posição:");

        lb_posAtual1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_posAtual1.setText("Posição");

        javax.swing.GroupLayout p_player1_onlineLayout = new javax.swing.GroupLayout(p_player1_online);
        p_player1_online.setLayout(p_player1_onlineLayout);
        p_player1_onlineLayout.setHorizontalGroup(
            p_player1_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player1_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_player1_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_player1)
                    .addGroup(p_player1_onlineLayout.createSequentialGroup()
                        .addComponent(lb_saldo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_saldoAtual1))
                    .addGroup(p_player1_onlineLayout.createSequentialGroup()
                        .addComponent(lb_pos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_posAtual1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        p_player1_onlineLayout.setVerticalGroup(
            p_player1_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player1_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_player1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_player1_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_saldo1)
                    .addComponent(lb_saldoAtual1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player1_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pos1)
                    .addComponent(lb_posAtual1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        p_player1.add(p_player1_online, "player1_online");

        p_player2.setBackground(new java.awt.Color(0, 204, 0));
        p_player2.setLayout(new java.awt.CardLayout());

        p_player2_offline.setBackground(new java.awt.Color(255, 100, 100));
        p_player2_offline.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 0, 50), 3));

        javax.swing.GroupLayout p_player2_offlineLayout = new javax.swing.GroupLayout(p_player2_offline);
        p_player2_offline.setLayout(p_player2_offlineLayout);
        p_player2_offlineLayout.setHorizontalGroup(
            p_player2_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        p_player2_offlineLayout.setVerticalGroup(
            p_player2_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        p_player2.add(p_player2_offline, "player2_offline");

        p_player2_online.setBackground(new java.awt.Color(250, 0, 0));
        p_player2_online.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 0, 50), 3));
        p_player2_online.setPreferredSize(new java.awt.Dimension(250, 100));

        lb_player2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_player2.setText("Player2");

        lb_saldo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldo2.setText("Saldo:");

        lb_saldoAtual2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldoAtual2.setText("Saldo");

        lb_pos2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_pos2.setText("Posição:");

        lb_posAtual2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_posAtual2.setText("Posição");

        javax.swing.GroupLayout p_player2_onlineLayout = new javax.swing.GroupLayout(p_player2_online);
        p_player2_online.setLayout(p_player2_onlineLayout);
        p_player2_onlineLayout.setHorizontalGroup(
            p_player2_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player2_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_player2_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_player2)
                    .addGroup(p_player2_onlineLayout.createSequentialGroup()
                        .addComponent(lb_pos2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_posAtual2))
                    .addGroup(p_player2_onlineLayout.createSequentialGroup()
                        .addComponent(lb_saldo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_saldoAtual2)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        p_player2_onlineLayout.setVerticalGroup(
            p_player2_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player2_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_player2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player2_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_saldo2)
                    .addComponent(lb_saldoAtual2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player2_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pos2)
                    .addComponent(lb_posAtual2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        p_player2.add(p_player2_online, "player2_online");

        p_player3.setBackground(new java.awt.Color(255, 255, 204));
        p_player3.setLayout(new java.awt.CardLayout());

        p_player3_offline.setBackground(new java.awt.Color(255, 255, 100));
        p_player3_offline.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 50), 3));
        p_player3_offline.setPreferredSize(new java.awt.Dimension(250, 100));

        javax.swing.GroupLayout p_player3_offlineLayout = new javax.swing.GroupLayout(p_player3_offline);
        p_player3_offline.setLayout(p_player3_offlineLayout);
        p_player3_offlineLayout.setHorizontalGroup(
            p_player3_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        p_player3_offlineLayout.setVerticalGroup(
            p_player3_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        p_player3.add(p_player3_offline, "player3_offline");

        p_player3_online.setBackground(new java.awt.Color(250, 250, 0));
        p_player3_online.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 50), 3));

        lb_player3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_player3.setText("Player3");

        lb_saldo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldo3.setText("Saldo:");

        lb_saldoAtual3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldoAtual3.setText("Saldo");

        lb_pos3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_pos3.setText("Posição:");

        lb_posAtual3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_posAtual3.setText("Posição");

        javax.swing.GroupLayout p_player3_onlineLayout = new javax.swing.GroupLayout(p_player3_online);
        p_player3_online.setLayout(p_player3_onlineLayout);
        p_player3_onlineLayout.setHorizontalGroup(
            p_player3_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player3_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_player3_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_player3)
                    .addGroup(p_player3_onlineLayout.createSequentialGroup()
                        .addComponent(lb_pos3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_posAtual3))
                    .addGroup(p_player3_onlineLayout.createSequentialGroup()
                        .addComponent(lb_saldo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_saldoAtual3)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        p_player3_onlineLayout.setVerticalGroup(
            p_player3_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player3_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_player3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player3_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_saldo3)
                    .addComponent(lb_saldoAtual3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player3_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pos3)
                    .addComponent(lb_posAtual3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        p_player3.add(p_player3_online, "player3_online");

        p_player4.setBackground(new java.awt.Color(204, 255, 204));
        p_player4.setLayout(new java.awt.CardLayout());

        p_player4_offline.setBackground(new java.awt.Color(100, 100, 255));
        p_player4_offline.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 50, 100), 3, true));
        p_player4_offline.setPreferredSize(new java.awt.Dimension(250, 100));

        javax.swing.GroupLayout p_player4_offlineLayout = new javax.swing.GroupLayout(p_player4_offline);
        p_player4_offline.setLayout(p_player4_offlineLayout);
        p_player4_offlineLayout.setHorizontalGroup(
            p_player4_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        p_player4_offlineLayout.setVerticalGroup(
            p_player4_offlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        p_player4.add(p_player4_offline, "player4_offline");

        p_player4_online.setBackground(new java.awt.Color(0, 0, 250));
        p_player4_online.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 50, 100), 3, true));
        p_player4_online.setPreferredSize(new java.awt.Dimension(250, 100));

        lb_player4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_player4.setText("Player4");

        lb_saldo4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldo4.setText("Saldo:");

        lb_saldoAtual4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_saldoAtual4.setText("Saldo");

        lb_pos4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_pos4.setText("Posição:");

        lb_posAtual4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_posAtual4.setText("Posição");

        javax.swing.GroupLayout p_player4_onlineLayout = new javax.swing.GroupLayout(p_player4_online);
        p_player4_online.setLayout(p_player4_onlineLayout);
        p_player4_onlineLayout.setHorizontalGroup(
            p_player4_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player4_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_player4_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_player4)
                    .addGroup(p_player4_onlineLayout.createSequentialGroup()
                        .addComponent(lb_pos4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_posAtual4))
                    .addGroup(p_player4_onlineLayout.createSequentialGroup()
                        .addComponent(lb_saldo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_saldoAtual4)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        p_player4_onlineLayout.setVerticalGroup(
            p_player4_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_player4_onlineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_player4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player4_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_saldo4)
                    .addComponent(lb_saldoAtual4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_player4_onlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pos4)
                    .addComponent(lb_posAtual4))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        p_player4.add(p_player4_online, "player4_online");

        p_rdados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tf_rdados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_rdados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_rdados.setText("Rolar Dados!");

        tf_rdados1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout p_rdadosLayout = new javax.swing.GroupLayout(p_rdados);
        p_rdados.setLayout(p_rdadosLayout);
        p_rdadosLayout.setHorizontalGroup(
            p_rdadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_rdadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_rdados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_rdados1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_rdados)
                .addContainerGap())
        );
        p_rdadosLayout.setVerticalGroup(
            p_rdadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_rdadosLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(p_rdadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(p_rdadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_rdados1)
                        .addComponent(btn_rdados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tf_rdados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_oferta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_oferta.setToolTipText("");

        lb_proprietario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_proprietario.setText("Proprietário:");

        cb_proprietario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_proprietario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name2", "Name3", "Name4" }));
        cb_proprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_proprietarioActionPerformed(evt);
            }
        });

        lb_propriedade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_propriedade.setText("Propriedade:");

        cb_propriedade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_propriedade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_oferta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_oferta.setText("Oferta:");

        tf_oferta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_oferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ofertaActionPerformed(evt);
            }
        });

        btn_go.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_go.setText("Ir!");
        btn_go.setPreferredSize(new java.awt.Dimension(101, 31));
        btn_go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_ofertaLayout = new javax.swing.GroupLayout(p_oferta);
        p_oferta.setLayout(p_ofertaLayout);
        p_ofertaLayout.setHorizontalGroup(
            p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ofertaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_ofertaLayout.createSequentialGroup()
                        .addComponent(lb_proprietario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_proprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_ofertaLayout.createSequentialGroup()
                        .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_oferta)
                            .addComponent(lb_propriedade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_propriedade, 0, 169, Short.MAX_VALUE)
                            .addComponent(tf_oferta))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_go, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        p_ofertaLayout.setVerticalGroup(
            p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ofertaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_ofertaLayout.createSequentialGroup()
                        .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_proprietario)
                            .addComponent(cb_proprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_propriedade)
                            .addComponent(cb_propriedade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_ofertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_oferta)))
                    .addComponent(btn_go, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(p_rdados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(p_player3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(p_player1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p_player2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_player4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(p_oferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_player2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_player1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_player3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_player4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p_rdados, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        m_conectar.setText("Conectar");
        menuBar.add(m_conectar);

        m_criarSala.setText("Criar Sala");
        menuBar.add(m_criarSala);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_proprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_proprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_proprietarioActionPerformed

    private void tf_ofertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ofertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ofertaActionPerformed

    private void btn_goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_goActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_go;
    private javax.swing.JButton btn_rdados;
    private javax.swing.JComboBox<String> cb_propriedade;
    private javax.swing.JComboBox<String> cb_proprietario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_oferta;
    private javax.swing.JLabel lb_player1;
    private javax.swing.JLabel lb_player2;
    private javax.swing.JLabel lb_player3;
    private javax.swing.JLabel lb_player4;
    private javax.swing.JLabel lb_pos1;
    private javax.swing.JLabel lb_pos2;
    private javax.swing.JLabel lb_pos3;
    private javax.swing.JLabel lb_pos4;
    private javax.swing.JLabel lb_posAtual1;
    private javax.swing.JLabel lb_posAtual2;
    private javax.swing.JLabel lb_posAtual3;
    private javax.swing.JLabel lb_posAtual4;
    private javax.swing.JLabel lb_propriedade;
    private javax.swing.JLabel lb_proprietario;
    private javax.swing.JLabel lb_saldo1;
    private javax.swing.JLabel lb_saldo2;
    private javax.swing.JLabel lb_saldo3;
    private javax.swing.JLabel lb_saldo4;
    private javax.swing.JLabel lb_saldoAtual1;
    private javax.swing.JLabel lb_saldoAtual2;
    private javax.swing.JLabel lb_saldoAtual3;
    private javax.swing.JLabel lb_saldoAtual4;
    private javax.swing.JMenu m_conectar;
    private javax.swing.JMenu m_criarSala;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel p_oferta;
    private javax.swing.JPanel p_player1;
    private javax.swing.JPanel p_player1_offline;
    private javax.swing.JPanel p_player1_online;
    private javax.swing.JPanel p_player2;
    private javax.swing.JPanel p_player2_offline;
    private javax.swing.JPanel p_player2_online;
    private javax.swing.JPanel p_player3;
    private javax.swing.JPanel p_player3_offline;
    private javax.swing.JPanel p_player3_online;
    private javax.swing.JPanel p_player4;
    private javax.swing.JPanel p_player4_offline;
    private javax.swing.JPanel p_player4_online;
    private javax.swing.JPanel p_rdados;
    private javax.swing.JTextField tf_oferta;
    private javax.swing.JTextField tf_rdados;
    private javax.swing.JTextField tf_rdados1;
    // End of variables declaration//GEN-END:variables
}
