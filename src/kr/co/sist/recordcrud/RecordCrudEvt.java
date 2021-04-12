package kr.co.sist.recordcrud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RecordCrudEvt implements ActionListener, ListSelectionListener {

	private RecordCrudView rcv;

	public RecordCrudEvt(RecordCrudView rcv) {
		this.rcv = rcv;
		RecordCrudDAO rcDAO = RecordCrudDAO.getInstance();
		try {
			rcv.getDlm().addAll(rcDAO.getRecord());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
					rcv.getDlm().clear();
					rcv.getDlm().addAll(rcDAO.getRecord());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(rcv, "동작중 문제가 발생했습니다.");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(rcv, "나이는 숫자만 입력해주세요.");
				}
			}
		}
		if (ae.getSource() == rcv.getJbtnDelete()) {

		}
		if (ae.getSource() == rcv.getJbtnUpdate()) {
		}
		if (ae.getSource() == rcv.getJbtnClose()) {
			rcv.dispose();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			String[] recordArr = rcv.getJlRecord().getSelectedValue().split(",");
			rcv.getJtfNum().setText(recordArr[0]);
			rcv.getJtfName().setText(recordArr[1]);
			rcv.getJtfAge().setText(recordArr[2]);
			rcv.getJtfAddress().setText(recordArr[3]);
		}
	}
}
