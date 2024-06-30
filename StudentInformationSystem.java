import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInformationSystem extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameField, ageField, gradeField;
    private JButton addButton, updateButton, deleteButton;

    public StudentInformationSystem() {
        // Set up the frame
        setTitle("Student Information System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table model
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Name", "Age", "Grade"});

        // Table
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input fields
        nameField = new JTextField(15);
        ageField = new JTextField(5);
        gradeField = new JTextField(5);

        // Buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        // Layout
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void addStudent() {
        String name = nameField.getText();
        String age = ageField.getText();
        String grade = gradeField.getText();
        model.addRow(new Object[]{name, age, grade});
        clearFields();
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            model.setValueAt(nameField.getText(), selectedRow, 0);
            model.setValueAt(ageField.getText(), selectedRow, 1);
            model.setValueAt(gradeField.getText(), selectedRow, 2);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "No student selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "No student selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        gradeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentInformationSystem().setVisible(true);
            }
        });
    }
}
