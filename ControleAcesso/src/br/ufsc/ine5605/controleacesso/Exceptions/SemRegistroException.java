/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.controleacesso.Exceptions;

/**
 *
 * @author caiocaio
 */
public class SemRegistroException extends Exception {
    public SemRegistroException(){
        this("Sem registro de acesso");
    }
    
    public SemRegistroException(String message){
        super(message);
    }
}
