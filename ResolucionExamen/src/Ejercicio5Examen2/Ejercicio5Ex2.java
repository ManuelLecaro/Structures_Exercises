/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5Examen2;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author user
 */
public class Ejercicio5Ex2 {

    /*Se ha decidido emprender un plan de mejoras para el actual sistema de consejerías. Las
    consejerías consisten en asignar a un estudiante un profesor consejero para que lo pueda guiar mientras
    realiza sus estudios en la institución. Actualmente, esta asignación es de forma aleatoria, sin embargo se
    desea aplicar una nueva metodología basada en el promedio de los estudiantes.
    Existen dos tipos de profesores, a tiempo completo y medio tiempo, donde los profesores a
    medio tiempo se les asigna hasta un máximo de 5 estudiantes a aconsejar mientras que para los de
    tiempo completo no hay límite (sin embargo, se desea que cada profesor tenga casi el mismo número de
    aconsejados).

    La nueva metodología consiste en asignar equitativamente la cantidad de estudiantes de acuerdo al
    promedio, es decir, que no solo un profesor tenga estudiantes con promedios altos sino que tenga desde
    promedios altos hasta bajos. Primero se comienza tomando los estudiantes con promedios altos, y así
    sucesivamente hasta llegar a los de promedio más bajo, y a medida que se va tomando cada estudiante
    se le asigna un profesor, si un profesor a medio tiempo ya tiene 5 estudiantes ya no se le podrá asignar
    más estudiantes.
     */
    
    /**
     * Implemente un método que permita realizar la asignación anteriormente descrita de estudiantes
    a consejeros. Para la cual usted recibiría una lista ordenada por promedio (de mayor a
    menor) con todos los estudiantes y una cola con todos los profesores (tiempo completo y medio
    tiempo). Al final, el método retorna una lista de profesores que deberán tener asignado los
    estudiantes correspondientes.

     * @param est
     * @param prof
     * @return 
     */
    public List<Profesores> asignarEstudantes(LinkedList<Estudiantes> est, Queue<Profesores> prof){
        List<Profesores> retorno = new LinkedList();
        
        for(Estudiantes st:est){
            Profesores pr = prof.poll();
            if(pr instanceof ProfesoresParcial){
                if(((ProfesoresParcial) pr).getAc().size()<5){
                    ((ProfesoresParcial) pr).getAc().add(st);
                }
                if(((ProfesoresParcial) pr).getAc().size()==5)
                    retorno.add(pr);
                else{
                    prof.offer(pr);
                }
            if(pr instanceof ProfesoresCompleto){
                ((ProfesoresCompleto) pr).getAc().add(st);
                prof.offer(pr);
            }
                    
            }
        }
        retorno.addAll(prof);
        return retorno;
    }
    
    /*Existe un escenario en el cual si un profesor deja de trabajar en ESPOL, sus aconsejados deben
    ser reasignados a otros profesores. Se le solicita que implemente un método que reciba una lista
    de estudiantes de un ex-profesor y una lista de profesores a tiempo completo, y se asigne a cada
    estudiante un profesor consejero en base al número de aconsejados que tiene a su cargo, se le
    asigna al profesor que tenga menos aconsejados. Para este método no importa el promedio del
    estudiante.*/
    public static void asignacionExtra(LinkedList<Estudiantes> est, LinkedList<ProfesoresCompleto> prof){
        PriorityQueue<ProfesoresCompleto> qprof= new PriorityQueue<>((ProfesoresCompleto p1, ProfesoresCompleto p2)->
                                                (p1.getAc().size()-p2.getAc().size()));
        
        for(Estudiantes es:est){
            ProfesoresCompleto p = qprof.poll();
            p.getAc().add(es);
            qprof.offer(p);
        }
    }
    
}
