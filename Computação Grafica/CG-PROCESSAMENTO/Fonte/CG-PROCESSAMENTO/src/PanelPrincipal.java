

import java.awt.Dimension;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PanelPrincipal extends javax.swing.JPanel {
	private JLabel jLabelLogo;
	private JPanel jPanelCreditos;
	private JLabel jLabelAutor2;
	private JLabel jLabelUepb;
	private JLabel jLabelAutor6;
	private JLabel jLabelAutor5;
	private JLabel jLabelAutor4;
	private JLabel jLabelAutor3;
	private JLabel jLabelAutor1;

	public PanelPrincipal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(600, 400));
			this.setBackground(new java.awt.Color(255,255,255));
			this.setLayout(null);
			{
				jLabelLogo = new JLabel(new ImageIcon("img//logoProcessamento.png"));
				this.add(jLabelLogo);
				jLabelLogo.setBounds(236, 63, 500, 214);
				jLabelLogo.setEnabled(true);
				jLabelLogo.setBorder(new LineBorder(new java.awt.Color(205,205,205), 1, false));
				jLabelLogo.setBackground(new java.awt.Color(218,215,207));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
