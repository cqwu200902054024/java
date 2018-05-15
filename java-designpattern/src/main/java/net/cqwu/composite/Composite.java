package net.cqwu.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.composite
 *
 * @author： Administrator
 * Create Date：  2018-05-14
 * Modified By：   Administrator
 * Modified Date:  2018-05-14
 * Why & What is modified
 * Version:        V1.0
 */
public class Composite extends Component {
    private List<Component> compositeList = new ArrayList<>();

    @Override
    public void add(Component c) {
        this.compositeList.add(c);
    }

    @Override
    public void remove(Component c) {
        this.compositeList.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return this.compositeList.get(i);
    }

    @Override
    public void operation() {
          for(Component component : compositeList) {
              component.operation();
          }
    }
}
