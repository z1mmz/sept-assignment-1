package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sept01.controller.CityClickListener;
import com.sept01.main.Favourites;
import com.sept01.main.Singleton;
import com.sept01.view.MainView;

public class EastPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel TextPanel = new JPanel();
	private ArrayList<Favourites> favAdded = new ArrayList<Favourites>();
	private JPanel favAreas = new JPanel();
	private Border blackline;

	public EastPanel(MainView mainView) {
		blackline = BorderFactory.createLineBorder(Color.black);
		// Adding Registering information
		this.setLayout(new BorderLayout());
		// JPanel infoPanel = new JPanel();
		// this.add(infoPanel, BorderLayout.NORTH);

		TextPanel.setLayout(new BoxLayout(TextPanel, BoxLayout.Y_AXIS));
		JLabel fav = new JLabel("Favourites", JLabel.RIGHT);
		fav.setBorder(blackline);
		TextPanel.add(fav);
		TextPanel.setBorder(blackline);
		this.add(TextPanel, BorderLayout.NORTH);

		// Set border to a textPanel
		TextPanel.setBorder(blackline);
		setBackground(Color.DARK_GRAY);
		// Set layout of favorite
		favAreas.setLayout(new BoxLayout(favAreas, BoxLayout.Y_AXIS));
		addFavourites();
	}

	public void addFavourites() {
 System.out.println("Does it come here");
		for (int i = 0; i < Singleton.getInstance().getApplication().getFav().size(); i++) {		
				
			if(checkifFavExists(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()) == false)	
			{	
				JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new GridLayout(1,1));
			JButton weather_station = new JButton(
					Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
			Singleton.getInstance().getApplication().getFav().get(i).getStation().getData();
			weather_station.addActionListener(new CityClickListener(Singleton.getInstance().getApplication().getFav().get(i).getStation().getStateAbv().toLowerCase(),Singleton.getInstance().getApplication().getFav().get(i).getStation()));
			 System.out.println(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
			 buttonPanel.add(weather_station);
			favAreas.add(buttonPanel);
			favAdded.add(Singleton.getInstance().getApplication().getFav().get(i));
			}
		}
		TextPanel.add(favAreas);
	}

 
	// public void addFavoriates() {
	//
	// System.out.println("Size of favouriates " +
	// Singleton.getInstance().getFav().size());
	//
	// for (int i = 0; i < Singleton.getInstance().getFav().size(); i++) {
	//
	//// if
	// (checkifFavExists(Singleton.getInstance().getFav().get(i).getArea().getName())
	// == false) {
	//// JButton areas = new
	// JButton(Singleton.getInstance().getFav().get(i).getArea().getName());
	//// System.out
	//// .println("This is the area name" +
	// Singleton.getInstance().getFav().get(i).getArea().getName());
	//// favAreas.add(areas);
	//// favAdded.add(Singleton.getInstance().getFav().get(i));
	//// }
	// }
	// TextPanel.add(favAreas);
	// }

	 public boolean checkifFavExists(String area) {
	
	 for (int i = 0; i < favAdded.size(); i++) {
	 if (favAdded.get(i).getStation().getName() == area) {
	 return true;
	 }
	 }
	 return false;
	 }

}
