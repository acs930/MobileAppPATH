package edu.wit.apppath;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import edu.wit.apppath.R;

public class NFC extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfc);

		NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

		if (nfcAdapter != null && nfcAdapter.isEnabled()) {
			Toast.makeText(this, "NFC available!", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, "NFC not available!", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
