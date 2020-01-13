package com.example.defnot.quiztest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.defnot.quiztest.Adapter.CategoryAdapter;
import com.example.defnot.quiztest.Common.Common;
import com.example.defnot.quiztest.Common.SpaceDecoration;
import com.example.defnot.quiztest.DBHelper.DBHelper;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recycler_category;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.category_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_settings)
        {
            showSettings();
        }
        return true;
    }

    private void showSettings() {
        View setting_layout = LayoutInflater.from(this)
                .inflate(R.layout.settings_layout,null);
        final CheckBox ckb_online_mode = (CheckBox)setting_layout.findViewById(R.id.ckb_online_mode);
        // load data from paper if not available just init false
        ckb_online_mode.setChecked(Paper.book().read(Common.KEY_SAVE_ONLINE_MODE,false));

        //show dialog
        new MaterialStyledDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_settings_white_24dp)
                .setTitle("Settings")
                .setDescription("Please choose action")
                .setCustomView(setting_layout)
                .setNegativeText("DISMISS")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveText("SAVE")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        if (ckb_online_mode.isChecked())
                        {
                            Common.isOnlineMode = true;
                        }else
                        {
                            Common.isOnlineMode = false;
                        }

                        // save
                        Paper.book().write(Common.KEY_SAVE_ONLINE_MODE,ckb_online_mode.isChecked());

                    }
                }).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init paper
        Paper.init(this);

        // get value online mode
        Common.isOnlineMode = Paper.book().read(Common.KEY_SAVE_ONLINE_MODE,false); // default

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("MultiQuizAplication");
        setSupportActionBar(toolbar);

        recycler_category = (RecyclerView)findViewById(R.id.recycler_category);
        recycler_category.setHasFixedSize(true);
        recycler_category.setLayoutManager(new GridLayoutManager(this, 2));


        // Screen height
        CategoryAdapter adapter = new CategoryAdapter(MainActivity.this,DBHelper.getInstance(this).getAllCategories());
        int spaceInPixel = 4;
        recycler_category.addItemDecoration(new SpaceDecoration(spaceInPixel));
        recycler_category.setAdapter(adapter);
    }
}
