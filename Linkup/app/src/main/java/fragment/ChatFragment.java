package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import adapter.ChatRecyclerViewAdapter;
import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import http.Constant;
import http.HttpUtil;
import okhttp3.Headers;
import okhttp3.Response;
import set2.linkup.R;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class ChatFragment extends Fragment {
    private static final String ARG_SECTION = "Chat";

    private RecyclerView recyclerView;
    private ChatRecyclerViewAdapter chatRecyclerViewAdapter;

    public BaseHttpRequestCallback callback = new BaseHttpRequestCallback() {
        @Override
        public void onResponse(Response httpResponse, String response, Headers headers) {
        }
    };

    public static ChatFragment newInstance(){
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString("type", ARG_SECTION);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        chatRecyclerViewAdapter = new ChatRecyclerViewAdapter(getContext());
        recyclerView.setAdapter(chatRecyclerViewAdapter);

        /*
        new HttpUtil(HttpUtil.NON_TOKEN_PARAMS)
                .add("key",HttpUtil.GOOGLE_KEY)
                .add("q","hello")
                .add("source","en")
                .add("target","zh")
                .add("format","text")
                .add("fields","translations")
                .get(Constant.URL_TRANSLATE,callback);
         */

        return rootView;
    }
}
