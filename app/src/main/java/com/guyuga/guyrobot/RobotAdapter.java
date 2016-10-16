package com.guyuga.guyrobot;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.guyuga.guyrobot.Model.Robot;
import com.guyuga.guyrobot.ViewModel.RobotViewModel;
import com.guyuga.guyrobot.databinding.RobotCardBinding;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by guy on 13/10/2016.
 * RecycleView adapter to bind Robot to card view
 */

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.BindingHolder> {

    private List<Robot> robotList;
    private Context mContext;

    public RobotAdapter(Context context) {

        mContext = context;
        robotList = new ArrayList<>();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RobotCardBinding robotBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                        R.layout.robot_card,
                        parent,
                        false);
        return new BindingHolder(robotBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        RobotCardBinding robotBinding = holder.binding;
        robotBinding.setViewModel(new RobotViewModel(mContext, robotList.get(position)));
    }

    @Override
    public int getItemCount() {
        return robotList.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private RobotCardBinding binding;

        public BindingHolder(RobotCardBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }

    public void setItems(List<Robot> robotList){
        this.robotList = robotList;
        notifyDataSetChanged();
    }
}
