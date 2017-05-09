package com.tc.testmemory;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.tc.testmemory.effectivejava.TestPerson;
import com.tc.testmemory.recycleview.BaseRecyclerViewAdapter;
import com.tc.testmemory.recycleview.BaseRecyclerViewHolder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private TestAdapter mTestAdapter;
    private List<UpdatesListBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshLayout);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTestAdapter = new TestAdapter(this);
        mRecyclerView.setAdapter(mTestAdapter);

        mRefreshLayout.setOnRefreshListener(mOnRefreshListener);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorAccent);

        initData();
        Log.e(TAG, "onCreate: "+ ("S".equals("S")) );
    }

    private void initData() {
        String jsonString = "{\"data\":[{\"icon\":\"static/images/game/2048Icon.png\",\"game_name\":\"2048 Fight\",\"verison\":\"1.1.8\",\"game_id\":1005,\"download\":\"static/files/2048_Fight_1.1.8.apk\",\"packName\":\"com.miracle.f2048\"},{\"icon\":\"static/images/game/Overtakeicon.png\",\"game_name\":\"Pixel Overtake\",\"verison\":\"1.1.1\",\"game_id\":1001,\"download\":\"static/files/PixelOvertake_1.1.1.apk\",\"packName\":\"com.AiPu.runcar\"},{\"icon\":\"static/images/game/CrossEyedMonkeysIcon.png\",\"game_name\":\"Cross-Eyed Monkeys\",\"verison\":\"1.1\",\"game_id\":1003,\"download\":\"static/files/CEMonkey_20170118.apk\",\"packName\":\"com.BrownieIS.ceMonkey\"}]}";
        Gson gson = new Gson();
        UpdatesListBean updatesListBean = gson.fromJson(jsonString, UpdatesListBean.class);
        data = updatesListBean.getData();
        mTestAdapter.updateForNew(updatesListBean.getData());

        TestPerson testPerson = new TestPerson.Builder().setAge(11).setName("dkl").setSex("男").build();
        Log.e(TAG, "initData: "+testPerson.toString() );
    }

    /**
     * 下拉刷新事件
     */
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mTestAdapter.updateForNew(data);
            mRefreshLayout.setRefreshing(false);
        }
    };

    public class TestAdapter<T> extends BaseRecyclerViewAdapter<UpdatesListBean.DataBean, BaseRecyclerViewHolder>{


        /**
         * @param context
         */
        public TestAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseRecyclerViewHolder baseRecyclerViewHolder, int position, UpdatesListBean.DataBean item) {

        }

        @Override
        public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            BaseRecyclerViewHolder holder = new BaseRecyclerViewHolder(inflateItemView(parent, R.layout.item_test_recyclerview));

            return holder;
        }
    }

}
