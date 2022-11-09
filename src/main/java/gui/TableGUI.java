package gui;

import javax.swing.JTable;

import domain.Registered;
import domain.RegisteredModelAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
public class TableGUI extends JFrame {
   private RegisteredModelAdapter tableModel;
   private JTable table;
   private Registered myList;
   public TableGUI(Registered user) {
      super(user.getUsername());
      setBounds(10,10,1000,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myList = user;
      tableModel = new RegisteredModelAdapter(myList);
      table = new JTable(tableModel);
      //table.setAutoCreateRowSorter(true);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setPreferredSize(new Dimension(600,280));
      JPanel panel = new JPanel();
      panel.add(scrollPane);
      add(panel,BorderLayout.CENTER);
   }
}