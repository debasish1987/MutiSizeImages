package com.deb.poc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{

	EditText mUserId, mPassword;
	Button mSubmit;
	CheckBox mCheckBox;
	private SharedPreferences mStayPreferences;
	Editor mEditor;
	
	@SuppressLint("WorldWriteableFiles")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		mCheckBox = (CheckBox) findViewById(R.id.remember_password);
		mSubmit = (Button) findViewById(R.id.login);
		
		mSubmit.setOnClickListener(this);
		bindAllEditTextIds();

		mStayPreferences = getSharedPreferences("rememberpassword", MODE_WORLD_WRITEABLE);
		mEditor = mStayPreferences.edit();
		
		if (checkStay()) {
			CheckBoxChecked();
		} else {
			mCheckBox.setChecked(checkStay());
		}
		
		mCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mEditor = mStayPreferences.edit();
				mEditor.putBoolean("CheckFlag", isChecked);
				mEditor.commit();
			}

		});

	}

		
	private void CheckBoxChecked() {
		mCheckBox.setChecked(checkStay());
		String userid = mStayPreferences.getString("userid", null);
		String password = mStayPreferences.getString("password", null);
		mUserId.setText(userid);
		mPassword.setText(password);
		mUserId.setSelection(mUserId.getText().length());
		mPassword.setSelection(mPassword.getText().length());
		
	}

	private boolean checkStay() {
		boolean flag = mStayPreferences.getBoolean("CheckFlag", false);
		return flag;
	}

	private void bindAllEditTextIds() {
		mUserId = (EditText) findViewById(R.id.user_id);
		mPassword = (EditText) findViewById(R.id.password);
	}

	private void saveEditTextToPrefecne() {
		SharedPreferences.Editor editor = mStayPreferences.edit();
		editor.putString("userid", mUserId.getText().toString());
		editor.putString("password", mPassword.getText().toString());
		editor.commit();

	}

	private void getCheckBoxFalse() {
		mEditor = mStayPreferences.edit();
		mEditor.putBoolean("CheckFlag", false);
		mEditor.commit();
		mCheckBox.setChecked(false);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.login:

			String userId = mUserId.getText().toString();
			String password = mPassword.getText().toString();


				if (userId.length() > 0 && password.length() > 0) {
					startActivity(new Intent(LoginActivity.this,HomeActivity.class));
					finish();
				} else {
					getCheckBoxFalse();
					Toast.makeText(LoginActivity.this, "Please provide Username and Password", Toast.LENGTH_LONG).show();
				}


			break;

		default:
			break;
		}

	}

	@Override
	protected void onPause() {
		saveEditTextToPrefecne();
		super.onPause();
	}

}
