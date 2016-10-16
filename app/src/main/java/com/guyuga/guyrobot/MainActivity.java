package com.guyuga.guyrobot;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guyuga.guyrobot.Model.Robot;
import com.guyuga.guyrobot.View.RobotListFragment;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Save all Robots to the DB
        SugarContext.init(this);
        createDbElements();
        // get view (Fragment)
        RobotListFragment robotListFragment = (RobotListFragment) getFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (robotListFragment == null){
            robotListFragment = RobotListFragment.newInstance();
            addFragmentToActivity(getFragmentManager(),robotListFragment, R.id.contentFrame);
        }

    }

    @Override
    protected void onDestroy() {
        // close DB access
        SugarContext.terminate();
        super.onDestroy();
    }

    /**
     * adds fragment to Activity
     * @param fragmentManager the fragment manager
     * @param fragment the fragment to be added
     * @param frameId the fragment container
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    /**
     * saves all data to the Data base. simulates getting data from external source
     */
    private void createDbElements(){
        List<Robot> robotList = new ArrayList<>();
        robotList.add(new Robot("Destrier",
                getResources().getString(R.string.DestrierDescription),
                getResources().getString(R.string.DestrierImageUrl), 2, 4, 6, 3, 1)
        );
        robotList.add(new Robot("Gepard",
                getResources().getString(R.string.GepardDescription),
                getResources().getString(R.string.GepardImageUrl), 2, 3, 6, 7, 1)
        );
        robotList.add(new Robot("Cossack",
                getResources().getString(R.string.CossackDescription),
                getResources().getString(R.string.CossackImageUrl), 1, 7, 6, 3, 7)
        );
        robotList.add(new Robot("Stalker",
                getResources().getString(R.string.StalkerDescription),
                getResources().getString(R.string.StalkerImageUrl), 2, 3, 7, 2, 7)
        );
        robotList.add(new Robot("Rogatka",
                getResources().getString(R.string.RogatkaDescription),
                getResources().getString(R.string.RogatkaImageUrl), 4, 4, 8, 3, 7)
        );
        robotList.add(new Robot("Vityaz",
                getResources().getString(R.string.VityazDescription),
                getResources().getString(R.string.VityazImageUrl), 7, 9, 6, 10, 1)
        );
        robotList.add(new Robot("Boa",
                getResources().getString(R.string.BoaDescription),
                getResources().getString(R.string.BoaImageUrl), 8, 4, 6, 3, 9)
        );
        robotList.add(new Robot("Galahad",
                getResources().getString(R.string.GalahadDescription),
                getResources().getString(R.string.GalahadImageUrl), 5, 6, 6, 8, 7)
        );
        robotList.add(new Robot("Fury",
                getResources().getString(R.string.FuryDescription),
                getResources().getString(R.string.FuryImageUrl), 9, 4, 10, 3, 6)
        );
        robotList.add(new Robot("Griffin",
                getResources().getString(R.string.GriffinDescription),
                getResources().getString(R.string.GriffinImageUrl), 5, 7, 6, 3, 10)
        );
        robotList.add(new Robot("Natasha",
                getResources().getString(R.string.NatashaDescription),
                getResources().getString(R.string.NatashaImageUrl), 7, 8, 6, 5, 8)
        );
        robotList.add(new Robot("Lancelot",
                getResources().getString(R.string.LancelotDescription),
                getResources().getString(R.string.LancelotImageUrl), 10, 9, 7, 8, 10)
        );

        SugarRecord.deleteAll(Robot.class);
        SugarRecord.saveInTx(robotList);
    }
}
