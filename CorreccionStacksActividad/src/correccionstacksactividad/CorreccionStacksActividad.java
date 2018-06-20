/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correccionstacksactividad;

import java.util.Stack;

/**
 *
 * @author user
 */
public class CorreccionStacksActividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("VALIDAR EXPRESIÓN POST FIJA");
        System.out.println(evaluatePostfixExtended("10 350 + 2 / 5 * 7 +"));
        System.out.println(evaluatePostfixSingle("43-46-+"));
        System.out.println("\nVALIDAR EXPRESIÓN CON PARENTESIS");
        System.out.println("La expresión 6(5)(()(())) es correcta: " + evaluarParentesisExpresion("6(5)(()(()))"));
        System.out.println("La expresión 6(5)(()(()))) es correcta: " + evaluarParentesisExpresion("6(5)(()(())))"));
        System.out.println("La expresión 6(5))()))) es correcta: " + evaluarParentesisExpresion("6(5))())))"));
        System.out.println("La expresión (((((((6(5))()))) es correcta: " + evaluarParentesisExpresion("(((((((6(5))())))"));
    }

    /***
     * Metodo que determinar si una expresión es escrita con el correcto número
     * de () de modo que por cada "(" haya un ")", lo hace por medio de una pila
     * si encuentra un "(", lo ingresa en la pila y si encuentra un ")" hace un pop
     * de la pila
     * @param expresion expresion con "()"
     * @return true o false dependiendo de la expresion
     */
    public static boolean evaluarParentesisExpresion(String expresion) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char current = expresion.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                //Verifica si antes de hacer el pop hay elementos en el stack
                //si no hay significa que ya no alcanzó la igualdad entre el número
                //de "(" y ")"
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * Esta forma soporta el ingreso de expresiones postfijas con numeros de mas
     * de un digito por lo que para diferenciar entre numeros debe haber un
     * espacio entre ellos por ejemplo: 10 350 + 2 / 5 * 7 +
     *
     * @param entrada expresion posfix
     * @return el valor de la expresion
     */
    static int evaluatePostfixExtended(String entrada) {
        //Instanciando Pila
        Stack<Integer> stack = new Stack<>();

        // recorriendo los caracteres en la expresion
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            //Si hay un espacio entre los numeros continua la expresion, se toma el siguiente numero
            if (c == ' ') {
                continue;
            } // si el caracter es un operador se realiza su caso
            // si no se toma el número
            // Push del número en el stack
            else if (Character.isDigit(c)) {
                int n = 0;

                //tomo el caracter y lo guardo
                while (Character.isDigit(c)) {
                    n = n * 10 + (int) (c - '0');
                    i++;
                    c = entrada.charAt(i);
                }
                i--;

                //agrego el numero en el stack
                stack.push(n);
            } // El caracter es un signo, pop dos elementos
            // del stack stack y aplica la operación
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        //Entregando el primer y único elemento la respuesta de la operacion
        return stack.pop();
    }

    static int evaluatePostfixSingle(String entrada) {
        //Creando un stack
        Stack<Integer> stack = new Stack<>();

        // Leer los caracteres
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            // si el caracter es un operador se realiza su caso
            // si no se toma el número
            // Push del número en el stack
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } 
            //  Si hay un operador, tomar dos elementos del stack
            // realizar la operación que simbolice el caracter
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
