package com.adityadua.fragement10demo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements HeadlineFragment.onHeadlineSelectedListener{

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_article);
        Toast.makeText(this, "MainActivity + onCreate", Toast.LENGTH_SHORT).show();
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }


            HeadlineFragment hdf = new HeadlineFragment();
            Toast.makeText(this, "MainActivity + onCreate + Headline Fragment Object Created ", Toast.LENGTH_SHORT).show();

            hdf.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, hdf).commit();
            Toast.makeText(this, "MainActivity + onCreate + Added to View and onCreate Ends ", Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    public void onArticleSelected(int position) {

        Toast.makeText(this, "MainActivity + onArticleSelected "+position, Toast.LENGTH_SHORT).show();

        ArticleFragment articleFragment = (ArticleFragment)getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if(articleFragment !=null){
            articleFragment.updateArticleView(position);
        }else{
            ArticleFragment newFragment = new ArticleFragment();

            Toast.makeText(this, "MainActivity + Article Fragment Object Created "+position, Toast.LENGTH_SHORT).show();

            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION,position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
