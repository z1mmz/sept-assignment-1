package com.sept01.view.listener;

import java.awt.Point;	
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import com.sept01.main.*;
import com.sept01.view.MainView;

public class MainViewWindowListener implements WindowListener {

	public MainViewWindowListener(MainView mainView) {
		// TODO Auto-generated constructor stub
	new ReadFavourites();
	new ReadScreenLoc();
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
	
	Point loc =arg0.getWindow().getLocationOnScreen();	
	new SaveScreenLocation(loc);	
	System.out.println("----Displays all the favouriates present in the system---------");
	Singleton.getInstance().getApplication().testFav();	
	new SaveFavourite();
		
	
			
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("When is this");
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

}
