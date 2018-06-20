/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author user
 */
public class Ejercicio4I {
    /*El I.E.S.S ha decidido implementar el servicio de telemedicina en su call 
    center de atención a los afiliados, la finalidad de este servicio es 
    descongestionar la atención de consulta externa en los diferentes hospitales
    del país. Para llevar a cabo este propósito, el I.E.S.S ha decidido incorporar un
    grupo de médicos de Medicina General para que sean parte del grupo de agentes
    que atienden las llamadas en el call center.
    
    Un afiliado tiene un número de cédula, nombres, apellidos y un historial de dolencias.
    Una dolencia tiene un nombre y un grupo de síntomas.
    Un médico tiene un número de cédula, nombres, apellidos y un histórico de afiliados que ha
    atendido.
    El call center atiende las llamadas de los afiliados conforme han sido recibidas por la central
    telefónica. El afiliado es asignado a un médico bajo el criterio del médico que ha atendido menos
    afiliados.
*/
    
    public static void main(String[] args){
        
    }
    
    /*Implementar el procedimiento medicosTratantes ​que recibe una lista de
    médicos y una dolencia y retorna una lista de médicos que han tratado esa dolencia.
    */

    public static LinkedList<Medico> medicosTratantes(LinkedList<Medico> medicos, Dolencias c){
        LinkedList<Medico> retorno = new LinkedList();
        for(Medico me: medicos){
            for(Afiliado af: me.getHist_fili()){
                if(af.getDolor().contains(c))
                    retorno.add(me);
            }
        }
        return retorno;
    }
    
    /*Implementar el procedimiento atenderLlamadas que simula la atención de las
    llamadas de los afiliados en el call center. El procedimiento recibe una lista de médicos y
    una cola que representa las llamadas de los afiliados:*/
    
    public static void atenderLlamadas(LinkedList<Medico> medicos, Queue<Afiliado> llamadas){
        PriorityQueue<Medico> medi = new PriorityQueue<>((Medico m1, Medico m2)->
                                        m1.getHist_fili().size()-m2.getHist_fili().size());
        medi.addAll(medicos);
        
        while(!llamadas.isEmpty()){
            Medico me = medi.poll();
            me.getHist_fili().add(llamadas.poll());
            medi.offer(me);
        }               
    }
}
