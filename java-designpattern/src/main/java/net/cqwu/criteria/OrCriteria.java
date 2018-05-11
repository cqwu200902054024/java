package net.cqwu.criteria;

import java.util.List;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.criteria
 *
 * @author： Administrator
 * Create Date：  2018-05-11
 * Modified By：   Administrator
 * Modified Date:  2018-05-11
 * Why & What is modified
 * Version:        V1.0
 */
public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> ps = this.criteria.meetCriteria(persons);
        ps.addAll(this.otherCriteria.meetCriteria(persons));
        return ps;
    }
}
