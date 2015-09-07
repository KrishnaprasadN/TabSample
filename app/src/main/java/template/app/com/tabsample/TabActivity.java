package template.app.com.tabsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.viewpagerindicator.TitlePageIndicator;

public class TabActivity extends AppCompatActivity  {

    private ViewPager mViewPager;
    private FragmentStatePagerAdapter mAdapter;
    private TitlePageIndicator mTitlePageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        initViews();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new PageAdapter(getSupportFragmentManager());

        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.tab_strip);
        tabStrip.setTextColor(R.color.material_blue_grey_800);
        tabStrip.setDrawFullUnderline(true);

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class PageAdapter extends FragmentStatePagerAdapter /*implements IconPagerAdapter*/ {

        private String[] mTitles = {"One", "Two"};
        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentOne();
            } else if (position == 1) {
                return new FragmentTwo();
            }

            return null;
        }

/*        @Override
        public int getIconResId(int i) {
            return 0;
        }*/

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
