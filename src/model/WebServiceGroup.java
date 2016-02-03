/**
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Pei
 *
 * Andrew ID : lip
 */
public class WebServiceGroup {

    List<WebService> group = new ArrayList<>();

    public List<WebService> getServiceGroup() {
        return this.group;
    }

    public void setServiceGroup(List<WebService> group) {
        this.group = group;
    }

}
