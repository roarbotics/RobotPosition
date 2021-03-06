package roarbotics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

public class Field extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 379092475697268476L;
	Image field;
	Toolkit t;

	AffineTransform a;

	boolean isRed = false;

	/**
	 * The Field class shows a scaled image of the 2019 game field which is rotated
	 * depending on which alliance you are on, so that the robot always starts at
	 * the bottom.
	 */
	public Field() {
		setSize(500, 700);
		t = Toolkit.getDefaultToolkit();
		field = t.getImage("src/img/2019-field.png");
		field = field.getScaledInstance(500, 700, Image.SCALE_SMOOTH);
		a = AffineTransform.getRotateInstance(Math.toRadians(180), 250, 350);
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;

		AffineTransform back = g2.getTransform();
		if (RobotPosition.getAlliance().getBoolean(isRed)) { // See if we are on the red alliance.
			g2.setTransform(a);
		}
		g2.drawImage(field, 0, 0, this);
		g2.setTransform(back);

	}

}
