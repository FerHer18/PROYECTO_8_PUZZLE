/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_2_0;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MUSICA {
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
    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
