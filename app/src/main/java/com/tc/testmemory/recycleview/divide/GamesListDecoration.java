package com.tc.testmemory.recycleview.divide;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <p>首页游戏列表的间距(网格)</p>
 *
 * @author chenyou
 * @version 2.0.1.0 , 2017/3/7
 */

public class GamesListDecoration extends RecyclerView.ItemDecoration {
    private int margintLeft;
    private int marginTop;
    private int marginRight;
    private int marginBottom;

    public GamesListDecoration(int margintLeft, int marginTop, int marginRight, int marginBottom) {
//        marginTop = context.getResources().getDimensionPixelSize(R.dimen.marginTop);
        this.margintLeft = margintLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margintLeft, marginTop, marginRight, marginBottom);

    }
}
