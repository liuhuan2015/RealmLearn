package com.liuh.realmlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * 大多数情况下,Realm的增删改查操作足够快,可以在UI线程执行操作.但是如果遇到较为复杂的增删改查,或者增删改查操作的数据较多时,可以在子线程中进行操作
 * 即异步的增删改查
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_select_result)
    TextView tvSelectResult;

    RealmResults<TimeInfo> beans;//查询结果

    Realm mRealm = Realm.getDefaultInstance();

    private String showStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_add, R.id.tv_delete, R.id.tv_alter, R.id.tv_select})
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                mRealm.beginTransaction();
                TimeInfo timeInfo = mRealm.createObject(TimeInfo.class, System.currentTimeMillis() + "");
                timeInfo.setTitle("realm" + System.currentTimeMillis());
                mRealm.commitTransaction();

                //使用事物块进行增加
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                    }
                });

                break;
            case R.id.tv_delete:
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        beans.deleteFirstFromRealm();
                    }
                });


                break;
            case R.id.tv_alter:

                TimeInfo info = mRealm.where(TimeInfo.class).equalTo("title", "realm1520924205117").findFirst();
                mRealm.beginTransaction();
                info.setTitle("修改一下,改成齐天大圣");
                mRealm.commitTransaction();
                break;
            case R.id.tv_select:
                beans = mRealm.where(TimeInfo.class).findAll();
                if (beans != null) {
                    showStr = "";
                    tvSelectResult.setText(showStr);
                    for (int i = 0; i < beans.size(); i++) {
                        Log.e("---------", "beans.get(" + i + ").getTitle() : " + beans.get(i).getTitle());
                        showStr = showStr + beans.get(i).getTitle() + "\n";

                    }
                    tvSelectResult.setText(showStr);
                }
                break;

        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭Realm,防止内存泄漏
        if (mRealm != null) {
            mRealm.close();
        }

    }
}
