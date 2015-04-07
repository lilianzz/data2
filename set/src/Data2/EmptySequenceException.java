/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data2;

/**
 *
 * @author 栗粒盐
 */
public class EmptySequenceException extends RuntimeException {
    String s;
    public EmptySequenceException(String message) {
	this.s = message;    }
    public String toString() {
	return s;
    }
} 