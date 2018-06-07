package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import set2.linkup.R;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class TranslateFragment extends Fragment {
    private static final String ARG_SECTION = "Translate";

    public static TranslateFragment newInstance(){
        TranslateFragment fragment = new TranslateFragment();
        Bundle args = new Bundle();
        args.putString("type", ARG_SECTION);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_translate, container, false);

        return rootView;
    }
}
