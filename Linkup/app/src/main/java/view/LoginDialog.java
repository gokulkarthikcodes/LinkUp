package view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

import bean.UserBean;
import service.LinkupApplication;
import set2.linkup.MainActivity;
import set2.linkup.R;
import util.UserUtil;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class LoginDialog extends Dialog {

    private Context context;

    public LoginDialog(Context context){
        super(context, R.style.AppTheme_NoActionBar);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View layout = inflater.inflate(R.layout.dialog_login, null);
        setContentView(layout);

        TextView submit = (TextView) layout.findViewById(R.id.submit);
        TextView register = (TextView) layout.findViewById(R.id.register);

        final MaterialEditText email = (MaterialEditText) layout.findViewById(R.id.email);
        final MaterialEditText name = (MaterialEditText) layout.findViewById(R.id.name);
        final MaterialEditText password = (MaterialEditText) layout.findViewById(R.id.password);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        UserBean bean = new UserBean();
                        bean.setEmail(email.getText().toString());
                        bean.setUsername(name.getText().toString());
                        bean.setPassword(password.getText().toString());
                        UserUtil.saveUserInfo(bean);

                        ((MainActivity)context).setAccount();

                        dismiss();
                    }
                }
        );

        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        UserBean bean = new UserBean();
                        bean.setEmail(email.getText().toString());
                        bean.setUsername(name.getText().toString());
                        bean.setPassword(password.getText().toString());
                        UserUtil.saveUserInfo(bean);

                        ((MainActivity)context).setAccount();

                        dismiss();
                    }
                }
        );
    }
}
