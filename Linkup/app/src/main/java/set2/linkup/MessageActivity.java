package set2.linkup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import adapter.MessageRecyclerViewAdapter;
import bean.MessageBean;

import static set2.linkup.R.id.toolbar;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class MessageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private EditText etReply;
    private ImageView ivReply;

    private List<MessageBean> msgList;
    private MessageRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String uName = getIntent().getStringExtra("uname");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(uName);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        etReply = (EditText) findViewById(R.id.et_reply);
        ivReply = (ImageView) findViewById(R.id.iv_reply);

        msgList = new ArrayList<>();
        adapter = new MessageRecyclerViewAdapter(this,msgList);

        recyclerView.setAdapter(adapter);

        ivReply.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(etReply.getText().length()>0){
                            MessageBean bean = new MessageBean();
                            bean.setPrimary(true);
                            bean.setMessage(etReply.getText().toString());
                            bean.setDateline(System.currentTimeMillis());
                            msgList.add(bean);

                            MessageBean bean2 = new MessageBean();
                            bean2.setPrimary(false);
                            bean2.setMessage("Received your message.");
                            bean2.setDateline(System.currentTimeMillis());
                            msgList.add(bean2);

                            etReply.setText("");

                            adapter.notifyItemRangeInserted(msgList.size(),2);
                            recyclerView.scrollToPosition(recyclerView.getChildCount());
                        }
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
