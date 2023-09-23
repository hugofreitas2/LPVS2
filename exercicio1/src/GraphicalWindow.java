import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GraphicalWindow extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JLabel lblName;
    private JLabel lblSalary;
    private JLabel lblWorkTime;
    private JTextField txtName;
    private JTextField txtSalary;
    private JRadioButton radioOneYear;
    private JRadioButton radioTwoFiveYears;
    private JRadioButton radioFiveYearsMore;
    private ButtonGroup group;
    private JButton btnNewEmployee;
    private JButton btnInsertData;
    private JButton btnPrintData;

    public GraphicalWindow(){
        createComponents();
        addComponents();
        configureWindow();
    }

    private void createComponents(){
        panel = new JPanel();
        lblName = new JLabel("Nome:");
        lblSalary = new JLabel("Salario: ");
        lblWorkTime = new JLabel("Tempo de Trabalho: ");
        txtName = new JTextField(20);
        txtSalary = new JTextField(10);
        radioOneYear = new JRadioButton("Um ano de serviço");
        radioOneYear.setSelected(true);
        radioTwoFiveYears = new JRadioButton("Dois a Cinco anos de serviço");
        radioFiveYearsMore = new JRadioButton("Cinco anos ou mais de serviço");
        group = new ButtonGroup();
        group.add(radioOneYear);
        group.add(radioTwoFiveYears);
        group.add(radioFiveYearsMore);
        btnNewEmployee = new JButton("Novo Funcionário");
        btnNewEmployee.addActionListener(this);
        btnInsertData = new JButton("Inserir Dados");
        btnInsertData.addActionListener(this);
        btnInsertData.setEnabled(false);
        btnPrintData = new JButton("Mostrar Dados");
        btnPrintData.addActionListener(this);
        btnPrintData.setEnabled(false);
    }

    private void addComponents(){
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblSalary);
        panel.add(txtSalary);
        panel.add(lblWorkTime);
        panel.add(radioOneYear);
        panel.add(radioTwoFiveYears);
        panel.add(radioFiveYearsMore);
        panel.add(btnNewEmployee);
        panel.add(btnInsertData);
        panel.add(btnPrintData);
        add(panel);
    }

    private void configureWindow(){
        setTitle("Cadastro de Funcionários");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == btnNewEmployee){
            btnNewEmployee.setEnabled(false);
            btnInsertData.setEnabled(true);
            btnPrintData.setEnabled(false);
            txtName.setText("");
            txtSalary.setText("");
            radioOneYear.setSelected(true);
            radioTwoFiveYears.setSelected(false);
            radioFiveYearsMore.setSelected(false);
        }else if(event.getSource() == btnInsertData){
            btnNewEmployee.setEnabled(false);
            btnInsertData.setEnabled(false);
            btnPrintData.setEnabled(true);
        }else{
            btnNewEmployee.setEnabled(true);
            btnInsertData.setEnabled(false);
            btnPrintData.setEnabled(false);
            String name = txtName.getText();
            double salary = Double.parseDouble(txtSalary.getText().replace(",", "."));
            if(radioOneYear.isSelected()){
                salary = salary + (salary * 0.025);
            }else if(radioTwoFiveYears.isSelected()){
                salary = salary + (salary * 0.05);
            }else{
                salary = salary + (salary * 0.075);
            }
            Employee employee = new Employee(name, salary);
            JOptionPane.showMessageDialog(null, employee);
            }
        }
    }
    



