package org.example.View;

import org.example.Model.Currency;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel Panel;
    private JLabel label;
    private JButton boton;
    private JTextField text;
    private JTextField text0;
    private JComboBox<String> lista;
    private JComboBox<String> lista0;

    public JTextField getText() {
        return text;
    }

    public JTextField getText0() {
        return text0;
    }

    public JComboBox<String> getLista() {
        return lista;
    }

    public JComboBox<String> getLista0() {
        return lista0;
    }

    public JButton getBoton() {
        return boton;
    }

    public View(String[] listas, Currency[] lista) {
        initialize();
        initializeComponents(listas, lista);
        pack();
    }

    private void initialize() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(650, 400));
        setTitle("MoneyCalculator");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents(String[] listas, Currency[] lista) {
        initializePanel();
        initializeButtons();
        initializeTextFields();
        updatePanel();
        initializeComboBoxes(listas);
        initializeLabel();
        updatePanel();
    }

    private void initializePanel() {
        Panel = new JPanel();
        Panel.setLayout(null);
        this.getContentPane().add(Panel);
    }

    private void initializeButtons() {
        boton = new JButton();
        boton.setText("Convert");
        boton.setBounds(250, 150, 100, 25);
        boton.setEnabled(true);
        Panel.add(boton);
    }

    private void initializeTextFields() {
        text = new JTextField();
        text0 = new JTextField();

        text.setBounds(10, 150, 125, 25);
        text.setText("Introduce amount");
        text.setEditable(true);

        text0.setBounds(375, 150, 125, 25);
        text0.setEditable(false);

        Panel.add(text);
        Panel.add(text0);
    }

    private void initializeComboBoxes(String[] listas) {
        lista = new JComboBox<>(listas);
        lista0 = new JComboBox<>(listas);

        lista.setBounds(150, 150, 75, 25);
        lista0.setBounds(520, 150, 75, 25);

        Panel.add(lista);
        Panel.add(lista0);
    }

    private void updatePanel() {
        Panel.revalidate();
        Panel.repaint();
    }

    private void initializeLabel() {
        this.label = new JLabel("Money Calculator");
        label.setBounds(230, 50, 200, 25);
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        Panel.add(label);
    }
}
