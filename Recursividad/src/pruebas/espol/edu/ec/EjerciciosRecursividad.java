/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.espol.edu.ec;

/**
 *
 * @author user
 */
public class EjerciciosRecursividad {
    
    //Ejericicio 1
    public static double dividirRecursivo(double dividendo, double divisor){
        if(dividendo==0)
            return 0;
        if(divisor==0)
            throw new ArithmeticException("No se puede dividir por cero");
        if(divisor>dividendo)
            return 0;
        return EjerciciosRecursividad.dividirRecursivo(dividendo-divisor, divisor)+1;
    }
    
    //Ejercicio 2
    public static int divisibilidad(int div, int divisor){
        if(divisor==0)
            return -1;
        if(div<divisor||div==0)
            return 0;
        if(div%divisor!=0)
            return 0;
        return 1+divisibilidad(div/divisor,divisor);
    }
    
    //Ejercicio 3
    
    public boolean esPrimo(int numero){
        if(numero == 0||numero==1)
            return false;
        return esPrimo(numero,2);        
    }
    
    private boolean esPrimo(int numero, int divisor){
        if(numero%divisor==0)
            return false;
        if(numero/2<divisor)
            return true;
        return esPrimo(numero,divisor+1);
    }
    
    //Ejercicio 4
    
    public int sumaMatriz(int mat[][]){
        int fila = mat.length;
        int columna = mat[0].length;
        if(columna==0&&fila==0)
            return 0;
        else return sumaMatriz(mat,fila,columna);
    }
    
    private int sumaMatriz(int mat[][], int fila, int col){
        
        if (col == 0)
            return sumaMatriz(mat, fila - 1, col);
        if(col==0&&fila==0)
            return mat[fila][col];
        return mat [fila] [col] + sumaMatriz(mat, fila, col - 1);
    }
}
