package ara.kuet.musta;

import android.content.Context;
import android.os.Bundle;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kuet.musta.R;

public class MainActivity extends FragmentActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private MyAdapter myAdapter;
	//private String[] mDrawerItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initializer();
		mTitle = mDrawerTitle = getTitle();
		

		// Set the OnItemClickListener so something happens when a 
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				R.drawable.ic_drawer, 
				R.string.drawer_open, 
				R.string.drawer_close
				) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
			
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};
		
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// Set the default content area to item 0
		// when the app opens for the first time
		if(savedInstanceState == null) {
			navigateTo(1);
		}
	
	}

	public void initializer(){
		//mDrawerItems = getResources().getStringArray(R.array.drawer_titles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		// set a custom shadow that overlays the main content when the drawer opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);
		// Add items to the ListView
		//mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItems));
		myAdapter = new MyAdapter(this);
		mDrawerList.setAdapter(myAdapter);
	}


	
	/*
	 * If you do not have any menus, you still need this function
	 * in order to open or close the NavigationDrawer when the user 
	 * clicking the ActionBar app icon.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	/*
	 * When using the ActionBarDrawerToggle, you must call it during onPostCreate()
	 * and onConfigurationChanged()
	 */
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Log.v(TAG, "ponies");
			navigateTo(position);
		}
	}
	
	private void navigateTo(int position) {
		Log.v(TAG, "List View Item: " + position);
		
		switch(position) {
		case 0:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame,
									QiblaDirection.newInstance(),
									QiblaDirection.TAG)
                    .commit();

			break;
		case 1:

			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame,
									TabbedActivity.newInstance(),
									TabbedActivity.TAG).commit();


			break;
		case 2:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame,
									NextTo.newInstance(),
									NextTo.TAG).commit();
		case 3:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame,
									AboutUs.newInstances(),
									AboutUs.TAG).commit();
		

		}
		mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	
}
class MyAdapter extends BaseAdapter{
	private Context context;
	String[] mDrawerItems;
	int[] images = { R.drawable.ic_compass, R.drawable.ic_silencer, R.drawable.ic_next, R.drawable.ic_about};
	public MyAdapter(Context context){
		this.context = context;
		mDrawerItems = context.getResources().getStringArray(R.array.drawer_titles);
	}

	@Override
	public int getCount() {
		return mDrawerItems.length;
	}

	@Override
	public Object getItem(int position) {
		return mDrawerItems[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row;
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.custom_row, parent, false);
		}
		else {
			row = convertView;
		}
		TextView titleTextView = (TextView) row.findViewById(R.id.textView1);
		ImageView titleImageView = (ImageView) row.findViewById(R.id.imageView1);
		titleTextView.setText(mDrawerItems[position]);
		titleImageView.setImageResource(images[position]);
		return row;
	}
}
