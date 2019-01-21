package game;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Window {
	public static JFrame frame = new JFrame("Tohou?");
	public Window(Game game) {
		

		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final GraphicsConfiguration display = ge.getDefaultScreenDevice().getDefaultConfiguration();
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Insets insets = toolkit.getScreenInsets(display);
		final Rectangle bounds = display.getBounds();
		final int wVisual = bounds.width - insets.left - insets.right;
		final int hVisual = bounds.height - insets.top - insets.bottom;
		frame.setPreferredSize(new Dimension(wVisual - 250, hVisual - 100));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.pack();
		frame.setResizable(false);
		frame.setLocation(bounds.x + insets.left + (wVisual - frame.getWidth()) / 2,
				bounds.y + insets.top + (hVisual - frame.getHeight()) / 2);
		frame.setVisible(true);
		frame.add(game);
		game.start();

		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit this game?", "Exit",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					frame.dispose();
					System.exit(0);
				}
			}
		});


		
	}
}