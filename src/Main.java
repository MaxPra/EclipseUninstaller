import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static DeleteDialog delDia;
	public static long datSize = 0;
	public static void main(String[] args) {
		
		String instPath = "";
		
		setLookAndFeel();
		int result = JOptionPane.showConfirmDialog(null, "Do you want to delete Eclipse IDE?", "EclipseUninstaller", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			delDia = new DeleteDialog();
			boolean check = uninstallEclipse();
			if(!check) {
				JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
				System.exit(0);
			}
		}else {
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "Finished successfully!\nSize of deleted files: " + datSize + " KB");
		
	}
	
	public static void setLookAndFeel() {
		try {
            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	}
	
	public static boolean uninstallEclipse() {
		String instPath = "";
		File dotEclipseFolder = new File(System.getProperty("user.home") + File.separator + ".eclipse");
		File eclipseProgramFolder = new File(System.getProperty("user.home") + File.separator + "eclipse");
		if(dotEclipseFolder.exists()) {
			try {
				delDia.setVisible(true);
				delete(dotEclipseFolder);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if(eclipseProgramFolder.exists()) {
			try {
				delDia.setVisible(true);
				delete(eclipseProgramFolder);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void delete(File file)
	    	throws IOException{
	 
	    	if(file.isDirectory()){
	 
	    		//directory is empty, then delete it
	    		if(file.list().length == 0){
	    			
	    		   file.delete();
	    		   delDia.informationArea.append("Deleted: " + file.getAbsolutePath() + "\n");
	    		   delDia.informationArea.setCaretPosition(delDia.informationArea.getText().length());
	    			
	    		}else{
	    			
	    		   //list all the directory contents
	        	   String files[] = file.list();
	     
	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);
	        		 
	        	      //recursive delete
	        	     delete(fileDelete);
	        	   }
	        		
	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length == 0){
	           	     file.delete();
	           	     delDia.informationArea.append("Deleted: " + file.getAbsolutePath() + "\n");
	           	     delDia.informationArea.setCaretPosition(delDia.informationArea.getText().length());
	        	   }
	    		}
	    		
	    	}else{
	    		//if file, then delete it
	    		datSize += (long)(file.length() / 1024); //In KB umrechnen
	    		file.delete();
	    		delDia.informationArea.append("Deleted: " + file.getAbsolutePath() + "\n");
	    		delDia.informationArea.setCaretPosition(delDia.informationArea.getText().length());
	    	}
	    }
}
