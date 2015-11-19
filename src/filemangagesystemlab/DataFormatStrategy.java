/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemangagesystemlab;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Matthew_2
 */
public interface DataFormatStrategy {
    public abstract String encode();
    public abstract List<Map<String,String>> decode(String data);
}
