/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import negocio.Cliente;
import negocio.Carro;
import apoio.db.DuplicateKeyException;
import static apoio.ValidaCPF.isCPF;
import apoio.db.DataBaseException;
import negocio.Funcionario;
import negocio.Usuario;
import persistencia.CarroDAO;
import persistencia.ClienteDAO;
import persistencia.DAOFactory;
import persistencia.FuncionarioDAO;
import persistencia.UsuarioDAO;

/**
 *
 * @author andrey.schneider
 */
public class TelaCad extends javax.swing.JFrame {

    private boolean novo;
    private Cliente cliente;
    private Carro carro;
    private Funcionario funcionario;
    private boolean validaCPF;

    public TelaCad() {
        novo = false;
        validaCPF = false;
        initComponents();

        //COMBO BOX CLIENTES
        try {
            UsuarioDAO dao = DAOFactory.newUsuarioDAO();
            ArrayList<Usuario> list = dao.lerTudo();

            for (Usuario usuario : list) {
                this.ClienteComboBox.addItem(usuario.getId());
            }

        } catch (DataBaseException ex) {

        }

        //COMBO BOX CARROS
        try {
            ClienteDAO dao = DAOFactory.newClienteDAO();
            ArrayList<Cliente> list = dao.lerTudo();

            for (Cliente clie : list) {
                this.CarroComboBox.addItem(clie);
            }

        } catch (DataBaseException ex) {

        }

        //USUARIOS
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            UsuarioDAO dao = DAOFactory.newUsuarioDAO();
            usuarios = dao.lerTudo();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
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

        ClientesTableModel cltm = new ClientesTableModel(clientes, usuarios);
        TabelaClientes.setModel(cltm);

        CarrosTableModel catm = new CarrosTableModel(carros, clientes);
        TabelaCarros.setModel(catm);

        FuncionariosTableModel ftm = new FuncionariosTableModel(funcionarios);
        TabelaFuncionarios.setModel(ftm);

        TabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TabelaCarros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TabelaFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListSelectionModel selectionModelClients = TabelaClientes.getSelectionModel();
        ListSelectionModel selectionModelCars = TabelaCarros.getSelectionModel();
        ListSelectionModel selectionModelFuncionarios = TabelaFuncionarios.getSelectionModel();

        selectionModelClients.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TabelaClientes.getSelectedRow();

                if (row >= 0) {
                    ClientesTableModel tableModel = (ClientesTableModel) TabelaClientes.getModel();
                    cliente = tableModel.getClientes().get(row);
                    ClienteComboBox.setSelectedIndex(cliente.getId() - 1);
                    NomeTextField.setText(cliente.getName());
                    CPFTextField.setText(cliente.getCPF());
                    novo = false;
                }
            }
        });

        selectionModelCars.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TabelaCarros.getSelectedRow();

                if (row >= 0) {
                    CarrosTableModel tableModel = (CarrosTableModel) TabelaCarros.getModel();
                    carro = tableModel.getCarros().get(row);
                    ModeloTextField.setText(carro.getModelo());
                    AnoTextField.setText(Integer.toString(carro.getAno()));
                    PlacaTextField.setText(carro.getPlaca());
                    CarroComboBox.setSelectedIndex(carro.getProprietario() - 1);
                    novo = false;
                }
            }
        });

        selectionModelFuncionarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TabelaFuncionarios.getSelectedRow();

                if (row >= 0) {
                    FuncionariosTableModel tableModel = (FuncionariosTableModel) TabelaFuncionarios.getModel();
                    funcionario = tableModel.getFunc().get(row);
                    NomeFuncTextField.setText(funcionario.getNome());
                    CPFFuncTextField.setText(funcionario.getCpf());
                    FunçaoFuncTextField.setText(funcionario.getFuncao());
                    novo = false;
                }
            }
        });

        novoCadCliente();
        novoCadCarro();
        novoCadFunc();

    }

    public String desformataCPF(String CPF) {
        CPF = CPF.replace("-", "");
        CPF = CPF.replace(".", "");

        return CPF;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        TelaCadastros = new javax.swing.JTabbedPane();
        CadClientes = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        SalvarCliente = new javax.swing.JButton();
        ApagarCliente = new javax.swing.JButton();
        NomeTextField = new javax.swing.JTextField();
        CancelaCadastroCliente = new javax.swing.JButton();
        CPFTextField = new javax.swing.JFormattedTextField();
        ClienteComboBox = new javax.swing.JComboBox<>();
        CadCarros = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ModeloTextField = new javax.swing.JTextField();
        AnoTextField = new javax.swing.JTextField();
        PlacaTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelaCarros = new javax.swing.JTable();
        SalvarCarro = new javax.swing.JButton();
        ApagarCarro = new javax.swing.JButton();
        CancelaCadastroCarro = new javax.swing.JButton();
        CarroComboBox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        CadFuncionarios = new javax.swing.JPanel();
        ApagarFunc = new javax.swing.JButton();
        CancelaCadastroFunc = new javax.swing.JButton();
        CPFFuncTextField = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TabelaFuncionarios = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        SalvarFunc = new javax.swing.JButton();
        NomeFuncTextField = new javax.swing.JTextField();
        FunçaoFuncTextField = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        jMenuItem6.setText("jMenuItem6");

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

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TelaCadastros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaCadastrosMouseClicked(evt);
            }
        });

        CadClientes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("CPF:");

        jLabel12.setText("Nome:");

        jLabel13.setText("Código:");

        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF"
            }
        ));
        jScrollPane7.setViewportView(TabelaClientes);

        jLabel14.setText("CADASTRO DE CLIENTES:");

        SalvarCliente.setText("Salvar");
        SalvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarClienteActionPerformed(evt);
            }
        });

        ApagarCliente.setText("Apagar");
        ApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarClienteActionPerformed(evt);
            }
        });

        CancelaCadastroCliente.setText("Cancelar");
        CancelaCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelaCadastroClienteActionPerformed(evt);
            }
        });

        try {
            CPFTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPFTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CPFTextFieldFocusLost(evt);
            }
        });

        ClienteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CadClientesLayout = new javax.swing.GroupLayout(CadClientes);
        CadClientes.setLayout(CadClientesLayout);
        CadClientesLayout.setHorizontalGroup(
            CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadClientesLayout.createSequentialGroup()
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CadClientesLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel14))
                    .addGroup(CadClientesLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CadClientesLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(28, 28, 28)
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(CPFTextField)
                    .addComponent(ClienteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(180, 180, 180))
            .addGroup(CadClientesLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(ApagarCliente)
                .addGap(93, 93, 93)
                .addComponent(SalvarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelaCadastroCliente)
                .addGap(90, 90, 90))
        );
        CadClientesLayout.setVerticalGroup(
            CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(47, 47, 47)
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(CadClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvarCliente)
                    .addComponent(CancelaCadastroCliente)
                    .addComponent(ApagarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TelaCadastros.addTab("Cliente", CadClientes);

        CadCarros.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("CADASTRO DE CARROS:");

        jLabel5.setText("Proprietário:");

        jLabel6.setText("Placa:");

        jLabel7.setText("Ano:");

        jLabel8.setText("Modelo:");

        TabelaCarros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(TabelaCarros);

        SalvarCarro.setText("Salvar");
        SalvarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarCarroActionPerformed(evt);
            }
        });

        ApagarCarro.setText("Apagar");
        ApagarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarCarroActionPerformed(evt);
            }
        });

        CancelaCadastroCarro.setText("Cancelar");
        CancelaCadastroCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelaCadastroCarroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CadCarrosLayout = new javax.swing.GroupLayout(CadCarros);
        CadCarros.setLayout(CadCarrosLayout);
        CadCarrosLayout.setHorizontalGroup(
            CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadCarrosLayout.createSequentialGroup()
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CadCarrosLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel9))
                    .addGroup(CadCarrosLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CadCarrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PlacaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(AnoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(ModeloTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(CarroComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(180, 180, 180))
            .addGroup(CadCarrosLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(ApagarCarro)
                .addGap(93, 93, 93)
                .addComponent(SalvarCarro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelaCadastroCarro)
                .addGap(90, 90, 90))
        );
        CadCarrosLayout.setVerticalGroup(
            CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadCarrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(44, 44, 44)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModeloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlacaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CarroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(CadCarrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvarCarro)
                    .addComponent(CancelaCadastroCarro)
                    .addComponent(ApagarCarro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TelaCadastros.addTab("Carro", CadCarros);

        CadFuncionarios.setBackground(new java.awt.Color(255, 255, 255));

        ApagarFunc.setText("Apagar");
        ApagarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarFuncActionPerformed(evt);
            }
        });

        CancelaCadastroFunc.setText("Cancelar");
        CancelaCadastroFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelaCadastroFuncActionPerformed(evt);
            }
        });

        try {
            CPFFuncTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPFFuncTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CPFFuncTextFieldFocusLost(evt);
            }
        });

        jLabel15.setText("Função:");

        jLabel16.setText("CPF:");

        jLabel17.setText("Nome:");

        TabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Funçao"
            }
        ));
        jScrollPane8.setViewportView(TabelaFuncionarios);

        jLabel18.setText("CADASTRO DE FUNCIONARIOS:");

        SalvarFunc.setText("Salvar");
        SalvarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarFuncActionPerformed(evt);
            }
        });

        NomeFuncTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeFuncTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CadFuncionariosLayout = new javax.swing.GroupLayout(CadFuncionarios);
        CadFuncionarios.setLayout(CadFuncionariosLayout);
        CadFuncionariosLayout.setHorizontalGroup(
            CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadFuncionariosLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(CadFuncionariosLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(ApagarFunc)
                .addGap(93, 93, 93)
                .addComponent(SalvarFunc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelaCadastroFunc)
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CadFuncionariosLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(28, 28, 28)
                .addGroup(CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CPFFuncTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addGroup(CadFuncionariosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel18))
                    .addComponent(NomeFuncTextField)
                    .addComponent(FunçaoFuncTextField))
                .addGap(180, 180, 180))
        );
        CadFuncionariosLayout.setVerticalGroup(
            CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(40, 40, 40)
                .addGroup(CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(NomeFuncTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(CPFFuncTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(FunçaoFuncTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(CadFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvarFunc)
                    .addComponent(CancelaCadastroFunc)
                    .addComponent(ApagarFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CadFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CadFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TelaCadastros.addTab("Funcionario", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCadastros)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaCadastros)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NomeTextFieldFocusLost
        if (NomeTextField.getText().length() == 0) {
            SalvarCliente.setEnabled(false);
            NomeTextField.setBackground(Color.red);
        } else {
            SalvarCliente.setEnabled(true);
            NomeTextField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_NomeTextFieldFocusLost

    private void ModeloTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ModeloTextFieldFocusLost
        if (ModeloTextField.getText().length() == 0) {
            SalvarCliente.setEnabled(false);
            ModeloTextField.setBackground(Color.red);
        } else {
            SalvarCliente.setEnabled(true);
            ModeloTextField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_ModeloTextFieldFocusLost

    private void AnoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AnoTextFieldFocusLost
        if (AnoTextField.getText().length() == 0) {
            SalvarCliente.setEnabled(false);
            AnoTextField.setBackground(Color.red);
        } else {
            SalvarCliente.setEnabled(true);
            AnoTextField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_AnoTextFieldFocusLost

    private void PlacaTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PlacaTextFieldFocusLost
        if (PlacaTextField.getText().length() == 0) {
            SalvarCliente.setEnabled(false);
            PlacaTextField.setBackground(Color.red);
        } else {
            SalvarCliente.setEnabled(true);
            PlacaTextField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_PlacaTextFieldFocusLost

    private void ProprietarioTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProprietarioTextFieldFocusLost
        //
    }//GEN-LAST:event_ProprietarioTextFieldFocusLost

    private void TelaCadastrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaCadastrosMouseClicked
        atualizarTabela();
    }//GEN-LAST:event_TelaCadastrosMouseClicked

    private void CancelaCadastroCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelaCadastroCarroActionPerformed
        JFrame TelaInicio = new TelaInicio();
        TelaInicio.setLocationRelativeTo(null);
        TelaInicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelaCadastroCarroActionPerformed

    private void ApagarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarCarroActionPerformed
        try {
            CarroDAO dao = DAOFactory.newCarroDAO();
            dao.apagar(carro);
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        novoCadCarro();
    }//GEN-LAST:event_ApagarCarroActionPerformed

    private void SalvarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarCarroActionPerformed
        String modelo = ModeloTextField.getText();
        int ano = Integer.parseInt(AnoTextField.getText());
        String placa = PlacaTextField.getText();
        Cliente prop = (Cliente) CarroComboBox.getSelectedItem();

        try {
            CarroDAO dao = DAOFactory.newCarroDAO();
            if (novo) {
                carro = new Carro(modelo, ano, placa, prop.getId());
                dao.criar(carro);
                novo = false;
            } else {
                carro.setModelo(modelo);
                carro.setAno(ano);
                carro.setPlaca(placa);
                carro.setProprietario(prop.getId());
                dao.editar(carro);
            }
        } catch (DuplicateKeyException ex) {
            System.out.println("Chave duplicada");
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        novoCadCarro();
    }//GEN-LAST:event_SalvarCarroActionPerformed

    private void ClienteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteComboBoxActionPerformed

    private void CPFTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CPFTextFieldFocusLost
        String cpf = CPFTextField.getText();
        cpf = desformataCPF(cpf);

        if (!isCPF(cpf) || cpf.length() < 8) {
            //System.out.println("CPF inválido!");
            SalvarCliente.setEnabled(false);
            CPFTextField.setBackground(Color.red);
        } else {
            //System.out.println("CPF válido!");
            SalvarCliente.setEnabled(true);
            CPFTextField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_CPFTextFieldFocusLost

    private void CancelaCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelaCadastroClienteActionPerformed
        JFrame TelaInicio = new TelaInicio();
        TelaInicio.setLocationRelativeTo(null);
        TelaInicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelaCadastroClienteActionPerformed

    private void ApagarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarClienteActionPerformed
        try {
            ClienteDAO dao = DAOFactory.newClienteDAO();
            dao.apagar(cliente);
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        novoCadCliente();
    }//GEN-LAST:event_ApagarClienteActionPerformed

    private void SalvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarClienteActionPerformed
        int id = (int) ClienteComboBox.getSelectedItem();
        String nome = NomeTextField.getText();
        String CPF = CPFTextField.getText();

        try {
            ClienteDAO dao = DAOFactory.newClienteDAO();
            if (novo) {
                cliente = new Cliente(id, nome, CPF);
                //System.out.println(id + " " + nome + " " + CPF);
                dao.criar(cliente);
                novo = false;
                atualizarTabela();
            } else {
                cliente.setName(nome);
                cliente.setCPF(CPF);
                dao.editar(cliente);
            }
        } catch (DuplicateKeyException ex) {
            System.out.println("Chave duplicada!");
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        novoCadCliente();
    }//GEN-LAST:event_SalvarClienteActionPerformed

    private void ApagarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarFuncActionPerformed
        try {
            FuncionarioDAO dao = DAOFactory.newFuncionarioDAO();
            dao.apagar(funcionario);
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        novoCadFunc();
    }//GEN-LAST:event_ApagarFuncActionPerformed

    private void CancelaCadastroFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelaCadastroFuncActionPerformed
        JFrame TelaInicio = new TelaInicio();
        TelaInicio.setLocationRelativeTo(null);
        TelaInicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelaCadastroFuncActionPerformed

    private void CPFFuncTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CPFFuncTextFieldFocusLost
        String cpf = CPFFuncTextField.getText();
        cpf = desformataCPF(cpf);

        if (!isCPF(cpf) || cpf.length() < 8) {
            //System.out.println("CPF inválido!");
            SalvarFunc.setEnabled(false);
            CPFFuncTextField.setBackground(Color.red);
        } else {
            //System.out.println("CPF válido!");
            SalvarFunc.setEnabled(true);
            CPFFuncTextField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_CPFFuncTextFieldFocusLost

    private void SalvarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarFuncActionPerformed
        String nome = NomeFuncTextField.getText();
        String CPF = CPFFuncTextField.getText();
        String funcao = FunçaoFuncTextField.getText();
        
        try {
            FuncionarioDAO dao = DAOFactory.newFuncionarioDAO();
            if (novo) {
                funcionario = new Funcionario(nome, CPF, funcao);
                //System.out.println(id + " " + nome + " " + CPF);
                dao.criar(funcionario);
                novo = false;
                atualizarTabela();
            } else {
                funcionario.setNome(nome);
                funcionario.setFuncao(funcao);
                dao.editar(funcionario);
            }
        } catch (DuplicateKeyException ex) {
            System.out.println("Chave duplicada!");
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        novoCadFunc();
    }//GEN-LAST:event_SalvarFuncActionPerformed

    private void NomeFuncTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeFuncTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeFuncTextFieldActionPerformed

    public void atualizarTabela() {
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

        ClientesTableModel tableModelClients = (ClientesTableModel) TabelaClientes.getModel();
        CarrosTableModel tableModelCars = (CarrosTableModel) TabelaCarros.getModel();
        FuncionariosTableModel tableModelFuncionarios = (FuncionariosTableModel) TabelaFuncionarios.getModel();

        tableModelClients.setClientes(clientes);
        tableModelCars.setCarros(carros);
        tableModelFuncionarios.setFunc(funcionarios);
        
        TabelaClientes.revalidate();
        TabelaCarros.revalidate();
        TabelaFuncionarios.revalidate();
        
        TabelaClientes.repaint();
        TabelaCarros.repaint();
        TabelaFuncionarios.repaint();
    }

    private void novoCadCliente() {
        NomeTextField.setText("");
        CPFTextField.setText("");
        novo = true;
    }
    
    private void novoCadFunc() {
        NomeFuncTextField.setText("");
        CPFFuncTextField.setText("");
        FunçaoFuncTextField.setText("");
        novo = true;
    }

    private void novoCadCarro() {
        ModeloTextField.setText("");
        AnoTextField.setText("");
        PlacaTextField.setText("");
        novo = true;
    }

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
            java.util.logging.Logger.getLogger(TelaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnoTextField;
    private javax.swing.JButton ApagarCarro;
    private javax.swing.JButton ApagarCliente;
    private javax.swing.JButton ApagarFunc;
    private javax.swing.JFormattedTextField CPFFuncTextField;
    private javax.swing.JFormattedTextField CPFTextField;
    private javax.swing.JPanel CadCarros;
    private javax.swing.JPanel CadClientes;
    private javax.swing.JPanel CadFuncionarios;
    private javax.swing.JButton CancelaCadastroCarro;
    private javax.swing.JButton CancelaCadastroCliente;
    private javax.swing.JButton CancelaCadastroFunc;
    private javax.swing.JComboBox<Cliente> CarroComboBox;
    private javax.swing.JComboBox<Integer> ClienteComboBox;
    private javax.swing.JTextField FunçaoFuncTextField;
    private javax.swing.JTextField ModeloTextField;
    private javax.swing.JTextField NomeFuncTextField;
    private javax.swing.JTextField NomeTextField;
    private javax.swing.JTextField PlacaTextField;
    private javax.swing.JButton SalvarCarro;
    private javax.swing.JButton SalvarCliente;
    private javax.swing.JButton SalvarFunc;
    private javax.swing.JTable TabelaCarros;
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JTable TabelaFuncionarios;
    private javax.swing.JTabbedPane TelaCadastros;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    // End of variables declaration//GEN-END:variables

}
