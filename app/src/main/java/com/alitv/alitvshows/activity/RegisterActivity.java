package com.alitv.alitvshows.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alitv.alitvshows.R;
import com.alitv.alitvshows.model.LoginResponseModel;
import com.alitv.alitvshows.model.RegisterResponseModel;
import com.alitv.alitvshows.retrofit.RetrofitInstance;
import com.alitv.alitvshows.retrofit.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.Html.fromHtml;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_name_reg;
    private EditText et_email_reg;
    private EditText et_password_reg;
    private EditText et_address_reg;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name_reg = findViewById(R.id.et_name_reg);
        et_email_reg = findViewById(R.id.et_email_reg);
        et_password_reg = findViewById(R.id.et_password_reg);
        et_address_reg = findViewById(R.id.et_address_reg);
        btn_register = findViewById(R.id.btn_register);

        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        TextView tvRegister = findViewById(R.id.tv_back_login);
        tvRegister.setText(fromHtml("Back to " + "</font><font color='#3b5998'>Login</font>"));

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name_reg.getText().toString();
                String email = et_email_reg.getText().toString();
                String password = et_password_reg.getText().toString();
                String address = et_address_reg.getText().toString();

                Call<RegisterResponseModel> call = userService.register(name, email, password, address);
                call.enqueue(new Callback<RegisterResponseModel>() {
                    @Override
                    public void onResponse(Call<RegisterResponseModel> call, Response<RegisterResponseModel> response) {
                        RegisterResponseModel registerResponseModel = response.body();
                        if (registerResponseModel.getStatus().equals("success")) {
                            Toast.makeText(RegisterActivity.this, "Success Register" + name, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Failed to register", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponseModel> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Failed Register " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }


}