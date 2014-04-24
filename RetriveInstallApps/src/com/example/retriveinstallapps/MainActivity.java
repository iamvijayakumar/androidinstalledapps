package com.example.retriveinstallapps;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.PackageInfo;

import android.os.Bundle;
import android.util.Log;

import android.widget.GridView;


public class MainActivity extends Activity {

	ArrayList<AppStructure> appStructurelist = new ArrayList<AppStructure>();

	AppStructure appStructure;
	GridView gridView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myactivity);
		gridView = (GridView) findViewById(R.id.gridView1);
		List<PackageInfo> pakageInstall = getPackageManager()
				.getInstalledPackages(0);
		for (int i = 0; i < pakageInstall.size(); i++) {
			PackageInfo packInfo = pakageInstall.get(i);
			appStructure = new AppStructure();
			appStructure.appName = packInfo.applicationInfo.loadLabel(getPackageManager()).toString();
			appStructure.appIcons = packInfo.applicationInfo.loadIcon(getPackageManager());
			appStructurelist.add(appStructure);
			Log.e("error", "" + appStructure.appName);
			InstalledAppAdapter adapter = new InstalledAppAdapter(this,
					appStructurelist);

			gridView.setAdapter(adapter);

		}
	}
}
