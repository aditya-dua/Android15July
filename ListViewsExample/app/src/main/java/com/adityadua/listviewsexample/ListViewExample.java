package com.adityadua.listviewsexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by AdityaDua on 23/07/17.
 */

public class ListViewExample extends Activity{

    public class codeLearnChapter{
        String chapterName;
        String chapterDescription;
    }

    public class codeLearnAdaptor extends BaseAdapter{

        List<codeLearnChapter> codeLearnChapterList;

        @Override
        public int getCount() {
            return codeLearnChapterList.size();
        }

        @Override
        public Object getItem(int position) {
            return codeLearnChapterList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)
                        ListViewExample.this.getSystemService
                                (Context.LAYOUT_INFLATER_SERVICE);
                // list_item => R.layout & android.R.layout
                // all the views (layout/ different elements in the layout can also be a view)
                // these are in XML.. and them use in your Java file : R.Java
                // and in cases when you want to use the views of Android :: android.R.layout........
                convertView = inflater.inflate(R.layout.list_item,parent,false);
            }


            return null;
        }
    }
}
