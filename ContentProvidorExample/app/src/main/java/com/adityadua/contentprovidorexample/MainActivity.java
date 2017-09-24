package com.adityadua.contentprovidorexample;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    SimpleCursorAdapter mAdaptor;
    MatrixCursor mMatrixCursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMatrixCursor = new MatrixCursor(new String[]{
                "_id","name","photo","details"
        });

        mAdaptor = new SimpleCursorAdapter(getBaseContext(),R.layout.row_layout,null,new String[]{"name","photo","details"},new int[]{R.id.tv_name,R.id.iv_photo,R.id.tv_details});

        ListView lstContacts = (ListView)findViewById(R.id.lst_contacts);

        lstContacts.setAdapter(mAdaptor);

        ListViewContactsLoader listViewContactsLoader = new ListViewContactsLoader();
        listViewContactsLoader.execute();




    }

    public class ListViewContactsLoader extends AsyncTask<Void,Void,Cursor>{

        @Override
        protected Cursor doInBackground(Void... params) {
            Uri contactUri  = ContactsContract.Contacts.CONTENT_URI;

            Cursor contactsCursor = getContentResolver().query(contactUri,null,null,null,ContactsContract.Contacts.DISPLAY_NAME+" ASC ");

            if(contactsCursor.moveToFirst()){

                do{
                    long ContactId = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID"));

                    Uri dataUri = ContactsContract.Data.CONTENT_URI;

                    Cursor dataCursor = getContentResolver().query(dataUri,null,ContactsContract.Data.CONTACT_ID+" = "+ContactId,null,null);

                    String displayName="";
                    String nickName="";
                    String homePhone="";
                    String mobilePhone="";
                    String workPhone="";
                    String photoPath="";
                    byte [] photobyte=null;
                    String homeEmail="";
                    String workEmail="";
                    String companyName="";
                    String title="";

                    if(dataCursor.moveToFirst()){
                        displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));

                        do{
                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE)){
                                nickName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                            }

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)){
                                switch (dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_HOME :
                                        homePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                            break;
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_WORK :
                                        workPhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE :
                                        workPhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;
                                }
                            }

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)){
                                switch (dataCursor.getInt(dataCursor.getColumnIndex("data2"))){
                                    case ContactsContract.CommonDataKinds.Email.TYPE_HOME :
                                        homeEmail = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;
                                    case ContactsContract.CommonDataKinds.Email.TYPE_WORK :
                                        workEmail = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                        break;

                                }
                            }

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)){
                                companyName = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                title = dataCursor.getString(dataCursor.getColumnIndex("data4"));

                            }

                            if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE)){

                                photobyte = dataCursor.getBlob(dataCursor.getColumnIndex("data15"));

                                if(photobyte != null){
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(photobyte,0,photobyte.length);
                                    File cacheDirectory = getBaseContext().getCacheDir();

                                    File tmpFile = new File(cacheDirectory.getPath()+"/wpta_"+ContactId+".png");

                                    try{
                                        FileOutputStream fileOutputStream = new FileOutputStream(tmpFile);

                                        bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    photoPath = tmpFile.getPath();

                                }
                                }
                            }while (dataCursor.moveToNext());

                            String details = "";
                            if(homePhone !=null && !homePhone.equals("")){
                                details = "HomePhone :"+homePhone+"\n";
                            }
                            if(workPhone !=null && !workPhone.equals("")){
                                details = "WorkPhone :"+workPhone+"\n";
                            }

                        if(mobilePhone !=null && !mobilePhone.equals("")){
                            details = "MobilePhone :"+mobilePhone+"\n";
                        }

                        if(nickName !=null && !nickName.equals("")){
                            details = "Nick Name :"+nickName+"\n";
                        }
                        if(homeEmail !=null && !homeEmail.equals("")){
                            details = "HomeEmail :"+homeEmail+"\n";
                        }
                        if(workEmail !=null && !workEmail.equals("")){
                            details = "WorkEmail :"+workEmail+"\n";
                        }
                        if(companyName !=null && !companyName.equals("")){
                            details = "Company :"+companyName+"\n";
                        }
                        if(title !=null && !title.equals("")){
                            details = "Title :"+title+"\n";
                        }

                        mMatrixCursor.addRow(new Object[]{
                                Long.toString(ContactId),displayName,photoPath,details});



                    }



                }while(contactsCursor.moveToNext());

            }


            return mMatrixCursor;
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            mAdaptor.swapCursor(cursor);
        }
    }

}
