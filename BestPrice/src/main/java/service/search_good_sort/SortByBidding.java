package service.search_good_sort;

import vo.GoodVO;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/**
 * Created by Administrator on 2017/4/9.
 */
public class SortByBidding implements SortStrategy{

    public void sort(List<GoodVO> goodVOList) {

        Collections.sort(goodVOList, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((GoodVO)o2).getCompetePrice().compareTo(((GoodVO)o1).getCompetePrice());
            }
        });

    }
}
