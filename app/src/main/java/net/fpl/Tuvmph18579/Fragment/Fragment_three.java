package net.fpl.Tuvmph18579.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.fpl.Tuvmph18579.PH18579_LoginActivity;
import net.fpl.Tuvmph18579.R;


public class Fragment_three extends Fragment {
    Button start;
    public Fragment_three(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_three,container,false);
        start = view.findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PH18579_LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}