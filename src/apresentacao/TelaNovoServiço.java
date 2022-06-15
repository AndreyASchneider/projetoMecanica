/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apresentacao;

import apoio.db.DataBaseException;
import apoio.db.DuplicateKeyException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import negocio.Carro;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Ordens;
import negocio.Peças;
import negocio.Usuario;
import persistencia.CarroDAO;
import persistencia.ClienteDAO;
import persistencia.DAOFactory;
import persistencia.FuncionarioDAO;
import persistencia.OrdensDAO;
import persistencia.PeçasDAO;

/**
 *
 * @author Usuario
 */
public class TelaNovoServiço extends javax.swing.JFrame {

    private boolean novo;
    private double valor_peças;
    private double valor_maoobra;
    private double valor_total;
    private Cliente cliente;
    private Carro carro;
    private Funcionario funcionario;
    private Usuario usuario;
    private Peças peça;
    private ArrayList serviços_realizados = new ArrayList();
    private ArrayList descriçao_serviços_realizados = new ArrayList();
    private Ordens ordem;
    LocalDate today = LocalDate.now();
    LocalTime instante = LocalTime.now();

    /**
     * Creates new form asd
     */
    public TelaNovoServiço() {
        novo = true;
        initComponents();

        //COMBO BOX FUNCIONARIOS
        try {
            FuncionarioDAO dao = DAOFactory.newFuncionarioDAO();
            ArrayList<Funcionario> list = dao.lerTudo();

            for (Funcionario func : list) {
                this.ComboBoxFunc.addItem(func.getNome());
            }

        } catch (DataBaseException ex) {

        }

        //CLIENTES
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            ClienteDAO dao = DAOFactory.newClienteDAO();
            clientes = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        //CARROS
        ArrayList<Carro> carros = new ArrayList();
        try {
            CarroDAO dao = DAOFactory.newCarroDAO();
            carros = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        //FUNCIONARIOS
        ArrayList<Funcionario> funcionarios = new ArrayList();
        try {
            FuncionarioDAO dao = DAOFactory.newFuncionarioDAO();
            funcionarios = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        //PEÇAS
        ArrayList<Peças> peças = new ArrayList();
        try {
            PeçasDAO dao = DAOFactory.newPeçasDAO();
            peças = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        CarrosTableModel catm = new CarrosTableModel(carros, clientes);
        Tabela.setModel(catm);

        PeçasTableModel ptm = new PeçasTableModel(peças);
        TabelaPeças.setModel(ptm);

        Tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TabelaPeças.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModelCars = Tabela.getSelectionModel();

        ListSelectionModel selectionModelPeças = TabelaPeças.getSelectionModel();

        selectionModelCars.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = Tabela.getSelectedRow();

                if (row >= 0) {
                    CarrosTableModel tableModel = (CarrosTableModel) Tabela.getModel();
                    carro = tableModel.getCarros().get(row);
                    jTextField1.setText(carro.getPlaca());
                    novo = false;
                }
            }
        });

        selectionModelPeças.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TabelaPeças.getSelectedRow();

                if (row >= 0) {
                    PeçasTableModel tableModel = (PeçasTableModel) TabelaPeças.getModel();
                    peça = tableModel.getPeças().get(row);
                    jTextField3.setText(peça.getQuantidade() + "");
                    jTextField2.setText(peça.getDescriçao());
                    jFormattedTextField1.setText(peça.getPreço());
                    novo = false;
                }
            }
        });

        novoCad();
        atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        TelaNovoServiço = new javax.swing.JPanel();
        SalvarButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxFunc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DataEntrada = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        HoraEntrada = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        CheckEletrica = new javax.swing.JCheckBox();
        CheckEscapamento = new javax.swing.JCheckBox();
        CheckFreio = new javax.swing.JCheckBox();
        CheckLataria = new javax.swing.JCheckBox();
        CheckMotor = new javax.swing.JCheckBox();
        CheckSuspensao = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        ValorPeças = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        DataEntrega = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        HoraEntrega = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TabelaPeças = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        ValorMaoObra = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        ValorTotal = new javax.swing.JTextField();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor de Peças", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList2);

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 650));

        TelaNovoServiço.setBackground(new java.awt.Color(255, 255, 255));
        TelaNovoServiço.setMaximumSize(new java.awt.Dimension(1000000000, 1000000000));
        TelaNovoServiço.setMinimumSize(new java.awt.Dimension(574, 620));
        TelaNovoServiço.setName(""); // NOI18N
        TelaNovoServiço.setPreferredSize(new java.awt.Dimension(574, 620));
        TelaNovoServiço.setVerifyInputWhenFocusTarget(false);

        SalvarButton.setText("Salvar");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome:");

        ComboBoxFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxFuncMouseClicked(evt);
            }
        });

        jLabel2.setText("Data:");

        try {
            DataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Hora:");

        try {
            HoraEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxFunc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBoxFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(HoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serviços", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        CheckEletrica.setText("ELÉTRICA");
        CheckEletrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckEletricaActionPerformed(evt);
            }
        });

        CheckEscapamento.setText("ESCAPAMENTO");
        CheckEscapamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckEscapamentoActionPerformed(evt);
            }
        });

        CheckFreio.setText("FREIO");
        CheckFreio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckFreioActionPerformed(evt);
            }
        });

        CheckLataria.setText("LATARIA");
        CheckLataria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckLatariaActionPerformed(evt);
            }
        });

        CheckMotor.setText("MOTOR");
        CheckMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMotorActionPerformed(evt);
            }
        });

        CheckSuspensao.setText("SUSPENSÃO");
        CheckSuspensao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckSuspensaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckEletrica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckEscapamento, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(CheckSuspensao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckFreio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckLataria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckMotor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CheckEletrica)
                .addGap(18, 18, 18)
                .addComponent(CheckEscapamento)
                .addGap(18, 18, 18)
                .addComponent(CheckFreio)
                .addGap(18, 18, 18)
                .addComponent(CheckLataria)
                .addGap(18, 18, 18)
                .addComponent(CheckMotor)
                .addGap(18, 18, 18)
                .addComponent(CheckSuspensao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor de Peças", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ValorPeças.setEditable(false);
        ValorPeças.setBackground(new java.awt.Color(255, 255, 255));
        ValorPeças.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        ValorPeças.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorPeçasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ValorPeças)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ValorPeças)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Modelo", "Ano", "Placa", "Cliente"
            }

        ));
        jScrollPane2.setViewportView(Tabela);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Previsão de Entrega:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        try {
            DataEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Hora:");

        try {
            HoraEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Data:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(DataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(HoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Peças", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TabelaPeças.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Modelo", "Ano", "Placa", "Cliente"
            }

        ));
        jScrollPane7.setViewportView(TabelaPeças);

        jLabel6.setText("Descrição Peça:");

        jLabel7.setText("Preço:");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Quantidade:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor de Mão de Obra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ValorMaoObra.setEditable(false);
        ValorMaoObra.setBackground(new java.awt.Color(255, 255, 255));
        ValorMaoObra.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ValorMaoObra)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ValorMaoObra)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ValorTotal.setEditable(false);
        ValorTotal.setBackground(new java.awt.Color(255, 255, 255));
        ValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        ValorTotal.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ValorTotal)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ValorTotal)
        );

        javax.swing.GroupLayout TelaNovoServiçoLayout = new javax.swing.GroupLayout(TelaNovoServiço);
        TelaNovoServiço.setLayout(TelaNovoServiçoLayout);
        TelaNovoServiçoLayout.setHorizontalGroup(
            TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaNovoServiçoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaNovoServiçoLayout.createSequentialGroup()
                        .addComponent(CancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalvarButton)
                        .addContainerGap())
                    .addGroup(TelaNovoServiçoLayout.createSequentialGroup()
                        .addGroup(TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))))
        );
        TelaNovoServiçoLayout.setVerticalGroup(
            TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaNovoServiçoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TelaNovoServiçoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TelaNovoServiçoLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(TelaNovoServiçoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvarButton)
                    .addComponent(CancelarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaNovoServiço, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaNovoServiço, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        try {
            PeçasDAO dao = DAOFactory.newPeçasDAO();
            dao.apagar(peça);
            valor_peças = 0;
            valor_maoobra = 0;
        } catch (DataBaseException ex) {
            Logger.getLogger(TelaNovoServiço.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela();
        JFrame TelaInicio = new TelaInicio();
        TelaInicio.setLocationRelativeTo(null);
        TelaInicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String quantidade = jTextField3.getText();
        String descriçao = jTextField2.getText();
        String preço = jFormattedTextField1.getText();
        String dte = DataEntrada.getText();
        String hre = HoraEntrada.getText();
        String dts = DataEntrega.getText();
        String hrs = HoraEntrega.getText();
        novo = true;

        int quantidadeint = Integer.parseInt(quantidade);
        double newpreço = Double.parseDouble(desformataValor(preço));

        String hrsfinicio = (dte + " " + hre);
        String hrsffinal = (dts + " " + hrs);
        findDifference(hrsfinicio, hrsffinal);

        try {
            PeçasDAO dao = DAOFactory.newPeçasDAO();
            if (novo) {
                peça = new Peças(quantidadeint, descriçao, preço);
                dao.criar(peça);
                descriçao_serviços_realizados.add(quantidadeint + " " + descriçao);
                novo = false;
                valor_peças = valor_peças + (newpreço * quantidadeint);

            } else {
                dao.apagar(peça);
                novo = true;
            }
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(TelaNovoServiço.class.getName()).log(Level.SEVERE, null, ex);
        }

        atualizarTabela();
        novaPeça();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void CheckEletricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckEletricaActionPerformed
        this.serviços_realizados.add("Elétrica");
    }//GEN-LAST:event_CheckEletricaActionPerformed

    private void ValorPeçasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorPeçasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorPeçasActionPerformed

    private void CheckEscapamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckEscapamentoActionPerformed
        this.serviços_realizados.add("Escapamento");
    }//GEN-LAST:event_CheckEscapamentoActionPerformed

    private void CheckFreioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckFreioActionPerformed
        this.serviços_realizados.add("Freio");
    }//GEN-LAST:event_CheckFreioActionPerformed

    private void CheckLatariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckLatariaActionPerformed
        this.serviços_realizados.add("Lataria");
    }//GEN-LAST:event_CheckLatariaActionPerformed

    private void CheckMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMotorActionPerformed
        this.serviços_realizados.add("Motor");
    }//GEN-LAST:event_CheckMotorActionPerformed

    private void CheckSuspensaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckSuspensaoActionPerformed
        this.serviços_realizados.add("Suspensão");
    }//GEN-LAST:event_CheckSuspensaoActionPerformed

    private void ComboBoxFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxFuncMouseClicked
        //
    }//GEN-LAST:event_ComboBoxFuncMouseClicked

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        String funcionario_serviço = (String) ComboBoxFunc.getSelectedItem();
        String cliente_serviço = jTextField1.getText();
        String data_entrada = DataEntrada.getText();
        String data_saida = DataEntrega.getText();
        ArrayList serviços = serviços_realizados;
        ArrayList descriçao_serviços = descriçao_serviços_realizados;
        int valor_total_serviços = (int) valor_total;
        novo = true;

        try {
            OrdensDAO dao = DAOFactory.newOrdensDAO();
            if (novo) {
                ordem = new Ordens(funcionario_serviço, cliente_serviço, data_entrada, data_saida, serviços, descriçao_serviços, valor_total_serviços);
                dao.criar(ordem);
                novo = false;
                atualizarTabela();
            } else {
                ordem.setFuncionario(funcionario_serviço);
                ordem.setCliente(cliente_serviço);
                ordem.setData_entrada(data_entrada);
                ordem.setData_saida(data_saida);
                ordem.setServiços(serviços);
                ordem.setDescriçao_serviços(descriçao_serviços);
                ordem.setValor_total(valor_total_serviços);
                dao.editar(ordem);
            }
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(TelaNovoServiço.class.getName()).log(Level.SEVERE, null, ex);
        }

        atualizarTabela();
        novoCad();
        novaPeça();
        limpaTablePeças();
        
        

        JFrame TelaInicio = new TelaInicio();
        TelaInicio.setLocationRelativeTo(null);
        TelaInicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_SalvarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNovoServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoServiço().setVisible(true);
            }
        });
    }

    public String desformataValor(String valor) {
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");

        return valor;
    }

    private void atualizarTabela() {
        //CARROS
        ArrayList<Carro> carros = new ArrayList();
        try {
            CarroDAO dao = DAOFactory.newCarroDAO();
            carros = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        //PEÇAS
        ArrayList<Peças> peças = new ArrayList();
        try {
            PeçasDAO dao = DAOFactory.newPeçasDAO();
            peças = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        CarrosTableModel tableModelCars = (CarrosTableModel) Tabela.getModel();
        PeçasTableModel tableModelPeças = (PeçasTableModel) TabelaPeças.getModel();

        tableModelCars.setCarros(carros);
        tableModelPeças.setPeças(peças);

        Tabela.revalidate();
        TabelaPeças.revalidate();

        Tabela.repaint();
        TabelaPeças.repaint();

        //ATUALIZA OS VALORES
        ValorPeças.setText(valor_peças + "");
        ValorMaoObra.setText(valor_maoobra + "");
        valor_total = (valor_peças + valor_maoobra);
        ValorTotal.setText(valor_total + "");
    }

    private void novoCad() {
        jTextField1.setText("");
        ValorPeças.setText("0.0");
        ValorMaoObra.setText("0.0");
        ValorTotal.setText("0.0");
        DataEntrada.setText("");
        HoraEntrada.setText("");
        DataEntrega.setText("");
        HoraEntrega.setText("");
        novo = true;
    }

    private void novaPeça() {
        jTextField3.setText("");
        jTextField2.setText("");
        jFormattedTextField1.setText("");
        novo = true;
    }
    
    private void limpaTablePeças() {
        try {
            DAOFactory.newPeçasDAO().apagar(peça);
        } catch (DataBaseException ex) {
            
        }
    }

    private void findDifference(String start_date, String end_date) {
        // Create an instance of the SimpleDateFormat class  
        SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        // In the try block, we will try to find the difference  
        try {
            // Use parse method to get date object of both dates  
            Date date1 = obj.parse(start_date);
            Date date2 = obj.parse(end_date);
            // Calucalte time difference in milliseconds   
            long time_difference = date2.getTime() - date1.getTime();
            // Calucalte time difference in days  
            long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
            // Calucalte time difference in minutes  
            long minutes_difference = (time_difference / (1000 * 60)) % 60;
            // Calucalte time difference in hours  
            long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;
            // Show difference in years, in days, hours, minutes, and seconds   
            //System.out.print("Difference " + "between two dates is: ");   
            //System.out.println(hours_difference + " hours, " + minutes_difference + " minutes, " + days_difference + " days.");   

            double minprahr = (double) (time_difference);
            minprahr = minprahr / 3600000;

            if (minprahr >= 24) {
                int aux = (int) (minprahr / 24);
                minprahr = (minprahr - (24 * aux));
                valor_maoobra = (minprahr * 80) + (aux * 640);
            } else {
                valor_maoobra = (minprahr * 80);
            }

        } catch (ParseException excep) {
            excep.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarButton;
    private javax.swing.JCheckBox CheckEletrica;
    private javax.swing.JCheckBox CheckEscapamento;
    private javax.swing.JCheckBox CheckFreio;
    private javax.swing.JCheckBox CheckLataria;
    private javax.swing.JCheckBox CheckMotor;
    private javax.swing.JCheckBox CheckSuspensao;
    private javax.swing.JComboBox<String> ComboBoxFunc;
    private javax.swing.JFormattedTextField DataEntrada;
    private javax.swing.JFormattedTextField DataEntrega;
    private javax.swing.JFormattedTextField HoraEntrada;
    private javax.swing.JFormattedTextField HoraEntrega;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JTable Tabela;
    private javax.swing.JTable TabelaPeças;
    private javax.swing.JPanel TelaNovoServiço;
    private javax.swing.JTextField ValorMaoObra;
    private javax.swing.JTextField ValorPeças;
    private javax.swing.JTextField ValorTotal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
