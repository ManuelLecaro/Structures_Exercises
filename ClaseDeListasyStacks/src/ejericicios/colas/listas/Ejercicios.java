/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejericicios.colas.listas;

import espol.edu.ec.interfaces.Queue;
import espol.edu.ec.tdas.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author user
 */
public class Ejercicios {
    
    /*La arquitectura de pila es un tipo de arquitectura del procesador que no 
almacena operandos dentro del CPU, sino en una pila dentro de memoria. 
En esta arquitectura, existen dos instrucciones para operadores de pila: 
PUSH y POP. Además, las operaciones aritméticas (ADD, SUB, MUL, DIV) se realizan
con los 2 elementos en el tope de la pila.

Asumiendo que se tiene la clase Instrucción que contiene los atributos tipo y 
variable, donde tipo indica el nombre de instrucción a realizar 
("PUSH", "POP", "ADD", "SUB", "MUL", "DIV") y variable representa el nombre de 
la variable con la que se requiere realizar una operación. Se dispone de un mapa
variables, que indica la dirección de memoria que representa cada variable. 

Implemente el método maquinaDePila que procesa una cola de instrucciones, además,
recibe el mapa de variables y un arraylist con las direcciones de memoria 
(índice del arraylist) y sus valores (datos del arraylist).*/

    public void maquinaDePila(Queue<Instruccion> cola, Map<String,Integer> variables, ArrayList<Integer> memoria){
        
        Stack<Integer> pila = new Stack();
        while(!cola.isEmpty()){
            Instruccion in = cola.poll();
            String tipo = in.getTipo();
            if(tipo.equals("PUSH")){
                
        }if(tipo.equals("POP")){
                
        }if(tipo.equals("ADD")){
                
        }if(tipo.equals("SUB")){
                
        }if(tipo.equals("PUSH")){
                
        }
        
            
        
    }
    
    
    
}

    class Instruccion{
        private String tipo;
        private String variable;
        
        public Instruccion(){
            
        }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
        
        
    }
    }
