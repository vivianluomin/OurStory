package com.example.asus1.ourstory.Listeners;

import android.support.design.widget.AppBarLayout;

/**
 * Created by asus1 on 2018/4/4.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    public enum State{
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentSate = State.IDLE;

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        if(verticalOffset == 0){
            if((mCurrentSate != State.EXPANDED)){
                onStateChange(appBarLayout,State.EXPANDED);
            }
            mCurrentSate = State.EXPANDED;
        }else if(Math.abs(verticalOffset)>= appBarLayout.getTotalScrollRange()){

            if(mCurrentSate != State.COLLAPSED){
                onStateChange(appBarLayout,State.COLLAPSED);
            }

            mCurrentSate = State.COLLAPSED;
        }else {
            if(mCurrentSate != State.IDLE){
                onStateChange(appBarLayout,State.IDLE);
            }

            mCurrentSate = State.IDLE;
        }

    }

    public abstract void onStateChange(AppBarLayout appBarLayout,State state);
}
