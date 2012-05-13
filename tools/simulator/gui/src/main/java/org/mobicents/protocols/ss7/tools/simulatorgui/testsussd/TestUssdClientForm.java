/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.tools.simulatorgui.testsussd;

import javax.management.Notification;
import javax.swing.JFrame;

import org.mobicents.protocols.ss7.tools.simulator.testsussd.TestUssdClientManMBean;
import org.mobicents.protocols.ss7.tools.simulatorgui.TestingForm;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author sergey vetyutnev
 * 
 */
public class TestUssdClientForm extends TestingForm {

	private static final long serialVersionUID = 5761747864020450945L;

	private JTextField tbMessage;
	private JLabel lbResult;
	private JLabel lbMessage;

	private TestUssdClientManMBean ussdClient; 

	public TestUssdClientForm(JFrame owner) {
		super(owner);
		
		JPanel panel = new JPanel();
		panel_c.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Message text");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		tbMessage = new JTextField();
		GridBagConstraints gbc_tbMessage = new GridBagConstraints();
		gbc_tbMessage.insets = new Insets(0, 0, 5, 0);
		gbc_tbMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbMessage.gridx = 1;
		gbc_tbMessage.gridy = 0;
		panel.add(tbMessage, gbc_tbMessage);
		tbMessage.setColumns(10);
		
		JButton btSendProcessunstructuredrequest = new JButton("Send ProcessUnstructuredRequest");
		btSendProcessunstructuredrequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendProcessUnstructuredRequest();
			}
		});
		GridBagConstraints gbc_btSendProcessunstructuredrequest = new GridBagConstraints();
		gbc_btSendProcessunstructuredrequest.insets = new Insets(0, 0, 5, 0);
		gbc_btSendProcessunstructuredrequest.gridx = 1;
		gbc_btSendProcessunstructuredrequest.gridy = 1;
		panel.add(btSendProcessunstructuredrequest, gbc_btSendProcessunstructuredrequest);
		
		JButton btSendUnstructuredresponse = new JButton("Send UnstructuredResponse");
		btSendUnstructuredresponse.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				sendUnstructuredResponse();
			}
		});
		GridBagConstraints gbc_btSendUnstructuredresponse = new GridBagConstraints();
		gbc_btSendUnstructuredresponse.insets = new Insets(0, 0, 5, 0);
		gbc_btSendUnstructuredresponse.gridx = 1;
		gbc_btSendUnstructuredresponse.gridy = 2;
		panel.add(btSendUnstructuredresponse, gbc_btSendUnstructuredresponse);
		
		JButton btCloseCurrentDialog = new JButton("Close current Dialog");
		btCloseCurrentDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeCurrentDialog();
			}
		});
		GridBagConstraints gbc_btCloseCurrentDialog = new GridBagConstraints();
		gbc_btCloseCurrentDialog.insets = new Insets(0, 0, 5, 0);
		gbc_btCloseCurrentDialog.gridx = 1;
		gbc_btCloseCurrentDialog.gridy = 3;
		panel.add(btCloseCurrentDialog, gbc_btCloseCurrentDialog);
		
		JLabel lblOperationResult = new JLabel("Operation result");
		GridBagConstraints gbc_lblOperationResult = new GridBagConstraints();
		gbc_lblOperationResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblOperationResult.gridx = 0;
		gbc_lblOperationResult.gridy = 4;
		panel.add(lblOperationResult, gbc_lblOperationResult);
		
		lbResult = new JLabel("-");
		GridBagConstraints gbc_lbResult = new GridBagConstraints();
		gbc_lbResult.insets = new Insets(0, 0, 5, 0);
		gbc_lbResult.gridx = 1;
		gbc_lbResult.gridy = 4;
		panel.add(lbResult, gbc_lbResult);
		
		JLabel lblMessageReceived = new JLabel("Message received");
		GridBagConstraints gbc_lblMessageReceived = new GridBagConstraints();
		gbc_lblMessageReceived.insets = new Insets(0, 0, 0, 5);
		gbc_lblMessageReceived.gridx = 0;
		gbc_lblMessageReceived.gridy = 5;
		panel.add(lblMessageReceived, gbc_lblMessageReceived);
		
		lbMessage = new JLabel("-");
		GridBagConstraints gbc_lbMessage = new GridBagConstraints();
		gbc_lbMessage.gridx = 1;
		gbc_lbMessage.gridy = 5;
		panel.add(lbMessage, gbc_lbMessage);
	}

	public void setData(TestUssdClientManMBean ussdClient) {
		this.ussdClient = ussdClient;
	}

	private void sendProcessUnstructuredRequest() {
		this.lbMessage.setText("");
		String msg = this.tbMessage.getText();
		String res = this.ussdClient.performProcessUnstructuredRequest(msg);
		this.lbResult.setText(res);
	}

	private void sendUnstructuredResponse() {
		this.lbMessage.setText("");
		String msg = this.tbMessage.getText();
		String res = this.ussdClient.performUnstructuredResponse(msg);
		this.lbResult.setText(res);
	}

	private void closeCurrentDialog() {
		this.lbMessage.setText("");
		String res = this.ussdClient.closeCurrentDialog();
		this.lbResult.setText(res);
	}

	@Override
	public void sendNotif(Notification notif) {
		super.sendNotif(notif);

		if (notif.getMessage().startsWith("Rsvd: procUnstrSsResp: ")) {
			String s1 = notif.getMessage().substring(6);
			this.lbMessage.setText(s1);
		}

		if (notif.getMessage().startsWith("Rsvd: unstrSsReq: ")) {
			String s1 = notif.getMessage().substring(6);
			this.lbMessage.setText(s1);
		}
	}
}

