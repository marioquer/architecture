package service.search_good_sort;

import vo.GoodVO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ldchao on 2017/4/13.
 */
public class SortByPrice implements SortStrategy{
    public void sort(List<GoodVO> goodVOList) {
        Collections.sort(goodVOList, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((GoodVO)o1).getPrice().compareTo(((GoodVO)o2).getPrice());
            }
        });
    }
}
