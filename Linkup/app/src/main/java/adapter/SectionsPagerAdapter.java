package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import fragment.ChatFragment;
import fragment.FriendsFragment;
import fragment.TranslateFragment;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<Fragment>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(ChatFragment.newInstance());
        fragments.add(FriendsFragment.newInstance());
        fragments.add(TranslateFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getArguments().get("type").toString();
    }
}
