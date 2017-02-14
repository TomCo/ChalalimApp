package com.themeteam.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themeteam.app.R;
import com.themeteam.app.adapters.ViewCasesAdapter;

public class ViewCasesFragment extends Fragment {

    public static String ADD_CASE_FRGAMENT_TAG = "tag";

    public ViewCasesFragment() {
        // Required empty public constructor
    }

    public static ViewCasesFragment newInstance() {
        ViewCasesFragment fragment = new ViewCasesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_cases, container, false);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.fvcRecycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

        recycler.setAdapter(new ViewCasesAdapter(view.getContext()));

        return view;
    }
}
