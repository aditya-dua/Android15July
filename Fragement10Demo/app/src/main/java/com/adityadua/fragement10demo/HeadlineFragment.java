package com.adityadua.fragement10demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 19/08/17.
 */

public class HeadlineFragment extends ListFragment {

    onHeadlineSelectedListener mCallback;

    public interface onHeadlineSelectedListener{

        public void onArticleSelected(int position);
    }

    // The first Lifecycle method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getActivity(), "HeadlineFragment + onCreate ", Toast.LENGTH_SHORT).show();

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headline));
    }
// I will intizile the Interface Object


    // once the activity is attached
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Toast.makeText(getActivity(), "HeadlineFragment + onAttach ", Toast.LENGTH_SHORT).show();

        try {
            mCallback = (onHeadlineSelectedListener) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "HeadlineFragment + onStart ", Toast.LENGTH_SHORT).show();

        if(getFragmentManager().findFragmentById(R.id.headline_fragment)!=null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }
    // I had created an Object of the onHeadlineSelectedListener, now I will set the onclick


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(), "HeadlineFragment + View Clicked ", Toast.LENGTH_SHORT).show();

        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position,true);
    }
}
