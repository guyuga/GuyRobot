package com.guyuga.guyrobot.ViewModel;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.guyuga.guyrobot.Model.Robot;
import com.guyuga.guyrobot.R;
import com.squareup.picasso.Picasso;

/**
 * Created by guy on 13/10/2016.
 * the RobotViewModel is the ViewModel that connects the Robot model and the view
 * the class is extending from BaseObservable using Data Binding to link data to the views
 */

public class RobotViewModel extends BaseObservable {

    private Context mContext;
    private Robot mRobot;

    public RobotViewModel(Context context, Robot robot) {
        mContext = context;
        mRobot = robot;
    }

    public String getRobotName(){
        return mRobot.getName();
    }

    public String getRobotDescription(){
        return mRobot.getDescription();
    }

    public int getStrength(){
        return mRobot.getStrength();
    }

    public int getDurability(){
        return mRobot.getDurability();
    }

    public int getManeuverability(){
        return mRobot.getManeuverability();
    }

    public int getWeapon_slots(){
        return mRobot.getWeapon_slots();
    }

    public int getCustomisation(){
        return mRobot.getCustomisation();
    }

    public String getImageUrl(){
        return  mRobot.getImage_url();
    }

    //on imageUrl request load image using picasso
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher)
                .into(view);
    }

    public String getStrengthTitle(){
        return mContext.getString(R.string.strength);
    }
    public String getDurabilityTitle(){
        return mContext.getString(R.string.durability);
    }
    public String getManeuverabilityTitle(){
        return mContext.getString(R.string.maneuverability);
    }
    public String getWeaponSlotsTitle(){
        return mContext.getString(R.string.weapon_slots);
    }
    public String getCustomisationTitle(){
        return mContext.getString(R.string.customisation);
    }

    public int getStrengthProgress(){
        return getProgressFromRobotChar(mRobot.getStrength());
    }

    public int getDurabilityProgress(){
        return getProgressFromRobotChar(mRobot.getDurability());
    }

    public int getManeuverabilityProgress(){
        return getProgressFromRobotChar(mRobot.getManeuverability());
    }

    public int getWeapon_slotsProgress(){
        return getProgressFromRobotChar(mRobot.getWeapon_slots());
    }

    public int getCustomisationProgress(){
        return getProgressFromRobotChar(mRobot.getCustomisation());
    }

    private int getProgressFromRobotChar(int Char){
        return (Char * 10);
    }

    // on progress change - start progress animation to transition the progress from 0 to [progress] with a delay
    @BindingAdapter({"android:progress"})
    public static void animateProgress(ProgressBar seekbar, int progress) {
        ObjectAnimator animation = ObjectAnimator.ofInt(seekbar, "progress", 0, progress);
        animation.setDuration(500); // 0.5 second
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }
}
