package com.yxxx.onlyone;

import java.util.Comparator;

/**
 * Created by yns on 2018/3/3.
 */

public class MyListComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        ScoresList e1=(ScoresList)o1;
        ScoresList e2=(ScoresList)o2;
//        if(e1.getSumscores()>e2.getSumscores())
//            return 1;
//        else
//            return 0;
        return (e2.getSumscores()-e1.getSumscores());

    }
}
