/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_2_0;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
/**
 *
 * @author ferna
 */
public class Musica {
    private Clip clip;
    
    public void reproducir(String rutaInterna) {
        try {
            URL sonidoURL = getClass().getResource(rutaInterna);
            if (sonidoURL == null) {
                System.out.println("Ups, al parecer no hay un archivo de sonido" + rutaInterna);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonidoURL);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Ups, error" + ex.getMessage());
        }
    }
    
    // Esta funcion detiene la musica al momento que se cierra la ventana principal
    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
