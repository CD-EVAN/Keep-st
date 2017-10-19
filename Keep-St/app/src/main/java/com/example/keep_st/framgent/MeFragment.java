package com.example.keep_st.framgent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.keep_st.R;
import com.example.keep_st.util.BroadCastManager;

/**
 * Created by lenovo on 2017/9/20.
 */

public class MeFragment extends android.support.v4.app.Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View meLayout = inflater.inflate(R.layout.me_layout,
                container, false);
        return meLayout;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.signoff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.keep_st.FORCE_OFFLINE");
                BroadCastManager.getInstance().sendBroadCast(getActivity(), intent);
            }
        });
    }
}
