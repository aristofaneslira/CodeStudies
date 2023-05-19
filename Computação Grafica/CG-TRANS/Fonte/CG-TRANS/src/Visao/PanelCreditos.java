package Visao;

import java.awt.Dimension;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
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
@SuppressWarnings("serial")
public class PanelCreditos extends javax.swing.JPanel {
	private JPanel jPanelLogo;
	private JPanel jPanelCreditos;
	private JLabel jLabelAutor2;
	private JLabel jLabelUepb;
	private JLabel jLabelAutor3;
	private JLabel jLabelAutor1;
	private JLabel jLabelLogo;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelCreditos());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public PanelCreditos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(880, 610));
			this.setLayout(null);
			this.setBackground(new java.awt.Color(255,255,255));
			{
				jPanelLogo = new JPanel();
				this.add(jPanelLogo);
				jPanelLogo.setBounds(117, 90, 651, 210);
				jPanelLogo.setLayout(null);
				jPanelLogo.setBackground(new java.awt.Color(255,255,255));
				{
					jLabelLogo = new JLabel(new ImageIcon("img//logoProcessamento.png"));
					jPanelLogo.add(jLabelLogo);
					jLabelLogo.setBounds(5, 0, 634, 210);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
