package org.mobicents.protocols.ss7.tools.simulatorgui.tests.attack.location;

import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.smstpdu.NumberingPlanIdentification;
import org.mobicents.protocols.ss7.map.api.smstpdu.TypeOfNumber;
import org.mobicents.protocols.ss7.tools.simulator.common.AddressNatureType;
import org.mobicents.protocols.ss7.tools.simulator.level3.MapProtocolVersion;
import org.mobicents.protocols.ss7.tools.simulator.level3.NumberingPlanMapType;
import org.mobicents.protocols.ss7.tools.simulator.tests.attack.location.TestSRIForSMManMBean;
import org.mobicents.protocols.ss7.tools.simulator.tests.sms.*;
import org.mobicents.protocols.ss7.tools.simulatorgui.M3uaForm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kristoffer Jensen
 */
public class TestSRIForSMParamForm extends JDialog {
    private static final long serialVersionUID = 5428271328162943202L;

    private TestSRIForSMManMBean sriForSM;

    private JTextField tbServiceCenterAddress;
    private JTextField tbSmscSsn;
    private JComboBox cbAddressNature;
    private JComboBox cbNumberingPlan;
    private JComboBox cbMapProtocolVersion;
    private JComboBox cbTypeOfNumber;
    private JComboBox cbNumberingPlanIdentification;
    private JComboBox cbSmsCodingType;
    private JTextField tbSRIResponseImsi;
    private JTextField tbSRIResponseVlr;
    private JComboBox cbSRIReaction;
    private JComboBox cbSRIInformServiceCenter;
    private JCheckBox cbSRIScAddressNotIncluded;
    private JComboBox cbMtFSMReaction;
    private JCheckBox cbOneNotificationFor100Dialogs;
    private JCheckBox cbReturn20PersDeliveryErrors;
    private JCheckBox cbContinueDialog;
    private JComboBox cbRsmdsReaction;
    private JTextField tbNationalLanguageCode;

    public TestSRIForSMParamForm(JFrame owner) {
        super(owner, true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("SMS test client settings");
        setBounds(100, 100, 640, 584);
        getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 634, 465);
        getContentPane().add(tabbedPane);

        JPanel panel_gen = new JPanel();
        tabbedPane.addTab("General", null, panel_gen, null);
        panel_gen.setLayout(null);

        JLabel label = new JLabel("MAP protocol version");
        label.setBounds(10, 14, 204, 14);
        panel_gen.add(label);

        cbMapProtocolVersion = new JComboBox();
        cbMapProtocolVersion.setBounds(266, 11, 255, 20);
        panel_gen.add(cbMapProtocolVersion);

        JLabel lblSmscSsnFor = new JLabel("SMSC SSN for outgoing SccpAddress (default value: 8)");
        lblSmscSsnFor.setBounds(10, 44, 415, 14);
        panel_gen.add(lblSmscSsnFor);

        tbSmscSsn = new JTextField();
        tbSmscSsn.setColumns(10);
        tbSmscSsn.setBounds(435, 41, 86, 20);
        panel_gen.add(tbSmscSsn);

        cbOneNotificationFor100Dialogs = new JCheckBox("One notification for 100 dialogs (recommended for bulk message mode)");
        cbOneNotificationFor100Dialogs.setBounds(10, 67, 511, 23);
        panel_gen.add(cbOneNotificationFor100Dialogs);

        cbReturn20PersDeliveryErrors = new JCheckBox("Return 20% delivery errors for SRI or MtForwardSM Requests");
        cbReturn20PersDeliveryErrors.setBounds(10, 95, 511, 23);
        panel_gen.add(cbReturn20PersDeliveryErrors);

        JPanel panel_sri = new JPanel();
        tabbedPane.addTab("SRI response", panel_sri);
        panel_sri.setLayout(null);

        JLabel label_7 = new JLabel("IMSI for auto sendRoutingInfoForSM response");
        label_7.setBounds(10, 8, 361, 14);
        panel_sri.add(label_7);

        tbSRIResponseImsi = new JTextField();
        tbSRIResponseImsi.setBounds(482, 5, 137, 20);
        tbSRIResponseImsi.setColumns(10);
        panel_sri.add(tbSRIResponseImsi);

        tbSRIResponseVlr = new JTextField();
        tbSRIResponseVlr.setBounds(482, 36, 137, 20);
        tbSRIResponseVlr.setColumns(10);
        panel_sri.add(tbSRIResponseVlr);

        JLabel label_8 = new JLabel("VLR address for auto sendRoutingInfoForSM response");
        label_8.setBounds(10, 39, 361, 14);
        panel_sri.add(label_8);

        JLabel lblReactionForSri = new JLabel("Reaction for SRI request");
        lblReactionForSri.setBounds(10, 70, 290, 14);
        panel_sri.add(lblReactionForSri);

        JLabel lblSriinformservicecenter = new JLabel("Sending InformServiceCenter for SRI request");
        lblSriinformservicecenter.setBounds(10, 101, 290, 14);
        panel_sri.add(lblSriinformservicecenter);

        cbSRIReaction = new JComboBox();
        cbSRIReaction.setBounds(310, 67, 309, 20);
        panel_sri.add(cbSRIReaction);

        cbSRIInformServiceCenter = new JComboBox();
        cbSRIInformServiceCenter.setBounds(310, 98, 309, 20);
        panel_sri.add(cbSRIInformServiceCenter);

        cbSRIScAddressNotIncluded = new JCheckBox("InformServiceCentre: ServiceCenter Address is not included in MWD");
        cbSRIScAddressNotIncluded.setBounds(10, 128, 457, 23);
        panel_sri.add(cbSRIScAddressNotIncluded);

        JPanel panel_mtfsm = new JPanel();
        tabbedPane.addTab("MtFSM response", null, panel_mtfsm, null);
        panel_mtfsm.setLayout(null);

        JLabel lblReactionForMtfsm = new JLabel("Reaction for MtFSM request");
        lblReactionForMtfsm.setBounds(12, 16, 290, 14);
        panel_mtfsm.add(lblReactionForMtfsm);

        cbMtFSMReaction = new JComboBox();
        cbMtFSMReaction.setBounds(312, 13, 309, 20);
        panel_mtfsm.add(cbMtFSMReaction);
        cbContinueDialog = new JCheckBox("Continue dialog after MtForwardSM receiving (MtForwardSM resnonse in TC-CONTINUE)");
        cbContinueDialog.setBounds(12, 39, 609, 23);
        panel_mtfsm.add(cbContinueDialog);

        JPanel panel_mofsm = new JPanel();
        tabbedPane.addTab("MoFSM request", null, panel_mofsm, null);
        panel_mofsm.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(12, 13, 511, 94);
        panel_mofsm.add(panel_2);
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setLayout(null);

        JLabel lblParametersForSms = new JLabel("Parameters for SMS tpdu destAddress");
        lblParametersForSms.setBounds(10, 0, 266, 14);
        panel_2.add(lblParametersForSms);

        JLabel label_5 = new JLabel("TypeOfNumber");
        label_5.setBounds(10, 28, 174, 14);
        panel_2.add(label_5);

        JLabel label_6 = new JLabel("NumberingPlanIdentification");
        label_6.setBounds(10, 59, 174, 14);
        panel_2.add(label_6);

        cbTypeOfNumber = new JComboBox();
        cbTypeOfNumber.setBounds(194, 25, 307, 20);
        panel_2.add(cbTypeOfNumber);

        cbNumberingPlanIdentification = new JComboBox();
        cbNumberingPlanIdentification.setBounds(194, 56, 307, 20);
        panel_2.add(cbNumberingPlanIdentification);

        JLabel label_4 = new JLabel("Character set for SMS encoding");
        label_4.setBounds(12, 121, 194, 14);
        panel_mofsm.add(label_4);

        cbSmsCodingType = new JComboBox();
        cbSmsCodingType.setBounds(216, 118, 307, 20);
        panel_mofsm.add(cbSmsCodingType);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(12, 151, 511, 94);
        panel_mofsm.add(panel_1);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setLayout(null);

        JLabel label_1 = new JLabel("Parameters for AddressString creation");
        label_1.setBounds(10, 0, 266, 14);
        panel_1.add(label_1);

        JLabel label_2 = new JLabel("AddressNature");
        label_2.setBounds(10, 28, 174, 14);
        panel_1.add(label_2);

        JLabel label_3 = new JLabel("NumberingPlan");
        label_3.setBounds(10, 59, 174, 14);
        panel_1.add(label_3);

        cbAddressNature = new JComboBox();
        cbAddressNature.setBounds(194, 25, 307, 20);
        panel_1.add(cbAddressNature);

        cbNumberingPlan = new JComboBox();
        cbNumberingPlan.setBounds(194, 56, 307, 20);
        panel_1.add(cbNumberingPlan);

        JLabel lblDestinationServiceCenter = new JLabel("Destination Service center address string");
        lblDestinationServiceCenter.setBounds(12, 259, 339, 14);
        panel_mofsm.add(lblDestinationServiceCenter);

        tbServiceCenterAddress = new JTextField();
        tbServiceCenterAddress.setBounds(369, 256, 154, 20);
        panel_mofsm.add(tbServiceCenterAddress);
        tbServiceCenterAddress.setColumns(10);

        JLabel lblNationalLanguageShift = new JLabel("National language shift table code (for GSM7 encoding)");
        lblNationalLanguageShift.setBounds(12, 287, 339, 14);
        panel_mofsm.add(lblNationalLanguageShift);

        tbNationalLanguageCode = new JTextField();
        tbNationalLanguageCode.setColumns(10);
        tbNationalLanguageCode.setBounds(369, 284, 75, 20);
        panel_mofsm.add(tbNationalLanguageCode);

        JPanel panel_ReportSMDeliveryStatus = new JPanel();
        tabbedPane.addTab("ReportSMDeliveryStatus response", null, panel_ReportSMDeliveryStatus, null);
        panel_ReportSMDeliveryStatus.setLayout(null);

        JLabel lblReactionForReportsmdeliverystatus = new JLabel("Reaction for ReportSMDeliveryStatus request");
        lblReactionForReportsmdeliverystatus.setBounds(10, 28, 271, 14);
        panel_ReportSMDeliveryStatus.add(lblReactionForReportsmdeliverystatus);

        cbRsmdsReaction = new JComboBox();
        cbRsmdsReaction.setBounds(291, 25, 328, 20);
        panel_ReportSMDeliveryStatus.add(cbRsmdsReaction);

        JButton button = new JButton("Load default values for side A");
        button.setBounds(10, 476, 246, 23);
        getContentPane().add(button);

        JButton button_3 = new JButton("Load default values for side B");
        button_3.setBounds(266, 476, 255, 23);
        getContentPane().add(button_3);

        JButton button_4 = new JButton("Cancel");
        button_4.setBounds(404, 510, 117, 23);
        getContentPane().add(button_4);

        JButton button_2 = new JButton("Save");
        button_2.setBounds(180, 510, 117, 23);
        getContentPane().add(button_2);

        JButton button_1 = new JButton("Reload");
        button_1.setBounds(10, 510, 144, 23);
        getContentPane().add(button_1);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reloadData();
            }
        });
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (saveData()) {
                    getJFrame().dispose();
                }
            }
        });
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getJFrame().dispose();
            }
        });
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDataB();
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDataA();
            }
        });
    }

    public void setData(TestSRIForSMManMBean smsClient) {
        this.sriForSM = smsClient;

        this.reloadData();
    }

    private JDialog getJFrame() {
        return this;
    }

    private void reloadData() {
        M3uaForm.setEnumeratedBaseComboBox(cbAddressNature, this.sriForSM.getAddressNature());
        M3uaForm.setEnumeratedBaseComboBox(cbNumberingPlan, this.sriForSM.getNumberingPlan());
        M3uaForm.setEnumeratedBaseComboBox(cbMapProtocolVersion, this.sriForSM.getMapProtocolVersion());
        M3uaForm.setEnumeratedBaseComboBox(cbTypeOfNumber, this.sriForSM.getTypeOfNumber());
        M3uaForm.setEnumeratedBaseComboBox(cbNumberingPlanIdentification, this.sriForSM.getNumberingPlanIdentification());
        M3uaForm.setEnumeratedBaseComboBox(cbSmsCodingType, this.sriForSM.getSmsCodingType());

        M3uaForm.setEnumeratedBaseComboBox(cbSRIReaction, this.sriForSM.getSRIReaction());
        M3uaForm.setEnumeratedBaseComboBox(cbSRIInformServiceCenter, this.sriForSM.getSRIInformServiceCenter());
        M3uaForm.setEnumeratedBaseComboBox(cbMtFSMReaction, this.sriForSM.getMtFSMReaction());
        M3uaForm.setEnumeratedBaseComboBox(cbRsmdsReaction, this.sriForSM.getReportSMDeliveryStatusReaction());

        tbServiceCenterAddress.setText(this.sriForSM.getServiceCenterAddress());
        tbSRIResponseImsi.setText(this.sriForSM.getSRIResponseImsi());
        tbSRIResponseVlr.setText(this.sriForSM.getSRIResponseVlr());

        tbSmscSsn.setText(((Integer) this.sriForSM.getSmscSsn()).toString());
        tbNationalLanguageCode.setText(((Integer) this.sriForSM.getNationalLanguageCode()).toString());

        cbSRIScAddressNotIncluded.setSelected(this.sriForSM.isSRIScAddressNotIncluded());
        cbOneNotificationFor100Dialogs.setSelected(this.sriForSM.isOneNotificationFor100Dialogs());
        cbReturn20PersDeliveryErrors.setSelected(this.sriForSM.isReturn20PersDeliveryErrors());
        cbContinueDialog.setSelected(this.sriForSM.isContinueDialog());
    }

    private void loadDataA() {
        M3uaForm.setEnumeratedBaseComboBox(cbAddressNature,
                new AddressNatureType(AddressNature.international_number.getIndicator()));
        M3uaForm.setEnumeratedBaseComboBox(cbNumberingPlan, new NumberingPlanMapType(NumberingPlan.ISDN.getIndicator()));
        M3uaForm.setEnumeratedBaseComboBox(cbMapProtocolVersion, new MapProtocolVersion(MapProtocolVersion.VAL_MAP_V3));
        M3uaForm.setEnumeratedBaseComboBox(cbTypeOfNumber, new TypeOfNumberType(TypeOfNumber.InternationalNumber.getCode()));
        M3uaForm.setEnumeratedBaseComboBox(cbNumberingPlanIdentification, new NumberingPlanIdentificationType(
                NumberingPlanIdentification.ISDNTelephoneNumberingPlan.getCode()));
        M3uaForm.setEnumeratedBaseComboBox(cbSmsCodingType, new SmsCodingType(SmsCodingType.VAL_GSM7));

        M3uaForm.setEnumeratedBaseComboBox(cbSRIReaction, new SRIReaction(SRIReaction.VAL_RETURN_SUCCESS));
        M3uaForm.setEnumeratedBaseComboBox(cbSRIInformServiceCenter, new SRIInformServiceCenter(SRIInformServiceCenter.MWD_NO));
        M3uaForm.setEnumeratedBaseComboBox(cbMtFSMReaction, new MtFSMReaction(MtFSMReaction.VAL_RETURN_SUCCESS));
        M3uaForm.setEnumeratedBaseComboBox(cbRsmdsReaction, new ReportSMDeliveryStatusReaction(
                ReportSMDeliveryStatusReaction.VAL_RETURN_SUCCESS));

        tbServiceCenterAddress.setText("");
        tbSRIResponseImsi.setText("");
        tbSRIResponseVlr.setText("");

        tbSmscSsn.setText("8");
        tbNationalLanguageCode.setText("0");

        cbSRIScAddressNotIncluded.setSelected(false);
        cbOneNotificationFor100Dialogs.setSelected(false);
        cbReturn20PersDeliveryErrors.setSelected(false);
        cbContinueDialog.setSelected(false);
    }

    private void loadDataB() {
        loadDataA();
    }

    private boolean saveData() {
        int smscSsn = 0;
        try {
            smscSsn = Integer.parseInt(tbSmscSsn.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Exception when parsing smscSsn value: " + e.toString());
            return false;
        }
        int nationalLanguageCode = 0;
        try {
            nationalLanguageCode = Integer.parseInt(tbNationalLanguageCode.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Exception when parsing nationalLanguageCode value: " + e.toString());
            return false;
        }

        this.sriForSM.setAddressNature((AddressNatureType) cbAddressNature.getSelectedItem());
        this.sriForSM.setNumberingPlan((NumberingPlanMapType) cbNumberingPlan.getSelectedItem());
        this.sriForSM.setMapProtocolVersion((MapProtocolVersion) cbMapProtocolVersion.getSelectedItem());
        this.sriForSM.setTypeOfNumber((TypeOfNumberType) cbTypeOfNumber.getSelectedItem());
        this.sriForSM.setNumberingPlanIdentification((NumberingPlanIdentificationType) cbNumberingPlanIdentification
                .getSelectedItem());
        this.sriForSM.setSmsCodingType((SmsCodingType) cbSmsCodingType.getSelectedItem());

        this.sriForSM.setSRIReaction((SRIReaction) cbSRIReaction.getSelectedItem());
        this.sriForSM.setSRIInformServiceCenter((SRIInformServiceCenter) cbSRIInformServiceCenter.getSelectedItem());
        this.sriForSM.setMtFSMReaction((MtFSMReaction) cbMtFSMReaction.getSelectedItem());
        this.sriForSM.setReportSMDeliveryStatusReaction((ReportSMDeliveryStatusReaction) cbRsmdsReaction.getSelectedItem());

        this.sriForSM.setServiceCenterAddress(tbServiceCenterAddress.getText());
        this.sriForSM.setSRIResponseImsi(tbSRIResponseImsi.getText());
        this.sriForSM.setSRIResponseVlr(tbSRIResponseVlr.getText());

        this.sriForSM.setSmscSsn(smscSsn);
        this.sriForSM.setNationalLanguageCode(nationalLanguageCode);

        this.sriForSM.setSRIScAddressNotIncluded(cbSRIScAddressNotIncluded.isSelected());
        this.sriForSM.setOneNotificationFor100Dialogs(cbOneNotificationFor100Dialogs.isSelected());
        this.sriForSM.setReturn20PersDeliveryErrors(cbReturn20PersDeliveryErrors.isSelected());
        this.sriForSM.setContinueDialog(cbContinueDialog.isSelected());

        return true;
    }
}
