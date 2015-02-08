package ara.kuet.musta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuet.musta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextTo extends Fragment {

	public final static String TAG = NextTo.class.getSimpleName();

	public static NextTo newInstance(){
		return new NextTo();
	}

	public NextTo() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_next, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView textView = (TextView) view.findViewById(R.id.textNext);
		textView.setText("Upcoming Features!");
	}
}
