package javaxm;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Muise {
	/*@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException{
		try{
			AudioClip ac=Applet.newAudioClip((new File("E:\\javaxm\\jpg\\林俊杰+-+可惜没如果.wav")).toURL());
			ac.loop();
		} catch(MalformedURLException e){
			e.printStackTrace();
		}
		//new Login();
		//new j2();
		//Thread.sleep(5000);
	}*/
	/*@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException,FileNotFoundException,InterruptedException{
		File file=new File("E:\\javaxm\\jpg\\林俊杰+-+可惜没如果.wav");
		AudioClip audioClip=null;
		audioClip=Applet.newAudioClip(file.toURL()); 
		audioClip.loop();
		Thread.sleep(5000);
		//new j2();
	}*/
	//public static final String muise="E:\\javaxm\\jpg\\林俊杰+-+可惜没如果.wav";
	public static final String muise="E:\\javaxm\\jpg\\Hans+Zimmer+-+Time+-+纯音乐.wav";
	//public static final String muise="D:\\360安全浏览器下载\\M11-01-05-19.mp3";
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{	
		AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(muise));
		AudioFormat audioFormat=audioInputStream.getFormat();
		DataLine.Info dataLineInfo=new DataLine.Info(SourceDataLine.class, audioFormat,AudioSystem.NOT_SPECIFIED);
		SourceDataLine sourceDataLine=(SourceDataLine)AudioSystem.getLine(dataLineInfo);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start();
		new j2();
		int count;
		byte tempBuffer[]=new byte[1024];
		while((count=audioInputStream.read(tempBuffer,0,tempBuffer.length))!=-1){
			if(count>0){
				sourceDataLine.write(tempBuffer, 0, count);
			}
		}
		//sourceDataLine.drain();
		//sourceDataLine.close();
	}
}

