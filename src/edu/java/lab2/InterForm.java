package edu.java.lab2;
/** 
 * @author ������*/

//����������� ����������� ���������
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.lang.Math;;

public class InterForm {
	//������ ����������
	/** 
	 * ����� ����������, ������������ 
	 * ��� ���������� ����� �� �����
	 * ��� ���������� ������
	 * */
	private class NotEnoughDiskSpace extends Exception
	{
		public NotEnoughDiskSpace()
		{
			super("������������ ����� �� ����� ��� �������� ������.");
		};
	};
	
	/**
	 * ����� ����������, ������������,
	 * ����� ��� �������� ���������� ������
	 * �� ������ ����� ��������������� ������.  
	 * */
	private class NotFound extends Exception
	{
		public NotFound()
		{
			super("�� ������� ������ �� �������� ����������.");
		};
	};	
	
	//���������� ����������� �����������
	private JFrame InterForm;
	private DefaultTableModel Model;
	private JButton New;
	private JButton Edit;
	private JButton Delete;
	private JToolBar ToolBar;
	private JScrollPane Scroll;
	private JTable Groups;
	private JComboBox Year;
	private JTextField GroupName;
	private JButton Filter;
	
	private void CheckDiskSpace() throws NotEnoughDiskSpace
	{
		if(Math.random() < 0.5)
			throw new NotEnoughDiskSpace();
	};
	
	private void FindByParams() throws NotFound
	{
		if(Math.random() >= 0.5)
			throw new NotFound();
	};
	
	//����� �������� ����
	public void Show()
	{
		InterForm = new JFrame("�������� ����������� �����");
		InterForm.setSize(500, 300);
		InterForm.setLocation(100, 100);
		InterForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�������� ������ � ������������ ������
		New = new JButton(new ImageIcon("./img/new.png"));
		Edit = new JButton(new ImageIcon("./img/edit.png"));
		Delete = new JButton(new ImageIcon("./img/delete.png"));
		
		//��������� ��������� ��� ������
		New.setToolTipText("����� ������");
		Edit.setToolTipText("������������� ������");
		Delete.setToolTipText("������� ������");
		
		//���������� ������ �� ������ ������������
		ToolBar = new JToolBar("������ ������������");
		ToolBar.add(New);
		ToolBar.add(Edit);
		ToolBar.add(Delete);
		
		//���������� ������ ������������
		InterForm.setLayout(new BorderLayout());
		InterForm.add(ToolBar, BorderLayout.NORTH);
		
		//�������� ������� � �������
		String[] Columns = {"������", "��� ���������", "��������� � ���-������"};
		String[][] Data = {{"Paul Van Dyk", "1994", "105"}, {"ATB", "1998", "54"}};
		Model = new DefaultTableModel(Data, Columns);
		Groups = new JTable(Model);
		Scroll = new JScrollPane(Groups);		
		
		//���������� ������� � �������
		InterForm.add(Scroll, BorderLayout.CENTER);
		
		//���������� ����������� ������
		Year = new JComboBox(new String[] {"���", "1994", "1998"});		
		GroupName = new JTextField("�������� ������");
		Filter = new JButton("�����");
		
		//���������� ����������� �� ������
		JPanel FilterPanel = new JPanel();
		FilterPanel.add(GroupName);
		FilterPanel.add(Year);
		FilterPanel.add(Filter);		
		
		//���������� ������ ������ ����� ����
		InterForm.add(FilterPanel, BorderLayout.SOUTH);
		
		//������������ �������� �����
		InterForm.setVisible(true);
		
		//���������� ����������
		New.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**����� ��������� � ����� �� ������� ������ "����� ������". */
				try
				{
					CheckDiskSpace();
				}
				catch(NotEnoughDiskSpace ex)
				{
					JOptionPane.showMessageDialog(InterForm, "������������ ����� �� ����� ��� �������� ����� ������.");
				};
				JOptionPane.showMessageDialog(InterForm, "�������� ������� �� ������ \"����� ������\".");
			}});
		
		Filter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**����� ��������� � ����� �� ������� ������ "�����". */
				try
				{
					FindByParams();
				}
				catch(NotFound ex)
				{
					JOptionPane.showMessageDialog(InterForm, "�� ������� ������ � ��������� ����������� ������.");
				};
				JOptionPane.showMessageDialog(InterForm, "�������� ������� �� ������ \"�����\".");
			}});
		
		Year.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**����� ��������� � ����� �� ����� ������ � ������ "���". */
				JOptionPane.showMessageDialog(InterForm, "�������� ������ ������ ��������������� ������ \"���\".");
			}});
	};	
	
	public static void main(String[] args)
	{
		//�������� � ����������� �������� �����
		new InterForm().Show();
	};
};
