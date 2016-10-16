package com.guyuga.guyrobot.View;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guyuga.guyrobot.Model.Robot;
import com.guyuga.guyrobot.RobotAdapter;
import com.guyuga.guyrobot.databinding.RobotsListFragmentBinding;
import com.orm.query.Select;
import java.util.List;

/**
 * Created by guy on 12/10/2016.
 */

public class RobotListFragment extends Fragment {

    private RobotsListFragmentBinding binding;


    public static RobotListFragment newInstance(){
        return new RobotListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = RobotsListFragmentBinding.inflate(inflater,container,false);
        setupRecyclerView();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.recycleView;
        List<Robot> robotList = getRobotListFromDb();
        RobotAdapter robotAdapter = new RobotAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(false);
        robotAdapter.setItems(robotList);
        recyclerView.setAdapter(robotAdapter);
    }

    private List<Robot> getRobotListFromDb() {
        return Select.from(Robot.class).list();
    }

}
