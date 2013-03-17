package user47.encryption;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Handler implements ActionListener
{
	
	FileOutputStream fos = null;
	FileInputStream fis = null;
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Decryption"))
			decryption(e);
		else
			encryption(e);
					
	}
	public void decryption(ActionEvent e)
	{
		File objFile = new File("D:\\Ag\\EncryptedFile.txt");
		byte [] arrData = new byte[(int)objFile.length()];
		Button btn = (Button)e.getSource();
		MainApplet aplt = (MainApplet)btn.getParent();
		String sstr = null;
		if(!objFile.exists())
		{
			System.out.println("Such file is not exist");
			return;
		}
		
		try
		{
			fis = new FileInputStream(objFile);
			
			fis.read(arrData);
			System.out.println(new String(arrData));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		char [] chrArr = new String(arrData).toCharArray();
		for(int iTmp = 0 ; iTmp < (new String(arrData)).length(); iTmp++)
		{
			int tmp = (int)chrArr[iTmp];
			tmp -= 10;
			chrArr[iTmp] = (char)tmp;
		}
		
		sstr = String.copyValueOf(chrArr);
		System.out.print(sstr);
		aplt.objTextArea.setText(sstr);
		
	}
	public void encryption(ActionEvent e)
	{
		Button btn = (Button)e.getSource();
		MainApplet aplt = (MainApplet)btn.getParent();
		
		String fileData;
		
		String data = aplt.objTextArea.getText();
		char [] chrArr = data.toCharArray();			
		
		for(int iTmp = 0; iTmp < data.length(); iTmp++)
		{
			int tmp = (int)chrArr[iTmp];
			tmp += 10;
			chrArr[iTmp] = (char)tmp;
		}
		
		fileData = String.copyValueOf(chrArr);
		System.out.println(fileData);				
		
		try
		{
			File objFile = new File("D:\\AG\\EncryptedFile.txt");
			
			if(!objFile.exists())
			{
				System.out.print("no such file is exist");
				objFile.createNewFile();
			}
			
			fos = new FileOutputStream(objFile);
			fos.write(fileData.getBytes());
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}		
	}
}
