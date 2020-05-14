package tr.com.deneme.test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import tr.com.deneme.frontend.AnaPencereFE;
import tr.com.deneme.frontend.LoginFE;

public class Run {

	public static void main(String[] args) {
		try {//tema ekler
			for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//new AnaPencereFE();
				new LoginFE();
				
			}
		});
		
	}

}
