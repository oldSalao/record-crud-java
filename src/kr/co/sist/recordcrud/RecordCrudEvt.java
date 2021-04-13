package kr.co.sist.recordcrud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RecordCrudEvt extends WindowAdapter implements ActionListener, ListSelectionListener {

	private RecordCrudView rcv;

	public RecordCrudEvt(RecordCrudView rcv) {
		this.rcv = rcv;
	}

	public void setJList() {
		RecordCrudDAO rcDAO = RecordCrudDAO.getInstance();
		List<StudentVO> list = new ArrayList<StudentVO>();
		rcv.getDlm().clear();
		try {
			list = rcDAO.selectAllStud();
			for (int i = 0; i < list.size(); i++) {
				rcv.getDlm().addElement(list.get(i).toString());
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(rcv, "실행중 문제가 발생했습니다.");
		}
	}
	
	public void clearJtf() {
		rcv.getJtfNum().setText("");
		rcv.getJtfName().setText("");
		rcv.getJtfAge().setText("");
		rcv.getJtfAddress().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == rcv.getJbtnCreate()) {
			String name = rcv.getJtfName().getText();
			String age = rcv.getJtfAge().getText();
			String address = rcv.getJtfAddress().getText();
			if (name.equals("") || age.equals("") || address.equals("")) {
				JOptionPane.showMessageDialog(rcv, "빈칸이 있습니다.");
			} else {
				RecordCrudDAO rcDAO = RecordCrudDAO.getInstance();
				try {
					rcDAO.insertRecord(name, Integer.parseInt(age), address);
					setJList();
					clearJtf();
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(rcv, "실행중 문제가 발생했습니다.");
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(rcv, "나이는 숫자만 입력해주세요.");
				}
			}
		}
		if (ae.getSource() == rcv.getJbtnDelete()) {
			RecordCrudDAO rcDAO = RecordCrudDAO.getInstance();
			try {
				int num = Integer.parseInt(rcv.getJtfNum().getText());
				rcDAO.deleteRecord(num);
				setJList();
				clearJtf();
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(rcv, "행을 먼저 선택해주세요.");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(rcv, "실행중 문제가 발생했습니다.");
			}
		}
		if (ae.getSource() == rcv.getJbtnUpdate()) {
		}
		if (ae.getSource() == rcv.getJbtnClose()) {
			rcv.dispose();
		}

	}

	@Override
	public void windowClosing(WindowEvent e) {
		rcv.dispose();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			RecordCrudDAO rcDAO = RecordCrudDAO.getInstance();
			List<StudentVO> list = rcDAO.getStudList();
			String record = rcv.getJlRecord().getSelectedValue();
			String num = record.substring(record.indexOf(":") + 2, record.indexOf(","));
			StudentVO studVO = null;

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNum() == Integer.parseInt(num)) {
					studVO = list.get(i);
				}
			}

			rcv.getJtfNum().setText(studVO.getNum() + "");
			rcv.getJtfName().setText(studVO.getName());
			rcv.getJtfAge().setText(studVO.getAge() + "");
			rcv.getJtfAddress().setText(studVO.getAddress());
		}
	}

}
