package com.adityadua.fragement10demo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by AdityaDua on 19/08/17.
 */

public class ArticleFragment extends Fragment {

    //  int : which store the position
    // need tem : string

    final static  String ARG_POSITION="position";
    int mCurrentPosition = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "ArticleFragment + onCreateView ", Toast.LENGTH_SHORT).show();


        if( savedInstanceState !=null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        return inflater.inflate(R.layout.article_view,container,false);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION,mCurrentPosition);
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "ArticleFragment + onStart ", Toast.LENGTH_SHORT).show();

        Bundle args= getArguments();
        if(args !=null){
            updateArticleView(args.getInt(ARG_POSITION));
        }else if(mCurrentPosition !=-1){
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position){
        TextView tv = (TextView) getActivity().findViewById(R.id.article);
        tv.setText(Ipsum.article[position]);
        mCurrentPosition = position;
    }
}
