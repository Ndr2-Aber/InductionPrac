package util;

import java.util.Observer;

import javax.swing.JFrame;

public abstract class View extends JFrame implements Observer {
	protected void registerWithModel(Model model) {
		model.addObserver(this);
	}

}
