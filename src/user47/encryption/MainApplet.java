package user47.encryption;

import java.applet.Applet;
import java.awt.Button;
import java.awt.LayoutManager;
import java.awt.TextArea;


public class MainApplet extends Applet
{
	TextArea objTextArea = null;
	Button []objButtons = new Button[2];
	public MainApplet()
	{
		setLayout(null);
		
		objTextArea = new TextArea();
		add(objTextArea);
		objTextArea.setBounds(40, 40, 200, 100);
		
		String [] btnNames = {"Encryption", "Decryption"};
		for(int iTmp = 0, xPos = 40; iTmp < 2; iTmp++, xPos += 100)
		{
			objButtons[iTmp] = new Button(btnNames[iTmp]);
			add(objButtons[iTmp]);
			objButtons[iTmp].setBounds(xPos, 180, 80, 30);
			objButtons[iTmp].addActionListener(new Handler());
		}
	}
}
