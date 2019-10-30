/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import org.reproductor.Ventana;
import org.util.Filtro;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author Gabriel
 */
public class Reproduccion {
    
    private Ventana ventana;
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private String ficheroVideo;
	
    public ArrayList<String> lista;
    private boolean fin = false;
    private boolean acabar = false;
    
    public void inicializar(Ventana ventana){
		this.ventana = ventana;
		this.mediaPlayer = ventana.mediaPlayer;
	}
    
    public void abrirArchivo(){
            JFileChooser fileChooser = new JFileChooser(new File("Videos"));
            fileChooser.setDialogTitle("Abrir Archivo de Audio o Video");
            fileChooser.setFileView(new FileView(){
                @Override
                public Icon getIcon(File f){
                    return FileSystemView.getFileSystemView().getSystemIcon(f);
                }
            });
		fileChooser.setFileFilter(new Filtro());
                fileChooser.setAcceptAllFileFilterUsed(false);
                JDialog dialogo = new JDialog();
                dialogo.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		if (fileChooser.showOpenDialog(dialogo) == JFileChooser.CANCEL_OPTION)
			return;
		
		ficheroVideo = fileChooser.getSelectedFile().getAbsolutePath();
		
		habilitar();
		reproducir(ficheroVideo);
	}
    
    public void habilitar(){
		
		ventana.btAdelantar.setEnabled(true);
		ventana.btPause.setEnabled(true);
		ventana.btPlay.setEnabled(false);
		ventana.btRetrasar.setEnabled(true);
		ventana.btStop.setEnabled(true);
		
		ventana.slTiempo.setEnabled(true);
		ventana.slVolumen.setEnabled(true);
		
		
	}
    public void reproducir(String fichero){
		
		try {
                    try (PrintWriter reciente = new PrintWriter (new BufferedWriter(new FileWriter("Reciente", true)))) {
                        reciente.println(fichero);
                    }
		} catch (IOException e1) {}
		
		ventana.frame.setTitle("Zafiro Players - "+new File(fichero).getName());
		mediaPlayer.getMediaPlayer().playMedia(fichero);
		
		ventana.dimension = mediaPlayer.getMediaPlayer().getCropGeometry();
		
		Thread hilo = new Thread(new Runnable(){
			
			@Override
			public void run() {
				while(mediaPlayer.getMediaPlayer().getLength() == 0){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				ventana.slTiempo.setMaximum((int) mediaPlayer.getMediaPlayer().getLength());
				
				while(mediaPlayer.getMediaPlayer().getTime() < mediaPlayer.getMediaPlayer().getLength()){
					if(ventana.tiempo == true){
						try {
							Thread.sleep(500);
							
							ventana.slTiempo.setValue((int) mediaPlayer.getMediaPlayer().getTime());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				fin = true;
			}
		});
		hilo.start();
	}
}
