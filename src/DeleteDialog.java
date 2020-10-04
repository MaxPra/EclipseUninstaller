import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DeleteDialog extends JDialog{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	public JScrollPane sPane;
	public JTextArea informationArea;
	
	int x = (int)(width - 400) / 2;
	int y = (int)(height - 400) / 2;
	
	public DeleteDialog() {
		this.setTitle("EclipseUninstaller - Uninstalling...");
		this.setSize(new Dimension(850, 400));
		this.setResizable(false);
		this.setLocation(x, y);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		informationArea = new JTextArea();
		informationArea.setFont(new Font("Arial", Font.PLAIN, 11));
		
		sPane = new JScrollPane();      
		sPane.setBorder(BorderFactory.createTitledBorder("Uninstall-Log"));
		sPane.setViewportView(informationArea);
		this.add(sPane, BorderLayout.CENTER);
	}
}
