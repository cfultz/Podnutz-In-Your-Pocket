package info.sipnet.podnutzinyourpocket;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import info.sipnet.podnutzinyourpocket.Shows.AndroidAppAddicts;
import info.sipnet.podnutzinyourpocket.Shows.BookNutz;
import info.sipnet.podnutzinyourpocket.Shows.DDG;
import info.sipnet.podnutzinyourpocket.Shows.Geeksters;
import info.sipnet.podnutzinyourpocket.Shows.LFTROU;
import info.sipnet.podnutzinyourpocket.Shows.MHDD;
import info.sipnet.podnutzinyourpocket.Shows.MRPTech;
import info.sipnet.podnutzinyourpocket.Shows.MiniPC;
import info.sipnet.podnutzinyourpocket.Shows.PodnutzDaily;
import info.sipnet.podnutzinyourpocket.Shows.PodnutzFeed;
import info.sipnet.podnutzinyourpocket.Shows.PodnutzPro;
import info.sipnet.podnutzinyourpocket.Shows.Sportsnutz;
import info.sipnet.podnutzinyourpocket.Shows.TheMakerz;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new RssFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_rss) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new RssFragment()).commit();
        } else if (id == R.id.nav_androidappaddicts) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AndroidAppAddicts()).commit();
        } else if (id == R.id.nav_booknutz) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new BookNutz()).commit();
        } else if (id == R.id.nav_computerrepair) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new PodnutzFeed()).commit();
        } else if (id == R.id.nav_ddg) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new DDG()).commit();
        } else if (id == R.id.nav_geeksters) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Geeksters()).commit();
        } else if (id == R.id.nav_linux) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new LFTROU()).commit();
        } else if (id == R.id.nav_makers) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new TheMakerz()).commit();
        } else if (id == R.id.nav_minipc) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new MiniPC()).commit();
        } else if (id == R.id.nav_mrp) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new MRPTech()).commit();
        } else if (id == R.id.nav_podnutzpro) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new PodnutzPro()).commit();
        } else if (id == R.id.nav_mhhd) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new MHDD()).commit();
        } else if (id == R.id.nav_daily) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new PodnutzDaily()).commit();
        } else if (id == R.id.nav_sportsnutz) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Sportsnutz()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
