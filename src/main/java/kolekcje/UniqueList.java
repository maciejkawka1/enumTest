package kolekcje;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueList<T> {


    private List<T> list;

    public UniqueList(List<T> list) {
        this.list = list;
    }

    public List<T> getUniqueList(){
        Set<T> set = new HashSet<>(this.list);
        return set.stream().toList();
    }



}
