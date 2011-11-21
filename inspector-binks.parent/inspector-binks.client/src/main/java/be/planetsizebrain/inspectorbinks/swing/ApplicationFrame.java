package be.planetsizebrain.inspectorbinks.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import be.planetsizebrain.inspectorbinks.InspectorBinks;

import com.explodingpixels.macwidgets.BottomBar;
import com.explodingpixels.macwidgets.BottomBarSize;
import com.explodingpixels.macwidgets.MacWidgetFactory;

public class ApplicationFrame extends JFrame {
	
	private static final Dimension FRAME_SIZE = new Dimension(800, 600);
	
	private FileListing listing = new FileListing(this);
	
	public ApplicationFrame() {
		setTitle(InspectorBinks.NAME);
		setSize(FRAME_SIZE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		getRootPane().setOpaque(false);
		getRootPane().setBackground(Color.WHITE);
		getRootPane().putClientProperty("apple.awt.brushMetalLook", Boolean.TRUE);
			
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new ApplicationToolbar(), BorderLayout.NORTH);
//		contentPane.add(new DropPanel(), BorderLayout.CENTER);
		contentPane.add(listing, BorderLayout.CENTER);
		
		BottomBar bottomBar = new BottomBar(BottomBarSize.LARGE);
		bottomBar.addComponentToCenter(MacWidgetFactory.createEmphasizedLabel("No archive opened yet."));
		contentPane.add(bottomBar.getComponent(), BorderLayout.SOUTH);
	}
}