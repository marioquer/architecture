package service.search_good_sort;

import vo.GoodVO;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface SortStrategy {

    public void sort(List<GoodVO> goodVOList);

}
