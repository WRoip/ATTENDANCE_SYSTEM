package javaxm;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audiotest extends Thread{
	private String filename;
	public Audiotest(String filename){
		this.filename=filename;
	}
	public void run(){
		File sourceFile=new File(filename);
		AudioInputStream audioInputStream=null;
		try{
			audioInputStream=AudioSystem.getAudioInputStream(sourceFile);
		} catch(UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		AudioFormat format=audioInputStream.getFormat();
		SourceDataLine auline=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);
		try{
			auline=(SourceDataLine) AudioSystem.getLine(info);
			auline.open();
		} catch(LineUnavailableException e){
			e.printStackTrace();
		}
		auline.start();
		
		int nBytesRead=0;
		byte[] abData=new byte[2];
		try{
			while(nBytesRead!=-1){
				nBytesRead=audioInputStream.read(abData, 0, abData.length);
				if(nBytesRead>=0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			auline.drain();
			auline.close();
		}
		
	}
}
