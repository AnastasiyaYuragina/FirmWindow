package lesson6.newFirm;

import java.awt.EventQueue;

public class Main {

	public MainFrame frame;
	public static boolean arg = false;

	public static void main(String[] args) {
		if (args.equals("/l"))
			arg = true;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
