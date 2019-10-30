/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reproductor;

import java.awt.EventQueue;
import javax.swing.JFrame;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import org.base.Reproduccion;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.awt.Toolkit;


/**
 *
 * @author Gabriel
 */
public class Ventana implements FullScreenStrategy{
    
        public JFrame frame;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAbrirCds;
	private JMenuItem mntmTamano;
	private JMenuItem mntmSubtitulos;
	private JMenuItem mntmListaDeReproduccion;
	private JMenuItem mntmRecientes;
	private JMenuItem mntmCaptura;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem mntmPantallaCompleta;
	private JMenuItem mntmPredeterminada;
	
	public JButton btRetrasar;
	public JButton btPlay;
	public JButton btPause;
	public JButton btStop;
	public JButton btAdelantar;
	public JSlider slVolumen;
	public JSlider slTiempo;
        
	private static String ruta_libreria; //= "C:\\Program Files (x86)\\VideoLAN\\VLC";
	
	public EmbeddedMediaPlayerComponent mediaPlayer;
	private JLabel lbVolumen;
	public boolean tiempo = true;
	public String dimension;
	public Reproduccion reproduccion;
	private ListaReproduccion listaReproduccion;
	private Recientes reciente;
	private JPanel panel;
	private JMenuItem mntmAbrirStriming;
	private JMenuItem mntmRetornarPantalla;
	private FullScreenStrategy fullScreenStrategy;
    

    @Override
    public void enterFullScreenMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitFullScreenMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFullScreenMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
