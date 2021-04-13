package kr.co.sist.recordcrud;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RecordCrudView extends JFrame {

	private JButton jbtnCreate;
	private JButton jbtnDelete;
	private JButton jbtnUpdate;
	private JButton jbtnClose;
	private JTextField jtfNum;
	private JTextField jtfName;
	private JTextField jtfAge;
	private JTextField jtfAddress;
	private JList<String> jlRecord;
	private DefaultListModel<String> dlm;

	public RecordCrudView() {
		super("���̺� ������");
		setSize(600, 350);
		setLocationRelativeTo(null);
		JPanel jpMain = new JPanel(new GridLayout(1, 2));
		JPanel jpL = new JPanel(new GridLayout(4, 1));
		JPanel jpFootBtn = new JPanel();
		JPanel jpFoot = new JPanel(new GridLayout(2, 1));
		JPanel[] jplArr = new JPanel[4];
		JScrollPane jspList = null;

		for (int i = 0; i < jplArr.length; i++) {
			jplArr[i] = new JPanel(new FlowLayout());
		}

		JLabel jlbNum = new JLabel("��ȣ : ");
		JLabel jlbName = new JLabel("�̸� : ");
		JLabel jlbAge = new JLabel("���� : ");
		JLabel jlbAddress = new JLabel("�ּ� : ");
		jtfNum = new JTextField();
		jtfNum.setEditable(false);
		jtfName = new JTextField();
		jtfAge = new JTextField();
		jtfAddress = new JTextField();
		jtfNum.setColumns(5);
		jtfName.setColumns(5);
		jtfAge.setColumns(5);
		jtfAddress.setColumns(5);
		dlm = new DefaultListModel<String>();
		jlRecord = new JList<String>(dlm);
		jbtnCreate = new JButton("�߰�");
		jbtnDelete = new JButton("����");
		jbtnUpdate = new JButton("����");
		jbtnClose = new JButton("�ݱ�");
		jspList = new JScrollPane(jlRecord);

		jplArr[0].add(jlbNum);
		jplArr[0].add(jtfNum);
		jplArr[1].add(jlbName);
		jplArr[1].add(jtfName);
		jplArr[2].add(jlbAge);
		jplArr[2].add(jtfAge);
		jplArr[3].add(jlbAddress);
		jplArr[3].add(jtfAddress);

		for (int i = 0; i < jplArr.length; i++) {
			jpL.add(jplArr[i]);
		}
		jpMain.add(jpL);
		jpMain.add(jspList);
		jpFootBtn.add(jbtnCreate);
		jpFootBtn.add(jbtnDelete);
		jpFootBtn.add(jbtnUpdate);
		jpFootBtn.add(jbtnClose);
		jpFoot.add(Box.createVerticalStrut(20));
		jpFoot.add(jpFootBtn);

		RecordCrudEvt rce = new RecordCrudEvt(this);
		jbtnCreate.addActionListener(rce);
		jbtnDelete.addActionListener(rce);
		jbtnUpdate.addActionListener(rce);
		jbtnClose.addActionListener(rce);
		jlRecord.addListSelectionListener(rce);
		addWindowListener(rce);

		this.add(jpMain);
		this.add(jpFoot, "South");
		this.add(Box.createVerticalStrut(30), "North");
		this.add(Box.createHorizontalStrut(10), "East");
		this.add(Box.createHorizontalStrut(10), "West");
		
		rce.setJList();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JButton getJbtnCreate() {
		return jbtnCreate;
	}

	public JButton getJbtnDelete() {
		return jbtnDelete;
	}

	public JButton getJbtnUpdate() {
		return jbtnUpdate;
	}

	public JButton getJbtnClose() {
		return jbtnClose;
	}

	public JTextField getJtfNum() {
		return jtfNum;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAge() {
		return jtfAge;
	}

	public JTextField getJtfAddress() {
		return jtfAddress;
	}

	public JList<String> getJlRecord() {
		return jlRecord;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

}
