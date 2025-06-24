/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_2_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class BAB {
    public static class PuzzleNode implements Comparable<PuzzleNode> {
        int[][] estado;
        int costoReal; // g(n)
        int heuristica; // h(n)
        int filaCero, colCero;
        PuzzleNode padre;

        public PuzzleNode(int[][] estado, int costoReal, PuzzleNode padre) {
            this.estado = copiar(estado);
            this.costoReal = costoReal;
            this.padre = padre;
            this.heuristica = calcularHeuristica(estado);
            localizarCero();
        }

        private void localizarCero() {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (estado[i][j] == 0) {
                        filaCero = i;
                        colCero = j;
                        return;
                    }
        }

        private int[][] copiar(int[][] origen) {
            int[][] copia = new int[3][3];
            for (int i = 0; i < 3; i++)
                copia[i] = origen[i].clone();
            return copia;
        }

        private int calcularHeuristica(int[][] tablero) {
            int h = 0;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (tablero[i][j] != 0) {
                        int val = tablero[i][j] - 1;
                        int filaMeta = val / 3;
                        int colMeta = val % 3;
                        h += Math.abs(i - filaMeta) + Math.abs(j - colMeta); // Manhattan
                    }
            return h;
        }

        public int getCostoTotal() {
            return costoReal + heuristica;
        }

        @Override
        public int compareTo(PuzzleNode otro) {
            return Integer.compare(this.getCostoTotal(), otro.getCostoTotal());
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PuzzleNode)) return false;
            PuzzleNode otro = (PuzzleNode) obj;
            return Arrays.deepEquals(this.estado, otro.estado);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(estado);
        }
    }

    public List<PuzzleNode> resolver(int[][] inicio, int[][] meta) {
        PriorityQueue<PuzzleNode> cola = new PriorityQueue<>();
        Set<PuzzleNode> visitados = new HashSet<>();

        PuzzleNode inicial = new PuzzleNode(inicio, 0, null);
        cola.add(inicial);

        while (!cola.isEmpty()) {
            PuzzleNode actual = cola.poll();

            if (Arrays.deepEquals(actual.estado, meta)) {
                return reconstruirCamino(actual);
            }

            visitados.add(actual);

            for (PuzzleNode hijo : generarHijos(actual)) {
                if (!visitados.contains(hijo)) {
                    cola.add(hijo);
                }
            }
        }

        return null;
    }

    private List<PuzzleNode> generarHijos(PuzzleNode nodo) {
        List<PuzzleNode> hijos = new ArrayList<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; 

        for (int[] d : dir) {
            int nuevaFila = nodo.filaCero + d[0];
            int nuevaCol = nodo.colCero + d[1];

            if (nuevaFila >= 0 && nuevaFila < 3 && nuevaCol >= 0 && nuevaCol < 3) {
                int[][] nuevoEstado = nodo.copiar(nodo.estado);
                nuevoEstado[nodo.filaCero][nodo.colCero] = nuevoEstado[nuevaFila][nuevaCol];
                nuevoEstado[nuevaFila][nuevaCol] = 0;
                hijos.add(new PuzzleNode(nuevoEstado, nodo.costoReal + 1, nodo));
            }
        }
        return hijos;
    }
    
    private List<PuzzleNode> reconstruirCamino(PuzzleNode nodo) {
        List<PuzzleNode> camino = new ArrayList<>();
        while (nodo != null) {
            camino.add(0, nodo); 
            nodo = nodo.padre;
        }
        return camino;
    }
    
    public boolean esSoluble(int[][] estadoInicial, int[][] estadoMeta) {
        int inversionesInicial = contarInversiones(estadoInicial);
        int inversionesMeta = contarInversiones(estadoMeta);
        
        return (inversionesInicial % 2 == inversionesMeta % 2);
    }
    
    private int contarInversiones(int[][] tablero) {
        List<Integer> listaLineal = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != 0) {
                    listaLineal.add(tablero[i][j]);
                }
            }
        }
        
        int inversiones = 0;
        int n = listaLineal.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listaLineal.get(i) > listaLineal.get(j)) {
                    inversiones++;
                }
            }
        }
        return inversiones;
    }

}