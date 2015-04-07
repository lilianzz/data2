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
public interface Sequenced<T extends Comparable<T>> {
    public Sequence seq();
}
