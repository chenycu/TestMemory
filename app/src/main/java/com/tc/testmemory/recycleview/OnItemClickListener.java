package com.tc.testmemory.recycleview;


import android.view.View;

/**
 * Created by chenyou on 2016/1/5 0005.
 */
public interface OnItemClickListener<T> {
    void onClick(View view, int position, T item);
}
