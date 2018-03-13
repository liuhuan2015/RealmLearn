package com.liuh.realmlearn;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Date: 2018/3/13 14:12
 * Description:
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
