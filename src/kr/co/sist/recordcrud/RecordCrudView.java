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
		super("테이블 관리기");
		setSize(600, 350);
		setLocationRelativeTo(null);
		JPanel jpMain = new JPanel(new GridLayout(1, 2));
		JPanel jpL = new JPanel(new GridLayout(4, 1));
		JPanel jpFootBtn = new JPanel();
		JPanel jpFoot = new JPanel(new GridLayout(2, 1));
		JPanel[] jplArr = new JPanel[4];
		JScrollPane jspList = new JScrollPane();

		for (int i = 0; i < jplArr.length; i++) {
			jplArr[i] = new JPanel(new FlowLayout());
		}

		JLabel jlbNum = new JLabel("번호 : ");
		JLabel jlbName = new JLabel("이름 : ");
		JLabel jlbAge = new JLabel("나이 : ");
		JLabel jlbAddress = new JLabel("주소 : ");
		jtfNum = new JTextField();
		jtfName = new JTextField();
		jtfAge = new JTextField();
		jtfAddress = new JTextField();
		jtfNum.setColumns(5);
		jtfName.setColumns(5);
		jtfAge.setColumns(5);
		jtfAddress.setColumns(5);
		dlm = new DefaultListModel<String>();
		jlRecord = new JList<String>(dlm);
		jbtnCreate = new JButton("추가");
		jbtnDelete = new JButton("삭제");
		jbtnUpdate = new JButton("변경");
		jbtnClose = new JButton("닫기");

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
		jspList.add(jlRecord);
		jpMain.add(jspList);
		jpFootBtn.add(jbtnCreate);
		jpFootBtn.add(jbtnDelete);
		jpFootBtn.add(jbtnUpdate);
		jpFootBtn.add(jbtnClose);
		jpFoot.add(Box.createVerticalStrut(20));
		jpFoot.add(jpFootBtn);

		this.add(jpMain);
		this.add(jpFoot, "South");
		this.add(Box.createVerticalStrut(30), "North");
		this.add(Box.createHorizontalStrut(10), "East");
		this.add(Box.createHorizontalStrut(10), "West");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JButton getJbtnCreate() {
		return jbtnCreate;
	}

	public void setJbtnCreate(JButton jbtnCreate) {
		this.jbtnCreate = jbtnCreate;
	}

	public JButton getJbtnDelete() {
		return jbtnDelete;
	}

	public void setJbtnDelete(JButton jbtnDelete) {
		this.jbtnDelete = jbtnDelete;
	}

	public JButton getJbtnUpdate() {
		return jbtnUpdate;
	}

	public void setJbtnUpdate(JButton jbtnUpdate) {
		this.jbtnUpdate = jbtnUpdate;
	}

	public JButton getJbtnClose() {
		return jbtnClose;
	}

	public void setJbtnClose(JButton jbtnClose) {
		this.jbtnClose = jbtnClose;
	}

	public JTextField getJtfNum() {
		return jtfNum;
	}

	public void setJtfNum(JTextField jtfNum) {
		this.jtfNum = jtfNum;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public void setJtfName(JTextField jtfName) {
		this.jtfName = jtfName;
	}

	public JTextField getJtfAge() {
		return jtfAge;
	}

	public void setJtfAge(JTextField jtfAge) {
		this.jtfAge = jtfAge;
	}

	public JTextField getJtfAddress() {
		return jtfAddress;
	}

	public void setJtfAddress(JTextField jtfAddress) {
		this.jtfAddress = jtfAddress;
	}

	public JList<String> getJlRecord() {
		return jlRecord;
	}

	public void setJlRecord(JList<String> jlRecord) {
		this.jlRecord = jlRecord;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}
	
}
