/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4Examen2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author user
 */
public class Ejercicio5 {
    
    public static void main(String[] args){
        
    }
    
/*Un buscador Web proporciona sugerencias de búsqueda mientras se escribe una consulta, basándose
en las consultas más frecuentes que han hecho distintos usuarios en el pasado.
Implemente el método estático sugerenciasTop que recibe como parámetros una cadena de texto escrita
por un usuario y el historial de consultas previas. El método sugerenciasTop debe retornar una lista
(ordenada por frecuencia descendente) de las consultas compatibles con el texto ingresado por el
usuario.
Por ejemplo, si el texto ingresado por el usuario es texto1 y el historial de consulta es historial1​, el
buscador sugiere consultas como las mostradas en la siguiente imagen:
*/
 
    public static List<String> sugerenciasTop(String consulta, String historial){
        List<String> retorno = new LinkedList();
        String[] hist = historial.split(",");
        PriorityQueue<Consulta> cola = new PriorityQueue<>((Consulta c1, Consulta c2)->
                                        c2.getNum_busquedas()-c1.getNum_busquedas());
        for(String st: hist){
            if(st.startsWith(consulta)){
                Consulta c = new Consulta(consulta);
                for (Consulta i : cola) {
                    if(c.equals(i))
                        i.setNum_busquedas(i.getNum_busquedas()+1);
                }
                if(!cola.contains(c))
                    cola.offer(c);
            }
        }
        cola.forEach((ci) -> {
            retorno.add(ci.getConsult());
        });
        
        return retorno;
    }
    
}
