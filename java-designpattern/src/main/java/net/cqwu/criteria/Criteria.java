package net.cqwu.criteria;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
