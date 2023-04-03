package com.bumbumapps.videoeditor.listmusicandmymusic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumbumapps.videoeditor.Helper;
import com.bumbumapps.videoeditor.R;
import com.bumbumapps.videoeditor.StartActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ListMusicAndMyMusicActivity extends AppCompatActivity {
    static final boolean a = true;
    private TabLayout b;
    private ViewPager c;
    private int[] d = {R.mipmap.icon_music, R.mipmap.icon_music};

    class a extends FragmentPagerAdapter {
        private final List<Fragment> b = new ArrayList();
        private final List<String> c = new ArrayList();

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return (Fragment) this.b.get(i);
        }

        public int getCount() {
            return this.b.size();
        }

        public void a(Fragment fragment, String str) {
            this.b.add(fragment);
            this.c.add(str);
        }

        public CharSequence getPageTitle(int i) {
            return (CharSequence) this.c.get(i);
        }
    }

    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView( R.layout.liststatusactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (Helper.ModuleId == 18) {
            textView.setText("Audio Compressor");
        } else if (Helper.ModuleId == 19) {
            textView.setText("Audio Joiner");
        } else if (Helper.ModuleId == 20) {
            textView.setText("Audio Cutter");
        }
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (a || supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(a);
            supportActionBar.setDisplayShowTitleEnabled(false);
            this.c = (ViewPager) findViewById(R.id.viewpager);
            a(this.c);
            this.b = (TabLayout) findViewById(R.id.tabs);


            this.b.setupWithViewPager(this.c);
            a();
            return;
        }
        throw new AssertionError();
    }

    private void a() {
        this.b.getTabAt(0).setIcon(this.d[0]);
        this.b.getTabAt(1).setIcon(this.d[1]);
    }

    private void a(ViewPager viewPager) {
        a aVar = new a(getSupportFragmentManager());
        aVar.a(new SelectMusicFragment(), "LIST MUSIC");
        aVar.a(new MyMusicFragment(), "MY ALBUM");
        viewPager.setAdapter(aVar);
    }

    @SuppressLint("WrongConstant")
    @Override public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return a;
    }

   @Override public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return a;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting()) {
            return false;
        }
        return a;
    }
}
